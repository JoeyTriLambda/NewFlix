package com.unity3d.services.core.webview;

import ac.c;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
public class WebViewUrlBuilder {
    private final SDKMetricsSender _sdkMetricsSender;
    private final String _urlWithQueryString;

    public WebViewUrlBuilder(String str, Configuration configuration) {
        SDKMetricsSender sDKMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
        this._sdkMetricsSender = sDKMetricsSender;
        StringBuilder sbR = c.r("?platform=android" + buildQueryParam("origin", configuration.getWebViewUrl()));
        sbR.append(buildQueryParam("version", configuration.getWebViewVersion()));
        StringBuilder sbR2 = c.r(sbR.toString());
        sbR2.append(buildQueryParam("isNativeCollectingMetrics", String.valueOf(sDKMetricsSender.areMetricsEnabledForCurrentSession())));
        this._urlWithQueryString = c.B(str, sbR2.toString());
    }

    private String buildQueryParam(String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (str2 == null) {
            return "";
        }
        try {
            return "&" + str + "=" + URLEncoder.encode(str2, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            DeviceLog.exception(String.format("Unsupported charset when encoding %s", str), e10);
            return "";
        }
    }

    public String getUrlWithQueryString() {
        return this._urlWithQueryString;
    }
}
