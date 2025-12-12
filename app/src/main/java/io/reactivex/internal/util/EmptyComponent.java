package io.reactivex.internal.util;

import ff.a;
import ne.b;
import ne.f;
import ne.h;
import ne.q;
import ne.t;
import zh.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class EmptyComponent implements f<Object>, q<Object>, h<Object>, t<Object>, b, c, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public static final EmptyComponent f14538b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ EmptyComponent[] f14539m;

    static {
        EmptyComponent emptyComponent = new EmptyComponent();
        f14538b = emptyComponent;
        f14539m = new EmptyComponent[]{emptyComponent};
    }

    public static <T> q<T> asObserver() {
        return f14538b;
    }

    public static EmptyComponent valueOf(String str) {
        return (EmptyComponent) Enum.valueOf(EmptyComponent.class, str);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) f14539m.clone();
    }

    @Override // zh.b
    public void onError(Throwable th2) {
        a.onError(th2);
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        bVar.dispose();
    }

    @Override // zh.b
    public void onSubscribe(c cVar) {
        cVar.cancel();
    }

    @Override // zh.c
    public void cancel() {
    }

    @Override // qe.b
    public void dispose() {
    }

    @Override // zh.b
    public void onComplete() {
    }

    @Override // zh.b
    public void onNext(Object obj) {
    }

    @Override // ne.h
    public void onSuccess(Object obj) {
    }

    @Override // zh.c
    public void request(long j10) {
    }
}
