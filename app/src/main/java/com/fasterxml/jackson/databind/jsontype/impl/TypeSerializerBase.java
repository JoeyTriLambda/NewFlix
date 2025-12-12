package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class TypeSerializerBase extends TypeSerializer {
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    public TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this._idResolver = typeIdResolver;
        this._property = beanProperty;
    }

    public void _generateTypeId(WritableTypeId writableTypeId) {
        if (writableTypeId.f5600id == null) {
            Object obj = writableTypeId.forValue;
            Class<?> cls = writableTypeId.forValueType;
            writableTypeId.f5600id = cls == null ? idFromValue(obj) : idFromValueAndType(obj, cls);
        }
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public String getPropertyName() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public TypeIdResolver getTypeIdResolver() {
        return this._idResolver;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public abstract JsonTypeInfo.As getTypeInclusion();

    public String idFromValue(Object obj) {
        String strIdFromValue = this._idResolver.idFromValue(obj);
        if (strIdFromValue == null) {
            handleMissingId(obj);
        }
        return strIdFromValue;
    }

    public String idFromValueAndType(Object obj, Class<?> cls) {
        String strIdFromValueAndType = this._idResolver.idFromValueAndType(obj, cls);
        if (strIdFromValueAndType == null) {
            handleMissingId(obj);
        }
        return strIdFromValueAndType;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public WritableTypeId writeTypePrefix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        _generateTypeId(writableTypeId);
        return jsonGenerator.writeTypePrefix(writableTypeId);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public WritableTypeId writeTypeSuffix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
        return jsonGenerator.writeTypeSuffix(writableTypeId);
    }

    public void handleMissingId(Object obj) {
    }
}
