package net.linkle.valleycraft.client;

import java.util.ArrayList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.block.entity.WispLanternRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

/**
 * It's for registering textures that aren't registered so it can load the
 * texture file into the sprite sheet/texture atlas. If the item/block model is
 * referencing the texture, then it's no need to register!
 * 
 * @author AndEditor7
 */
@Environment(EnvType.CLIENT)
public class Sprites {

    private static final ArrayList<Identifier> TEXS = new ArrayList<>();

    static void intialize() {
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlas, registry) -> TEXS.forEach(registry::register));

        register(WispLanternRenderer.VEX_TEXTURE);
        register(WispLanternRenderer.ALLAY_TEXTURE);
    }

    /**
     * Register the sprite.
     * 
     * @param texturePath of your textures mod folder.
     */
    private static void register(String texturePath) {
        register(Main.makeId(texturePath));
    }

    /** Register the sprite. */
    private static void register(Identifier id) {
        TEXS.add(id);
    }

    /** Register the sprite. */
    private static void register(SpriteIdentifier id) {
        register(id.getTextureId());
    }

    public static SpriteIdentifier create(String id) {
        return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Main.makeId(id));
    }
}
