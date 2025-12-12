package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l1.a;
import lf.f;
import lf.h;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: SettingsCache.kt */
@d(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SettingsCache$updateConfigValue$2 extends SuspendLambda implements p<MutablePreferences, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10030b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ T f10031m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a.C0186a<T> f10032n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SettingsCache f10033o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsCache$updateConfigValue$2(SettingsCache settingsCache, a.C0186a c0186a, Object obj, c cVar) {
        super(2, cVar);
        this.f10031m = obj;
        this.f10032n = c0186a;
        this.f10033o = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(this.f10033o, this.f10032n, this.f10031m, cVar);
        settingsCache$updateConfigValue$2.f10030b = obj;
        return settingsCache$updateConfigValue$2;
    }

    @Override // yf.p
    public final Object invoke(MutablePreferences mutablePreferences, c<? super h> cVar) {
        return ((SettingsCache$updateConfigValue$2) create(mutablePreferences, cVar)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        MutablePreferences mutablePreferences = (MutablePreferences) this.f10030b;
        Object obj2 = this.f10032n;
        T t10 = this.f10031m;
        if (t10 != 0) {
            mutablePreferences.set(obj2, t10);
        } else {
            mutablePreferences.remove(obj2);
        }
        SettingsCache.access$updateSessionConfigs(this.f10033o, mutablePreferences);
        return h.f16056a;
    }
}
