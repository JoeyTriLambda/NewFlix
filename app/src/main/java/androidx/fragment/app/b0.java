package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.a0;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
public final class b0 extends androidx.lifecycle.z {

    /* renamed from: i, reason: collision with root package name */
    public static final a f2762i = new a();

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2766f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Fragment> f2763c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, b0> f2764d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, androidx.lifecycle.d0> f2765e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public boolean f2767g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2768h = false;

    /* compiled from: FragmentManagerViewModel.java */
    public class a implements a0.b {
        @Override // androidx.lifecycle.a0.b
        public final /* synthetic */ androidx.lifecycle.z create(Class cls, u1.a aVar) {
            return androidx.lifecycle.b0.b(this, cls, aVar);
        }

        @Override // androidx.lifecycle.a0.b
        public <T extends androidx.lifecycle.z> T create(Class<T> cls) {
            return new b0(true);
        }
    }

    public b0(boolean z10) {
        this.f2766f = z10;
    }

    public final void a(Fragment fragment) {
        if (this.f2768h) {
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap<String, Fragment> map = this.f2763c;
        if (map.containsKey(fragment.f2679q)) {
            return;
        }
        map.put(fragment.f2679q, fragment);
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void b(Fragment fragment) {
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        c(fragment.f2679q);
    }

    public final void c(String str) {
        HashMap<String, b0> map = this.f2764d;
        b0 b0Var = map.get(str);
        if (b0Var != null) {
            b0Var.onCleared();
            map.remove(str);
        }
        HashMap<String, androidx.lifecycle.d0> map2 = this.f2765e;
        androidx.lifecycle.d0 d0Var = map2.get(str);
        if (d0Var != null) {
            d0Var.clear();
            map2.remove(str);
        }
    }

    public final void d(Fragment fragment) {
        if (this.f2768h) {
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if ((this.f2763c.remove(fragment.f2679q) != null) && y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f2763c.equals(b0Var.f2763c) && this.f2764d.equals(b0Var.f2764d) && this.f2765e.equals(b0Var.f2765e);
    }

    public int hashCode() {
        return this.f2765e.hashCode() + ((this.f2764d.hashCode() + (this.f2763c.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.z
    public void onCleared() {
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2767g = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f2763c.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f2764d.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2765e.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
