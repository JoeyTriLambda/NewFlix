package f3;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import okhttp3.internal.http2.Http2;

/* compiled from: WorkSpec.kt */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: u, reason: collision with root package name */
    public static final String f11425u;

    /* renamed from: a, reason: collision with root package name */
    public final String f11426a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo$State f11427b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11428c;

    /* renamed from: d, reason: collision with root package name */
    public String f11429d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.work.b f11430e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.work.b f11431f;

    /* renamed from: g, reason: collision with root package name */
    public final long f11432g;

    /* renamed from: h, reason: collision with root package name */
    public long f11433h;

    /* renamed from: i, reason: collision with root package name */
    public long f11434i;

    /* renamed from: j, reason: collision with root package name */
    public final w2.b f11435j;

    /* renamed from: k, reason: collision with root package name */
    public final int f11436k;

    /* renamed from: l, reason: collision with root package name */
    public final BackoffPolicy f11437l;

    /* renamed from: m, reason: collision with root package name */
    public final long f11438m;

    /* renamed from: n, reason: collision with root package name */
    public long f11439n;

    /* renamed from: o, reason: collision with root package name */
    public final long f11440o;

    /* renamed from: p, reason: collision with root package name */
    public final long f11441p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11442q;

    /* renamed from: r, reason: collision with root package name */
    public final OutOfQuotaPolicy f11443r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11444s;

    /* renamed from: t, reason: collision with root package name */
    public final int f11445t;

    /* compiled from: WorkSpec.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    /* compiled from: WorkSpec.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11446a;

        /* renamed from: b, reason: collision with root package name */
        public final WorkInfo$State f11447b;

        public b(String str, WorkInfo$State workInfo$State) {
            zf.i.checkNotNullParameter(str, "id");
            zf.i.checkNotNullParameter(workInfo$State, AdOperationMetric.INIT_STATE);
            this.f11446a = str;
            this.f11447b = workInfo$State;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return zf.i.areEqual(this.f11446a, bVar.f11446a) && this.f11447b == bVar.f11447b;
        }

        public int hashCode() {
            return this.f11447b.hashCode() + (this.f11446a.hashCode() * 31);
        }

        public String toString() {
            return "IdAndState(id=" + this.f11446a + ", state=" + this.f11447b + ')';
        }
    }

    static {
        new a(null);
        String strTagWithPrefix = w2.g.tagWithPrefix("WorkSpec");
        zf.i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        f11425u = strTagWithPrefix;
    }

    public t(String str, WorkInfo$State workInfo$State, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, w2.b bVar3, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12) {
        zf.i.checkNotNullParameter(str, "id");
        zf.i.checkNotNullParameter(workInfo$State, AdOperationMetric.INIT_STATE);
        zf.i.checkNotNullParameter(str2, "workerClassName");
        zf.i.checkNotNullParameter(bVar, "input");
        zf.i.checkNotNullParameter(bVar2, "output");
        zf.i.checkNotNullParameter(bVar3, "constraints");
        zf.i.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        zf.i.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f11426a = str;
        this.f11427b = workInfo$State;
        this.f11428c = str2;
        this.f11429d = str3;
        this.f11430e = bVar;
        this.f11431f = bVar2;
        this.f11432g = j10;
        this.f11433h = j11;
        this.f11434i = j12;
        this.f11435j = bVar3;
        this.f11436k = i10;
        this.f11437l = backoffPolicy;
        this.f11438m = j13;
        this.f11439n = j14;
        this.f11440o = j15;
        this.f11441p = j16;
        this.f11442q = z10;
        this.f11443r = outOfQuotaPolicy;
        this.f11444s = i11;
        this.f11445t = i12;
    }

    public final long calculateNextRunTime() {
        if (isBackedOff()) {
            boolean z10 = this.f11437l == BackoffPolicy.LINEAR;
            int i10 = this.f11436k;
            long j10 = this.f11438m;
            return fg.h.coerceAtMost(z10 ? j10 * i10 : (long) Math.scalb(j10, i10 - 1), 18000000L) + this.f11439n;
        }
        boolean zIsPeriodic = isPeriodic();
        long j11 = this.f11432g;
        if (!zIsPeriodic) {
            long jCurrentTimeMillis = this.f11439n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + j11;
        }
        int i11 = this.f11444s;
        long j12 = this.f11439n;
        if (i11 == 0) {
            j12 += j11;
        }
        long j13 = this.f11434i;
        long j14 = this.f11433h;
        if (j13 != j14) {
            j = i11 == 0 ? (-1) * j13 : 0L;
            j12 += j14;
        } else if (i11 != 0) {
            j = j14;
        }
        return j12 + j;
    }

    public final t copy(String str, WorkInfo$State workInfo$State, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, w2.b bVar3, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12) {
        zf.i.checkNotNullParameter(str, "id");
        zf.i.checkNotNullParameter(workInfo$State, AdOperationMetric.INIT_STATE);
        zf.i.checkNotNullParameter(str2, "workerClassName");
        zf.i.checkNotNullParameter(bVar, "input");
        zf.i.checkNotNullParameter(bVar2, "output");
        zf.i.checkNotNullParameter(bVar3, "constraints");
        zf.i.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        zf.i.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new t(str, workInfo$State, str2, str3, bVar, bVar2, j10, j11, j12, bVar3, i10, backoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicy, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return zf.i.areEqual(this.f11426a, tVar.f11426a) && this.f11427b == tVar.f11427b && zf.i.areEqual(this.f11428c, tVar.f11428c) && zf.i.areEqual(this.f11429d, tVar.f11429d) && zf.i.areEqual(this.f11430e, tVar.f11430e) && zf.i.areEqual(this.f11431f, tVar.f11431f) && this.f11432g == tVar.f11432g && this.f11433h == tVar.f11433h && this.f11434i == tVar.f11434i && zf.i.areEqual(this.f11435j, tVar.f11435j) && this.f11436k == tVar.f11436k && this.f11437l == tVar.f11437l && this.f11438m == tVar.f11438m && this.f11439n == tVar.f11439n && this.f11440o == tVar.f11440o && this.f11441p == tVar.f11441p && this.f11442q == tVar.f11442q && this.f11443r == tVar.f11443r && this.f11444s == tVar.f11444s && this.f11445t == tVar.f11445t;
    }

    public final int getGeneration() {
        return this.f11445t;
    }

    public final int getPeriodCount() {
        return this.f11444s;
    }

    public final boolean hasConstraints() {
        return !zf.i.areEqual(w2.b.f20863i, this.f11435j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iB = ac.c.b(this.f11428c, (this.f11427b.hashCode() + (this.f11426a.hashCode() * 31)) * 31, 31);
        String str = this.f11429d;
        int iHashCode = (this.f11431f.hashCode() + ((this.f11430e.hashCode() + ((iB + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31;
        long j10 = this.f11432g;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f11433h;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f11434i;
        int iHashCode2 = (this.f11437l.hashCode() + ((((this.f11435j.hashCode() + ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31)) * 31) + this.f11436k) * 31)) * 31;
        long j13 = this.f11438m;
        int i12 = (iHashCode2 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f11439n;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f11440o;
        int i14 = (i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f11441p;
        int i15 = (i14 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        boolean z10 = this.f11442q;
        int i16 = z10;
        if (z10 != 0) {
            i16 = 1;
        }
        return ((((this.f11443r.hashCode() + ((i15 + i16) * 31)) * 31) + this.f11444s) * 31) + this.f11445t;
    }

    public final boolean isBackedOff() {
        return this.f11427b == WorkInfo$State.ENQUEUED && this.f11436k > 0;
    }

    public final boolean isPeriodic() {
        return this.f11433h != 0;
    }

    public final void setPeriodic(long j10) {
        if (j10 < 900000) {
            w2.g.get().warning(f11425u, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(fg.h.coerceAtLeast(j10, 900000L), fg.h.coerceAtLeast(j10, 900000L));
    }

    public String toString() {
        return ac.c.n(new StringBuilder("{WorkSpec: "), this.f11426a, '}');
    }

    public final void setPeriodic(long j10, long j11) {
        String str = f11425u;
        if (j10 < 900000) {
            w2.g.get().warning(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.f11433h = fg.h.coerceAtLeast(j10, 900000L);
        if (j11 < 300000) {
            w2.g.get().warning(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j11 > this.f11433h) {
            w2.g.get().warning(str, "Flex duration greater than interval duration; Changed to " + j10);
        }
        this.f11434i = fg.h.coerceIn(j11, 300000L, this.f11433h);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ t(String str, WorkInfo$State workInfo$State, String str2, String str3, androidx.work.b bVar, androidx.work.b bVar2, long j10, long j11, long j12, w2.b bVar3, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, int i13, zf.f fVar) {
        androidx.work.b bVar4;
        androidx.work.b bVar5;
        WorkInfo$State workInfo$State2 = (i13 & 2) != 0 ? WorkInfo$State.ENQUEUED : workInfo$State;
        String str4 = (i13 & 8) != 0 ? null : str3;
        if ((i13 & 16) != 0) {
            androidx.work.b bVar6 = androidx.work.b.f4506c;
            zf.i.checkNotNullExpressionValue(bVar6, "EMPTY");
            bVar4 = bVar6;
        } else {
            bVar4 = bVar;
        }
        if ((i13 & 32) != 0) {
            androidx.work.b bVar7 = androidx.work.b.f4506c;
            zf.i.checkNotNullExpressionValue(bVar7, "EMPTY");
            bVar5 = bVar7;
        } else {
            bVar5 = bVar2;
        }
        this(str, workInfo$State2, str2, str4, bVar4, bVar5, (i13 & 64) != 0 ? 0L : j10, (i13 & 128) != 0 ? 0L : j11, (i13 & 256) != 0 ? 0L : j12, (i13 & 512) != 0 ? w2.b.f20863i : bVar3, (i13 & 1024) != 0 ? 0 : i10, (i13 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i13 & 4096) != 0 ? 30000L : j13, (i13 & 8192) != 0 ? 0L : j14, (i13 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? 0L : j15, (32768 & i13) != 0 ? -1L : j16, (65536 & i13) != 0 ? false : z10, (131072 & i13) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i13) != 0 ? 0 : i11, (i13 & 524288) != 0 ? 0 : i12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(String str, String str2) {
        this(str, null, str2, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 1048570, null);
        zf.i.checkNotNullParameter(str, "id");
        zf.i.checkNotNullParameter(str2, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(String str, t tVar) {
        this(str, tVar.f11427b, tVar.f11428c, tVar.f11429d, new androidx.work.b(tVar.f11430e), new androidx.work.b(tVar.f11431f), tVar.f11432g, tVar.f11433h, tVar.f11434i, new w2.b(tVar.f11435j), tVar.f11436k, tVar.f11437l, tVar.f11438m, tVar.f11439n, tVar.f11440o, tVar.f11441p, tVar.f11442q, tVar.f11443r, tVar.f11444s, 0, 524288, null);
        zf.i.checkNotNullParameter(str, "newId");
        zf.i.checkNotNullParameter(tVar, "other");
    }
}
