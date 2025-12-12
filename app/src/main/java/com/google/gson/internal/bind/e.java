package com.google.gson.internal.bind;

import com.google.gson.ToNumberPolicy;
import com.google.gson.i;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class e extends w<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final x f10199c = new ObjectTypeAdapter$1(ToNumberPolicy.f10043b);

    /* renamed from: a, reason: collision with root package name */
    public final i f10200a;

    /* renamed from: b, reason: collision with root package name */
    public final v f10201b;

    public e(i iVar, v vVar) {
        this.f10200a = iVar;
        this.f10201b = vVar;
    }

    public static Serializable b(z9.a aVar, JsonToken jsonToken) throws IOException {
        int iOrdinal = jsonToken.ordinal();
        if (iOrdinal == 0) {
            aVar.beginArray();
            return new ArrayList();
        }
        if (iOrdinal != 2) {
            return null;
        }
        aVar.beginObject();
        return new LinkedTreeMap();
    }

    public static x getFactory(v vVar) {
        return vVar == ToNumberPolicy.f10043b ? f10199c : new ObjectTypeAdapter$1(vVar);
    }

    public final Serializable a(z9.a aVar, JsonToken jsonToken) throws IOException {
        int iOrdinal = jsonToken.ordinal();
        if (iOrdinal == 5) {
            return aVar.nextString();
        }
        if (iOrdinal == 6) {
            return this.f10201b.readNumber(aVar);
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(aVar.nextBoolean());
        }
        if (iOrdinal == 8) {
            aVar.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    @Override // com.google.gson.w
    public Object read(z9.a aVar) throws IOException {
        JsonToken jsonTokenPeek = aVar.peek();
        Object objB = b(aVar, jsonTokenPeek);
        if (objB == null) {
            return a(aVar, jsonTokenPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.hasNext()) {
                String strNextName = objB instanceof Map ? aVar.nextName() : null;
                JsonToken jsonTokenPeek2 = aVar.peek();
                Serializable serializableB = b(aVar, jsonTokenPeek2);
                boolean z10 = serializableB != null;
                Serializable serializableA = serializableB == null ? a(aVar, jsonTokenPeek2) : serializableB;
                if (objB instanceof List) {
                    ((List) objB).add(serializableA);
                } else {
                    ((Map) objB).put(strNextName, serializableA);
                }
                if (z10) {
                    arrayDeque.addLast(objB);
                    objB = serializableA;
                }
            } else {
                if (objB instanceof List) {
                    aVar.endArray();
                } else {
                    aVar.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return objB;
                }
                objB = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.nullValue();
            return;
        }
        w adapter = this.f10200a.getAdapter(obj.getClass());
        if (!(adapter instanceof e)) {
            adapter.write(bVar, obj);
        } else {
            bVar.beginObject();
            bVar.endObject();
        }
    }
}
