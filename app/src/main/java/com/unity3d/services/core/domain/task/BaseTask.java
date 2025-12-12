package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.BaseParams;
import qf.c;

/* compiled from: BaseTask.kt */
/* loaded from: classes2.dex */
public interface BaseTask<P extends BaseParams, R> extends IServiceComponent {

    /* compiled from: BaseTask.kt */
    public static final class DefaultImpls {
        public static <P extends BaseParams, R> IServiceProvider getServiceProvider(BaseTask<? super P, R> baseTask) {
            return IServiceComponent.DefaultImpls.getServiceProvider(baseTask);
        }

        public static <P extends BaseParams, R> Object invoke(BaseTask<? super P, R> baseTask, P p10, c<? super R> cVar) {
            return baseTask.doWork(p10, cVar);
        }
    }

    Object doWork(P p10, c<? super R> cVar);

    Object invoke(P p10, c<? super R> cVar);
}
