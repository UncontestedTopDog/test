package com.yy.android.lib.genericity;

public class GenericityClass<T> {
    T t;
    public T getValue() {
        return t;
    }

    public void setValue(T t) {
        this.t = t;
    }

    public T test(T t) {
        return this.t;
    }
}
