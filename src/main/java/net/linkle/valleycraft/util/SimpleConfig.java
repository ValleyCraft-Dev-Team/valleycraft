package net.linkle.valleycraft.util;

import static net.linkle.valleycraft.Main.LOGGER;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import net.fabricmc.loader.api.FabricLoader;

/**
 * <p>
 * A simple config file system made by truly AndEditor7.
 * <p>
 * It outputs properties file format and never breaks if the file is corrupted.
 * If so, it resets the config file or resets a corrupted property value.
 * <p>
 * This config system uses the "default" value used for any property. It allows
 * using the latest property value from java code without automatically updating
 * the property value with bulky codes.
 * <p>
 * It also generates comments for individual property values.
 * 
 * @author AndEditor7
 */
public class SimpleConfig {
    /** An error message for the log output.  */
    private static final String ERROR = "Error from reading the file config: ";
    /** A default value to use the latest property value from java */
    private static final String DEFAULT = "default";
    
    private final LinkedHashSet<String> set = new LinkedHashSet<>();
    private final LinkedHashMap<String, Config> map = new LinkedHashMap<>();
    private final File file;
    private Config lastConfig;

    /** Create and read the config file. */
    public SimpleConfig(String name) {
        var path = FabricLoader.getInstance().getConfigDir();
        this.file = path.resolve(name.concat(".properties")).toFile();
        try {
            readFile();
        } catch (Exception e) {
            LOGGER.warn(ERROR + file.getName());
            map.clear();
        }
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

                var parts = StringUtils.split(StringUtils.trimToEmpty(entry), '=');
                map.put(parts[0], new Config(parts[0], parts[1]));
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
        var temp = new LinkedHashMap<String, Config>(map);
        map.clear();
        for (String key : set) {
            map.put(key, temp.get(key));
        }

        PrintWriter printer = null;
        try {
            printer = new PrintWriter(file, "UTF-8");
            printer.write("# value type sheet\n");
            printer.write("# Boolean: true or false (true)\n");
            printer.write("# Integer: a number without decimal (42)\n");
            printer.write("# Double: a number with decimal (42.64)\n");
            printer.write("# String: any (boop)\n");
            printer.write("# List: either in numbers or anything. Use comma for each element (3,80,14,34)");
            for (var config : map.values()) {
                if (config.value == null)
                    continue;

                printer.write(LINES);

                if (StringUtils.isNotBlank(config.script)) {
                    var lines = warp(config, 80);
                    for (String line : lines) {
                        printer.write("# " + line + '\n');
                    }
                }

                printer.write(config.key + " = " + config.value);
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
        lastConfig = config;
        return config;
    }

    /** An integer getter with default value. 
     * @param positiveOnly - if true, use the default value if it's negative. */
    public int getInt(String key, int defValue, boolean positiveOnly) {
        get(key).set(defValue, "Integer" + (positiveOnly ? "[PositiveOnly]" : ""));
        return getInt(key, defValue, positiveOnly ? 0 : Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /** An integer getter with default value. 
    * @param min - if it below min, use the default value.
    * @param max - if it above max, use the default value. */
    public int getInt(String key, int defValue, int min, int max) {
        var config = get(key);
        if (config.valueType.isEmpty())
        config.set(defValue, "Integer[min:"+min+", max:"+max+"]");
        if (config.isDefault) {
            return defValue;
        }
        int result = NumberUtils.toInt(config.value, Integer.MIN_VALUE);
        if (result == Integer.MIN_VALUE || result < min || result > max) {
            config.setDefault();
            result = defValue;
        }
        return result;
    }

    /** A string getter with default value. */
    public String getString(String key, String defValue) {
        var config = get(key);
        config.set(defValue);
        if (config.isDefault) {
            return defValue;
        }
        if (StringUtils.isBlank(config.value)) {
            config.setDefault();
            return defValue;
        }
        return config.value;
    }
    
    /** An enum getter with default value. 
     *  @param defValue - A default value.
     *  @param type - Typically put YourEnum.class */
    public <T extends Enum<T>> T getEnum(String key, T defValue, Class<T> type) {
        var config = get(key);
        config.set(defValue, "Enum"+Arrays.toString(type.getEnumConstants()));
        if (config.isDefault) {
            return defValue;
        }
        var value = defValue;
        try {
            value = Enum.valueOf(type, config.value);
        } catch(Exception e) {
            config.setDefault();
        }
        return value;
    }
    
    /** A float getter with default value.
     * @param positiveOnly - if true, use the default value if it's negative. */
    public float getFloat(String key, double defValue, boolean positiveOnly) {
        return (float)getDouble(key, defValue, positiveOnly);
    }

    /** A float getter with default value.
    * @param min - if it below min, use the default value.
    * @param max - if it above max, use the default value. */
    public float getFloat(String key, double defValue, double min, double max) {
        return (float)getDouble(key, defValue, min, max);
    }
    
    /** A double getter with default value.
     * @param positiveOnly - if true, use the default value if it's negative. */
    public double getDouble(String key, double defValue, boolean positiveOnly) {
        get(key).set(defValue, "Double" + (positiveOnly ? "[PositiveOnly]" : ""));
        return getDouble(key, defValue, positiveOnly ? 0.0 : Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    /** A double getter with default value. It can be casted to Float.
    * @param min - if it below min, use the default value.
    * @param max - if it above max, use the default value. */
    public double getDouble(String key, double defValue, double min, double max) {
        var config = get(key);
        if (config.valueType.isEmpty())
        config.set(defValue, "Double[min:"+min+", max:"+max+"]");
        if (config.isDefault) {
            return defValue;
        }
        
        var result = NumberUtils.toDouble(config.value, Double.NaN);
        if (Double.isNaN(result) || result < min || result > max) {
            config.setDefault();
            result = defValue;
        }
        return result;
    }

    /** A boolean getter with default value. */
    public boolean getBoolean(String key, boolean defValue) {
        var config = get(key);
        config.set(defValue);
        if (config.isDefault) {
            return defValue;
        }
        var result = getBoolean(config.value);
        if (result == -1) {
            config.setDefault();
            return defValue;
        }
        return result == 1;
    }
    
    /** A list getter with default value. Integer, Double, Boolean and String only */
    public ObjList getList(String key, List<Object> defValues) {
        var config = get(key);
        config.setList(defValues, "any");
        if (config.isDefault) {
            return new ObjList(defValues);
        }
        
        final var strings = StringUtils.split(config.value, ',');
        final var array = new Object[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            var string = strings[i];
            Object obj;
            int intVal; double doubleVal;
            if ((intVal = getBoolean(string)) != -1) {
                obj = intVal == 1;
            } else if ((intVal = NumberUtils.toInt(string, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                obj = intVal;
            } else if (!Double.isNaN(doubleVal = NumberUtils.toDouble(string, Double.NaN))) {
                obj = doubleVal;
            } else {
                obj = string;
            }
            array[i] = obj;
        }
        
        return new ObjList(array);
    }
    
    /** A number list getter with default value. Integer and Double only */
    public ObjList getListNum(String key, List<Object> defValues) {
        var config = get(key);
        config.setList(defValues, "numbers");
        if (config.isDefault) {
            return new ObjList(defValues);
        }
        
        final var strings = StringUtils.split(config.value, ',');
        final var array = new Object[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            var string = strings[i];
            Object obj;
            int intVal; double doubleVal;
            if ((intVal = NumberUtils.toInt(string, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                obj = intVal;
            } else if (!Double.isNaN(doubleVal = NumberUtils.toDouble(string, Double.NaN))) {
                obj = doubleVal;
            } else {
                config.setDefault();
                return new ObjList(defValues);
            }
            array[i] = obj;
        }
        
        return new ObjList(array);
    }
    
    /** An enum list getter with default value. Enum only */
    @SuppressWarnings("unchecked")
    public <T extends Enum<T>> List<T> getListEnum(String key, List<T> defValues, Class<T> type) {
        var config = get(key);
        config.setList(defValues, "Enum"+Arrays.toString(type.getEnumConstants()));
        if (config.isDefault) {
            return defValues;
        }
        
        final var strings = StringUtils.split(config.value, ',');
        final var array = new Enum[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            var string = strings[i];
            T value;
            try {
                value = Enum.valueOf(type, string);
            } catch(Exception e) {
                config.setDefault();
                return defValues;
            }
            array[i] = value;
        }
        
        return (List<T>)List.of((T[])array);
    }

    /** Add description for specific value. */
    public void script(String key, String description) {
        var config = get(key);
        config.script = description;
    }
    
    /** Add description for the last get value. */
    public void script(String description) {
        lastConfig.script = description;
    }

    /** @return 1 is true, 0 is false, -1 is error. */
    private static int getBoolean(String string) {
        var bool = "true".equalsIgnoreCase(string);
        if (!bool && !"false".equalsIgnoreCase(string)) {
            return -1; // Error
        }
        return bool ? 1 : 0;
    }
    
    private static String[] warp(Config config, int wrapLength) {
        String text = config.script;
        var size = Math.min(text.length(), wrapLength);
        var array = new ArrayList<StringBuilder>();
        var builder = new StringBuilder(size);
        if (!StringUtils.isBlank(text)) {
            var words = StringUtils.split(text, ' ');
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
            builder.append('\n');
        }
        builder.append("# (default: ").append(config.defValue).append("), (value type: ").append(config.valueType).append(')');
        return array.stream().map(StringBuilder::toString).toArray(String[]::new);
    }

    private static class Config {
        boolean isDefault = true;
        /** Non-Null */
        String defValue = StringUtils.EMPTY;
        /** Non-Null */
        String valueType = StringUtils.EMPTY;
        /** Non-Null */
        String value;
        String script;
        final String key;

        Config(String key) {
            this(key, DEFAULT);
        }

        Config(String key, String value) {
            this.key = key;
            this.value = value;
            isDefault = value.equalsIgnoreCase(DEFAULT);
        }
        
        void setList(List<?> defValues, String type) {
            var defValue = new StringBuilder();
            for (var obj : defValues) {
                defValue.append(obj).append(',');
            }
            defValue.setLength(defValue.length()-1);
            set(defValue, "List["+type+']');
        }
        
        void set(Object defValue) {
            set(defValue, defValue.getClass().getSimpleName());
        }
        
        void set(Object defValue, Object valueType) {
            this.defValue = defValue.toString();
            this.valueType = valueType.toString();
        }
        
        void setDefault() {
            this.isDefault = true;
            this.value = DEFAULT;
        }
    }
    
    public static class ObjList implements Iterable<Object> {
        
        public final List<Object> list;
        
        private ObjList(Object[] list) {
            this(List.of(list));
        }
        
        private ObjList(List<Object> list) {
            this.list = list;
        }
        
        public int size() {
            return list.size();
        }
        
        public Object get(int i) {
            return list.get(i);
        }
        
        public Number getNum(int i) {
            return (Number)get(i);
        }
        
        public int getInt(int i) {
            return getNum(i).intValue();
        }
        
        public double getDouble(int i) {
            return getNum(i).doubleValue();
        }
        
        public float getFloat(int i) {
            return getNum(i).floatValue();
        }
        
        public boolean getBoolean(int i) {
            return (boolean)get(i);
        }
        
        public String getString(int i) {
            return get(i).toString();
        }

        @Override
        public Iterator<Object> iterator() {
            return list.iterator();
        }
        
        @Override
        public String toString() {
            return list.toString();
        }
    }
}
