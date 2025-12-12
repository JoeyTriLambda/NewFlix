package k2;

import java.io.Closeable;

/* compiled from: SupportSQLiteProgram.kt */
/* loaded from: classes.dex */
public interface g extends Closeable {
    void bindBlob(int i10, byte[] bArr);

    void bindDouble(int i10, double d10);

    void bindLong(int i10, long j10);

    void bindNull(int i10);

    void bindString(int i10, String str);
}
