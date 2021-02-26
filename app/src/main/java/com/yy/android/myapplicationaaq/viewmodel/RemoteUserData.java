package com.yy.android.myapplicationaaq.viewmodel;

import java.util.Objects;

public class RemoteUserData {
    private long uid;

    public RemoteUserData(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public boolean areItemsTheSame(RemoteUserData item) {
        return uid == item.uid;
    }

    public boolean areContentsTheSame(RemoteUserData item) {
        return uid == item.uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RemoteUserData that = (RemoteUserData) o;
        return uid == that.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    @Override
    public String toString() {
        return "RemoteUserData{" +
                "uid=" + uid +
                '}';
    }
}
