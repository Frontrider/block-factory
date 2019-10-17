package hu.frontrider.blockfactory.core.templates.initializers;


import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import java.util.List;

/**
 * Used to build a template of a specific type.
 *
 * IF the item is NOT a tool, then it will get a null for the material!
 * IF the item is NOT an armor, then it will get a null for the material!
 * */
public interface ItemTemplateInitializer {

    List<Item> initialize(ItemTemplate template, ToolMaterial material, ArmorMaterial armorMaterial, Identifier identifier);

    default ItemType itemType(){return ItemType.NORMAL;}

    boolean isValid(ItemTemplate template, Identifier toolMaterial);

    enum ItemType{
        ARMOR,NORMAL,TOOL
    }
}
