package zf;

import java.util.List;
import yf.o;
import yf.p;
import yf.q;
import yf.r;
import yf.s;
import yf.t;
import yf.u;
import yf.v;
import yf.w;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes2.dex */
public final class n {
    public static List asMutableList(Object obj) {
        if ((obj instanceof ag.a) && !(obj instanceof ag.b)) {
            throwCce(obj, "kotlin.collections.MutableList");
        }
        return castToList(obj);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i10) {
        if (obj != null && !isFunctionOfArity(obj, i10)) {
            throwCce(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static List castToList(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw throwCce(e10);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof yf.a) {
            return 0;
        }
        if (obj instanceof yf.l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof yf.b) {
            return 10;
        }
        if (obj instanceof yf.c) {
            return 11;
        }
        if (obj instanceof yf.d) {
            return 12;
        }
        if (obj instanceof yf.e) {
            return 13;
        }
        if (obj instanceof yf.f) {
            return 14;
        }
        if (obj instanceof yf.g) {
            return 15;
        }
        if (obj instanceof yf.h) {
            return 16;
        }
        if (obj instanceof yf.i) {
            return 17;
        }
        if (obj instanceof yf.j) {
            return 18;
        }
        if (obj instanceof yf.k) {
            return 19;
        }
        if (obj instanceof yf.m) {
            return 20;
        }
        if (obj instanceof yf.n) {
            return 21;
        }
        return obj instanceof o ? 22 : -1;
    }

    public static boolean isFunctionOfArity(Object obj, int i10) {
        return (obj instanceof lf.b) && getFunctionArity(obj) == i10;
    }

    public static ClassCastException throwCce(ClassCastException classCastException) {
        i.b(n.class.getName(), classCastException);
        throw classCastException;
    }

    public static void throwCce(Object obj, String str) {
        throwCce((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void throwCce(String str) {
        throw throwCce(new ClassCastException(str));
    }
}
