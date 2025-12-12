package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2862b;

    public k(ArrayList arrayList) {
        this.f2862b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        h0.a(4, this.f2862b);
    }
}
