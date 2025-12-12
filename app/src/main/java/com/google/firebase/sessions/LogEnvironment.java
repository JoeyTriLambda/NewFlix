package com.google.firebase.sessions;

import d9.e;

/* compiled from: ApplicationInfo.kt */
/* loaded from: classes.dex */
public enum LogEnvironment implements e {
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_UNKNOWN(0),
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_AUTOPUSH(1),
    /* JADX INFO: Fake field, exist only in values array */
    LOG_ENVIRONMENT_STAGING(2),
    LOG_ENVIRONMENT_PROD(3);


    /* renamed from: b, reason: collision with root package name */
    public final int f9893b;

    LogEnvironment(int i10) {
        this.f9893b = i10;
    }

    @Override // d9.e
    public int getNumber() {
        return this.f9893b;
    }
}
