package hu.frontrider.blockfactory.core.templates.provider;

import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import net.minecraft.util.Identifier;
import java.util.Map;

/**
 * Because fabric prevents mods from reading the file system, we have a service that can provide templates from mods.
 * */
public interface  BlockTemplateProvider extends TemplateProvider<BlockTemplate>{

    Map<Identifier,BlockTemplate> getTemplates();
}
