package okhttp3.internal.ws;

import ah.c;
import ah.f;
import ah.w;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.Deflater;
import okio.ByteString;
import wf.a;
import zf.i;

/* compiled from: MessageDeflater.kt */
/* loaded from: classes2.dex */
public final class MessageDeflater implements Closeable {
    private final c deflatedBytes;
    private final Deflater deflater;
    private final f deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z10) {
        this.noContextTakeover = z10;
        c cVar = new c();
        this.deflatedBytes = cVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new f((w) cVar, deflater);
    }

    private final boolean endsWith(c cVar, ByteString byteString) {
        return cVar.rangeEquals(cVar.size() - byteString.size(), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    public final void deflate(c cVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(cVar, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(cVar, cVar.size());
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            long size = this.deflatedBytes.size() - 4;
            c.a andWriteUnsafe$default = c.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
            try {
                andWriteUnsafe$default.resizeBuffer(size);
                a.closeFinally(andWriteUnsafe$default, null);
            } finally {
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        c cVar2 = this.deflatedBytes;
        cVar.write(cVar2, cVar2.size());
    }
}
