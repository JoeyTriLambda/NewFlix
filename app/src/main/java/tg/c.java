package tg;

import pg.b0;
import pg.e0;

/* compiled from: Semaphore.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f19917a = e0.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f19918b = new b0("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f19919c = new b0("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    public static final b0 f19920d = new b0("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    public static final b0 f19921e = new b0("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    public static final int f19922f = e0.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    public static final d access$createSegment(long j10, d dVar) {
        return new d(j10, dVar, 0);
    }
}
