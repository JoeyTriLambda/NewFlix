package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import org.json.JSONObject;
import qf.c;
import rf.a;
import sf.d;
import wf.b;
import yf.p;
import zf.i;

/* compiled from: ConfigFileFromLocalStorage.kt */
/* loaded from: classes2.dex */
public final class ConfigFileFromLocalStorage extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: ConfigFileFromLocalStorage.kt */
    public static final class Params implements BaseParams {
    }

    /* compiled from: ConfigFileFromLocalStorage.kt */
    @d(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            return new Configuration(new JSONObject(b.readText$default(new File(SdkProperties.getLocalConfigurationFilepath()), null, 1, null)));
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public ConfigFileFromLocalStorage(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super Configuration>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_config");
    }

    public Object doWork(Params params, c<? super Configuration> cVar) {
        return kg.f.withContext(this.dispatchers.getIo(), new AnonymousClass2(null), cVar);
    }
}
