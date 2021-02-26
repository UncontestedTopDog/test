package com.yy.android.myapplicationaaq.databinding;

import androidx.databinding.ObservableField;

public class DataBean2 {
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> userPwd  = new ObservableField<>();

    @Override
    public String toString() {
        return "DataBean1{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
