package com.google.firebase.sessions;

import d9.e;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public enum EventType implements e {
    /* JADX INFO: Fake field, exist only in values array */
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);


    /* renamed from: b, reason: collision with root package name */
    public final int f9878b;

    EventType(int i10) {
        this.f9878b = i10;
    }

    @Override // d9.e
    public int getNumber() {
        return this.f9878b;
    }
}
