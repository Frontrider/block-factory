package hu.frontrider.blockfactory.core.templates;

import java.util.List;

/**
 * Stores enough data to create a new item.
* */
public interface ItemTemplate {
    int maxCount();
    List<String> getType();
    String getMaterialID();
    boolean isColored();

}
