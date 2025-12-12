package r;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f18241b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f18242m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AlertController f18243n;

    public g(AlertController alertController, View view, View view2) {
        this.f18243n = alertController;
        this.f18241b = view;
        this.f18242m = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.c(this.f18243n.f854g, this.f18241b, this.f18242m);
    }
}
