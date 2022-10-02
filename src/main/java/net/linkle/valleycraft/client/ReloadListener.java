package net.linkle.valleycraft.client;

import net.minecraft.resource.ResourceManager;

/**
 * A simple synchronous reload listener. Typically it gets called when the
 * resource is loaded or reloaded in-game when F3+T is pressed.
 */
public interface ReloadListener {
    void reload(ResourceManager manager);
}
