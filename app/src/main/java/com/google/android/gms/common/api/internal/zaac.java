package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaac implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f7137a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zaad f7138b;

    public zaac(zaad zaadVar, TaskCompletionSource taskCompletionSource) {
        this.f7138b = zaadVar;
        this.f7137a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.f7138b.f7140b.remove(this.f7137a);
    }
}
