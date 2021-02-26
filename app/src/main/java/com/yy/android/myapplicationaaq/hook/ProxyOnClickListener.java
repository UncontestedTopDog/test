package com.yy.android.myapplicationaaq.hook;

import android.util.Log;
import android.view.View;
public class ProxyOnClickListener implements View.OnClickListener{

    View.OnClickListener oriLis;

    public ProxyOnClickListener(View.OnClickListener oriLis) {
        this.oriLis = oriLis;
    }

    @Override
    public void onClick(View v) {
        Log.d("HookProxyClickListener","------------Click----------------");
        if (oriLis != null) {
            oriLis.onClick(v);
        }
    }
}
