package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class EnumValues implements Serializable {
    private static final long serialVersionUID = 1;
    private transient EnumMap<?, SerializableString> _asMap;
    private final Class<Enum<?>> _enumClass;
    private final SerializableString[] _textual;
    private final Enum<?>[] _values;

    private EnumValues(Class<Enum<?>> cls, SerializableString[] serializableStringArr) {
        this._enumClass = cls;
        this._values = cls.getEnumConstants();
        this._textual = serializableStringArr;
    }

    public static EnumValues construct(SerializationConfig serializationConfig, Class<Enum<?>> cls) {
        return serializationConfig.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING) ? constructFromToString(serializationConfig, cls) : constructFromName(serializationConfig, cls);
    }

    public static EnumValues constructFromName(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Class<? extends Enum<?>> clsFindEnumType = ClassUtil.findEnumType(cls);
        Enum<?>[] enumArr = (Enum[]) clsFindEnumType.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class ".concat(cls.getName()));
        }
        String[] strArrFindEnumValues = mapperConfig.getAnnotationIntrospector().findEnumValues(clsFindEnumType, enumArr, new String[enumArr.length]);
        SerializableString[] serializableStringArr = new SerializableString[enumArr.length];
        int length = enumArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Enum<?> r52 = enumArr[i10];
            String strName = strArrFindEnumValues[i10];
            if (strName == null) {
                strName = r52.name();
            }
            serializableStringArr[r52.ordinal()] = mapperConfig.compileString(strName);
        }
        return new EnumValues(cls, serializableStringArr);
    }

    public static EnumValues constructFromToString(MapperConfig<?> mapperConfig, Class<Enum<?>> cls) {
        Enum[] enumArr = (Enum[]) ClassUtil.findEnumType(cls).getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class ".concat(cls.getName()));
        }
        SerializableString[] serializableStringArr = new SerializableString[enumArr.length];
        for (Enum r42 : enumArr) {
            serializableStringArr[r42.ordinal()] = mapperConfig.compileString(r42.toString());
        }
        return new EnumValues(cls, serializableStringArr);
    }

    public List<Enum<?>> enums() {
        return Arrays.asList(this._values);
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public EnumMap<?, SerializableString> internalMap() {
        EnumMap<?, SerializableString> enumMap = this._asMap;
        if (enumMap != null) {
            return enumMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Enum<?> r42 : this._values) {
            linkedHashMap.put(r42, this._textual[r42.ordinal()]);
        }
        return new EnumMap<>(linkedHashMap);
    }

    public SerializableString serializedValueFor(Enum<?> r22) {
        return this._textual[r22.ordinal()];
    }

    public Collection<SerializableString> values() {
        return Arrays.asList(this._textual);
    }
}
