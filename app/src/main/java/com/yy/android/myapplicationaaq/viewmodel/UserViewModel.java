package com.yy.android.myapplicationaaq.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();

    private MutableLiveData<List<RemoteUserData>> set = new MutableLiveData<>();
    Random random = new Random();

    public UserViewModel() {
        set.setValue(new ArrayList<>());
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<List<RemoteUserData>> getSet() {
        return set;
    }

    public void test() {
        int a = random.nextInt(5);
        RemoteUserData remoteUserData = new RemoteUserData(a);
        if (set.getValue().contains(remoteUserData)) {
            set.getValue().remove(remoteUserData);
        } else {
            set.getValue().add(remoteUserData);
        }
        set.postValue(set.getValue());
    }
}
