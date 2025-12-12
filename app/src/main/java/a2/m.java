package a2;

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaRouteSelector.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final m f182c = new m(null, new Bundle());

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f183a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f184b;

    /* compiled from: MediaRouteSelector.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<String> f185a;

        public a() {
        }

        public a addControlCategories(Collection<String> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("categories must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator<String> it = collection.iterator();
                while (it.hasNext()) {
                    addControlCategory(it.next());
                }
            }
            return this;
        }

        public a addControlCategory(String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            if (this.f185a == null) {
                this.f185a = new ArrayList<>();
            }
            if (!this.f185a.contains(str)) {
                this.f185a.add(str);
            }
            return this;
        }

        public a addSelector(m mVar) {
            if (mVar == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            addControlCategories(mVar.getControlCategories());
            return this;
        }

        public m build() {
            if (this.f185a == null) {
                return m.f182c;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", this.f185a);
            return new m(this.f185a, bundle);
        }

        public a(m mVar) {
            if (mVar == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            mVar.a();
            if (mVar.f184b.isEmpty()) {
                return;
            }
            this.f185a = new ArrayList<>(mVar.f184b);
        }
    }

    public m(ArrayList arrayList, Bundle bundle) {
        this.f183a = bundle;
        this.f184b = arrayList;
    }

    public static m fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new m(null, bundle);
        }
        return null;
    }

    public final void a() {
        if (this.f184b == null) {
            ArrayList<String> stringArrayList = this.f183a.getStringArrayList("controlCategories");
            this.f184b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f184b = Collections.emptyList();
            }
        }
    }

    public Bundle asBundle() {
        return this.f183a;
    }

    public boolean contains(m mVar) {
        if (mVar == null) {
            return false;
        }
        a();
        mVar.a();
        return this.f184b.containsAll(mVar.f184b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        a();
        mVar.a();
        return this.f184b.equals(mVar.f184b);
    }

    public List<String> getControlCategories() {
        a();
        return new ArrayList(this.f184b);
    }

    public int hashCode() {
        a();
        return this.f184b.hashCode();
    }

    public boolean isEmpty() {
        a();
        return this.f184b.isEmpty();
    }

    public boolean isValid() {
        a();
        return !this.f184b.contains(null);
    }

    public boolean matchesControlFilters(List<IntentFilter> list) {
        if (list == null) {
            return false;
        }
        a();
        if (this.f184b.isEmpty()) {
            return false;
        }
        for (IntentFilter intentFilter : list) {
            if (intentFilter != null) {
                Iterator<String> it = this.f184b.iterator();
                while (it.hasNext()) {
                    if (intentFilter.hasCategory(it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return "MediaRouteSelector{ controlCategories=" + Arrays.toString(getControlCategories().toArray()) + " }";
    }
}
