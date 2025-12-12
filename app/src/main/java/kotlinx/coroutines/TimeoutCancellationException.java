package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kg.k1;

/* compiled from: Timeout.kt */
/* loaded from: classes2.dex */
public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: b, reason: collision with root package name */
    public final transient k1 f15296b;

    public TimeoutCancellationException(String str, k1 k1Var) {
        super(str);
        this.f15296b = k1Var;
    }
}
