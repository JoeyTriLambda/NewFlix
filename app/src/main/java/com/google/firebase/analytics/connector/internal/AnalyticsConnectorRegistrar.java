package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import f9.d;
import g8.f;
import i8.a;
import java.util.Arrays;
import java.util.List;
import l8.b;
import l8.g;
import l8.l;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
@Keep
@KeepForSdk
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @KeepForSdk
    @SuppressLint({"MissingPermission"})
    public List<b<?>> getComponents() {
        return Arrays.asList(b.builder(a.class).add(l.required((Class<?>) f.class)).add(l.required((Class<?>) Context.class)).add(l.required((Class<?>) d.class)).factory(new g() { // from class: j8.a
            @Override // l8.g
            public final Object create(l8.d dVar) {
                return i8.b.getInstance((g8.f) dVar.get(g8.f.class), (Context) dVar.get(Context.class), (f9.d) dVar.get(f9.d.class));
            }
        }).eagerInDefaultApp().build(), o9.g.create("fire-analytics", "21.6.1"));
    }
}
