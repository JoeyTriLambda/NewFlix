package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.Device;
import java.util.Map;
import zf.i;

/* compiled from: DeviceInfoReaderWithAuid.kt */
/* loaded from: classes2.dex */
public final class DeviceInfoReaderWithAuid implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderWithAuid(IDeviceInfoReader iDeviceInfoReader) {
        i.checkNotNullParameter(iDeviceInfoReader, "_deviceInfoReader");
        this._deviceInfoReader = iDeviceInfoReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        i.checkNotNullExpressionValue(deviceInfoData, "_deviceInfoReader.deviceInfoData");
        String auid = Device.getAuid();
        if (auid != null) {
            deviceInfoData.put(JsonStorageKeyNames.AUID_ID_KEY, auid);
        }
        return deviceInfoData;
    }
}
