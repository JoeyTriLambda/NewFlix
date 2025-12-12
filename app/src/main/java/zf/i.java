package zf;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* loaded from: classes2.dex */
public final class i {
    public static String a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = i.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(String str, Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        th2.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(ac.c.B(str, " must not be null"));
        b(i.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(ac.c.B(str, " must not be null"));
        b(i.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(a(str));
        b(i.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(a(str));
        b(i.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static int compare(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i10, String str) {
        throwUndefinedForReified();
    }

    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        b(i.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        b(i.class.getName(), kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        b(i.class.getName(), uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static int compare(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void throwJavaNpe(String str) {
        NullPointerException nullPointerException = new NullPointerException(str);
        b(i.class.getName(), nullPointerException);
        throw nullPointerException;
    }
}
