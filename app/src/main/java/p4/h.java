package p4;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.auto.value.AutoValue;
import p4.d;

/* compiled from: LogEvent.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: LogEvent.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract h build();

        public abstract a setEventCode(Integer num);

        public abstract a setEventTimeMs(long j10);

        public abstract a setEventUptimeMs(long j10);

        public abstract a setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo);

        public abstract a setTimezoneOffsetSeconds(long j10);
    }

    public static a jsonBuilder(String str) {
        d.a aVar = new d.a();
        aVar.f17580e = str;
        return aVar;
    }

    public static a protoBuilder(byte[] bArr) {
        d.a aVar = new d.a();
        aVar.f17579d = bArr;
        return aVar;
    }

    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    public abstract byte[] getSourceExtension();

    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();
}
