package com.google.gson.internal;

import com.google.gson.i;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import u9.c;
import u9.d;
import z9.b;

/* loaded from: classes.dex */
public final class Excluder implements x, Cloneable {

    /* renamed from: q, reason: collision with root package name */
    public static final Excluder f10072q = new Excluder();

    /* renamed from: b, reason: collision with root package name */
    public final double f10073b = -1.0d;

    /* renamed from: m, reason: collision with root package name */
    public final int f10074m = 136;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10075n = true;

    /* renamed from: o, reason: collision with root package name */
    public final List<com.google.gson.a> f10076o = Collections.emptyList();

    /* renamed from: p, reason: collision with root package name */
    public final List<com.google.gson.a> f10077p = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends w<T> {

        /* renamed from: a, reason: collision with root package name */
        public w<T> f10078a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f10079b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f10080c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f10081d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ y9.a f10082e;

        public a(boolean z10, boolean z11, i iVar, y9.a aVar) {
            this.f10079b = z10;
            this.f10080c = z11;
            this.f10081d = iVar;
            this.f10082e = aVar;
        }

        @Override // com.google.gson.w
        public T read(z9.a aVar) throws IOException {
            if (this.f10079b) {
                aVar.skipValue();
                return null;
            }
            w<T> delegateAdapter = this.f10078a;
            if (delegateAdapter == null) {
                delegateAdapter = this.f10081d.getDelegateAdapter(Excluder.this, this.f10082e);
                this.f10078a = delegateAdapter;
            }
            return delegateAdapter.read(aVar);
        }

        @Override // com.google.gson.w
        public void write(b bVar, T t10) throws IOException {
            if (this.f10080c) {
                bVar.nullValue();
                return;
            }
            w<T> delegateAdapter = this.f10078a;
            if (delegateAdapter == null) {
                delegateAdapter = this.f10081d.getDelegateAdapter(Excluder.this, this.f10082e);
                this.f10078a = delegateAdapter;
            }
            delegateAdapter.write(bVar, t10);
        }
    }

    public static boolean c(Class cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        if ((cls.getModifiers() & 8) != 0) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.Class<?> r7) {
        /*
            r6 = this;
            double r0 = r6.f10073b
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L20
            java.lang.Class<u9.c> r0 = u9.c.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            u9.c r0 = (u9.c) r0
            java.lang.Class<u9.d> r1 = u9.d.class
            java.lang.annotation.Annotation r1 = r7.getAnnotation(r1)
            u9.d r1 = (u9.d) r1
            boolean r0 = r6.d(r0, r1)
            if (r0 != 0) goto L20
            return r4
        L20:
            boolean r0 = r6.f10075n
            r1 = 0
            if (r0 != 0) goto L3e
            boolean r0 = r7.isMemberClass()
            if (r0 == 0) goto L3a
            int r0 = r7.getModifiers()
            r0 = r0 & 8
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L3a
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            return r4
        L3e:
            boolean r7 = c(r7)
            if (r7 == 0) goto L45
            return r4
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Excluder.a(java.lang.Class):boolean");
    }

    public final boolean b(Class<?> cls, boolean z10) {
        Iterator<com.google.gson.a> it = (z10 ? this.f10076o : this.f10077p).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zA = a(rawType);
        boolean z10 = zA || b(rawType, true);
        boolean z11 = zA || b(rawType, false);
        if (z10 || z11) {
            return new a(z11, z10, iVar, aVar);
        }
        return null;
    }

    public final boolean d(c cVar, d dVar) {
        double d10 = this.f10073b;
        if (cVar == null || cVar.value() <= d10) {
            return dVar == null || (dVar.value() > d10 ? 1 : (dVar.value() == d10 ? 0 : -1)) > 0;
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z10) {
        return a(cls) || b(cls, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean excludeField(java.lang.reflect.Field r7, boolean r8) {
        /*
            r6 = this;
            int r0 = r7.getModifiers()
            int r1 = r6.f10074m
            r0 = r0 & r1
            r1 = 1
            if (r0 == 0) goto Lb
            return r1
        Lb:
            double r2 = r6.f10073b
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L2a
            java.lang.Class<u9.c> r0 = u9.c.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            u9.c r0 = (u9.c) r0
            java.lang.Class<u9.d> r2 = u9.d.class
            java.lang.annotation.Annotation r2 = r7.getAnnotation(r2)
            u9.d r2 = (u9.d) r2
            boolean r0 = r6.d(r0, r2)
            if (r0 != 0) goto L2a
            return r1
        L2a:
            boolean r0 = r7.isSynthetic()
            if (r0 == 0) goto L31
            return r1
        L31:
            boolean r0 = r6.f10075n
            r2 = 0
            if (r0 != 0) goto L53
            java.lang.Class r0 = r7.getType()
            boolean r3 = r0.isMemberClass()
            if (r3 == 0) goto L4f
            int r0 = r0.getModifiers()
            r0 = r0 & 8
            if (r0 == 0) goto L4a
            r0 = 1
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 != 0) goto L4f
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 == 0) goto L53
            return r1
        L53:
            java.lang.Class r0 = r7.getType()
            boolean r0 = c(r0)
            if (r0 == 0) goto L5e
            return r1
        L5e:
            if (r8 == 0) goto L63
            java.util.List<com.google.gson.a> r8 = r6.f10076o
            goto L65
        L63:
            java.util.List<com.google.gson.a> r8 = r6.f10077p
        L65:
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L87
            com.google.gson.b r0 = new com.google.gson.b
            r0.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L74:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L87
            java.lang.Object r8 = r7.next()
            com.google.gson.a r8 = (com.google.gson.a) r8
            boolean r8 = r8.shouldSkipField(r0)
            if (r8 == 0) goto L74
            return r1
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Excluder.excludeField(java.lang.reflect.Field, boolean):boolean");
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m22clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }
}
