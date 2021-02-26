package com.yy.android.lib.proxy;

public class UserManagerImpl implements UserManager {
    private static final String TAG = "UserManagerImpl";

    @Override
    public void addUser(String userId, String userName) {
        System.out.println(TAG + ".addUser");
    }

    @Override
    public void delUser(String userId) {
        System.out.println(TAG + ".delUser");
    }

    @Override
    public String findUser(String userId) {
        System.out.println(TAG + ".findUser");
        return "User";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.println(TAG + ".modifyUser");
    }
}
