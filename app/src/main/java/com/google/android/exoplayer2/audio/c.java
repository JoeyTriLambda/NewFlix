package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import c5.i;
import c5.m;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioTrack;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import l6.h;
import l6.u;

/* compiled from: MediaCodecAudioRenderer.java */
@TargetApi(16)
/* loaded from: classes.dex */
public final class c extends MediaCodecRenderer implements h {

    /* renamed from: g0, reason: collision with root package name */
    public final a.C0068a f5779g0;

    /* renamed from: h0, reason: collision with root package name */
    public final AudioTrack f5780h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f5781i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f5782j0;

    /* renamed from: k0, reason: collision with root package name */
    public MediaFormat f5783k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f5784l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f5785m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f5786n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f5787o0;

    /* compiled from: MediaCodecAudioRenderer.java */
    public final class a implements AudioTrack.d {
        public a() {
        }

        public void onAudioSessionId(int i10) {
            c cVar = c.this;
            cVar.f5779g0.audioSessionId(i10);
            cVar.onAudioSessionId(i10);
        }

        public void onPositionDiscontinuity() {
            c cVar = c.this;
            cVar.onAudioTrackPositionDiscontinuity();
            cVar.f5787o0 = true;
        }

        public void onUnderrun(int i10, long j10, long j11) {
            c.this.f5779g0.audioTrackUnderrun(i10, j10, j11);
            c.this.onAudioTrackUnderrun(i10, j10, j11);
        }
    }

    public c(com.google.android.exoplayer2.mediacodec.a aVar, f5.a<f5.c> aVar2, boolean z10, Handler handler, com.google.android.exoplayer2.audio.a aVar3, d5.c cVar, AudioProcessor... audioProcessorArr) {
        super(1, aVar, aVar2, z10);
        this.f5780h0 = new AudioTrack(cVar, audioProcessorArr, new a());
        this.f5779g0 = new a.C0068a(handler, aVar3);
    }

    public boolean allowPassthrough(String str) {
        return this.f5780h0.isPassthroughSupported(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void configureCodec(p5.a r5, android.media.MediaCodec r6, c5.i r7, android.media.MediaCrypto r8) {
        /*
            r4 = this;
            java.lang.String r5 = r5.f17598a
            int r0 = l6.u.f15907a
            r1 = 24
            r2 = 0
            if (r0 >= r1) goto L37
            java.lang.String r0 = "OMX.SEC.aac.dec"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L37
            java.lang.String r5 = "samsung"
            java.lang.String r0 = l6.u.f15909c
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L37
            java.lang.String r5 = l6.u.f15908b
            java.lang.String r0 = "zeroflte"
            boolean r0 = r5.startsWith(r0)
            if (r0 != 0) goto L35
            java.lang.String r0 = "herolte"
            boolean r0 = r5.startsWith(r0)
            if (r0 != 0) goto L35
            java.lang.String r0 = "heroqlte"
            boolean r5 = r5.startsWith(r0)
            if (r5 == 0) goto L37
        L35:
            r5 = 1
            goto L38
        L37:
            r5 = 0
        L38:
            r4.f5782j0 = r5
            boolean r5 = r4.f5781i0
            r0 = 0
            if (r5 == 0) goto L59
            android.media.MediaFormat r5 = r7.getFrameworkMediaFormatV16()
            r4.f5783k0 = r5
            java.lang.String r1 = "audio/raw"
            java.lang.String r3 = "mime"
            r5.setString(r3, r1)
            android.media.MediaFormat r5 = r4.f5783k0
            r6.configure(r5, r0, r8, r2)
            android.media.MediaFormat r5 = r4.f5783k0
            java.lang.String r6 = r7.f5120q
            r5.setString(r3, r6)
            goto L62
        L59:
            android.media.MediaFormat r5 = r7.getFrameworkMediaFormatV16()
            r6.configure(r5, r0, r8, r2)
            r4.f5783k0 = r0
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.c.configureCodec(p5.a, android.media.MediaCodec, c5.i, android.media.MediaCrypto):void");
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public p5.a getDecoderInfo(com.google.android.exoplayer2.mediacodec.a aVar, i iVar, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        p5.a passthroughDecoderInfo;
        if (!allowPassthrough(iVar.f5120q) || (passthroughDecoderInfo = aVar.getPassthroughDecoderInfo()) == null) {
            this.f5781i0 = false;
            return super.getDecoderInfo(aVar, iVar, z10);
        }
        this.f5781i0 = true;
        return passthroughDecoderInfo;
    }

    @Override // l6.h
    public m getPlaybackParameters() {
        return this.f5780h0.getPlaybackParameters();
    }

    @Override // l6.h
    public long getPositionUs() {
        long currentPositionUs = this.f5780h0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.f5787o0) {
                currentPositionUs = Math.max(this.f5786n0, currentPositionUs);
            }
            this.f5786n0 = currentPositionUs;
            this.f5787o0 = false;
        }
        return this.f5786n0;
    }

    @Override // c5.a, c5.d.a
    public void handleMessage(int i10, Object obj) throws ExoPlaybackException, IllegalStateException {
        AudioTrack audioTrack = this.f5780h0;
        if (i10 == 2) {
            audioTrack.setVolume(((Float) obj).floatValue());
        } else if (i10 != 3) {
            super.handleMessage(i10, obj);
        } else {
            audioTrack.setAudioAttributes((d5.b) obj);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.o
    public boolean isEnded() {
        return super.isEnded() && this.f5780h0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.o
    public boolean isReady() {
        return this.f5780h0.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(String str, long j10, long j11) {
        this.f5779g0.decoderInitialized(str, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onDisabled() {
        a.C0068a c0068a = this.f5779g0;
        try {
            this.f5780h0.release();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th2) {
            try {
                super.onDisabled();
                throw th2;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onEnabled(boolean z10) throws ExoPlaybackException, IllegalStateException {
        super.onEnabled(z10);
        this.f5779g0.enabled(this.f5861e0);
        int i10 = getConfiguration().f5147a;
        AudioTrack audioTrack = this.f5780h0;
        if (i10 != 0) {
            audioTrack.enableTunnelingV21(i10);
        } else {
            audioTrack.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(i iVar) throws ExoPlaybackException {
        super.onInputFormatChanged(iVar);
        this.f5779g0.inputFormatChanged(iVar);
        this.f5784l0 = "audio/raw".equals(iVar.f5120q) ? iVar.E : 2;
        this.f5785m0 = iVar.C;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws IllegalStateException, ExoPlaybackException {
        int[] iArr;
        int i10;
        MediaFormat mediaFormat2 = this.f5783k0;
        boolean z10 = mediaFormat2 != null;
        String string = z10 ? mediaFormat2.getString("mime") : "audio/raw";
        if (z10) {
            mediaFormat = this.f5783k0;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f5782j0 && integer == 6 && (i10 = this.f5785m0) < 6) {
            iArr = new int[i10];
            for (int i11 = 0; i11 < this.f5785m0; i11++) {
                iArr[i11] = i11;
            }
        } else {
            iArr = null;
        }
        try {
            this.f5780h0.configure(string, integer, integer2, this.f5784l0, 0, iArr);
        } catch (AudioTrack.ConfigurationException e10) {
            throw ExoPlaybackException.createForRenderer(e10, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onPositionReset(long j10, boolean z10) throws ExoPlaybackException, IllegalStateException {
        super.onPositionReset(j10, z10);
        this.f5780h0.reset();
        this.f5786n0 = j10;
        this.f5787o0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onStarted() throws IllegalStateException {
        super.onStarted();
        this.f5780h0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c5.a
    public void onStopped() throws IllegalStateException {
        this.f5780h0.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j10, long j11, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i10, int i11, long j12, boolean z10) throws ExoPlaybackException {
        if (this.f5781i0 && (i11 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i10, false);
            return true;
        }
        AudioTrack audioTrack = this.f5780h0;
        if (z10) {
            mediaCodec.releaseOutputBuffer(i10, false);
            this.f5861e0.getClass();
            audioTrack.handleDiscontinuity();
            return true;
        }
        try {
            if (!audioTrack.handleBuffer(byteBuffer, j12)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i10, false);
            this.f5861e0.getClass();
            return true;
        } catch (AudioTrack.InitializationException | AudioTrack.WriteException e10) {
            throw ExoPlaybackException.createForRenderer(e10, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws IllegalStateException, ExoPlaybackException {
        try {
            this.f5780h0.playToEndOfStream();
        } catch (AudioTrack.WriteException e10) {
            throw ExoPlaybackException.createForRenderer(e10, getIndex());
        }
    }

    @Override // l6.h
    public m setPlaybackParameters(m mVar) {
        return this.f5780h0.setPlaybackParameters(mVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.a aVar, i iVar) throws MediaCodecUtil.DecoderQueryException {
        int i10;
        int i11;
        String str = iVar.f5120q;
        boolean z10 = false;
        if (!l6.i.isAudio(str)) {
            return 0;
        }
        int i12 = u.f15907a;
        int i13 = i12 >= 21 ? 32 : 0;
        if (allowPassthrough(str) && aVar.getPassthroughDecoderInfo() != null) {
            return i13 | 8 | 4;
        }
        p5.a decoderInfo = aVar.getDecoderInfo(str, false);
        if (decoderInfo == null) {
            return 1;
        }
        if (i12 < 21 || (((i10 = iVar.D) == -1 || decoderInfo.isAudioSampleRateSupportedV21(i10)) && ((i11 = iVar.C) == -1 || decoderInfo.isAudioChannelCountSupportedV21(i11)))) {
            z10 = true;
        }
        return i13 | 8 | (z10 ? 4 : 3);
    }

    @Override // c5.a, c5.o
    public h getMediaClock() {
        return this;
    }

    public void onAudioTrackPositionDiscontinuity() {
    }

    public void onAudioSessionId(int i10) {
    }

    public void onAudioTrackUnderrun(int i10, long j10, long j11) {
    }
}
