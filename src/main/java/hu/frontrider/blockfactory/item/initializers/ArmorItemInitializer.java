package hu.frontrider.blockfactory.item.initializers;

import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import hu.frontrider.blockfactory.core.templates.initializers.ItemTemplateInitializer;
import hu.frontrider.blockfactory.item.templates.TemplatedArmorItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArmorItemInitializer implements ItemTemplateInitializer {

    @Override
    public List<Item> initialize(ItemTemplate template, ToolMaterial material, ArmorMaterial armorMaterial, Identifier identifier) {

        List<String> templateType = template.getType();

        if (templateType.size() == 1) {
            String type = templateType.get(0);
            if (type.equals("chestplate")) {
                return Collections.singletonList(Registry.register(Registry.ITEM, identifier, new TemplatedArmorItem(armorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
            }
            if (type.equals("boots")) {
                return Collections.singletonList(Registry.register(Registry.ITEM, identifier, new TemplatedArmorItem(armorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
            }
            if (type.equals("leggings")) {
                return Collections.singletonList(Registry.register(Registry.ITEM, identifier, new TemplatedArmorItem(armorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
            }
            if (type.equals("helmet")) {
                return Collections.singletonList(Registry.register(Registry.ITEM, identifier, new TemplatedArmorItem(armorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
            }
        } else {
            LinkedList<Item> items = new LinkedList<>();
            for (String type : templateType) {
                if (type.equals("chestplate")) {
                    items.add(Registry.register(Registry.ITEM, new Identifier(identifier.getNamespace(), identifier.getPath() + "_chestplate"), new TemplatedArmorItem(armorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
                }
                if (type.equals("boots")) {
                    items.add(Registry.register(Registry.ITEM, new Identifier(identifier.getNamespace(), identifier.getPath() + "_boots"), new TemplatedArmorItem(armorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
                }
                if (type.equals("leggings")) {
                    items.add(Registry.register(Registry.ITEM, new Identifier(identifier.getNamespace(), identifier.getPath() + "_leggings"), new TemplatedArmorItem(armorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
                }
                if (type.equals("helmet")) {
                    items.add(Registry.register(Registry.ITEM, new Identifier(identifier.getNamespace(), identifier.getPath() + "_helmet"), new TemplatedArmorItem(armorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT).maxCount(1))));
                }
            }
            return items;
        }
        return null;
    }

    @Override
    public boolean isValid(ItemTemplate template, Identifier material) {
        if (template.getMaterialID() == null) {
            return false;
        }
        return (
                template.getType().contains("chestplate") ||
                        template.getType().contains("boots") ||
                        template.getType().contains("leggings") ||
                        template.getType().contains("helmet")
        )
                && template.getMaterialID().equals(material.toString());
    }

    @Override
    public ItemType itemType() {
        return ItemType.ARMOR;
    }
}
