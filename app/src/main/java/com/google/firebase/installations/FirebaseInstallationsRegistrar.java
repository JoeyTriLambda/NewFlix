package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import g8.f;
import g9.e;
import i9.c;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k8.b;
import l8.d;
import l8.l;
import l8.r;
import m8.g;
import m8.h;

@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$getComponents$0(d dVar) {
        return new a((f) dVar.get(f.class), dVar.getProvider(g9.f.class), (ExecutorService) dVar.get(r.qualified(k8.a.class, ExecutorService.class)), h.newSequentialExecutor((Executor) dVar.get(r.qualified(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<l8.b<?>> getComponents() {
        return Arrays.asList(l8.b.builder(c.class).name(LIBRARY_NAME).add(l.required((Class<?>) f.class)).add(l.optionalProvider(g9.f.class)).add(l.required((r<?>) r.qualified(k8.a.class, ExecutorService.class))).add(l.required((r<?>) r.qualified(b.class, Executor.class))).factory(new g(5)).build(), e.create(), o9.g.create(LIBRARY_NAME, "17.2.0"));
    }
}
