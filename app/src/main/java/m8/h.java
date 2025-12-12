package m8;

import com.google.firebase.concurrent.SequentialExecutor;
import java.util.concurrent.Executor;

/* compiled from: FirebaseExecutors.java */
/* loaded from: classes.dex */
public final class h {
    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
