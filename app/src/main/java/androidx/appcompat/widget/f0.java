package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton.java */
/* loaded from: classes.dex */
public final class f0 extends ToggleButton implements d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final e f1342b;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f1343m;

    /* renamed from: n, reason: collision with root package name */
    public n f1344n;

    public f0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1344n == null) {
            this.f1344n = new n(this);
        }
        return this.f1344n;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1342b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1343m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1342b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1342b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1343m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1343m.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1342b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1342b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1343m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1343m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1342b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1342b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1343m;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1343m;
        b0Var.l(mode);
        b0Var.b();
    }

    public f0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        e eVar = new e(this);
        this.f1342b = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1343m = b0Var;
        b0Var.f(attributeSet, i10);
        getEmojiTextViewHelper().b(attributeSet, i10);
    }
}
