package r8;

import com.google.auto.value.AutoValue;

/* compiled from: InstallIdProvider.java */
/* loaded from: classes.dex */
public interface i0 {

    /* compiled from: InstallIdProvider.java */
    @AutoValue
    public static abstract class a {
        public static a createWithoutFid(String str) {
            return new c(str, null);
        }

        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseInstallationId();
    }
}
