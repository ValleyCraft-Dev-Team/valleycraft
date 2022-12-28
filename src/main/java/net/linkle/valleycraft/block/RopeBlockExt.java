package net.linkle.valleycraft.block;

public interface RopeBlockExt {
    boolean isVertical();
    default boolean isHorizontal() {
        return !isVertical();
    }
}
