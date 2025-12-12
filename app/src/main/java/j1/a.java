package j1;

import androidx.datastore.core.CorruptionException;
import qf.c;

/* compiled from: NoOpCorruptionHandler.kt */
/* loaded from: classes.dex */
public final class a<T> implements i1.a<T> {
    @Override // i1.a
    public Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar) throws CorruptionException {
        throw corruptionException;
    }
}
