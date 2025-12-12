package com.unity3d.services.core.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryAsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeContentObserver;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import kg.e0;
import kg.g;
import kg.g0;
import kg.g2;
import kg.h0;
import kotlin.a;
import lf.h;
import okhttp3.OkHttpClient;
import yf.l;
import zf.i;
import zf.k;

/* compiled from: ServiceProvider.kt */
/* loaded from: classes2.dex */
public final class ServiceProvider implements IServiceProvider {
    public static final ServiceProvider INSTANCE;
    public static final String NAMED_SDK = "sdk";
    private static final IServicesRegistry serviceRegistry;

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    private ServiceProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpClient provideHttpClient(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage) {
        IExperiments experiments;
        Configuration configuration = (Configuration) g.runBlocking$default(null, new ServiceProvider$provideHttpClient$config$1(configFileFromLocalStorage, null), 1, null);
        return (configuration == null || (experiments = configuration.getExperiments()) == null || !experiments.isOkHttpEnabled()) ? false : true ? new OkHttp3Client(iSDKDispatchers, new OkHttpClient()) : new LegacyHttpClient(iSDKDispatchers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISDKDispatchers provideSDKDispatchers() {
        return new SDKDispatchers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e0 provideSDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        return new SDKErrorHandler(iSDKDispatchers, sDKMetricsSender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SDKMetricsSender provideSDKMetricSender() {
        SDKMetricsSender sDKMetrics = SDKMetrics.getInstance();
        i.checkNotNullExpressionValue(sDKMetrics, "getInstance()");
        return sDKMetrics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g0 provideSDKScope(ISDKDispatchers iSDKDispatchers, e0 e0Var) {
        return h0.CoroutineScope(iSDKDispatchers.getDefault().plus(g2.SupervisorJob$default(null, 1, null)).plus(e0Var));
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(new l<ServicesRegistry, h>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1
            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(ServicesRegistry servicesRegistry) {
                invoke2(servicesRegistry);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ServicesRegistry servicesRegistry) {
                i.checkNotNullParameter(servicesRegistry, "$this$registry");
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(SDKMetricsSender.class)), a.lazy(new yf.a<SDKMetricsSender>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final SDKMetricsSender invoke() {
                        return ServiceProvider.INSTANCE.provideSDKMetricSender();
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class)), a.lazy(new yf.a<ISDKDispatchers>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final ISDKDispatchers invoke() {
                        return ServiceProvider.INSTANCE.provideSDKDispatchers();
                    }
                }));
                servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, k.getOrCreateKotlinClass(e0.class)), a.lazy(new yf.a<e0>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.3
                    {
                        super(0);
                    }

                    @Override // yf.a
                    public final e0 invoke() {
                        return ServiceProvider.INSTANCE.provideSDKErrorHandler((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey(ServiceProvider.NAMED_SDK, k.getOrCreateKotlinClass(g0.class)), a.lazy(new yf.a<g0>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.4
                    {
                        super(0);
                    }

                    @Override // yf.a
                    public final g0 invoke() {
                        return ServiceProvider.INSTANCE.provideSDKScope((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (e0) servicesRegistry.resolveService(new ServiceKey(ServiceProvider.NAMED_SDK, k.getOrCreateKotlinClass(e0.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(HttpClient.class)), a.lazy(new yf.a<HttpClient>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.5
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final HttpClient invoke() {
                        return ServiceProvider.INSTANCE.provideHttpClient((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new yf.a<InitializeStateNetworkError>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.6
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateNetworkError invoke() {
                        return new InitializeStateNetworkError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class)), a.lazy(new yf.a<ConfigFileFromLocalStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.7
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final ConfigFileFromLocalStorage invoke() {
                        return new ConfigFileFromLocalStorage((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateReset.class)), a.lazy(new yf.a<InitializeStateReset>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.8
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateReset invoke() {
                        return new InitializeStateReset((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateError.class)), a.lazy(new yf.a<InitializeStateError>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.9
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateError invoke() {
                        return new InitializeStateError((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class)), a.lazy(new yf.a<InitializeStateConfigWithLoader>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateConfigWithLoader invoke() {
                        return new InitializeStateConfigWithLoader((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(TokenStorage.class))), (SDKMetricsSender) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateConfig.class)), a.lazy(new yf.a<InitializeStateConfig>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.11
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateConfig invoke() {
                        return new InitializeStateConfig((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateCreate.class)), a.lazy(new yf.a<InitializeStateCreate>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.12
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateCreate invoke() {
                        return new InitializeStateCreate((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateLoadCache.class)), a.lazy(new yf.a<InitializeStateLoadCache>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.13
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateLoadCache invoke() {
                        return new InitializeStateLoadCache((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class)), a.lazy(new yf.a<InitializeStateCreateWithRemote>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.14
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateCreateWithRemote invoke() {
                        return new InitializeStateCreateWithRemote((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateLoadWeb.class)), a.lazy(new yf.a<InitializeStateLoadWeb>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.15
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateLoadWeb invoke() {
                        return new InitializeStateLoadWeb((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (HttpClient) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(HttpClient.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateComplete.class)), a.lazy(new yf.a<InitializeStateComplete>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.16
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeStateComplete invoke() {
                        return new InitializeStateComplete((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeSDK.class)), a.lazy(new yf.a<InitializeSDK>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.17
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final InitializeSDK invoke() {
                        return new InitializeSDK((ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (InitializeStateReset) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateReset.class))), (InitializeStateError) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateError.class))), (InitializeStateConfig) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateConfig.class))), (InitializeStateCreate) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateCreate.class))), (InitializeStateLoadCache) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateLoadCache.class))), (InitializeStateCreateWithRemote) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateCreateWithRemote.class))), (InitializeStateLoadWeb) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateLoadWeb.class))), (InitializeStateComplete) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(InitializeStateComplete.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(TokenStorage.class)), a.lazy(new yf.a<TokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.18
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final TokenStorage invoke() {
                        return new InMemoryTokenStorage();
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(AsyncTokenStorage.class)), a.lazy(new yf.a<AsyncTokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.19
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final AsyncTokenStorage invoke() {
                        return new InMemoryAsyncTokenStorage(null, new Handler(Looper.getMainLooper()), SDKMetrics.getInstance(), (TokenStorage) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(TokenStorage.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(VolumeChange.class)), a.lazy(new yf.a<VolumeChange>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.20
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final VolumeChange invoke() {
                        return new VolumeChangeContentObserver();
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(VolumeChangeMonitor.class)), a.lazy(new yf.a<VolumeChangeMonitor>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.21
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final VolumeChangeMonitor invoke() {
                        return new VolumeChangeMonitor(SharedInstances.INSTANCE.getWebViewEventSender(), (VolumeChange) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(VolumeChange.class))));
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(MeasurementsService.class)), a.lazy(new yf.a<MeasurementsService>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.22
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final MeasurementsService invoke() {
                        Context applicationContext = ClientProperties.getApplicationContext();
                        i.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                        return new MeasurementsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
                    }
                }));
                servicesRegistry.updateService(new ServiceKey("", k.getOrCreateKotlinClass(TopicsService.class)), a.lazy(new yf.a<TopicsService>() { // from class: com.unity3d.services.core.di.ServiceProvider.initialize.1.23
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final TopicsService invoke() {
                        Context applicationContext = ClientProperties.getApplicationContext();
                        i.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
                        return new TopicsService(applicationContext, (ISDKDispatchers) servicesRegistry.resolveService(new ServiceKey("", k.getOrCreateKotlinClass(ISDKDispatchers.class))), SharedInstances.INSTANCE.getWebViewEventSender());
                    }
                }));
            }
        });
    }
}
