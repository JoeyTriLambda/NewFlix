package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import se.n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ArrayListSupplier implements Callable<List<Object>>, n<Object, List<Object>> {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayListSupplier f14536b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ ArrayListSupplier[] f14537m;

    static {
        ArrayListSupplier arrayListSupplier = new ArrayListSupplier();
        f14536b = arrayListSupplier;
        f14537m = new ArrayListSupplier[]{arrayListSupplier};
    }

    public static <T> Callable<List<T>> asCallable() {
        return f14536b;
    }

    public static <T, O> n<O, List<T>> asFunction() {
        return f14536b;
    }

    public static ArrayListSupplier valueOf(String str) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, str);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) f14537m.clone();
    }

    @Override // se.n
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
