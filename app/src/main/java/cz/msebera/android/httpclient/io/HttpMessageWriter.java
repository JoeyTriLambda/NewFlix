package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t10) throws IOException, HttpException;
}
