package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class HashMapSupplier implements Callable<Map<Object, Object>> {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMapSupplier f14545b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ HashMapSupplier[] f14546m;

    static {
        HashMapSupplier hashMapSupplier = new HashMapSupplier();
        f14545b = hashMapSupplier;
        f14546m = new HashMapSupplier[]{hashMapSupplier};
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return f14545b;
    }

    public static HashMapSupplier valueOf(String str) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, str);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) f14546m.clone();
    }

    @Override // java.util.concurrent.Callable
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
