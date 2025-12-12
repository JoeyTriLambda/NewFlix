package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class UiExecutor implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final UiExecutor f9757b;

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"ThreadPoolCreation"})
    public static final Handler f9758m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ UiExecutor[] f9759n;

    static {
        UiExecutor uiExecutor = new UiExecutor();
        f9757b = uiExecutor;
        f9759n = new UiExecutor[]{uiExecutor};
        f9758m = new Handler(Looper.getMainLooper());
    }

    public static UiExecutor valueOf(String str) {
        return (UiExecutor) Enum.valueOf(UiExecutor.class, str);
    }

    public static UiExecutor[] values() {
        return (UiExecutor[]) f9759n.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f9758m.post(runnable);
    }
}
