package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
/* loaded from: classes2.dex */
public class EntitySerializer {
    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy contentLengthStrategy) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(contentLengthStrategy, "Content length strategy");
    }

    public OutputStream doSerialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        long jDetermineLength = this.lenStrategy.determineLength(httpMessage);
        return jDetermineLength == -2 ? new ChunkedOutputStream(sessionOutputBuffer) : jDetermineLength == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, jDetermineLength);
    }

    public void serialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage, HttpEntity httpEntity) throws HttpException, IOException {
        Args.notNull(sessionOutputBuffer, "Session output buffer");
        Args.notNull(httpMessage, "HTTP message");
        Args.notNull(httpEntity, "HTTP entity");
        OutputStream outputStreamDoSerialize = doSerialize(sessionOutputBuffer, httpMessage);
        httpEntity.writeTo(outputStreamDoSerialize);
        outputStreamDoSerialize.close();
    }
}
