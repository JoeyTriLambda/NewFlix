package mg;

import kg.m;
import kg.m2;
import pg.y;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class h<E> implements m2 {

    /* renamed from: b, reason: collision with root package name */
    public final m<kotlinx.coroutines.channels.a<? extends E>> f16318b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(m<? super kotlinx.coroutines.channels.a<? extends E>> mVar) {
        this.f16318b = mVar;
    }

    @Override // kg.m2
    public void invokeOnCancellation(y<?> yVar, int i10) {
        this.f16318b.invokeOnCancellation(yVar, i10);
    }
}
