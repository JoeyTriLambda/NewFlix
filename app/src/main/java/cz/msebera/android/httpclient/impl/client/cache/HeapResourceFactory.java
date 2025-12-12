package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class HeapResourceFactory implements ResourceFactory {
    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource copy(String str, Resource resource) throws IOException {
        byte[] byteArray;
        if (resource instanceof HeapResource) {
            byteArray = ((HeapResource) resource).getByteArray();
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copyAndClose(resource.getInputStream(), byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return createResource(byteArray);
    }

    public Resource createResource(byte[] bArr) {
        return new HeapResource(bArr);
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i10);
            j10 += i10;
            if (inputLimit != null && j10 > inputLimit.getValue()) {
                inputLimit.reached();
                break;
            }
        }
        return createResource(byteArrayOutputStream.toByteArray());
    }
}
