package hu.frontrider.blockfactory.templates;

import hu.frontrider.blockfactory.data.BlockType;
import hu.frontrider.blockfactory.data.Material;
import net.minecraft.block.BlockRenderLayer;

import java.util.Objects;

public class DefaultBlockTemplate implements BlockTemplate {

    private Material material = Material.STONE;
    private BlockRenderLayer renderLayer = BlockRenderLayer.SOLID;
    private boolean canSpawnMobs = true;
    private boolean isAir =false;
    private int lightLevel = 0;
    private boolean isInvisible =false;
    private float hardness = 1.0f;
    private boolean isCollideable = true;
    private boolean hasItem = true;
    private boolean ticksRandomly=false;
    private BlockType type = BlockType.NORMAl;

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

    public DefaultBlockTemplate setType(BlockType blockType) {
        this.type = blockType;
        return this;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
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
    public BlockType getType() {
        return type;
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

    public DefaultBlockTemplate setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public DefaultBlockTemplate setRenderLayer(BlockRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
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
                material == that.material &&
                renderLayer == that.renderLayer &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, renderLayer, canSpawnMobs, isAir, lightLevel, isInvisible, hardness, isCollideable, hasItem, ticksRandomly, type);
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
                ", type=" + type +
                '}';
    }
}
