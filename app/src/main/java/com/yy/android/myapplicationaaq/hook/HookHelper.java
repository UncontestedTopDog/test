package com.yy.android.myapplicationaaq.hook;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yy.android.myapplicationaaq.databinding.ActivityHookBinding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * hook的辅助类
 * <p>
 * hook的动作放在这里
 */

public class HookHelper {

    public static void hook(ActivityHookBinding binding) {
        try {
        Class clazz = binding.getClass();
        Field[] fields = clazz.getFields();
        List<Field> fieldList = new ArrayList<>();
        for (Field field : fields) {
            if (field.getType().getName().equals(Button.class.getName())) {
                fieldList.add(field);
            }
        }
            if (fieldList.size() == 0) {
                Log.d("HookSetOnClickListener", "field is null");
                return;
            }
        View[] views = new View[fieldList.size()];
        for (int i = 0; i < fieldList.size(); i++) {
            fieldList.get(i).setAccessible(true);
            views[i] = (View) fieldList.get(i).get(binding);
        }
            for (View view : views) {
                Log.d("HookSetOnClickListener", "field is null"+view.toString());
            }
        hook(views);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void hook(final View[] views) {
        try {
            Method method = View.class.getDeclaredMethod("getListenerInfo");
            method.setAccessible(true); //由于getListenerInfo()方法并不是public的，所以要加这个代码来保证访问权限
            Class<?> listenerInfoClz =
                    Class.forName("android.view.View$ListenerInfo"); // 这是内部类的表示方法
            Field field = listenerInfoClz.getDeclaredField("mOnClickListener");
            field.setAccessible(true);
            for (View view : views) {
                Object mListenerInfo = method.invoke(view);    //这里拿到的就是mListenerInfo对象，也就是点击事件的持有者
                final View.OnClickListener onClickListenerInstance =
                        (View.OnClickListener) field.get(mListenerInfo);    //取得真实的mOnClickListener对象
                if (onClickListenerInstance == null) continue;
                Object proxyOnClickListener = Proxy
                        .newProxyInstance(view.getClass().getClassLoader(),
                                new Class[]{View.OnClickListener.class}, new InvocationHandler() {
                                    @Override
                                    public Object invoke(Object proxy, Method method, Object[] args)
                                            throws Throwable {
                                        Log.d("HookSetOnClickListener",
                                                "点击事件被hook到了"
                                                        +view.getContext().getResources().getResourceEntryName(view.getId()));
                                        //加入自己的逻辑
                                        return method
                                                .invoke(onClickListenerInstance, args); //执行被代理的对象的逻辑
                                    }
                                });
                field.set(mListenerInfo, proxyOnClickListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ViewAnno {
        public View view;
        public Annotation annotation;

        public ViewAnno(View view, Annotation annotation) {
            this.view = view;
            this.annotation = annotation;
        }
    }
}
