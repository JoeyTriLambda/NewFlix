package cz.msebera.android.httpclient.entity;

import android.support.v4.media.session.PlaybackStateCompat;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class InputStreamEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    public InputStreamEntity(InputStream inputStream) {
        this(inputStream, -1L);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.length;
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
    public void writeTo(OutputStream outputStream) throws IOException {
        int i10;
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[4096];
            long j10 = this.length;
            if (j10 < 0) {
                while (true) {
                    int i11 = inputStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i11);
                    }
                }
            } else {
                while (j10 > 0 && (i10 = inputStream.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, j10))) != -1) {
                    outputStream.write(bArr, 0, i10);
                    j10 -= i10;
                }
            }
        } finally {
            inputStream.close();
        }
    }

    public InputStreamEntity(InputStream inputStream, long j10) {
        this(inputStream, j10, null);
    }

    public InputStreamEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1L, contentType);
    }

    public InputStreamEntity(InputStream inputStream, long j10, ContentType contentType) {
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j10;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }
}
