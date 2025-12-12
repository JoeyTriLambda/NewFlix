package com.google.gson;

import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.lang3.ClassUtils;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class FieldNamingPolicy implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final FieldNamingPolicy f10034b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ FieldNamingPolicy[] f10035m;

    static {
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.1
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return field.getName();
            }
        };
        f10034b = fieldNamingPolicy;
        f10035m = new FieldNamingPolicy[]{fieldNamingPolicy, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.2
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.b(field.getName());
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.3
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.b(FieldNamingPolicy.a(field.getName(), TokenParser.SP));
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.4
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.a(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.5
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.6
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.a(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        }, new FieldNamingPolicy() { // from class: com.google.gson.FieldNamingPolicy.7
            @Override // com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.a(field.getName(), ClassUtils.PACKAGE_SEPARATOR_CHAR).toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public FieldNamingPolicy() {
        throw null;
    }

    public FieldNamingPolicy(String str, int i10) {
    }

    public static String a(String str, char c10) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c10);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String b(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f10035m.clone();
    }
}
