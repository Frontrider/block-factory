package hu.frontrider.blockfactory.templates;

import hu.frontrider.blockfactory.data.BlockType;
import hu.frontrider.blockfactory.data.Material;
import net.minecraft.block.BlockRenderLayer;

public interface BlockTemplate {

    Material getMaterial();
    BlockRenderLayer getRenderLayer();
    boolean canSpawnMobs();
    boolean isAir();
    int getLightLevel();

    BlockType getType();

    /**
     * sets the render type from MODEL to INVISIBLE
     * By design, you can not use special renderers!
     * */
    boolean isInvisible();

    float getHardness();

    /**
     * weather or not this block ticks randomly. Can be important if an another mod adds behaviour for random ticks!
     * */
    boolean ticksRandomly();
    boolean isCollideable();

    boolean hasItem();
}
