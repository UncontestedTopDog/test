package com.yy.android.myapplicationaaq.leakcanary;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class VeryBigWeakReference extends WeakReference<VeryBig> {

    public String id;
    public VeryBigWeakReference(VeryBig veryBig,
                                ReferenceQueue<? super VeryBig> referenceQueue) {
        super(veryBig, referenceQueue);
        this.id = veryBig.id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }
}
