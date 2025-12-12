package kotlin;

import java.io.Serializable;
import zf.f;
import zf.i;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f15189m = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15190b;

    /* compiled from: Result.kt */
    public static final class Failure implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f15191b;

        public Failure(Throwable th2) {
            i.checkNotNullParameter(th2, "exception");
            this.f15191b = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Failure) {
                if (i.areEqual(this.f15191b, ((Failure) obj).f15191b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f15191b.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f15191b + ')';
        }
    }

    /* compiled from: Result.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
    }

    public /* synthetic */ Result(Object obj) {
        this.f15190b = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m58boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m60equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && i.areEqual(obj, ((Result) obj2).m66unboximpl());
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m61exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f15191b;
        }
        return null;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m62hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m63isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m64isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m65toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m60equalsimpl(this.f15190b, obj);
    }

    public int hashCode() {
        return m62hashCodeimpl(this.f15190b);
    }

    public String toString() {
        return m65toStringimpl(this.f15190b);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m66unboximpl() {
        return this.f15190b;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m59constructorimpl(Object obj) {
        return obj;
    }
}
