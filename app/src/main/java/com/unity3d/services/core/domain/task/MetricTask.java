package com.unity3d.services.core.domain.task;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;
import zf.i;
import zf.k;

/* compiled from: MetricTask.kt */
/* loaded from: classes2.dex */
public abstract class MetricTask<P extends BaseParams, R> implements BaseTask<P, R> {
    private long duration;
    private String taskStatus = "unknown";

    /* compiled from: MetricTask.kt */
    @d(c = "com.unity3d.services.core.domain.task.MetricTask", f = "MetricTask.kt", l = {24}, m = "invoke$suspendImpl")
    /* renamed from: com.unity3d.services.core.domain.task.MetricTask$invoke$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MetricTask<P, R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(MetricTask<? super P, R> metricTask, c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = metricTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricTask.invoke$suspendImpl(this.this$0, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void captureMetric(R r10) {
        String str = "success";
        if ((r10 instanceof Result) && !Result.m64isSuccessimpl(((Result) r10).m66unboximpl())) {
            str = "failure";
        }
        this.taskStatus = str;
        sendMetric();
    }

    private final Metric getMetric() {
        return new Metric(getMetricName(), Long.valueOf(this.duration), getMetricTagsForState());
    }

    private final Map<String, String> getMetricTagsForState() {
        Map<String, String> retryTags = InitializeEventsMetricSender.getInstance().getRetryTags();
        i.checkNotNullExpressionValue(retryTags, "getInstance().retryTags");
        return retryTags;
    }

    private final SDKMetricsSender getSDKMetrics() {
        return (SDKMetricsSender) getServiceProvider().getRegistry().getService("", k.getOrCreateKotlinClass(SDKMetricsSender.class));
    }

    private final int getStatePrefixLength() {
        return 15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object invoke$suspendImpl(com.unity3d.services.core.domain.task.MetricTask<? super P, R> r8, P r9, qf.c<? super R> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.unity3d.services.core.domain.task.MetricTask.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.unity3d.services.core.domain.task.MetricTask$invoke$1 r0 = (com.unity3d.services.core.domain.task.MetricTask.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.MetricTask$invoke$1 r0 = new com.unity3d.services.core.domain.task.MetricTask$invoke$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4b
            if (r2 != r3) goto L43
            long r8 = r0.J$0
            java.lang.Object r1 = r0.L$4
            java.util.concurrent.TimeUnit r1 = (java.util.concurrent.TimeUnit) r1
            java.lang.Object r2 = r0.L$3
            com.unity3d.services.core.domain.task.MetricTask r2 = (com.unity3d.services.core.domain.task.MetricTask) r2
            java.lang.Object r3 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
            java.lang.Object r0 = r0.L$0
            com.unity3d.services.core.domain.task.MetricTask r0 = (com.unity3d.services.core.domain.task.MetricTask) r0
            lf.f.throwOnFailure(r10)
            r6 = r8
            r8 = r2
            r9 = r4
            r4 = r6
            goto L73
        L43:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4b:
            lf.f.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r4 = java.lang.System.nanoTime()
            r0.L$0 = r8
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r8
            r0.L$4 = r2
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = com.unity3d.services.core.domain.task.BaseTask.DefaultImpls.invoke(r8, r9, r0)
            if (r9 != r1) goto L6e
            return r1
        L6e:
            r0 = r8
            r3 = r10
            r1 = r2
            r10 = r9
            r9 = r3
        L73:
            r3.f15262b = r10
            lf.h r10 = lf.h.f16056a
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r4
            long r1 = r1.toMillis(r2)
            r8.duration = r1
            T r8 = r9.f15262b
            r0.captureMetric(r8)
            T r8 = r9.f15262b
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.MetricTask.invoke$suspendImpl(com.unity3d.services.core.domain.task.MetricTask, com.unity3d.services.core.domain.task.BaseParams, qf.c):java.lang.Object");
    }

    private final void sendMetric() {
        String metricName = getMetricName();
        if (metricName == null || metricName.length() == 0) {
            return;
        }
        getSDKMetrics().sendMetric(getMetric());
    }

    public final long getDuration() {
        return this.duration;
    }

    public String getMetricName() {
        return null;
    }

    public final String getMetricNameForInitializeTask(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        StringBuilder sb2 = new StringBuilder("native_");
        sb2.append(str);
        sb2.append("_task_");
        return ac.c.o(sb2, this.taskStatus, "_time");
    }

    public final String getMetricNameForTask(Object obj) {
        i.checkNotNullParameter(obj, "task");
        String simpleName = obj.getClass().getSimpleName();
        i.checkNotNullExpressionValue(simpleName, "className");
        if (simpleName.length() == 0) {
            return null;
        }
        i.checkNotNullExpressionValue(simpleName, "className");
        String strSubstring = simpleName.substring(getStatePrefixLength());
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return ac.c.p(new StringBuilder(lowerCase.length() + 7 + 6), "native_", lowerCase, "_state");
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    public final String getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public Object invoke(P p10, c<? super R> cVar) {
        return invoke$suspendImpl(this, p10, cVar);
    }

    public final void setDuration(long j10) {
        this.duration = j10;
    }

    public final void setTaskStatus(String str) {
        i.checkNotNullParameter(str, "<set-?>");
        this.taskStatus = str;
    }
}
