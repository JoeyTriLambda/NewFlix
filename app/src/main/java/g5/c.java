package g5;

import java.lang.reflect.Constructor;
import n5.p;
import n5.u;

/* compiled from: DefaultExtractorsFactory.java */
/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: b, reason: collision with root package name */
    public static final Constructor<? extends e> f12706b;

    /* renamed from: a, reason: collision with root package name */
    public final int f12707a = 1;

    static {
        Constructor<? extends e> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f12706b = constructor;
    }

    @Override // g5.h
    public synchronized e[] createExtractors() {
        e[] eVarArr;
        Constructor<? extends e> constructor = f12706b;
        eVarArr = new e[constructor == null ? 11 : 12];
        eVarArr[0] = new i5.d(0);
        eVarArr[1] = new k5.e(0);
        eVarArr[2] = new k5.g(0);
        eVarArr[3] = new j5.b(0);
        eVarArr[4] = new n5.c();
        eVarArr[5] = new n5.a();
        eVarArr[6] = new u(this.f12707a, 0);
        eVarArr[7] = new h5.a();
        eVarArr[8] = new l5.c();
        eVarArr[9] = new p();
        eVarArr[10] = new o5.a();
        if (constructor != null) {
            try {
                eVarArr[11] = constructor.newInstance(new Object[0]);
            } catch (Exception e10) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e10);
            }
        }
        return eVarArr;
    }
}
