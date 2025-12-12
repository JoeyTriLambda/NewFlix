package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zad {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> f8656a;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zaa zaaVar = new zaa();
        f8656a = zaaVar;
        zab zabVar = new zab();
        new Scope("profile");
        new Scope("email");
        new Api("SignIn.API", zaaVar, clientKey);
        new Api("SignIn.INTERNAL_API", zabVar, clientKey2);
    }
}
