package c8;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l1;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import ne.q;
import ne.u;
import se.n;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class i implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i f5250a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f5251b = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[][] f5252c = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f5253d = {95.047f, 100.0f, 108.883f};

    /* renamed from: e, reason: collision with root package name */
    public static final float[][] f5254e = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* renamed from: f, reason: collision with root package name */
    public static final qf.c[] f5255f = new qf.c[0];

    public static void a(int i10, String str) {
        if (i10 >= 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 40);
        sb2.append(str);
        sb2.append(" cannot be negative but was: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static Object b(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("must be power of 2 between 2^1 and 2^30: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int c(Set set) {
        Iterator it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static int d(float f10) {
        if (f10 < 1.0f) {
            return -16777216;
        }
        if (f10 > 99.0f) {
            return -1;
        }
        float f11 = (f10 + 16.0f) / 116.0f;
        float f12 = (f10 > 8.0f ? 1 : (f10 == 8.0f ? 0 : -1)) > 0 ? f11 * f11 * f11 : f10 / 903.2963f;
        float f13 = f11 * f11 * f11;
        boolean z10 = f13 > 0.008856452f;
        float f14 = z10 ? f13 : ((f11 * 116.0f) - 16.0f) / 903.2963f;
        if (!z10) {
            f13 = ((f11 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f5253d;
        return o0.a.XYZToColor(f14 * fArr[0], f12 * fArr[1], f13 * fArr[2]);
    }

    public static float e(int i10) {
        float f10 = i10 / 255.0f;
        return (f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static String f(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public static void g(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof l1) {
                editorInfo.hintText = ((l1) parent).getHint();
                return;
            }
        }
    }

    public static int i(Object obj, Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i11;
        int i12;
        int iK = k(obj);
        int i13 = iK & i10;
        int iL = l(i13, obj3);
        if (iL == 0) {
            return -1;
        }
        int i14 = ~i10;
        int i15 = iK & i14;
        int i16 = -1;
        while (true) {
            i11 = iL - 1;
            i12 = iArr[i11];
            if ((i12 & i14) == i15 && b8.d.equal(obj, objArr[i11]) && (objArr2 == null || b8.d.equal(obj2, objArr2[i11]))) {
                break;
            }
            int i17 = i12 & i10;
            if (i17 == 0) {
                return -1;
            }
            i16 = i11;
            iL = i17;
        }
        int i18 = i12 & i10;
        if (i16 == -1) {
            m(i13, i18, obj3);
        } else {
            iArr[i16] = (i18 & i10) | (iArr[i16] & i14);
        }
        return i11;
    }

    public static int j(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    public static int k(Object obj) {
        return j(obj == null ? 0 : obj.hashCode());
    }

    public static int l(int i10, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & 255 : obj instanceof short[] ? ((short[]) obj)[i10] & 65535 : ((int[]) obj)[i10];
    }

    public static void m(int i10, int i11, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean n(ne.k kVar, n nVar, ne.b bVar) {
        if (!(kVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) kVar).call();
            ne.c cVar = objCall != null ? (ne.c) ue.a.requireNonNull(nVar.apply(objCall), "The mapper returned a null CompletableSource") : null;
            if (cVar == null) {
                EmptyDisposable.complete(bVar);
            } else {
                cVar.subscribe(bVar);
            }
            return true;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, bVar);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean o(ne.k kVar, n nVar, q qVar) {
        if (!(kVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) kVar).call();
            ne.i iVar = objCall != null ? (ne.i) ue.a.requireNonNull(nVar.apply(objCall), "The mapper returned a null MaybeSource") : null;
            if (iVar == null) {
                EmptyDisposable.complete((q<?>) qVar);
            } else {
                iVar.subscribe(MaybeToObservable.create(qVar));
            }
            return true;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, (q<?>) qVar);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean p(ne.k kVar, n nVar, q qVar) {
        if (!(kVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) kVar).call();
            u uVar = objCall != null ? (u) ue.a.requireNonNull(nVar.apply(objCall), "The mapper returned a null SingleSource") : null;
            if (uVar == null) {
                EmptyDisposable.complete((q<?>) qVar);
            } else {
                uVar.subscribe(SingleToObservable.create(qVar));
            }
            return true;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, (q<?>) qVar);
            return true;
        }
    }

    public static float q() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void h(Rect rect) {
        throw null;
    }
}
