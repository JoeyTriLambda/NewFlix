package cd;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;
import com.afollestad.materialdialogs.MaterialDialog;

/* compiled from: NameFileDialog.java */
/* loaded from: classes2.dex */
public final class b extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    public c f5264b;

    /* renamed from: m, reason: collision with root package name */
    public EditText f5265m;

    /* compiled from: NameFileDialog.java */
    public class a extends MaterialDialog.d {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.d
        public void onNegative(MaterialDialog materialDialog) {
            materialDialog.dismiss();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.d
        public void onPositive(MaterialDialog materialDialog) {
            b bVar = b.this;
            c cVar = bVar.f5264b;
            if (cVar != null) {
                cVar.onReturnFileName(bVar.f5265m.getText().toString());
            }
            materialDialog.dismiss();
        }
    }

    public static b newInstance() {
        b bVar = new b();
        bVar.setCancelable(false);
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        try {
            this.f5264b = (c) activity;
        } catch (ClassCastException e10) {
            e10.printStackTrace();
        }
        super.onAttach(activity);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MaterialDialog.c cVar = new MaterialDialog.c(getActivity());
        cVar.title("New File");
        EditText editText = new EditText(getActivity());
        this.f5265m = editText;
        cVar.customView(editText, false);
        cVar.positiveText("Done");
        cVar.negativeText("Cancel");
        cVar.autoDismiss(false);
        cVar.callback(new a());
        return cVar.build();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        this.f5264b = null;
        super.onDetach();
    }
}
