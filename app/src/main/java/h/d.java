package h;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import yf.p;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f12871b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f12872m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ de.c f12873n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(de.c cVar, qf.c cVar2) {
        super(2, cVar2);
        this.f12873n = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        d dVar = new d(this.f12873n, cVar);
        dVar.f12872m = obj;
        return dVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        d dVar = new d(this.f12873n, (qf.c) obj2);
        dVar.f12872m = (g0) obj;
        return dVar.invokeSuspend(h.f16056a);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0095 -> B:14:0x002a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r11.f12871b
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r1 = r11.f12872m
            kg.g0 r1 = (kg.g0) r1
            lf.f.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L13
            goto L29
        L13:
            r12 = move-exception
            r3 = r1
            r1 = r0
            r0 = r11
            goto L8f
        L19:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L21:
            lf.f.throwOnFailure(r12)
            java.lang.Object r12 = r11.f12872m
            r1 = r12
            kg.g0 r1 = (kg.g0) r1
        L29:
            r12 = r11
        L2a:
            de.c r3 = r12.f12873n
            boolean r4 = kg.h0.isActive(r1)
            if (r4 == 0) goto L9a
            java.io.InputStream r4 = r3.f11013a     // Catch: java.lang.Throwable -> L89
            int r4 = r4.read()     // Catch: java.lang.Throwable -> L89
            r5 = -1
            if (r4 != r5) goto L4a
            boolean r5 = kg.h0.isActive(r1)     // Catch: java.lang.Throwable -> L89
            if (r5 != 0) goto L42
            goto L4a
        L42:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "EnfOfStream"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L89
            throw r3     // Catch: java.lang.Throwable -> L89
        L4a:
            i.t[] r5 = i.t.values()     // Catch: java.lang.Throwable -> L89
            int r6 = r5.length     // Catch: java.lang.Throwable -> L89
            r7 = 0
        L50:
            if (r7 >= r6) goto L5c
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L89
            int r9 = r8.f13097b     // Catch: java.lang.Throwable -> L89
            if (r9 != r4) goto L59
            goto L5d
        L59:
            int r7 = r7 + 1
            goto L50
        L5c:
            r8 = 0
        L5d:
            if (r8 == 0) goto L70
            ng.f r4 = r3.f11015c     // Catch: java.lang.Throwable -> L89
            ee.w r3 = de.c.a(r3, r8)     // Catch: java.lang.Throwable -> L89
            r12.f12872m = r1     // Catch: java.lang.Throwable -> L89
            r12.f12871b = r2     // Catch: java.lang.Throwable -> L89
            java.lang.Object r3 = r4.emit(r3, r12)     // Catch: java.lang.Throwable -> L89
            if (r3 != r0) goto L2a
            return r0
        L70:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L89
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = "No such message with id ["
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L89
            r5.append(r4)     // Catch: java.lang.Throwable -> L89
            r4 = 93
            r5.append(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L89
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L89
            throw r3     // Catch: java.lang.Throwable -> L89
        L89:
            r3 = move-exception
            r10 = r0
            r0 = r12
            r12 = r3
            r3 = r1
            r1 = r10
        L8f:
            boolean r4 = kg.h0.isActive(r3)
            if (r4 != 0) goto L99
            r12 = r0
            r0 = r1
            r1 = r3
            goto L2a
        L99:
            throw r12
        L9a:
            lf.h r12 = lf.h.f16056a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: h.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
