package com.example.dell.addviewsinlistitem;

import java.util.ArrayList;

/**
 * Created by dell on 2/4/2016.
 */
public class ListItemModel {

    String title;
    ArrayList<EdittextValues> arrayList = new ArrayList<>();

    public ListItemModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<EdittextValues> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<EdittextValues> arrayList) {
        this.arrayList = arrayList;
    }
}
