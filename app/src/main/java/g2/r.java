package g2;

import java.io.File;
import java.io.IOException;

/* compiled from: SQLiteCopyOpenHelper.kt */
/* loaded from: classes.dex */
public final class r implements k2.f, d {

    /* renamed from: b, reason: collision with root package name */
    public c f12628b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12629m;

    public final void a(File file) throws IOException {
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    public final void b(boolean z10) {
        if (getDatabaseName() == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw null;
    }

    @Override // k2.f, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.f12629m = false;
    }

    @Override // k2.f
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // g2.d
    public k2.f getDelegate() {
        return null;
    }

    @Override // k2.f
    public k2.e getWritableDatabase() {
        if (!this.f12629m) {
            b(true);
            this.f12629m = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(c cVar) {
        zf.i.checkNotNullParameter(cVar, "databaseConfiguration");
        this.f12628b = cVar;
    }

    @Override // k2.f
    public void setWriteAheadLoggingEnabled(boolean z10) {
        getDelegate().setWriteAheadLoggingEnabled(z10);
    }
}
