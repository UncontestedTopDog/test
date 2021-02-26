// package com.yy.android.myapplicationaaq.board;
//
// import android.content.BroadcastReceiver;
// import android.content.Context;
// import android.content.Intent;
// import android.content.IntentFilter;
// import android.widget.Toast;
//
// public class ScreenOnOffReceiver {
//     public static void ReceiverScreenOnOff(Context context) {
//         IntentFilter screenOffFilter = new IntentFilter();
//         screenOffFilter.addAction(Intent.ACTION_SCREEN_OFF);
//         screenOffFilter.addAction(Intent.ACTION_SCREEN_ON);
//         BroadcastReceiver mScreenOnOffReceiver = new BroadcastReceiver() {
//
//             @Override
//             public void onReceive(Context context, Intent intent) {
//                 // TODO Auto-generated method stub
//                 String action = intent.getAction();
//                 if (action.equals(Intent.ACTION_SCREEN_OFF)) {
//
//                     Toast.makeText(context, "接收屏幕熄灭广播", Toast.LENGTH_SHORT).show();
//
//                 }
//                 if (action.equals(Intent.ACTION_SCREEN_ON)) {
//
//                     Toast.makeText(context, "接收屏幕点亮广播", Toast.LENGTH_SHORT).show();
//                 }
//
//
//             }
//
//         };
//         /**
//          * context.getApplicationContext()
//          * 在广播中注册广播时候需要注意，防止context 为空 ，引起空指针异常
//          * **/
// // 2.动态注册广播的方法
//         context.registerReceiver(mScreenOnOffReceiver, screenOffFilter);
//
//     }
// }
