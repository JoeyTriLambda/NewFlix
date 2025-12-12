package x5;

import android.net.Uri;
import l6.t;

/* compiled from: RangedUri.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final long f21587a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21588b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21589c;

    /* renamed from: d, reason: collision with root package name */
    public int f21590d;

    public f(String str, long j10, long j11) {
        this.f21589c = str == null ? "" : str;
        this.f21587a = j10;
        this.f21588b = j11;
    }

    public f attemptMerge(f fVar, String str) {
        long j10;
        String strResolveUriString = resolveUriString(str);
        if (fVar == null || !strResolveUriString.equals(fVar.resolveUriString(str))) {
            return null;
        }
        long j11 = fVar.f21588b;
        long j12 = this.f21588b;
        if (j12 != -1) {
            long j13 = this.f21587a;
            if (j13 + j12 == fVar.f21587a) {
                return new f(strResolveUriString, j13, j11 == -1 ? -1L : j12 + j11);
            }
            j10 = -1;
        } else {
            j10 = -1;
        }
        if (j11 == j10) {
            return null;
        }
        long j14 = fVar.f21587a;
        if (j14 + j11 == this.f21587a) {
            return new f(strResolveUriString, j14, j12 == j10 ? j10 : j11 + j12);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f21587a == fVar.f21587a && this.f21588b == fVar.f21588b && this.f21589c.equals(fVar.f21589c);
    }

    public int hashCode() {
        if (this.f21590d == 0) {
            this.f21590d = this.f21589c.hashCode() + ((((527 + ((int) this.f21587a)) * 31) + ((int) this.f21588b)) * 31);
        }
        return this.f21590d;
    }

    public Uri resolveUri(String str) {
        return t.resolveToUri(str, this.f21589c);
    }

    public String resolveUriString(String str) {
        return t.resolve(str, this.f21589c);
    }
}
