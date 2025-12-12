package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: ChannelMappingAudioProcessor.java */
/* loaded from: classes.dex */
public final class b implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    public int f5771b;

    /* renamed from: c, reason: collision with root package name */
    public int f5772c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f5773d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5774e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f5775f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f5776g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f5777h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5778i;

    public b() {
        ByteBuffer byteBuffer = AudioProcessor.f5704a;
        this.f5776g = byteBuffer;
        this.f5777h = byteBuffer;
        this.f5771b = -1;
        this.f5772c = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i10, int i11, int i12) throws AudioProcessor.UnhandledFormatException {
        boolean z10 = !Arrays.equals(this.f5773d, this.f5775f);
        int[] iArr = this.f5773d;
        this.f5775f = iArr;
        if (iArr == null) {
            this.f5774e = false;
            return z10;
        }
        if (i12 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i10, i11, i12);
        }
        if (!z10 && this.f5772c == i10 && this.f5771b == i11) {
            return false;
        }
        this.f5772c = i10;
        this.f5771b = i11;
        this.f5774e = i11 != iArr.length;
        int i13 = 0;
        while (true) {
            int[] iArr2 = this.f5775f;
            if (i13 >= iArr2.length) {
                return true;
            }
            int i14 = iArr2[i13];
            if (i14 >= i11) {
                throw new AudioProcessor.UnhandledFormatException(i10, i11, i12);
            }
            this.f5774e = (i14 != i13) | this.f5774e;
            i13++;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.f5777h = AudioProcessor.f5704a;
        this.f5778i = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f5777h;
        this.f5777h = AudioProcessor.f5704a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        int[] iArr = this.f5775f;
        return iArr == null ? this.f5771b : iArr.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f5774e;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.f5778i && this.f5777h == AudioProcessor.f5704a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.f5778i = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = ((iLimit - iPosition) / (this.f5771b * 2)) * this.f5775f.length * 2;
        if (this.f5776g.capacity() < length) {
            this.f5776g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f5776g.clear();
        }
        while (iPosition < iLimit) {
            for (int i10 : this.f5775f) {
                this.f5776g.putShort(byteBuffer.getShort((i10 * 2) + iPosition));
            }
            iPosition += this.f5771b * 2;
        }
        byteBuffer.position(iLimit);
        this.f5776g.flip();
        this.f5777h = this.f5776g;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.f5776g = AudioProcessor.f5704a;
        this.f5771b = -1;
        this.f5772c = -1;
        this.f5775f = null;
        this.f5774e = false;
    }

    public void setChannelMap(int[] iArr) {
        this.f5773d = iArr;
    }
}
