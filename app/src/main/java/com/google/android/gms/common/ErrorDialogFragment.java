package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    public Dialog f7019b;

    /* renamed from: m, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7020m;

    /* renamed from: n, reason: collision with root package name */
    public AlertDialog f7021n;

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f7019b = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.f7020m = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7020m;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f7019b;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f7021n == null) {
            this.f7021n = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getActivity())).create();
        }
        return this.f7021n;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
