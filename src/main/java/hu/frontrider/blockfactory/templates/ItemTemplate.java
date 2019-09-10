package hu.frontrider.blockfactory.templates;

import hu.frontrider.blockfactory.data.ItemType;

/**
 * Stores enough data to create a new item.
* */
public interface ItemTemplate {
    int maxCount();
    ItemType getType();
}
