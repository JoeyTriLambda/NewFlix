package kotlinx.coroutines.channels;

import com.loopj.android.http.AsyncHttpClient;
import kg.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import mg.d;
import pg.b0;
import pg.e0;
import yf.p;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class BufferedChannelKt {

    /* renamed from: a, reason: collision with root package name */
    public static final d<Object> f15339a = new d<>(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f15340b = e0.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f15341c = e0.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, 0, 0, 12, (Object) null);

    /* renamed from: d, reason: collision with root package name */
    public static final b0 f15342d = new b0("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final b0 f15343e = new b0("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final b0 f15344f = new b0("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final b0 f15345g = new b0("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f15346h = new b0("POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final b0 f15347i = new b0("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f15348j = new b0("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final b0 f15349k = new b0("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final b0 f15350l = new b0("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final b0 f15351m = new b0("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final b0 f15352n = new b0("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final b0 f15353o = new b0("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final b0 f15354p;

    /* renamed from: q, reason: collision with root package name */
    public static final b0 f15355q;

    /* renamed from: r, reason: collision with root package name */
    public static final b0 f15356r;

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: BufferedChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1<E> extends FunctionReferenceImpl implements p<Long, d<E>, d<E>> {

        /* renamed from: u, reason: collision with root package name */
        public static final AnonymousClass1 f15357u = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // yf.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
            return invoke(l10.longValue(), (d) obj);
        }

        public final d<E> invoke(long j10, d<E> dVar) {
            return BufferedChannelKt.access$createSegment(j10, dVar);
        }
    }

    static {
        new b0("NO_RECEIVE_RESULT");
        f15354p = new b0("CLOSE_HANDLER_CLOSED");
        f15355q = new b0("CLOSE_HANDLER_INVOKED");
        f15356r = new b0("NO_CLOSE_CAUSE");
    }

    public static final long access$constructEBCompletedAndPauseFlag(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long access$constructSendersAndCloseStatus(long j10, int i10) {
        return (i10 << 60) + j10;
    }

    public static final d access$createSegment(long j10, d dVar) {
        return new d(j10, dVar, dVar.getChannel(), 0);
    }

    public static final long access$initialBufferEnd(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean access$tryResume0(l lVar, Object obj, yf.l lVar2) {
        Object objTryResume = lVar.tryResume(obj, null, lVar2);
        if (objTryResume == null) {
            return false;
        }
        lVar.completeResume(objTryResume);
        return true;
    }

    public static final <E> gg.d<d<E>> createSegmentFunction() {
        return AnonymousClass1.f15357u;
    }

    public static final b0 getCHANNEL_CLOSED() {
        return f15350l;
    }
}
