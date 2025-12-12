package com.fasterxml.jackson.databind.deser;

import ac.c;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    protected final DeserializerFactoryConfig _factoryConfig;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_SEQUENCE = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Map.Entry.class;
    private static final Class<?> CLASS_SERIALIZABLE = Serializable.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");

    /* renamed from: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode;

        static {
            int[] iArr = new int[JsonCreator.Mode.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode = iArr;
            try {
                iArr[JsonCreator.Mode.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[JsonCreator.Mode.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[JsonCreator.Mode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class ContainerDefaultMappings {
        static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
        static final HashMap<String, Class<? extends Map>> _mapFallbacks;

        static {
            HashMap<String, Class<? extends Collection>> map = new HashMap<>();
            map.put(Collection.class.getName(), ArrayList.class);
            map.put(List.class.getName(), ArrayList.class);
            map.put(Set.class.getName(), HashSet.class);
            map.put(SortedSet.class.getName(), TreeSet.class);
            map.put(Queue.class.getName(), LinkedList.class);
            map.put(AbstractList.class.getName(), ArrayList.class);
            map.put(AbstractSet.class.getName(), HashSet.class);
            map.put(Deque.class.getName(), LinkedList.class);
            map.put(NavigableSet.class.getName(), TreeSet.class);
            _collectionFallbacks = map;
            HashMap<String, Class<? extends Map>> map2 = new HashMap<>();
            map2.put(Map.class.getName(), LinkedHashMap.class);
            map2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            map2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            map2.put(SortedMap.class.getName(), TreeMap.class);
            map2.put(NavigableMap.class.getName(), TreeMap.class);
            map2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            _mapFallbacks = map2;
        }

        public static Class<?> findCollectionFallback(JavaType javaType) {
            return _collectionFallbacks.get(javaType.getRawClass().getName());
        }

        public static Class<?> findMapFallback(JavaType javaType) {
            return _mapFallbacks.get(javaType.getRawClass().getName());
        }
    }

    public BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    private boolean _checkIfCreatorPropertyBased(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, BeanPropertyDefinition beanPropertyDefinition) {
        String name;
        if ((beanPropertyDefinition == null || !beanPropertyDefinition.isExplicitlyNamed()) && annotationIntrospector.findInjectableValue(annotatedWithParams.getParameter(0)) == null) {
            return (beanPropertyDefinition == null || (name = beanPropertyDefinition.getName()) == null || name.isEmpty() || !beanPropertyDefinition.couldSerialize()) ? false : true;
        }
        return true;
    }

    private void _checkImplicitlyNamedConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, List<AnnotatedWithParams> list) throws JsonMappingException {
        int i10;
        Iterator<AnnotatedWithParams> it = list.iterator();
        AnnotatedWithParams annotatedWithParams = null;
        AnnotatedWithParams annotatedWithParams2 = null;
        SettableBeanProperty[] settableBeanPropertyArr = null;
        while (true) {
            if (!it.hasNext()) {
                annotatedWithParams = annotatedWithParams2;
                break;
            }
            AnnotatedWithParams next = it.next();
            if (visibilityChecker.isCreatorVisible(next)) {
                int parameterCount = next.getParameterCount();
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                int i11 = 0;
                while (true) {
                    if (i11 < parameterCount) {
                        AnnotatedParameter parameter = next.getParameter(i11);
                        PropertyName propertyName_findParamName = _findParamName(parameter, annotationIntrospector);
                        if (propertyName_findParamName == null || propertyName_findParamName.isEmpty()) {
                            break;
                        }
                        settableBeanPropertyArr2[i11] = constructCreatorProperty(deserializationContext, beanDescription, propertyName_findParamName, parameter.getIndex(), parameter, null);
                        i11++;
                    } else {
                        if (annotatedWithParams2 != null) {
                            break;
                        }
                        annotatedWithParams2 = next;
                        settableBeanPropertyArr = settableBeanPropertyArr2;
                    }
                }
            }
        }
        if (annotatedWithParams != null) {
            creatorCollector.addPropertyCreator(annotatedWithParams, false, settableBeanPropertyArr);
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescription;
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                PropertyName fullName = settableBeanProperty.getFullName();
                if (!basicBeanDescription.hasProperty(fullName)) {
                    basicBeanDescription.addProperty(SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), settableBeanProperty.getMember(), fullName));
                }
            }
        }
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws SecurityException, JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        BeanDescription beanDescriptionIntrospect = config.introspect(javaType);
        KeyDeserializer keyDeserializerFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospect.getClassInfo());
        if (keyDeserializerFindKeyDeserializerFromAnnotation != null) {
            return keyDeserializerFindKeyDeserializerFromAnnotation;
        }
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescriptionIntrospect);
        if (jsonDeserializer_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializer_findCustomEnumDeserializer);
        }
        JsonDeserializer<Object> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospect.getClassInfo());
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializerFindDeserializerFromAnnotation);
        }
        EnumResolver enumResolverConstructEnumResolver = constructEnumResolver(rawClass, config, beanDescriptionIntrospect.findJsonValueAccessor());
        for (AnnotatedMethod annotatedMethod : beanDescriptionIntrospect.getFactoryMethods()) {
            if (_hasCreatorAnnotation(deserializationContext, annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    StringBuilder sb2 = new StringBuilder("Unsuitable method (");
                    sb2.append(annotatedMethod);
                    sb2.append(") decorated with @JsonCreator (for Enum type ");
                    throw new IllegalArgumentException(c.d(rawClass, sb2, ")"));
                }
                if (annotatedMethod.getRawParameterType(0) == String.class) {
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(annotatedMethod.getMember(), deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver, annotatedMethod);
                }
                throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String");
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver);
    }

    private PropertyName _findParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (annotatedParameter == null || annotationIntrospector == null) {
            return null;
        }
        PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
        if (propertyNameFindNameForDeserialization != null) {
            return propertyNameFindNameForDeserialization;
        }
        String strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (strFindImplicitPropertyName == null || strFindImplicitPropertyName.isEmpty()) {
            return null;
        }
        return PropertyName.construct(strFindImplicitPropertyName);
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (!this._factoryConfig.hasAbstractTypeResolvers()) {
            return null;
        }
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeFindTypeMapping = it.next().findTypeMapping(deserializationConfig, javaType);
            if (javaTypeFindTypeMapping != null && !javaTypeFindTypeMapping.hasRawClass(rawClass)) {
                return javaTypeFindTypeMapping;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void _addDeserializerConstructors(com.fasterxml.jackson.databind.DeserializationContext r27, com.fasterxml.jackson.databind.BeanDescription r28, com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> r29, com.fasterxml.jackson.databind.AnnotationIntrospector r30, com.fasterxml.jackson.databind.deser.impl.CreatorCollector r31, java.util.Map<com.fasterxml.jackson.databind.introspect.AnnotatedWithParams, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition[]> r32) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory._addDeserializerConstructors(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription, com.fasterxml.jackson.databind.introspect.VisibilityChecker, com.fasterxml.jackson.databind.AnnotationIntrospector, com.fasterxml.jackson.databind.deser.impl.CreatorCollector, java.util.Map):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v1, types: [com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition] */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    public void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) throws JsonMappingException {
        AnnotatedParameter annotatedParameter;
        int i10;
        int i11;
        SettableBeanProperty[] settableBeanPropertyArr;
        AnnotatedWithParams annotatedWithParams;
        int i12;
        AnnotatedParameter annotatedParameter2;
        VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> map2 = map;
        LinkedList<CreatorCandidate> linkedList = new LinkedList();
        Iterator<AnnotatedMethod> it = beanDescription.getFactoryMethods().iterator();
        int i13 = 0;
        while (true) {
            annotatedParameter = null;
            i10 = 1;
            if (!it.hasNext()) {
                break;
            }
            AnnotatedMethod next = it.next();
            JsonCreator.Mode modeFindCreatorAnnotation = annotationIntrospector.findCreatorAnnotation(deserializationContext.getConfig(), next);
            int parameterCount = next.getParameterCount();
            if (modeFindCreatorAnnotation == null) {
                if (parameterCount == 1 && visibilityChecker2.isCreatorVisible(next)) {
                    linkedList.add(CreatorCandidate.construct(annotationIntrospector, next, null));
                }
            } else if (modeFindCreatorAnnotation != JsonCreator.Mode.DISABLED) {
                if (parameterCount == 0) {
                    creatorCollector.setDefaultCreator(next);
                } else {
                    int i14 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonCreator$Mode[modeFindCreatorAnnotation.ordinal()];
                    if (i14 == 1) {
                        _addExplicitDelegatingCreator(deserializationContext, beanDescription, creatorCollector, CreatorCandidate.construct(annotationIntrospector, next, null));
                    } else if (i14 != 2) {
                        _addExplicitAnyCreator(deserializationContext, beanDescription, creatorCollector, CreatorCandidate.construct(annotationIntrospector, next, map2.get(next)));
                    } else {
                        _addExplicitPropertyCreator(deserializationContext, beanDescription, creatorCollector, CreatorCandidate.construct(annotationIntrospector, next, map2.get(next)));
                    }
                    i13++;
                }
            }
        }
        if (i13 > 0) {
            return;
        }
        for (CreatorCandidate creatorCandidate : linkedList) {
            int iParamCount = creatorCandidate.paramCount();
            AnnotatedWithParams annotatedWithParamsCreator = creatorCandidate.creator();
            BeanPropertyDefinition[] beanPropertyDefinitionArr = map2.get(annotatedWithParamsCreator);
            if (iParamCount == i10) {
                BeanPropertyDefinition beanPropertyDefinitionPropertyDef = creatorCandidate.propertyDef(0);
                if (_checkIfCreatorPropertyBased(annotationIntrospector, annotatedWithParamsCreator, beanPropertyDefinitionPropertyDef)) {
                    SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[iParamCount];
                    AnnotatedParameter annotatedParameter3 = annotatedParameter;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    while (i15 < iParamCount) {
                        AnnotatedParameter parameter = annotatedWithParamsCreator.getParameter(i15);
                        ?? r20 = beanPropertyDefinitionArr == null ? annotatedParameter : beanPropertyDefinitionArr[i15];
                        JacksonInject.Value valueFindInjectableValue = annotationIntrospector.findInjectableValue(parameter);
                        PropertyName fullName = r20 == 0 ? annotatedParameter : r20.getFullName();
                        if (r20 == 0 || !r20.isExplicitlyNamed()) {
                            i11 = i15;
                            settableBeanPropertyArr = settableBeanPropertyArr2;
                            annotatedWithParams = annotatedWithParamsCreator;
                            i12 = iParamCount;
                            annotatedParameter2 = annotatedParameter;
                            if (valueFindInjectableValue != null) {
                                i17++;
                                settableBeanPropertyArr[i11] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i11, parameter, valueFindInjectableValue);
                            } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                                _reportUnwrappedCreatorProperty(deserializationContext, beanDescription, parameter);
                            } else if (annotatedParameter3 == null) {
                                annotatedParameter3 = parameter;
                            }
                        } else {
                            i16++;
                            i11 = i15;
                            settableBeanPropertyArr = settableBeanPropertyArr2;
                            annotatedWithParams = annotatedWithParamsCreator;
                            i12 = iParamCount;
                            annotatedParameter2 = annotatedParameter;
                            settableBeanPropertyArr[i11] = constructCreatorProperty(deserializationContext, beanDescription, fullName, i11, parameter, valueFindInjectableValue);
                        }
                        i15 = i11 + 1;
                        annotatedWithParamsCreator = annotatedWithParams;
                        iParamCount = i12;
                        settableBeanPropertyArr2 = settableBeanPropertyArr;
                        annotatedParameter = annotatedParameter2;
                    }
                    SettableBeanProperty[] settableBeanPropertyArr3 = settableBeanPropertyArr2;
                    AnnotatedWithParams annotatedWithParams2 = annotatedWithParamsCreator;
                    int i18 = iParamCount;
                    AnnotatedParameter annotatedParameter4 = annotatedParameter;
                    int i19 = i16 + 0;
                    if (i16 > 0 || i17 > 0) {
                        if (i19 + i17 == i18) {
                            creatorCollector.addPropertyCreator(annotatedWithParams2, false, settableBeanPropertyArr3);
                        } else if (i16 == 0 && i17 + 1 == i18) {
                            creatorCollector.addDelegatingCreator(annotatedWithParams2, false, settableBeanPropertyArr3, 0);
                        } else {
                            deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(annotatedParameter3.getIndex()), annotatedWithParams2);
                            visibilityChecker2 = visibilityChecker;
                            map2 = map;
                            annotatedParameter = annotatedParameter4;
                            i10 = 1;
                        }
                    }
                    visibilityChecker2 = visibilityChecker;
                    map2 = map;
                    annotatedParameter = annotatedParameter4;
                    i10 = 1;
                } else {
                    _handleSingleArgumentCreator(creatorCollector, annotatedWithParamsCreator, false, visibilityChecker2.isCreatorVisible(annotatedWithParamsCreator));
                    if (beanPropertyDefinitionPropertyDef != null) {
                        ((POJOPropertyBuilder) beanPropertyDefinitionPropertyDef).removeConstructors();
                    }
                }
            }
        }
    }

    public void _addExplicitAnyCreator(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, CreatorCandidate creatorCandidate) throws JsonMappingException {
        if (1 != creatorCandidate.paramCount()) {
            int iFindOnlyParamWithoutInjection = creatorCandidate.findOnlyParamWithoutInjection();
            if (iFindOnlyParamWithoutInjection < 0 || creatorCandidate.paramName(iFindOnlyParamWithoutInjection) != null) {
                _addExplicitPropertyCreator(deserializationContext, beanDescription, creatorCollector, creatorCandidate);
                return;
            } else {
                _addExplicitDelegatingCreator(deserializationContext, beanDescription, creatorCollector, creatorCandidate);
                return;
            }
        }
        AnnotatedParameter annotatedParameterParameter = creatorCandidate.parameter(0);
        JacksonInject.Value valueInjection = creatorCandidate.injection(0);
        PropertyName propertyNameExplicitParamName = creatorCandidate.explicitParamName(0);
        BeanPropertyDefinition beanPropertyDefinitionPropertyDef = creatorCandidate.propertyDef(0);
        boolean z10 = (propertyNameExplicitParamName == null && valueInjection == null) ? false : true;
        if (!z10 && beanPropertyDefinitionPropertyDef != null) {
            propertyNameExplicitParamName = creatorCandidate.paramName(0);
            z10 = propertyNameExplicitParamName != null && beanPropertyDefinitionPropertyDef.couldSerialize();
        }
        PropertyName propertyName = propertyNameExplicitParamName;
        if (z10) {
            creatorCollector.addPropertyCreator(creatorCandidate.creator(), true, new SettableBeanProperty[]{constructCreatorProperty(deserializationContext, beanDescription, propertyName, 0, annotatedParameterParameter, valueInjection)});
            return;
        }
        _handleSingleArgumentCreator(creatorCollector, creatorCandidate.creator(), true, true);
        if (beanPropertyDefinitionPropertyDef != null) {
            ((POJOPropertyBuilder) beanPropertyDefinitionPropertyDef).removeConstructors();
        }
    }

    public void _addExplicitDelegatingCreator(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, CreatorCandidate creatorCandidate) throws JsonMappingException {
        int iParamCount = creatorCandidate.paramCount();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
        int i10 = -1;
        for (int i11 = 0; i11 < iParamCount; i11++) {
            AnnotatedParameter annotatedParameterParameter = creatorCandidate.parameter(i11);
            JacksonInject.Value valueInjection = creatorCandidate.injection(i11);
            if (valueInjection != null) {
                settableBeanPropertyArr[i11] = constructCreatorProperty(deserializationContext, beanDescription, null, i11, annotatedParameterParameter, valueInjection);
            } else if (i10 < 0) {
                i10 = i11;
            } else {
                deserializationContext.reportBadTypeDefinition(beanDescription, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i10), Integer.valueOf(i11), creatorCandidate);
            }
        }
        if (i10 < 0) {
            deserializationContext.reportBadTypeDefinition(beanDescription, "No argument left as delegating for Creator %s: exactly one required", creatorCandidate);
        }
        if (iParamCount != 1) {
            creatorCollector.addDelegatingCreator(creatorCandidate.creator(), true, settableBeanPropertyArr, i10);
            return;
        }
        _handleSingleArgumentCreator(creatorCollector, creatorCandidate.creator(), true, true);
        BeanPropertyDefinition beanPropertyDefinitionPropertyDef = creatorCandidate.propertyDef(0);
        if (beanPropertyDefinitionPropertyDef != null) {
            ((POJOPropertyBuilder) beanPropertyDefinitionPropertyDef).removeConstructors();
        }
    }

    public void _addExplicitPropertyCreator(DeserializationContext deserializationContext, BeanDescription beanDescription, CreatorCollector creatorCollector, CreatorCandidate creatorCandidate) throws JsonMappingException {
        int iParamCount = creatorCandidate.paramCount();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iParamCount];
        for (int i10 = 0; i10 < iParamCount; i10++) {
            JacksonInject.Value valueInjection = creatorCandidate.injection(i10);
            AnnotatedParameter annotatedParameterParameter = creatorCandidate.parameter(i10);
            PropertyName propertyNameParamName = creatorCandidate.paramName(i10);
            if (propertyNameParamName == null) {
                if (deserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer(annotatedParameterParameter) != null) {
                    _reportUnwrappedCreatorProperty(deserializationContext, beanDescription, annotatedParameterParameter);
                }
                propertyNameParamName = creatorCandidate.findImplicitParamName(i10);
                if (propertyNameParamName == null && valueInjection == null) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Argument #%d has no property name, is not Injectable: can not use as Creator %s", Integer.valueOf(i10), creatorCandidate);
                }
            }
            settableBeanPropertyArr[i10] = constructCreatorProperty(deserializationContext, beanDescription, propertyNameParamName, i10, annotatedParameterParameter, valueInjection);
        }
        creatorCollector.addPropertyCreator(creatorCandidate.creator(), true, settableBeanPropertyArr);
    }

    public ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        CreatorCollector creatorCollector = new CreatorCollector(beanDescription, deserializationContext.getConfig());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        VisibilityChecker<?> defaultVisibilityChecker = deserializationContext.getConfig().getDefaultVisibilityChecker(beanDescription.getBeanClass(), beanDescription.getClassInfo());
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> map_findCreatorsFromProperties = _findCreatorsFromProperties(deserializationContext, beanDescription);
        _addDeserializerFactoryMethods(deserializationContext, beanDescription, defaultVisibilityChecker, annotationIntrospector, creatorCollector, map_findCreatorsFromProperties);
        if (beanDescription.getType().isConcrete()) {
            _addDeserializerConstructors(deserializationContext, beanDescription, defaultVisibilityChecker, annotationIntrospector, creatorCollector, map_findCreatorsFromProperties);
        }
        return creatorCollector.constructValueInstantiator(deserializationContext);
    }

    public Map<AnnotatedWithParams, BeanPropertyDefinition[]> _findCreatorsFromProperties(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> mapEmptyMap = Collections.emptyMap();
        for (BeanPropertyDefinition beanPropertyDefinition : beanDescription.findProperties()) {
            Iterator<AnnotatedParameter> constructorParameters = beanPropertyDefinition.getConstructorParameters();
            while (constructorParameters.hasNext()) {
                AnnotatedParameter next = constructorParameters.next();
                AnnotatedWithParams owner = next.getOwner();
                BeanPropertyDefinition[] beanPropertyDefinitionArr = mapEmptyMap.get(owner);
                int index = next.getIndex();
                if (beanPropertyDefinitionArr == null) {
                    if (mapEmptyMap.isEmpty()) {
                        mapEmptyMap = new LinkedHashMap<>();
                    }
                    beanPropertyDefinitionArr = new BeanPropertyDefinition[owner.getParameterCount()];
                    mapEmptyMap.put(owner, beanPropertyDefinitionArr);
                } else if (beanPropertyDefinitionArr[index] != null) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(index), owner, beanPropertyDefinitionArr[index], beanPropertyDefinition);
                }
                beanPropertyDefinitionArr[index] = beanPropertyDefinition;
            }
        }
        return mapEmptyMap;
    }

    public JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindArrayDeserializer = it.next().findArrayDeserializer(arrayType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindArrayDeserializer != null) {
                return jsonDeserializerFindArrayDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindBeanDeserializer = it.next().findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            if (jsonDeserializerFindBeanDeserializer != null) {
                return jsonDeserializerFindBeanDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindCollectionDeserializer = it.next().findCollectionDeserializer(collectionType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindCollectionDeserializer != null) {
                return jsonDeserializerFindCollectionDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindCollectionLikeDeserializer = it.next().findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindCollectionLikeDeserializer != null) {
                return jsonDeserializerFindCollectionLikeDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindEnumDeserializer = it.next().findEnumDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindEnumDeserializer != null) {
                return jsonDeserializerFindEnumDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindMapDeserializer = it.next().findMapDeserializer(mapType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindMapDeserializer != null) {
                return jsonDeserializerFindMapDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindMapLikeDeserializer = it.next().findMapLikeDeserializer(mapLikeType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindMapLikeDeserializer != null) {
                return jsonDeserializerFindMapLikeDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindReferenceDeserializer = it.next().findReferenceDeserializer(referenceType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (jsonDeserializerFindReferenceDeserializer != null) {
                return jsonDeserializerFindReferenceDeserializer;
            }
        }
        return null;
    }

    public JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindTreeNodeDeserializer = it.next().findTreeNodeDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindTreeNodeDeserializer != null) {
                return jsonDeserializerFindTreeNodeDeserializer;
            }
        }
        return null;
    }

    @Deprecated
    public AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return deserializationConfig.introspect(javaType).findJsonValueMethod();
    }

    public JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) throws JsonMappingException {
        JavaType javaTypeMapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType(cls));
        if (javaTypeMapAbstractType == null || javaTypeMapAbstractType.hasRawClass(cls)) {
            return null;
        }
        return javaTypeMapAbstractType;
    }

    public PropertyMetadata _getSetterInfo(DeserializationContext deserializationContext, BeanProperty beanProperty, PropertyMetadata propertyMetadata) {
        Nulls nullsNonDefaultContentNulls;
        JsonSetter.Value valueFindSetterInfo;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedMember member = beanProperty.getMember();
        Nulls nullsNonDefaultValueNulls = null;
        if (member != null) {
            if (annotationIntrospector == null || (valueFindSetterInfo = annotationIntrospector.findSetterInfo(member)) == null) {
                nullsNonDefaultContentNulls = null;
            } else {
                nullsNonDefaultValueNulls = valueFindSetterInfo.nonDefaultValueNulls();
                nullsNonDefaultContentNulls = valueFindSetterInfo.nonDefaultContentNulls();
            }
            JsonSetter.Value setterInfo = config.getConfigOverride(beanProperty.getType().getRawClass()).getSetterInfo();
            if (setterInfo != null) {
                if (nullsNonDefaultValueNulls == null) {
                    nullsNonDefaultValueNulls = setterInfo.nonDefaultValueNulls();
                }
                if (nullsNonDefaultContentNulls == null) {
                    nullsNonDefaultContentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
        } else {
            nullsNonDefaultContentNulls = null;
        }
        JsonSetter.Value defaultSetterInfo = config.getDefaultSetterInfo();
        if (nullsNonDefaultValueNulls == null) {
            nullsNonDefaultValueNulls = defaultSetterInfo.nonDefaultValueNulls();
        }
        if (nullsNonDefaultContentNulls == null) {
            nullsNonDefaultContentNulls = defaultSetterInfo.nonDefaultContentNulls();
        }
        return (nullsNonDefaultValueNulls == null && nullsNonDefaultContentNulls == null) ? propertyMetadata : propertyMetadata.withNulls(nullsNonDefaultValueNulls, nullsNonDefaultContentNulls);
    }

    public boolean _handleSingleArgumentCreator(CreatorCollector creatorCollector, AnnotatedWithParams annotatedWithParams, boolean z10, boolean z11) {
        Class<?> rawParameterType = annotatedWithParams.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CLASS_CHAR_SEQUENCE) {
            if (z10 || z11) {
                creatorCollector.addStringCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z10 || z11) {
                creatorCollector.addIntCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z10 || z11) {
                creatorCollector.addLongCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z10 || z11) {
                creatorCollector.addDoubleCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z10 || z11) {
                creatorCollector.addBooleanCreator(annotatedWithParams, z10);
            }
            return true;
        }
        if (!z10) {
            return false;
        }
        creatorCollector.addDelegatingCreator(annotatedWithParams, z10, null, 0);
        return true;
    }

    public boolean _hasCreatorAnnotation(DeserializationContext deserializationContext, Annotated annotated) {
        JsonCreator.Mode modeFindCreatorAnnotation;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        return (annotationIntrospector == null || (modeFindCreatorAnnotation = annotationIntrospector.findCreatorAnnotation(deserializationContext.getConfig(), annotated)) == null || modeFindCreatorAnnotation == JsonCreator.Mode.DISABLED) ? false : true;
    }

    public CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsFindCollectionFallback = ContainerDefaultMappings.findCollectionFallback(javaType);
        if (clsFindCollectionFallback != null) {
            return (CollectionType) deserializationConfig.constructSpecializedType(javaType, clsFindCollectionFallback);
        }
        return null;
    }

    public MapType _mapAbstractMapType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsFindMapFallback = ContainerDefaultMappings.findMapFallback(javaType);
        if (clsFindMapFallback != null) {
            return (MapType) deserializationConfig.constructSpecializedType(javaType, clsFindMapFallback);
        }
        return null;
    }

    public void _reportUnwrappedCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedParameter annotatedParameter) throws JsonMappingException {
        deserializationContext.reportBadDefinition(beanDescription.getType(), String.format("Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(annotatedParameter.getIndex())));
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) throws JsonMappingException {
        ValueInstantiator valueInstantiatorValueInstantiatorInstance;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class<?> cls = (Class) obj;
        if (ClassUtil.isBogusClass(cls)) {
            return null;
        }
        if (!ValueInstantiator.class.isAssignableFrom(cls)) {
            throw new IllegalStateException(c.d(cls, new StringBuilder("AnnotationIntrospector returned Class "), "; expected Class<ValueInstantiator>"));
        }
        HandlerInstantiator handlerInstantiator = deserializationConfig.getHandlerInstantiator();
        return (handlerInstantiator == null || (valueInstantiatorValueInstantiatorInstance = handlerInstantiator.valueInstantiatorInstance(deserializationConfig, annotated, cls)) == null) ? (ValueInstantiator) ClassUtil.createInstance(cls, deserializationConfig.canOverrideAccessModifiers()) : valueInstantiatorValueInstantiatorInstance;
    }

    public SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, PropertyName propertyName, int i10, AnnotatedParameter annotatedParameter, JacksonInject.Value value) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        PropertyMetadata propertyMetadataConstruct = annotationIntrospector == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.construct(annotationIntrospector.hasRequiredMarker(annotatedParameter), annotationIntrospector.findPropertyDescription(annotatedParameter), annotationIntrospector.findPropertyIndex(annotatedParameter), annotationIntrospector.findPropertyDefaultValue(annotatedParameter));
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedParameter, annotatedParameter.getType());
        BeanProperty.Std std = new BeanProperty.Std(propertyName, javaTypeResolveMemberAndTypeAnnotations, annotationIntrospector.findWrapperName(annotatedParameter), annotatedParameter, propertyMetadataConstruct);
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, javaTypeResolveMemberAndTypeAnnotations);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        PropertyMetadata propertyMetadata_getSetterInfo = _getSetterInfo(deserializationContext, std, propertyMetadataConstruct);
        CreatorProperty creatorProperty = new CreatorProperty(propertyName, javaTypeResolveMemberAndTypeAnnotations, std.getWrapperName(), typeDeserializer, beanDescription.getClassAnnotations(), annotatedParameter, i10, value == null ? null : value.getId(), propertyMetadata_getSetterInfo);
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return jsonDeserializerFindDeserializerFromAnnotation != null ? creatorProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, creatorProperty, javaTypeResolveMemberAndTypeAnnotations)) : creatorProperty;
    }

    public EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) throws SecurityException {
        if (annotatedMember == null) {
            return EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
        }
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotatedMember.getMember(), deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return EnumResolver.constructUnsafeUsingMethod(cls, annotatedMember, deserializationConfig.getAnnotationIntrospector());
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomArrayDeserializer == null) {
            if (jsonDeserializer == null) {
                Class<?> rawClass = contentType.getRawClass();
                if (contentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            jsonDeserializer_findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, jsonDeserializer, typeDeserializer);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomArrayDeserializer = it.next().modifyArrayDeserializer(config, arrayType, beanDescription, jsonDeserializer_findCustomArrayDeserializer);
            }
        }
        return jsonDeserializer_findCustomArrayDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            Class<?> rawClass = collectionType.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(rawClass)) {
                jsonDeserializer_findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            if (collectionType.isInterface() || collectionType.isAbstract()) {
                CollectionType collectionType_mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config);
                if (collectionType_mapAbstractCollectionType != null) {
                    beanDescription = config.introspectForCreation(collectionType_mapAbstractCollectionType);
                    collectionType = collectionType_mapAbstractCollectionType;
                } else {
                    if (collectionType.getTypeHandler() == null) {
                        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + collectionType);
                    }
                    jsonDeserializer_findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(beanDescription);
                }
            }
            if (jsonDeserializer_findCustomCollectionDeserializer == null) {
                ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
                if (!valueInstantiatorFindValueInstantiator.canCreateUsingDefault()) {
                    if (collectionType.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(collectionType, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator);
                    }
                    JsonDeserializer<?> jsonDeserializerFindForCollection = JavaUtilCollectionsDeserializers.findForCollection(deserializationContext, collectionType);
                    if (jsonDeserializerFindForCollection != null) {
                        return jsonDeserializerFindForCollection;
                    }
                }
                jsonDeserializer_findCustomCollectionDeserializer = contentType.hasRawClass(String.class) ? new StringCollectionDeserializer(collectionType, jsonDeserializer, valueInstantiatorFindValueInstantiator) : new CollectionDeserializer(collectionType, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionDeserializer = it.next().modifyCollectionDeserializer(config, collectionType, beanDescription, jsonDeserializer_findCustomCollectionDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionLikeType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, beanDescription, typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionLikeDeserializer = it.next().modifyCollectionLikeDeserializer(config, collectionLikeType, beanDescription, jsonDeserializer_findCustomCollectionLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescription);
        if (jsonDeserializer_findCustomEnumDeserializer == null) {
            ValueInstantiator valueInstantiator_constructDefaultValueInstantiator = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
            SettableBeanProperty[] fromObjectArguments = valueInstantiator_constructDefaultValueInstantiator == null ? null : valueInstantiator_constructDefaultValueInstantiator.getFromObjectArguments(deserializationContext.getConfig());
            Iterator<AnnotatedMethod> it = beanDescription.getFactoryMethods().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedMethod next = it.next();
                if (_hasCreatorAnnotation(deserializationContext, next)) {
                    if (next.getParameterCount() == 0) {
                        jsonDeserializer_findCustomEnumDeserializer = EnumDeserializer.deserializerForNoArgsCreator(config, rawClass, next);
                        break;
                    }
                    if (next.getRawReturnType().isAssignableFrom(rawClass)) {
                        jsonDeserializer_findCustomEnumDeserializer = EnumDeserializer.deserializerForCreator(config, rawClass, next, valueInstantiator_constructDefaultValueInstantiator, fromObjectArguments);
                        break;
                    }
                }
            }
            if (jsonDeserializer_findCustomEnumDeserializer == null) {
                jsonDeserializer_findCustomEnumDeserializer = new EnumDeserializer(constructEnumResolver(rawClass, config, beanDescription.findJsonValueAccessor()), Boolean.valueOf(config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializer_findCustomEnumDeserializer = it2.next().modifyEnumDeserializer(config, javaType, beanDescription, jsonDeserializer_findCustomEnumDeserializer);
            }
        }
        return jsonDeserializer_findCustomEnumDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        KeyDeserializer keyDeserializerModifyKeyDeserializer = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            BeanDescription beanDescriptionIntrospectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            Iterator<KeyDeserializers> it = this._factoryConfig.keyDeserializers().iterator();
            while (it.hasNext() && (keyDeserializerModifyKeyDeserializer = it.next().findKeyDeserializer(javaType, config, beanDescriptionIntrospectClassAnnotations)) == null) {
            }
        }
        if (keyDeserializerModifyKeyDeserializer == null) {
            keyDeserializerModifyKeyDeserializer = javaType.isEnumType() ? _createEnumKeyDeserializer(deserializationContext, javaType) : StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
        }
        if (keyDeserializerModifyKeyDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                keyDeserializerModifyKeyDeserializer = it2.next().modifyKeyDeserializer(config, javaType, keyDeserializerModifyKeyDeserializer);
            }
        }
        return keyDeserializerModifyKeyDeserializer;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext r20, com.fasterxml.jackson.databind.type.MapType r21, com.fasterxml.jackson.databind.BeanDescription r22) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.type.MapType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> jsonDeserializer_findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, beanDescription, keyDeserializer, typeDeserializerFindTypeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomMapLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomMapLikeDeserializer = it.next().modifyMapLikeDeserializer(config, mapLikeType, beanDescription, jsonDeserializer_findCustomMapLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomMapLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = referenceType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomReferenceDeserializer = _findCustomReferenceDeserializer(referenceType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomReferenceDeserializer == null && referenceType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return new AtomicReferenceDeserializer(referenceType, referenceType.getRawClass() == AtomicReference.class ? null : findValueInstantiator(deserializationContext, beanDescription), typeDeserializer, jsonDeserializer);
        }
        if (jsonDeserializer_findCustomReferenceDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomReferenceDeserializer = it.next().modifyReferenceDeserializer(config, referenceType, beanDescription, jsonDeserializer_findCustomReferenceDeserializer);
            }
        }
        return jsonDeserializer_findCustomReferenceDeserializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanDescription);
        return jsonDeserializer_findCustomTreeNodeDeserializer != null ? jsonDeserializer_findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    public JsonDeserializer<Object> findContentDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        Object objFindContentDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindContentDeserializer = annotationIntrospector.findContentDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(annotated, objFindContentDeserializer);
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType javaType_findRemappedType;
        JavaType javaType_findRemappedType2;
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == CLASS_OBJECT || rawClass == CLASS_SERIALIZABLE) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                javaType_findRemappedType = _findRemappedType(config, List.class);
                javaType_findRemappedType2 = _findRemappedType(config, Map.class);
            } else {
                javaType_findRemappedType = null;
                javaType_findRemappedType2 = null;
            }
            return new UntypedObjectDeserializer(javaType_findRemappedType, javaType_findRemappedType2);
        }
        if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_SEQUENCE) {
            return StringDeserializer.instance;
        }
        Class<?> cls = CLASS_ITERABLE;
        if (rawClass == cls) {
            TypeFactory typeFactory = deserializationContext.getTypeFactory();
            JavaType[] javaTypeArrFindTypeParameters = typeFactory.findTypeParameters(javaType, cls);
            return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, (javaTypeArrFindTypeParameters == null || javaTypeArrFindTypeParameters.length != 1) ? TypeFactory.unknownType() : javaTypeArrFindTypeParameters[0]), beanDescription);
        }
        if (rawClass == CLASS_MAP_ENTRY) {
            JavaType javaTypeContainedTypeOrUnknown = javaType.containedTypeOrUnknown(0);
            JavaType javaTypeContainedTypeOrUnknown2 = javaType.containedTypeOrUnknown(1);
            TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) javaTypeContainedTypeOrUnknown2.getTypeHandler();
            if (typeDeserializerFindTypeDeserializer == null) {
                typeDeserializerFindTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), javaTypeContainedTypeOrUnknown2);
            }
            return new MapEntryDeserializer(javaType, (KeyDeserializer) javaTypeContainedTypeOrUnknown.getValueHandler(), (JsonDeserializer<Object>) javaTypeContainedTypeOrUnknown2.getValueHandler(), typeDeserializerFindTypeDeserializer);
        }
        String name = rawClass.getName();
        if (rawClass.isPrimitive() || name.startsWith("java.")) {
            JsonDeserializer<?> jsonDeserializerFind = NumberDeserializers.find(rawClass, name);
            if (jsonDeserializerFind == null) {
                jsonDeserializerFind = DateDeserializers.find(rawClass, name);
            }
            if (jsonDeserializerFind != null) {
                return jsonDeserializerFind;
            }
        }
        if (rawClass == TokenBuffer.class) {
            return new TokenBufferDeserializer();
        }
        JsonDeserializer<?> jsonDeserializerFindOptionalStdDeserializer = findOptionalStdDeserializer(deserializationContext, javaType, beanDescription);
        return jsonDeserializerFindOptionalStdDeserializer != null ? jsonDeserializerFindOptionalStdDeserializer : JdkDeserializers.find(rawClass, name);
    }

    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        Object objFindDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindDeserializer = annotationIntrospector.findDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(annotated, objFindDeserializer);
    }

    public KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        Object objFindKeyDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindKeyDeserializer = annotationIntrospector.findKeyDeserializer(annotated)) == null) {
            return null;
        }
        return deserializationContext.keyDeserializerInstance(annotated, objFindKeyDeserializer);
    }

    public JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), beanDescription);
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        return typeResolverBuilderFindPropertyContentTypeResolver == null ? findTypeDeserializer(deserializationConfig, contentType) : typeResolverBuilderFindPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, contentType));
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (typeResolverBuilderFindPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        try {
            return typeResolverBuilderFindPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
        } catch (IllegalArgumentException e10) {
            InvalidDefinitionException invalidDefinitionExceptionFrom = InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e10), javaType);
            invalidDefinitionExceptionFrom.initCause(e10);
            throw invalidDefinitionExceptionFrom;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Collection<NamedType> collectionCollectAndResolveSubtypesByTypeId;
        JavaType javaTypeMapAbstractType;
        AnnotatedClass classInfo = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        TypeResolverBuilder<?> typeResolverBuilderFindTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, classInfo, javaType);
        if (typeResolverBuilderFindTypeResolver == null) {
            typeResolverBuilderFindTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            if (typeResolverBuilderFindTypeResolver == null) {
                return null;
            }
            collectionCollectAndResolveSubtypesByTypeId = null;
        } else {
            collectionCollectAndResolveSubtypesByTypeId = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, classInfo);
        }
        if (typeResolverBuilderFindTypeResolver.getDefaultImpl() == null && javaType.isAbstract() && (javaTypeMapAbstractType = mapAbstractType(deserializationConfig, javaType)) != null && !javaTypeMapAbstractType.hasRawClass(javaType.getRawClass())) {
            typeResolverBuilderFindTypeResolver = typeResolverBuilderFindTypeResolver.defaultImpl(javaTypeMapAbstractType.getRawClass());
        }
        try {
            return typeResolverBuilderFindTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collectionCollectAndResolveSubtypesByTypeId);
        } catch (IllegalArgumentException e10) {
            InvalidDefinitionException invalidDefinitionExceptionFrom = InvalidDefinitionException.from((JsonParser) null, ClassUtil.exceptionMessage(e10), javaType);
            invalidDefinitionExceptionFrom.initCause(e10);
            throw invalidDefinitionExceptionFrom;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedClass classInfo = beanDescription.getClassInfo();
        Object objFindValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(classInfo);
        ValueInstantiator valueInstantiator_valueInstantiatorInstance = objFindValueInstantiator != null ? _valueInstantiatorInstance(config, classInfo, objFindValueInstantiator) : null;
        if (valueInstantiator_valueInstantiatorInstance == null && (valueInstantiator_valueInstantiatorInstance = JDKValueInstantiators.findStdValueInstantiator(config, beanDescription.getBeanClass())) == null) {
            valueInstantiator_valueInstantiatorInstance = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators valueInstantiators : this._factoryConfig.valueInstantiators()) {
                valueInstantiator_valueInstantiatorInstance = valueInstantiators.findValueInstantiator(config, beanDescription, valueInstantiator_valueInstantiatorInstance);
                if (valueInstantiator_valueInstantiatorInstance == null) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", valueInstantiators.getClass().getName());
                }
            }
        }
        if (valueInstantiator_valueInstantiatorInstance.getIncompleteParameter() == null) {
            return valueInstantiator_valueInstantiatorInstance;
        }
        AnnotatedParameter incompleteParameter = valueInstantiator_valueInstantiatorInstance.getIncompleteParameter();
        throw new IllegalArgumentException("Argument #" + incompleteParameter.getIndex() + " of constructor " + incompleteParameter.getOwner() + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType javaType_mapAbstractType2;
        while (true) {
            javaType_mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (javaType_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = javaType_mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                break;
            }
            javaType = javaType_mapAbstractType2;
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + javaType_mapAbstractType2 + ": latter is not a subtype of former");
    }

    @Deprecated
    public JavaType modifyTypeByAnnotation(DeserializationContext deserializationContext, Annotated annotated, JavaType javaType) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        return annotationIntrospector == null ? javaType : annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotated, javaType);
    }

    public JavaType resolveMemberAndTypeAnnotations(DeserializationContext deserializationContext, AnnotatedMember annotatedMember, JavaType javaType) throws JsonMappingException {
        KeyDeserializer keyDeserializerKeyDeserializerInstance;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && javaType.getKeyType() != null && (keyDeserializerKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember))) != null) {
            javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerKeyDeserializerInstance);
            javaType.getKeyType();
        }
        if (javaType.hasContentType()) {
            JsonDeserializer<Object> jsonDeserializerDeserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (jsonDeserializerDeserializerInstance != null) {
                javaType = javaType.withContentValueHandler(jsonDeserializerDeserializerInstance);
            }
            TypeDeserializer typeDeserializerFindPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
            if (typeDeserializerFindPropertyContentTypeDeserializer != null) {
                javaType = javaType.withContentTypeHandler(typeDeserializerFindPropertyContentTypeDeserializer);
            }
        }
        TypeDeserializer typeDeserializerFindPropertyTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        if (typeDeserializerFindPropertyTypeDeserializer != null) {
            javaType = javaType.withTypeHandler(typeDeserializerFindPropertyTypeDeserializer);
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotatedMember, javaType);
    }

    @Deprecated
    public JavaType resolveType(DeserializationContext deserializationContext, BeanDescription beanDescription, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        return resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, javaType);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(abstractTypeResolver));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(deserializers));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(keyDeserializers));
    }

    public abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        return withConfig(this._factoryConfig.withDeserializerModifier(beanDeserializerModifier));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withValueInstantiators(ValueInstantiators valueInstantiators) {
        return withConfig(this._factoryConfig.withValueInstantiators(valueInstantiators));
    }
}
