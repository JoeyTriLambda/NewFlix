package w2;

import android.net.Uri;
import androidx.work.NetworkType;
import java.util.Set;
import mf.z;

/* compiled from: Constraints.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final b f20863i;

    /* renamed from: a, reason: collision with root package name */
    public final NetworkType f20864a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20865b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20866c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20867d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20868e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20869f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20870g;

    /* renamed from: h, reason: collision with root package name */
    public final Set<C0302b> f20871h;

    /* compiled from: Constraints.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    /* compiled from: Constraints.kt */
    /* renamed from: w2.b$b, reason: collision with other inner class name */
    public static final class C0302b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f20872a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20873b;

        public C0302b(Uri uri, boolean z10) {
            zf.i.checkNotNullParameter(uri, "uri");
            this.f20872a = uri;
            this.f20873b = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!zf.i.areEqual(C0302b.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            zf.i.checkNotNull(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            C0302b c0302b = (C0302b) obj;
            return zf.i.areEqual(this.f20872a, c0302b.f20872a) && this.f20873b == c0302b.f20873b;
        }

        public final Uri getUri() {
            return this.f20872a;
        }

        public int hashCode() {
            return (this.f20872a.hashCode() * 31) + (this.f20873b ? 1231 : 1237);
        }

        public final boolean isTriggeredForDescendants() {
            return this.f20873b;
        }
    }

    static {
        new a(null);
        f20863i = new b(null, false, false, false, false, 0L, 0L, null, 255, null);
    }

    public b() {
        this(null, false, false, false, false, 0L, 0L, null, 255, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !zf.i.areEqual(b.class, obj.getClass())) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f20865b == bVar.f20865b && this.f20866c == bVar.f20866c && this.f20867d == bVar.f20867d && this.f20868e == bVar.f20868e && this.f20869f == bVar.f20869f && this.f20870g == bVar.f20870g && this.f20864a == bVar.f20864a) {
            return zf.i.areEqual(this.f20871h, bVar.f20871h);
        }
        return false;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.f20870g;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.f20869f;
    }

    public final Set<C0302b> getContentUriTriggers() {
        return this.f20871h;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.f20864a;
    }

    public final boolean hasContentUriTriggers() {
        return !this.f20871h.isEmpty();
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f20864a.hashCode() * 31) + (this.f20865b ? 1 : 0)) * 31) + (this.f20866c ? 1 : 0)) * 31) + (this.f20867d ? 1 : 0)) * 31) + (this.f20868e ? 1 : 0)) * 31;
        long j10 = this.f20869f;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f20870g;
        return this.f20871h.hashCode() + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31);
    }

    public final boolean requiresBatteryNotLow() {
        return this.f20867d;
    }

    public final boolean requiresCharging() {
        return this.f20865b;
    }

    public final boolean requiresDeviceIdle() {
        return this.f20866c;
    }

    public final boolean requiresStorageNotLow() {
        return this.f20868e;
    }

    public b(NetworkType networkType, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, Set<C0302b> set) {
        zf.i.checkNotNullParameter(networkType, "requiredNetworkType");
        zf.i.checkNotNullParameter(set, "contentUriTriggers");
        this.f20864a = networkType;
        this.f20865b = z10;
        this.f20866c = z11;
        this.f20867d = z12;
        this.f20868e = z13;
        this.f20869f = j10;
        this.f20870g = j11;
        this.f20871h = set;
    }

    public /* synthetic */ b(NetworkType networkType, boolean z10, boolean z11, boolean z12, boolean z13, long j10, long j11, Set set, int i10, zf.f fVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) == 0 ? z13 : false, (i10 & 32) != 0 ? -1L : j10, (i10 & 64) == 0 ? j11 : -1L, (i10 & 128) != 0 ? z.emptySet() : set);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(b bVar) {
        zf.i.checkNotNullParameter(bVar, "other");
        boolean z10 = bVar.f20865b;
        boolean z11 = bVar.f20866c;
        this(bVar.f20864a, z10, z11, bVar.f20867d, bVar.f20868e, bVar.f20869f, bVar.f20870g, bVar.f20871h);
    }
}
