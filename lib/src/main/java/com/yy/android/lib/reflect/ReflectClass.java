package com.yy.android.lib.reflect;

public class ReflectClass {
    private String apple;
    private String banana;
    private final int val;

    public ReflectClass(String val) {
        this.val = 10;
    }

    // public ReflectClass() {
    // }
    //
    // public ReflectClass(String apple, String banana) {
    //     this.apple = apple;
    //     this.banana = banana;
    // }

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getBanana() {
        return banana;
    }

    public void setBanana(String banana) {
        this.banana = banana;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "ReflectClass{" +
                "apple='" + apple + '\'' +
                ", banana='" + banana + '\'' +
                '}';
    }

    private void haha(String haha) {
        System.out.println(haha + "   haha "+ apple+ "   "+banana);
    }

    public void xixi(String xixi) {
        System.out.println(xixi + "   xixi "+ apple+ "   "+banana);
    }
}
