package com.yy.android.lib.proxy;

import com.yy.android.lib.proxy.dynamicproxy.LogHandler;
import com.yy.android.lib.proxy.staticproxy.UserManagerImplProxy;

public class ProxyClass {
    public static void main(String[] args) {
        // UserManagerImpl impl = new UserManagerImpl();
        // UserManagerImplProxy proxy = new UserManagerImplProxy(impl);
        // proxy.addUser("","");
        // proxy.delUser("");
        // proxy.findUser("");
        // proxy.modifyUser("","");

        LogHandler logHandler = new LogHandler();
        UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.addUser("AAA","!!!");
    }
}
