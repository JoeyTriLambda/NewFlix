package com.google.android.gms.tasks;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzab implements Continuation {
    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(null);
        return Tasks.forResult(arrayList);
    }
}
