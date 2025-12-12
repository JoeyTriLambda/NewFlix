package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonToken;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;

/* compiled from: NumberTypeAdapter.java */
/* loaded from: classes.dex */
public final class d extends w<Number> {

    /* renamed from: b, reason: collision with root package name */
    public static final x f10197b = new NumberTypeAdapter$1(new d(ToNumberPolicy.f10044m));

    /* renamed from: a, reason: collision with root package name */
    public final v f10198a;

    public d(v vVar) {
        this.f10198a = vVar;
    }

    public static x getFactory(v vVar) {
        return vVar == ToNumberPolicy.f10044m ? f10197b : new NumberTypeAdapter$1(new d(vVar));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.w
    public Number read(z9.a aVar) throws IOException {
        JsonToken jsonTokenPeek = aVar.peek();
        int iOrdinal = jsonTokenPeek.ordinal();
        if (iOrdinal == 5 || iOrdinal == 6) {
            return this.f10198a.readNumber(aVar);
        }
        if (iOrdinal == 8) {
            aVar.nextNull();
            return null;
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenPeek + "; at path " + aVar.getPath());
    }

    @Override // com.google.gson.w
    public void write(z9.b bVar, Number number) throws IOException {
        bVar.value(number);
    }
}
