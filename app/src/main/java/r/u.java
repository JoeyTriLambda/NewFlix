package r;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import w.b;
import x0.i;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class u extends androidx.activity.h implements k {

    /* renamed from: o, reason: collision with root package name */
    public m f18328o;

    /* renamed from: p, reason: collision with root package name */
    public final t f18329p;

    /* JADX WARN: Type inference failed for: r1v2, types: [r.t] */
    public u(Context context, int i10) {
        int i11;
        if (i10 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i11 = typedValue.resourceId;
        } else {
            i11 = i10;
        }
        super(context, i11);
        this.f18329p = new i.a() { // from class: r.t
            @Override // x0.i.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f18327b.b(keyEvent);
            }
        };
        m delegate = getDelegate();
        if (i10 == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            i10 = typedValue2.resourceId;
        }
        delegate.setTheme(i10);
        delegate.onCreate(null);
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    final boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return x0.i.dispatchKeyEvent(this.f18329p, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().findViewById(i10);
    }

    public m getDelegate() {
        if (this.f18328o == null) {
            this.f18328o = m.create(this, this);
        }
        return this.f18328o;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().installViewFactory();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // r.k
    public w.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void setContentView(int i10) {
        getDelegate().setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().requestWindowFeature(i10);
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.h, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().setTitle(getContext().getString(i10));
    }

    @Override // r.k
    public void onSupportActionModeFinished(w.b bVar) {
    }

    @Override // r.k
    public void onSupportActionModeStarted(w.b bVar) {
    }
}
