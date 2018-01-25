package com.plotsquared.block;

import com.intellectualcrafters.plot.IPlotMain;
import com.intellectualcrafters.plot.object.PlotBlock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BlockRegistry<T extends PlotBlock> {
    private final PlotBlock[] CACHE;
    private final Map<String, Integer> BLOCK_MAP;
    private final IPlotMain iPlotMain;
    private String world;
    private boolean enabled;

    public BlockRegistry(IPlotMain iPlotMain, String world) {
        this.iPlotMain = iPlotMain;
        CACHE = new PlotBlock[65535];
        BLOCK_MAP = new ConcurrentHashMap<>();
        this.world = world;
    }

    public boolean isWorld(String world) {
        if (this.world == world) return true;
        if (this.world.equals(world)) {
            this.world = world;
            return true;
        }
        return false;
    }

    public void enable() {
        if (!enabled) {
            synchronized (this) {
                if (!enabled) {
                    iPlotMain.registerBlocks(this);
                    enabled = true;
                }
            }
        }
    }

    public void register(char combinedId, T block) {
        CACHE[combinedId] = block;
        BLOCK_MAP.putIfAbsent(block.toString(), (int) combinedId);
    }

    public T get(String name) {
        enable();
        Integer id = BLOCK_MAP.get(name);
        if (id != null) return (T) CACHE[id];
        return null;
    }

    public T get(int combined) {
        enable();
        return (T) CACHE[combined];
    }

    public int getId(PlotBlock block) {
        return block.getCombinedId();
    }
}
