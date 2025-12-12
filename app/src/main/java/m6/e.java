package m6;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import c5.i;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.util.List;
import l6.s;
import l6.u;
import m6.g;

/* compiled from: MediaCodecVideoRenderer.java */
@TargetApi(16)
/* loaded from: classes.dex */
public final class e extends MediaCodecRenderer {
    public static final int[] N0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public int A0;
    public int B0;
    public int C0;
    public float D0;
    public int E0;
    public int F0;
    public int G0;
    public float H0;
    public boolean I0;
    public int J0;
    public b K0;
    public long L0;
    public int M0;

    /* renamed from: g0, reason: collision with root package name */
    public final Context f16135g0;

    /* renamed from: h0, reason: collision with root package name */
    public final f f16136h0;

    /* renamed from: i0, reason: collision with root package name */
    public final g.a f16137i0;

    /* renamed from: j0, reason: collision with root package name */
    public final long f16138j0;

    /* renamed from: k0, reason: collision with root package name */
    public final int f16139k0;

    /* renamed from: l0, reason: collision with root package name */
    public final boolean f16140l0;

    /* renamed from: m0, reason: collision with root package name */
    public final long[] f16141m0;

    /* renamed from: n0, reason: collision with root package name */
    public i[] f16142n0;

    /* renamed from: o0, reason: collision with root package name */
    public a f16143o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f16144p0;

    /* renamed from: q0, reason: collision with root package name */
    public Surface f16145q0;

    /* renamed from: r0, reason: collision with root package name */
    public c f16146r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f16147s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f16148t0;

    /* renamed from: u0, reason: collision with root package name */
    public long f16149u0;

    /* renamed from: v0, reason: collision with root package name */
    public long f16150v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f16151w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f16152x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f16153y0;

    /* renamed from: z0, reason: collision with root package name */
    public float f16154z0;

    /* compiled from: MediaCodecVideoRenderer.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f16155a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16156b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16157c;

        public a(int i10, int i11, int i12) {
            this.f16155a = i10;
            this.f16156b = i11;
            this.f16157c = i12;
        }
    }

    /* compiled from: MediaCodecVideoRenderer.java */
    @TargetApi(23)
    public final class b implements MediaCodec.OnFrameRenderedListener {
        public b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
            e eVar = e.this;
            if (this != eVar.K0) {
                return;
            }
            eVar.f();
        }
    }

    public e(Context context, com.google.android.exoplayer2.mediacodec.a aVar, long j10, f5.a<f5.c> aVar2, boolean z10, Handler handler, g gVar, int i10) {
        super(2, aVar, aVar2, z10);
        this.f16138j0 = j10;
        this.f16139k0 = i10;
        this.f16135g0 = context.getApplicationContext();
        this.f16136h0 = new f(context);
        this.f16137i0 = new g.a(handler, gVar);
        this.f16140l0 = u.f15907a <= 22 && "foster".equals(u.f15908b) && "NVIDIA".equals(u.f15909c);
        this.f16141m0 = new long[10];
        this.L0 = -9223372036854775807L;
        this.f16149u0 = -9223372036854775807L;
        this.A0 = -1;
        this.B0 = -1;
        this.D0 = -1.0f;
        this.f16154z0 = -1.0f;
        this.f16147s0 = 1;
        this.E0 = -1;
        this.F0 = -1;
        this.H0 = -1.0f;
        this.G0 = -1;
    }

    public static boolean b(boolean z10, i iVar, i iVar2) {
        if (!iVar.f5120q.equals(iVar2.f5120q)) {
            return false;
        }
        int i10 = iVar.f5127x;
        if (i10 == -1) {
            i10 = 0;
        }
        int i11 = iVar2.f5127x;
        if (i11 == -1) {
            i11 = 0;
        }
        if (i10 == i11) {
            return z10 || (iVar.f5124u == iVar2.f5124u && iVar.f5125v == iVar2.f5125v);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(int r5, int r6, java.lang.String r7) {
        /*
            r0 = -1
            if (r5 == r0) goto L83
            if (r6 != r0) goto L7
            goto L83
        L7:
            r7.getClass()
            int r1 = r7.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L4d;
                case -1662541442: goto L42;
                case 1187890754: goto L37;
                case 1331836730: goto L2c;
                case 1599127256: goto L21;
                case 1599127257: goto L16;
                default: goto L14;
            }
        L14:
            r7 = -1
            goto L57
        L16:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L1f
            goto L14
        L1f:
            r7 = 5
            goto L57
        L21:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L2a
            goto L14
        L2a:
            r7 = 4
            goto L57
        L2c:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L35
            goto L14
        L35:
            r7 = 3
            goto L57
        L37:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L40
            goto L14
        L40:
            r7 = 2
            goto L57
        L42:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L4b
            goto L14
        L4b:
            r7 = 1
            goto L57
        L4d:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L56
            goto L14
        L56:
            r7 = 0
        L57:
            switch(r7) {
                case 0: goto L7a;
                case 1: goto L77;
                case 2: goto L7a;
                case 3: goto L5b;
                case 4: goto L7a;
                case 5: goto L77;
                default: goto L5a;
            }
        L5a:
            return r0
        L5b:
            java.lang.String r7 = "BRAVIA 4K 2015"
            java.lang.String r1 = l6.u.f15910d
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L66
            return r0
        L66:
            r7 = 16
            int r5 = l6.u.ceilDivide(r5, r7)
            int r6 = l6.u.ceilDivide(r6, r7)
            int r6 = r6 * r5
            int r6 = r6 * 16
            int r5 = r6 * 16
            goto L7c
        L77:
            int r5 = r5 * r6
            goto L7d
        L7a:
            int r5 = r5 * r6
        L7c:
            r2 = 2
        L7d:
            int r5 = r5 * 3
            int r2 = r2 * 2
            int r5 = r5 / r2
            return r5
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.e.d(int, int, java.lang.String):int");
    }

    public static int e(i iVar) {
        if (iVar.f5121r == -1) {
            return d(iVar.f5124u, iVar.f5125v, iVar.f5120q);
        }
        List<byte[]> list = iVar.f5122s;
        int size = list.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += list.get(i10).length;
        }
        return iVar.f5121r + length;
    }

    public final void c() {
        MediaCodec codec;
        this.f16148t0 = false;
        if (u.f15907a < 23 || !this.I0 || (codec = getCodec()) == null) {
            return;
        }
        this.K0 = new b(codec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean canReconfigureCodec(MediaCodec mediaCodec, boolean z10, i iVar, i iVar2) {
        if (b(z10, iVar, iVar2)) {
            a aVar = this.f16143o0;
            if (iVar2.f5124u <= aVar.f16155a && iVar2.f5125v <= aVar.f16156b && e(iVar2) <= this.f16143o0.f16157c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(p5.a aVar, MediaCodec mediaCodec, i iVar, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        a codecMaxValues = getCodecMaxValues(aVar, iVar, this.f16142n0);
        this.f16143o0 = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(iVar, codecMaxValues, this.f16140l0, this.J0);
        if (this.f16145q0 == null) {
            l6.a.checkState(h(aVar.f17601d));
            if (this.f16146r0 == null) {
                this.f16146r0 = c.newInstanceV17(this.f16135g0, aVar.f17601d);
            }
            this.f16145q0 = this.f16146r0;
        }
        mediaCodec.configure(mediaFormat, this.f16145q0, mediaCrypto, 0);
        if (u.f15907a < 23 || !this.I0) {
            return;
        }
        this.K0 = new b(mediaCodec);
    }

    public void dropOutputBuffer(MediaCodec mediaCodec, int i10, long j10) {
        s.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i10, false);
        s.endSection();
        e5.d dVar = this.f5861e0;
        dVar.getClass();
        this.f16151w0++;
        int i11 = this.f16152x0 + 1;
        this.f16152x0 = i11;
        dVar.f11140a = Math.max(i11, dVar.f11140a);
        int i12 = this.f16151w0;
        if (i12 != this.f16139k0 || i12 <= 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f16137i0.droppedFrames(this.f16151w0, jElapsedRealtime - this.f16150v0);
        this.f16151w0 = 0;
        this.f16150v0 = jElapsedRealtime;
    }

    public final void f() {
        if (this.f16148t0) {
            return;
        }
        this.f16148t0 = true;
        this.f16137i0.renderedFirstFrame(this.f16145q0);
    }

    public final void g() {
        int i10 = this.A0;
        if (i10 == -1 && this.B0 == -1) {
            return;
        }
        if (this.E0 == i10 && this.F0 == this.B0 && this.G0 == this.C0 && this.H0 == this.D0) {
            return;
        }
        this.f16137i0.videoSizeChanged(i10, this.B0, this.C0, this.D0);
        this.E0 = this.A0;
        this.F0 = this.B0;
        this.G0 = this.C0;
        this.H0 = this.D0;
    }

    public a getCodecMaxValues(p5.a aVar, i iVar, i[] iVarArr) throws MediaCodecUtil.DecoderQueryException {
        String str;
        Point point;
        int i10;
        int iMax = iVar.f5124u;
        int iE = e(iVar);
        int length = iVarArr.length;
        int i11 = iVar.f5125v;
        if (length == 1) {
            return new a(iMax, i11, iE);
        }
        int i12 = 0;
        int iMax2 = i11;
        boolean z10 = false;
        for (i iVar2 : iVarArr) {
            if (b(aVar.f17599b, iVar, iVar2)) {
                int i13 = iVar2.f5125v;
                int i14 = iVar2.f5124u;
                z10 |= i14 == -1 || i13 == -1;
                iMax = Math.max(iMax, i14);
                iMax2 = Math.max(iMax2, i13);
                iE = Math.max(iE, e(iVar2));
            }
        }
        if (z10) {
            String str2 = "MediaCodecVideoRenderer";
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            int i15 = iVar.f5124u;
            boolean z11 = i11 > i15;
            int i16 = z11 ? i11 : i15;
            if (z11) {
                i11 = i15;
            }
            float f10 = i11 / i16;
            int[] iArr = N0;
            while (i12 < 9) {
                int i17 = iArr[i12];
                int i18 = (int) (i17 * f10);
                if (i17 <= i16 || i18 <= i11) {
                    break;
                }
                float f11 = f10;
                if (u.f15907a >= 21) {
                    int i19 = z11 ? i18 : i17;
                    if (!z11) {
                        i17 = i18;
                    }
                    point = aVar.alignVideoSizeV21(i19, i17);
                    str = str2;
                    i10 = i16;
                    if (aVar.isVideoSizeAndRateSupportedV21(point.x, point.y, iVar.f5126w)) {
                        break;
                    }
                    i12++;
                    f10 = f11;
                    str2 = str;
                    i16 = i10;
                } else {
                    str = str2;
                    i10 = i16;
                    int iCeilDivide = u.ceilDivide(i17, 16) * 16;
                    int iCeilDivide2 = u.ceilDivide(i18, 16) * 16;
                    if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i20 = z11 ? iCeilDivide2 : iCeilDivide;
                        if (!z11) {
                            iCeilDivide = iCeilDivide2;
                        }
                        point = new Point(i20, iCeilDivide);
                    } else {
                        i12++;
                        f10 = f11;
                        str2 = str;
                        i16 = i10;
                    }
                }
            }
            str = str2;
            point = null;
            if (point != null) {
                iMax = Math.max(iMax, point.x);
                iMax2 = Math.max(iMax2, point.y);
                iE = Math.max(iE, d(iMax, iMax2, iVar.f5120q));
                Log.w(str, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iE);
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(i iVar, a aVar, boolean z10, int i10) {
        MediaFormat frameworkMediaFormatV16 = iVar.getFrameworkMediaFormatV16();
        frameworkMediaFormatV16.setInteger("max-width", aVar.f16155a);
        frameworkMediaFormatV16.setInteger("max-height", aVar.f16156b);
        int i11 = aVar.f16157c;
        if (i11 != -1) {
            frameworkMediaFormatV16.setInteger("max-input-size", i11);
        }
        if (z10) {
            frameworkMediaFormatV16.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            frameworkMediaFormatV16.setFeatureEnabled("tunneled-playback", true);
            frameworkMediaFormatV16.setInteger("audio-session-id", i10);
        }
        return frameworkMediaFormatV16;
    }

    public final boolean h(boolean z10) {
        return u.f15907a >= 23 && !this.I0 && (!z10 || c.isSecureSupported(this.f16135g0));
    }

    @Override // c5.a, c5.d.a
    public void handleMessage(int i10, Object obj) throws ExoPlaybackException {
        if (i10 != 1) {
            if (i10 != 4) {
                super.handleMessage(i10, obj);
                return;
            }
            this.f16147s0 = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.f16147s0);
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        Surface surface2 = surface;
        if (surface == null) {
            c cVar = this.f16146r0;
            if (cVar != null) {
                surface2 = cVar;
            } else {
                p5.a codecInfo = getCodecInfo();
                surface2 = surface;
                if (codecInfo != null) {
                    boolean z10 = codecInfo.f17601d;
                    surface2 = surface;
                    if (h(z10)) {
                        c cVarNewInstanceV17 = c.newInstanceV17(this.f16135g0, z10);
                        this.f16146r0 = cVarNewInstanceV17;
                        surface2 = cVarNewInstanceV17;
                    }
                }
            }
        }
        Surface surface3 = this.f16145q0;
        g.a aVar = this.f16137i0;
        if (surface3 == surface2) {
            if (surface2 == null || surface2 == this.f16146r0) {
                return;
            }
            int i11 = this.E0;
            if (i11 != -1 || this.F0 != -1) {
                aVar.videoSizeChanged(i11, this.F0, this.G0, this.H0);
            }
            if (this.f16148t0) {
                aVar.renderedFirstFrame(this.f16145q0);
                return;
            }
            return;
        }
        this.f16145q0 = surface2;
        int state = getState();
        if (state == 1 || state == 2) {
            MediaCodec codec2 = getCodec();
            if (u.f15907a < 23 || codec2 == null || surface2 == null || this.f16144p0) {
                releaseCodec();
                maybeInitCodec();
            } else {
                codec2.setOutputSurface(surface2);
            }
        }
        if (surface2 == null || surface2 == this.f16146r0) {
            this.E0 = -1;
            this.F0 = -1;
            this.H0 = -1.0f;
            this.G0 = -1;
            c();
            return;
        }
        int i12 = this.E0;
        if (i12 != -1 || this.F0 != -1) {
            aVar.videoSizeChanged(i12, this.F0, this.G0, this.H0);
        }
        c();
        if (state == 2) {
            long j10 = this.f16138j0;
            this.f16149u0 = j10 > 0 ? SystemClock.elapsedRealtime() + j10 : -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.o
    public boolean isReady() {
        c cVar;
        if (super.isReady() && (this.f16148t0 || (((cVar = this.f16146r0) != null && this.f16145q0 == cVar) || getCodec() == null || this.I0))) {
            this.f16149u0 = -9223372036854775807L;
            return true;
        }
        if (this.f16149u0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f16149u0) {
            return true;
        }
        this.f16149u0 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j10, long j11) {
        this.f16137i0.decoderInitialized(str, j10, j11);
        String str2 = u.f15908b;
        this.f16144p0 = (("deb".equals(str2) || "flo".equals(str2)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(str2) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onDisabled() {
        g.a aVar = this.f16137i0;
        this.A0 = -1;
        this.B0 = -1;
        this.D0 = -1.0f;
        this.f16154z0 = -1.0f;
        this.L0 = -9223372036854775807L;
        this.M0 = 0;
        this.E0 = -1;
        this.F0 = -1;
        this.H0 = -1.0f;
        this.G0 = -1;
        c();
        this.f16136h0.disable();
        this.K0 = null;
        this.I0 = false;
        try {
            super.onDisabled();
        } finally {
            this.f5861e0.ensureUpdated();
            aVar.disabled(this.f5861e0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onEnabled(boolean z10) throws ExoPlaybackException {
        super.onEnabled(z10);
        int i10 = getConfiguration().f5147a;
        this.J0 = i10;
        this.I0 = i10 != 0;
        this.f16137i0.enabled(this.f5861e0);
        this.f16136h0.enable();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(i iVar) throws ExoPlaybackException {
        super.onInputFormatChanged(iVar);
        this.f16137i0.inputFormatChanged(iVar);
        float f10 = iVar.f5128y;
        if (f10 == -1.0f) {
            f10 = 1.0f;
        }
        this.f16154z0 = f10;
        int i10 = iVar.f5127x;
        if (i10 == -1) {
            i10 = 0;
        }
        this.f16153y0 = i10;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.A0 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.B0 = integer;
        float f10 = this.f16154z0;
        this.D0 = f10;
        if (u.f15907a >= 21) {
            int i10 = this.f16153y0;
            if (i10 == 90 || i10 == 270) {
                int i11 = this.A0;
                this.A0 = integer;
                this.B0 = i11;
                this.D0 = 1.0f / f10;
            }
        } else {
            this.C0 = this.f16153y0;
        }
        mediaCodec.setVideoScalingMode(this.f16147s0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onPositionReset(long j10, boolean z10) throws ExoPlaybackException {
        super.onPositionReset(j10, z10);
        c();
        this.f16152x0 = 0;
        int i10 = this.M0;
        if (i10 != 0) {
            this.L0 = this.f16141m0[i10 - 1];
            this.M0 = 0;
        }
        if (!z10) {
            this.f16149u0 = -9223372036854775807L;
        } else {
            long j11 = this.f16138j0;
            this.f16149u0 = j11 > 0 ? SystemClock.elapsedRealtime() + j11 : -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(e5.e eVar) {
        if (u.f15907a >= 23 || !this.I0) {
            return;
        }
        f();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onStarted() {
        super.onStarted();
        this.f16151w0 = 0;
        this.f16150v0 = SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onStopped() {
        this.f16149u0 = -9223372036854775807L;
        if (this.f16151w0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f16137i0.droppedFrames(this.f16151w0, jElapsedRealtime - this.f16150v0);
            this.f16151w0 = 0;
            this.f16150v0 = jElapsedRealtime;
        }
        super.onStopped();
    }

    @Override // c5.a
    public void onStreamChanged(i[] iVarArr, long j10) throws ExoPlaybackException {
        this.f16142n0 = iVarArr;
        if (this.L0 == -9223372036854775807L) {
            this.L0 = j10;
        } else {
            int i10 = this.M0;
            long[] jArr = this.f16141m0;
            if (i10 == jArr.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + jArr[this.M0 - 1]);
            } else {
                this.M0 = i10 + 1;
            }
            jArr[this.M0 - 1] = j10;
        }
        super.onStreamChanged(iVarArr, j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j10, long j11, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i10, int i11, long j12, boolean z10) throws InterruptedException {
        while (true) {
            int i12 = this.M0;
            if (i12 == 0) {
                break;
            }
            long[] jArr = this.f16141m0;
            long j13 = jArr[0];
            if (j12 < j13) {
                break;
            }
            this.L0 = j13;
            int i13 = i12 - 1;
            this.M0 = i13;
            System.arraycopy(jArr, 1, jArr, 0, i13);
        }
        long j14 = j12 - this.L0;
        if (z10) {
            skipOutputBuffer(mediaCodec, i10, j14);
            return true;
        }
        long j15 = j12 - j10;
        if (this.f16145q0 == this.f16146r0) {
            if (!(j15 < -30000)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i10, j14);
            return true;
        }
        if (!this.f16148t0) {
            if (u.f15907a >= 21) {
                renderOutputBufferV21(mediaCodec, i10, j14, System.nanoTime());
            } else {
                renderOutputBuffer(mediaCodec, i10, j14);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long jElapsedRealtime = j15 - ((SystemClock.elapsedRealtime() * 1000) - j11);
        long jNanoTime = System.nanoTime();
        long jAdjustReleaseTime = this.f16136h0.adjustReleaseTime(j12, (jElapsedRealtime * 1000) + jNanoTime);
        long j16 = (jAdjustReleaseTime - jNanoTime) / 1000;
        if (shouldDropOutputBuffer(j16, j11)) {
            dropOutputBuffer(mediaCodec, i10, j14);
            return true;
        }
        if (u.f15907a >= 21) {
            if (j16 < 50000) {
                renderOutputBufferV21(mediaCodec, i10, j14, jAdjustReleaseTime);
                return true;
            }
        } else if (j16 < 30000) {
            if (j16 > 11000) {
                try {
                    Thread.sleep((j16 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            renderOutputBuffer(mediaCodec, i10, j14);
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void releaseCodec() {
        try {
            super.releaseCodec();
            c cVar = this.f16146r0;
            if (cVar != null) {
                if (this.f16145q0 == cVar) {
                    this.f16145q0 = null;
                }
                cVar.release();
                this.f16146r0 = null;
            }
        } catch (Throwable th2) {
            if (this.f16146r0 != null) {
                Surface surface = this.f16145q0;
                c cVar2 = this.f16146r0;
                if (surface == cVar2) {
                    this.f16145q0 = null;
                }
                cVar2.release();
                this.f16146r0 = null;
            }
            throw th2;
        }
    }

    public void renderOutputBuffer(MediaCodec mediaCodec, int i10, long j10) {
        g();
        s.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i10, true);
        s.endSection();
        this.f5861e0.getClass();
        this.f16152x0 = 0;
        f();
    }

    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i10, long j10, long j11) {
        g();
        s.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i10, j11);
        s.endSection();
        this.f5861e0.getClass();
        this.f16152x0 = 0;
        f();
    }

    public boolean shouldDropOutputBuffer(long j10, long j11) {
        return j10 < -30000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(p5.a aVar) {
        return this.f16145q0 != null || h(aVar.f17601d);
    }

    public void skipOutputBuffer(MediaCodec mediaCodec, int i10, long j10) {
        s.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i10, false);
        s.endSection();
        this.f5861e0.getClass();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.a aVar, i iVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z10;
        int i10;
        int i11;
        String str = iVar.f5120q;
        if (!l6.i.isVideo(str)) {
            return 0;
        }
        com.google.android.exoplayer2.drm.c cVar = iVar.f5123t;
        if (cVar != null) {
            z10 = false;
            for (int i12 = 0; i12 < cVar.f5836n; i12++) {
                z10 |= cVar.get(i12).f5842q;
            }
        } else {
            z10 = false;
        }
        p5.a decoderInfo = aVar.getDecoderInfo(str, z10);
        if (decoderInfo == null) {
            return 1;
        }
        boolean zIsCodecSupported = decoderInfo.isCodecSupported(iVar.f5117n);
        if (zIsCodecSupported && (i10 = iVar.f5124u) > 0 && (i11 = iVar.f5125v) > 0) {
            if (u.f15907a >= 21) {
                zIsCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(i10, i11, iVar.f5126w);
            } else {
                boolean z11 = i10 * i11 <= MediaCodecUtil.maxH264DecodableFrameSize();
                if (!z11) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + i10 + "x" + i11 + "] [" + u.f15911e + "]");
                }
                zIsCodecSupported = z11;
            }
        }
        return (zIsCodecSupported ? 4 : 3) | (decoderInfo.f17599b ? 16 : 8) | (decoderInfo.f17600c ? 32 : 0);
    }
}
