package p4;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.auto.value.AutoValue;
import java.util.List;
import p4.e;

/* compiled from: LogRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class i {
    public static a builder() {
        return new e.a();
    }

    public abstract ClientInfo getClientInfo();

    public abstract List<h> getLogEvents();

    public abstract Integer getLogSource();

    public abstract String getLogSourceName();

    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();

    /* compiled from: LogRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract i build();

        public abstract a setClientInfo(ClientInfo clientInfo);

        public abstract a setLogEvents(List<h> list);

        public abstract a setQosTier(QosTier qosTier);

        public abstract a setRequestTimeMs(long j10);

        public abstract a setRequestUptimeMs(long j10);

        public a setSource(int i10) {
            e.a aVar = (e.a) this;
            aVar.f17593d = Integer.valueOf(i10);
            return aVar;
        }

        public a setSource(String str) {
            e.a aVar = (e.a) this;
            aVar.f17594e = str;
            return aVar;
        }
    }
}
