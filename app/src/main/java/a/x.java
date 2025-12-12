package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import yf.a;

/* loaded from: classes.dex */
public final class x extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f26b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ u f27m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(lh.a aVar, u uVar) {
        super(0);
        this.f26b = aVar;
        this.f27m = uVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f26b;
        boolean z10 = aVar instanceof b;
        u uVar = this.f27m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(kf.b.class), null, uVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(kf.b.class), null, uVar);
    }
}
