package hu.frontrider.blockfactory.fileprovider;

import com.google.gson.Gson;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class FileTemplateHelper<T> {

    private TemplateFunction<T> templateCreator;
    private File rootFolder;

    public FileTemplateHelper(TemplateFunction<T> templateCreator, File rootFolder) {
        this.templateCreator = templateCreator;
        this.rootFolder = rootFolder;
    }


    public Map<Identifier, T> getTemplates() {

        Map<Identifier, T> result = new HashMap<>();

        for (String childFile : rootFolder.list()) {
            File namespaceDir = new File(rootFolder.getAbsolutePath()+"/"+childFile);
            //the directory bellow the block folder is the namespace
            if (!namespaceDir.isFile()) {
                File[] files = namespaceDir.listFiles((blockFile, s) -> !blockFile.getAbsolutePath().endsWith(".json"));
                //if there are no files ignore
                if (files == null)
                    continue;

                for (File file : files) {
                    try {
                        result.put(new Identifier(namespaceDir.getName(), file.getName().replace(".json","")), templateCreator.get(file));

                    } catch (FileNotFoundException ignored) {

                    }
                }
            }
        }
        return result;
    }

    interface TemplateFunction<T>{
        T get(File source) throws FileNotFoundException;
    }
}
