package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class LongSerializationPolicy {

    /* renamed from: b, reason: collision with root package name */
    public static final LongSerializationPolicy f10036b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ LongSerializationPolicy[] f10037m;

    static {
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.1
        };
        f10036b = longSerializationPolicy;
        f10037m = new LongSerializationPolicy[]{longSerializationPolicy, new LongSerializationPolicy() { // from class: com.google.gson.LongSerializationPolicy.2
        }};
    }

    public LongSerializationPolicy() {
        throw null;
    }

    public LongSerializationPolicy(String str, int i10) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f10037m.clone();
    }
}
