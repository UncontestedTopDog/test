package com.yy.android.lib.reflect;

import java.lang.reflect.Field;

class FinalDemo {
    /**常量：默认值null*/
    private final String v1 = null;
    /**常量：默认值v4*/
    private final String v2 = "v2";
    private final ChildA v3 = new ChildA("kancy");
    private final ChildA v4 = null;

    public FinalDemo() {
    }

    public static void main(String[] args) throws Exception {
        FinalDemo finalDemo = new FinalDemo();
        Field f3 = finalDemo.getClass().getDeclaredField("v3");
        f3.setAccessible(true);
        ChildA oldValue = finalDemo.getV3();
        System.out.println("v3 改变前的值：" + finalDemo.getV3()+", " );
        f3.set(finalDemo, new ChildA("pmm"));
        System.out.println("v3 改变后的值（对象取值）：" + finalDemo.getV3()+", ");
        System.out.println("v3 改变后的值（反射取值）：" + f3.get(finalDemo)+", ");
        // 地址已经发生变化
        System.out.println(oldValue == finalDemo.getV3());

    }

    public ChildA getV3() {
        return v3;
    }

    public static class ChildA {
        private String name;

        public ChildA(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}