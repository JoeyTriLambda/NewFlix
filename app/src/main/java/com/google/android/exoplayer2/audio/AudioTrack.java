package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import c5.m;
import com.google.android.exoplayer2.audio.c;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import l6.u;

/* loaded from: classes.dex */
public final class AudioTrack {
    public long A;
    public long B;
    public boolean C;
    public long D;
    public Method E;
    public int F;
    public long G;
    public long H;
    public int I;
    public long J;
    public long K;
    public int L;
    public int M;
    public long N;
    public long O;
    public long P;
    public float Q;
    public AudioProcessor[] R;
    public ByteBuffer[] S;
    public ByteBuffer T;
    public ByteBuffer U;
    public byte[] V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final d5.c f5705a;

    /* renamed from: a0, reason: collision with root package name */
    public int f5706a0;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.b f5707b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f5708b0;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.e f5709c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f5710c0;

    /* renamed from: d, reason: collision with root package name */
    public final AudioProcessor[] f5711d;

    /* renamed from: d0, reason: collision with root package name */
    public long f5712d0;

    /* renamed from: e, reason: collision with root package name */
    public final d f5713e;

    /* renamed from: f, reason: collision with root package name */
    public final ConditionVariable f5714f = new ConditionVariable(true);

    /* renamed from: g, reason: collision with root package name */
    public final long[] f5715g;

    /* renamed from: h, reason: collision with root package name */
    public final b f5716h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedList<e> f5717i;

    /* renamed from: j, reason: collision with root package name */
    public android.media.AudioTrack f5718j;

    /* renamed from: k, reason: collision with root package name */
    public int f5719k;

    /* renamed from: l, reason: collision with root package name */
    public int f5720l;

    /* renamed from: m, reason: collision with root package name */
    public int f5721m;

    /* renamed from: n, reason: collision with root package name */
    public int f5722n;

    /* renamed from: o, reason: collision with root package name */
    public d5.b f5723o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5724p;

    /* renamed from: q, reason: collision with root package name */
    public int f5725q;

    /* renamed from: r, reason: collision with root package name */
    public long f5726r;

    /* renamed from: s, reason: collision with root package name */
    public m f5727s;

    /* renamed from: t, reason: collision with root package name */
    public m f5728t;

    /* renamed from: u, reason: collision with root package name */
    public long f5729u;

    /* renamed from: v, reason: collision with root package name */
    public long f5730v;

    /* renamed from: w, reason: collision with root package name */
    public ByteBuffer f5731w;

    /* renamed from: x, reason: collision with root package name */
    public int f5732x;

    /* renamed from: y, reason: collision with root package name */
    public int f5733y;

    /* renamed from: z, reason: collision with root package name */
    public int f5734z;

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th2) {
            super(th2);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public InitializationException(int i10, int i11, int i12, int i13) {
            StringBuilder sbT = ac.c.t("AudioTrack init failed: ", i10, ", Config(", i11, ", ");
            sbT.append(i12);
            sbT.append(", ");
            sbT.append(i13);
            sbT.append(")");
            super(sbT.toString());
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
    }

    public static final class WriteException extends Exception {
        public WriteException(int i10) {
            super(ac.c.f("AudioTrack write failed: ", i10));
        }
    }

    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ android.media.AudioTrack f5735b;

        public a(android.media.AudioTrack audioTrack) {
            this.f5735b = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AudioTrack audioTrack = AudioTrack.this;
            android.media.AudioTrack audioTrack2 = this.f5735b;
            try {
                audioTrack2.flush();
                audioTrack2.release();
            } finally {
                audioTrack.f5714f.open();
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public android.media.AudioTrack f5737a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5738b;

        /* renamed from: c, reason: collision with root package name */
        public int f5739c;

        /* renamed from: d, reason: collision with root package name */
        public long f5740d;

        /* renamed from: e, reason: collision with root package name */
        public long f5741e;

        /* renamed from: f, reason: collision with root package name */
        public long f5742f;

        /* renamed from: g, reason: collision with root package name */
        public long f5743g;

        /* renamed from: h, reason: collision with root package name */
        public long f5744h;

        /* renamed from: i, reason: collision with root package name */
        public long f5745i;

        public long getPlaybackHeadPosition() {
            if (this.f5743g != -9223372036854775807L) {
                return Math.min(this.f5745i, this.f5744h + ((((SystemClock.elapsedRealtime() * 1000) - this.f5743g) * this.f5739c) / 1000000));
            }
            int playState = this.f5737a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = this.f5737a.getPlaybackHeadPosition() & 4294967295L;
            if (this.f5738b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f5742f = this.f5740d;
                }
                playbackHeadPosition += this.f5742f;
            }
            if (this.f5740d > playbackHeadPosition) {
                this.f5741e++;
            }
            this.f5740d = playbackHeadPosition;
            return playbackHeadPosition + (this.f5741e << 32);
        }

        public long getPositionUs() {
            return (getPlaybackHeadPosition() * 1000000) / this.f5739c;
        }

        public long getTimestampFramePosition() {
            throw new UnsupportedOperationException();
        }

        public long getTimestampNanoTime() {
            throw new UnsupportedOperationException();
        }

        public void handleEndOfStream(long j10) throws IllegalStateException {
            this.f5744h = getPlaybackHeadPosition();
            this.f5743g = SystemClock.elapsedRealtime() * 1000;
            this.f5745i = j10;
            this.f5737a.stop();
        }

        public void pause() throws IllegalStateException {
            if (this.f5743g != -9223372036854775807L) {
                return;
            }
            this.f5737a.pause();
        }

        public void reconfigure(android.media.AudioTrack audioTrack, boolean z10) {
            this.f5737a = audioTrack;
            this.f5738b = z10;
            this.f5743g = -9223372036854775807L;
            this.f5740d = 0L;
            this.f5741e = 0L;
            this.f5742f = 0L;
            if (audioTrack != null) {
                this.f5739c = audioTrack.getSampleRate();
            }
        }

        public boolean updateTimestamp() {
            return false;
        }
    }

    @TargetApi(19)
    public static class c extends b {

        /* renamed from: j, reason: collision with root package name */
        public final AudioTimestamp f5746j = new AudioTimestamp();

        /* renamed from: k, reason: collision with root package name */
        public long f5747k;

        /* renamed from: l, reason: collision with root package name */
        public long f5748l;

        /* renamed from: m, reason: collision with root package name */
        public long f5749m;

        @Override // com.google.android.exoplayer2.audio.AudioTrack.b
        public long getTimestampFramePosition() {
            return this.f5749m;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.b
        public long getTimestampNanoTime() {
            return this.f5746j.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.b
        public void reconfigure(android.media.AudioTrack audioTrack, boolean z10) {
            super.reconfigure(audioTrack, z10);
            this.f5747k = 0L;
            this.f5748l = 0L;
            this.f5749m = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrack.b
        public boolean updateTimestamp() {
            android.media.AudioTrack audioTrack = this.f5737a;
            AudioTimestamp audioTimestamp = this.f5746j;
            boolean timestamp = audioTrack.getTimestamp(audioTimestamp);
            if (timestamp) {
                long j10 = audioTimestamp.framePosition;
                if (this.f5748l > j10) {
                    this.f5747k++;
                }
                this.f5748l = j10;
                this.f5749m = j10 + (this.f5747k << 32);
            }
            return timestamp;
        }
    }

    public interface d {
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final m f5750a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5751b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5752c;

        public e(m mVar, long j10, long j11) {
            this.f5750a = mVar;
            this.f5751b = j10;
            this.f5752c = j11;
        }
    }

    public AudioTrack(d5.c cVar, AudioProcessor[] audioProcessorArr, d dVar) {
        this.f5705a = cVar;
        this.f5713e = dVar;
        if (u.f15907a >= 18) {
            try {
                this.E = android.media.AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (u.f15907a >= 19) {
            this.f5716h = new c();
        } else {
            this.f5716h = new b();
        }
        com.google.android.exoplayer2.audio.b bVar = new com.google.android.exoplayer2.audio.b();
        this.f5707b = bVar;
        com.google.android.exoplayer2.audio.e eVar = new com.google.android.exoplayer2.audio.e();
        this.f5709c = eVar;
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 3];
        this.f5711d = audioProcessorArr2;
        audioProcessorArr2[0] = new com.google.android.exoplayer2.audio.d();
        audioProcessorArr2[1] = bVar;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 2, audioProcessorArr.length);
        audioProcessorArr2[audioProcessorArr.length + 2] = eVar;
        this.f5715g = new long[10];
        this.Q = 1.0f;
        this.M = 0;
        this.f5723o = d5.b.f10861e;
        this.f5706a0 = 0;
        this.f5728t = m.f5142d;
        this.X = -1;
        this.R = new AudioProcessor[0];
        this.S = new ByteBuffer[0];
        this.f5717i = new LinkedList<>();
    }

    public static int b(String str) {
        str.getClass();
        switch (str) {
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/eac3":
                return 6;
            case "audio/vnd.dts.hd":
                return 8;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0033 -> B:19:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() throws com.google.android.exoplayer2.audio.AudioTrack.WriteException {
        /*
            r10 = this;
            int r0 = r10.X
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L14
            boolean r0 = r10.f5724p
            if (r0 == 0) goto Lf
            com.google.android.exoplayer2.audio.AudioProcessor[] r0 = r10.R
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r10.X = r0
            r0 = r10
            goto L38
        L14:
            r4 = 0
            r0 = r10
        L16:
            int r5 = r0.X
            com.google.android.exoplayer2.audio.AudioProcessor[] r6 = r0.R
            int r7 = r6.length
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 >= r7) goto L3a
            r5 = r6[r5]
            if (r4 == 0) goto L29
            r5.queueEndOfStream()
        L29:
            r0.f(r8)
            boolean r4 = r5.isEnded()
            if (r4 != 0) goto L33
            return r2
        L33:
            int r4 = r0.X
            int r4 = r4 + r1
            r0.X = r4
        L38:
            r4 = 1
            goto L16
        L3a:
            java.nio.ByteBuffer r4 = r0.U
            if (r4 == 0) goto L46
            r0.i(r4, r8)
            java.nio.ByteBuffer r4 = r0.U
            if (r4 == 0) goto L46
            return r2
        L46:
            r0.X = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.a():boolean");
    }

    public final long c() {
        return this.f5724p ? this.K : this.J / this.I;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void configure(java.lang.String r9, int r10, int r11, int r12, int r13, int[] r14) throws java.lang.IllegalStateException, com.google.android.exoplayer2.audio.AudioTrack.ConfigurationException {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.configure(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean d() {
        return this.f5718j != null;
    }

    public void disableTunneling() throws IllegalStateException {
        if (this.f5708b0) {
            this.f5708b0 = false;
            this.f5706a0 = 0;
            reset();
        }
    }

    public final boolean e() {
        int i10;
        return u.f15907a < 23 && ((i10 = this.f5722n) == 5 || i10 == 6);
    }

    public void enableTunnelingV21(int i10) throws IllegalStateException {
        l6.a.checkState(u.f15907a >= 21);
        if (this.f5708b0 && this.f5706a0 == i10) {
            return;
        }
        this.f5708b0 = true;
        this.f5706a0 = i10;
        reset();
    }

    public final void f(long j10) throws WriteException {
        ByteBuffer byteBuffer;
        int length = this.R.length;
        int i10 = length;
        while (i10 >= 0) {
            if (i10 > 0) {
                byteBuffer = this.S[i10 - 1];
            } else {
                byteBuffer = this.T;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f5704a;
                }
            }
            if (i10 == length) {
                i(byteBuffer, j10);
            } else {
                AudioProcessor audioProcessor = this.R[i10];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.S[i10] = output;
                if (output.hasRemaining()) {
                    i10++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i10--;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.f5711d) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.R = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.S = new ByteBuffer[size];
        for (int i10 = 0; i10 < size; i10++) {
            AudioProcessor audioProcessor2 = this.R[i10];
            audioProcessor2.flush();
            this.S[i10] = audioProcessor2.getOutput();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getCurrentPositionUs(boolean r23) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.getCurrentPositionUs(boolean):long");
    }

    public m getPlaybackParameters() {
        return this.f5728t;
    }

    public final void h() {
        if (d()) {
            if (u.f15907a >= 21) {
                this.f5718j.setVolume(this.Q);
                return;
            }
            android.media.AudioTrack audioTrack = this.f5718j;
            float f10 = this.Q;
            audioTrack.setStereoVolume(f10, f10);
        }
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j10) throws IllegalStateException, InitializationException, WriteException {
        int dtsAudioSampleCount;
        android.media.AudioTrack audioTrack;
        AudioAttributes audioAttributesBuild;
        ByteBuffer byteBuffer2 = this.T;
        l6.a.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        boolean zD = d();
        b bVar = this.f5716h;
        d dVar = this.f5713e;
        if (!zD) {
            this.f5714f.block();
            if (u.f15907a >= 21) {
                if (this.f5708b0) {
                    audioAttributesBuild = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
                } else {
                    d5.b bVar2 = this.f5723o;
                    if (bVar2.f10865d == null) {
                        bVar2.f10865d = new AudioAttributes.Builder().setContentType(bVar2.f10862a).setFlags(bVar2.f10863b).setUsage(bVar2.f10864c).build();
                    }
                    audioAttributesBuild = bVar2.f10865d;
                }
                AudioAttributes audioAttributes = audioAttributesBuild;
                AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.f5720l).setEncoding(this.f5722n).setSampleRate(this.f5719k).build();
                int i10 = this.f5706a0;
                audioTrack = new android.media.AudioTrack(audioAttributes, audioFormatBuild, this.f5725q, 1, i10 != 0 ? i10 : 0);
            } else {
                int streamTypeForAudioUsage = u.getStreamTypeForAudioUsage(this.f5723o.f10864c);
                audioTrack = this.f5706a0 == 0 ? new android.media.AudioTrack(streamTypeForAudioUsage, this.f5719k, this.f5720l, this.f5722n, this.f5725q, 1) : new android.media.AudioTrack(streamTypeForAudioUsage, this.f5719k, this.f5720l, this.f5722n, this.f5725q, 1, this.f5706a0);
            }
            int state = audioTrack.getState();
            if (state != 1) {
                try {
                    audioTrack.release();
                } catch (Exception unused) {
                }
                throw new InitializationException(state, this.f5719k, this.f5720l, this.f5725q);
            }
            this.f5718j = audioTrack;
            int audioSessionId = audioTrack.getAudioSessionId();
            if (this.f5706a0 != audioSessionId) {
                this.f5706a0 = audioSessionId;
                ((c.a) dVar).onAudioSessionId(audioSessionId);
            }
            bVar.reconfigure(this.f5718j, e());
            h();
            this.f5710c0 = false;
            if (this.Z) {
                play();
            }
        }
        if (e()) {
            if (this.f5718j.getPlayState() == 2) {
                this.f5710c0 = false;
                return false;
            }
            if (this.f5718j.getPlayState() == 1 && bVar.getPlaybackHeadPosition() != 0) {
                return false;
            }
        }
        boolean z10 = this.f5710c0;
        boolean zHasPendingData = hasPendingData();
        this.f5710c0 = zHasPendingData;
        if (z10 && !zHasPendingData && this.f5718j.getPlayState() != 1) {
            ((c.a) dVar).onUnderrun(this.f5725q, c5.b.usToMs(this.f5726r), SystemClock.elapsedRealtime() - this.f5712d0);
        }
        if (this.T == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.f5724p && this.L == 0) {
                int i11 = this.f5722n;
                if (i11 == 7 || i11 == 8) {
                    dtsAudioSampleCount = d5.d.parseDtsAudioSampleCount(byteBuffer);
                } else if (i11 == 5) {
                    dtsAudioSampleCount = d5.a.getAc3SyncframeAudioSampleCount();
                } else {
                    if (i11 != 6) {
                        throw new IllegalStateException(ac.c.f("Unexpected audio encoding: ", i11));
                    }
                    dtsAudioSampleCount = d5.a.parseEAc3SyncframeAudioSampleCount(byteBuffer);
                }
                this.L = dtsAudioSampleCount;
            }
            if (this.f5727s != null) {
                if (!a()) {
                    return false;
                }
                this.f5717i.add(new e(this.f5727s, Math.max(0L, j10), (c() * 1000000) / this.f5719k));
                this.f5727s = null;
                g();
            }
            int i12 = this.M;
            if (i12 == 0) {
                this.N = Math.max(0L, j10);
                this.M = 1;
            } else {
                long j11 = (((this.f5724p ? this.H : this.G / this.F) * 1000000) / this.f5719k) + this.N;
                if (i12 == 1 && Math.abs(j11 - j10) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + j11 + ", got " + j10 + "]");
                    this.M = 2;
                }
                if (this.M == 2) {
                    this.N = (j10 - j11) + this.N;
                    this.M = 1;
                    ((c.a) dVar).onPositionDiscontinuity();
                }
            }
            if (this.f5724p) {
                this.H += this.L;
            } else {
                this.G += byteBuffer.remaining();
            }
            this.T = byteBuffer;
        }
        if (this.f5724p) {
            i(this.T, j10);
        } else {
            f(j10);
        }
        if (this.T.hasRemaining()) {
            return false;
        }
        this.T = null;
        return true;
    }

    public void handleDiscontinuity() {
        if (this.M == 1) {
            this.M = 2;
        }
    }

    public boolean hasPendingData() {
        if (!d()) {
            return false;
        }
        if (c() <= this.f5716h.getPlaybackHeadPosition()) {
            if (!(e() && this.f5718j.getPlayState() == 2 && this.f5718j.getPlaybackHeadPosition() == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(java.nio.ByteBuffer r8, long r9) throws com.google.android.exoplayer2.audio.AudioTrack.WriteException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioTrack.i(java.nio.ByteBuffer, long):void");
    }

    public boolean isEnded() {
        return !d() || (this.Y && !hasPendingData());
    }

    public boolean isPassthroughSupported(String str) {
        d5.c cVar = this.f5705a;
        return cVar != null && cVar.supportsEncoding(b(str));
    }

    public void pause() throws IllegalStateException {
        this.Z = false;
        if (d()) {
            this.A = 0L;
            this.f5734z = 0;
            this.f5733y = 0;
            this.B = 0L;
            this.C = false;
            this.D = 0L;
            this.f5716h.pause();
        }
    }

    public void play() throws IllegalStateException {
        this.Z = true;
        if (d()) {
            this.O = System.nanoTime() / 1000;
            this.f5718j.play();
        }
    }

    public void playToEndOfStream() throws IllegalStateException, WriteException {
        if (!this.Y && d() && a()) {
            this.f5716h.handleEndOfStream(c());
            this.f5732x = 0;
            this.Y = true;
        }
    }

    public void release() throws IllegalStateException {
        reset();
        for (AudioProcessor audioProcessor : this.f5711d) {
            audioProcessor.reset();
        }
        this.f5706a0 = 0;
        this.Z = false;
    }

    public void reset() throws IllegalStateException {
        if (d()) {
            this.G = 0L;
            this.H = 0L;
            this.J = 0L;
            this.K = 0L;
            this.L = 0;
            m mVar = this.f5727s;
            LinkedList<e> linkedList = this.f5717i;
            if (mVar != null) {
                this.f5728t = mVar;
                this.f5727s = null;
            } else if (!linkedList.isEmpty()) {
                this.f5728t = linkedList.getLast().f5750a;
            }
            linkedList.clear();
            this.f5729u = 0L;
            this.f5730v = 0L;
            this.T = null;
            this.U = null;
            int i10 = 0;
            while (true) {
                AudioProcessor[] audioProcessorArr = this.R;
                if (i10 >= audioProcessorArr.length) {
                    break;
                }
                AudioProcessor audioProcessor = audioProcessorArr[i10];
                audioProcessor.flush();
                this.S[i10] = audioProcessor.getOutput();
                i10++;
            }
            this.Y = false;
            this.X = -1;
            this.f5731w = null;
            this.f5732x = 0;
            this.M = 0;
            this.P = 0L;
            this.A = 0L;
            this.f5734z = 0;
            this.f5733y = 0;
            this.B = 0L;
            this.C = false;
            this.D = 0L;
            if (this.f5718j.getPlayState() == 3) {
                this.f5718j.pause();
            }
            android.media.AudioTrack audioTrack = this.f5718j;
            this.f5718j = null;
            this.f5716h.reconfigure(null, false);
            this.f5714f.close();
            new a(audioTrack).start();
        }
    }

    public void setAudioAttributes(d5.b bVar) throws IllegalStateException {
        if (this.f5723o.equals(bVar)) {
            return;
        }
        this.f5723o = bVar;
        if (this.f5708b0) {
            return;
        }
        reset();
        this.f5706a0 = 0;
    }

    public m setPlaybackParameters(m mVar) {
        if (this.f5724p) {
            m mVar2 = m.f5142d;
            this.f5728t = mVar2;
            return mVar2;
        }
        float f10 = mVar.f5143a;
        com.google.android.exoplayer2.audio.e eVar = this.f5709c;
        m mVar3 = new m(eVar.setSpeed(f10), eVar.setPitch(mVar.f5144b));
        m mVar4 = this.f5727s;
        if (mVar4 == null) {
            LinkedList<e> linkedList = this.f5717i;
            mVar4 = !linkedList.isEmpty() ? linkedList.getLast().f5750a : this.f5728t;
        }
        if (!mVar3.equals(mVar4)) {
            if (d()) {
                this.f5727s = mVar3;
            } else {
                this.f5728t = mVar3;
            }
        }
        return this.f5728t;
    }

    public void setVolume(float f10) {
        if (this.Q != f10) {
            this.Q = f10;
            h();
        }
    }
}
