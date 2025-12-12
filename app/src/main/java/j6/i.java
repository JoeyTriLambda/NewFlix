package j6;

import c5.q;
import l6.u;
import u5.o;

/* compiled from: TrackSelectorResult.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final o f14668a;

    /* renamed from: b, reason: collision with root package name */
    public final g f14669b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14670c;

    /* renamed from: d, reason: collision with root package name */
    public final q[] f14671d;

    public i(o oVar, g gVar, Object obj, q[] qVarArr) {
        this.f14668a = oVar;
        this.f14669b = gVar;
        this.f14670c = obj;
        this.f14671d = qVarArr;
    }

    public boolean isEquivalent(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.f14669b.f14665a; i10++) {
            if (!isEquivalent(iVar, i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquivalent(i iVar, int i10) {
        return iVar != null && u.areEqual(this.f14669b.get(i10), iVar.f14669b.get(i10)) && u.areEqual(this.f14671d[i10], iVar.f14671d[i10]);
    }
}
