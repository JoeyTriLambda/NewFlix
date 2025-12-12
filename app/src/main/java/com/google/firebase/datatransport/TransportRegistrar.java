package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import l8.b;
import l8.d;
import l8.l;
import m8.g;
import n4.f;
import o4.a;
import q4.s;

@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$0(d dVar) {
        s.initialize((Context) dVar.get(Context.class));
        return s.getInstance().newFactory(a.f16998f);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b<?>> getComponents() {
        return Arrays.asList(b.builder(f.class).name(LIBRARY_NAME).add(l.required((Class<?>) Context.class)).factory(new g(4)).build(), o9.g.create(LIBRARY_NAME, "18.1.8"));
    }
}
