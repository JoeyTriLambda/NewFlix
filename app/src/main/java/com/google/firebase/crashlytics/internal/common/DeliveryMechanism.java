package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    /* JADX INFO: Fake field, exist only in values array */
    USER_SIDELOAD(2),
    /* JADX INFO: Fake field, exist only in values array */
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* renamed from: b, reason: collision with root package name */
    public final int f9768b;

    DeliveryMechanism(int i10) {
        this.f9768b = i10;
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int getId() {
        return this.f9768b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f9768b);
    }
}
