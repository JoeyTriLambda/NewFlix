package flix.com.vision.filepickerlibrary;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import com.google.android.material.snackbar.Snackbar;
import flix.com.vision.R;
import flix.com.vision.filepickerlibrary.FilePicker.f;
import flix.com.vision.filepickerlibrary.enums.Request;

/* compiled from: FilePicker.java */
/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePicker f12303b;

    public a(FilePicker filePicker) {
        this.f12303b = filePicker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String lowerCase;
        FilePicker filePicker = this.f12303b;
        if (filePicker.f12268a0 == Request.DIRECTORY) {
            if (!filePicker.V.isDirectory()) {
                Snackbar.make(filePicker.getWindow().getDecorView(), R.string.file_picker_snackbar_select_directory_message, -1).show();
                return;
            }
            filePicker.S = filePicker.V;
            Intent intent = new Intent();
            filePicker.f12269b0 = intent;
            intent.putExtra("fileExtraPath", filePicker.V.getAbsolutePath());
            filePicker.setResult(-1, filePicker.f12269b0);
            filePicker.finish();
            return;
        }
        if (filePicker.V.isDirectory()) {
            filePicker.S = filePicker.V;
            filePicker.new f(filePicker).execute(filePicker.S);
            return;
        }
        if (TextUtils.isEmpty(filePicker.Z)) {
            Intent intent2 = new Intent();
            filePicker.f12269b0 = intent2;
            intent2.putExtra("fileExtraPath", filePicker.V.getAbsolutePath());
            filePicker.setResult(-1, filePicker.f12269b0);
            filePicker.finish();
            return;
        }
        String str = "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(filePicker.Z);
        String string = filePicker.V.toString();
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
            Snackbar.make(filePicker.getWindow().getDecorView(), String.format(filePicker.getString(R.string.file_picker_snackbar_select_file_ext_message), str), -1).show();
            return;
        }
        Intent intent3 = new Intent();
        filePicker.f12269b0 = intent3;
        intent3.putExtra("fileExtraPath", filePicker.V.getAbsolutePath());
        filePicker.setResult(-1, filePicker.f12269b0);
        filePicker.finish();
    }
}
