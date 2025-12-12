package com.google.android.gms.cast.framework;

import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zza implements OnSuccessListener {
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        CastContext castContext = (CastContext) obj;
        ArrayList arrayList = CastButtonFactory.f6333a;
        if (castContext != null && castContext.getMergedSelector() == null) {
            throw null;
        }
        throw null;
    }
}
