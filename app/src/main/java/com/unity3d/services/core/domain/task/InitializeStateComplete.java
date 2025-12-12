package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kg.g0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateComplete.kt */
/* loaded from: classes2.dex */
public final class InitializeStateComplete extends MetricTask<Params, h> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateComplete.kt */
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

    /* compiled from: InitializeStateComplete.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateComplete", f = "InitializeStateComplete.kt", l = {15}, m = "doWork")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InitializeStateComplete.this.doWork((Params) null, (c<? super h>) this);
        }
    }

    /* compiled from: InitializeStateComplete.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2", f = "InitializeStateComplete.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        final /* synthetic */ Params $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$params, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            Class[] moduleConfigurationList = this.$params.getConfig().getModuleConfigurationList();
            i.checkNotNullExpressionValue(moduleConfigurationList, "params.config.moduleConfigurationList");
            for (Class cls : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration = this.$params.getConfig().getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    sf.a.boxBoolean(moduleConfiguration.initCompleteState(this.$params.getConfig()));
                }
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateComplete(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super h>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("completion");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.InitializeStateComplete.Params r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateComplete.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateComplete.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lf.f.throwOnFailure(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            lf.f.throwOnFailure(r7)
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r5.dispatchers
            kotlinx.coroutines.b r7 = r7.getDefault()
            com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = kg.f.withContext(r7, r2, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateComplete.doWork(com.unity3d.services.core.domain.task.InitializeStateComplete$Params, qf.c):java.lang.Object");
    }
}
