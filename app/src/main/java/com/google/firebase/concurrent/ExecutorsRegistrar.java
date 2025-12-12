package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import k8.a;
import k8.c;
import k8.d;
import l8.b;
import l8.i;
import l8.n;
import l8.r;
import m8.g;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final n<ScheduledExecutorService> f9739a = new n<>(new i(2));

    /* renamed from: b, reason: collision with root package name */
    public static final n<ScheduledExecutorService> f9740b = new n<>(new i(3));

    /* renamed from: c, reason: collision with root package name */
    public static final n<ScheduledExecutorService> f9741c = new n<>(new i(4));

    /* renamed from: d, reason: collision with root package name */
    public static final n<ScheduledExecutorService> f9742d = new n<>(new i(5));

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b<?>> getComponents() {
        return Arrays.asList(b.builder(r.qualified(a.class, ScheduledExecutorService.class), r.qualified(a.class, ExecutorService.class), r.qualified(a.class, Executor.class)).factory(new g(0)).build(), b.builder(r.qualified(k8.b.class, ScheduledExecutorService.class), r.qualified(k8.b.class, ExecutorService.class), r.qualified(k8.b.class, Executor.class)).factory(new g(1)).build(), b.builder(r.qualified(c.class, ScheduledExecutorService.class), r.qualified(c.class, ExecutorService.class), r.qualified(c.class, Executor.class)).factory(new g(2)).build(), b.builder(r.qualified(d.class, Executor.class)).factory(new g(3)).build());
    }
}
