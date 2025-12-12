package ue;

import se.d;

/* compiled from: ObjectHelper.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0288a f20375a = new C0288a();

    /* compiled from: ObjectHelper.java */
    /* renamed from: ue.a$a, reason: collision with other inner class name */
    public static final class C0288a implements d<Object, Object> {
        public boolean test(Object obj, Object obj2) {
            return a.equals(obj, obj2);
        }
    }

    public static int compare(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> d<T, T> equalsPredicate() {
        return f20375a;
    }

    public static <T> T requireNonNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static int verifyPositive(int i10, String str) {
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i10);
    }

    public static int compare(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 > j11 ? 1 : 0;
    }

    public static long verifyPositive(long j10, String str) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j10);
    }
}
