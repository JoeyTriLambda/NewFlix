package i9;

import com.google.auto.value.AutoValue;
import i9.a;

/* compiled from: InstallationTokenResult.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class f {

    /* compiled from: InstallationTokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract f build();

        public abstract a setToken(String str);

        public abstract a setTokenCreationTimestamp(long j10);

        public abstract a setTokenExpirationTimestamp(long j10);
    }

    public static a builder() {
        return new a.C0167a();
    }

    public abstract String getToken();

    public abstract long getTokenCreationTimestamp();

    public abstract long getTokenExpirationTimestamp();
}
