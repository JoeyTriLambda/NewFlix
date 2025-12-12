package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class c implements AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController.RecycleListView f903b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AlertController f904m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f905n;

    public c(AlertController.b bVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f905n = bVar;
        this.f903b = recycleListView;
        this.f904m = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AlertController.b bVar = this.f905n;
        boolean[] zArr = bVar.f893q;
        AlertController.RecycleListView recycleListView = this.f903b;
        if (zArr != null) {
            zArr[i10] = recycleListView.isItemChecked(i10);
        }
        bVar.f897u.onClick(this.f904m.f849b, i10, recycleListView.isItemChecked(i10));
    }
}
