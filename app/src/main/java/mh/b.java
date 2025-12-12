package mh;

import lf.h;
import org.koin.core.error.KoinAppAlreadyStartedException;
import yf.l;
import zf.i;

/* compiled from: GlobalContext.kt */
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f16320a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static kh.a f16321b;

    @Override // mh.c
    public kh.a get() {
        kh.a aVar = f16321b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KoinApplication has not been started".toString());
    }

    @Override // mh.c
    public kh.b startKoin(l<? super kh.b, h> lVar) {
        kh.b bVarInit;
        i.checkNotNullParameter(lVar, "appDeclaration");
        synchronized (this) {
            bVarInit = kh.b.f15181c.init();
            if (f16321b != null) {
                throw new KoinAppAlreadyStartedException("A Koin Application has already been started");
            }
            f16321b = bVarInit.getKoin();
            lVar.invoke(bVarInit);
            bVarInit.createEagerInstances();
        }
        return bVarInit;
    }

    @Override // mh.c
    public void stopKoin() {
        synchronized (this) {
            kh.a aVar = f16321b;
            if (aVar != null) {
                aVar.close();
            }
            f16321b = null;
            h hVar = h.f16056a;
        }
    }
}
