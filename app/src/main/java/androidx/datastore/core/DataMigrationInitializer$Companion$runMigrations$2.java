package androidx.datastore.core;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import qf.c;
import sf.d;
import yf.l;
import yf.p;

/* compiled from: DataMigrationInitializer.kt */
@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements p<Object, c<Object>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public Iterator f2171b;

    /* renamed from: m, reason: collision with root package name */
    public i1.c f2172m;

    /* renamed from: n, reason: collision with root package name */
    public Object f2173n;

    /* renamed from: o, reason: collision with root package name */
    public int f2174o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f2175p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ List<i1.c<Object>> f2176q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ List<l<c<? super h>, Object>> f2177r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$runMigrations$2(List<? extends i1.c<Object>> list, List<l<c<? super h>, Object>> list2, c<? super DataMigrationInitializer$Companion$runMigrations$2> cVar) {
        super(2, cVar);
        this.f2176q = list;
        this.f2177r = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.f2176q, this.f2177r, cVar);
        dataMigrationInitializer$Companion$runMigrations$2.f2175p = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r11.f2174o
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.util.Iterator r1 = r11.f2171b
            java.lang.Object r4 = r11.f2175p
            java.util.List r4 = (java.util.List) r4
            lf.f.throwOnFailure(r12)
            goto L3e
        L18:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L20:
            java.lang.Object r1 = r11.f2173n
            i1.c r4 = r11.f2172m
            java.util.Iterator r5 = r11.f2171b
            java.lang.Object r6 = r11.f2175p
            java.util.List r6 = (java.util.List) r6
            lf.f.throwOnFailure(r12)
            r7 = r11
            goto L64
        L2f:
            lf.f.throwOnFailure(r12)
            java.lang.Object r12 = r11.f2175p
            java.util.List<i1.c<java.lang.Object>> r1 = r11.f2176q
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            java.util.List<yf.l<qf.c<? super lf.h>, java.lang.Object>> r4 = r11.f2177r
        L3e:
            r5 = r11
        L3f:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L8b
            java.lang.Object r6 = r1.next()
            i1.c r6 = (i1.c) r6
            r5.f2175p = r4
            r5.f2171b = r1
            r5.f2172m = r6
            r5.f2173n = r12
            r5.f2174o = r3
            java.lang.Object r7 = r6.shouldMigrate(r12, r5)
            if (r7 != r0) goto L5c
            return r0
        L5c:
            r9 = r1
            r1 = r12
            r12 = r7
            r7 = r5
            r5 = r9
            r10 = r6
            r6 = r4
            r4 = r10
        L64:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L86
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r12 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r8 = 0
            r12.<init>(r4, r8)
            r6.add(r12)
            r7.f2175p = r6
            r7.f2171b = r5
            r7.f2172m = r8
            r7.f2173n = r8
            r7.f2174o = r2
            java.lang.Object r12 = r4.migrate(r1, r7)
            if (r12 != r0) goto L87
            return r0
        L86:
            r12 = r1
        L87:
            r1 = r5
            r4 = r6
            r5 = r7
            goto L3f
        L8b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // yf.p
    public final Object invoke(Object obj, c<Object> cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(obj, cVar)).invokeSuspend(h.f16056a);
    }
}
