package v5;

import java.io.IOException;

/* compiled from: ChunkSource.java */
/* loaded from: classes.dex */
public interface g {
    void getNextChunk(l lVar, long j10, e eVar);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(c cVar);

    boolean onChunkLoadError(c cVar, boolean z10, Exception exc);
}
