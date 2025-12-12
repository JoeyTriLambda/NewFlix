package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import java.util.concurrent.CancellationException;
import kg.g0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateRetry.kt */
/* loaded from: classes2.dex */
public final class InitializeStateRetry implements BaseTask<Params, Result<? extends h>> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateRetry.kt */
    public static final class Params implements BaseParams {
        private final Configuration config;

        public Params(Configuration configuration) {
            i.checkNotNullParameter(configuration, "config");
            this.config = configuration;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final Params copy(Configuration configuration) {
            i.checkNotNullParameter(configuration, "config");
            return new Params(configuration);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && i.areEqual(this.config, ((Params) obj).config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    /* compiled from: InitializeStateRetry.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateRetry$doWork$2", f = "InitializeStateRetry.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateRetry$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Result<? extends h>>, Object> {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        @Override // yf.p
        public /* bridge */ /* synthetic */ Object invoke(g0 g0Var, c<? super Result<? extends h>> cVar) {
            return invoke2(g0Var, (c<? super Result<h>>) cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM59constructorimpl;
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            try {
                int i10 = Result.f15189m;
                objM59constructorimpl = Result.m59constructorimpl(h.f16056a);
            } catch (CancellationException e10) {
                throw e10;
            } catch (Throwable th2) {
                int i11 = Result.f15189m;
                objM59constructorimpl = Result.m59constructorimpl(f.createFailure(th2));
            }
            if (Result.m64isSuccessimpl(objM59constructorimpl)) {
                objM59constructorimpl = Result.m59constructorimpl(objM59constructorimpl);
            } else {
                Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(objM59constructorimpl);
                if (thM61exceptionOrNullimpl != null) {
                    objM59constructorimpl = Result.m59constructorimpl(f.createFailure(thM61exceptionOrNullimpl));
                }
            }
            return Result.m58boximpl(objM59constructorimpl);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(g0 g0Var, c<? super Result<h>> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateRetry(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s, reason: not valid java name and merged with bridge method [inline-methods] */
    public Object doWork(Params params, c<? super Result<h>> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(null), cVar);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: invoke-gIAlu-s, reason: not valid java name and merged with bridge method [inline-methods] */
    public Object invoke(Params params, c<? super Result<h>> cVar) {
        return BaseTask.DefaultImpls.invoke(this, params, cVar);
    }
}
