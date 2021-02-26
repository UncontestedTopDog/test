package com.yy.android.myapplicationaaq.diff;

public interface Diff {
    boolean areItemsTheSame(Diff diff);
    boolean areContentsTheSame(Diff diff);
}