package hu.frontrider.blockfactory.data;

public enum Material {

    STONE(net.minecraft.block.Material.STONE),
    WOOD(net.minecraft.block.Material.WOOD),
    METAL(net.minecraft.block.Material.METAL),
    DIRT(net.minecraft.block.Material.EARTH),
    SAND(net.minecraft.block.Material.SAND),
    GLASS(net.minecraft.block.Material.GLASS);

    private final net.minecraft.block.Material material;

    private Material(net.minecraft.block.Material material){
        this.material = material;
    }

    public net.minecraft.block.Material getMaterial() {
        return material;
    }
}
