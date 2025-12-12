package com.google.android.gms.common.api.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaa extends LifecycleCallback {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f7129b;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = this.f7129b;
            this.f7129b = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
