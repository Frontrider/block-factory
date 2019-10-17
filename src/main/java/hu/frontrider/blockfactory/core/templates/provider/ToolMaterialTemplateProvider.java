package hu.frontrider.blockfactory.core.templates.provider;

import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * Because fabric prevents mods from reading the file system, we have a service that can provide templates from mods.
 * */
public interface ToolMaterialTemplateProvider extends TemplateProvider<ToolMaterial>{

    Map<Identifier,ToolMaterial> getTemplates();
}
