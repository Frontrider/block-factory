package hu.frontrider.blockfactory.core.templates;

import hu.frontrider.blockfactory.data.BlockRendering;
import hu.frontrider.blockfactory.data.Materials;

import java.util.List;

public interface BlockTemplate {

    Materials getMaterial();
    BlockRendering getRenderLayer();
    boolean canSpawnMobs();
    boolean isAir();
    int getLightLevel();

    List<String> getType();

    /**
     * Weather or not this block is being colored.
    * */
    boolean isColored();
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
