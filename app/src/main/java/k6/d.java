package k6;

import android.net.Uri;
import java.io.IOException;

/* compiled from: DataSource.java */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: DataSource.java */
    public interface a {
        d createDataSource();
    }

    void close() throws IOException;

    Uri getUri();

    long open(f fVar) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;
}
