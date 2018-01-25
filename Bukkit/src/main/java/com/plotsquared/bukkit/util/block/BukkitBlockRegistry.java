package com.plotsquared.bukkit.util.block;

import com.intellectualcrafters.plot.IPlotMain;
import com.intellectualcrafters.plot.object.PlotBlock;
import com.plotsquared.block.BlockRegistry;
import org.bukkit.Material;

public class BukkitBlockRegistry extends BlockRegistry {
    public BukkitBlockRegistry(IPlotMain iPlotMain, String world) {
        super(iPlotMain, world);
    }

    @Override
    public boolean isWorld(String world) {
        return true;
    }

    @Override
    public PlotBlock get(int combined) {
        return super.get(combined);
    }

    @Override
    public PlotBlock get(String name) {
        PlotBlock cached = super.get(name);
        if (cached != null) return cached;

        String[] split = name.split(":");
        String type;
        String[] variants;
        switch (split.length) {
            case 1:
            case 2:
                if (split[0].equalsIgnoreCase("minecraft") || split[])

                break;
            case 3:
            default: return null;
        }
        try {
            Material.valueOf(name.toUpperCase())
        }
    }
}
