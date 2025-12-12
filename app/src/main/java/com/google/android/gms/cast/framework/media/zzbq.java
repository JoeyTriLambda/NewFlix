package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbq implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TracksChooserDialogFragment f6756b;

    public zzbq(TracksChooserDialogFragment tracksChooserDialogFragment) {
        this.f6756b = tracksChooserDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        TracksChooserDialogFragment tracksChooserDialogFragment = this.f6756b;
        AlertDialog alertDialog = tracksChooserDialogFragment.B0;
        if (alertDialog != null) {
            alertDialog.cancel();
            tracksChooserDialogFragment.B0 = null;
        }
    }
}
