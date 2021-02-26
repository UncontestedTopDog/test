package com.yy.android.myapplicationaaq.utils;

import static android.os.Looper.getMainLooper;

public class BlockUtils {

    public static void init() {
        getMainLooper().setMessageLogging(new BlockPrinter());
    }

}
