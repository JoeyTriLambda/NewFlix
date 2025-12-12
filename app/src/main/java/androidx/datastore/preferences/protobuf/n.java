package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* compiled from: ExtensionRegistryLite.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static volatile n f2498b;

    /* renamed from: c, reason: collision with root package name */
    public static final n f2499c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.e<?, ?>> f2500a;

    /* compiled from: ExtensionRegistryLite.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f2501a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2502b;

        public a(Object obj, int i10) {
            this.f2501a = obj;
            this.f2502b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2501a == aVar.f2501a && this.f2502b == aVar.f2502b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f2501a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f2502b;
        }
    }

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
        f2499c = new n(0);
    }

    public n() {
        this.f2500a = new HashMap();
    }

    public static n getEmptyRegistry() {
        n nVarCreateEmpty = f2498b;
        if (nVarCreateEmpty == null) {
            synchronized (n.class) {
                nVarCreateEmpty = f2498b;
                if (nVarCreateEmpty == null) {
                    nVarCreateEmpty = m.createEmpty();
                    f2498b = nVarCreateEmpty;
                }
            }
        }
        return nVarCreateEmpty;
    }

    public <ContainingType extends k0> GeneratedMessageLite.e<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i10) {
        return (GeneratedMessageLite.e) this.f2500a.get(new a(containingtype, i10));
    }

    public n(int i10) {
        this.f2500a = Collections.emptyMap();
    }
}
