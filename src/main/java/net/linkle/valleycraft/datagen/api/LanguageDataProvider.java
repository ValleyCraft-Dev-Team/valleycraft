package net.linkle.valleycraft.datagen.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Block;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Register an instance of the class with {@link FabricDataGenerator#addProvider} in a {@link net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint}
 */
public abstract class LanguageDataProvider implements DataProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageDataProvider.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private final Map<String, String> data = new TreeMap<>();
    protected final FabricDataGenerator dataGenerator;
    private final String modId;
    private final String locale;

    protected LanguageDataProvider(FabricDataGenerator dataGenerator, String locale) {
        this.dataGenerator = dataGenerator;
        this.modId = dataGenerator.getModId();
        this.locale = locale;
    }

    public void addBlock(Block key, String name) {
        add(key.getTranslationKey(), name);
    }

    public void addItem(Item key, String name) {
        add(key.getTranslationKey(), name);
    }

    public void addItemStack(ItemStack key, String name) {
        add(key.getTranslationKey(), name);
    }

    public void addEnchantment(Enchantment key, String name) {
        add(key.getTranslationKey(), name);
    }

    public void addBiome(RegistryKey<Biome> key, String name) {
        addBiome(key.getValue(), name);
    }

    public void addBiome(Identifier key, String name) {
        add("biome." + key.getNamespace() + "." + key.getPath(), name);
    }

    public void add(String key, String value) {
        if (data.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }

    /**
     * Registers all translations to be placed inside the lang file.
     */
    protected abstract void registerTranslations();

    @Override
    public void run(@NotNull DataWriter writer) {
        this.registerTranslations();

        Path path = this.dataGenerator.getOutput().resolve("assets/" + this.modId + "/lang/" + this.locale + ".json");
        try {
            JsonElement json = GSON.toJsonTree(this.data);
            DataProvider.writeToPath(writer, json, path);
        } catch (IOException e) {
            LOGGER.error("Couldn't save {}", path, e);
        }
    }

    @Override
    public String getName() {
        return "Language: " + locale;
    }

}