package m3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.internal.MDRootLayout;

/* compiled from: DialogBase.java */
/* loaded from: classes.dex */
public class a extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: b, reason: collision with root package name */
    public MDRootLayout f16099b;

    /* renamed from: m, reason: collision with root package name */
    public DialogInterface.OnShowListener f16100m;

    public a(Context context, int i10) {
        super(context, i10);
    }

    @Override // android.app.Dialog
    public View findViewById(int i10) {
        return this.f16099b.findViewById(i10);
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = this.f16100m;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(int i10) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f16100m = onShowListener;
    }

    public final void setOnShowListenerInternal() {
        super.setOnShowListener(this);
    }

    public final void setViewInternal(View view) {
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(View view) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }
}
