package org.koin.androidx.scope;

import androidx.lifecycle.b;
import androidx.lifecycle.c;
import androidx.lifecycle.l;
import zf.i;

/* compiled from: LifecycleViewModelScopeDelegate.kt */
/* loaded from: classes2.dex */
public final class LifecycleViewModelScopeDelegate$2 implements c {
    @Override // androidx.lifecycle.c
    public void onCreate(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        throw null;
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onDestroy(l lVar) {
        b.b(this, lVar);
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
