package t8;

import t8.g0;

/* compiled from: AutoValue_StaticSessionData_DeviceData.java */
/* loaded from: classes.dex */
public final class d0 extends g0.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f19672a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19673b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19674c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19675d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19676e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19677f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19678g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19679h;

    /* renamed from: i, reason: collision with root package name */
    public final String f19680i;

    public d0(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f19672a = i10;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f19673b = str;
        this.f19674c = i11;
        this.f19675d = j10;
        this.f19676e = j11;
        this.f19677f = z10;
        this.f19678g = i12;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f19679h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f19680i = str3;
    }

    @Override // t8.g0.b
    public int arch() {
        return this.f19672a;
    }

    @Override // t8.g0.b
    public int availableProcessors() {
        return this.f19674c;
    }

    @Override // t8.g0.b
    public long diskSpace() {
        return this.f19676e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.b)) {
            return false;
        }
        g0.b bVar = (g0.b) obj;
        return this.f19672a == bVar.arch() && this.f19673b.equals(bVar.model()) && this.f19674c == bVar.availableProcessors() && this.f19675d == bVar.totalRam() && this.f19676e == bVar.diskSpace() && this.f19677f == bVar.isEmulator() && this.f19678g == bVar.state() && this.f19679h.equals(bVar.manufacturer()) && this.f19680i.equals(bVar.modelClass());
    }

    public int hashCode() {
        int iHashCode = (((((this.f19672a ^ 1000003) * 1000003) ^ this.f19673b.hashCode()) * 1000003) ^ this.f19674c) * 1000003;
        long j10 = this.f19675d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f19676e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f19677f ? 1231 : 1237)) * 1000003) ^ this.f19678g) * 1000003) ^ this.f19679h.hashCode()) * 1000003) ^ this.f19680i.hashCode();
    }

    @Override // t8.g0.b
    public boolean isEmulator() {
        return this.f19677f;
    }

    @Override // t8.g0.b
    public String manufacturer() {
        return this.f19679h;
    }

    @Override // t8.g0.b
    public String model() {
        return this.f19673b;
    }

    @Override // t8.g0.b
    public String modelClass() {
        return this.f19680i;
    }

    @Override // t8.g0.b
    public int state() {
        return this.f19678g;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DeviceData{arch=");
        sb2.append(this.f19672a);
        sb2.append(", model=");
        sb2.append(this.f19673b);
        sb2.append(", availableProcessors=");
        sb2.append(this.f19674c);
        sb2.append(", totalRam=");
        sb2.append(this.f19675d);
        sb2.append(", diskSpace=");
        sb2.append(this.f19676e);
        sb2.append(", isEmulator=");
        sb2.append(this.f19677f);
        sb2.append(", state=");
        sb2.append(this.f19678g);
        sb2.append(", manufacturer=");
        sb2.append(this.f19679h);
        sb2.append(", modelClass=");
        return ac.c.o(sb2, this.f19680i, "}");
    }

    @Override // t8.g0.b
    public long totalRam() {
        return this.f19675d;
    }
}
