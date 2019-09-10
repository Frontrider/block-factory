package hu.frontrider.blockfactory.templateprovider;

import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * Because fabric prevents mods from reading the file system, we have a service that can provide templates from mods.
 * */
public interface TemplateProvider<T> {

    Map<Identifier,T> getTemplates();
}
