package e5;

import java.lang.Exception;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public interface c<I, O, E extends Exception> {
    I dequeueInputBuffer() throws Exception;

    O dequeueOutputBuffer() throws Exception;

    void flush();

    void queueInputBuffer(I i10) throws Exception;

    void release();
}
