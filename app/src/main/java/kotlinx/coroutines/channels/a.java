package kotlinx.coroutines.channels;

import zf.f;
import zf.i;

/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public final class a<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f15358b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final c f15359c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final Object f15360a;

    /* compiled from: Channel.kt */
    /* renamed from: kotlinx.coroutines.channels.a$a, reason: collision with other inner class name */
    public static final class C0181a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f15361a;

        public C0181a(Throwable th2) {
            this.f15361a = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0181a) {
                if (i.areEqual(this.f15361a, ((C0181a) obj).f15361a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Throwable th2 = this.f15361a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.a.c
        public String toString() {
            return "Closed(" + this.f15361a + ')';
        }
    }

    /* compiled from: Channel.kt */
    public static final class b {
        public b(f fVar) {
        }

        /* renamed from: closed-JP2dKIU, reason: not valid java name */
        public final <E> Object m81closedJP2dKIU(Throwable th2) {
            return a.m72constructorimpl(new C0181a(th2));
        }

        /* renamed from: failure-PtdJZtk, reason: not valid java name */
        public final <E> Object m82failurePtdJZtk() {
            return a.m72constructorimpl(a.f15359c);
        }

        /* renamed from: success-JP2dKIU, reason: not valid java name */
        public final <E> Object m83successJP2dKIU(E e10) {
            return a.m72constructorimpl(e10);
        }
    }

    /* compiled from: Channel.kt */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ a(Object obj) {
        this.f15360a = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ a m71boximpl(Object obj) {
        return new a(obj);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m73equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof a) && i.areEqual(obj, ((a) obj2).m80unboximpl());
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m74exceptionOrNullimpl(Object obj) {
        C0181a c0181a = obj instanceof C0181a ? (C0181a) obj : null;
        if (c0181a != null) {
            return c0181a.f15361a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m75getOrNullimpl(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m76hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m77isClosedimpl(Object obj) {
        return obj instanceof C0181a;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m78isSuccessimpl(Object obj) {
        return !(obj instanceof c);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m79toStringimpl(Object obj) {
        if (obj instanceof C0181a) {
            return ((C0181a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m73equalsimpl(this.f15360a, obj);
    }

    public int hashCode() {
        return m76hashCodeimpl(this.f15360a);
    }

    public String toString() {
        return m79toStringimpl(this.f15360a);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m80unboximpl() {
        return this.f15360a;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m72constructorimpl(Object obj) {
        return obj;
    }
}
