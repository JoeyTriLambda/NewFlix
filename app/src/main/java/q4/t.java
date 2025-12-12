package q4;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: TransportRuntimeComponent.java */
/* loaded from: classes.dex */
public abstract class t implements Closeable {

    /* compiled from: TransportRuntimeComponent.java */
    public interface a {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((e) this).f17855q.get().close();
    }
}
