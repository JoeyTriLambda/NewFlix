package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.kt */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f821a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f822b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public yf.a<lf.h> f823c;

    public k(boolean z10) {
        this.f821a = z10;
    }

    public final void addCancellable(c cVar) {
        zf.i.checkNotNullParameter(cVar, "cancellable");
        this.f822b.add(cVar);
    }

    public final yf.a<lf.h> getEnabledChangedCallback$activity_release() {
        return this.f823c;
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(b bVar) {
        zf.i.checkNotNullParameter(bVar, "backEvent");
    }

    public void handleOnBackStarted(b bVar) {
        zf.i.checkNotNullParameter(bVar, "backEvent");
    }

    public final boolean isEnabled() {
        return this.f821a;
    }

    public final void remove() {
        Iterator<T> it = this.f822b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void removeCancellable(c cVar) {
        zf.i.checkNotNullParameter(cVar, "cancellable");
        this.f822b.remove(cVar);
    }

    public final void setEnabled(boolean z10) {
        this.f821a = z10;
        yf.a<lf.h> aVar = this.f823c;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(yf.a<lf.h> aVar) {
        this.f823c = aVar;
    }

    public void handleOnBackCancelled() {
    }
}
