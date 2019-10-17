package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.StaticDataTemplateHelper;
import hu.frontrider.blockfactory.core.templates.provider.ItemTemplateProvider;
import hu.frontrider.blockfactory.core.templates.impl.DefaultItemTemplate;
import hu.frontrider.blockfactory.core.templates.ItemTemplate;
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
