package org.koin.core.scope;

import ac.c;
import java.util.ArrayList;
import java.util.Iterator;
import lf.h;
import mf.f;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import th.a;
import yh.b;
import zf.i;

/* compiled from: Scope.kt */
/* loaded from: classes2.dex */
public final class Scope {

    /* renamed from: a, reason: collision with root package name */
    public final a f17386a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17387b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17388c;

    /* renamed from: d, reason: collision with root package name */
    public final kh.a f17389d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<Scope> f17390e;

    /* renamed from: f, reason: collision with root package name */
    public Object f17391f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<vh.a> f17392g;

    /* renamed from: h, reason: collision with root package name */
    public final f<sh.a> f17393h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17394i;

    public Scope(a aVar, String str, boolean z10, kh.a aVar2) {
        i.checkNotNullParameter(aVar, "scopeQualifier");
        i.checkNotNullParameter(str, "id");
        i.checkNotNullParameter(aVar2, "_koin");
        this.f17386a = aVar;
        this.f17387b = str;
        this.f17388c = z10;
        this.f17389d = aVar2;
        this.f17390e = new ArrayList<>();
        this.f17392g = new ArrayList<>();
        this.f17393h = new f<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(gg.b r11, th.a r12, yf.a r13) throws org.koin.core.error.ClosedScopeException, org.koin.core.error.NoBeanDefFoundException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.a(gg.b, th.a, yf.a):java.lang.Object");
    }

    public final void close() {
        b.f22543a.m238synchronized(this, new yf.a<h>() { // from class: org.koin.core.scope.Scope.close.1
            {
                super(0);
            }

            @Override // yf.a
            public /* bridge */ /* synthetic */ h invoke() {
                invoke2();
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Scope scope = Scope.this;
                qh.b logger = scope.get_koin().getLogger();
                String str = "|- (-) Scope - id:'" + scope.getId() + '\'';
                Level level = Level.DEBUG;
                if (logger.isAt(level)) {
                    logger.display(level, str);
                }
                Iterator it = scope.f17392g.iterator();
                while (it.hasNext()) {
                    ((vh.a) it.next()).onScopeClose(scope);
                }
                scope.f17392g.clear();
                scope.set_source(null);
                scope.f17394i = true;
                scope.get_koin().getScopeRegistry().deleteScope$koin_core(scope);
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) obj;
        return i.areEqual(this.f17386a, scope.f17386a) && i.areEqual(this.f17387b, scope.f17387b) && this.f17388c == scope.f17388c && i.areEqual(this.f17389d, scope.f17389d);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> T get(gg.b<?> r10, th.a r11, yf.a<? extends sh.a> r12) {
        /*
            r9 = this;
            java.lang.String r0 = "clazz"
            zf.i.checkNotNullParameter(r10, r0)
            kh.a r0 = r9.f17389d
            qh.b r1 = r0.getLogger()
            org.koin.core.logger.Level r2 = org.koin.core.logger.Level.DEBUG
            boolean r1 = r1.isAt(r2)
            if (r1 == 0) goto L8b
            r1 = 39
            if (r11 == 0) goto L2a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = " with qualifier '"
            r3.<init>(r4)
            r3.append(r11)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L2c
        L2a:
            java.lang.String r3 = ""
        L2c:
            qh.b r4 = r0.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "|- '"
            r5.<init>(r6)
            java.lang.String r7 = xh.a.getFullName(r10)
            r5.append(r7)
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = " ..."
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4.display(r2, r1)
            yh.a r1 = yh.a.f22542a
            long r3 = r1.getTimeInNanoSeconds()
            java.lang.Object r11 = r9.a(r10, r11, r12)
            long r7 = r1.getTimeInNanoSeconds()
            long r7 = r7 - r3
            double r3 = (double) r7
            r7 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r7
            qh.b r12 = r0.getLogger()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            java.lang.String r10 = xh.a.getFullName(r10)
            r0.append(r10)
            java.lang.String r10 = "' in "
            r0.append(r10)
            r0.append(r3)
            java.lang.String r10 = " ms"
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r12.display(r2, r10)
            goto L8f
        L8b:
            java.lang.Object r11 = r9.a(r10, r11, r12)
        L8f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.scope.Scope.get(gg.b, th.a, yf.a):java.lang.Object");
    }

    public final String getId() {
        return this.f17387b;
    }

    public final <T> T getOrNull(gg.b<?> bVar, a aVar, yf.a<? extends sh.a> aVar2) {
        Level level = Level.DEBUG;
        kh.a aVar3 = this.f17389d;
        i.checkNotNullParameter(bVar, "clazz");
        try {
            return (T) get(bVar, aVar, aVar2);
        } catch (ClosedScopeException unused) {
            qh.b logger = aVar3.getLogger();
            String str = "* Scope closed - no instance found for " + xh.a.getFullName(bVar) + " on scope " + this;
            if (!logger.isAt(level)) {
                return null;
            }
            logger.display(level, str);
            return null;
        } catch (NoBeanDefFoundException unused2) {
            qh.b logger2 = aVar3.getLogger();
            String str2 = "* No instance found for " + xh.a.getFullName(bVar) + " on scope " + this;
            if (!logger2.isAt(level)) {
                return null;
            }
            logger2.display(level, str2);
            return null;
        }
    }

    public final a getScopeQualifier() {
        return this.f17386a;
    }

    public final kh.a get_koin() {
        return this.f17389d;
    }

    public final f<sh.a> get_parameterStack() {
        return this.f17393h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iB = c.b(this.f17387b, this.f17386a.hashCode() * 31, 31);
        boolean z10 = this.f17388c;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return this.f17389d.hashCode() + ((iB + i10) * 31);
    }

    public final void set_source(Object obj) {
        this.f17391f = obj;
    }

    public String toString() {
        return c.o(new StringBuilder("['"), this.f17387b, "']");
    }
}
