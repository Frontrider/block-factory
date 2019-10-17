package hu.frontrider.blockfactory.core.templates.impl;

import hu.frontrider.blockfactory.core.templates.ItemTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DefaultItemTemplate implements ItemTemplate {


    private int count = 64;
    private List<String>  type = Collections.singletonList("NORMAL");
    private String materialID ="";
    private boolean isColored = false;

    @Override
    public int maxCount() {
        return count;
    }

    @Override
    public List<String> getType() {
        return type;
    }

    @Override
    public String getMaterialID() {
        return materialID;
    }

    @Override
    public boolean isColored() {
        return isColored;
    }


    public DefaultItemTemplate setCount(int count) {
        this.count = count;
        return this;
    }

    public DefaultItemTemplate setType(List<String> types) {
        this.type = types;
        return this;
    }


    public DefaultItemTemplate setMaterialID(String materialID) {
        this.materialID = materialID;
        return this;
    }

    public DefaultItemTemplate setColored(boolean colored) {
        isColored = colored;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultItemTemplate that = (DefaultItemTemplate) o;
        return count == that.count &&
                isColored == that.isColored &&
                Objects.equals(type, that.type) &&
                Objects.equals(materialID, that.materialID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, type, materialID, isColored);
    }

    @Override
    public String toString() {
        return "DefaultItemTemplate{" +
                "count=" + count +
                ", type=" + type +
                ", materialID='" + materialID + '\'' +
                ", isColored=" + isColored +
                '}';
    }
}
