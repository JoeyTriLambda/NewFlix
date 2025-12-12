package c3;

import f3.t;
import zf.i;

/* compiled from: ContraintControllers.kt */
/* loaded from: classes.dex */
public final class h extends c<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d3.g<Boolean> gVar) {
        super(gVar);
        i.checkNotNullParameter(gVar, "tracker");
    }

    @Override // c3.c
    public boolean hasConstraint(t tVar) {
        i.checkNotNullParameter(tVar, "workSpec");
        return tVar.f11435j.requiresStorageNotLow();
    }

    public boolean isConstrained(boolean z10) {
        return !z10;
    }

    @Override // c3.c
    public /* bridge */ /* synthetic */ boolean isConstrained(Boolean bool) {
        return isConstrained(bool.booleanValue());
    }
}
