package hu.frontrider.blockfactory.templates;

/**
 * Stores enough data to create a new item.
* */
public interface ItemTemplate {
    int maxCount();
    String getType();
}
