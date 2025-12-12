package androidx.privacysandbox.ads.adservices.java.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import e2.b;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: MeasurementManagerFutures.kt */
@d(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {133}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f3822b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl f3823m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Uri f3824n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ InputEvent f3825o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, Uri uri, InputEvent inputEvent, c<? super MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1> cVar) {
        super(2, cVar);
        this.f3823m = api33Ext5JavaImpl;
        this.f3824n = uri;
        this.f3825o = inputEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this.f3823m, this.f3824n, this.f3825o, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f3822b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            b bVar = this.f3823m.f3817b;
            this.f3822b = 1;
            if (bVar.registerSource(this.f3824n, this.f3825o, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
