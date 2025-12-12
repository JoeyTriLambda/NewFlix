package com.unity3d.services.core.configuration;

import android.content.Context;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.List;
import lf.h;
import mf.k;
import n2.a;
import zf.i;

/* compiled from: AdsSdkInitializer.kt */
/* loaded from: classes2.dex */
public final class AdsSdkInitializer implements a<h> {
    @Override // n2.a
    public /* bridge */ /* synthetic */ h create(Context context) {
        create2(context);
        return h.f16056a;
    }

    @Override // n2.a
    public List<Class<? extends a<?>>> dependencies() {
        return k.emptyList();
    }

    /* renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(Context context) {
        i.checkNotNullParameter(context, "context");
        ClientProperties.setApplicationContext(context.getApplicationContext());
    }
}
