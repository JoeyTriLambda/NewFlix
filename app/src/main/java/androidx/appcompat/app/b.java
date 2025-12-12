package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController.java */
/* loaded from: classes.dex */
public final class b implements AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController f901b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f902m;

    public b(AlertController.b bVar, AlertController alertController) {
        this.f902m = bVar;
        this.f901b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AlertController.b bVar = this.f902m;
        DialogInterface.OnClickListener onClickListener = bVar.f891o;
        AlertController alertController = this.f901b;
        onClickListener.onClick(alertController.f849b, i10);
        if (bVar.f895s) {
            return;
        }
        alertController.f849b.dismiss();
    }
}
