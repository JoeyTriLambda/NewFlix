package kg;

import kg.k1;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes2.dex */
public abstract class a<T> extends r1 implements qf.c<T>, g0 {

    /* renamed from: n, reason: collision with root package name */
    public final CoroutineContext f15092n;

    public a(CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            initParentJob((k1) coroutineContext.get(k1.b.f15119b));
        }
        this.f15092n = coroutineContext.plus(this);
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kg.r1
    public String cancellationExceptionMessage() {
        return i0.getClassSimpleName(this) + " was cancelled";
    }

    @Override // qf.c
    public final CoroutineContext getContext() {
        return this.f15092n;
    }

    @Override // kg.g0
    public CoroutineContext getCoroutineContext() {
        return this.f15092n;
    }

    @Override // kg.r1
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th2) {
        f0.handleCoroutineException(this.f15092n, th2);
    }

    @Override // kg.r1, kg.k1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kg.r1
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.f15092n);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        StringBuilder sbV = ac.c.v("\"", coroutineName, "\":");
        sbV.append(super.nameString$kotlinx_coroutines_core());
        return sbV.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kg.r1
    public final void onCompletionInternal(Object obj) {
        if (!(obj instanceof z)) {
            onCompleted(obj);
        } else {
            z zVar = (z) obj;
            onCancelled(zVar.f15175a, zVar.getHandled());
        }
    }

    @Override // qf.c
    public final void resumeWith(Object obj) throws Throwable {
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(c0.toState$default(obj, null, 1, null));
        if (objMakeCompletingOnce$kotlinx_coroutines_core == t1.f15154b) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public final <R> void start(CoroutineStart coroutineStart, R r10, yf.p<? super R, ? super qf.c<? super T>, ? extends Object> pVar) {
        coroutineStart.invoke(pVar, r10, this);
    }

    public void onCompleted(T t10) {
    }

    public void onCancelled(Throwable th2, boolean z10) {
    }
}
