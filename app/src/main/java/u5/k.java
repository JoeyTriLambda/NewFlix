package u5;

import java.io.IOException;

/* compiled from: SampleStream.java */
/* loaded from: classes.dex */
public interface k {
    boolean isReady();

    void maybeThrowError() throws IOException;

    int readData(c5.j jVar, e5.e eVar, boolean z10);

    void skipData(long j10);
}
