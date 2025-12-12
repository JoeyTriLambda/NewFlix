package b3;

import c3.c;
import d3.n;
import f3.t;
import java.util.ArrayList;
import java.util.List;
import lf.h;
import w2.g;
import zf.i;

/* compiled from: WorkConstraintsTracker.kt */
/* loaded from: classes.dex */
public final class e implements d, c.a {

    /* renamed from: a, reason: collision with root package name */
    public final c f4751a;

    /* renamed from: b, reason: collision with root package name */
    public final c3.c<?>[] f4752b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4753c;

    public e(c cVar, c3.c<?>[] cVarArr) {
        i.checkNotNullParameter(cVarArr, "constraintControllers");
        this.f4751a = cVar;
        this.f4752b = cVarArr;
        this.f4753c = new Object();
    }

    public final boolean areAllConstraintsMet(String str) {
        c3.c<?> cVar;
        boolean z10;
        i.checkNotNullParameter(str, "workSpecId");
        synchronized (this.f4753c) {
            c3.c<?>[] cVarArr = this.f4752b;
            int length = cVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cVar = null;
                    break;
                }
                cVar = cVarArr[i10];
                if (cVar.isWorkSpecConstrained(str)) {
                    break;
                }
                i10++;
            }
            if (cVar != null) {
                g.get().debug(f.f4754a, "Work " + str + " constrained by " + cVar.getClass().getSimpleName());
            }
            z10 = cVar == null;
        }
        return z10;
    }

    @Override // c3.c.a
    public void onConstraintMet(List<t> list) {
        i.checkNotNullParameter(list, "workSpecs");
        synchronized (this.f4753c) {
            ArrayList<t> arrayList = new ArrayList();
            for (Object obj : list) {
                if (areAllConstraintsMet(((t) obj).f11426a)) {
                    arrayList.add(obj);
                }
            }
            for (t tVar : arrayList) {
                g.get().debug(f.f4754a, "Constraints met for " + tVar);
            }
            c cVar = this.f4751a;
            if (cVar != null) {
                cVar.onAllConstraintsMet(arrayList);
                h hVar = h.f16056a;
            }
        }
    }

    @Override // c3.c.a
    public void onConstraintNotMet(List<t> list) {
        i.checkNotNullParameter(list, "workSpecs");
        synchronized (this.f4753c) {
            c cVar = this.f4751a;
            if (cVar != null) {
                cVar.onAllConstraintsNotMet(list);
                h hVar = h.f16056a;
            }
        }
    }

    @Override // b3.d
    public void replace(Iterable<t> iterable) {
        i.checkNotNullParameter(iterable, "workSpecs");
        synchronized (this.f4753c) {
            for (c3.c<?> cVar : this.f4752b) {
                cVar.setCallback(null);
            }
            for (c3.c<?> cVar2 : this.f4752b) {
                cVar2.replace(iterable);
            }
            for (c3.c<?> cVar3 : this.f4752b) {
                cVar3.setCallback(this);
            }
            h hVar = h.f16056a;
        }
    }

    @Override // b3.d
    public void reset() {
        synchronized (this.f4753c) {
            for (c3.c<?> cVar : this.f4752b) {
                cVar.reset();
            }
            h hVar = h.f16056a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(n nVar, c cVar) {
        this(cVar, (c3.c<?>[]) new c3.c[]{new c3.a(nVar.getBatteryChargingTracker()), new c3.b(nVar.getBatteryNotLowTracker()), new c3.h(nVar.getStorageNotLowTracker()), new c3.d(nVar.getNetworkStateTracker()), new c3.g(nVar.getNetworkStateTracker()), new c3.f(nVar.getNetworkStateTracker()), new c3.e(nVar.getNetworkStateTracker())});
        i.checkNotNullParameter(nVar, "trackers");
    }
}
