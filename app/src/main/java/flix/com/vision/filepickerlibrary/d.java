package flix.com.vision.filepickerlibrary;

import android.view.View;
import android.widget.Toast;
import flix.com.vision.filepickerlibrary.FilePickerActivity.d;
import java.io.File;

/* compiled from: FilePickerActivity.java */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePickerActivity f12306b;

    public d(FilePickerActivity filePickerActivity) {
        this.f12306b = filePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FilePickerActivity filePickerActivity = this.f12306b;
        if (!filePickerActivity.f12292w.isDirectory()) {
            Toast.makeText(filePickerActivity.getBaseContext(), "Please use the Select button to Load Subtitles or Playlists", 1).show();
            return;
        }
        File file = filePickerActivity.f12292w;
        filePickerActivity.f12289t = file;
        filePickerActivity.f12285p.setText(file.getName());
        filePickerActivity.new d(filePickerActivity).execute(filePickerActivity.f12289t);
    }
}
