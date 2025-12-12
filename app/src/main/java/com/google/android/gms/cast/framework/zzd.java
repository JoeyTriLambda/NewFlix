package com.google.android.gms.cast.framework;

import com.google.android.gms.internal.cast.zzml;
import com.google.android.gms.tasks.OnSuccessListener;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzd implements OnSuccessListener {
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        synchronized (CastButtonFactory.f6336d) {
            CastButtonFactory.f6335c.add(new WeakReference(null));
        }
        com.google.android.gms.internal.cast.zzo.zzd(zzml.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
