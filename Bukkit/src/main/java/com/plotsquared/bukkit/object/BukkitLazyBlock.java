package com.plotsquared.bukkit.object;

import com.intellectualcrafters.plot.object.LazyBlock;
import com.intellectualcrafters.plot.object.PlotBlock;
import com.plotsquared.bukkit.util.BukkitUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BukkitLazyBlock extends LazyBlock {

    private int id;
    private Block block;
    private PlotBlock pb;

    public BukkitLazyBlock(int id, Block block) {
        this.id = id;
        this.block = block;
    }

    public BukkitLazyBlock(PlotBlock pb) {
        this.id = pb.id;
        this.pb = pb;
    }

    public BukkitLazyBlock(Block block) {
        this.block = block;
    }

    @Override
    public PlotBlock getPlotBlock() {
        if (this.pb != null) {
            return this.pb;
        }
        Material type = this.block.getType();
        this.id = BukkitUtil.getId(type);
        switch (type) {
            case AIR:
            case LEGACY_AIR:
                return PlotBlock.get((char) 1);
        }
        byte data = block.getData();
        this.pb = PlotBlock.get(BukkitUtil.getId(type), data);
        return this.pb;

    }

    @Override
    public int getId() {
        if (this.id == 0) {
            this.id = this.block.getTypeId();
        }
        return this.id;
    }

}
