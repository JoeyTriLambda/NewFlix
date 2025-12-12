package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f2771b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2772m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ m f2773n;

    public d(m mVar, ArrayList arrayList, SpecialEffectsController.Operation operation) {
        this.f2773n = mVar;
        this.f2771b = arrayList;
        this.f2772m = operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list = this.f2771b;
        SpecialEffectsController.Operation operation = this.f2772m;
        if (list.contains(operation)) {
            list.remove(operation);
            this.f2773n.getClass();
            operation.getFinalState().a(operation.getFragment().S);
        }
    }
}
