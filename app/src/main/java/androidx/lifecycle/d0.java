package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: ViewModelStore.kt */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3489a = new LinkedHashMap();

    public final void clear() {
        for (z zVar : this.f3489a.values()) {
            HashMap map = zVar.f3533a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : zVar.f3533a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e10) {
                                throw new RuntimeException(e10);
                            }
                        }
                    }
                }
            }
            LinkedHashSet linkedHashSet = zVar.f3534b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    for (Closeable closeable : zVar.f3534b) {
                        if (closeable instanceof Closeable) {
                            try {
                                closeable.close();
                            } catch (IOException e11) {
                                throw new RuntimeException(e11);
                            }
                        }
                    }
                }
            }
            zVar.onCleared();
        }
        this.f3489a.clear();
    }

    public final z get(String str) {
        zf.i.checkNotNullParameter(str, "key");
        return (z) this.f3489a.get(str);
    }

    public final Set<String> keys() {
        return new HashSet(this.f3489a.keySet());
    }

    public final void put(String str, z zVar) {
        zf.i.checkNotNullParameter(str, "key");
        zf.i.checkNotNullParameter(zVar, "viewModel");
        z zVar2 = (z) this.f3489a.put(str, zVar);
        if (zVar2 != null) {
            zVar2.onCleared();
        }
    }
}
