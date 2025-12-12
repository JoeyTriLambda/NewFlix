package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class MethodProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _annotated;
    protected final transient Method _setter;
    protected final boolean _skipNulls;

    public MethodProperty(BeanPropertyDefinition beanPropertyDefinition, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
        super(beanPropertyDefinition, javaType, typeDeserializer, annotations);
        this._annotated = annotatedMethod;
        this._setter = annotatedMethod.getAnnotated();
        this._skipNulls = NullsConstantProvider.isSkipper(this._nullProvider);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Object objDeserializeWithType;
        if (!jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (typeDeserializer == null) {
                Object objDeserialize = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
                if (objDeserialize != null) {
                    objDeserializeWithType = objDeserialize;
                } else if (this._skipNulls) {
                    return;
                } else {
                    objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                }
            } else {
                objDeserializeWithType = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
        } else if (this._skipNulls) {
            return;
        } else {
            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
        }
        try {
            this._setter.invoke(obj, objDeserializeWithType);
        } catch (Exception e10) {
            _throwAsIOE(jsonParser, e10, objDeserializeWithType);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Object objDeserializeWithType;
        if (!jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (typeDeserializer == null) {
                Object objDeserialize = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
                if (objDeserialize != null) {
                    objDeserializeWithType = objDeserialize;
                } else {
                    if (this._skipNulls) {
                        return obj;
                    }
                    objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                }
            } else {
                objDeserializeWithType = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
        } else {
            if (this._skipNulls) {
                return obj;
            }
            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
        }
        try {
            Object objInvoke = this._setter.invoke(obj, objDeserializeWithType);
            return objInvoke == null ? obj : objInvoke;
        } catch (Exception e10) {
            _throwAsIOE(jsonParser, e10, objDeserializeWithType);
            return null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public void fixAccess(DeserializationConfig deserializationConfig) throws SecurityException {
        this._annotated.fixAccess(deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        AnnotatedMethod annotatedMethod = this._annotated;
        if (annotatedMethod == null) {
            return null;
        }
        return (A) annotatedMethod.getAnnotation(cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public AnnotatedMember getMember() {
        return this._annotated;
    }

    public Object readResolve() {
        return new MethodProperty(this, this._annotated.getAnnotated());
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void set(Object obj, Object obj2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            this._setter.invoke(obj, obj2);
        } catch (Exception e10) {
            _throwAsIOE(e10, obj2);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public Object setAndReturn(Object obj, Object obj2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = this._setter.invoke(obj, obj2);
            return objInvoke == null ? obj : objInvoke;
        } catch (Exception e10) {
            _throwAsIOE(e10, obj2);
            return null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withName(PropertyName propertyName) {
        return new MethodProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withNullProvider(NullValueProvider nullValueProvider) {
        return new MethodProperty(this, this._valueDeserializer, nullValueProvider);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> jsonDeserializer) {
        JsonDeserializer<?> jsonDeserializer2 = this._valueDeserializer;
        if (jsonDeserializer2 == jsonDeserializer) {
            return this;
        }
        NullValueProvider nullValueProvider = this._nullProvider;
        if (jsonDeserializer2 == nullValueProvider) {
            nullValueProvider = jsonDeserializer;
        }
        return new MethodProperty(this, jsonDeserializer, nullValueProvider);
    }

    public MethodProperty(MethodProperty methodProperty, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider) {
        super(methodProperty, jsonDeserializer, nullValueProvider);
        this._annotated = methodProperty._annotated;
        this._setter = methodProperty._setter;
        this._skipNulls = NullsConstantProvider.isSkipper(nullValueProvider);
    }

    public MethodProperty(MethodProperty methodProperty, PropertyName propertyName) {
        super(methodProperty, propertyName);
        this._annotated = methodProperty._annotated;
        this._setter = methodProperty._setter;
        this._skipNulls = methodProperty._skipNulls;
    }

    public MethodProperty(MethodProperty methodProperty, Method method) {
        super(methodProperty);
        this._annotated = methodProperty._annotated;
        this._setter = method;
        this._skipNulls = methodProperty._skipNulls;
    }
}
