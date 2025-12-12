package c3;

import f3.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zf.i;

/* compiled from: ConstraintController.kt */
/* loaded from: classes.dex */
public abstract class c<T> implements b3.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final d3.g<T> f5015a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5016b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f5017c;

    /* renamed from: d, reason: collision with root package name */
    public T f5018d;

    /* renamed from: e, reason: collision with root package name */
    public a f5019e;

    /* compiled from: ConstraintController.kt */
    public interface a {
        void onConstraintMet(List<t> list);

        void onConstraintNotMet(List<t> list);
    }

    public c(d3.g<T> gVar) {
        i.checkNotNullParameter(gVar, "tracker");
        this.f5015a = gVar;
        this.f5016b = new ArrayList();
        this.f5017c = new ArrayList();
    }

    public final void a(a aVar, T t10) {
        ArrayList arrayList = this.f5016b;
        if (arrayList.isEmpty() || aVar == null) {
            return;
        }
        if (t10 == null || isConstrained(t10)) {
            aVar.onConstraintNotMet(arrayList);
        } else {
            aVar.onConstraintMet(arrayList);
        }
    }

    public abstract boolean hasConstraint(t tVar);

    public abstract boolean isConstrained(T t10);

    public final boolean isWorkSpecConstrained(String str) {
        i.checkNotNullParameter(str, "workSpecId");
        T t10 = this.f5018d;
        return t10 != null && isConstrained(t10) && this.f5017c.contains(str);
    }

    @Override // b3.a
    public void onConstraintChanged(T t10) {
        this.f5018d = t10;
        a(this.f5019e, t10);
    }

    public final void replace(Iterable<t> iterable) {
        i.checkNotNullParameter(iterable, "workSpecs");
        ArrayList arrayList = this.f5016b;
        arrayList.clear();
        ArrayList arrayList2 = this.f5017c;
        arrayList2.clear();
        for (t tVar : iterable) {
            if (hasConstraint(tVar)) {
                arrayList.add(tVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((t) it.next()).f11426a);
        }
        boolean zIsEmpty = arrayList.isEmpty();
        d3.g<T> gVar = this.f5015a;
        if (zIsEmpty) {
            gVar.removeListener(this);
        } else {
            gVar.addListener(this);
        }
        a(this.f5019e, this.f5018d);
    }

    public final void reset() {
        ArrayList arrayList = this.f5016b;
        if (!arrayList.isEmpty()) {
            arrayList.clear();
            this.f5015a.removeListener(this);
        }
    }

    public final void setCallback(a aVar) {
        if (this.f5019e != aVar) {
            this.f5019e = aVar;
            a(aVar, this.f5018d);
        }
    }
}
