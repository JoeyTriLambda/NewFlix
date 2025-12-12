package h7;

import android.view.ViewTreeObserver;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.floatingactionbutton.d f12954b;

    public c(com.google.android.material.floatingactionbutton.d dVar) {
        this.f12954b = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        com.google.android.material.floatingactionbutton.d dVar = this.f12954b;
        float rotation = dVar.f9160q.getRotation();
        if (dVar.f9153j == rotation) {
            return true;
        }
        dVar.f9153j = rotation;
        dVar.m();
        return true;
    }
}
