package com.yy.android.myapplicationaaq.memory;

public class Test {
    private String s;
    private String a;
    private String b;

    public Test(String s, String a, String b) {
        for (int i = 0; i < 300; i++) {
            this.s += s;
            this.a += a;
            this.b += b;
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "s='" + s + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
