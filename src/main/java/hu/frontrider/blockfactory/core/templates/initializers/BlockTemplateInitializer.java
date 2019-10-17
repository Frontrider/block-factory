package hu.frontrider.blockfactory.core.templates.initializers;


import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.List;

/**
 * Used to build a template of a specific type.
 *
 * */
public interface BlockTemplateInitializer {

    Block initialize(BlockTemplate template, Identifier identifier);

    boolean isValid(List<String> types);
}
