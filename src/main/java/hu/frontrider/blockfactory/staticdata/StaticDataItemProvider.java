package hu.frontrider.blockfactory.staticdata;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.templateprovider.BlockTemplateProvider;
import hu.frontrider.blockfactory.templateprovider.ItemTemplateProvider;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.DefaultBlockTemplate;
import hu.frontrider.blockfactory.templates.DefaultItemTemplate;
import hu.frontrider.blockfactory.templates.ItemTemplate;
import net.minecraft.util.Identifier;

import java.util.Map;

public class StaticDataItemProvider implements ItemTemplateProvider {
    @Override
    public Map<Identifier, ItemTemplate> getTemplates() {
        return new StaticDataTemplateHelper<ItemTemplate>(
                bufferedReader -> new Gson().fromJson(bufferedReader, DefaultItemTemplate.class),
                "block_factory/items")
                .getElements();
    }
}
