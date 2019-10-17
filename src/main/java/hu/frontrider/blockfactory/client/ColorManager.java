package hu.frontrider.blockfactory.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ColorManager {
    private static ColorManager ourInstance = new ColorManager();

    public static ColorManager getInstance() {
        return ourInstance;
    }

    Map<Identifier, JsonObject> itemColorDataMap = new HashMap<>();
    private Map<Identifier, JsonObject> blockColorDataMap = new HashMap<>();
    private ColorManager() {
    }

    public enum Type{
        ITEM,BLOCK
    }

    public int getColor(int layer, Identifier id,Type type){
        ResourceManager resourceManager = MinecraftClient.getInstance().getResourceManager();

        JsonObject colorData = null;
        if(type == Type.ITEM)
        if(!itemColorDataMap.containsKey(id)){
            Identifier identifier = new Identifier(id.getNamespace(), "colors/item/" + id.getPath());
            if(resourceManager.containsResource(identifier)){
                try {
                    Resource resource = resourceManager.getResource(identifier);

                    colorData = new Gson().fromJson(new InputStreamReader(resource.getInputStream()), JsonObject.class);
                    itemColorDataMap.put(id,colorData);
                } catch (IOException e) {
                    return 16777215;
                }
            }
        }else{
            colorData = itemColorDataMap.get(id);
        }
        if(type == Type.BLOCK)
            if(!blockColorDataMap.containsKey(id)){
                Identifier identifier = new Identifier(id.getNamespace(), "colors/block/" + id.getPath());
                if(resourceManager.containsResource(identifier)){
                    try {
                        Resource resource = resourceManager.getResource(identifier);

                        colorData = new Gson().fromJson(new InputStreamReader(resource.getInputStream()), JsonObject.class);
                        blockColorDataMap.put(id,colorData);
                    } catch (IOException e) {
                        return 16777215;
                    }
                }
            }else{
                colorData = blockColorDataMap.get(id);
            }
        if(colorData == null)
            return 16777215;

        String layerName = String.valueOf(layer);
        if(colorData.has(layerName)){
            return colorData.getAsJsonPrimitive(layerName).getAsInt();
        }

        return 16777215;
    }

    public void clear() {
        itemColorDataMap.clear();
        blockColorDataMap.clear();
    }
}
