package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import c5.i;
import c5.j;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import e5.d;
import e5.e;
import f5.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import l6.u;

@TargetApi(16)
/* loaded from: classes.dex */
public abstract class MediaCodecRenderer extends c5.a {

    /* renamed from: f0, reason: collision with root package name */
    public static final byte[] f5856f0 = u.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    public final MediaCodec.BufferInfo A;
    public i B;
    public DrmSession<c> C;
    public DrmSession<c> D;
    public MediaCodec E;
    public p5.a F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public ByteBuffer[] P;
    public ByteBuffer[] Q;
    public long R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f5857a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f5858b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f5859c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f5860d0;

    /* renamed from: e0, reason: collision with root package name */
    public d f5861e0;

    /* renamed from: t, reason: collision with root package name */
    public final a f5862t;

    /* renamed from: u, reason: collision with root package name */
    public final f5.a<c> f5863u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f5864v;

    /* renamed from: w, reason: collision with root package name */
    public final e f5865w;

    /* renamed from: x, reason: collision with root package name */
    public final e f5866x;

    /* renamed from: y, reason: collision with root package name */
    public final j f5867y;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f5868z;

    public MediaCodecRenderer(int i10, a aVar, f5.a<c> aVar2, boolean z10) {
        super(i10);
        l6.a.checkState(u.f15907a >= 16);
        this.f5862t = (a) l6.a.checkNotNull(aVar);
        this.f5863u = aVar2;
        this.f5864v = z10;
        this.f5865w = new e(0);
        this.f5866x = e.newFlagsOnlyInstance();
        this.f5867y = new j();
        this.f5868z = new ArrayList();
        this.A = new MediaCodec.BufferInfo();
        this.W = 0;
        this.X = 0;
    }

    public final void a() throws ExoPlaybackException {
        if (this.X == 2) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.f5858b0 = true;
            renderToEndOfStream();
        }
    }

    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z10, i iVar, i iVar2) {
        return false;
    }

    public abstract void configureCodec(p5.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    public void flushCodec() throws ExoPlaybackException {
        this.R = -9223372036854775807L;
        this.S = -1;
        this.T = -1;
        this.f5860d0 = true;
        this.f5859c0 = false;
        this.U = false;
        this.f5868z.clear();
        this.N = false;
        this.O = false;
        if (this.I || ((this.K && this.Z) || this.X != 0)) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.E.flush();
            this.Y = false;
        }
        if (!this.V || this.B == null) {
            return;
        }
        this.W = 1;
    }

    public final MediaCodec getCodec() {
        return this.E;
    }

    public final p5.a getCodecInfo() {
        return this.F;
    }

    public p5.a getDecoderInfo(a aVar, i iVar, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        return aVar.getDecoderInfo(iVar.f5120q, z10);
    }

    public long getDequeueOutputBufferTimeoutUs() {
        return 0L;
    }

    @Override // c5.o
    public boolean isEnded() {
        return this.f5858b0;
    }

    @Override // c5.o
    public boolean isReady() {
        return (this.B == null || this.f5859c0 || (!isSourceReady() && this.T < 0 && (this.R == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.R))) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void maybeInitCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.maybeInitCodec():void");
    }

    public abstract void onCodecInitialized(String str, long j10, long j11);

    @Override // c5.a
    public void onDisabled() {
        f5.a<c> aVar = this.f5863u;
        this.B = null;
        try {
            releaseCodec();
            try {
                DrmSession<c> drmSession = this.C;
                if (drmSession != null) {
                    ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession);
                }
                try {
                    DrmSession<c> drmSession2 = this.D;
                    if (drmSession2 != null && drmSession2 != this.C) {
                        ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession2);
                    }
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    DrmSession<c> drmSession3 = this.D;
                    if (drmSession3 != null && drmSession3 != this.C) {
                        ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession3);
                    }
                    throw th2;
                } finally {
                }
            }
        } catch (Throwable th3) {
            try {
                if (this.C != null) {
                    ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(this.C);
                }
                try {
                    DrmSession<c> drmSession4 = this.D;
                    if (drmSession4 != null && drmSession4 != this.C) {
                        ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession4);
                    }
                    throw th3;
                } finally {
                }
            } catch (Throwable th4) {
                try {
                    DrmSession<c> drmSession5 = this.D;
                    if (drmSession5 != null && drmSession5 != this.C) {
                        ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession5);
                    }
                    throw th4;
                } finally {
                }
            }
        }
    }

    @Override // c5.a
    public void onEnabled(boolean z10) throws ExoPlaybackException {
        this.f5861e0 = new d();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onInputFormatChanged(c5.i r6) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r5 = this;
            c5.i r0 = r5.B
            r5.B = r6
            com.google.android.exoplayer2.drm.c r6 = r6.f5123t
            r1 = 0
            if (r0 != 0) goto Lb
            r2 = r1
            goto Ld
        Lb:
            com.google.android.exoplayer2.drm.c r2 = r0.f5123t
        Ld:
            boolean r6 = l6.u.areEqual(r6, r2)
            r2 = 1
            r6 = r6 ^ r2
            if (r6 == 0) goto L4c
            c5.i r6 = r5.B
            com.google.android.exoplayer2.drm.c r6 = r6.f5123t
            if (r6 == 0) goto L4a
            f5.a<f5.c> r6 = r5.f5863u
            if (r6 == 0) goto L3a
            android.os.Looper r1 = android.os.Looper.myLooper()
            c5.i r3 = r5.B
            com.google.android.exoplayer2.drm.c r3 = r3.f5123t
            r4 = r6
            com.google.android.exoplayer2.drm.a r4 = (com.google.android.exoplayer2.drm.a) r4
            com.google.android.exoplayer2.drm.DrmSession r1 = r4.acquireSession(r1, r3)
            r5.D = r1
            com.google.android.exoplayer2.drm.DrmSession<f5.c> r3 = r5.C
            if (r1 != r3) goto L4c
            com.google.android.exoplayer2.drm.a r6 = (com.google.android.exoplayer2.drm.a) r6
            r6.releaseSession(r1)
            goto L4c
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r6.<init>(r0)
            int r0 = r5.getIndex()
            com.google.android.exoplayer2.ExoPlaybackException r6 = com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(r6, r0)
            throw r6
        L4a:
            r5.D = r1
        L4c:
            com.google.android.exoplayer2.drm.DrmSession<f5.c> r6 = r5.D
            com.google.android.exoplayer2.drm.DrmSession<f5.c> r1 = r5.C
            if (r6 != r1) goto L80
            android.media.MediaCodec r6 = r5.E
            if (r6 == 0) goto L80
            p5.a r1 = r5.F
            boolean r1 = r1.f17599b
            c5.i r3 = r5.B
            boolean r6 = r5.canReconfigureCodec(r6, r1, r0, r3)
            if (r6 == 0) goto L80
            r5.V = r2
            r5.W = r2
            int r6 = r5.G
            r1 = 2
            if (r6 == r1) goto L7d
            if (r6 != r2) goto L7c
            c5.i r6 = r5.B
            int r1 = r6.f5124u
            int r3 = r0.f5124u
            if (r1 != r3) goto L7c
            int r6 = r6.f5125v
            int r0 = r0.f5125v
            if (r6 != r0) goto L7c
            goto L7d
        L7c:
            r2 = 0
        L7d:
            r5.N = r2
            goto L8d
        L80:
            boolean r6 = r5.Y
            if (r6 == 0) goto L87
            r5.X = r2
            goto L8d
        L87:
            r5.releaseCodec()
            r5.maybeInitCodec()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(c5.i):void");
    }

    public abstract void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException;

    @Override // c5.a
    public void onPositionReset(long j10, boolean z10) throws ExoPlaybackException {
        this.f5857a0 = false;
        this.f5858b0 = false;
        if (this.E != null) {
            flushCodec();
        }
    }

    public abstract boolean processOutputBuffer(long j10, long j11, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i10, int i11, long j12, boolean z10) throws ExoPlaybackException;

    public void releaseCodec() {
        f5.a<c> aVar = this.f5863u;
        this.R = -9223372036854775807L;
        this.S = -1;
        this.T = -1;
        this.f5859c0 = false;
        this.U = false;
        this.f5868z.clear();
        this.P = null;
        this.Q = null;
        this.F = null;
        this.V = false;
        this.Y = false;
        this.H = false;
        this.I = false;
        this.G = 0;
        this.J = false;
        this.K = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.Z = false;
        this.W = 0;
        this.X = 0;
        this.f5865w.f11142n = null;
        MediaCodec mediaCodec = this.E;
        if (mediaCodec != null) {
            this.f5861e0.getClass();
            try {
                mediaCodec.stop();
                try {
                    this.E.release();
                    this.E = null;
                    DrmSession<c> drmSession = this.C;
                    if (drmSession == null || this.D == drmSession) {
                        return;
                    }
                    try {
                        ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession);
                    } finally {
                    }
                } catch (Throwable th2) {
                    this.E = null;
                    DrmSession<c> drmSession2 = this.C;
                    if (drmSession2 != null && this.D != drmSession2) {
                        try {
                            ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession2);
                        } finally {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    this.E.release();
                    this.E = null;
                    DrmSession<c> drmSession3 = this.C;
                    if (drmSession3 != null && this.D != drmSession3) {
                        try {
                            ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession3);
                        } finally {
                        }
                    }
                    throw th3;
                } catch (Throwable th4) {
                    this.E = null;
                    DrmSession<c> drmSession4 = this.C;
                    if (drmSession4 != null && this.D != drmSession4) {
                        try {
                            ((com.google.android.exoplayer2.drm.a) aVar).releaseSession(drmSession4);
                        } finally {
                        }
                    }
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0310 A[Catch: CryptoException -> 0x0376, TryCatch #4 {CryptoException -> 0x0376, blocks: (B:182:0x0308, B:184:0x0310, B:186:0x031c, B:188:0x0324, B:195:0x033d, B:197:0x0368, B:191:0x032d, B:193:0x0331, B:194:0x0335, B:196:0x0351), top: B:226:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0324 A[Catch: CryptoException -> 0x0376, TryCatch #4 {CryptoException -> 0x0376, blocks: (B:182:0x0308, B:184:0x0310, B:186:0x031c, B:188:0x0324, B:195:0x033d, B:197:0x0368, B:191:0x032d, B:193:0x0331, B:194:0x0335, B:196:0x0351), top: B:226:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0351 A[Catch: CryptoException -> 0x0376, TryCatch #4 {CryptoException -> 0x0376, blocks: (B:182:0x0308, B:184:0x0310, B:186:0x031c, B:188:0x0324, B:195:0x033d, B:197:0x0368, B:191:0x032d, B:193:0x0331, B:194:0x0335, B:196:0x0351), top: B:226:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0390 A[LOOP:1: B:91:0x01a6->B:207:0x0390, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01a6 A[EDGE_INSN: B:228:0x01a6->B:91:0x01a6 BREAK  A[LOOP:0: B:17:0x0040->B:90:0x019e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019b A[PHI: r0 r15 r22 r23
  0x019b: PHI (r0v10 boolean) = (r0v11 boolean), (r0v14 boolean), (r0v14 boolean) binds: [B:86:0x0190, B:83:0x016b, B:84:0x016d] A[DONT_GENERATE, DONT_INLINE]
  0x019b: PHI (r15v2 int) = (r15v3 int), (r15v5 int), (r15v5 int) binds: [B:86:0x0190, B:83:0x016b, B:84:0x016d] A[DONT_GENERATE, DONT_INLINE]
  0x019b: PHI (r22v1 java.util.ArrayList) = (r22v2 java.util.ArrayList), (r22v4 java.util.ArrayList), (r22v4 java.util.ArrayList) binds: [B:86:0x0190, B:83:0x016b, B:84:0x016d] A[DONT_GENERATE, DONT_INLINE]
  0x019b: PHI (r23v1 c5.j) = (r23v2 c5.j), (r23v4 c5.j), (r23v4 c5.j) binds: [B:86:0x0190, B:83:0x016b, B:84:0x016d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019e A[LOOP:0: B:17:0x0040->B:90:0x019e, LOOP_END] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v15 */
    @Override // c5.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void render(long r31, long r33) throws com.google.android.exoplayer2.ExoPlaybackException, android.media.MediaCodec.CryptoException {
        /*
            Method dump skipped, instructions count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.render(long, long):void");
    }

    public boolean shouldInitCodec(p5.a aVar) {
        return true;
    }

    @Override // c5.p
    public final int supportsFormat(i iVar) throws ExoPlaybackException {
        try {
            int iSupportsFormat = supportsFormat(this.f5862t, iVar);
            if ((iSupportsFormat & 7) <= 2) {
                return iSupportsFormat;
            }
            f5.a<c> aVar = this.f5863u;
            com.google.android.exoplayer2.drm.c cVar = iVar.f5123t;
            return !(cVar == null ? true : aVar == null ? false : ((com.google.android.exoplayer2.drm.a) aVar).canAcquireSession(cVar)) ? (iSupportsFormat & (-8)) | 2 : iSupportsFormat;
        } catch (MediaCodecUtil.DecoderQueryException e10) {
            throw ExoPlaybackException.createForRenderer(e10, getIndex());
        }
    }

    public abstract int supportsFormat(a aVar, i iVar) throws MediaCodecUtil.DecoderQueryException;

    @Override // c5.a, c5.p
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        public DecoderInitializationException(i iVar, Throwable th2, boolean z10, int i10) {
            super("Decoder init failed: [" + i10 + "], " + iVar, th2);
            String str = iVar.f5120q;
            Math.abs(i10);
        }

        public DecoderInitializationException(i iVar, Throwable th2, boolean z10, String str) {
            super("Decoder init failed: " + str + ", " + iVar, th2);
            String str2 = iVar.f5120q;
            if (u.f15907a < 21 || !(th2 instanceof MediaCodec.CodecException)) {
                return;
            }
            ((MediaCodec.CodecException) th2).getDiagnosticInfo();
        }
    }

    @Override // c5.a
    public void onStarted() {
    }

    @Override // c5.a
    public void onStopped() {
    }

    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    public void onProcessedOutputBuffer(long j10) {
    }

    public void onQueueInputBuffer(e eVar) {
    }
}
