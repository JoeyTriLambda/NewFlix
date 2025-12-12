package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class f extends w<Number> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.w
    public Number read(z9.a aVar) throws IOException {
        if (aVar.peek() != JsonToken.NULL) {
            return Long.valueOf(aVar.nextLong());
        }
        aVar.nextNull();
        return null;
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Number number) throws IOException {
        if (number == null) {
            bVar.nullValue();
        } else {
            bVar.value(number.toString());
        }
    }
}
