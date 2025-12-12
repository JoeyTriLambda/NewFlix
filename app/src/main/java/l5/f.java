package l5;

import g5.l;
import java.io.IOException;

/* compiled from: OggSeeker.java */
/* loaded from: classes.dex */
public interface f {
    l createSeekMap();

    long read(g5.f fVar) throws InterruptedException, IOException;

    long startSeek(long j10);
}
