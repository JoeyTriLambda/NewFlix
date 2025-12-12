package androidx.fragment.app;

import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2800a;

    /* renamed from: b, reason: collision with root package name */
    public final Cloneable f2801b;

    /* renamed from: c, reason: collision with root package name */
    public final Cloneable f2802c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2803d;

    public f0(int i10) {
        if (i10 != 1) {
            this.f2800a = new ArrayList();
            this.f2801b = new HashMap();
            this.f2802c = new HashMap();
        } else {
            this.f2800a = new b0.b();
            this.f2801b = new SparseArray();
            this.f2802c = new b0.h();
            this.f2803d = new b0.b();
        }
    }

    public final void a(Fragment fragment) {
        if (((ArrayList) this.f2800a).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.f2800a)) {
            ((ArrayList) this.f2800a).add(fragment);
        }
        fragment.f2685w = true;
    }

    public final void b() {
        ((HashMap) this.f2801b).values().removeAll(Collections.singleton(null));
    }

    public final Fragment c(String str) {
        e0 e0Var = (e0) ((HashMap) this.f2801b).get(str);
        if (e0Var != null) {
            return e0Var.f2794c;
        }
        return null;
    }

    public final Fragment d(String str) {
        Fragment fragmentC;
        for (e0 e0Var : ((HashMap) this.f2801b).values()) {
            if (e0Var != null && (fragmentC = e0Var.f2794c.c(str)) != null) {
                return fragmentC;
            }
        }
        return null;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (e0 e0Var : ((HashMap) this.f2801b).values()) {
            if (e0Var != null) {
                arrayList.add(e0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (e0 e0Var : ((HashMap) this.f2801b).values()) {
            if (e0Var != null) {
                arrayList.add(e0Var.f2794c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List g() {
        ArrayList arrayList;
        if (((ArrayList) this.f2800a).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f2800a)) {
            arrayList = new ArrayList((ArrayList) this.f2800a);
        }
        return arrayList;
    }

    public final void h(e0 e0Var) {
        Fragment fragment = e0Var.f2794c;
        String str = fragment.f2679q;
        Cloneable cloneable = this.f2801b;
        if (((HashMap) cloneable).get(str) != null) {
            return;
        }
        ((HashMap) cloneable).put(fragment.f2679q, e0Var);
        if (fragment.N) {
            if (fragment.M) {
                ((b0) this.f2803d).a(fragment);
            } else {
                ((b0) this.f2803d).d(fragment);
            }
            fragment.N = false;
        }
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public final void i(e0 e0Var) {
        Fragment fragment = e0Var.f2794c;
        if (fragment.M) {
            ((b0) this.f2803d).d(fragment);
        }
        if (((e0) ((HashMap) this.f2801b).put(fragment.f2679q, null)) != null && y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public final d0 j(String str, d0 d0Var) {
        Cloneable cloneable = this.f2802c;
        return d0Var != null ? (d0) ((HashMap) cloneable).put(str, d0Var) : (d0) ((HashMap) cloneable).remove(str);
    }
}
