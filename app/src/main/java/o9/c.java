package o9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: GlobalLibraryVersionRegistrar.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f17054b;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f17055a = new HashSet();

    public static c getInstance() {
        c cVar = f17054b;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = f17054b;
                if (cVar == null) {
                    cVar = new c();
                    f17054b = cVar;
                }
            }
        }
        return cVar;
    }

    public final Set<e> a() {
        Set<e> setUnmodifiableSet;
        synchronized (this.f17055a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f17055a);
        }
        return setUnmodifiableSet;
    }
}
