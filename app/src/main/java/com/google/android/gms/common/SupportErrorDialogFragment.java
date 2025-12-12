package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.n;
import androidx.fragment.app.y;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public class SupportErrorDialogFragment extends n {

    /* renamed from: x0, reason: collision with root package name */
    public Dialog f7042x0;

    /* renamed from: y0, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7043y0;

    /* renamed from: z0, reason: collision with root package name */
    public AlertDialog f7044z0;

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f7042x0 = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f7043y0 = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7043y0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.n
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f7042x0;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f7044z0 == null) {
            this.f7044z0 = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getContext())).create();
        }
        return this.f7044z0;
    }

    @Override // androidx.fragment.app.n
    public void show(y yVar, String str) {
        super.show(yVar, str);
    }
}
