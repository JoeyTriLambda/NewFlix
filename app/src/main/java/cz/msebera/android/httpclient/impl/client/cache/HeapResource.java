package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class HeapResource implements Resource {
    private static final long serialVersionUID = -2078599905620463394L;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f10719b;

    public HeapResource(byte[] bArr) {
        this.f10719b = bArr;
    }

    public byte[] getByteArray() {
        return this.f10719b;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f10719b);
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public long length() {
        return this.f10719b.length;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public void dispose() {
    }
}
