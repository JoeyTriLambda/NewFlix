package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import l6.u;

/* compiled from: SonicAudioProcessor.java */
/* loaded from: classes.dex */
public final class e implements AudioProcessor {

    /* renamed from: d, reason: collision with root package name */
    public d5.e f5797d;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f5800g;

    /* renamed from: h, reason: collision with root package name */
    public ShortBuffer f5801h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f5802i;

    /* renamed from: j, reason: collision with root package name */
    public long f5803j;

    /* renamed from: k, reason: collision with root package name */
    public long f5804k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5805l;

    /* renamed from: e, reason: collision with root package name */
    public float f5798e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f5799f = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f5795b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f5796c = -1;

    public e() {
        ByteBuffer byteBuffer = AudioProcessor.f5704a;
        this.f5800g = byteBuffer;
        this.f5801h = byteBuffer.asShortBuffer();
        this.f5802i = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i10, int i11, int i12) throws AudioProcessor.UnhandledFormatException {
        if (i12 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i10, i11, i12);
        }
        if (this.f5796c == i10 && this.f5795b == i11) {
            return false;
        }
        this.f5796c = i10;
        this.f5795b = i11;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        d5.e eVar = new d5.e(this.f5796c, this.f5795b);
        this.f5797d = eVar;
        eVar.setSpeed(this.f5798e);
        this.f5797d.setPitch(this.f5799f);
        this.f5802i = AudioProcessor.f5704a;
        this.f5803j = 0L;
        this.f5804k = 0L;
        this.f5805l = false;
    }

    public long getInputByteCount() {
        return this.f5803j;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f5802i;
        this.f5802i = AudioProcessor.f5704a;
        return byteBuffer;
    }

    public long getOutputByteCount() {
        return this.f5804k;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.f5795b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.f5798e - 1.0f) >= 0.01f || Math.abs(this.f5799f - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        d5.e eVar;
        return this.f5805l && ((eVar = this.f5797d) == null || eVar.getSamplesAvailable() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.f5797d.queueEndOfStream();
        this.f5805l = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f5803j += iRemaining;
            this.f5797d.queueInput(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int samplesAvailable = this.f5797d.getSamplesAvailable() * this.f5795b * 2;
        if (samplesAvailable > 0) {
            if (this.f5800g.capacity() < samplesAvailable) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(samplesAvailable).order(ByteOrder.nativeOrder());
                this.f5800g = byteBufferOrder;
                this.f5801h = byteBufferOrder.asShortBuffer();
            } else {
                this.f5800g.clear();
                this.f5801h.clear();
            }
            this.f5797d.getOutput(this.f5801h);
            this.f5804k += samplesAvailable;
            this.f5800g.limit(samplesAvailable);
            this.f5802i = this.f5800g;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f5797d = null;
        ByteBuffer byteBuffer = AudioProcessor.f5704a;
        this.f5800g = byteBuffer;
        this.f5801h = byteBuffer.asShortBuffer();
        this.f5802i = byteBuffer;
        this.f5795b = -1;
        this.f5796c = -1;
        this.f5803j = 0L;
        this.f5804k = 0L;
        this.f5805l = false;
    }

    public float setPitch(float f10) {
        this.f5799f = u.constrainValue(f10, 0.1f, 8.0f);
        return f10;
    }

    public float setSpeed(float f10) {
        float fConstrainValue = u.constrainValue(f10, 0.1f, 8.0f);
        this.f5798e = fConstrainValue;
        return fConstrainValue;
    }
}
