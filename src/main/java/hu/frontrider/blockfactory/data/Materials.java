package hu.frontrider.blockfactory.data;

import net.minecraft.block.Material;

//references to all vanilla materials that should be useable in templates.
public enum Materials {

    AIR(Material.AIR),
    STRUCTURE_VOID(Material.STRUCTURE_VOID),
    PORTAL(Material.PORTAL),
    CARPET(Material.CARPET),
    PLANT(Material.PLANT),
    UNDERWATER_PLANT(Material.UNDERWATER_PLANT),
    REPLACEABLE_PLANT(Material.REPLACEABLE_PLANT),
    SEAGRASS(Material.SEAGRASS),
    WATER(Material.WATER),
    LAVA(Material.LAVA),
    SNOW(Material.SNOW),
    FIRE(Material.FIRE),
    COBWEB(Material.COBWEB),
    REDSTONE_LAMP(Material.REDSTONE_LAMP),
    CLAY(Material.CLAY),
    EARTH(Material.EARTH),
    ORGANIC(Material.ORGANIC),
    PACKED_ICE(Material.PACKED_ICE),
    SAND(Material.SAND),
    SPONGE(Material.SPONGE),
    SHULKER_BOX(Material.SHULKER_BOX),
    WOOD(Material.WOOD),
    BAMBOO_SAPLING(Material.BAMBOO_SAPLING),
    BAMBOO(Material.BAMBOO),
    WOOL(Material.WOOL),
    TNT(Material.TNT),
    LEAVES(Material.LEAVES),
    GLASS(Material.GLASS),
    ICE(Material.ICE),
    CACTUS(Material.CACTUS),
    STONE(Material.STONE),
    METAL(Material.METAL),
    SNOW_BLOCK(Material.SNOW_BLOCK),
    ANVIL(Material.ANVIL),
    BARRIER(Material.BARRIER),
    PISTON(Material.PISTON),
    PUMPLKIN(Material.PUMPKIN),
    EGG(Material.EGG),
    CAKE(Material.CAKE);

    private final Material material;

    Materials(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}
