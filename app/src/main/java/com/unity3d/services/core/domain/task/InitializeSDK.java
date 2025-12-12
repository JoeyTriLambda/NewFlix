package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateError;
import kg.g0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeSDK.kt */
/* loaded from: classes2.dex */
public final class InitializeSDK extends MetricTask<EmptyParams, h> {
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    private final InitializeStateComplete initializeStateComplete;
    private final InitializeStateConfig initializeStateConfig;
    private final InitializeStateCreate initializeStateCreate;
    private final InitializeStateCreateWithRemote initializeStateCreateWithRemote;
    private final InitializeStateError initializeStateError;
    private final InitializeStateLoadCache initializeStateLoadCache;
    private final InitializeStateLoadWeb initializeStateLoadWeb;
    private final InitializeStateReset initializeStateReset;

    /* compiled from: InitializeSDK.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", l = {35}, m = "doWork")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeSDK$doWork$1, reason: invalid class name */
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
            return InitializeSDK.this.doWork((EmptyParams) null, (c<? super h>) this);
        }
    }

    /* compiled from: InitializeSDK.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", l = {41, 46, 48, 53, 55, 61, 66, 69, 75, 77, 90, 92, 101, 103, 106}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = InitializeSDK.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0270 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0288  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x02a8  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0328  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0377 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:162:0x038f  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x03c6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0145 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d9  */
        /* JADX WARN: Type inference failed for: r1v100 */
        /* JADX WARN: Type inference failed for: r1v101 */
        /* JADX WARN: Type inference failed for: r1v11, types: [com.unity3d.services.core.configuration.Configuration, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v14, types: [com.unity3d.services.core.configuration.Configuration, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v41, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v47, types: [java.lang.Object, kg.g0] */
        /* JADX WARN: Type inference failed for: r1v50, types: [kg.g0] */
        /* JADX WARN: Type inference failed for: r1v52, types: [com.unity3d.services.core.configuration.Configuration] */
        /* JADX WARN: Type inference failed for: r1v54, types: [com.unity3d.services.core.configuration.Configuration] */
        /* JADX WARN: Type inference failed for: r1v56, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v58, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v59, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v61, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v68 */
        /* JADX WARN: Type inference failed for: r1v69 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v70 */
        /* JADX WARN: Type inference failed for: r1v71 */
        /* JADX WARN: Type inference failed for: r1v72 */
        /* JADX WARN: Type inference failed for: r1v73 */
        /* JADX WARN: Type inference failed for: r1v78 */
        /* JADX WARN: Type inference failed for: r1v79 */
        /* JADX WARN: Type inference failed for: r1v80 */
        /* JADX WARN: Type inference failed for: r1v81 */
        /* JADX WARN: Type inference failed for: r1v82 */
        /* JADX WARN: Type inference failed for: r1v85 */
        /* JADX WARN: Type inference failed for: r1v86 */
        /* JADX WARN: Type inference failed for: r1v87 */
        /* JADX WARN: Type inference failed for: r1v88 */
        /* JADX WARN: Type inference failed for: r1v89 */
        /* JADX WARN: Type inference failed for: r1v92 */
        /* JADX WARN: Type inference failed for: r1v93 */
        /* JADX WARN: Type inference failed for: r1v96 */
        /* JADX WARN: Type inference failed for: r1v97 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 1018
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: InitializeSDK.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", l = {111}, m = "handleInitializationException")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03471(c<? super C03471> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InitializeSDK.this.handleInitializationException(null, this);
        }
    }

    public InitializeSDK(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage, InitializeStateReset initializeStateReset, InitializeStateError initializeStateError, InitializeStateConfig initializeStateConfig, InitializeStateCreate initializeStateCreate, InitializeStateLoadCache initializeStateLoadCache, InitializeStateCreateWithRemote initializeStateCreateWithRemote, InitializeStateLoadWeb initializeStateLoadWeb, InitializeStateComplete initializeStateComplete) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(configFileFromLocalStorage, "configFileFromLocalStorage");
        i.checkNotNullParameter(initializeStateReset, "initializeStateReset");
        i.checkNotNullParameter(initializeStateError, "initializeStateError");
        i.checkNotNullParameter(initializeStateConfig, "initializeStateConfig");
        i.checkNotNullParameter(initializeStateCreate, "initializeStateCreate");
        i.checkNotNullParameter(initializeStateLoadCache, "initializeStateLoadCache");
        i.checkNotNullParameter(initializeStateCreateWithRemote, "initializeStateCreateWithRemote");
        i.checkNotNullParameter(initializeStateLoadWeb, "initializeStateLoadWeb");
        i.checkNotNullParameter(initializeStateComplete, "initializeStateComplete");
        this.dispatchers = iSDKDispatchers;
        this.configFileFromLocalStorage = configFileFromLocalStorage;
        this.initializeStateReset = initializeStateReset;
        this.initializeStateError = initializeStateError;
        this.initializeStateConfig = initializeStateConfig;
        this.initializeStateCreate = initializeStateCreate;
        this.initializeStateLoadCache = initializeStateLoadCache;
        this.initializeStateCreateWithRemote = initializeStateCreateWithRemote;
        this.initializeStateLoadWeb = initializeStateLoadWeb;
        this.initializeStateComplete = initializeStateComplete;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeErrorState(ErrorState errorState, Throwable th2, Configuration configuration, c<? super h> cVar) {
        Object objInvoke = this.initializeStateError.invoke(new InitializeStateError.Params(errorState, new Exception(th2 != null ? th2.getMessage() : null), configuration), cVar);
        return objInvoke == a.getCOROUTINE_SUSPENDED() ? objInvoke : h.f16056a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleInitializationException(com.unity3d.services.core.domain.task.InitializationException r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeSDK.C03471
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = (com.unity3d.services.core.domain.task.InitializeSDK.C03471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = new com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            java.lang.Object r6 = r0.L$0
            com.unity3d.services.core.domain.task.InitializationException r6 = (com.unity3d.services.core.domain.task.InitializationException) r6
            lf.f.throwOnFailure(r7)
            goto L4f
        L35:
            lf.f.throwOnFailure(r7)
            com.unity3d.services.core.configuration.ErrorState r7 = r6.getErrorState()
            java.lang.Exception r2 = r6.getOriginalException()
            com.unity3d.services.core.configuration.Configuration r4 = r6.getConfig()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.executeErrorState(r7, r2, r4, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.handleInitializationException(com.unity3d.services.core.domain.task.InitializationException, qf.c):java.lang.Object");
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((EmptyParams) baseParams, (c<? super h>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask(MobileAdsBridgeBase.initializeMethodName);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.EmptyParams r5, qf.c<? super lf.h> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r5 = r6 instanceof com.unity3d.services.core.domain.task.InitializeSDK.AnonymousClass1
            if (r5 == 0) goto L13
            r5 = r6
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = (com.unity3d.services.core.domain.task.InitializeSDK.AnonymousClass1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
            r5.<init>(r6)
        L18:
            java.lang.Object r6 = r5.result
            java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            lf.f.throwOnFailure(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            lf.f.throwOnFailure(r6)
            com.unity3d.services.core.domain.ISDKDispatchers r6 = r4.dispatchers
            kotlinx.coroutines.b r6 = r6.getDefault()
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2 r1 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2
            r3 = 0
            r1.<init>(r3)
            r5.label = r2
            java.lang.Object r5 = kg.f.withContext(r6, r1, r5)
            if (r5 != r0) goto L49
            return r0
        L49:
            lf.h r5 = lf.h.f16056a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.doWork(com.unity3d.services.core.domain.task.EmptyParams, qf.c):java.lang.Object");
    }
}
