package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializationException;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class DefaultHttpCacheEntrySerializer implements HttpCacheEntrySerializer {
    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public HttpCacheEntry readFrom(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            try {
                return (HttpCacheEntry) objectInputStream.readObject();
            } catch (ClassNotFoundException e10) {
                throw new HttpCacheEntrySerializationException("Class not found: " + e10.getMessage(), e10);
            }
        } finally {
            objectInputStream.close();
        }
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheEntrySerializer
    public void writeTo(HttpCacheEntry httpCacheEntry, OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        try {
            objectOutputStream.writeObject(httpCacheEntry);
        } finally {
            objectOutputStream.close();
        }
    }
}
