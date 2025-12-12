package okhttp3.internal.ws;

import ah.c;
import ah.k;
import ah.y;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Settings;
import zf.i;

/* compiled from: MessageInflater.kt */
/* loaded from: classes2.dex */
public final class MessageInflater implements Closeable {
    private final c deflatedBytes;
    private final Inflater inflater;
    private final k inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z10) {
        this.noContextTakeover = z10;
        c cVar = new c();
        this.deflatedBytes = cVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new k((y) cVar, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(c cVar) throws DataFormatException, IOException {
        i.checkNotNullParameter(cVar, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.writeAll(cVar);
        this.deflatedBytes.writeInt(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long size = this.deflatedBytes.size() + this.inflater.getBytesRead();
        do {
            this.inflaterSource.readOrInflate(cVar, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < size);
    }
}
