package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.util.Args;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/* loaded from: classes2.dex */
class CombinedEntity extends AbstractHttpEntity {
    private final InputStream combinedStream;
    private final Resource resource;

    public class ResourceStream extends FilterInputStream {
        public ResourceStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
            } finally {
                CombinedEntity.this.dispose();
            }
        }
    }

    public CombinedEntity(Resource resource, InputStream inputStream) throws IOException {
        this.resource = resource;
        this.combinedStream = new SequenceInputStream(new ResourceStream(resource.getInputStream()), inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispose() {
        this.resource.dispose();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IllegalStateException, IOException {
        return this.combinedStream;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IllegalStateException, IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i10 = content.read(bArr);
                if (i10 == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i10);
                }
            }
        } finally {
            content.close();
        }
    }
}
