package kg;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15165a;

    /* renamed from: b, reason: collision with root package name */
    public final j f15166b;

    /* renamed from: c, reason: collision with root package name */
    public final yf.l<Throwable, lf.h> f15167c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f15168d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f15169e;

    /* JADX WARN: Multi-variable type inference failed */
    public y(Object obj, j jVar, yf.l<? super Throwable, lf.h> lVar, Object obj2, Throwable th2) {
        this.f15165a = obj;
        this.f15166b = jVar;
        this.f15167c = lVar;
        this.f15168d = obj2;
        this.f15169e = th2;
    }

    public static /* synthetic */ y copy$default(y yVar, Object obj, j jVar, yf.l lVar, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = yVar.f15165a;
        }
        if ((i10 & 2) != 0) {
            jVar = yVar.f15166b;
        }
        j jVar2 = jVar;
        if ((i10 & 4) != 0) {
            lVar = yVar.f15167c;
        }
        yf.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = yVar.f15168d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = yVar.f15169e;
        }
        return yVar.copy(obj, jVar2, lVar2, obj4, th2);
    }

    public final y copy(Object obj, j jVar, yf.l<? super Throwable, lf.h> lVar, Object obj2, Throwable th2) {
        return new y(obj, jVar, lVar, obj2, th2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return zf.i.areEqual(this.f15165a, yVar.f15165a) && zf.i.areEqual(this.f15166b, yVar.f15166b) && zf.i.areEqual(this.f15167c, yVar.f15167c) && zf.i.areEqual(this.f15168d, yVar.f15168d) && zf.i.areEqual(this.f15169e, yVar.f15169e);
    }

    public final boolean getCancelled() {
        return this.f15169e != null;
    }

    public int hashCode() {
        Object obj = this.f15165a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        j jVar = this.f15166b;
        int iHashCode2 = (iHashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        yf.l<Throwable, lf.h> lVar = this.f15167c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f15168d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f15169e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public final void invokeHandlers(m<?> mVar, Throwable th2) {
        j jVar = this.f15166b;
        if (jVar != null) {
            mVar.callCancelHandler(jVar, th2);
        }
        yf.l<Throwable, lf.h> lVar = this.f15167c;
        if (lVar != null) {
            mVar.callOnCancellation(lVar, th2);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f15165a + ", cancelHandler=" + this.f15166b + ", onCancellation=" + this.f15167c + ", idempotentResume=" + this.f15168d + ", cancelCause=" + this.f15169e + ')';
    }

    public /* synthetic */ y(Object obj, j jVar, yf.l lVar, Object obj2, Throwable th2, int i10, zf.f fVar) {
        this(obj, (i10 & 2) != 0 ? null : jVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }
}
