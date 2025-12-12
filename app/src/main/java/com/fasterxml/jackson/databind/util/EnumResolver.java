package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class EnumResolver implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Enum<?> _defaultValue;
    protected final Class<Enum<?>> _enumClass;
    protected final Enum<?>[] _enums;
    protected final HashMap<String, Enum<?>> _enumsById;

    public EnumResolver(Class<Enum<?>> cls, Enum<?>[] enumArr, HashMap<String, Enum<?>> map, Enum<?> r42) {
        this._enumClass = cls;
        this._enums = enumArr;
        this._enumsById = map;
        this._defaultValue = r42;
    }

    public static EnumResolver constructFor(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum<?>[] enumConstants = cls.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("No enum constants for class ".concat(cls.getName()));
        }
        String[] strArrFindEnumValues = annotationIntrospector.findEnumValues(cls, enumConstants, new String[enumConstants.length]);
        HashMap map = new HashMap();
        int length = enumConstants.length;
        for (int i10 = 0; i10 < length; i10++) {
            String strName = strArrFindEnumValues[i10];
            if (strName == null) {
                strName = enumConstants[i10].name();
            }
            map.put(strName, enumConstants[i10]);
        }
        return new EnumResolver(cls, enumConstants, map, annotationIntrospector.findDefaultEnumValue(cls));
    }

    public static EnumResolver constructUnsafe(Class<?> cls, AnnotationIntrospector annotationIntrospector) {
        return constructFor(cls, annotationIntrospector);
    }

    public static EnumResolver constructUnsafeUsingMethod(Class<?> cls, AnnotatedMember annotatedMember, AnnotationIntrospector annotationIntrospector) {
        return constructUsingMethod(cls, annotatedMember, annotationIntrospector);
    }

    public static EnumResolver constructUnsafeUsingToString(Class<?> cls, AnnotationIntrospector annotationIntrospector) {
        return constructUsingToString(cls, annotationIntrospector);
    }

    public static EnumResolver constructUsingMethod(Class<Enum<?>> cls, AnnotatedMember annotatedMember, AnnotationIntrospector annotationIntrospector) {
        Enum<?>[] enumConstants = cls.getEnumConstants();
        HashMap map = new HashMap();
        int length = enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Enum<?> r32 = enumConstants[length];
            try {
                Object value = annotatedMember.getValue(r32);
                if (value != null) {
                    map.put(value.toString(), r32);
                }
            } catch (Exception e10) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + r32 + ": " + e10.getMessage());
            }
        }
        return new EnumResolver(cls, enumConstants, map, annotationIntrospector != null ? annotationIntrospector.findDefaultEnumValue(cls) : null);
    }

    @Deprecated
    public static EnumResolver constructUsingToString(Class<Enum<?>> cls) {
        return constructUsingToString(cls, null);
    }

    public CompactStringObjectMap constructLookup() {
        return CompactStringObjectMap.construct(this._enumsById);
    }

    public Enum<?> findEnum(String str) {
        return this._enumsById.get(str);
    }

    public Enum<?> getDefaultValue() {
        return this._defaultValue;
    }

    public Enum<?> getEnum(int i10) {
        if (i10 < 0) {
            return null;
        }
        Enum<?>[] enumArr = this._enums;
        if (i10 >= enumArr.length) {
            return null;
        }
        return enumArr[i10];
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public Collection<String> getEnumIds() {
        return this._enumsById.keySet();
    }

    public List<Enum<?>> getEnums() {
        ArrayList arrayList = new ArrayList(this._enums.length);
        for (Enum<?> r02 : this._enums) {
            arrayList.add(r02);
        }
        return arrayList;
    }

    public Enum<?>[] getRawEnums() {
        return this._enums;
    }

    public int lastValidIndex() {
        return this._enums.length - 1;
    }

    public static EnumResolver constructUsingToString(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum<?>[] enumConstants = cls.getEnumConstants();
        HashMap map = new HashMap();
        int length = enumConstants.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Enum<?> r32 = enumConstants[length];
            map.put(r32.toString(), r32);
        }
        return new EnumResolver(cls, enumConstants, map, annotationIntrospector == null ? null : annotationIntrospector.findDefaultEnumValue(cls));
    }
}
