package pg;

/* compiled from: SystemProps.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f17693a = Runtime.getRuntime().availableProcessors();

    public static final int getAVAILABLE_PROCESSORS() {
        return f17693a;
    }

    public static final String systemProp(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
