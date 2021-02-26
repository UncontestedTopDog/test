/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yy.android.myapplicationaaq.leakcanary;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ActivityWeakReference extends WeakReference<Object> {
    public final String key;
    public final String name;

    public ActivityWeakReference(Object referent, String key, String name,
                                 ReferenceQueue<Object> referenceQueue) {
        super(referent, referenceQueue);
        this.key = key;
        this.name = name;
    }
}