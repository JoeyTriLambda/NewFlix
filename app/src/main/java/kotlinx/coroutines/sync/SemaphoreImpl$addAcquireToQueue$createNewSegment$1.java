package kotlinx.coroutines.sync;

import kotlin.jvm.internal.FunctionReferenceImpl;
import tg.c;
import tg.d;
import yf.p;

/* compiled from: Semaphore.kt */
/* loaded from: classes2.dex */
final /* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements p<Long, d, d> {

    /* renamed from: u, reason: collision with root package name */
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 f15625u = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();

    public SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // yf.p
    public /* bridge */ /* synthetic */ d invoke(Long l10, d dVar) {
        return invoke(l10.longValue(), dVar);
    }

    public final d invoke(long j10, d dVar) {
        return c.access$createSegment(j10, dVar);
    }
}
