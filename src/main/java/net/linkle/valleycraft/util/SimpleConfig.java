package net.linkle.valleycraft.util;

import static net.linkle.valleycraft.Main.LOGGER;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.text.WordUtils;

import net.fabricmc.loader.api.FabricLoader;

/** A simple config file system made by truly AndEditor7. */
@SuppressWarnings("deprecation")
public class SimpleConfig {
    private static final String ERROR = "Error from reading the file config: ";
    
    private final LinkedHashSet<String> set = new LinkedHashSet<>();
    private final LinkedHashMap<String, Config> map = new LinkedHashMap<>();
    private final File file;
    private Config lastConfig;

    /** Create and read the config file. */
    public SimpleConfig(String name, int version) {
        var path = FabricLoader.getInstance().getConfigDir();
        file = path.resolve(name + ".properties").toFile();

        try {
            readFile();
        } catch (Exception e) {
            LOGGER.warn(ERROR + file.getName());
            map.clear();
        }

        var config = get("version");
        var lastVer = NumberUtils.toInt(config.value, Integer.MAX_VALUE);
        if (version > lastVer) {
            // Handle version here.
        }
        config.value = Integer.toString(version);
        config.script = "Version handler. It's best to not modify this value.";
    }

    private void readFile() throws Exception {
        Scanner reader = null;

        file.getParentFile().mkdirs();
        if (!file.exists()) {
            Files.createFile(file.toPath());
            return;
        }

        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                var entry = reader.nextLine();
                if (entry.isBlank() || entry.startsWith("#")) {
                    continue;
                }

                var parts = StringUtils.split(entry, '=');
                if (parts.length == 2) {
                    map.put(parts[0], new Config(parts[0], parts[1]));
                } else {
                    throw new Exception();
                }
            }
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private static final String LINES = "\n\n\n";

    /** Flush the current changes and save as a file. */
    public void flush() {
        // Clear unused values.
        var temp = new LinkedHashMap<String, Config>(Math.max(map.size()<<1, 64));
        temp.putAll(map);
        map.clear();

        for (String key : set) {
            map.put(key, temp.get(key));
        }

        PrintWriter printer = null;
        try {
            printer = new PrintWriter(file, "UTF-8");
            var printLine = false;
            for (var config : map.values()) {
                if (config.value == null)
                    continue;

                if (printLine) {
                    printer.write(LINES);
                }

                printLine = true;
                if (StringUtils.isNotBlank(config.script)) {
                    var warp = WordUtils.wrap(config.script, 80, "\u0000", false);
                    var lines = StringUtils.split(warp, '\u0000');

                    for (String line : lines) {
                        printer.write("# " + line + '\n');
                    }
                }

                printer.write(config.key + '=' + config.value);
            }
        } catch (Exception e) {
            LOGGER.warn(ERROR + file.getName());
        } finally {
            if (printer != null)
                printer.close();
        }
    }

    private Config get(String key) {
        set.add(key);
        var config = map.get(key);
        if (config == null) {
            config = new Config(key);
            map.put(key, config);
        }
        return config;
    }

    /** An integer getter with default value. */
    public int get(String key, int defValue) {
        var config = get(key);
        int result = NumberUtils.toInt(config.value, Integer.MIN_VALUE);
        if (result == Integer.MIN_VALUE) {
            config.value = Integer.toString(defValue);
            result = defValue;
        }
        return result;
    }

    /** A string getter with default value. */
    public String get(String key, String defValue) {
        var config = get(key);
        if (StringUtils.isBlank(config.value)) {
            config.value = defValue;
        }
        return config.value;
    }

    /** A double getter with default value. */
    public double get(String key, double defValue) {
        var config = get(key);
        var result = NumberUtils.toDouble(config.value, Double.NaN);
        if (Double.isNaN(result)) {
            config.value = Double.toString(defValue);
            result = defValue;
        }
        return result;
    }

    /** A boolean getter with default value. */
    public boolean get(String key, boolean defValue) {
        var config = get(key);
        var result = getBoolean(config.value);
        if (result == -1) {
            config.value = Boolean.toString(defValue);
            return defValue;
        }
        config.value = Boolean.toString(result == 1);
        return result == 1;
    }

    /** Add description for specific value. */
    public Config script(String key, String script) {
        var config = get(key);
        config.script = script;
        return config;
    }

    /** @return 1 for true, 0 for false, -1 for error. */
    private static int getBoolean(String string) {
        var bool = "true".equalsIgnoreCase(string);
        if (!bool && !"false".equalsIgnoreCase(string)) {
            return -1; // Error
        }
        return bool ? 1 : 0;
    }
    
    // A WordUtils.wrap replacement if it got removed in newer Minecraft version.
    @SuppressWarnings("unused")
    private static String[] warp(String text, int wrapLength) {
        var words = StringUtils.split(text, ' ');
        var array = new ArrayList<StringBuilder>();
        var size = Math.min(text.length(), wrapLength);
        var builder = new StringBuilder(size);
        array.add(builder);
        var len = 0;
        for (var word : words) {
            len += word.length();
            builder.append(word).append(' ');
            if (len > wrapLength) {
                len = 0;
                builder = new StringBuilder(size);
                array.add(builder);
            }
        }
        return array.stream().map(StringBuilder::toString).toArray(String[]::new);
    }

    private static class Config {
        String value, script;
        final String key;

        Config(String key) {
            this.key = key;
        }

        Config(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
