package og;

import java.util.Arrays;
import kotlin.Result;
import og.b;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes2.dex */
public abstract class a<S extends b<?>> {

    /* renamed from: b, reason: collision with root package name */
    public S[] f17087b;

    /* renamed from: m, reason: collision with root package name */
    public int f17088m;

    /* renamed from: n, reason: collision with root package name */
    public int f17089n;

    public final S allocateSlot() {
        S s10;
        synchronized (this) {
            S[] sArr = this.f17087b;
            if (sArr == null) {
                sArr = (S[]) createSlotArray(2);
                this.f17087b = sArr;
            } else if (this.f17088m >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                zf.i.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                this.f17087b = (S[]) ((b[]) objArrCopyOf);
                sArr = (S[]) ((b[]) objArrCopyOf);
            }
            int i10 = this.f17089n;
            do {
                s10 = sArr[i10];
                if (s10 == null) {
                    s10 = (S) createSlot();
                    sArr[i10] = s10;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
                zf.i.checkNotNull(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s10.allocateLocked(this));
            this.f17089n = i10;
            this.f17088m++;
        }
        return s10;
    }

    public abstract S createSlot();

    public abstract S[] createSlotArray(int i10);

    public final void freeSlot(S s10) {
        int i10;
        qf.c<lf.h>[] cVarArrFreeLocked;
        synchronized (this) {
            int i11 = this.f17088m - 1;
            this.f17088m = i11;
            if (i11 == 0) {
                this.f17089n = 0;
            }
            zf.i.checkNotNull(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            cVarArrFreeLocked = s10.freeLocked(this);
        }
        for (qf.c<lf.h> cVar : cVarArrFreeLocked) {
            if (cVar != null) {
                int i12 = Result.f15189m;
                cVar.resumeWith(Result.m59constructorimpl(lf.h.f16056a));
            }
        }
    }

    public final int getNCollectors() {
        return this.f17088m;
    }

    public final S[] getSlots() {
        return this.f17087b;
    }
}
