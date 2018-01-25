package com.intellectualcrafters.plot.object;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.config.Settings;

public class PlotBlock {

    public static final PlotBlock EVERYTHING = new PlotBlock((short) 0, (byte) 0);

    private char combinedId;

    public static PlotBlock get(char combinedId) {
        switch (combinedId) {
            case 0:
                return null;
            case 1:
                return get(0, 0);
            default:
                return get(combinedId >> 4, combinedId & 15);
        }
    }

    @Deprecated
    public static PlotBlock get(int id, int data) {
        if (Settings.Enabled_Components.BLOCK_CACHE) {
            return PS.get().getBlockRegistry().get((id << 4) + data);
        } else {
            return new PlotBlock((short) id, (byte) data);
        }
    }

    protected PlotBlock(int combinedId) {
        this.combinedId = (char) combinedId;
    }

    @Deprecated
    public PlotBlock(short id, byte data) {
        combinedId = (char) ((id >> 4) + data);
    }

    @Deprecated
    public int getId() {
        return combinedId >> 4;
    }

    @Deprecated
    public int getData() {
        return combinedId & 15;
    }

    public int getCombinedId() {
        return combinedId;
    }

    public String getName() {
        if (this.getData() == -1) {
            return Integer.toString(this.getId());
        }
        return this.getId() + ":" + this.getData();
    }

    public boolean isTransparent() {
        return false;
    }

    public boolean isOccluding() {
        return !isTransparent() && isSolid() && isBlock();
    }

    public boolean isSolid() {
        return true;
    }

    public boolean isBlock() {
        return true;
    }

    public boolean isEdible() {
        return false;
    }

    public boolean isInteractive() {
        return false;
    }

    public boolean isItem() {
        return !isBlock();
    }

    public boolean isFlammable() {
        return isBurnable();
    }

    public boolean isBurnable() {
        return false;
    }

    public boolean isPowerable() {
        return false;
    }

    public boolean hasGravity() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PlotBlock other = (PlotBlock) obj;
        return (this.id == other.id) && ((this.data == other.data) || (this.data == -1) || (other.data == -1));
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
