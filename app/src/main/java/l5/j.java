package l5;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import l5.h;
import l5.k;
import l6.l;

/* compiled from: VorbisReader.java */
/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: n, reason: collision with root package name */
    public a f15829n;

    /* renamed from: o, reason: collision with root package name */
    public int f15830o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15831p;

    /* renamed from: q, reason: collision with root package name */
    public k.d f15832q;

    /* renamed from: r, reason: collision with root package name */
    public k.b f15833r;

    /* compiled from: VorbisReader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final k.d f15834a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f15835b;

        /* renamed from: c, reason: collision with root package name */
        public final k.c[] f15836c;

        /* renamed from: d, reason: collision with root package name */
        public final int f15837d;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i10) {
            this.f15834a = dVar;
            this.f15835b = bArr;
            this.f15836c = cVarArr;
            this.f15837d = i10;
        }
    }

    public static boolean verifyBitstreamType(l lVar) {
        try {
            return k.verifyVorbisHeaderCapturePattern(1, lVar, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // l5.h
    public void onSeekEnd(long j10) {
        super.onSeekEnd(j10);
        this.f15831p = j10 != 0;
        k.d dVar = this.f15832q;
        this.f15830o = dVar != null ? dVar.f15842d : 0;
    }

    @Override // l5.h
    public long preparePayload(l lVar) {
        byte b10 = lVar.f15881a[0];
        if ((b10 & 1) == 1) {
            return -1L;
        }
        a aVar = this.f15829n;
        boolean z10 = aVar.f15836c[(b10 >> 1) & (255 >>> (8 - aVar.f15837d))].f15838a;
        k.d dVar = aVar.f15834a;
        int i10 = !z10 ? dVar.f15842d : dVar.f15843e;
        long j10 = this.f15831p ? (this.f15830o + i10) / 4 : 0;
        lVar.setLimit(lVar.limit() + 4);
        lVar.f15881a[lVar.limit() - 4] = (byte) (j10 & 255);
        lVar.f15881a[lVar.limit() - 3] = (byte) ((j10 >>> 8) & 255);
        lVar.f15881a[lVar.limit() - 2] = (byte) ((j10 >>> 16) & 255);
        lVar.f15881a[lVar.limit() - 1] = (byte) ((j10 >>> 24) & 255);
        this.f15831p = true;
        this.f15830o = i10;
        return j10;
    }

    @Override // l5.h
    public boolean readHeaders(l lVar, long j10, h.a aVar) throws InterruptedException, IOException {
        if (this.f15829n != null) {
            return false;
        }
        a aVar2 = null;
        if (this.f15832q == null) {
            this.f15832q = k.readVorbisIdentificationHeader(lVar);
        } else if (this.f15833r == null) {
            this.f15833r = k.readVorbisCommentHeader(lVar);
        } else {
            byte[] bArr = new byte[lVar.limit()];
            System.arraycopy(lVar.f15881a, 0, bArr, 0, lVar.limit());
            aVar2 = new a(this.f15832q, this.f15833r, bArr, k.readVorbisModes(lVar, this.f15832q.f15839a), k.iLog(r8.length - 1));
        }
        this.f15829n = aVar2;
        if (aVar2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15829n.f15834a.f15844f);
        arrayList.add(this.f15829n.f15835b);
        k.d dVar = this.f15829n.f15834a;
        aVar.f15823a = c5.i.createAudioSampleFormat(null, "audio/vorbis", null, dVar.f15841c, -1, dVar.f15839a, (int) dVar.f15840b, arrayList, null, 0, null);
        return true;
    }

    @Override // l5.h
    public void reset(boolean z10) {
        super.reset(z10);
        if (z10) {
            this.f15829n = null;
            this.f15832q = null;
            this.f15833r = null;
        }
        this.f15830o = 0;
        this.f15831p = false;
    }
}
