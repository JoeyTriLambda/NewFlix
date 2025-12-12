package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: b, reason: collision with root package name */
    public final int f7030b;

    public GooglePlayServicesRepairableException(int i10, String str, Intent intent) {
        super(str, intent);
        this.f7030b = i10;
    }

    public int getConnectionStatusCode() {
        return this.f7030b;
    }
}
