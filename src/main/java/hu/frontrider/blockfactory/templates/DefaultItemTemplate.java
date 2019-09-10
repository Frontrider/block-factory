package hu.frontrider.blockfactory.templates;

import hu.frontrider.blockfactory.data.ItemType;

import java.util.Objects;

public class DefaultItemTemplate implements ItemTemplate {


    private int count = 64;
    private ItemType type = ItemType.NORMAL;

    @Override
    public int maxCount() {
        return count;
    }

    @Override
    public ItemType getType() {
        return type;
    }


    public DefaultItemTemplate setCount(int count) {
        this.count = count;
        return this;
    }

    public DefaultItemTemplate setType(ItemType type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultItemTemplate that = (DefaultItemTemplate) o;
        return count == that.count &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, type);
    }

    @Override
    public String toString() {
        return "DefaultItemTemplate{" +
                "count=" + count +
                ", type=" + type +
                '}';
    }
}
