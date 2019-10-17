package hu.frontrider.blockfactory.item;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.core.util.DirectoryManager;
import hu.frontrider.blockfactory.core.templates.provider.ToolMaterialTemplateProvider;
import hu.frontrider.blockfactory.core.templates.impl.DefaultToolMaterialTemplate;
import hu.frontrider.blockfactory.core.util.FileTemplateHelper;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.util.Map;

/**
 * reads json files from the run folder.
 */
public class FileToolMaterialTemplateProvider implements ToolMaterialTemplateProvider {
    private Gson gson = new Gson();

    @Override
    public Map<Identifier, ToolMaterial> getTemplates() {
        return new FileTemplateHelper<ToolMaterial>(
                (file)-> gson.fromJson(new FileReader(file), DefaultToolMaterialTemplate.class),
                DirectoryManager.getINSTANCE().getToolMaterialFolderFolder()
        ).getTemplates();
    }
}
