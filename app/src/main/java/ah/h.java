package ah;

import java.io.IOException;

/* compiled from: ForwardingSource.kt */
/* loaded from: classes2.dex */
public abstract class h implements y {
    private final y delegate;

    public h(y yVar) {
        zf.i.checkNotNullParameter(yVar, "delegate");
        this.delegate = yVar;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final y m2deprecated_delegate() {
        return this.delegate;
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final y delegate() {
        return this.delegate;
    }

    @Override // ah.y
    public long read(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "sink");
        return this.delegate.read(cVar, j10);
    }

    @Override // ah.y
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
}
