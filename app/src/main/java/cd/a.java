package cd;

import android.view.View;
import flix.com.vision.filepickerlibrary.FilePickerActivity;

/* compiled from: FilePickerActivity.java */
/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePickerActivity f5263b;

    public a(FilePickerActivity filePickerActivity) {
        this.f5263b = filePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.newInstance().show(this.f5263b.getFragmentManager(), "NameDialog");
    }
}
