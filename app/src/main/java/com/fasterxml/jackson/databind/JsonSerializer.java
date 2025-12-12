package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class JsonSerializer<T> implements JsonFormatVisitable {

    public static abstract class None extends JsonSerializer<Object> {
    }

    @Override // com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        jsonFormatVisitorWrapper.expectAnyFormat(javaType);
    }

    public JsonSerializer<?> getDelegatee() {
        return null;
    }

    public Class<T> handledType() {
        return null;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t10) {
        return t10 == null;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public Iterator<PropertyWriter> properties() {
        return ClassUtil.emptyIterator();
    }

    public JsonSerializer<T> replaceDelegatee(JsonSerializer<?> jsonSerializer) {
        throw new UnsupportedOperationException();
    }

    public abstract void serialize(T t10, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    public void serializeWithType(T t10, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Class clsHandledType = handledType();
        if (clsHandledType == null) {
            clsHandledType = t10.getClass();
        }
        serializerProvider.reportBadDefinition((Class<?>) clsHandledType, String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsHandledType.getName(), getClass().getName()));
    }

    public boolean usesObjectId() {
        return false;
    }

    @Deprecated
    public boolean isEmpty(T t10) {
        return isEmpty(null, t10);
    }

    public JsonSerializer<T> unwrappingSerializer(NameTransformer nameTransformer) {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<?> withFilterId(Object obj) {
        return this;
    }
}
