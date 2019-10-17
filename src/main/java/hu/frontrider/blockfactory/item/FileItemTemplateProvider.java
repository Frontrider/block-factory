package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.DirectoryManager;
import hu.frontrider.blockfactory.core.templates.provider.ItemTemplateProvider;
import hu.frontrider.blockfactory.core.templates.impl.DefaultItemTemplate;
import hu.frontrider.blockfactory.core.templates.ItemTemplate;
import hu.frontrider.blockfactory.core.util.FileTemplateHelper;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.util.Map;

/**
 * reads json files from the run folder.
 */
public class FileItemTemplateProvider implements ItemTemplateProvider {
    private Gson gson = new Gson();

    @Override
    public Map<Identifier, ItemTemplate> getTemplates() {
        return new FileTemplateHelper<ItemTemplate>(
                (file)-> gson.fromJson(new FileReader(file), DefaultItemTemplate.class),
                DirectoryManager.getINSTANCE().getItemFolder()
        ).getTemplates();
    }
}
