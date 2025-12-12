package cz.msebera.android.httpclient.pool;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface ConnFactory<T, C> {
    C create(T t10) throws IOException;
}
