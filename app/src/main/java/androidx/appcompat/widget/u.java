package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R;

/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class u extends RadioButton implements d1.k, d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final j f1522b;

    /* renamed from: m, reason: collision with root package name */
    public final e f1523m;

    /* renamed from: n, reason: collision with root package name */
    public final b0 f1524n;

    /* renamed from: o, reason: collision with root package name */
    public n f1525o;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1525o == null) {
            this.f1525o = new n(this);
        }
        return this.f1525o;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1523m;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1524n;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        j jVar = this.f1522b;
        if (jVar != null) {
            jVar.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1523m;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1523m;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // d1.k
    public ColorStateList getSupportButtonTintList() {
        j jVar = this.f1522b;
        if (jVar != null) {
            return jVar.f1390b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        j jVar = this.f1522b;
        if (jVar != null) {
            return jVar.f1391c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1524n.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1524n.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1523m;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1523m;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) throws NoSuchFieldException, SecurityException {
        super.setButtonDrawable(drawable);
        j jVar = this.f1522b;
        if (jVar != null) {
            if (jVar.f1394f) {
                jVar.f1394f = false;
            } else {
                jVar.f1394f = true;
                jVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1524n;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1524n;
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
        e eVar = this.f1523m;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1523m;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.k
    public void setSupportButtonTintList(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        j jVar = this.f1522b;
        if (jVar != null) {
            jVar.f1390b = colorStateList;
            jVar.f1392d = true;
            jVar.a();
        }
    }

    @Override // d1.k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        j jVar = this.f1522b;
        if (jVar != null) {
            jVar.f1391c = mode;
            jVar.f1393e = true;
            jVar.a();
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1524n;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1524n;
        b0Var.l(mode);
        b0Var.b();
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        j jVar = new j(this);
        this.f1522b = jVar;
        jVar.b(attributeSet, i10);
        e eVar = new e(this);
        this.f1523m = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1524n = b0Var;
        b0Var.f(attributeSet, i10);
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) throws NoSuchFieldException, SecurityException {
        setButtonDrawable(s.a.getDrawable(getContext(), i10));
    }
}
