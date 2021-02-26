package com.yy.android.myapplicationaaq.able;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

// Parcelable 是Android特有的序列化的
public class AbleClass implements Parcelable {

    private int id;

    private String name;

    public void test(){
        Bundle bundle = new Bundle();
    }

    protected AbleClass(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<AbleClass> CREATOR = new Creator<AbleClass>() {
        @Override
        public AbleClass createFromParcel(Parcel in) {
            return new AbleClass(in);
        }

        @Override
        public AbleClass[] newArray(int size) {
            return new AbleClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
