package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import yf.l;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public abstract class h extends b implements Closeable {

    /* compiled from: Executors.kt */
    public static final class a extends qf.b<b, h> {
        public a(zf.f fVar) {
            super(b.f15310b, new l<CoroutineContext.a, h>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1
                @Override // yf.l
                public final h invoke(CoroutineContext.a aVar) {
                    if (aVar instanceof h) {
                        return (h) aVar;
                    }
                    return null;
                }
            });
        }
    }

    static {
        new a(null);
    }

    public abstract Executor getExecutor();
}
