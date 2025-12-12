package rg;

import java.util.concurrent.TimeUnit;
import pg.c0;
import pg.e0;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18961a = c0.systemProp("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public static final long f18962b = e0.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, (Object) null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f18963c = e0.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", fg.h.coerceAtLeast(c0.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f18964d = e0.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: e, reason: collision with root package name */
    public static final long f18965e = TimeUnit.SECONDS.toNanos(e0.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null));

    /* renamed from: f, reason: collision with root package name */
    public static final d f18966f = d.f18955a;

    /* renamed from: g, reason: collision with root package name */
    public static final i f18967g = new i(0);

    /* renamed from: h, reason: collision with root package name */
    public static final i f18968h = new i(1);
}
