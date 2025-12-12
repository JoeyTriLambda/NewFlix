package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: SavedStateHandle.kt */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    public static final a f3519f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Class<? extends Object>[] f3520g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3521a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3522b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3523c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3524d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final androidx.activity.f f3525e = new androidx.activity.f(this, 3);

    /* compiled from: SavedStateHandle.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final boolean validateValue(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : w.f3520g) {
                zf.i.checkNotNull(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final a.c savedStateProvider() {
        return this.f3525e;
    }

    public final <T> void set(String str, T t10) {
        zf.i.checkNotNullParameter(str, "key");
        if (!f3519f.validateValue(t10)) {
            StringBuilder sb2 = new StringBuilder("Can't put value with type ");
            zf.i.checkNotNull(t10);
            sb2.append(t10.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj = this.f3523c.get(str);
        r rVar = obj instanceof r ? (r) obj : null;
        if (rVar != null) {
            rVar.setValue(t10);
        } else {
            this.f3521a.put(str, t10);
        }
        ng.g gVar = (ng.g) this.f3524d.get(str);
        if (gVar == null) {
            return;
        }
        gVar.setValue(t10);
    }
}
