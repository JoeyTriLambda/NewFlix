package com.unity3d.services.ads.topics;

import android.adservices.AdServicesState;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.ext.SdkExtensions;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.lang.reflect.InvocationTargetException;
import kg.c1;
import zf.i;

/* compiled from: TopicsService.kt */
@SuppressLint({"NewApi", "MissingPermission"})
/* loaded from: classes2.dex */
public final class TopicsService {
    private final ISDKDispatchers dispatchers;
    private final IEventSender eventSender;
    private final TopicsManager topicsManager;

    public TopicsService(Context context, ISDKDispatchers iSDKDispatchers, IEventSender iEventSender) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(iEventSender, "eventSender");
        this.dispatchers = iSDKDispatchers;
        this.eventSender = iEventSender;
        this.topicsManager = getTopicsManager(context);
    }

    private final TopicsManager getTopicsManager(Context context) {
        if (Device.getApiLevel() >= 33 && SdkExtensions.getExtensionVersion(1000000) >= 4) {
            return (TopicsManager) context.getSystemService(TopicsManager.class);
        }
        return null;
    }

    public final TopicsStatus checkAvailability() {
        return Device.getApiLevel() < 33 ? TopicsStatus.ERROR_API_BELOW_33 : SdkExtensions.getExtensionVersion(1000000) < 4 ? TopicsStatus.ERROR_EXTENSION_BELOW_4 : this.topicsManager == null ? TopicsStatus.ERROR_TOPICSMANAGER_NULL : !AdServicesState.isAdServicesStateEnabled() ? TopicsStatus.ERROR_AD_SERVICES_DISABLED : TopicsStatus.TOPICS_AVAILABLE;
    }

    public final void getTopics(String str, boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(str, "adsSdkName");
        TopicsReceiver topicsReceiver = new TopicsReceiver(this.eventSender);
        GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(str).setShouldRecordObservation(z10).build();
        i.checkNotNullExpressionValue(getTopicsRequestBuild, "Builder().setAdsSdkName(…ecordObservation).build()");
        try {
            TopicsManager topicsManager = this.topicsManager;
            if (topicsManager != null) {
                topicsManager.getTopics(getTopicsRequestBuild, c1.asExecutor(this.dispatchers.getDefault()), topicsReceiver);
            }
        } catch (Exception e10) {
            this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, e10.toString());
            DeviceLog.debug("Failed to get topics with error: " + e10);
        }
    }
}
