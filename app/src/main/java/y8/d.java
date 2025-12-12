package y8;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final b f22022a;

    /* renamed from: b, reason: collision with root package name */
    public final a f22023b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22024c;

    /* renamed from: d, reason: collision with root package name */
    public final double f22025d;

    /* renamed from: e, reason: collision with root package name */
    public final double f22026e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22027f;

    /* compiled from: Settings.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f22028a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22029b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f22030c;

        public a(boolean z10, boolean z11, boolean z12) {
            this.f22028a = z10;
            this.f22029b = z11;
            this.f22030c = z12;
        }
    }

    /* compiled from: Settings.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22031a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22032b;

        public b(int i10, int i11) {
            this.f22031a = i10;
            this.f22032b = i11;
        }
    }

    public d(long j10, b bVar, a aVar, int i10, int i11, double d10, double d11, int i12) {
        this.f22024c = j10;
        this.f22022a = bVar;
        this.f22023b = aVar;
        this.f22025d = d10;
        this.f22026e = d11;
        this.f22027f = i12;
    }

    public boolean isExpired(long j10) {
        return this.f22024c < j10;
    }
}
