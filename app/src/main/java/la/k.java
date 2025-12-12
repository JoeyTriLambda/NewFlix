package la;

import android.os.Handler;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import la.a;

/* compiled from: ValueAnimator.java */
/* loaded from: classes.dex */
public final class k extends la.a {
    public static final ThreadLocal<f> D = new ThreadLocal<>();
    public static final a E = new a();
    public static final b F = new b();
    public static final c G = new c();
    public static final d H = new d();
    public static final e I = new e();
    public static final AccelerateDecelerateInterpolator J = new AccelerateDecelerateInterpolator();
    public static final long K;
    public i[] B;
    public HashMap<String, i> C;

    /* renamed from: m, reason: collision with root package name */
    public long f16031m;

    /* renamed from: s, reason: collision with root package name */
    public long f16037s;

    /* renamed from: n, reason: collision with root package name */
    public long f16032n = -1;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16033o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f16034p = 0;

    /* renamed from: q, reason: collision with root package name */
    public float f16035q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    public boolean f16036r = false;

    /* renamed from: t, reason: collision with root package name */
    public int f16038t = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f16039u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f16040v = false;

    /* renamed from: w, reason: collision with root package name */
    public long f16041w = 300;

    /* renamed from: x, reason: collision with root package name */
    public long f16042x = 0;

    /* renamed from: y, reason: collision with root package name */
    public final int f16043y = 1;

    /* renamed from: z, reason: collision with root package name */
    public Interpolator f16044z = J;
    public ArrayList<g> A = null;

    /* compiled from: ValueAnimator.java */
    public static class a extends ThreadLocal<ArrayList<k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    public static class b extends ThreadLocal<ArrayList<k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    public static class c extends ThreadLocal<ArrayList<k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    public static class d extends ThreadLocal<ArrayList<k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    public static class e extends ThreadLocal<ArrayList<k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: ValueAnimator.java */
    public static class f extends Handler {
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00a9 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r18) {
            /*
                Method dump skipped, instructions count: 301
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: la.k.f.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: ValueAnimator.java */
    public interface g {
        void onAnimationUpdate(k kVar);
    }

    static {
        new la.e();
        new la.c();
        K = 10L;
    }

    public static void a(k kVar) {
        ArrayList<a.InterfaceC0190a> arrayList;
        kVar.d();
        E.get().add(kVar);
        if (kVar.f16042x <= 0 || (arrayList = kVar.f16002b) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((a.InterfaceC0190a) arrayList2.get(i10)).onAnimationStart(kVar);
        }
    }

    public static k ofFloat(float... fArr) {
        k kVar = new k();
        kVar.setFloatValues(fArr);
        return kVar;
    }

    public static k ofInt(int... iArr) {
        k kVar = new k();
        kVar.setIntValues(iArr);
        return kVar;
    }

    public void addUpdateListener(g gVar) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(gVar);
    }

    public final boolean b(long j10) {
        boolean z10 = true;
        if (this.f16038t == 0) {
            this.f16038t = 1;
            long j11 = this.f16032n;
            if (j11 < 0) {
                this.f16031m = j10;
            } else {
                this.f16031m = j10 - j11;
                this.f16032n = -1L;
            }
        }
        int i10 = this.f16038t;
        if (i10 != 1 && i10 != 2) {
            return false;
        }
        long j12 = this.f16041w;
        float fMin = j12 > 0 ? (j10 - this.f16031m) / j12 : 1.0f;
        if (fMin < 1.0f) {
            z10 = false;
        } else if (this.f16034p >= 0) {
            fMin = Math.min(fMin, 1.0f);
        } else {
            ArrayList<a.InterfaceC0190a> arrayList = this.f16002b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    this.f16002b.get(i11).onAnimationRepeat(this);
                }
            }
            if (this.f16043y == 2) {
                this.f16033o = !this.f16033o;
            }
            this.f16034p += (int) fMin;
            fMin %= 1.0f;
            this.f16031m += this.f16041w;
            z10 = false;
        }
        if (this.f16033o) {
            fMin = 1.0f - fMin;
        }
        float interpolation = this.f16044z.getInterpolation(fMin);
        this.f16035q = interpolation;
        int length = this.B.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.B[i12].a(interpolation);
        }
        ArrayList<g> arrayList2 = this.A;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                this.A.get(i13).onAnimationUpdate(this);
            }
        }
        return z10;
    }

    public final void c() {
        ArrayList<a.InterfaceC0190a> arrayList;
        E.get().remove(this);
        F.get().remove(this);
        G.get().remove(this);
        this.f16038t = 0;
        if (this.f16039u && (arrayList = this.f16002b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a.InterfaceC0190a) arrayList2.get(i10)).onAnimationEnd(this);
            }
        }
        this.f16039u = false;
    }

    @Override // la.a
    public void cancel() {
        ArrayList<a.InterfaceC0190a> arrayList;
        if (this.f16038t != 0 || F.get().contains(this) || G.get().contains(this)) {
            if (this.f16039u && (arrayList = this.f16002b) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((a.InterfaceC0190a) it.next()).onAnimationCancel(this);
                }
            }
            c();
        }
    }

    public final void d() {
        if (this.f16040v) {
            return;
        }
        int length = this.B.length;
        for (int i10 = 0; i10 < length; i10++) {
            i iVar = this.B[i10];
            if (iVar.f16025p == null) {
                Class cls = iVar.f16022m;
                iVar.f16025p = cls == Integer.class ? i.f16019r : cls == Float.class ? i.f16020s : null;
            }
            j jVar = iVar.f16025p;
            if (jVar != null) {
                iVar.f16023n.setEvaluator(jVar);
            }
        }
        this.f16040v = true;
    }

    public float getAnimatedFraction() {
        return this.f16035q;
    }

    public Object getAnimatedValue() {
        i[] iVarArr = this.B;
        if (iVarArr == null || iVarArr.length <= 0) {
            return null;
        }
        return iVarArr[0].b();
    }

    public long getCurrentPlayTime() {
        if (!this.f16040v || this.f16038t == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f16031m;
    }

    public void setCurrentPlayTime(long j10) {
        d();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f16038t != 1) {
            this.f16032n = j10;
            this.f16038t = 2;
        }
        this.f16031m = jCurrentAnimationTimeMillis - j10;
        b(jCurrentAnimationTimeMillis);
    }

    public k setDuration(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(ac.c.h("Animators cannot have negative duration: ", j10));
        }
        this.f16041w = j10;
        return this;
    }

    public void setFloatValues(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        i[] iVarArr = this.B;
        if (iVarArr == null || iVarArr.length == 0) {
            setValues(i.ofFloat("", fArr));
        } else {
            iVarArr[0].setFloatValues(fArr);
        }
        this.f16040v = false;
    }

    public void setIntValues(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        i[] iVarArr = this.B;
        if (iVarArr == null || iVarArr.length == 0) {
            setValues(i.ofInt("", iArr));
        } else {
            iVarArr[0].setIntValues(iArr);
        }
        this.f16040v = false;
    }

    public void setValues(i... iVarArr) {
        int length = iVarArr.length;
        this.B = iVarArr;
        this.C = new HashMap<>(length);
        for (i iVar : iVarArr) {
            this.C.put(iVar.getPropertyName(), iVar);
        }
        this.f16040v = false;
    }

    public void start() {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f16033o = false;
        this.f16034p = 0;
        this.f16038t = 0;
        this.f16036r = false;
        F.get().add(this);
        if (this.f16042x == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.f16038t = 0;
            this.f16039u = true;
            ArrayList<a.InterfaceC0190a> arrayList = this.f16002b;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((a.InterfaceC0190a) arrayList2.get(i10)).onAnimationStart(this);
                }
            }
        }
        ThreadLocal<f> threadLocal = D;
        f fVar = threadLocal.get();
        if (fVar == null) {
            fVar = new f();
            threadLocal.set(fVar);
        }
        fVar.sendEmptyMessage(0);
    }

    public String toString() {
        String string = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.B != null) {
            for (int i10 = 0; i10 < this.B.length; i10++) {
                StringBuilder sbU = ac.c.u(string, "\n    ");
                sbU.append(this.B[i10].toString());
                string = sbU.toString();
            }
        }
        return string;
    }

    @Override // la.a
    public k clone() {
        k kVar = (k) super.clone();
        ArrayList<g> arrayList = this.A;
        if (arrayList != null) {
            kVar.A = new ArrayList<>();
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                kVar.A.add(arrayList.get(i10));
            }
        }
        kVar.f16032n = -1L;
        kVar.f16033o = false;
        kVar.f16034p = 0;
        kVar.f16040v = false;
        kVar.f16038t = 0;
        kVar.f16036r = false;
        i[] iVarArr = this.B;
        if (iVarArr != null) {
            int length = iVarArr.length;
            kVar.B = new i[length];
            kVar.C = new HashMap<>(length);
            for (int i11 = 0; i11 < length; i11++) {
                i iVarMo87clone = iVarArr[i11].mo87clone();
                kVar.B[i11] = iVarMo87clone;
                kVar.C.put(iVarMo87clone.getPropertyName(), iVarMo87clone);
            }
        }
        return kVar;
    }
}
