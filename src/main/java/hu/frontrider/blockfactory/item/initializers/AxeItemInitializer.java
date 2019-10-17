package hu.frontrider.blockfactory.item.initializers;

import hu.frontrider.blockfactory.item.templates.TemplatedAxe;
import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import hu.frontrider.blockfactory.core.templates.initializers.ItemTemplateInitializer;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.List;

public class AxeItemInitializer implements ItemTemplateInitializer {

    @Override
    public List<Item> initialize(ItemTemplate template, ToolMaterial material, ArmorMaterial armorMaterial, Identifier identifier) {
        return Collections.singletonList(Registry.register(Registry.ITEM, identifier, new TemplatedAxe(material,template)));
    }

    @Override
    public boolean isValid(ItemTemplate template, Identifier toolMaterial) {
        if(template.getMaterialID() == null){
            return false;
        }
        return template.getType().contains("axe")
                && template.getMaterialID().equals(toolMaterial.toString());
    }

    @Override
    public ItemType itemType() {
        return ItemType.TOOL;
    }
}
