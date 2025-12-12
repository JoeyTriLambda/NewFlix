package mh;

import lf.h;
import yf.l;
import zf.i;

/* compiled from: DefaultContextExt.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final kh.b startKoin(l<? super kh.b, h> lVar) {
        i.checkNotNullParameter(lVar, "appDeclaration");
        return yh.b.f22543a.defaultContext().startKoin(lVar);
    }

    public static final void stopKoin() {
        yh.b.f22543a.defaultContext().stopKoin();
    }
}
