package r;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class f implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f18239a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f18240b;

    public f(View view, View view2) {
        this.f18239a = view;
        this.f18240b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        AlertController.c(absListView, this.f18239a, this.f18240b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
