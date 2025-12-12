package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import r.u;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class d extends u implements DialogInterface {

    /* renamed from: q, reason: collision with root package name */
    public final AlertController f906q;

    /* compiled from: AlertDialog.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.b f907a;

        /* renamed from: b, reason: collision with root package name */
        public final int f908b;

        public a(Context context) {
            this(context, d.c(context, 0));
        }

        public d create() {
            AlertController.b bVar = this.f907a;
            d dVar = new d(bVar.f877a, this.f908b);
            bVar.apply(dVar.f906q);
            dVar.setCancelable(bVar.f886j);
            if (bVar.f886j) {
                dVar.setCanceledOnTouchOutside(true);
            }
            bVar.getClass();
            dVar.setOnCancelListener(null);
            dVar.setOnDismissListener(bVar.f887k);
            DialogInterface.OnKeyListener onKeyListener = bVar.f888l;
            if (onKeyListener != null) {
                dVar.setOnKeyListener(onKeyListener);
            }
            return dVar;
        }

        public Context getContext() {
            return this.f907a.f877a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f890n = listAdapter;
            bVar.f891o = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.f907a.f881e = view;
            return this;
        }

        public a setIcon(Drawable drawable) {
            this.f907a.f879c = drawable;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f889m = charSequenceArr;
            bVar.f897u = onMultiChoiceClickListener;
            bVar.f893q = zArr;
            bVar.f894r = true;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f884h = charSequence;
            bVar.f885i = onClickListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f907a.f887k = onDismissListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f907a.f888l = onKeyListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f882f = charSequence;
            bVar.f883g = onClickListener;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f889m = charSequenceArr;
            bVar.f891o = onClickListener;
            bVar.f896t = i10;
            bVar.f895s = true;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.f907a.f880d = charSequence;
            return this;
        }

        public a setView(View view) {
            this.f907a.f892p = view;
            return this;
        }

        public d show() {
            d dVarCreate = create();
            dVarCreate.show();
            return dVarCreate;
        }

        public a(Context context, int i10) {
            this.f907a = new AlertController.b(new ContextThemeWrapper(context, d.c(context, i10)));
            this.f908b = i10;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f907a;
            bVar.f890n = listAdapter;
            bVar.f891o = onClickListener;
            bVar.f896t = i10;
            bVar.f895s = true;
            return this;
        }
    }

    public d(Context context, int i10) {
        super(context, c(context, i10));
        this.f906q = new AlertController(getContext(), this, getWindow());
    }

    public static int c(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.f906q.getListView();
    }

    @Override // r.u, androidx.activity.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f906q.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f906q.onKeyDown(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f906q.onKeyUp(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f906q.setButton(i10, charSequence, onClickListener, null, null);
    }

    public void setIcon(int i10) {
        this.f906q.setIcon(i10);
    }

    public void setMessage(CharSequence charSequence) {
        this.f906q.setMessage(charSequence);
    }

    @Override // r.u, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f906q.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f906q.setView(view);
    }
}
