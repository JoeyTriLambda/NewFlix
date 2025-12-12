package t8;

import com.google.auto.value.AutoValue;

/* compiled from: StaticSessionData.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class g0 {

    /* compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class a {
        public static a create(String str, String str2, String str3, String str4, int i10, o8.d dVar) {
            return new c0(str, str2, str3, str4, i10, dVar);
        }

        public abstract String appIdentifier();

        public abstract int deliveryMechanism();

        public abstract o8.d developmentPlatformProvider();

        public abstract String installUuid();

        public abstract String versionCode();

        public abstract String versionName();
    }

    /* compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class b {
        public static b create(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
            return new d0(i10, str, i11, j10, j11, z10, i12, str2, str3);
        }

        public abstract int arch();

        public abstract int availableProcessors();

        public abstract long diskSpace();

        public abstract boolean isEmulator();

        public abstract String manufacturer();

        public abstract String model();

        public abstract String modelClass();

        public abstract int state();

        public abstract long totalRam();
    }

    /* compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class c {
        public static c create(String str, String str2, boolean z10) {
            return new e0(str, str2, z10);
        }

        public abstract boolean isRooted();

        public abstract String osCodeName();

        public abstract String osRelease();
    }

    public static g0 create(a aVar, c cVar, b bVar) {
        return new b0(aVar, cVar, bVar);
    }

    public abstract a appData();

    public abstract b deviceData();

    public abstract c osData();
}
