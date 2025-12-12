package de;

import ee.w;
import java.io.OutputStream;
import ng.g;
import zf.i;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public e f11017a;

    /* renamed from: b, reason: collision with root package name */
    public c f11018b;

    public final void a(w wVar) {
        i.checkNotNullParameter(wVar, "message");
        e eVar = this.f11017a;
        if (eVar == null) {
            i.throwUninitializedPropertyAccessException("sender");
            eVar = null;
        }
        eVar.getClass();
        OutputStream outputStream = eVar.f11016a;
        i.checkNotNullParameter(wVar, "message");
        try {
            outputStream.write(wVar.b());
            outputStream.flush();
            g gVar = k.c.f14701a;
            k.c.a("ApiSender", "--> " + wVar);
        } catch (Throwable th2) {
            g gVar2 = k.c.f14701a;
            k.c.a("ApiSender", "Exception: " + th2.getMessage(), th2);
            throw th2;
        }
    }
}
