package hu.frontrider.blockfactory.core.templates.provider;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * Because fabric prevents mods from reading the file system, we have a service that can provide templates from mods.
 * */
public interface ArmorMaterialTemplateProvider extends TemplateProvider<ArmorMaterial>{

    Map<Identifier,ArmorMaterial> getTemplates();
}
