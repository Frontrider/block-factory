package hu.frontrider.blockfactory.block;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.StaticDataTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.BlockTemplateProvider;
import hu.frontrider.blockfactory.core.templates.BlockTemplate;
import hu.frontrider.blockfactory.core.templates.impl.DefaultBlockTemplate;
import net.minecraft.util.Identifier;

import java.util.Map;

public class StaticDataBlockProvider implements BlockTemplateProvider {
    @Override
    public Map<Identifier, BlockTemplate> getTemplates() {
        return new StaticDataTemplateHelper<BlockTemplate>(
                bufferedReader -> new Gson().fromJson(bufferedReader, DefaultBlockTemplate.class),
                "block_factory/blocks")
                .getElements();
    }
}
