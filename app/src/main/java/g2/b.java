package g2;

import java.io.IOException;

/* compiled from: AutoClosingRoomOpenHelper.kt */
/* loaded from: classes.dex */
public final class b implements k2.f, d {

    /* compiled from: AutoClosingRoomOpenHelper.kt */
    public static final class a implements k2.e {
        public final void a() {
            throw null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw null;
        }
    }

    @Override // k2.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw null;
    }

    @Override // k2.f
    public String getDatabaseName() {
        throw null;
    }

    @Override // g2.d
    public k2.f getDelegate() {
        return null;
    }

    @Override // k2.f
    public k2.e getWritableDatabase() {
        throw null;
    }

    @Override // k2.f
    public void setWriteAheadLoggingEnabled(boolean z10) {
        throw null;
    }
}
