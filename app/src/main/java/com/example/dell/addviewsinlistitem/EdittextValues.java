package com.example.dell.addviewsinlistitem;

/**
 * Created by dell on 2/4/2016.
 */
public class EdittextValues {
    int ids, etIds;
    String value;

    public EdittextValues(int ids, int etIds, String value) {
        this.ids = ids;
        this.etIds = etIds;
        this.value = value;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public int getEtIds() {
        return etIds;
    }

    public void setEtIds(int etIds) {
        this.etIds = etIds;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
