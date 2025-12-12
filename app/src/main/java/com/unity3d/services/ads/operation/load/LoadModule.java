package com.unity3d.services.ads.operation.load;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LoadModule extends BaseLoadModule {
    static ILoadModule _instance;

    public LoadModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }

    public static ILoadModule getInstance() {
        if (_instance == null) {
            _instance = new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(new LoadModule((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)), InitializationNotificationCenter.getInstance()), new ConfigurationReader());
        }
        return _instance;
    }

    @Override // com.unity3d.services.ads.operation.load.BaseLoadModule
    public void addOptionalParameters(LoadOperationState loadOperationState, JSONObject jSONObject) {
    }
}
