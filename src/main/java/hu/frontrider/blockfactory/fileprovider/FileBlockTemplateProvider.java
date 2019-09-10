package hu.frontrider.blockfactory.fileprovider;

import com.google.gson.Gson;
import hu.frontrider.blockfactory.templateprovider.BlockTemplateProvider;
import hu.frontrider.blockfactory.templates.BlockTemplate;
import hu.frontrider.blockfactory.templates.DefaultBlockTemplate;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.util.Map;

/**
 * reads json files from the run folder.
 */
public class FileBlockTemplateProvider implements BlockTemplateProvider {
    private Gson gson = new Gson();

    @Override
    public Map<Identifier, BlockTemplate> getTemplates() {
        return new FileTemplateHelper<BlockTemplate>(
                (file)-> gson.fromJson(new FileReader(file), DefaultBlockTemplate.class),
                DirectoryManager.getINSTANCE().getBlockFolder()
        ).getTemplates();
    }
}
