package ug;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kg.l;
import kg.m;
import kotlin.Result;
import lf.f;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class b<TResult> implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l<Object> f20378a;

    public b(m mVar) {
        this.f20378a = mVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Object> task) {
        Exception exception = task.getException();
        l<Object> lVar = this.f20378a;
        if (exception != null) {
            int i10 = Result.f15189m;
            lVar.resumeWith(Result.m59constructorimpl(f.createFailure(exception)));
        } else if (task.isCanceled()) {
            l.a.cancel$default(lVar, null, 1, null);
        } else {
            int i11 = Result.f15189m;
            lVar.resumeWith(Result.m59constructorimpl(task.getResult()));
        }
    }
}
