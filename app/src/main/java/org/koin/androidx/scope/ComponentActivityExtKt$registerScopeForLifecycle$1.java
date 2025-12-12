package org.koin.androidx.scope;

import androidx.lifecycle.b;
import androidx.lifecycle.c;
import androidx.lifecycle.l;
import zf.i;

/* compiled from: ComponentActivityExt.kt */
/* loaded from: classes2.dex */
public final class ComponentActivityExtKt$registerScopeForLifecycle$1 implements c {
    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onCreate(l lVar) {
        b.a(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public void onDestroy(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        b.b(this, lVar);
        throw null;
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onPause(l lVar) {
        b.c(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onResume(l lVar) {
        b.d(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onStart(l lVar) {
        b.e(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onStop(l lVar) {
        b.f(this, lVar);
    }
}
