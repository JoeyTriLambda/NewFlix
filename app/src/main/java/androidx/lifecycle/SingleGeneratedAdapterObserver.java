package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SingleGeneratedAdapterObserver.kt */
/* loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements j {

    /* renamed from: b, reason: collision with root package name */
    public final e f3474b;

    public SingleGeneratedAdapterObserver(e eVar) {
        zf.i.checkNotNullParameter(eVar, "generatedAdapter");
        this.f3474b = eVar;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        e eVar = this.f3474b;
        eVar.callMethods(lVar, event, false, null);
        eVar.callMethods(lVar, event, true, null);
    }
}
