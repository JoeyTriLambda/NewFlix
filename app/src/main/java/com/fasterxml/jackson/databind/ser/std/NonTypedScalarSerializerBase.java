package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@Deprecated
/* loaded from: classes.dex */
public abstract class NonTypedScalarSerializerBase<T> extends StdScalarSerializer<T> {
    public NonTypedScalarSerializerBase(Class<T> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public final void serializeWithType(T t10, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        serialize(t10, jsonGenerator, serializerProvider);
    }

    public NonTypedScalarSerializerBase(Class<?> cls, boolean z10) {
        super(cls, z10);
    }
}
