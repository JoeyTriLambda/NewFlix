package wh;

import lf.h;
import yf.l;
import zf.i;

/* compiled from: ModuleDSL.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final rh.a module(boolean z10, l<? super rh.a, h> lVar) {
        i.checkNotNullParameter(lVar, "moduleDeclaration");
        rh.a aVar = new rh.a(z10);
        lVar.invoke(aVar);
        return aVar;
    }

    public static /* synthetic */ rh.a module$default(boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return module(z10, lVar);
    }
}
