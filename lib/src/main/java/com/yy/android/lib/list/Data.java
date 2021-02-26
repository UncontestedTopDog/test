package com.yy.android.lib.list;

public class Data {
    public String url;
    public String name;

    public Data(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
