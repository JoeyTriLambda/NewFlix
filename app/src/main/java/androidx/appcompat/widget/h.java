package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R;

/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public final class h extends CheckedTextView implements d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final i f1351b;

    /* renamed from: m, reason: collision with root package name */
    public final e f1352m;

    /* renamed from: n, reason: collision with root package name */
    public final b0 f1353n;

    /* renamed from: o, reason: collision with root package name */
    public n f1354o;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1354o == null) {
            this.f1354o = new n(this);
        }
        return this.f1354o;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f1353n;
        if (b0Var != null) {
            b0Var.b();
        }
        e eVar = this.f1352m;
        if (eVar != null) {
            eVar.a();
        }
        i iVar = this.f1351b;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d1.i.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1352m;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1352m;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        i iVar = this.f1351b;
        if (iVar != null) {
            return iVar.f1368b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        i iVar = this.f1351b;
        if (iVar != null) {
            return iVar.f1369c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1353n.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1353n.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        c8.i.g(this, inputConnectionOnCreateInputConnection, editorInfo);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1352m;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1352m;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        i iVar = this.f1351b;
        if (iVar != null) {
            if (iVar.f1372f) {
                iVar.f1372f = false;
            } else {
                iVar.f1372f = true;
                iVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1353n;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1353n;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1352m;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1352m;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        i iVar = this.f1351b;
        if (iVar != null) {
            iVar.f1368b = colorStateList;
            iVar.f1370d = true;
            iVar.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1351b;
        if (iVar != null) {
            iVar.f1369c = mode;
            iVar.f1371e = true;
            iVar.a();
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1353n;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1353n;
        b0Var.l(mode);
        b0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        b0 b0Var = this.f1353n;
        if (b0Var != null) {
            b0Var.g(context, i10);
        }
    }

    public h(Context context, AttributeSet attributeSet, int i10) {
        boolean z10;
        int resourceId;
        int resourceId2;
        super(z0.wrap(context), attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        b0 b0Var = new b0(this);
        this.f1353n = b0Var;
        b0Var.f(attributeSet, i10);
        b0Var.b();
        e eVar = new e(this);
        this.f1352m = eVar;
        eVar.d(attributeSet, i10);
        this.f1351b = new i(this);
        Context context2 = getContext();
        int[] iArr = R.styleable.CheckedTextView;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context2, attributeSet, iArr, i10, 0);
        x0.j0.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            int i11 = R.styleable.CheckedTextView_checkMarkCompat;
            if (!c1VarObtainStyledAttributes.hasValue(i11) || (resourceId2 = c1VarObtainStyledAttributes.getResourceId(i11, 0)) == 0) {
                z10 = false;
            } else {
                try {
                    setCheckMarkDrawable(s.a.getDrawable(getContext(), resourceId2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z10) {
                int i12 = R.styleable.CheckedTextView_android_checkMark;
                if (c1VarObtainStyledAttributes.hasValue(i12) && (resourceId = c1VarObtainStyledAttributes.getResourceId(i12, 0)) != 0) {
                    setCheckMarkDrawable(s.a.getDrawable(getContext(), resourceId));
                }
            }
            int i13 = R.styleable.CheckedTextView_checkMarkTint;
            if (c1VarObtainStyledAttributes.hasValue(i13)) {
                d1.b.setCheckMarkTintList(this, c1VarObtainStyledAttributes.getColorStateList(i13));
            }
            int i14 = R.styleable.CheckedTextView_checkMarkTintMode;
            if (c1VarObtainStyledAttributes.hasValue(i14)) {
                d1.b.setCheckMarkTintMode(this, i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i14, -1), null));
            }
            c1VarObtainStyledAttributes.recycle();
            getEmojiTextViewHelper().b(attributeSet, i10);
        } catch (Throwable th2) {
            c1VarObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(s.a.getDrawable(getContext(), i10));
    }
}
