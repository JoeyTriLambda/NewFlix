package q4;

import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import q4.b;

/* compiled from: EventInternal.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class i {

    /* compiled from: EventInternal.java */
    @AutoValue.Builder
    public static abstract class a {
        public final a addMetadata(String str, String str2) {
            getAutoMetadata().put(str, str2);
            return this;
        }

        public abstract i build();

        public abstract Map<String, String> getAutoMetadata();

        public abstract a setAutoMetadata(Map<String, String> map);

        public abstract a setCode(Integer num);

        public abstract a setEncodedPayload(h hVar);

        public abstract a setEventMillis(long j10);

        public abstract a setTransportName(String str);

        public abstract a setUptimeMillis(long j10);

        public final a addMetadata(String str, long j10) {
            getAutoMetadata().put(str, String.valueOf(j10));
            return this;
        }

        public final a addMetadata(String str, int i10) {
            getAutoMetadata().put(str, String.valueOf(i10));
            return this;
        }
    }

    public static a builder() {
        return new b.a().setAutoMetadata(new HashMap());
    }

    public final String get(String str) {
        String str2 = getAutoMetadata().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> getAutoMetadata();

    public abstract Integer getCode();

    public abstract h getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(getAutoMetadata());
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public a toBuilder() {
        return new b.a().setTransportName(getTransportName()).setCode(getCode()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).setAutoMetadata(new HashMap(getAutoMetadata()));
    }
}
