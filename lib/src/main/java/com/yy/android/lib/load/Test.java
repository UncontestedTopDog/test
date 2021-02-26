package com.yy.android.lib.load;

public class Test extends Test2 {
    public String j = "Test j";
    public static String i = "Test static i";

    static {
        System.out.println("Test static {}");
        System.out.println(Test.i);
    }

    {
        System.out.println("Test {}");
        System.out.println(this.j);
    }

    public Test() {
        System.out.println("Test Test() ");
        {
            System.out.println("Test Test() {}");
        }
    }

    public void test() {
        System.out.println("Test test()");
    }

    public static void test1() {
        System.out.println("Test static test1()");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
// Test.test1();
    }
}

class Test2 {
    public String j = "Test Parent j";
    public static String i = "Test Parent sattic i";

    static {
        System.out.println(Test2.i);
        System.out.println("Test Parent static {}");
    }

    {
        System.out.println("Test Parent {}");
        System.out.println(this.j);
    }

    public Test2() {
        System.out.println("Test Parent Test2");
        {
            System.out.println("Test Parent Test2 {}");
        }
    }

    public void test() {
        System.out.println("Test Parent test()");
    }

    public static void test1() {
        System.out.println("Test Parent static test1()");
    }
}
