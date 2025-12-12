package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.i;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.o;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import v9.l;
import v9.t;
import v9.u;
import v9.y;

/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements x {

    /* renamed from: b, reason: collision with root package name */
    public final l f10116b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10117m;

    public final class a<K, V> extends w<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final g f10118a;

        /* renamed from: b, reason: collision with root package name */
        public final g f10119b;

        /* renamed from: c, reason: collision with root package name */
        public final u<? extends Map<K, V>> f10120c;

        public a(i iVar, Type type, w<K> wVar, Type type2, w<V> wVar2, u<? extends Map<K, V>> uVar) {
            this.f10118a = new g(iVar, wVar, type);
            this.f10119b = new g(iVar, wVar2, type2);
            this.f10120c = uVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.w
        public Map<K, V> read(z9.a aVar) throws IOException {
            JsonToken jsonTokenPeek = aVar.peek();
            if (jsonTokenPeek == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Map<K, V> mapConstruct = this.f10120c.construct();
            JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
            g gVar = this.f10119b;
            g gVar2 = this.f10118a;
            if (jsonTokenPeek == jsonToken) {
                aVar.beginArray();
                while (aVar.hasNext()) {
                    aVar.beginArray();
                    Object obj = gVar2.read(aVar);
                    if (mapConstruct.put(obj, gVar.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + obj);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
            } else {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    t.f20642a.promoteNameToValue(aVar);
                    Object obj2 = gVar2.read(aVar);
                    if (mapConstruct.put(obj2, gVar.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + obj2);
                    }
                }
                aVar.endObject();
            }
            return mapConstruct;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, Map<K, V> map) throws IOException {
            String asString;
            if (map == null) {
                bVar.nullValue();
                return;
            }
            boolean z10 = MapTypeAdapterFactory.this.f10117m;
            g gVar = this.f10119b;
            if (!z10) {
                bVar.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.name(String.valueOf(entry.getKey()));
                    gVar.write(bVar, entry.getValue());
                }
                bVar.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z11 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                o jsonTree = this.f10118a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z11 |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z11) {
                bVar.beginArray();
                int size = arrayList.size();
                while (i10 < size) {
                    bVar.beginArray();
                    y.write((o) arrayList.get(i10), bVar);
                    gVar.write(bVar, arrayList2.get(i10));
                    bVar.endArray();
                    i10++;
                }
                bVar.endArray();
                return;
            }
            bVar.beginObject();
            int size2 = arrayList.size();
            while (i10 < size2) {
                o oVar = (o) arrayList.get(i10);
                if (oVar.isJsonPrimitive()) {
                    s asJsonPrimitive = oVar.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        asString = String.valueOf(asJsonPrimitive.getAsNumber());
                    } else if (asJsonPrimitive.isBoolean()) {
                        asString = Boolean.toString(asJsonPrimitive.getAsBoolean());
                    } else {
                        if (!asJsonPrimitive.isString()) {
                            throw new AssertionError();
                        }
                        asString = asJsonPrimitive.getAsString();
                    }
                } else {
                    if (!oVar.isJsonNull()) {
                        throw new AssertionError();
                    }
                    asString = "null";
                }
                bVar.name(asString);
                gVar.write(bVar, arrayList2.get(i10));
                i10++;
            }
            bVar.endObject();
        }
    }

    public MapTypeAdapterFactory(l lVar, boolean z10) {
        this.f10116b = lVar;
        this.f10117m = z10;
    }

    @Override // com.google.gson.x
    public <T> w<T> create(i iVar, y9.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, rawType);
        Type type2 = mapKeyAndValueTypes[0];
        return new a(iVar, mapKeyAndValueTypes[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f10148c : iVar.getAdapter(y9.a.get(type2)), mapKeyAndValueTypes[1], iVar.getAdapter(y9.a.get(mapKeyAndValueTypes[1])), this.f10116b.get(aVar));
    }
}
