package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class w<T> {

    /* compiled from: TypeAdapter.java */
    public class a extends w<T> {
        public a() {
        }

        @Override // com.google.gson.w
        public T read(z9.a aVar) throws IOException {
            if (aVar.peek() != JsonToken.NULL) {
                return (T) w.this.read(aVar);
            }
            aVar.nextNull();
            return null;
        }

        @Override // com.google.gson.w
        public void write(z9.b bVar, T t10) throws IOException {
            if (t10 == null) {
                bVar.nullValue();
            } else {
                w.this.write(bVar, t10);
            }
        }
    }

    public final w<T> nullSafe() {
        return new a();
    }

    public abstract T read(z9.a aVar) throws IOException;

    public final o toJsonTree(T t10) {
        try {
            com.google.gson.internal.bind.c cVar = new com.google.gson.internal.bind.c();
            write(cVar, t10);
            return cVar.get();
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public abstract void write(z9.b bVar, T t10) throws IOException;
}
