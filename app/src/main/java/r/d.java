package r;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class d implements NestedScrollView.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f18194a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f18195b;

    public d(View view, View view2) {
        this.f18194a = view;
        this.f18195b = view2;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        AlertController.c(nestedScrollView, this.f18194a, this.f18195b);
    }
}
