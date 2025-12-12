package j1;

import androidx.datastore.core.CorruptionException;
import java.io.IOException;
import qf.c;
import yf.l;
import zf.i;

/* compiled from: ReplaceFileCorruptionHandler.kt */
/* loaded from: classes.dex */
public final class b<T> implements i1.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final l<CorruptionException, T> f14576a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(l<? super CorruptionException, ? extends T> lVar) {
        i.checkNotNullParameter(lVar, "produceNewData");
        this.f14576a = lVar;
    }

    @Override // i1.a
    public Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar) throws IOException {
        return this.f14576a.invoke(corruptionException);
    }
}
