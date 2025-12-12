package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.IOException;
import java.io.InputStream;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class DeflateInputStreamFactory implements InputStreamFactory {
    private static final DeflateInputStreamFactory INSTANCE = new DeflateInputStreamFactory();

    public static DeflateInputStreamFactory getInstance() {
        return INSTANCE;
    }

    @Override // cz.msebera.android.httpclient.client.entity.InputStreamFactory
    public InputStream create(InputStream inputStream) throws IOException {
        return new DeflateInputStream(inputStream);
    }
}
