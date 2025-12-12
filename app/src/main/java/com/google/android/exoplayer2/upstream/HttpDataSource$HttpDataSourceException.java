package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import k6.f;

/* loaded from: classes.dex */
public class HttpDataSource$HttpDataSourceException extends IOException {
    public HttpDataSource$HttpDataSourceException(String str, f fVar, int i10) {
        super(str);
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, f fVar, int i10) {
        super(iOException);
    }

    public HttpDataSource$HttpDataSourceException(String str, IOException iOException, f fVar, int i10) {
        super(str, iOException);
    }
}
