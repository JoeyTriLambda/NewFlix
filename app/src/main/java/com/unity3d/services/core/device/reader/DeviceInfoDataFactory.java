package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderPrivacyBuilder;

/* loaded from: classes2.dex */
public class DeviceInfoDataFactory {

    /* renamed from: com.unity3d.services.core.device.reader.DeviceInfoDataFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$configuration$InitRequestType;

        static {
            int[] iArr = new int[InitRequestType.values().length];
            $SwitchMap$com$unity3d$services$core$configuration$InitRequestType = iArr;
            try {
                iArr[InitRequestType.TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$configuration$InitRequestType[InitRequestType.PRIVACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private IDeviceInfoDataContainer getPrivacyDeviceInfoData() {
        return new DeviceInfoReaderCompressor(new DeviceInfoReaderPrivacyBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()).build());
    }

    private IDeviceInfoDataContainer getTokenDeviceInfoData() {
        return new DeviceInfoReaderCompressorWithMetrics(new DeviceInfoReaderCompressor(new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()).build()));
    }

    public IDeviceInfoDataContainer getDeviceInfoData(InitRequestType initRequestType) {
        int i10 = AnonymousClass1.$SwitchMap$com$unity3d$services$core$configuration$InitRequestType[initRequestType.ordinal()];
        if (i10 == 1) {
            return getTokenDeviceInfoData();
        }
        if (i10 != 2) {
            return null;
        }
        return getPrivacyDeviceInfoData();
    }
}
