package androidx.datastore.preferences.core;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import l1.a;
import mf.q;
import yf.l;
import zf.f;
import zf.i;

/* compiled from: Preferences.kt */
/* loaded from: classes.dex */
public final class MutablePreferences extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<a.C0186a<?>, Object> f2304a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2305b;

    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // l1.a
    public Map<a.C0186a<?>, Object> asMap() {
        Map<a.C0186a<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.f2304a);
        i.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    public final void checkNotFrozen$datastore_preferences_core() {
        if (!(!this.f2305b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutablePreferences)) {
            return false;
        }
        return i.areEqual(this.f2304a, ((MutablePreferences) obj).f2304a);
    }

    public final void freeze$datastore_preferences_core() {
        this.f2305b.set(true);
    }

    @Override // l1.a
    public <T> T get(a.C0186a<T> c0186a) {
        i.checkNotNullParameter(c0186a, "key");
        return (T) this.f2304a.get(c0186a);
    }

    public int hashCode() {
        return this.f2304a.hashCode();
    }

    public final void putAll(a.b<?>... bVarArr) {
        i.checkNotNullParameter(bVarArr, "pairs");
        checkNotFrozen$datastore_preferences_core();
        for (a.b<?> bVar : bVarArr) {
            setUnchecked$datastore_preferences_core(bVar.getKey$datastore_preferences_core(), bVar.getValue$datastore_preferences_core());
        }
    }

    public final <T> T remove(a.C0186a<T> c0186a) {
        i.checkNotNullParameter(c0186a, "key");
        checkNotFrozen$datastore_preferences_core();
        return (T) this.f2304a.remove(c0186a);
    }

    public final <T> void set(a.C0186a<T> c0186a, T t10) {
        i.checkNotNullParameter(c0186a, "key");
        setUnchecked$datastore_preferences_core(c0186a, t10);
    }

    public final void setUnchecked$datastore_preferences_core(a.C0186a<?> c0186a, Object obj) {
        i.checkNotNullParameter(c0186a, "key");
        checkNotFrozen$datastore_preferences_core();
        if (obj == null) {
            remove(c0186a);
            return;
        }
        boolean z10 = obj instanceof Set;
        Map<a.C0186a<?>, Object> map = this.f2304a;
        if (!z10) {
            map.put(c0186a, obj);
            return;
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(q.toSet((Iterable) obj));
        i.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(c0186a, setUnmodifiableSet);
    }

    public String toString() {
        return q.joinToString$default(this.f2304a.entrySet(), ",\n", "{\n", "\n}", 0, null, new l<Map.Entry<a.C0186a<?>, Object>, CharSequence>() { // from class: androidx.datastore.preferences.core.MutablePreferences.toString.1
            @Override // yf.l
            public final CharSequence invoke(Map.Entry<a.C0186a<?>, Object> entry) {
                i.checkNotNullParameter(entry, "entry");
                return "  " + entry.getKey().getName() + " = " + entry.getValue();
            }
        }, 24, null);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z10, int i10, f fVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z10);
    }

    public MutablePreferences(Map<a.C0186a<?>, Object> map, boolean z10) {
        i.checkNotNullParameter(map, "preferencesMap");
        this.f2304a = map;
        this.f2305b = new AtomicBoolean(z10);
    }
}
