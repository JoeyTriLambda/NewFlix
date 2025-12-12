package flix.com.vision.filepickerlibrary;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import com.google.android.material.snackbar.Snackbar;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.FilePickerActivity.d;
import flix.com.vision.filepickerlibrary.enums.Request;

/* compiled from: FilePickerActivity.java */
/* loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePickerActivity f12305b;

    public c(FilePickerActivity filePickerActivity) {
        this.f12305b = filePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String lowerCase;
        FilePickerActivity filePickerActivity = this.f12305b;
        if (filePickerActivity.B == Request.DIRECTORY) {
            if (!filePickerActivity.f12292w.isDirectory()) {
                Snackbar.make(filePickerActivity.getWindow().getDecorView(), R.string.file_picker_snackbar_select_directory_message, -1).show();
                return;
            }
            filePickerActivity.f12289t = filePickerActivity.f12292w;
            Intent intent = new Intent();
            filePickerActivity.C = intent;
            intent.putExtra("fileExtraPath", filePickerActivity.f12292w.getAbsolutePath());
            filePickerActivity.setResult(-1, filePickerActivity.C);
            filePickerActivity.finish();
            return;
        }
        if (filePickerActivity.f12292w.isDirectory()) {
            filePickerActivity.f12289t = filePickerActivity.f12292w;
            filePickerActivity.new d(filePickerActivity).execute(filePickerActivity.f12289t);
            return;
        }
        if (TextUtils.isEmpty(filePickerActivity.A)) {
            Intent intent2 = new Intent();
            filePickerActivity.C = intent2;
            intent2.putExtra("fileExtraPath", filePickerActivity.f12292w.getAbsolutePath());
            filePickerActivity.setResult(-1, filePickerActivity.C);
            filePickerActivity.finish();
            return;
        }
        String str = "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(filePickerActivity.A);
        String string = filePickerActivity.f12292w.toString();
        if (string.indexOf("?") > -1) {
            string = string.substring(0, string.indexOf("?"));
        }
        if (string.lastIndexOf(".") == -1) {
            lowerCase = null;
        } else {
            String strSubstring = string.substring(string.lastIndexOf("."));
            if (strSubstring.indexOf("%") > -1) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf("%"));
            }
            if (strSubstring.indexOf("/") > -1) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf("/"));
            }
            lowerCase = strSubstring.toLowerCase();
        }
        if (!str.equalsIgnoreCase(lowerCase)) {
            Snackbar.make(filePickerActivity.getWindow().getDecorView(), String.format(filePickerActivity.getString(R.string.file_picker_snackbar_select_file_ext_message), str), -1).show();
            return;
        }
        Intent intent3 = new Intent();
        filePickerActivity.C = intent3;
        intent3.putExtra("fileExtraPath", filePickerActivity.f12292w.getAbsolutePath());
        filePickerActivity.setResult(-1, filePickerActivity.C);
        filePickerActivity.finish();
    }
}
