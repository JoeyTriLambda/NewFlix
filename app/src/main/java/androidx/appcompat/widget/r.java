package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* loaded from: classes.dex */
public final class r extends MultiAutoCompleteTextView implements d1.l {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f1498o = {R.attr.popupBackground};

    /* renamed from: b, reason: collision with root package name */
    public final e f1499b;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f1500m;

    /* renamed from: n, reason: collision with root package name */
    public final m f1501n;

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1499b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1500m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1499b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1499b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1500m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1500m.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        c8.i.g(this, inputConnectionOnCreateInputConnection, editorInfo);
        return this.f1501n.f1446b.onCreateInputConnection(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1499b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1499b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1500m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1500m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(s.a.getDrawable(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1501n.f1446b.setEnabled(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1501n.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1499b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1499b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1500m;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1500m;
        b0Var.l(mode);
        b0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        b0 b0Var = this.f1500m;
        if (b0Var != null) {
            b0Var.g(context, i10);
        }
    }

    public r(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(getContext(), attributeSet, f1498o, i10, 0);
        if (c1VarObtainStyledAttributes.hasValue(0)) {
            setDropDownBackgroundDrawable(c1VarObtainStyledAttributes.getDrawable(0));
        }
        c1VarObtainStyledAttributes.recycle();
        e eVar = new e(this);
        this.f1499b = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1500m = b0Var;
        b0Var.f(attributeSet, i10);
        b0Var.b();
        m mVar = new m(this);
        this.f1501n = mVar;
        mVar.b(attributeSet, i10);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = isFocusable();
            boolean zIsClickable = isClickable();
            boolean zIsLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener keyListenerA = mVar.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            setRawInputType(inputType);
            setFocusable(zIsFocusable);
            setClickable(zIsClickable);
            setLongClickable(zIsLongClickable);
        }
    }
}
