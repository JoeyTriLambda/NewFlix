package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineName.kt */
/* loaded from: classes2.dex */
public final class c extends qf.a {

    /* renamed from: m, reason: collision with root package name */
    public static final a f15311m = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f15312b;

    /* compiled from: CoroutineName.kt */
    public static final class a implements CoroutineContext.b<c> {
        public a(zf.f fVar) {
        }
    }

    public c(String str) {
        super(f15311m);
        this.f15312b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && zf.i.areEqual(this.f15312b, ((c) obj).f15312b);
    }

    public int hashCode() {
        return this.f15312b.hashCode();
    }

    public String toString() {
        return ac.c.n(new StringBuilder("CoroutineName("), this.f15312b, ')');
    }
}
