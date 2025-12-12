package y4;

import java.io.Closeable;

/* compiled from: EventStore.java */
/* loaded from: classes.dex */
public interface d extends Closeable {
    int cleanUp();

    long getNextCallTime(q4.o oVar);

    boolean hasPendingEventsFor(q4.o oVar);

    Iterable<q4.o> loadActiveContexts();

    Iterable<j> loadBatch(q4.o oVar);

    j persist(q4.o oVar, q4.i iVar);

    void recordFailure(Iterable<j> iterable);

    void recordNextCallTime(q4.o oVar, long j10);

    void recordSuccess(Iterable<j> iterable);
}
