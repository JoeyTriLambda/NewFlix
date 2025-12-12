package sg;

import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.j;
import kg.l;
import kg.m2;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import lf.h;
import mf.q;
import pg.b0;
import pg.y;
import zf.i;

/* compiled from: Select.kt */
/* loaded from: classes2.dex */
public final class a<R> extends j implements b, m2 {

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f19287m = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, AdOperationMetric.INIT_STATE);

    /* renamed from: b, reason: collision with root package name */
    public Object f19288b;
    private volatile Object state;

    /* compiled from: Select.kt */
    /* renamed from: sg.a$a, reason: collision with other inner class name */
    public final class C0251a {
    }

    public final int a(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f19287m;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof l)) {
                if (i.areEqual(obj2, c.f19290b) ? true : obj2 instanceof C0251a) {
                    return 3;
                }
                if (i.areEqual(obj2, c.f19291c)) {
                    return 2;
                }
                boolean z10 = false;
                if (i.areEqual(obj2, c.f19289a)) {
                    List listListOf = mf.j.listOf(obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, listListOf)) {
                            z10 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    if (z10) {
                        return 1;
                    }
                } else {
                    if (!(obj2 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj2).toString());
                    }
                    List listPlus = q.plus((Collection<? extends Object>) obj2, obj);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, listPlus)) {
                            z10 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    if (z10) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // sg.b
    public CoroutineContext getContext() {
        return null;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
        invoke2(th2);
        return h.f16056a;
    }

    @Override // sg.b
    public void selectInRegistrationPhase(Object obj) {
        this.f19288b = obj;
    }

    @Override // sg.b
    public boolean trySelect(Object obj, Object obj2) {
        return a(obj) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object obj, Object obj2) {
        return c.access$TrySelectDetailedResult(a(obj));
    }

    @Override // kg.k
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f19287m;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == c.f19290b) {
                return;
            }
            b0 b0Var = c.f19291c;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, b0Var)) {
                    z10 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
    }

    @Override // kg.m2
    public void invokeOnCancellation(y<?> yVar, int i10) {
    }
}
