package a;

import k.h;
import kotlin.jvm.internal.Lambda;
import lh.b;
import yf.a;

/* loaded from: classes.dex */
public final class z extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f30b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f31m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(lh.a aVar, v vVar) {
        super(0);
        this.f30b = aVar;
        this.f31m = vVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f30b;
        boolean z10 = aVar instanceof b;
        v vVar = this.f31m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(h.class), null, vVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(h.class), null, vVar);
    }
}
