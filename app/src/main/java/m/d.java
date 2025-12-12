package m;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f16059b;

    /* renamed from: m, reason: collision with root package name */
    public wg.e f16060m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f16061n;

    /* renamed from: o, reason: collision with root package name */
    public long f16062o;

    /* renamed from: p, reason: collision with root package name */
    public int f16063p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object f16064q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ wg.e f16065r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(wg.e eVar, c cVar) {
        super(2, cVar);
        this.f16065r = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        d dVar = new d(this.f16065r, cVar);
        dVar.f16064q = obj;
        return dVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        d dVar = new d(this.f16065r, (c) obj2);
        dVar.f16064q = (g0) obj;
        return dVar.invokeSuspend(lf.h.f16056a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b A[Catch: all -> 0x01c1, TryCatch #0 {all -> 0x01c1, blocks: (B:23:0x0073, B:25:0x007b, B:29:0x0088, B:31:0x008c, B:33:0x0092, B:35:0x009c, B:38:0x00a3, B:39:0x00aa, B:40:0x00ab, B:42:0x00e6, B:44:0x00ea, B:45:0x00ee, B:48:0x010e, B:57:0x0165, B:28:0x0082), top: B:82:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0160 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184 A[Catch: all -> 0x004d, TryCatch #4 {all -> 0x004d, blocks: (B:8:0x0027, B:61:0x017e, B:63:0x0184, B:65:0x0188, B:66:0x018c, B:67:0x0191, B:13:0x0042, B:18:0x005d), top: B:90:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017b -> B:61:0x017e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
