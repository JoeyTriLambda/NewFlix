package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends w<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final x f10107c = new x() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.x
        public <T> w<T> create(i iVar, y9.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(iVar, iVar.getAdapter(y9.a.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Class<E> f10108a;

    /* renamed from: b, reason: collision with root package name */
    public final g f10109b;

    public ArrayTypeAdapter(i iVar, w<E> wVar, Class<E> cls) {
        this.f10109b = new g(iVar, wVar, cls);
        this.f10108a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.w
    public Object read(z9.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.peek() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.beginArray();
        while (aVar.hasNext()) {
            arrayList.add(this.f10109b.read(aVar));
        }
        aVar.endArray();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f10108a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            bVar.nullValue();
            return;
        }
        bVar.beginArray();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f10109b.write(bVar, Array.get(obj, i10));
        }
        bVar.endArray();
    }
}
