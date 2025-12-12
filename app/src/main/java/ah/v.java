package ah;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SegmentPool.kt */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final u f730a = new u(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f731b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<u>[] f732c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f731b = iHighestOneBit;
        AtomicReference<u>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f732c = atomicReferenceArr;
    }

    public static final void recycle(u uVar) {
        zf.i.checkNotNullParameter(uVar, "segment");
        boolean z10 = true;
        if (!(uVar.f728f == null && uVar.f729g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (uVar.f726d) {
            return;
        }
        AtomicReference<u> atomicReference = f732c[(int) (Thread.currentThread().getId() & (f731b - 1))];
        u uVar2 = atomicReference.get();
        if (uVar2 == f730a) {
            return;
        }
        int i10 = uVar2 == null ? 0 : uVar2.f725c;
        if (i10 >= 65536) {
            return;
        }
        uVar.f728f = uVar2;
        uVar.f724b = 0;
        uVar.f725c = i10 + 8192;
        while (true) {
            if (atomicReference.compareAndSet(uVar2, uVar)) {
                break;
            } else if (atomicReference.get() != uVar2) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return;
        }
        uVar.f728f = null;
    }

    public static final u take() {
        AtomicReference<u> atomicReference = f732c[(int) (Thread.currentThread().getId() & (f731b - 1))];
        u uVar = f730a;
        u andSet = atomicReference.getAndSet(uVar);
        if (andSet == uVar) {
            return new u();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new u();
        }
        atomicReference.set(andSet.f728f);
        andSet.f728f = null;
        andSet.f725c = 0;
        return andSet;
    }
}
