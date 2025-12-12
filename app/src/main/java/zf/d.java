package zf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt;
import mf.x;
import org.apache.commons.lang3.ClassUtils;
import yf.o;
import yf.p;
import yf.q;
import yf.r;
import yf.s;
import yf.t;
import yf.u;
import yf.v;
import yf.w;

/* compiled from: ClassReference.kt */
/* loaded from: classes2.dex */
public final class d implements gg.b<Object>, c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22722b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends lf.b<?>>, Integer> f22723c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f22724d;

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f22725a;

    /* compiled from: ClassReference.kt */
    public static final class a {
        public a(f fVar) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String getClassSimpleName(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                zf.i.checkNotNullParameter(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Laa
            Le:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L6b
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L42
                zf.i.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L40
                goto L42
            L40:
                r1 = r2
                goto Laa
            L42:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L63
                zf.i.checkNotNullExpressionValue(r0, r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r8, r1, r3, r1)
                goto Laa
            L63:
                zf.i.checkNotNullExpressionValue(r0, r5)
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r4, r1, r3, r1)
                goto Laa
            L6b:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L95
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L92
                java.util.Map r0 = zf.d.access$getSimpleNames$cp()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L92
                java.lang.String r8 = r8.concat(r2)
                r1 = r8
            L92:
                if (r1 != 0) goto Laa
                goto L40
            L95:
                java.util.Map r0 = zf.d.access$getSimpleNames$cp()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Laa
                java.lang.String r1 = r8.getSimpleName()
            Laa:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: zf.d.a.getClassSimpleName(java.lang.Class):java.lang.String");
        }

        public final boolean isInstance(Object obj, Class<?> cls) {
            i.checkNotNullParameter(cls, "jClass");
            Map map = d.f22723c;
            i.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return n.isFunctionOfArity(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = xf.a.getJavaObjectType(xf.a.getKotlinClass(cls));
            }
            return cls.isInstance(obj);
        }
    }

    static {
        int i10 = 0;
        List listListOf = mf.k.listOf((Object[]) new Class[]{yf.a.class, yf.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, yf.b.class, yf.c.class, yf.d.class, yf.e.class, yf.f.class, yf.g.class, yf.h.class, yf.i.class, yf.j.class, yf.k.class, yf.m.class, yf.n.class, o.class});
        ArrayList arrayList = new ArrayList(mf.l.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                mf.k.throwIndexOverflow();
            }
            arrayList.add(lf.g.to((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f22723c = kotlin.collections.a.toMap(arrayList);
        HashMap mapX = ac.c.x("boolean", "kotlin.Boolean", "char", "kotlin.Char");
        mapX.put("byte", "kotlin.Byte");
        mapX.put("short", "kotlin.Short");
        mapX.put("int", "kotlin.Int");
        mapX.put("float", "kotlin.Float");
        mapX.put("long", "kotlin.Long");
        mapX.put("double", "kotlin.Double");
        HashMap map = new HashMap();
        map.put("java.lang.Boolean", "kotlin.Boolean");
        map.put("java.lang.Character", "kotlin.Char");
        map.put("java.lang.Byte", "kotlin.Byte");
        map.put("java.lang.Short", "kotlin.Short");
        map.put("java.lang.Integer", "kotlin.Int");
        map.put("java.lang.Float", "kotlin.Float");
        map.put("java.lang.Long", "kotlin.Long");
        map.put("java.lang.Double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Object", "kotlin.Any");
        map2.put("java.lang.String", "kotlin.String");
        map2.put("java.lang.CharSequence", "kotlin.CharSequence");
        map2.put("java.lang.Throwable", "kotlin.Throwable");
        map2.put("java.lang.Cloneable", "kotlin.Cloneable");
        map2.put("java.lang.Number", "kotlin.Number");
        map2.put("java.lang.Comparable", "kotlin.Comparable");
        map2.put("java.lang.Enum", "kotlin.Enum");
        map2.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map2.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map2.put("java.util.Iterator", "kotlin.collections.Iterator");
        map2.put("java.util.Collection", "kotlin.collections.Collection");
        map2.put("java.util.List", "kotlin.collections.List");
        map2.put("java.util.Set", "kotlin.collections.Set");
        map2.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map2.put("java.util.Map", "kotlin.collections.Map");
        map2.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map2.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map2.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map2.putAll(mapX);
        map2.putAll(map);
        Collection<String> collectionValues = mapX.values();
        i.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            i.checkNotNullExpressionValue(str, "kotlinName");
            sb2.append(StringsKt__StringsKt.substringAfterLast$default(str, ClassUtils.PACKAGE_SEPARATOR_CHAR, null, 2, null));
            sb2.append("CompanionObject");
            Pair pair = lf.g.to(sb2.toString(), str + ".Companion");
            map2.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry<Class<? extends lf.b<?>>, Integer> entry : f22723c.entrySet()) {
            map2.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.mapCapacity(map2.size()));
        for (Map.Entry entry2 : map2.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.substringAfterLast$default((String) entry2.getValue(), ClassUtils.PACKAGE_SEPARATOR_CHAR, null, 2, null));
        }
        f22724d = linkedHashMap;
    }

    public d(Class<?> cls) {
        i.checkNotNullParameter(cls, "jClass");
        this.f22725a = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && i.areEqual(xf.a.getJavaObjectType(this), xf.a.getJavaObjectType((gg.b) obj));
    }

    @Override // zf.c
    public Class<?> getJClass() {
        return this.f22725a;
    }

    @Override // gg.b
    public String getSimpleName() {
        return f22722b.getClassSimpleName(getJClass());
    }

    public int hashCode() {
        return xf.a.getJavaObjectType(this).hashCode();
    }

    @Override // gg.b
    public boolean isInstance(Object obj) {
        return f22722b.isInstance(obj, getJClass());
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
