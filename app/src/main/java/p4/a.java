package p4;

import com.google.auto.value.AutoValue;
import p4.b;

/* compiled from: AndroidClientInfo.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: AndroidClientInfo.java */
    @AutoValue.Builder
    /* renamed from: p4.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0222a {
        public abstract a build();

        public abstract AbstractC0222a setApplicationBuild(String str);

        public abstract AbstractC0222a setCountry(String str);

        public abstract AbstractC0222a setDevice(String str);

        public abstract AbstractC0222a setFingerprint(String str);

        public abstract AbstractC0222a setHardware(String str);

        public abstract AbstractC0222a setLocale(String str);

        public abstract AbstractC0222a setManufacturer(String str);

        public abstract AbstractC0222a setMccMnc(String str);

        public abstract AbstractC0222a setModel(String str);

        public abstract AbstractC0222a setOsBuild(String str);

        public abstract AbstractC0222a setProduct(String str);

        public abstract AbstractC0222a setSdkVersion(Integer num);
    }

    public static AbstractC0222a builder() {
        return new b.a();
    }

    public abstract String getApplicationBuild();

    public abstract String getCountry();

    public abstract String getDevice();

    public abstract String getFingerprint();

    public abstract String getHardware();

    public abstract String getLocale();

    public abstract String getManufacturer();

    public abstract String getMccMnc();

    public abstract String getModel();

    public abstract String getOsBuild();

    public abstract String getProduct();

    public abstract Integer getSdkVersion();
}
