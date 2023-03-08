package net.linkle.valleycraft.client;

import com.google.common.collect.ArrayListMultimap;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.linkle.valleycraft.Main;
import net.minecraft.client.render.TexturedRenderLayers;
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
    private static final ArrayListMultimap<Identifier, Identifier> MAP = ArrayListMultimap.create();
    
    public static final SpriteIdentifier DEEPSLATE_CHEST = register(create(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "entity/chest/deepslate"));
    public static final SpriteIdentifier DEEPSLATE_LEFT_CHEST = register(create(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "entity/chest/deepslate_left"));
    public static final SpriteIdentifier DEEPSLATE_RIGHT_CHEST = register(create(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, "entity/chest/deepslate_right"));
    
    static void initialize() {
        
    }
    
    /** Register the texture to atlas */
    private static SpriteIdentifier register(SpriteIdentifier spriteId) {
        register(spriteId.getAtlasId(), spriteId.getTextureId());
        return spriteId;
    }
    
    /** Register the texture with a given atlas path */
    private static Identifier register(Identifier atlasId, Identifier texId) {
        if (!MAP.containsKey(atlasId)) {
            ClientSpriteRegistryCallback.event(atlasId).register((atlas, registry) -> MAP.get(atlasId).forEach(registry::register));
        }
        MAP.put(atlasId, texId);
        return texId;
    }

    /** Create the Sprite in Block Atlas. Register using {@link Sprites#register(SpriteIdentifier)} order to work */
    public static SpriteIdentifier create(String id) {
        return create(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, id);
    }
    
    /** Create the Sprite. Register using {@link Sprites#register(SpriteIdentifier)} in {@link Sprites#initialize} order to work */
    public static SpriteIdentifier create(Identifier atlasId, String id) {
        return new SpriteIdentifier(atlasId, Main.makeId(id));
    }
}
