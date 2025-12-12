package ie;

import android.os.Build;

/* loaded from: classes2.dex */
public final class h extends a {
    public final int A;
    public final String B;
    public final String C;

    /* renamed from: r, reason: collision with root package name */
    public final String f13408r;

    /* renamed from: s, reason: collision with root package name */
    public final String f13409s;

    /* renamed from: t, reason: collision with root package name */
    public final String f13410t;

    /* renamed from: u, reason: collision with root package name */
    public final String f13411u;

    /* renamed from: v, reason: collision with root package name */
    public final String f13412v;

    /* renamed from: w, reason: collision with root package name */
    public final String f13413w;

    /* renamed from: x, reason: collision with root package name */
    public final String f13414x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f13415y;

    /* renamed from: z, reason: collision with root package name */
    public final byte f13416z;

    /* renamed from: c, reason: collision with root package name */
    public final int f13393c = 4096;

    /* renamed from: d, reason: collision with root package name */
    public final int f13394d = 4097;

    /* renamed from: e, reason: collision with root package name */
    public final int f13395e = 4098;

    /* renamed from: f, reason: collision with root package name */
    public final int f13396f = 4099;

    /* renamed from: g, reason: collision with root package name */
    public final int f13397g = 4100;

    /* renamed from: h, reason: collision with root package name */
    public final int f13398h = 4101;

    /* renamed from: i, reason: collision with root package name */
    public final int f13399i = 4102;

    /* renamed from: j, reason: collision with root package name */
    public final int f13400j = 4103;

    /* renamed from: k, reason: collision with root package name */
    public final int f13401k = 4104;

    /* renamed from: l, reason: collision with root package name */
    public final int f13402l = 4105;

    /* renamed from: m, reason: collision with root package name */
    public final int f13403m = 4106;

    /* renamed from: n, reason: collision with root package name */
    public final int f13404n = 4107;

    /* renamed from: o, reason: collision with root package name */
    public final int f13405o = 4108;

    /* renamed from: p, reason: collision with root package name */
    public final int f13406p = 4109;

    /* renamed from: q, reason: collision with root package name */
    public final int f13407q = 4110;
    public final long D = 1;

    public h(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, boolean z11, byte b10, String str8, String str9) {
        this.f13408r = str;
        this.f13410t = str3;
        this.f13409s = str2;
        this.f13411u = str4;
        this.f13412v = str5;
        this.f13413w = str6;
        this.f13414x = str7;
        this.f13415y = z10;
        this.A = z11 ? 1 : 2;
        this.B = str8;
        this.C = str9;
        this.f13416z = b10;
    }

    public byte[] c() {
        String str = this.f13415y ? "5.0.29fg" : "5.0.29";
        j jVarA = j.a();
        jVarA.a(this.f13393c, this.f13408r);
        jVarA.a(this.f13394d, this.f13409s);
        jVarA.a(this.f13400j, this.f13410t);
        jVarA.a(this.f13395e, this.f13411u);
        jVarA.a(this.f13396f, this.f13412v);
        jVarA.a(this.f13397g, str);
        jVarA.a(this.f13398h, this.f13413w);
        jVarA.a(this.f13399i, this.f13414x);
        int i10 = this.f13401k;
        int i11 = this.A;
        jVarA.a(i10, i11);
        jVarA.a(this.f13402l, Build.MANUFACTURER + "_" + Build.MODEL);
        if (i11 != 1) {
            jVarA.a(this.f13403m, this.B);
        }
        jVarA.a(this.f13404n, Build.VERSION.SDK_INT + "(Android " + Build.VERSION.RELEASE + ")");
        jVarA.a(this.f13405o, this.C);
        jVarA.a(this.f13406p, this.f13416z);
        jVarA.a(this.f13407q, this.D);
        return j.a().a(1, jVarA).c();
    }
}
