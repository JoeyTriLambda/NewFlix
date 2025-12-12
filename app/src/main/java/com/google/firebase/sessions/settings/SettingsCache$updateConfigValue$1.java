package com.google.firebase.sessions.settings;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SettingsCache.kt */
@d(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {112}, m = "updateConfigValue")
/* loaded from: classes.dex */
public final class SettingsCache$updateConfigValue$1<T> extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10027b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SettingsCache f10028m;

    /* renamed from: n, reason: collision with root package name */
    public int f10029n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$1(SettingsCache settingsCache, c<? super SettingsCache$updateConfigValue$1> cVar) {
        super(cVar);
        this.f10028m = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10027b = obj;
        this.f10029n |= Integer.MIN_VALUE;
        return this.f10028m.a(null, null, this);
    }
}
