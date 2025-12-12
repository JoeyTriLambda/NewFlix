package a2;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaRouteProviderDescriptor.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final List<g> f178a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f179b;

    /* compiled from: MediaRouteProviderDescriptor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f180a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f181b = false;

        public a addRoute(g gVar) {
            if (gVar == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            ArrayList arrayList = this.f180a;
            if (arrayList.contains(gVar)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            arrayList.add(gVar);
            return this;
        }

        public a addRoutes(Collection<g> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("routes must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator<g> it = collection.iterator();
                while (it.hasNext()) {
                    addRoute(it.next());
                }
            }
            return this;
        }

        public k build() {
            return new k(this.f180a, this.f181b);
        }

        public a setSupportsDynamicGroupRoute(boolean z10) {
            this.f181b = z10;
            return this;
        }
    }

    public k(ArrayList arrayList, boolean z10) {
        if (arrayList.isEmpty()) {
            this.f178a = Collections.emptyList();
        } else {
            this.f178a = Collections.unmodifiableList(new ArrayList(arrayList));
        }
        this.f179b = z10;
    }

    public static k fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null) {
            for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
                arrayList.add(g.fromBundle((Bundle) parcelableArrayList.get(i10)));
            }
        }
        return new k(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public List<g> getRoutes() {
        return this.f178a;
    }

    public boolean isValid() {
        int size = getRoutes().size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar = this.f178a.get(i10);
            if (gVar == null || !gVar.isValid()) {
                return false;
            }
        }
        return true;
    }

    public boolean supportsDynamicGroupRoute() {
        return this.f179b;
    }

    public String toString() {
        return "MediaRouteProviderDescriptor{ routes=" + Arrays.toString(getRoutes().toArray()) + ", isValid=" + isValid() + " }";
    }
}
