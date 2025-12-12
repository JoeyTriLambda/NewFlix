package a6;

import a6.a;
import a6.b;
import android.util.Base64;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import java.io.IOException;
import java.util.ArrayList;
import k5.k;
import k6.m;
import u5.a;
import u5.g;
import u5.l;
import u5.n;
import u5.o;
import v5.f;

/* compiled from: SsMediaPeriod.java */
/* loaded from: classes.dex */
public final class c implements g, l.a<f<b>> {

    /* renamed from: b, reason: collision with root package name */
    public final b.a f341b;

    /* renamed from: m, reason: collision with root package name */
    public final m f342m;

    /* renamed from: n, reason: collision with root package name */
    public final int f343n;

    /* renamed from: o, reason: collision with root package name */
    public final a.C0284a f344o;

    /* renamed from: p, reason: collision with root package name */
    public final k6.b f345p;

    /* renamed from: q, reason: collision with root package name */
    public final o f346q;

    /* renamed from: r, reason: collision with root package name */
    public final k[] f347r;

    /* renamed from: s, reason: collision with root package name */
    public g.a f348s;

    /* renamed from: t, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f349t;

    /* renamed from: u, reason: collision with root package name */
    public f<b>[] f350u;

    /* renamed from: v, reason: collision with root package name */
    public u5.c f351v;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i10, a.C0284a c0284a, m mVar, k6.b bVar) {
        this.f341b = aVar2;
        this.f342m = mVar;
        this.f343n = i10;
        this.f344o = c0284a;
        this.f345p = bVar;
        n[] nVarArr = new n[aVar.f5995c.length];
        int i11 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f5995c;
            if (i11 >= bVarArr.length) {
                break;
            }
            nVarArr[i11] = new n(bVarArr[i11].f6002c);
            i11++;
        }
        this.f346q = new o(nVarArr);
        a.C0073a c0073a = aVar.f5994b;
        if (c0073a != null) {
            StringBuilder sb2 = new StringBuilder();
            int i12 = 0;
            while (true) {
                byte[] bArr = c0073a.f5999b;
                if (i12 >= bArr.length) {
                    break;
                }
                sb2.append((char) bArr[i12]);
                i12 += 2;
            }
            String string = sb2.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            byte b10 = bArrDecode[0];
            bArrDecode[0] = bArrDecode[3];
            bArrDecode[3] = b10;
            byte b11 = bArrDecode[1];
            bArrDecode[1] = bArrDecode[2];
            bArrDecode[2] = b11;
            byte b12 = bArrDecode[4];
            bArrDecode[4] = bArrDecode[5];
            bArrDecode[5] = b12;
            byte b13 = bArrDecode[6];
            bArrDecode[6] = bArrDecode[7];
            bArrDecode[7] = b13;
            this.f347r = new k[]{new k(true, null, 8, bArrDecode, 0, 0, null)};
        } else {
            this.f347r = null;
        }
        this.f349t = aVar;
        f<b>[] fVarArr = new f[0];
        this.f350u = fVarArr;
        this.f351v = new u5.c(fVarArr);
    }

    @Override // u5.g, u5.l
    public boolean continueLoading(long j10) {
        return this.f351v.continueLoading(j10);
    }

    @Override // u5.g, u5.l
    public long getBufferedPositionUs() {
        return this.f351v.getBufferedPositionUs();
    }

    @Override // u5.g, u5.l
    public long getNextLoadPositionUs() {
        return this.f351v.getNextLoadPositionUs();
    }

    @Override // u5.g
    public o getTrackGroups() {
        return this.f346q;
    }

    @Override // u5.g
    public void maybeThrowPrepareError() throws IOException {
        this.f342m.maybeThrowError();
    }

    @Override // u5.g
    public void prepare(g.a aVar, long j10) {
        this.f348s = aVar;
        aVar.onPrepared(this);
    }

    @Override // u5.g
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void release() {
        for (f<b> fVar : this.f350u) {
            fVar.release();
        }
    }

    @Override // u5.g
    public long seekToUs(long j10) {
        for (f<b> fVar : this.f350u) {
            fVar.seekToUs(j10);
        }
        return j10;
    }

    @Override // u5.g
    public long selectTracks(j6.f[] fVarArr, boolean[] zArr, u5.k[] kVarArr, boolean[] zArr2, long j10) {
        j6.f fVar;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < fVarArr.length; i10++) {
            u5.k kVar = kVarArr[i10];
            if (kVar != null) {
                f fVar2 = (f) kVar;
                if (fVarArr[i10] == null || !zArr[i10]) {
                    fVar2.release();
                    kVarArr[i10] = null;
                } else {
                    arrayList.add(fVar2);
                }
            }
            if (kVarArr[i10] == null && (fVar = fVarArr[i10]) != null) {
                int iIndexOf = this.f346q.indexOf(fVar.getTrackGroup());
                f fVar3 = new f(this.f349t.f5995c[iIndexOf].f6000a, null, ((a.C0005a) this.f341b).createChunkSource(this.f342m, this.f349t, iIndexOf, fVar, this.f347r), this, this.f345p, j10, this.f343n, this.f344o);
                arrayList.add(fVar3);
                kVarArr[i10] = fVar3;
                zArr2[i10] = true;
            }
        }
        f<b>[] fVarArr2 = new f[arrayList.size()];
        this.f350u = fVarArr2;
        arrayList.toArray(fVarArr2);
        this.f351v = new u5.c(this.f350u);
        return j10;
    }

    public void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f349t = aVar;
        for (f<b> fVar : this.f350u) {
            ((b) fVar.getChunkSource()).updateManifest(aVar);
        }
        this.f348s.onContinueLoadingRequested(this);
    }

    @Override // u5.l.a
    public void onContinueLoadingRequested(f<b> fVar) {
        this.f348s.onContinueLoadingRequested(this);
    }

    @Override // u5.g
    public void discardBuffer(long j10) {
    }
}
