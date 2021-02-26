package com.yy.android.myapplicationaaq.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class BlockConstants {
    public static final int SAMPLE_DELAY = 1000;
    public static final SimpleDateFormat TIME_FORMATTER =
            new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static final String SEPARATOR = "\r\n";
    public static final int DEFAULT_MAX_ENTRY_COUNT = 100;
}
