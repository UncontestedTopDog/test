package com.yy.android.myapplicationaaq.hook;

import android.util.Log;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * hook的辅助类
 * <p>
 * hook的动作放在这里
 */

public class HookSetOnClickListenerHelper {

    /**
     * hook的核心代码
     * <p>
     * 这个方法的唯一目的：用自己的点击事件，替换掉 View原来的点击事件
     *
     * @param v hook的范围仅限于这个view
     */

    public static void hook(final View v) {
        try {
            Method method = View.class.getDeclaredMethod("getListenerInfo");
            method.setAccessible(true); //由于getListenerInfo()方法并不是public的，所以要加这个代码来保证访问权限
            Object mListenerInfo = method.invoke(v);    //这里拿到的就是mListenerInfo对象，也就是点击事件的持有者
            Class<?> listenerInfoClz =
                    Class.forName("android.view.View$ListenerInfo"); // 这是内部类的表示方法
            Field field = listenerInfoClz.getDeclaredField("mOnClickListener");
            field.setAccessible(true);
            final View.OnClickListener onClickListenerInstance =
                    (View.OnClickListener) field.get(mListenerInfo);    //取得真实的mOnClickListener对象
            Object proxyOnClickListener =
                    new ProxyOnClickListener(onClickListenerInstance);
            // Object proxyOnClickListener = Proxy
            //         .newProxyInstance(v.getClass().getClassLoader(),
            //                 new Class[]{View.OnClickListener.class}, new InvocationHandler() {
            //
            //                     @Override
            //                     public Object invoke(Object proxy, Method method, Object[] args)
            //                             throws Throwable {
            //                         Log.d("HookSetOnClickListener", "点击事件被hook到了"); //加入自己的逻辑
            //                         return method
            //                                 .invoke(onClickListenerInstance, args); //执行被代理的对象的逻辑
            //                     }
            //                 });

            //3\. 用我们自己的点击事件代理类，设置到"持有者"中
            field.set(mListenerInfo, proxyOnClickListener);
            // final View.OnClickListener onClickListenerInstance2 =
            //         (View.OnClickListener) field.get(mListenerInfo);
            // Log.d("HookSetOnClickListener", "view is : " + onClickListenerInstance2.getClass().getName());
            //完成
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hook(Hook2Activity activity) {
        try {

            Class clazz = activity.getClass();
            Field[] fields = clazz.getDeclaredFields();
            List<Field> fieldList = new ArrayList<>();
            for (Field field : fields) {
                if (field.isAnnotationPresent(HookClick.class)) {
                    fieldList.add(field);
                }
            }
            if (fieldList.size() == 0) {
                Log.d("HookSetOnClickListener", "field is null");
                return;
            }
            ViewAnno[] views = new ViewAnno[fieldList.size()];
            for (int i = 0; i < fieldList.size(); i++) {
                fieldList.get(i).setAccessible(true);
                View view = (View) fieldList.get(i).get(activity);
                views[i] = new ViewAnno(view,fieldList.get(i).getAnnotation(HookClick.class));
            }
            hook(views);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void hook(final ViewAnno[] views) {
        try {
            Method method = View.class.getDeclaredMethod("getListenerInfo");
            method.setAccessible(true); //由于getListenerInfo()方法并不是public的，所以要加这个代码来保证访问权限
            Class<?> listenerInfoClz =
                    Class.forName("android.view.View$ListenerInfo"); // 这是内部类的表示方法
            Field field = listenerInfoClz.getDeclaredField("mOnClickListener");
            field.setAccessible(true);
            for (ViewAnno view : views) {
                Object mListenerInfo = method.invoke(view.view);    //这里拿到的就是mListenerInfo对象，也就是点击事件的持有者
                final View.OnClickListener onClickListenerInstance =
                        (View.OnClickListener) field.get(mListenerInfo);    //取得真实的mOnClickListener对象
                if (onClickListenerInstance == null) continue;
                Object proxyOnClickListener = Proxy
                        .newProxyInstance(view.view.getClass().getClassLoader(),
                                new Class[]{View.OnClickListener.class}, new InvocationHandler() {
                                    @Override
                                    public Object invoke(Object proxy, Method method, Object[] args)
                                            throws Throwable {
                                        HookClick hookClick  = (HookClick) view.annotation;
                                        Log.d("HookSetOnClickListener",
                                                "点击事件被hook到了"+view.view.getId()+hookClick.name());
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

    // // 还真是这样,自定义代理类
    static class ProxyOnClickListener implements View.OnClickListener {
        View.OnClickListener oriLis;

        public ProxyOnClickListener(View.OnClickListener oriLis) {
            this.oriLis = oriLis;
        }

        @Override
        public void onClick(View v) {
            Log.d("HookSetOnClickListener", "点击事件被hook到了"+v);
            if (oriLis != null) {
                oriLis.onClick(v);
            }
        }
    }
}
