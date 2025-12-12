package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R;

/* compiled from: AppCompatButton.java */
/* loaded from: classes.dex */
public class f extends Button implements d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final e f1339b;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f1340m;

    /* renamed from: n, reason: collision with root package name */
    public n f1341n;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1341n == null) {
            this.f1341n = new n(this);
        }
        return this.f1341n;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1339b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (k1.f1426b) {
            return super.getAutoSizeMaxTextSize();
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1303e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (k1.f1426b) {
            return super.getAutoSizeMinTextSize();
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1302d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (k1.f1426b) {
            return super.getAutoSizeStepGranularity();
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1301c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (k1.f1426b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        b0 b0Var = this.f1340m;
        return b0Var != null ? b0Var.f1262i.f1304f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (k1.f1426b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            return b0Var.f1262i.f1299a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d1.i.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1339b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1339b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1340m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1340m.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b0 b0Var = this.f1340m;
        if (b0Var == null || k1.f1426b) {
            return;
        }
        b0Var.f1262i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        boolean z10 = false;
        b0 b0Var = this.f1340m;
        if (b0Var != null && !k1.f1426b) {
            d0 d0Var = b0Var.f1262i;
            if (d0Var.i() && d0Var.f1299a != 0) {
                z10 = true;
            }
        }
        if (z10) {
            b0Var.f1262i.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (k1.f1426b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.h(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (k1.f1426b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.i(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (k1.f1426b) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.j(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1339b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1339b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.f1254a.setAllCaps(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1339b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1339b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1340m;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1340m;
        b0Var.l(mode);
        b0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        b0 b0Var = this.f1340m;
        if (b0Var != null) {
            b0Var.g(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        boolean z10 = k1.f1426b;
        if (z10) {
            super.setTextSize(i10, f10);
            return;
        }
        b0 b0Var = this.f1340m;
        if (b0Var == null || z10) {
            return;
        }
        d0 d0Var = b0Var.f1262i;
        if (d0Var.i() && d0Var.f1299a != 0) {
            return;
        }
        d0Var.f(f10, i10);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        e eVar = new e(this);
        this.f1339b = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1340m = b0Var;
        b0Var.f(attributeSet, i10);
        b0Var.b();
        getEmojiTextViewHelper().b(attributeSet, i10);
    }
}
