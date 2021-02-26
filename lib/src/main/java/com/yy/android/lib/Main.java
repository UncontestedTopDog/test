package com.yy.android.lib;

import com.yy.android.lib.test.TestF;
import com.yy.android.lib.test.TestS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        TestS s = new TestS();
        TestF f = s;
        f.test();
        f.test2();
    }

}
