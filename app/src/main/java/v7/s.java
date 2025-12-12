package v7;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c1;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import i7.t;
import x0.j0;

/* compiled from: StartCompoundLayout.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class s extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f20609b;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f20610m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f20611n;

    /* renamed from: o, reason: collision with root package name */
    public final CheckableImageButton f20612o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f20613p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f20614q;

    /* renamed from: r, reason: collision with root package name */
    public int f20615r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView.ScaleType f20616s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnLongClickListener f20617t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f20618u;

    public s(TextInputLayout textInputLayout, c1 c1Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f20609b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f20612o = checkableImageButton;
        if (Build.VERSION.SDK_INT <= 22) {
            checkableImageButton.setBackground(o7.b.createOvalRippleLollipop(checkableImageButton.getContext(), (int) t.dpToPx(checkableImageButton.getContext(), 4)));
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f20610m = appCompatTextView;
        if (n7.c.isFontScaleAtLeast1_3(getContext())) {
            x0.k.setMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f20617t;
        checkableImageButton.setOnClickListener(null);
        m.d(checkableImageButton, onLongClickListener);
        this.f20617t = null;
        checkableImageButton.setOnLongClickListener(null);
        m.d(checkableImageButton, null);
        int i10 = R.styleable.TextInputLayout_startIconTint;
        if (c1Var.hasValue(i10)) {
            this.f20613p = n7.c.getColorStateList(getContext(), c1Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_startIconTintMode;
        if (c1Var.hasValue(i11)) {
            this.f20614q = t.parseTintMode(c1Var.getInt(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_startIconDrawable;
        if (c1Var.hasValue(i12)) {
            b(c1Var.getDrawable(i12));
            int i13 = R.styleable.TextInputLayout_startIconContentDescription;
            if (c1Var.hasValue(i13) && checkableImageButton.getContentDescription() != (text = c1Var.getText(i13))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(c1Var.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        int dimensionPixelSize = c1Var.getDimensionPixelSize(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f20615r) {
            this.f20615r = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        int i14 = R.styleable.TextInputLayout_startIconScaleType;
        if (c1Var.hasValue(i14)) {
            ImageView.ScaleType scaleTypeB = m.b(c1Var.getInt(i14, -1));
            this.f20616s = scaleTypeB;
            checkableImageButton.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        j0.setAccessibilityLiveRegion(appCompatTextView, 1);
        d1.i.setTextAppearance(appCompatTextView, c1Var.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        int i15 = R.styleable.TextInputLayout_prefixTextColor;
        if (c1Var.hasValue(i15)) {
            appCompatTextView.setTextColor(c1Var.getColorStateList(i15));
        }
        CharSequence text2 = c1Var.getText(R.styleable.TextInputLayout_prefixText);
        this.f20611n = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        e();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int a() {
        CheckableImageButton checkableImageButton = this.f20612o;
        return j0.getPaddingStart(this.f20610m) + j0.getPaddingStart(this) + (checkableImageButton.getVisibility() == 0 ? x0.k.getMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth() : 0);
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f20612o;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f20613p;
            PorterDuff.Mode mode = this.f20614q;
            TextInputLayout textInputLayout = this.f20609b;
            m.a(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            m.c(textInputLayout, checkableImageButton, this.f20613p);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f20617t;
        checkableImageButton.setOnClickListener(null);
        m.d(checkableImageButton, onLongClickListener);
        this.f20617t = null;
        checkableImageButton.setOnLongClickListener(null);
        m.d(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z10) {
        CheckableImageButton checkableImageButton = this.f20612o;
        if ((checkableImageButton.getVisibility() == 0) != z10) {
            checkableImageButton.setVisibility(z10 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f20609b.f9424o;
        if (editText == null) {
            return;
        }
        j0.setPaddingRelative(this.f20610m, this.f20612o.getVisibility() == 0 ? 0 : j0.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i10 = (this.f20611n == null || this.f20618u) ? 8 : 0;
        setVisibility(this.f20612o.getVisibility() == 0 || i10 == 0 ? 0 : 8);
        this.f20610m.setVisibility(i10);
        this.f20609b.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        d();
    }
}
