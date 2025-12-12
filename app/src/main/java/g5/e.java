package g5;

import java.io.IOException;

/* compiled from: Extractor.java */
/* loaded from: classes.dex */
public interface e {
    void init(g gVar);

    int read(f fVar, k kVar) throws InterruptedException, IOException;

    void release();

    void seek(long j10, long j11);

    boolean sniff(f fVar) throws InterruptedException, IOException;
}
