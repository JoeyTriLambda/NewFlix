package ig;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import yf.p;

/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public final class d implements hg.d<fg.c> {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f13443a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13444b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13445c;

    /* renamed from: d, reason: collision with root package name */
    public final p<CharSequence, Integer, Pair<Integer, Integer>> f13446d;

    /* compiled from: Strings.kt */
    public static final class a implements Iterator<fg.c>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public int f13447b = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f13448m;

        /* renamed from: n, reason: collision with root package name */
        public int f13449n;

        /* renamed from: o, reason: collision with root package name */
        public fg.c f13450o;

        /* renamed from: p, reason: collision with root package name */
        public int f13451p;

        public a() {
            int iCoerceIn = fg.h.coerceIn(d.this.f13444b, 0, d.this.f13443a.length());
            this.f13448m = iCoerceIn;
            this.f13449n = iCoerceIn;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r7 = this;
                int r0 = r7.f13449n
                r1 = 0
                if (r0 >= 0) goto Lc
                r7.f13447b = r1
                r0 = 0
                r7.f13450o = r0
                goto L92
            Lc:
                ig.d r0 = ig.d.this
                int r2 = ig.d.access$getLimit$p(r0)
                r3 = -1
                r4 = 1
                if (r2 <= 0) goto L21
                int r2 = r7.f13451p
                int r2 = r2 + r4
                r7.f13451p = r2
                int r5 = ig.d.access$getLimit$p(r0)
                if (r2 >= r5) goto L2d
            L21:
                int r2 = r7.f13449n
                java.lang.CharSequence r5 = ig.d.access$getInput$p(r0)
                int r5 = r5.length()
                if (r2 <= r5) goto L41
            L2d:
                fg.c r1 = new fg.c
                int r2 = r7.f13448m
                java.lang.CharSequence r0 = ig.d.access$getInput$p(r0)
                int r0 = kotlin.text.StringsKt__StringsKt.getLastIndex(r0)
                r1.<init>(r2, r0)
                r7.f13450o = r1
                r7.f13449n = r3
                goto L90
            L41:
                yf.p r2 = ig.d.access$getGetNextMatch$p(r0)
                java.lang.CharSequence r5 = ig.d.access$getInput$p(r0)
                int r6 = r7.f13449n
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.Object r2 = r2.invoke(r5, r6)
                kotlin.Pair r2 = (kotlin.Pair) r2
                if (r2 != 0) goto L6b
                fg.c r1 = new fg.c
                int r2 = r7.f13448m
                java.lang.CharSequence r0 = ig.d.access$getInput$p(r0)
                int r0 = kotlin.text.StringsKt__StringsKt.getLastIndex(r0)
                r1.<init>(r2, r0)
                r7.f13450o = r1
                r7.f13449n = r3
                goto L90
            L6b:
                java.lang.Object r0 = r2.component1()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                java.lang.Object r2 = r2.component2()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                int r3 = r7.f13448m
                fg.c r3 = fg.h.until(r3, r0)
                r7.f13450o = r3
                int r0 = r0 + r2
                r7.f13448m = r0
                if (r2 != 0) goto L8d
                r1 = 1
            L8d:
                int r0 = r0 + r1
                r7.f13449n = r0
            L90:
                r7.f13447b = r4
            L92:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ig.d.a.a():void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f13447b == -1) {
                a();
            }
            return this.f13447b == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public fg.c next() {
            if (this.f13447b == -1) {
                a();
            }
            if (this.f13447b == 0) {
                throw new NoSuchElementException();
            }
            fg.c cVar = this.f13450o;
            zf.i.checkNotNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f13450o = null;
            this.f13447b = -1;
            return cVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i10, int i11, p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> pVar) {
        zf.i.checkNotNullParameter(charSequence, "input");
        zf.i.checkNotNullParameter(pVar, "getNextMatch");
        this.f13443a = charSequence;
        this.f13444b = i10;
        this.f13445c = i11;
        this.f13446d = pVar;
    }

    @Override // hg.d
    public Iterator<fg.c> iterator() {
        return new a();
    }
}
