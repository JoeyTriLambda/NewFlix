package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import v0.d;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements d1.l {

    /* renamed from: b, reason: collision with root package name */
    public final e f1113b;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f1114m;

    /* renamed from: n, reason: collision with root package name */
    public final a0 f1115n;

    /* renamed from: o, reason: collision with root package name */
    public n f1116o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1117p;

    /* renamed from: q, reason: collision with root package name */
    public b f1118q;

    /* renamed from: r, reason: collision with root package name */
    public Future<v0.d> f1119r;

    public interface a {
        void setFirstBaselineToTopHeight(int i10);

        void setLastBaselineToBottomHeight(int i10);
    }

    public class c extends b {
        public c() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void setFirstBaselineToTopHeight(int i10) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void setLastBaselineToBottomHeight(int i10) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i10);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1116o == null) {
            this.f1116o = new n(this);
        }
        return this.f1116o;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1113b;
        if (eVar != null) {
            eVar.a();
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (k1.f1426b) {
            return ((b) getSuperCaller()).getAutoSizeMaxTextSize();
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1303e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (k1.f1426b) {
            return ((b) getSuperCaller()).getAutoSizeMinTextSize();
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1302d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (k1.f1426b) {
            return ((b) getSuperCaller()).getAutoSizeStepGranularity();
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            return Math.round(b0Var.f1262i.f1301c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (k1.f1426b) {
            return ((b) getSuperCaller()).getAutoSizeTextAvailableSizes();
        }
        b0 b0Var = this.f1114m;
        return b0Var != null ? b0Var.f1262i.f1304f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (k1.f1426b) {
            return ((b) getSuperCaller()).getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            return b0Var.f1262i.f1299a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d1.i.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return d1.i.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return d1.i.getLastBaselineToBottomHeight(this);
    }

    public a getSuperCaller() {
        if (this.f1118q == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                this.f1118q = new c();
            } else if (i10 >= 26) {
                this.f1118q = new b();
            }
        }
        return this.f1118q;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1113b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1113b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1114m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1114m.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future<v0.d> future = this.f1119r;
        if (future != null) {
            try {
                this.f1119r = null;
                d1.i.setPrecomputedText(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        a0 a0Var;
        return (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f1115n) == null) ? ((b) getSuperCaller()).getTextClassifier() : a0Var.getTextClassifier();
    }

    public d.a getTextMetricsParamsCompat() {
        return d1.i.getTextMetricsParams(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1114m.getClass();
        if (Build.VERSION.SDK_INT < 30 && inputConnectionOnCreateInputConnection != null) {
            c1.b.setInitialSurroundingText(editorInfo, getText());
        }
        c8.i.g(this, inputConnectionOnCreateInputConnection, editorInfo);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b0 b0Var = this.f1114m;
        if (b0Var == null || k1.f1426b) {
            return;
        }
        b0Var.f1262i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        Future<v0.d> future = this.f1119r;
        if (future != null) {
            try {
                this.f1119r = null;
                d1.i.setPrecomputedText(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        boolean z10 = false;
        b0 b0Var = this.f1114m;
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
            ((b) getSuperCaller()).setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.h(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (k1.f1426b) {
            ((b) getSuperCaller()).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.i(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (k1.f1426b) {
            ((b) getSuperCaller()).setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.j(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1113b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1113b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b0 b0Var = this.f1114m;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setFirstBaselineToTopHeight(i10);
        } else {
            d1.i.setFirstBaselineToTopHeight(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().setLastBaselineToBottomHeight(i10);
        } else {
            d1.i.setLastBaselineToBottomHeight(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10) {
        d1.i.setLineHeight(this, i10);
    }

    public void setPrecomputedText(v0.d dVar) {
        d1.i.setPrecomputedText(this, dVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1113b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1113b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f1114m;
        b0Var.k(colorStateList);
        b0Var.b();
    }

    @Override // d1.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f1114m;
        b0Var.l(mode);
        b0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.g(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        a0 a0Var;
        if (Build.VERSION.SDK_INT >= 28 || (a0Var = this.f1115n) == null) {
            ((b) getSuperCaller()).setTextClassifier(textClassifier);
        } else {
            a0Var.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<v0.d> future) {
        this.f1119r = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(d.a aVar) {
        d1.i.setTextMetricsParams(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        boolean z10 = k1.f1426b;
        if (z10) {
            super.setTextSize(i10, f10);
            return;
        }
        b0 b0Var = this.f1114m;
        if (b0Var == null || z10) {
            return;
        }
        d0 d0Var = b0Var.f1262i;
        if (d0Var.i() && d0Var.f1299a != 0) {
            return;
        }
        d0Var.f(f10, i10);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i10) {
        if (this.f1117p) {
            return;
        }
        Typeface typefaceCreate = (typeface == null || i10 <= 0) ? null : o0.e.create(getContext(), typeface, i10);
        this.f1117p = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i10);
        } finally {
            this.f1117p = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        this.f1117p = false;
        this.f1118q = null;
        x0.checkAppCompatTheme(this, getContext());
        e eVar = new e(this);
        this.f1113b = eVar;
        eVar.d(attributeSet, i10);
        b0 b0Var = new b0(this);
        this.f1114m = b0Var;
        b0Var.f(attributeSet, i10);
        b0Var.b();
        this.f1115n = new a0(this);
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i10 != 0 ? s.a.getDrawable(context, i10) : null, i11 != 0 ? s.a.getDrawable(context, i11) : null, i12 != 0 ? s.a.getDrawable(context, i12) : null, i13 != 0 ? s.a.getDrawable(context, i13) : null);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i10 != 0 ? s.a.getDrawable(context, i10) : null, i11 != 0 ? s.a.getDrawable(context, i11) : null, i12 != 0 ? s.a.getDrawable(context, i12) : null, i13 != 0 ? s.a.getDrawable(context, i13) : null);
        b0 b0Var = this.f1114m;
        if (b0Var != null) {
            b0Var.b();
        }
    }

    public class b implements a {
        public b() {
        }

        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        public int getAutoSizeTextType() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        public TextClassifier getTextClassifier() {
            return AppCompatTextView.super.getTextClassifier();
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public void setAutoSizeTextTypeWithDefaults(int i10) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i10);
        }

        public void setTextClassifier(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void setFirstBaselineToTopHeight(int i10) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void setLastBaselineToBottomHeight(int i10) {
        }
    }
}
