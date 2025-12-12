package qb;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import kg.g0;

/* loaded from: classes2.dex */
public final class h extends Bloc {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f18058x = 0;

    /* renamed from: t, reason: collision with root package name */
    public final kf.b f18059t;

    /* renamed from: u, reason: collision with root package name */
    public final p000if.b f18060u;

    /* renamed from: v, reason: collision with root package name */
    public g0 f18061v;

    /* renamed from: w, reason: collision with root package name */
    public g0 f18062w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(kf.b bVar, p000if.b bVar2) {
        super(k.f18064b);
        zf.i.checkNotNullParameter(bVar, "connectivityRepository");
        zf.i.checkNotNullParameter(bVar2, "configRepository");
        this.f18059t = bVar;
        this.f18060u = bVar2;
        ng.c.launchIn(ng.c.onEach(new g(transformEvents(this.f10408p)), new d.n(new d.b(this, null), this, null)), getBlocScope());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(qb.h r6, oa.c r7, qf.c r8) throws java.lang.Throwable {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof d.c
            if (r0 == 0) goto L16
            r0 = r8
            d.c r0 = (d.c) r0
            int r1 = r0.f10730o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f10730o = r1
            goto L1b
        L16:
            d.c r0 = new d.c
            r0.<init>(r6, r8)
        L1b:
            java.lang.Object r8 = r0.f10728m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10730o
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            qb.h r6 = r0.f10727b
            lf.f.throwOnFailure(r8)
            goto L9d
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            lf.f.throwOnFailure(r8)
            ng.g r8 = k.c.f14701a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "onStart wifiOnly = "
            r8.<init>(r2)
            if.b r2 = r6.f18060u
            ng.g r4 = r2.f13438a
            java.lang.Object r4 = r4.getValue()
            if.a r4 = (p000if.a) r4
            boolean r4 = r4.f13429b
            r8.append(r4)
            java.lang.String r4 = ", wifi = "
            r8.append(r4)
            kf.b r4 = r6.f18059t
            ng.g r5 = r4.f15090b
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            java.lang.String r5 = "ConnectivityBloc"
            k.c.a(r5, r8)
            ng.g r8 = r2.f13438a
            java.lang.Object r8 = r8.getValue()
            if.a r8 = (p000if.a) r8
            boolean r8 = r8.f13429b
            ng.g r2 = r4.f15090b
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r8 != 0) goto L8b
            qb.a r8 = qb.a.f18051b
            goto L92
        L8b:
            if (r2 == 0) goto L90
            qb.a r8 = qb.a.f18051b
            goto L92
        L90:
            qb.l r8 = qb.l.f18065b
        L92:
            r0.f10727b = r6
            r0.f10730o = r3
            java.lang.Object r7 = r7.emit(r8, r0)
            if (r7 != r1) goto L9d
            goto Ld0
        L9d:
            kotlinx.coroutines.b r7 = kg.s0.getDefault()
            kg.g0 r0 = kg.h0.CoroutineScope(r7)
            r6.f18061v = r0
            r7 = 0
            if (r0 == 0) goto Lb6
            d.e r3 = new d.e
            r3.<init>(r6, r7)
            r1 = 0
            r2 = 0
            r4 = 3
            r5 = 0
            kg.f.launch$default(r0, r1, r2, r3, r4, r5)
        Lb6:
            kotlinx.coroutines.b r8 = kg.s0.getDefault()
            kg.g0 r0 = kg.h0.CoroutineScope(r8)
            r6.f18062w = r0
            if (r0 == 0) goto Lce
            d.j r3 = new d.j
            r3.<init>(r6, r7)
            r1 = 0
            r2 = 0
            r4 = 3
            r5 = 0
            kg.f.launch$default(r0, r1, r2, r3, r4, r5)
        Lce:
            lf.h r1 = lf.h.f16056a
        Ld0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: qb.h.a(qb.h, oa.c, qf.c):java.lang.Object");
    }
}
