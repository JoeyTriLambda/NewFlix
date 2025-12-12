package ya;

import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;
import xa.b;
import xa.c;
import xa.d;
import xa.e;
import xa.f;
import xa.g;
import xa.h;
import xa.i;
import xa.j;
import xa.k;

/* compiled from: LoaderGenerator.java */
/* loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static d generateLoaderView(String str) {
        str.getClass();
        switch (str) {
            case "FourPulse":
                try {
                    return new f(4);
                } catch (InvalidNumberOfPulseException e10) {
                    e10.printStackTrace();
                    break;
                }
            case "FishSpinner":
                return new b();
            case "TwinFishesSpinner":
                return new i();
            case "Worm":
                return new k();
            case "LineSpinner":
                return new c();
            case "Radar":
                return new g();
            case "Whirlpool":
                return new j();
            case "Sharingan":
                return new h();
            case "ClassicSpinner":
                return new xa.a();
            case "ThreePulse":
                try {
                    return new f(3);
                } catch (InvalidNumberOfPulseException e11) {
                    e11.printStackTrace();
                    break;
                }
            case "FivePulse":
                try {
                    return new f(5);
                } catch (InvalidNumberOfPulseException e12) {
                    e12.printStackTrace();
                    break;
                }
            case "PhoneWave":
                return new e();
            default:
                return new xa.a();
        }
    }
}
