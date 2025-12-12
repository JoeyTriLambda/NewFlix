package l2;

import android.database.sqlite.SQLiteProgram;
import k2.g;
import zf.i;

/* compiled from: FrameworkSQLiteProgram.kt */
/* loaded from: classes.dex */
public class d implements g {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteProgram f15726b;

    public d(SQLiteProgram sQLiteProgram) {
        i.checkNotNullParameter(sQLiteProgram, "delegate");
        this.f15726b = sQLiteProgram;
    }

    @Override // k2.g
    public void bindBlob(int i10, byte[] bArr) {
        i.checkNotNullParameter(bArr, "value");
        this.f15726b.bindBlob(i10, bArr);
    }

    @Override // k2.g
    public void bindDouble(int i10, double d10) {
        this.f15726b.bindDouble(i10, d10);
    }

    @Override // k2.g
    public void bindLong(int i10, long j10) {
        this.f15726b.bindLong(i10, j10);
    }

    @Override // k2.g
    public void bindNull(int i10) {
        this.f15726b.bindNull(i10);
    }

    @Override // k2.g
    public void bindString(int i10, String str) {
        i.checkNotNullParameter(str, "value");
        this.f15726b.bindString(i10, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15726b.close();
    }
}
