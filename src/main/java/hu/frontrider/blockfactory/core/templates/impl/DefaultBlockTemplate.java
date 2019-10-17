package hu.frontrider.blockfactory.core.templates.impl;

import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.data.BlockRendering;
import hu.frontrider.blockfactory.data.Materials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DefaultBlockTemplate implements BlockTemplate {

    private Materials material = Materials.STONE;
    private BlockRendering renderLayer = BlockRendering.SOLID;
    private boolean canSpawnMobs = true;
    private boolean isAir =false;
    private int lightLevel = 0;
    private boolean isInvisible =false;
    private float hardness = 1.0f;
    private boolean isCollideable = true;
    private boolean hasItem = true;
    private boolean ticksRandomly=false;
    private boolean isColored = false;
    private List<String> type = Collections.singletonList("normal");


    public boolean isCanSpawnMobs() {
        return canSpawnMobs;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public boolean isTicksRandomly() {
        return ticksRandomly;
    }

    public DefaultBlockTemplate setTicksRandomly(boolean ticksRandomly) {
        this.ticksRandomly = ticksRandomly;
        return this;
    }

    public DefaultBlockTemplate setType(List<String> blockTypes) {
        this.type = blockTypes;
        return this;
    }

    @Override
    public Materials getMaterial() {
        return material;
    }

    @Override
    public BlockRendering getRenderLayer() {
        return renderLayer;
    }

    @Override
    public boolean canSpawnMobs() {
        return canSpawnMobs;
    }

    @Override
    public boolean isAir() {
        return isAir;
    }

    @Override
    public int getLightLevel() {
        return lightLevel;
    }

    @Override
    public List<String> getType() {
        ArrayList<String> list = new ArrayList<>();
        for (String s : type) {
            list.add(s.toLowerCase());
        }
        return list;
    }

    @Override
    public boolean isColored() {
        return isColored;
    }

    @Override
    public boolean isInvisible() {
        return isInvisible;
    }

    @Override
    public float getHardness() {
        return hardness;
    }

    @Override
    public boolean ticksRandomly() {
        return ticksRandomly;
    }

    @Override
    public boolean isCollideable() {
        return isCollideable;
    }

    @Override
    public boolean hasItem() {
        return hasItem;
    }

    public DefaultBlockTemplate setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
        return this;
    }

    public DefaultBlockTemplate setCollideable(boolean collideable) {
        isCollideable = collideable;
        return this;
    }

    public DefaultBlockTemplate setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    public DefaultBlockTemplate setInvisible(boolean invisible) {
        isInvisible = invisible;
        return this;
    }

    public DefaultBlockTemplate setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
        return this;
    }

    public DefaultBlockTemplate setAir(boolean air) {
        isAir = air;
        return this;
    }

    public DefaultBlockTemplate setCanSpawnMobs(boolean canSpawnMobs) {
        this.canSpawnMobs = canSpawnMobs;
        return this;
    }

    public DefaultBlockTemplate setMaterial(Materials material) {
        this.material = material;
        return this;
    }

    public DefaultBlockTemplate setRenderLayer(BlockRendering renderLayer) {
        this.renderLayer = renderLayer;
        return this;
    }

    public DefaultBlockTemplate setColored(boolean colored) {
        isColored = colored;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultBlockTemplate that = (DefaultBlockTemplate) o;
        return canSpawnMobs == that.canSpawnMobs &&
                isAir == that.isAir &&
                lightLevel == that.lightLevel &&
                isInvisible == that.isInvisible &&
                Float.compare(that.hardness, hardness) == 0 &&
                isCollideable == that.isCollideable &&
                hasItem == that.hasItem &&
                ticksRandomly == that.ticksRandomly &&
                isColored == that.isColored &&
                material == that.material &&
                renderLayer == that.renderLayer &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, renderLayer, canSpawnMobs, isAir, lightLevel, isInvisible, hardness, isCollideable, hasItem, ticksRandomly, isColored, type);
    }

    @Override
    public String toString() {
        return "DefaultBlockTemplate{" +
                "material=" + material +
                ", renderLayer=" + renderLayer +
                ", canSpawnMobs=" + canSpawnMobs +
                ", isAir=" + isAir +
                ", lightLevel=" + lightLevel +
                ", isInvisible=" + isInvisible +
                ", hardness=" + hardness +
                ", isCollideable=" + isCollideable +
                ", hasItem=" + hasItem +
                ", ticksRandomly=" + ticksRandomly +
                ", isColored=" + isColored +
                ", type=" + type +
                '}';
    }
}
