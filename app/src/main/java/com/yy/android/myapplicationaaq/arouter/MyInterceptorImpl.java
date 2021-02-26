package com.yy.android.myapplicationaaq.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.yy.android.myapplicationaaq.App;

// 在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(name = "login", priority = 5)
public class MyInterceptorImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        boolean isLogin = App.login;

        if (isLogin) { // 如果已经登录不拦截
            callback.onContinue(postcard);
        } else {  // 如果没有登录
            Log.i("AAAA2", "onInterrupt  " + path);
            callback.onInterrupt(null);
        }
    }

    // Executors

    @Override
    public void init(Context context) {//此方法只会走一次
        Log.e("AAAA", "路由登录拦截器初始化成功");
    }

}
