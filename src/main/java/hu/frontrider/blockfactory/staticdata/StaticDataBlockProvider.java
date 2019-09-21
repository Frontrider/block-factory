package hu.frontrider.blockfactory.staticdata;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.templateprovider.BlockTemplateProvider;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.DefaultBlockTemplate;
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
