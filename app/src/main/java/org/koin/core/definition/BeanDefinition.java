package org.koin.core.definition;

import gg.b;
import java.util.List;
import org.koin.core.scope.Scope;
import th.a;
import yf.p;
import zf.i;

/* compiled from: BeanDefinition.kt */
/* loaded from: classes2.dex */
public final class BeanDefinition<T> {

    /* renamed from: a, reason: collision with root package name */
    public final a f17364a;

    /* renamed from: b, reason: collision with root package name */
    public final b<?> f17365b;

    /* renamed from: c, reason: collision with root package name */
    public final a f17366c;

    /* renamed from: d, reason: collision with root package name */
    public final p<Scope, sh.a, T> f17367d;

    /* renamed from: e, reason: collision with root package name */
    public final Kind f17368e;

    /* renamed from: f, reason: collision with root package name */
    public List<? extends b<?>> f17369f;

    /* renamed from: g, reason: collision with root package name */
    public final nh.b<T> f17370g;

    /* JADX WARN: Multi-variable type inference failed */
    public BeanDefinition(a aVar, b<?> bVar, a aVar2, p<? super Scope, ? super sh.a, ? extends T> pVar, Kind kind, List<? extends b<?>> list) {
        i.checkNotNullParameter(aVar, "scopeQualifier");
        i.checkNotNullParameter(bVar, "primaryType");
        i.checkNotNullParameter(pVar, "definition");
        i.checkNotNullParameter(kind, "kind");
        i.checkNotNullParameter(list, "secondaryTypes");
        this.f17364a = aVar;
        this.f17365b = bVar;
        this.f17366c = aVar2;
        this.f17367d = pVar;
        this.f17368e = kind;
        this.f17369f = list;
        this.f17370g = new nh.b<>(null, 1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        i.checkNotNull(obj, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        BeanDefinition beanDefinition = (BeanDefinition) obj;
        return i.areEqual(this.f17365b, beanDefinition.f17365b) && i.areEqual(this.f17366c, beanDefinition.f17366c) && i.areEqual(this.f17364a, beanDefinition.f17364a);
    }

    public final nh.b<T> getCallbacks() {
        return this.f17370g;
    }

    public final p<Scope, sh.a, T> getDefinition() {
        return this.f17367d;
    }

    public final b<?> getPrimaryType() {
        return this.f17365b;
    }

    public final a getQualifier() {
        return this.f17366c;
    }

    public final a getScopeQualifier() {
        return this.f17364a;
    }

    public final List<b<?>> getSecondaryTypes() {
        return this.f17369f;
    }

    public int hashCode() {
        a aVar = this.f17366c;
        return this.f17364a.hashCode() + ((this.f17365b.hashCode() + ((aVar != null ? aVar.hashCode() : 0) * 31)) * 31);
    }

    public final void setSecondaryTypes(List<? extends b<?>> list) {
        i.checkNotNullParameter(list, "<set-?>");
        this.f17369f = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r14 = this;
            org.koin.core.definition.Kind r0 = r14.f17368e
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "'"
            r1.<init>(r2)
            gg.b<?> r2 = r14.f17365b
            java.lang.String r2 = xh.a.getFullName(r2)
            r1.append(r2)
            r2 = 39
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = ""
            th.a r3 = r14.f17366c
            if (r3 == 0) goto L35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = ",qualifier:"
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            if (r3 != 0) goto L36
        L35:
            r3 = r2
        L36:
            uh.c$a r4 = uh.c.f20383e
            th.c r4 = r4.getRootScopeQualifier()
            th.a r5 = r14.f17364a
            boolean r4 = zf.i.areEqual(r5, r4)
            if (r4 == 0) goto L46
            r4 = r2
            goto L54
        L46:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = ",scope:"
            r4.<init>(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L54:
            java.util.List<? extends gg.b<?>> r5 = r14.f17369f
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L7a
            java.util.List<? extends gg.b<?>> r2 = r14.f17369f
            r5 = r2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.String r6 = ","
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r11 = new yf.l<gg.b<?>, java.lang.CharSequence>() { // from class: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                static {
                    /*
                        org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r0 = new org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1) org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.b org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<init>():void");
                }

                @Override // yf.l
                public final java.lang.CharSequence invoke(gg.b<?> r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        zf.i.checkNotNullParameter(r2, r0)
                        java.lang.String r2 = xh.a.getFullName(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(gg.b):java.lang.CharSequence");
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ java.lang.CharSequence invoke(gg.b<?> r1) {
                    /*
                        r0 = this;
                        gg.b r1 = (gg.b) r1
                        java.lang.CharSequence r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r12 = 30
            r13 = 0
            java.lang.String r2 = mf.q.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.String r5 = ",binds:"
            java.lang.String r2 = ac.c.j(r5, r2)
        L7a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "["
            r5.<init>(r6)
            r5.append(r0)
            r0 = 58
            r5.append(r0)
            r5.append(r1)
            r5.append(r3)
            r5.append(r4)
            r5.append(r2)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition.toString():java.lang.String");
    }
}
