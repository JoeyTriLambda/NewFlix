package ng;

import kotlinx.coroutines.flow.StateFlowImpl;
import pg.b0;

/* compiled from: StateFlow.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f16831a = new b0("NONE");

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f16832b = new b0("PENDING");

    public static final <T> g<T> MutableStateFlow(T t10) {
        if (t10 == null) {
            t10 = (T) og.j.f17095a;
        }
        return new StateFlowImpl(t10);
    }
}
