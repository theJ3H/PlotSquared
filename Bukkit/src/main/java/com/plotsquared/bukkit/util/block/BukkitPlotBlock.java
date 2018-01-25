package com.plotsquared.bukkit.util.block;

import com.intellectualcrafters.plot.object.PlotBlock;
import org.bukkit.Material;

public class BukkitPlotBlock extends PlotBlock {
    private final short ordinal;

    public BukkitPlotBlock(int combinedId, Material material) {
        super(combinedId);
        this.ordinal = (short) material.ordinal();

    }

    @Override
    public boolean isInteractive() {
        return getMaterial().isInteractive();
    }

    @Override
    public boolean isPowerable() {
        return getMaterial().isPowerable();
    }

    public Material getMaterial() {
        return Material.values()[ordinal];
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean isTransparent() {
        return getMaterial().isTransparent();
    }

    @Override
    public boolean isItem() {
        return getMaterial().isItem();
    }

    @Override
    public boolean isFlammable() {
        return getMaterial().isFlammable();
    }

    @Override
    public boolean isBurnable() {
        return getMaterial().isBurnable();
    }

    @Override
    public boolean isSolid() {
        return getMaterial().isSolid();
    }

    @Override
    public boolean isBlock() {
        return getMaterial().isBlock();
    }

    @Override
    public boolean isEdible() {
        return getMaterial().isEdible();
    }

    @Override
    public boolean isOccluding() {
        return getMaterial().isOccluding();
    }


    @Override
    public boolean hasGravity() {
        return getMaterial().hasGravity();
    }
}
