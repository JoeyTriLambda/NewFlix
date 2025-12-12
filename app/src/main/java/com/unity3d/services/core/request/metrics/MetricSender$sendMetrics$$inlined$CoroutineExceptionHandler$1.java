package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kg.e0;
import kotlin.coroutines.CoroutineContext;
import qf.a;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes2.dex */
public final class MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1 extends a implements e0 {
    final /* synthetic */ List $metrics$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(e0.b bVar, List list) {
        super(bVar);
        this.$metrics$inlined = list;
    }

    @Override // kg.e0
    public void handleException(CoroutineContext coroutineContext, Throwable th2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DeviceLog.debug("Metric " + this.$metrics$inlined + " failed to send with error: " + th2);
    }
}
