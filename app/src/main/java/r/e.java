package r;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f18202b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f18203m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AlertController f18204n;

    public e(AlertController alertController, View view, View view2) {
        this.f18204n = alertController;
        this.f18202b = view;
        this.f18203m = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.f18204n.f870w, this.f18202b, this.f18203m);
    }
}
