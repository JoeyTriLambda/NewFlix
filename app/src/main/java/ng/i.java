package ng;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import pg.b0;

/* compiled from: SharedFlow.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f16828a = new b0("NO_VALUE");

    public static final <T> f<T> MutableSharedFlow(int i10, int i11, BufferOverflow bufferOverflow) {
        boolean z10 = true;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(ac.c.f("replay cannot be negative, but was ", i10).toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(ac.c.f("extraBufferCapacity cannot be negative, but was ", i11).toString());
        }
        if (i10 <= 0 && i11 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
        }
        int i12 = i11 + i10;
        if (i12 < 0) {
            i12 = Integer.MAX_VALUE;
        }
        return new SharedFlowImpl(i10, i12, bufferOverflow);
    }

    public static /* synthetic */ f MutableSharedFlow$default(int i10, int i11, BufferOverflow bufferOverflow, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i10, i11, bufferOverflow);
    }

    public static final Object access$getBufferAt(Object[] objArr, long j10) {
        return objArr[(objArr.length - 1) & ((int) j10)];
    }

    public static final void access$setBufferAt(Object[] objArr, long j10, Object obj) {
        objArr[(objArr.length - 1) & ((int) j10)] = obj;
    }
}
