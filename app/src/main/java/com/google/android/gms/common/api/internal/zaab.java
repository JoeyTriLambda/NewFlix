package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaab implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f7135a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zaad f7136b;

    public zaab(zaad zaadVar, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f7136b = zaadVar;
        this.f7135a = apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.f7136b.f7139a.remove(this.f7135a);
    }
}
