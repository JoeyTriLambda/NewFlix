package r4;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MetadataBackendRegistry.java */
/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: a, reason: collision with root package name */
    public final a f18594a;

    /* renamed from: b, reason: collision with root package name */
    public final g f18595b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f18596c;

    /* compiled from: MetadataBackendRegistry.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f18597a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f18598b = null;

        public a(Context context) {
            this.f18597a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final r4.c a(java.lang.String r15) throws android.content.pm.PackageManager.NameNotFoundException {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: r4.i.a.a(java.lang.String):r4.c");
        }
    }

    public i(Context context, g gVar) {
        a aVar = new a(context);
        this.f18596c = new HashMap();
        this.f18594a = aVar;
        this.f18595b = gVar;
    }

    @Override // r4.d
    public synchronized k get(String str) {
        if (this.f18596c.containsKey(str)) {
            return (k) this.f18596c.get(str);
        }
        c cVarA = this.f18594a.a(str);
        if (cVarA == null) {
            return null;
        }
        g gVar = this.f18595b;
        k kVarCreate = cVarA.create(f.create(gVar.f18588a, gVar.f18589b, gVar.f18590c, str));
        this.f18596c.put(str, kVarCreate);
        return kVarCreate;
    }
}
