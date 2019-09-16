package hu.frontrider.blockfactory.fileprovider;

import java.io.File;

public class DirectoryManager {

    private static DirectoryManager INSTANCE = new DirectoryManager();

    private File blockFolder = new File("./block-factory/blocks");
    private File itemFolder = new File("./block-factory/items");

    private DirectoryManager(){}

    public static DirectoryManager getINSTANCE() {
        return INSTANCE;
    }

    public File getBlockFolder(){
        if(!blockFolder.exists()) {
            if(!blockFolder.mkdirs()){
                throw new DirectoryStateException(blockFolder);
            }
        }
        return blockFolder;
    }

    public File getItemFolder(){
        if(!itemFolder.exists()) {
            if(!itemFolder.mkdirs()){
                throw new DirectoryStateException(itemFolder);
            }
        }

        return itemFolder;
    }

    class DirectoryStateException extends RuntimeException{
        DirectoryStateException(File directory){
            super("Could not create directory: "+directory.getAbsolutePath());
        }
    }

}
