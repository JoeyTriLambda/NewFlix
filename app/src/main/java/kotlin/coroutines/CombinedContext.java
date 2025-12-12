package kotlin.coroutines;

import ac.c;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import yf.p;
import zf.i;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class CombinedContext implements CoroutineContext, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f15235b;

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineContext.a f15236m;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.a aVar) {
        i.checkNotNullParameter(coroutineContext, "left");
        i.checkNotNullParameter(aVar, "element");
        this.f15235b = coroutineContext;
        this.f15236m = aVar;
    }

    public boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (!(obj instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) obj;
            combinedContext.getClass();
            int i10 = 2;
            CombinedContext combinedContext2 = combinedContext;
            int i11 = 2;
            while (true) {
                CoroutineContext coroutineContext = combinedContext2.f15235b;
                combinedContext2 = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
                if (combinedContext2 == null) {
                    break;
                }
                i11++;
            }
            CombinedContext combinedContext3 = this;
            while (true) {
                CoroutineContext coroutineContext2 = combinedContext3.f15235b;
                combinedContext3 = coroutineContext2 instanceof CombinedContext ? (CombinedContext) coroutineContext2 : null;
                if (combinedContext3 == null) {
                    break;
                }
                i10++;
            }
            if (i11 != i10) {
                return false;
            }
            CombinedContext combinedContext4 = this;
            while (true) {
                CoroutineContext.a aVar = combinedContext4.f15236m;
                if (!i.areEqual(combinedContext.get(aVar.getKey()), aVar)) {
                    zAreEqual = false;
                    break;
                }
                CoroutineContext coroutineContext3 = combinedContext4.f15235b;
                if (!(coroutineContext3 instanceof CombinedContext)) {
                    i.checkNotNull(coroutineContext3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.a aVar2 = (CoroutineContext.a) coroutineContext3;
                    zAreEqual = i.areEqual(combinedContext.get(aVar2.getKey()), aVar2);
                    break;
                }
                combinedContext4 = (CombinedContext) coroutineContext3;
            }
            if (!zAreEqual) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        i.checkNotNullParameter(pVar, "operation");
        return pVar.invoke((Object) this.f15235b.fold(r10, pVar), this.f15236m);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        i.checkNotNullParameter(bVar, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e10 = (E) combinedContext.f15236m.get(bVar);
            if (e10 != null) {
                return e10;
            }
            CoroutineContext coroutineContext = combinedContext.f15235b;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(bVar);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f15236m.hashCode() + this.f15235b.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        i.checkNotNullParameter(bVar, "key");
        CoroutineContext.a aVar = this.f15236m;
        CoroutineContext.a aVar2 = aVar.get(bVar);
        CoroutineContext coroutineContext = this.f15235b;
        if (aVar2 != null) {
            return coroutineContext;
        }
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(bVar);
        return coroutineContextMinusKey == coroutineContext ? this : coroutineContextMinusKey == EmptyCoroutineContext.f15239b ? aVar : new CombinedContext(coroutineContextMinusKey, aVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public String toString() {
        return c.n(new StringBuilder("["), (String) fold("", new p<String, CoroutineContext.a, String>() { // from class: kotlin.coroutines.CombinedContext.toString.1
            @Override // yf.p
            public final String invoke(String str, CoroutineContext.a aVar) {
                i.checkNotNullParameter(str, "acc");
                i.checkNotNullParameter(aVar, "element");
                if (str.length() == 0) {
                    return aVar.toString();
                }
                return str + ", " + aVar;
            }
        }), ']');
    }
}
