package b6;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* compiled from: SimpleSubtitleDecoder.java */
/* loaded from: classes.dex */
public abstract class b extends e5.g<g, h, SubtitleDecoderException> implements e {
    public b(String str) throws IllegalStateException {
        super(new g[2], new h[2]);
        setInitialInputBufferSize(1024);
    }

    public abstract d decode(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException;

    public final void releaseOutputBuffer(h hVar) {
        releaseOutputBuffer((b) hVar);
    }

    @Override // e5.g
    public final g createInputBuffer() {
        return new g();
    }

    @Override // e5.g
    public final h createOutputBuffer() {
        return new c(this);
    }

    @Override // e5.g
    public final SubtitleDecoderException decode(g gVar, h hVar, boolean z10) {
        try {
            ByteBuffer byteBuffer = gVar.f11142n;
            hVar.setContent(gVar.f11143o, decode(byteBuffer.array(), byteBuffer.limit(), z10), gVar.f4782q);
            hVar.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e10) {
            return e10;
        }
    }

    @Override // b6.e
    public void setPositionUs(long j10) {
    }
}
