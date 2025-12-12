package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* compiled from: ResamplingAudioProcessor.java */
/* loaded from: classes.dex */
public final class d implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public int f5789b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f5790c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f5791d = 0;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f5792e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f5793f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5794g;

    public d() {
        ByteBuffer byteBuffer = AudioProcessor.f5704a;
        this.f5792e = byteBuffer;
        this.f5793f = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i10, int i11, int i12) throws AudioProcessor.UnhandledFormatException {
        if (i12 != 3 && i12 != 2 && i12 != Integer.MIN_VALUE && i12 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i10, i11, i12);
        }
        if (this.f5789b == i10 && this.f5790c == i11 && this.f5791d == i12) {
            return false;
        }
        this.f5789b = i10;
        this.f5790c = i11;
        this.f5791d = i12;
        if (i12 != 2) {
            return true;
        }
        this.f5792e = AudioProcessor.f5704a;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f5793f = AudioProcessor.f5704a;
        this.f5794g = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f5793f;
        this.f5793f = AudioProcessor.f5704a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.f5790c;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        int i10 = this.f5791d;
        return (i10 == 0 || i10 == 2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.f5794g && this.f5793f == AudioProcessor.f5704a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.f5794g = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[ADDED_TO_REGION, LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void queueInput(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.f5791d
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L20
            if (r3 == r6) goto L21
            if (r3 != r4) goto L1a
            int r2 = r2 / 2
            goto L23
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L20:
            int r2 = r2 / r6
        L21:
            int r2 = r2 * 2
        L23:
            java.nio.ByteBuffer r3 = r7.f5792e
            int r3 = r3.capacity()
            if (r3 >= r2) goto L3a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.f5792e = r2
            goto L3f
        L3a:
            java.nio.ByteBuffer r2 = r7.f5792e
            r2.clear()
        L3f:
            int r2 = r7.f5791d
            if (r2 == r5) goto L81
            if (r2 == r6) goto L68
            if (r2 != r4) goto L62
        L47:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f5792e
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f5792e
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L47
        L62:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L68:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f5792e
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f5792e
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L68
        L81:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.f5792e
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.f5792e
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L81
        L9c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.f5792e
            r8.flip()
            java.nio.ByteBuffer r8 = r7.f5792e
            r7.f5793f = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.d.queueInput(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.f5792e = AudioProcessor.f5704a;
        this.f5789b = -1;
        this.f5790c = -1;
        this.f5791d = 0;
    }
}
