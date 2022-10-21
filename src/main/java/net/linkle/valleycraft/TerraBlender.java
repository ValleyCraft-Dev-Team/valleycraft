package net.linkle.valleycraft;

import net.linkle.valleycraft.gen.ModRegion;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class TerraBlender implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModRegion());
    }
}
