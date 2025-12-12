package nh;

import lf.h;
import yf.l;
import zf.f;
import zf.i;

/* compiled from: Callbacks.kt */
/* loaded from: classes2.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final l<T, h> f16834a;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && i.areEqual(this.f16834a, ((b) obj).f16834a);
    }

    public final l<T, h> getOnClose() {
        return this.f16834a;
    }

    public int hashCode() {
        l<T, h> lVar = this.f16834a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public String toString() {
        return "Callbacks(onClose=" + this.f16834a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(l<? super T, h> lVar) {
        this.f16834a = lVar;
    }

    public /* synthetic */ b(l lVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : lVar);
    }
}
