package k6;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: DataSpec.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f14959a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f14960b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14961c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14962d;

    /* renamed from: e, reason: collision with root package name */
    public final long f14963e;

    /* renamed from: f, reason: collision with root package name */
    public final String f14964f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14965g;

    public f(Uri uri, int i10) {
        this(uri, 0L, -1L, null, i10);
    }

    public boolean isFlagSet(int i10) {
        return (this.f14965g & i10) == i10;
    }

    public f subrange(long j10) {
        long j11 = this.f14963e;
        return subrange(j10, j11 != -1 ? j11 - j10 : -1L);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DataSpec[");
        sb2.append(this.f14959a);
        sb2.append(", ");
        sb2.append(Arrays.toString(this.f14960b));
        sb2.append(", ");
        sb2.append(this.f14961c);
        sb2.append(", ");
        sb2.append(this.f14962d);
        sb2.append(", ");
        sb2.append(this.f14963e);
        sb2.append(", ");
        sb2.append(this.f14964f);
        sb2.append(", ");
        return ac.c.m(sb2, this.f14965g, "]");
    }

    public f(Uri uri, long j10, long j11, String str) {
        this(uri, j10, j10, j11, str, 0);
    }

    public f subrange(long j10, long j11) {
        return (j10 == 0 && this.f14963e == j11) ? this : new f(this.f14959a, this.f14960b, this.f14961c + j10, this.f14962d + j10, j11, this.f14964f, this.f14965g);
    }

    public f(Uri uri, long j10, long j11, String str, int i10) {
        this(uri, j10, j10, j11, str, i10);
    }

    public f(Uri uri, long j10, long j11, long j12, String str, int i10) {
        this(uri, null, j10, j11, j12, str, i10);
    }

    public f(Uri uri, byte[] bArr, long j10, long j11, long j12, String str, int i10) {
        boolean z10 = true;
        l6.a.checkArgument(j10 >= 0);
        l6.a.checkArgument(j11 >= 0);
        if (j12 <= 0 && j12 != -1) {
            z10 = false;
        }
        l6.a.checkArgument(z10);
        this.f14959a = uri;
        this.f14960b = bArr;
        this.f14961c = j10;
        this.f14962d = j11;
        this.f14963e = j12;
        this.f14964f = str;
        this.f14965g = i10;
    }
}
