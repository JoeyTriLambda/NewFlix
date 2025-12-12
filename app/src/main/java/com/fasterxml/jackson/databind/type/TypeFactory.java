package com.fasterxml.jackson.databind.type;

import ac.c;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class TypeFactory implements Serializable {
    private static final Class<?> CLS_BOOL;
    private static final Class<?> CLS_INT;
    private static final Class<?> CLS_LONG;
    protected static final SimpleType CORE_TYPE_BOOL;
    protected static final SimpleType CORE_TYPE_CLASS;
    protected static final SimpleType CORE_TYPE_COMPARABLE;
    protected static final SimpleType CORE_TYPE_ENUM;
    protected static final SimpleType CORE_TYPE_INT;
    protected static final SimpleType CORE_TYPE_JSON_NODE;
    protected static final SimpleType CORE_TYPE_LONG;
    protected static final SimpleType CORE_TYPE_OBJECT;
    protected static final SimpleType CORE_TYPE_STRING;
    private static final long serialVersionUID = 1;
    protected final ClassLoader _classLoader;
    protected final TypeModifier[] _modifiers;
    protected final TypeParser _parser;
    protected final LRUMap<Object, JavaType> _typeCache;
    private static final JavaType[] NO_TYPES = new JavaType[0];
    protected static final TypeFactory instance = new TypeFactory();
    protected static final TypeBindings EMPTY_BINDINGS = TypeBindings.emptyBindings();
    private static final Class<?> CLS_STRING = String.class;
    private static final Class<?> CLS_OBJECT = Object.class;
    private static final Class<?> CLS_COMPARABLE = Comparable.class;
    private static final Class<?> CLS_CLASS = Class.class;
    private static final Class<?> CLS_ENUM = Enum.class;
    private static final Class<?> CLS_JSON_NODE = JsonNode.class;

    static {
        Class<?> cls = Boolean.TYPE;
        CLS_BOOL = cls;
        Class<?> cls2 = Integer.TYPE;
        CLS_INT = cls2;
        Class<?> cls3 = Long.TYPE;
        CLS_LONG = cls3;
        CORE_TYPE_BOOL = new SimpleType(cls);
        CORE_TYPE_INT = new SimpleType(cls2);
        CORE_TYPE_LONG = new SimpleType(cls3);
        CORE_TYPE_STRING = new SimpleType((Class<?>) String.class);
        CORE_TYPE_OBJECT = new SimpleType((Class<?>) Object.class);
        CORE_TYPE_COMPARABLE = new SimpleType((Class<?>) Comparable.class);
        CORE_TYPE_ENUM = new SimpleType((Class<?>) Enum.class);
        CORE_TYPE_CLASS = new SimpleType((Class<?>) Class.class);
        CORE_TYPE_JSON_NODE = new SimpleType((Class<?>) JsonNode.class);
    }

    private TypeFactory() {
        this(null);
    }

    private TypeBindings _bindingsForSubtype(JavaType javaType, int i10, Class<?> cls) throws IllegalArgumentException {
        PlaceholderForType[] placeholderForTypeArr = new PlaceholderForType[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            placeholderForTypeArr[i11] = new PlaceholderForType(i11);
        }
        JavaType javaTypeFindSuperType = _fromClass(null, cls, TypeBindings.create(cls, placeholderForTypeArr)).findSuperType(javaType.getRawClass());
        if (javaTypeFindSuperType == null) {
            throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", javaType.getRawClass().getName(), cls.getName()));
        }
        String str_resolveTypePlaceholders = _resolveTypePlaceholders(javaType, javaTypeFindSuperType);
        if (str_resolveTypePlaceholders != null) {
            throw new IllegalArgumentException("Failed to specialize base type " + javaType.toCanonical() + " as " + cls.getName() + ", problem: " + str_resolveTypePlaceholders);
        }
        JavaType[] javaTypeArr = new JavaType[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            JavaType javaTypeActualType = placeholderForTypeArr[i12].actualType();
            if (javaTypeActualType == null) {
                javaTypeActualType = unknownType();
            }
            javaTypeArr[i12] = javaTypeActualType;
        }
        return TypeBindings.create(cls, javaTypeArr);
    }

    private JavaType _collectionType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType_unknownType;
        List<JavaType> typeParameters = typeBindings.getTypeParameters();
        if (typeParameters.isEmpty()) {
            javaType_unknownType = _unknownType();
        } else {
            if (typeParameters.size() != 1) {
                throw new IllegalArgumentException(c.d(cls, new StringBuilder("Strange Collection type "), ": cannot determine type parameters"));
            }
            javaType_unknownType = typeParameters.get(0);
        }
        return CollectionType.construct(cls, typeBindings, javaType, javaTypeArr, javaType_unknownType);
    }

    private JavaType _mapType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType_unknownType;
        JavaType javaType2;
        JavaType javaType3;
        if (cls == Properties.class) {
            javaType_unknownType = CORE_TYPE_STRING;
        } else {
            List<JavaType> typeParameters = typeBindings.getTypeParameters();
            int size = typeParameters.size();
            if (size != 0) {
                if (size != 2) {
                    throw new IllegalArgumentException(c.d(cls, new StringBuilder("Strange Map type "), ": cannot determine type parameters"));
                }
                JavaType javaType4 = typeParameters.get(0);
                javaType2 = typeParameters.get(1);
                javaType3 = javaType4;
                return MapType.construct(cls, typeBindings, javaType, javaTypeArr, javaType3, javaType2);
            }
            javaType_unknownType = _unknownType();
        }
        javaType3 = javaType_unknownType;
        javaType2 = javaType3;
        return MapType.construct(cls, typeBindings, javaType, javaTypeArr, javaType3, javaType2);
    }

    private JavaType _referenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType_unknownType;
        List<JavaType> typeParameters = typeBindings.getTypeParameters();
        if (typeParameters.isEmpty()) {
            javaType_unknownType = _unknownType();
        } else {
            if (typeParameters.size() != 1) {
                throw new IllegalArgumentException(c.d(cls, new StringBuilder("Strange Reference type "), ": cannot determine type parameters"));
            }
            javaType_unknownType = typeParameters.get(0);
        }
        return ReferenceType.construct(cls, typeBindings, javaType, javaTypeArr, javaType_unknownType);
    }

    private String _resolveTypePlaceholders(JavaType javaType, JavaType javaType2) throws IllegalArgumentException {
        List<JavaType> typeParameters = javaType.getBindings().getTypeParameters();
        List<JavaType> typeParameters2 = javaType2.getBindings().getTypeParameters();
        int size = typeParameters.size();
        for (int i10 = 0; i10 < size; i10++) {
            JavaType javaType3 = typeParameters.get(i10);
            JavaType javaType4 = typeParameters2.get(i10);
            if (!_verifyAndResolvePlaceholders(javaType3, javaType4) && !javaType3.hasRawClass(Object.class) && ((i10 != 0 || !javaType.isMapLikeType() || !javaType4.hasRawClass(Object.class)) && (!javaType3.isInterface() || !javaType3.isTypeOrSuperTypeOf(javaType4.getRawClass())))) {
                return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i10 + 1), Integer.valueOf(size), javaType3.toCanonical(), javaType4.toCanonical());
            }
        }
        return null;
    }

    private boolean _verifyAndResolvePlaceholders(JavaType javaType, JavaType javaType2) {
        if (javaType2 instanceof PlaceholderForType) {
            ((PlaceholderForType) javaType2).actualType(javaType);
            return true;
        }
        if (javaType.getRawClass() != javaType2.getRawClass()) {
            return false;
        }
        List<JavaType> typeParameters = javaType.getBindings().getTypeParameters();
        List<JavaType> typeParameters2 = javaType2.getBindings().getTypeParameters();
        int size = typeParameters.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!_verifyAndResolvePlaceholders(typeParameters.get(i10), typeParameters2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static TypeFactory defaultInstance() {
        return instance;
    }

    public static Class<?> rawClass(Type type) {
        return type instanceof Class ? (Class) type : defaultInstance().constructType(type).getRawClass();
    }

    public static JavaType unknownType() {
        return defaultInstance()._unknownType();
    }

    public JavaType _constructSimple(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType_findWellKnownSimple;
        return (!typeBindings.isEmpty() || (javaType_findWellKnownSimple = _findWellKnownSimple(cls)) == null) ? _newSimpleType(cls, typeBindings, javaType, javaTypeArr) : javaType_findWellKnownSimple;
    }

    public Class<?> _findPrimitive(String str) {
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        if ("char".equals(str)) {
            return Character.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("void".equals(str)) {
            return Void.TYPE;
        }
        return null;
    }

    public JavaType _findWellKnownSimple(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == CLS_BOOL) {
                return CORE_TYPE_BOOL;
            }
            if (cls == CLS_INT) {
                return CORE_TYPE_INT;
            }
            if (cls == CLS_LONG) {
                return CORE_TYPE_LONG;
            }
            return null;
        }
        if (cls == CLS_STRING) {
            return CORE_TYPE_STRING;
        }
        if (cls == CLS_OBJECT) {
            return CORE_TYPE_OBJECT;
        }
        if (cls == CLS_JSON_NODE) {
            return CORE_TYPE_JSON_NODE;
        }
        return null;
    }

    public JavaType _fromAny(ClassStack classStack, Type type, TypeBindings typeBindings) {
        JavaType javaType_fromWildcard;
        if (type instanceof Class) {
            javaType_fromWildcard = _fromClass(classStack, (Class) type, EMPTY_BINDINGS);
        } else if (type instanceof ParameterizedType) {
            javaType_fromWildcard = _fromParamType(classStack, (ParameterizedType) type, typeBindings);
        } else {
            if (type instanceof JavaType) {
                return (JavaType) type;
            }
            if (type instanceof GenericArrayType) {
                javaType_fromWildcard = _fromArrayType(classStack, (GenericArrayType) type, typeBindings);
            } else if (type instanceof TypeVariable) {
                javaType_fromWildcard = _fromVariable(classStack, (TypeVariable) type, typeBindings);
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sb2 = new StringBuilder("Unrecognized Type: ");
                    sb2.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sb2.toString());
                }
                javaType_fromWildcard = _fromWildcard(classStack, (WildcardType) type, typeBindings);
            }
        }
        if (this._modifiers != null) {
            TypeBindings bindings = javaType_fromWildcard.getBindings();
            if (bindings == null) {
                bindings = EMPTY_BINDINGS;
            }
            TypeModifier[] typeModifierArr = this._modifiers;
            int length = typeModifierArr.length;
            int i10 = 0;
            while (i10 < length) {
                TypeModifier typeModifier = typeModifierArr[i10];
                JavaType javaTypeModifyType = typeModifier.modifyType(javaType_fromWildcard, type, bindings, this);
                if (javaTypeModifyType == null) {
                    throw new IllegalStateException(String.format("TypeModifier %s (of type %s) return null for type %s", typeModifier, typeModifier.getClass().getName(), javaType_fromWildcard));
                }
                i10++;
                javaType_fromWildcard = javaTypeModifyType;
            }
        }
        return javaType_fromWildcard;
    }

    public JavaType _fromArrayType(ClassStack classStack, GenericArrayType genericArrayType, TypeBindings typeBindings) {
        return ArrayType.construct(_fromAny(classStack, genericArrayType.getGenericComponentType(), typeBindings), typeBindings);
    }

    public JavaType _fromClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        ClassStack classStackChild;
        JavaType javaType_resolveSuperClass;
        JavaType[] javaTypeArr_resolveSuperInterfaces;
        JavaType javaType_newSimpleType;
        JavaType javaType_findWellKnownSimple = _findWellKnownSimple(cls);
        if (javaType_findWellKnownSimple != null) {
            return javaType_findWellKnownSimple;
        }
        Object objAsKey = (typeBindings == null || typeBindings.isEmpty()) ? cls : typeBindings.asKey(cls);
        JavaType javaTypeRefine = this._typeCache.get(objAsKey);
        if (javaTypeRefine != null) {
            return javaTypeRefine;
        }
        if (classStack == null) {
            classStackChild = new ClassStack(cls);
        } else {
            ClassStack classStackFind = classStack.find(cls);
            if (classStackFind != null) {
                ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(cls, EMPTY_BINDINGS);
                classStackFind.addSelfReference(resolvedRecursiveType);
                return resolvedRecursiveType;
            }
            classStackChild = classStack.child(cls);
        }
        if (cls.isArray()) {
            javaType_newSimpleType = ArrayType.construct(_fromAny(classStackChild, cls.getComponentType(), typeBindings), typeBindings);
        } else {
            if (cls.isInterface()) {
                javaTypeArr_resolveSuperInterfaces = _resolveSuperInterfaces(classStackChild, cls, typeBindings);
                javaType_resolveSuperClass = null;
            } else {
                javaType_resolveSuperClass = _resolveSuperClass(classStackChild, cls, typeBindings);
                javaTypeArr_resolveSuperInterfaces = _resolveSuperInterfaces(classStackChild, cls, typeBindings);
            }
            JavaType[] javaTypeArr = javaTypeArr_resolveSuperInterfaces;
            JavaType javaType = javaType_resolveSuperClass;
            if (cls == Properties.class) {
                SimpleType simpleType = CORE_TYPE_STRING;
                javaTypeRefine = MapType.construct(cls, typeBindings, javaType, javaTypeArr, simpleType, simpleType);
            } else if (javaType != null) {
                javaTypeRefine = javaType.refine(cls, typeBindings, javaType, javaTypeArr);
            }
            javaType_newSimpleType = (javaTypeRefine == null && (javaTypeRefine = _fromWellKnownClass(classStackChild, cls, typeBindings, javaType, javaTypeArr)) == null && (javaTypeRefine = _fromWellKnownInterface(classStackChild, cls, typeBindings, javaType, javaTypeArr)) == null) ? _newSimpleType(cls, typeBindings, javaType, javaTypeArr) : javaTypeRefine;
        }
        classStackChild.resolveSelfReferences(javaType_newSimpleType);
        if (!javaType_newSimpleType.hasHandlers()) {
            this._typeCache.putIfAbsent(objAsKey, javaType_newSimpleType);
        }
        return javaType_newSimpleType;
    }

    public JavaType _fromParamType(ClassStack classStack, ParameterizedType parameterizedType, TypeBindings typeBindings) {
        TypeBindings typeBindingsCreate;
        Class<?> cls = (Class) parameterizedType.getRawType();
        if (cls == CLS_ENUM) {
            return CORE_TYPE_ENUM;
        }
        if (cls == CLS_COMPARABLE) {
            return CORE_TYPE_COMPARABLE;
        }
        if (cls == CLS_CLASS) {
            return CORE_TYPE_CLASS;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
        if (length == 0) {
            typeBindingsCreate = EMPTY_BINDINGS;
        } else {
            JavaType[] javaTypeArr = new JavaType[length];
            for (int i10 = 0; i10 < length; i10++) {
                javaTypeArr[i10] = _fromAny(classStack, actualTypeArguments[i10], typeBindings);
            }
            typeBindingsCreate = TypeBindings.create(cls, javaTypeArr);
        }
        return _fromClass(classStack, cls, typeBindingsCreate);
    }

    public JavaType _fromVariable(ClassStack classStack, TypeVariable<?> typeVariable, TypeBindings typeBindings) {
        Type[] bounds;
        String name = typeVariable.getName();
        if (typeBindings == null) {
            throw new IllegalArgumentException(c.k("Null `bindings` passed (type variable \"", name, "\")"));
        }
        JavaType javaTypeFindBoundType = typeBindings.findBoundType(name);
        if (javaTypeFindBoundType != null) {
            return javaTypeFindBoundType;
        }
        if (typeBindings.hasUnbound(name)) {
            return CORE_TYPE_OBJECT;
        }
        TypeBindings typeBindingsWithUnboundVariable = typeBindings.withUnboundVariable(name);
        synchronized (typeVariable) {
            bounds = typeVariable.getBounds();
        }
        return _fromAny(classStack, bounds[0], typeBindingsWithUnboundVariable);
    }

    public JavaType _fromWellKnownClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        if (typeBindings == null) {
            typeBindings = EMPTY_BINDINGS;
        }
        if (cls == Map.class) {
            return _mapType(cls, typeBindings, javaType, javaTypeArr);
        }
        if (cls == Collection.class) {
            return _collectionType(cls, typeBindings, javaType, javaTypeArr);
        }
        if (cls == AtomicReference.class) {
            return _referenceType(cls, typeBindings, javaType, javaTypeArr);
        }
        return null;
    }

    public JavaType _fromWellKnownInterface(ClassStack classStack, Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        for (JavaType javaType2 : javaTypeArr) {
            JavaType javaTypeRefine = javaType2.refine(cls, typeBindings, javaType, javaTypeArr);
            if (javaTypeRefine != null) {
                return javaTypeRefine;
            }
        }
        return null;
    }

    public JavaType _fromWildcard(ClassStack classStack, WildcardType wildcardType, TypeBindings typeBindings) {
        return _fromAny(classStack, wildcardType.getUpperBounds()[0], typeBindings);
    }

    public JavaType _newSimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new SimpleType(cls, typeBindings, javaType, javaTypeArr);
    }

    public JavaType _resolveSuperClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Type genericSuperclass = ClassUtil.getGenericSuperclass(cls);
        if (genericSuperclass == null) {
            return null;
        }
        return _fromAny(classStack, genericSuperclass, typeBindings);
    }

    public JavaType[] _resolveSuperInterfaces(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Type[] genericInterfaces = ClassUtil.getGenericInterfaces(cls);
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return NO_TYPES;
        }
        int length = genericInterfaces.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i10 = 0; i10 < length; i10++) {
            javaTypeArr[i10] = _fromAny(classStack, genericInterfaces[i10], typeBindings);
        }
        return javaTypeArr;
    }

    public JavaType _unknownType() {
        return CORE_TYPE_OBJECT;
    }

    public Class<?> classForName(String str, boolean z10, ClassLoader classLoader) throws ClassNotFoundException {
        return Class.forName(str, true, classLoader);
    }

    public void clearCache() {
        this._typeCache.clear();
    }

    public ArrayType constructArrayType(Class<?> cls) {
        return ArrayType.construct(_fromAny(null, cls, null), null);
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, Class<?> cls2) {
        return constructCollectionLikeType(cls, _fromClass(null, cls2, EMPTY_BINDINGS));
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, Class<?> cls2) {
        return constructCollectionType(cls, _fromClass(null, cls2, EMPTY_BINDINGS));
    }

    public JavaType constructFromCanonical(String str) throws IllegalArgumentException {
        return this._parser.parse(str);
    }

    public JavaType constructGeneralizedType(JavaType javaType, Class<?> cls) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == cls) {
            return javaType;
        }
        JavaType javaTypeFindSuperType = javaType.findSuperType(cls);
        if (javaTypeFindSuperType != null) {
            return javaTypeFindSuperType;
        }
        if (cls.isAssignableFrom(rawClass)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), javaType));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), javaType));
    }

    public MapLikeType constructMapLikeType(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        TypeBindings typeBindings = EMPTY_BINDINGS;
        return constructMapLikeType(cls, _fromClass(null, cls2, typeBindings), _fromClass(null, cls3, typeBindings));
    }

    public MapType constructMapType(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        JavaType javaType_fromClass;
        JavaType javaType_fromClass2;
        if (cls == Properties.class) {
            javaType_fromClass = CORE_TYPE_STRING;
            javaType_fromClass2 = javaType_fromClass;
        } else {
            TypeBindings typeBindings = EMPTY_BINDINGS;
            javaType_fromClass = _fromClass(null, cls2, typeBindings);
            javaType_fromClass2 = _fromClass(null, cls3, typeBindings);
        }
        return constructMapType(cls, javaType_fromClass, javaType_fromClass2);
    }

    public JavaType constructParametricType(Class<?> cls, Class<?>... clsArr) {
        int length = clsArr.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i10 = 0; i10 < length; i10++) {
            javaTypeArr[i10] = _fromClass(null, clsArr[i10], EMPTY_BINDINGS);
        }
        return constructParametricType(cls, javaTypeArr);
    }

    @Deprecated
    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, JavaType... javaTypeArr) {
        return constructParametricType(cls, javaTypeArr);
    }

    public CollectionLikeType constructRawCollectionLikeType(Class<?> cls) {
        return constructCollectionLikeType(cls, unknownType());
    }

    public CollectionType constructRawCollectionType(Class<? extends Collection> cls) {
        return constructCollectionType(cls, unknownType());
    }

    public MapLikeType constructRawMapLikeType(Class<?> cls) {
        return constructMapLikeType(cls, unknownType(), unknownType());
    }

    public MapType constructRawMapType(Class<? extends Map> cls) {
        return constructMapType(cls, unknownType(), unknownType());
    }

    public JavaType constructReferenceType(Class<?> cls, JavaType javaType) {
        return ReferenceType.construct(cls, null, null, null, javaType);
    }

    public JavaType constructSimpleType(Class<?> cls, JavaType[] javaTypeArr) {
        return _fromClass(null, cls, TypeBindings.create(cls, javaTypeArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.databind.JavaType constructSpecializedType(com.fasterxml.jackson.databind.JavaType r4, java.lang.Class<?> r5) {
        /*
            r3 = this;
            java.lang.Class r0 = r4.getRawClass()
            if (r0 != r5) goto L7
            return r4
        L7:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r2 = 0
            if (r0 != r1) goto L14
            com.fasterxml.jackson.databind.type.TypeBindings r0 = com.fasterxml.jackson.databind.type.TypeFactory.EMPTY_BINDINGS
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
            goto L98
        L14:
            boolean r1 = r0.isAssignableFrom(r5)
            if (r1 == 0) goto L9d
            com.fasterxml.jackson.databind.type.TypeBindings r1 = r4.getBindings()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L2c
            com.fasterxml.jackson.databind.type.TypeBindings r0 = com.fasterxml.jackson.databind.type.TypeFactory.EMPTY_BINDINGS
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
            goto L98
        L2c:
            boolean r1 = r4.isContainerType()
            if (r1 == 0) goto L82
            boolean r1 = r4.isMapLikeType()
            if (r1 == 0) goto L59
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            if (r5 == r0) goto L48
            java.lang.Class<java.util.LinkedHashMap> r0 = java.util.LinkedHashMap.class
            if (r5 == r0) goto L48
            java.lang.Class<java.util.EnumMap> r0 = java.util.EnumMap.class
            if (r5 == r0) goto L48
            java.lang.Class<java.util.TreeMap> r0 = java.util.TreeMap.class
            if (r5 != r0) goto L82
        L48:
            com.fasterxml.jackson.databind.JavaType r0 = r4.getKeyType()
            com.fasterxml.jackson.databind.JavaType r1 = r4.getContentType()
            com.fasterxml.jackson.databind.type.TypeBindings r0 = com.fasterxml.jackson.databind.type.TypeBindings.create(r5, r0, r1)
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
            goto L98
        L59:
            boolean r1 = r4.isCollectionLikeType()
            if (r1 == 0) goto L82
            java.lang.Class<java.util.ArrayList> r1 = java.util.ArrayList.class
            if (r5 == r1) goto L75
            java.lang.Class<java.util.LinkedList> r1 = java.util.LinkedList.class
            if (r5 == r1) goto L75
            java.lang.Class<java.util.HashSet> r1 = java.util.HashSet.class
            if (r5 == r1) goto L75
            java.lang.Class<java.util.TreeSet> r1 = java.util.TreeSet.class
            if (r5 != r1) goto L70
            goto L75
        L70:
            java.lang.Class<java.util.EnumSet> r1 = java.util.EnumSet.class
            if (r0 != r1) goto L82
            return r4
        L75:
            com.fasterxml.jackson.databind.JavaType r0 = r4.getContentType()
            com.fasterxml.jackson.databind.type.TypeBindings r0 = com.fasterxml.jackson.databind.type.TypeBindings.create(r5, r0)
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
            goto L98
        L82:
            java.lang.reflect.TypeVariable[] r0 = r5.getTypeParameters()
            int r0 = r0.length
            if (r0 != 0) goto L90
            com.fasterxml.jackson.databind.type.TypeBindings r0 = com.fasterxml.jackson.databind.type.TypeFactory.EMPTY_BINDINGS
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
            goto L98
        L90:
            com.fasterxml.jackson.databind.type.TypeBindings r0 = r3._bindingsForSubtype(r4, r0, r5)
            com.fasterxml.jackson.databind.JavaType r5 = r3._fromClass(r2, r5, r0)
        L98:
            com.fasterxml.jackson.databind.JavaType r4 = r5.withHandlersFrom(r4)
            return r4
        L9d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r5 = r5.getName()
            r2 = 0
            r1[r2] = r5
            r5 = 1
            r1[r5] = r4
            java.lang.String r4 = "Class %s not subtype of %s"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.TypeFactory.constructSpecializedType(com.fasterxml.jackson.databind.JavaType, java.lang.Class):com.fasterxml.jackson.databind.JavaType");
    }

    public JavaType constructType(Type type) {
        return _fromAny(null, type, EMPTY_BINDINGS);
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        Throwable rootCause;
        Class<?> cls_findPrimitive;
        if (str.indexOf(46) < 0 && (cls_findPrimitive = _findPrimitive(str)) != null) {
            return cls_findPrimitive;
        }
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        if (classLoader != null) {
            try {
                return classForName(str, true, classLoader);
            } catch (Exception e10) {
                rootCause = ClassUtil.getRootCause(e10);
            }
        } else {
            rootCause = null;
        }
        try {
            return classForName(str);
        } catch (Exception e11) {
            if (rootCause == null) {
                rootCause = ClassUtil.getRootCause(e11);
            }
            ClassUtil.throwIfRTE(rootCause);
            throw new ClassNotFoundException(rootCause.getMessage(), rootCause);
        }
    }

    public JavaType[] findTypeParameters(JavaType javaType, Class<?> cls) {
        JavaType javaTypeFindSuperType = javaType.findSuperType(cls);
        return javaTypeFindSuperType == null ? NO_TYPES : javaTypeFindSuperType.getBindings().typeParameterArray();
    }

    public ClassLoader getClassLoader() {
        return this._classLoader;
    }

    public JavaType moreSpecificType(JavaType javaType, JavaType javaType2) {
        Class<?> rawClass;
        Class<?> rawClass2;
        return javaType == null ? javaType2 : (javaType2 == null || (rawClass = javaType.getRawClass()) == (rawClass2 = javaType2.getRawClass()) || !rawClass.isAssignableFrom(rawClass2)) ? javaType : javaType2;
    }

    @Deprecated
    public JavaType uncheckedSimpleType(Class<?> cls) {
        return _constructSimple(cls, EMPTY_BINDINGS, null, null);
    }

    public TypeFactory withCache(LRUMap<Object, JavaType> lRUMap) {
        return new TypeFactory(lRUMap, this._parser, this._modifiers, this._classLoader);
    }

    public TypeFactory withClassLoader(ClassLoader classLoader) {
        return new TypeFactory(this._typeCache, this._parser, this._modifiers, classLoader);
    }

    public TypeFactory withModifier(TypeModifier typeModifier) {
        LRUMap<Object, JavaType> lRUMap = this._typeCache;
        TypeModifier[] typeModifierArr = null;
        if (typeModifier == null) {
            lRUMap = null;
        } else {
            TypeModifier[] typeModifierArr2 = this._modifiers;
            if (typeModifierArr2 == null) {
                typeModifierArr = new TypeModifier[]{typeModifier};
                lRUMap = null;
            } else {
                typeModifierArr = (TypeModifier[]) ArrayBuilders.insertInListNoDup(typeModifierArr2, typeModifier);
            }
        }
        return new TypeFactory(lRUMap, this._parser, typeModifierArr, this._classLoader);
    }

    public TypeFactory(LRUMap<Object, JavaType> lRUMap) {
        this._typeCache = lRUMap == null ? new LRUMap<>(16, 200) : lRUMap;
        this._parser = new TypeParser(this);
        this._modifiers = null;
        this._classLoader = null;
    }

    public Class<?> classForName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public ArrayType constructArrayType(JavaType javaType) {
        return ArrayType.construct(javaType, null);
    }

    @Deprecated
    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        return constructParametricType(cls, clsArr);
    }

    @Deprecated
    public JavaType constructSimpleType(Class<?> cls, Class<?> cls2, JavaType[] javaTypeArr) {
        return constructSimpleType(cls, javaTypeArr);
    }

    public JavaType constructType(Type type, TypeBindings typeBindings) {
        return _fromAny(null, type, typeBindings);
    }

    public JavaType constructType(TypeReference<?> typeReference) {
        return _fromAny(null, typeReference.getType(), EMPTY_BINDINGS);
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, JavaType javaType) {
        JavaType javaType_fromClass = _fromClass(null, cls, TypeBindings.createIfNeeded(cls, javaType));
        if (javaType_fromClass instanceof CollectionLikeType) {
            return (CollectionLikeType) javaType_fromClass;
        }
        return CollectionLikeType.upgradeFrom(javaType_fromClass, javaType);
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, JavaType javaType) {
        TypeBindings typeBindingsCreateIfNeeded = TypeBindings.createIfNeeded(cls, javaType);
        CollectionType collectionType = (CollectionType) _fromClass(null, cls, typeBindingsCreateIfNeeded);
        if (typeBindingsCreateIfNeeded.isEmpty() && javaType != null) {
            JavaType contentType = collectionType.findSuperType(Collection.class).getContentType();
            if (!contentType.equals(javaType)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", ClassUtil.nameOf(cls), javaType, contentType));
            }
        }
        return collectionType;
    }

    @Deprecated
    public JavaType constructType(Type type, Class<?> cls) {
        return constructType(type, cls == null ? null : constructType(cls));
    }

    @Deprecated
    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2, TypeBindings typeBindings) {
        return findTypeParameters(constructType(cls, typeBindings), cls2);
    }

    public MapLikeType constructMapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        JavaType javaType_fromClass = _fromClass(null, cls, TypeBindings.createIfNeeded(cls, new JavaType[]{javaType, javaType2}));
        if (javaType_fromClass instanceof MapLikeType) {
            return (MapLikeType) javaType_fromClass;
        }
        return MapLikeType.upgradeFrom(javaType_fromClass, javaType, javaType2);
    }

    public JavaType constructParametricType(Class<?> cls, JavaType... javaTypeArr) {
        return _fromClass(null, cls, TypeBindings.create(cls, javaTypeArr));
    }

    @Deprecated
    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2) {
        return findTypeParameters(constructType(cls), cls2);
    }

    public MapType constructMapType(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        TypeBindings typeBindingsCreateIfNeeded = TypeBindings.createIfNeeded(cls, new JavaType[]{javaType, javaType2});
        MapType mapType = (MapType) _fromClass(null, cls, typeBindingsCreateIfNeeded);
        if (typeBindingsCreateIfNeeded.isEmpty()) {
            JavaType javaTypeFindSuperType = mapType.findSuperType(Map.class);
            JavaType keyType = javaTypeFindSuperType.getKeyType();
            if (keyType.equals(javaType)) {
                JavaType contentType = javaTypeFindSuperType.getContentType();
                if (!contentType.equals(javaType2)) {
                    throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", ClassUtil.nameOf(cls), javaType2, contentType));
                }
            } else {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", ClassUtil.nameOf(cls), javaType, keyType));
            }
        }
        return mapType;
    }

    @Deprecated
    public JavaType constructType(Type type, JavaType javaType) {
        TypeBindings bindings;
        if (javaType == null) {
            bindings = EMPTY_BINDINGS;
        } else {
            TypeBindings bindings2 = javaType.getBindings();
            if (type.getClass() != Class.class) {
                JavaType superClass = javaType;
                bindings = bindings2;
                while (bindings.isEmpty() && (superClass = superClass.getSuperClass()) != null) {
                    bindings = superClass.getBindings();
                }
            } else {
                bindings = bindings2;
            }
        }
        return _fromAny(null, type, bindings);
    }

    public TypeFactory(LRUMap<Object, JavaType> lRUMap, TypeParser typeParser, TypeModifier[] typeModifierArr, ClassLoader classLoader) {
        this._typeCache = lRUMap == null ? new LRUMap<>(16, 200) : lRUMap;
        this._parser = typeParser.withFactory(this);
        this._modifiers = typeModifierArr;
        this._classLoader = classLoader;
    }
}
