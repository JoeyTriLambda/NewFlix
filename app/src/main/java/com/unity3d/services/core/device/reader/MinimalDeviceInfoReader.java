package com.unity3d.services.core.device.reader;

import ac.c;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MinimalDeviceInfoReader implements IDeviceInfoReader {
    final IGameSessionIdReader _gameSessionIdReader;

    public MinimalDeviceInfoReader(IGameSessionIdReader iGameSessionIdReader) {
        this._gameSessionIdReader = iGameSessionIdReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        HashMap mapW = c.w("platform", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
        mapW.put("sdkVersion", Integer.valueOf(SdkProperties.getVersionCode()));
        mapW.put("sdkVersionName", SdkProperties.getVersionName());
        mapW.put(ScarConstants.IDFI_KEY, Device.getIdfi());
        mapW.put(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY, this._gameSessionIdReader.getGameSessionIdAndStore());
        mapW.put("ts", Long.valueOf(System.currentTimeMillis()));
        mapW.put("gameId", ClientProperties.getGameId());
        return mapW;
    }
}
