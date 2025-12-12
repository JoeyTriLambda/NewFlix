package com.google.firebase.sessions;

import d9.e;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public enum DataCollectionState implements e {
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_DISABLED_REMOTE(4),
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION_SAMPLED(5);


    /* renamed from: b, reason: collision with root package name */
    public final int f9875b;

    DataCollectionState(int i10) {
        this.f9875b = i10;
    }

    @Override // d9.e
    public int getNumber() {
        return this.f9875b;
    }
}
