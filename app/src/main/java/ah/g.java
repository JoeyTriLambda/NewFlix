package ah;

import java.io.IOException;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes2.dex */
public abstract class g implements w {
    private final w delegate;

    public g(w wVar) {
        zf.i.checkNotNullParameter(wVar, "delegate");
        this.delegate = wVar;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final w m1deprecated_delegate() {
        return this.delegate;
    }

    @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final w delegate() {
        return this.delegate;
    }

    @Override // ah.w, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // ah.w
    public z timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getClass().getSimpleName());
        sb2.append('(');
        sb2.append(this.delegate);
        sb2.append(')');
        return sb2.toString();
    }

    @Override // ah.w
    public void write(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "source");
        this.delegate.write(cVar, j10);
    }
}
