package ah;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: DeflaterSink.kt */
/* loaded from: classes2.dex */
public final class f implements w {

    /* renamed from: b, reason: collision with root package name */
    public final d f689b;

    /* renamed from: m, reason: collision with root package name */
    public final Deflater f690m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f691n;

    public f(d dVar, Deflater deflater) {
        zf.i.checkNotNullParameter(dVar, "sink");
        zf.i.checkNotNullParameter(deflater, "deflater");
        this.f689b = dVar;
        this.f690m = deflater;
    }

    @IgnoreJRERequirement
    public final void a(boolean z10) throws IOException {
        u uVarWritableSegment$okio;
        int iDeflate;
        d dVar = this.f689b;
        c buffer = dVar.getBuffer();
        while (true) {
            uVarWritableSegment$okio = buffer.writableSegment$okio(1);
            Deflater deflater = this.f690m;
            if (z10) {
                byte[] bArr = uVarWritableSegment$okio.f723a;
                int i10 = uVarWritableSegment$okio.f725c;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                byte[] bArr2 = uVarWritableSegment$okio.f723a;
                int i11 = uVarWritableSegment$okio.f725c;
                iDeflate = deflater.deflate(bArr2, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                uVarWritableSegment$okio.f725c += iDeflate;
                buffer.setSize$okio(buffer.size() + iDeflate);
                dVar.emitCompleteSegments();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (uVarWritableSegment$okio.f724b == uVarWritableSegment$okio.f725c) {
            buffer.f676b = uVarWritableSegment$okio.pop();
            v.recycle(uVarWritableSegment$okio);
        }
    }

    @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f691n) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f690m.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f689b.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f691n = true;
        if (th != null) {
            throw th;
        }
    }

    public final void finishDeflate$okio() throws IOException {
        this.f690m.finish();
        a(false);
    }

    @Override // ah.w, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f689b.flush();
    }

    @Override // ah.w
    public z timeout() {
        return this.f689b.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f689b + ')';
    }

    @Override // ah.w
    public void write(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "source");
        d0.checkOffsetAndCount(cVar.size(), 0L, j10);
        while (j10 > 0) {
            u uVar = cVar.f676b;
            zf.i.checkNotNull(uVar);
            int iMin = (int) Math.min(j10, uVar.f725c - uVar.f724b);
            this.f690m.setInput(uVar.f723a, uVar.f724b, iMin);
            a(false);
            long j11 = iMin;
            cVar.setSize$okio(cVar.size() - j11);
            int i10 = uVar.f724b + iMin;
            uVar.f724b = i10;
            if (i10 == uVar.f725c) {
                cVar.f676b = uVar.pop();
                v.recycle(uVar);
            }
            j10 -= j11;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(w wVar, Deflater deflater) {
        this(m.buffer(wVar), deflater);
        zf.i.checkNotNullParameter(wVar, "sink");
        zf.i.checkNotNullParameter(deflater, "deflater");
    }
}
