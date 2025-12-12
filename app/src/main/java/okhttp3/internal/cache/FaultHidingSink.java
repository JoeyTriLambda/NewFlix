package okhttp3.internal.cache;

import ah.c;
import ah.g;
import ah.w;
import java.io.EOFException;
import java.io.IOException;
import lf.h;
import yf.l;
import zf.i;

/* compiled from: FaultHidingSink.kt */
/* loaded from: classes2.dex */
public class FaultHidingSink extends g {
    private boolean hasErrors;
    private final l<IOException, h> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(w wVar, l<? super IOException, h> lVar) {
        super(wVar);
        i.checkNotNullParameter(wVar, "delegate");
        i.checkNotNullParameter(lVar, "onException");
        this.onException = lVar;
    }

    @Override // ah.g, ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }

    @Override // ah.g, ah.w, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }

    public final l<IOException, h> getOnException() {
        return this.onException;
    }

    @Override // ah.g, ah.w
    public void write(c cVar, long j10) throws EOFException {
        i.checkNotNullParameter(cVar, "source");
        if (this.hasErrors) {
            cVar.skip(j10);
            return;
        }
        try {
            super.write(cVar, j10);
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }
}
