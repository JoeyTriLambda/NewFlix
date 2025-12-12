package p3;

import java.util.Arrays;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class l<V> {

    /* renamed from: a, reason: collision with root package name */
    public final V f17532a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f17533b;

    public l(V v10) {
        this.f17532a = v10;
        this.f17533b = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (getValue() != null && getValue().equals(lVar.getValue())) {
            return true;
        }
        if (getException() == null || lVar.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public Throwable getException() {
        return this.f17533b;
    }

    public V getValue() {
        return this.f17532a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }

    public l(Throwable th2) {
        this.f17533b = th2;
        this.f17532a = null;
    }
}
