package v0;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final e f20415a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final e f20416b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final e f20417c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f20418d;

    /* renamed from: e, reason: collision with root package name */
    public static final e f20419e;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f20420a = new a();

        @Override // v0.f.c
        public int checkRtl(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (true) {
                char c10 = 2;
                if (i10 >= i12) {
                    return z10 ? 1 : 2;
                }
                byte directionality = Character.getDirectionality(charSequence.charAt(i10));
                e eVar = f.f20415a;
                if (directionality == 0) {
                    c10 = 1;
                } else if (directionality == 1 || directionality == 2) {
                    c10 = 0;
                }
                if (c10 == 0) {
                    return 0;
                }
                if (c10 == 1) {
                    z10 = true;
                }
                i10++;
            }
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f20421a = new b();

        /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
        @Override // v0.f.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int checkRtl(java.lang.CharSequence r4, int r5, int r6) {
            /*
                r3 = this;
                int r6 = r6 + r5
                r0 = 2
                r1 = 2
            L3:
                if (r5 >= r6) goto L23
                if (r1 != r0) goto L23
                char r1 = r4.charAt(r5)
                byte r1 = java.lang.Character.getDirectionality(r1)
                v0.f$e r2 = v0.f.f20415a
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 == r2) goto L1d
                if (r1 == r0) goto L1d
                switch(r1) {
                    case 14: goto L1f;
                    case 15: goto L1f;
                    case 16: goto L1d;
                    case 17: goto L1d;
                    default: goto L1b;
                }
            L1b:
                r1 = 2
                goto L20
            L1d:
                r1 = 0
                goto L20
            L1f:
                r1 = 1
            L20:
                int r5 = r5 + 1
                goto L3
            L23:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: v0.f.b.checkRtl(java.lang.CharSequence, int, int):int");
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public interface c {
        int checkRtl(CharSequence charSequence, int i10, int i11);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static abstract class d implements v0.e {

        /* renamed from: a, reason: collision with root package name */
        public final c f20422a;

        public d(c cVar) {
            this.f20422a = cVar;
        }

        public abstract boolean defaultIsRtl();

        @Override // v0.e
        public boolean isRtl(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            c cVar = this.f20422a;
            if (cVar == null) {
                return defaultIsRtl();
            }
            int iCheckRtl = cVar.checkRtl(charSequence, i10, i11);
            if (iCheckRtl == 0) {
                return true;
            }
            if (iCheckRtl != 1) {
                return defaultIsRtl();
            }
            return false;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    public static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20423b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f20423b = z10;
        }

        @Override // v0.f.d
        public boolean defaultIsRtl() {
            return this.f20423b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: v0.f$f, reason: collision with other inner class name */
    public static class C0293f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final C0293f f20424b = new C0293f();

        public C0293f() {
            super(null);
        }

        @Override // v0.f.d
        public boolean defaultIsRtl() {
            return g.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f20421a;
        f20417c = new e(bVar, false);
        f20418d = new e(bVar, true);
        f20419e = new e(a.f20420a, false);
    }
}
