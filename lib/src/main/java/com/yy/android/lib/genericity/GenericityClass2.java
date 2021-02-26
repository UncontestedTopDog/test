package com.yy.android.lib.genericity;

public class GenericityClass2<T extends String> {
    T t;
    public T getValue() {
        return t;
    }

    public void setValue(T t) {
        this.t = t;
    }
}
