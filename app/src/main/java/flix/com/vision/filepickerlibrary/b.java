package flix.com.vision.filepickerlibrary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.FilePicker.f;
import java.io.File;

/* compiled from: FilePicker.java */
/* loaded from: classes2.dex */
public final class b implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePicker f12304b;

    public b(FilePicker filePicker) {
        this.f12304b = filePicker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FilePicker filePicker = this.f12304b;
        if (filePicker.V.isDirectory()) {
            File file = filePicker.V;
            filePicker.S = file;
            filePicker.K.setTitle(file.getName());
            filePicker.new f(filePicker).execute(filePicker.S);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (filePicker.V.toString() == null) {
            Snackbar.make(filePicker.getWindow().getDecorView(), R.string.file_picker_snackbar_no_read_type, -1).show();
            return;
        }
        intent.setDataAndType(Uri.fromFile(filePicker.V), filePicker.Z);
        intent.setFlags(268435456);
        try {
            filePicker.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Snackbar.make(filePicker.getWindow().getDecorView(), R.string.file_picker_snackbar_no_file_type_handler, -1).show();
        }
    }
}
