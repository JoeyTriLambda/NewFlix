package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: o, reason: collision with root package name */
    public static final y9.a<?> f10049o = y9.a.get(Object.class);

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Map<y9.a<?>, a<?>>> f10050a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10051b;

    /* renamed from: c, reason: collision with root package name */
    public final v9.l f10052c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f10053d;

    /* renamed from: e, reason: collision with root package name */
    public final List<x> f10054e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Type, k<?>> f10055f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10056g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10057h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10058i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f10059j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10060k;

    /* renamed from: l, reason: collision with root package name */
    public final List<x> f10061l;

    /* renamed from: m, reason: collision with root package name */
    public final List<x> f10062m;

    /* renamed from: n, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f10063n;

    /* compiled from: Gson.java */
    public static class a<T> extends w<T> {

        /* renamed from: a, reason: collision with root package name */
        public w<T> f10064a;

        @Override // com.google.gson.w
        public T read(z9.a aVar) throws IOException {
            w<T> wVar = this.f10064a;
            if (wVar != null) {
                return wVar.read(aVar);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(w<T> wVar) {
            if (this.f10064a != null) {
                throw new AssertionError();
            }
            this.f10064a = wVar;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, T t10) throws IOException {
            w<T> wVar = this.f10064a;
            if (wVar == null) {
                throw new IllegalStateException();
            }
            wVar.write(bVar, t10);
        }
    }

    public i() {
        this(Excluder.f10072q, FieldNamingPolicy.f10034b, Collections.emptyMap(), true, false, true, LongSerializationPolicy.f10036b, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), ToNumberPolicy.f10043b, ToNumberPolicy.f10044m, Collections.emptyList());
    }

    public static void a(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) v9.w.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> w<T> getAdapter(y9.a<T> aVar) {
        boolean z10;
        ConcurrentHashMap concurrentHashMap = this.f10051b;
        w<T> wVar = (w) concurrentHashMap.get(aVar == null ? f10049o : aVar);
        if (wVar != null) {
            return wVar;
        }
        ThreadLocal<Map<y9.a<?>, a<?>>> threadLocal = this.f10050a;
        Map<y9.a<?>, a<?>> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
            z10 = true;
        } else {
            z10 = false;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<x> it = this.f10054e.iterator();
            while (it.hasNext()) {
                w<T> wVarCreate = it.next().create(this, aVar);
                if (wVarCreate != null) {
                    aVar3.setDelegate(wVarCreate);
                    concurrentHashMap.put(aVar, wVarCreate);
                    return wVarCreate;
                }
            }
            throw new IllegalArgumentException("GSON (2.9.1) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z10) {
                threadLocal.remove();
            }
        }
    }

    public <T> w<T> getDelegateAdapter(x xVar, y9.a<T> aVar) {
        List<x> list = this.f10054e;
        if (!list.contains(xVar)) {
            xVar = this.f10053d;
        }
        boolean z10 = false;
        for (x xVar2 : list) {
            if (z10) {
                w<T> wVarCreate = xVar2.create(this, aVar);
                if (wVarCreate != null) {
                    return wVarCreate;
                }
            } else if (xVar2 == xVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public z9.a newJsonReader(Reader reader) {
        z9.a aVar = new z9.a(reader);
        aVar.setLenient(this.f10060k);
        return aVar;
    }

    public z9.b newJsonWriter(Writer writer) throws IOException {
        if (this.f10057h) {
            writer.write(")]}'\n");
        }
        z9.b bVar = new z9.b(writer);
        if (this.f10059j) {
            bVar.setIndent("  ");
        }
        bVar.setHtmlSafe(this.f10058i);
        bVar.setLenient(this.f10060k);
        bVar.setSerializeNulls(this.f10056g);
        return bVar;
    }

    public void toJson(Object obj, Type type, z9.b bVar) throws JsonIOException {
        w adapter = getAdapter(y9.a.get(type));
        boolean zIsLenient = bVar.isLenient();
        bVar.setLenient(true);
        boolean zIsHtmlSafe = bVar.isHtmlSafe();
        bVar.setHtmlSafe(this.f10058i);
        boolean serializeNulls = bVar.getSerializeNulls();
        bVar.setSerializeNulls(this.f10056g);
        try {
            try {
                try {
                    adapter.write(bVar, obj);
                } catch (IOException e10) {
                    throw new JsonIOException(e10);
                }
            } catch (AssertionError e11) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.1): " + e11.getMessage());
                assertionError.initCause(e11);
                throw assertionError;
            }
        } finally {
            bVar.setLenient(zIsLenient);
            bVar.setHtmlSafe(zIsHtmlSafe);
            bVar.setSerializeNulls(serializeNulls);
        }
    }

    public o toJsonTree(Object obj) {
        return obj == null ? p.f10239b : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.f10056g + ",factories:" + this.f10054e + ",instanceCreators:" + this.f10052c + "}";
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public o toJsonTree(Object obj, Type type) throws JsonIOException {
        com.google.gson.internal.bind.c cVar = new com.google.gson.internal.bind.c();
        toJson(obj, type, cVar);
        return cVar.get();
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        z9.a aVarNewJsonReader = newJsonReader(reader);
        T t10 = (T) fromJson(aVarNewJsonReader, type);
        if (t10 != null) {
            try {
                if (aVarNewJsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        }
        return t10;
    }

    public i(Excluder excluder, c cVar, Map map, boolean z10, boolean z11, boolean z12, LongSerializationPolicy longSerializationPolicy, List list, List list2, List list3, v vVar, v vVar2, List list4) {
        w fVar;
        this.f10050a = new ThreadLocal<>();
        this.f10051b = new ConcurrentHashMap();
        this.f10055f = map;
        v9.l lVar = new v9.l(map, z12, list4);
        this.f10052c = lVar;
        this.f10056g = false;
        this.f10057h = false;
        this.f10058i = z10;
        this.f10059j = false;
        this.f10060k = z11;
        this.f10061l = list;
        this.f10062m = list2;
        this.f10063n = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.A);
        arrayList.add(com.google.gson.internal.bind.e.getFactory(vVar));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f10161p);
        arrayList.add(TypeAdapters.f10152g);
        arrayList.add(TypeAdapters.f10149d);
        arrayList.add(TypeAdapters.f10150e);
        arrayList.add(TypeAdapters.f10151f);
        if (longSerializationPolicy == LongSerializationPolicy.f10036b) {
            fVar = TypeAdapters.f10156k;
        } else {
            fVar = new f();
        }
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, fVar));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, new d()));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, new e()));
        arrayList.add(com.google.gson.internal.bind.d.getFactory(vVar2));
        arrayList.add(TypeAdapters.f10153h);
        arrayList.add(TypeAdapters.f10154i);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, new g(fVar).nullSafe()));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, new h(fVar).nullSafe()));
        arrayList.add(TypeAdapters.f10155j);
        arrayList.add(TypeAdapters.f10157l);
        arrayList.add(TypeAdapters.f10162q);
        arrayList.add(TypeAdapters.f10163r);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.f10158m));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.f10159n));
        arrayList.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.f10160o));
        arrayList.add(TypeAdapters.f10164s);
        arrayList.add(TypeAdapters.f10165t);
        arrayList.add(TypeAdapters.f10167v);
        arrayList.add(TypeAdapters.f10168w);
        arrayList.add(TypeAdapters.f10170y);
        arrayList.add(TypeAdapters.f10166u);
        arrayList.add(TypeAdapters.f10147b);
        arrayList.add(DateTypeAdapter.f10113b);
        arrayList.add(TypeAdapters.f10169x);
        if (com.google.gson.internal.sql.a.f10218a) {
            arrayList.add(com.google.gson.internal.sql.a.f10222e);
            arrayList.add(com.google.gson.internal.sql.a.f10221d);
            arrayList.add(com.google.gson.internal.sql.a.f10223f);
        }
        arrayList.add(ArrayTypeAdapter.f10107c);
        arrayList.add(TypeAdapters.f10146a);
        arrayList.add(new CollectionTypeAdapterFactory(lVar));
        arrayList.add(new MapTypeAdapterFactory(lVar, false));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(lVar);
        this.f10053d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.B);
        arrayList.add(new ReflectiveTypeAdapterFactory(lVar, cVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f10054e = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(z9.a aVar, Type type) throws JsonSyntaxException, JsonIOException {
        boolean zIsLenient = aVar.isLenient();
        boolean z10 = true;
        aVar.setLenient(true);
        try {
            try {
                try {
                    aVar.peek();
                    z10 = false;
                    return getAdapter(y9.a.get(type)).read(aVar);
                } catch (EOFException e10) {
                    if (z10) {
                        aVar.setLenient(zIsLenient);
                        return null;
                    }
                    throw new JsonSyntaxException(e10);
                } catch (AssertionError e11) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.1): " + e11.getMessage());
                    assertionError.initCause(e11);
                    throw assertionError;
                }
            } catch (IOException e12) {
                throw new JsonSyntaxException(e12);
            } catch (IllegalStateException e13) {
                throw new JsonSyntaxException(e13);
            }
        } finally {
            aVar.setLenient(zIsLenient);
        }
    }

    public <T> w<T> getAdapter(Class<T> cls) {
        return getAdapter(y9.a.get((Class) cls));
    }
}
