package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: b, reason: collision with root package name */
    public int f2810b;

    /* renamed from: c, reason: collision with root package name */
    public int f2811c;

    /* renamed from: d, reason: collision with root package name */
    public int f2812d;

    /* renamed from: e, reason: collision with root package name */
    public int f2813e;

    /* renamed from: f, reason: collision with root package name */
    public int f2814f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2815g;

    /* renamed from: h, reason: collision with root package name */
    public String f2816h;

    /* renamed from: i, reason: collision with root package name */
    public int f2817i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f2818j;

    /* renamed from: k, reason: collision with root package name */
    public int f2819k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2820l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<String> f2821m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<String> f2822n;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f2809a = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public boolean f2823o = false;

    /* compiled from: FragmentTransaction.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2824a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f2825b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2826c;

        /* renamed from: d, reason: collision with root package name */
        public int f2827d;

        /* renamed from: e, reason: collision with root package name */
        public int f2828e;

        /* renamed from: f, reason: collision with root package name */
        public int f2829f;

        /* renamed from: g, reason: collision with root package name */
        public int f2830g;

        /* renamed from: h, reason: collision with root package name */
        public Lifecycle.State f2831h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f2832i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f2824a = i10;
            this.f2825b = fragment;
            this.f2826c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f2831h = state;
            this.f2832i = state;
        }

        public a(int i10, Fragment fragment, int i11) {
            this.f2824a = i10;
            this.f2825b = fragment;
            this.f2826c = true;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f2831h = state;
            this.f2832i = state;
        }
    }

    public final void a(a aVar) {
        this.f2809a.add(aVar);
        aVar.f2827d = this.f2810b;
        aVar.f2828e = this.f2811c;
        aVar.f2829f = this.f2812d;
        aVar.f2830g = this.f2813e;
    }

    public g0 add(Fragment fragment, String str) {
        b(0, fragment, str, 1);
        return this;
    }

    public abstract void b(int i10, Fragment fragment, String str, int i11);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public g0 disallowAddToBackStack() {
        if (this.f2815g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    public g0 remove(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public g0 replace(int i10, Fragment fragment) {
        return replace(i10, fragment, null);
    }

    public g0 setReorderingAllowed(boolean z10) {
        this.f2823o = z10;
        return this;
    }

    public g0 add(int i10, Fragment fragment) {
        b(i10, fragment, null, 1);
        return this;
    }

    public g0 replace(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        b(i10, fragment, str, 2);
        return this;
    }

    public g0 add(int i10, Fragment fragment, String str) {
        b(i10, fragment, str, 1);
        return this;
    }
}
