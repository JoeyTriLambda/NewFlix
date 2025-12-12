package ne;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.subscribers.StrictSubscriber;

/* compiled from: Flowable.java */
/* loaded from: classes2.dex */
public abstract class e<T> implements zh.a<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final int f16807b = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int bufferSize() {
        return f16807b;
    }

    public final e<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    public final e<T> onBackpressureDrop() {
        return ff.a.onAssembly(new FlowableOnBackpressureDrop(this));
    }

    public final e<T> onBackpressureLatest() {
        return ff.a.onAssembly(new FlowableOnBackpressureLatest(this));
    }

    public final void subscribe(zh.b<? super T> bVar) {
        if (bVar instanceof f) {
            subscribe((f) bVar);
        } else {
            ue.a.requireNonNull(bVar, "s is null");
            subscribe((f) new StrictSubscriber(bVar));
        }
    }

    public abstract void subscribeActual(zh.b<? super T> bVar);

    public final e<T> onBackpressureBuffer(int i10, boolean z10, boolean z11) {
        ue.a.verifyPositive(i10, "capacity");
        return ff.a.onAssembly(new FlowableOnBackpressureBuffer(this, i10, z11, z10, Functions.f13540c));
    }

    public final void subscribe(f<? super T> fVar) {
        ue.a.requireNonNull(fVar, "s is null");
        try {
            zh.b<? super T> bVarOnSubscribe = ff.a.onSubscribe(this, fVar);
            ue.a.requireNonNull(bVarOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(bVarOnSubscribe);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
