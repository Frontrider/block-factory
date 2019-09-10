package hu.frontrider.blockfactory.templateprovider;

import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * Because fabric prevents mods from reading the file system, we have a service that can provide templates from mods.
 * */
public interface ItemTemplateProvider extends TemplateProvider<ItemTemplate>{

    Map<Identifier,ItemTemplate> getTemplates();
}
