package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: CompositeGeneratedAdaptersObserver.kt */
/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements j {

    /* renamed from: b, reason: collision with root package name */
    public final e[] f3424b;

    public CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        zf.i.checkNotNullParameter(eVarArr, "generatedAdapters");
        this.f3424b = eVarArr;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        q qVar = new q();
        e[] eVarArr = this.f3424b;
        for (e eVar : eVarArr) {
            eVar.callMethods(lVar, event, false, qVar);
        }
        for (e eVar2 : eVarArr) {
            eVar2.callMethods(lVar, event, true, qVar);
        }
    }
}
