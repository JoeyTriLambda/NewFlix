package v7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import x0.j0;

/* compiled from: IndicatorViewController.java */
/* loaded from: classes.dex */
public final class n {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a, reason: collision with root package name */
    public final int f20562a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20563b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20564c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f20565d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f20566e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f20567f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f20568g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f20569h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f20570i;

    /* renamed from: j, reason: collision with root package name */
    public int f20571j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f20572k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f20573l;

    /* renamed from: m, reason: collision with root package name */
    public final float f20574m;

    /* renamed from: n, reason: collision with root package name */
    public int f20575n;

    /* renamed from: o, reason: collision with root package name */
    public int f20576o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f20577p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20578q;

    /* renamed from: r, reason: collision with root package name */
    public AppCompatTextView f20579r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f20580s;

    /* renamed from: t, reason: collision with root package name */
    public int f20581t;

    /* renamed from: u, reason: collision with root package name */
    public int f20582u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f20583v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f20584w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f20585x;

    /* renamed from: y, reason: collision with root package name */
    public AppCompatTextView f20586y;

    /* renamed from: z, reason: collision with root package name */
    public int f20587z;

    /* compiled from: IndicatorViewController.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20588b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ TextView f20589m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f20590n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ TextView f20591o;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f20588b = i10;
            this.f20589m = textView;
            this.f20590n = i11;
            this.f20591o = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AppCompatTextView appCompatTextView;
            int i10 = this.f20588b;
            n nVar = n.this;
            nVar.f20575n = i10;
            nVar.f20573l = null;
            TextView textView = this.f20589m;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f20590n == 1 && (appCompatTextView = nVar.f20579r) != null) {
                    appCompatTextView.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f20591o;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                textView2.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f20591o;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setAlpha(0.0f);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f20568g = context;
        this.f20569h = textInputLayout;
        this.f20574m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        int i10 = R.attr.motionDurationShort4;
        this.f20562a = k7.g.resolveThemeDuration(context, i10, 217);
        this.f20563b = k7.g.resolveThemeDuration(context, R.attr.motionDurationMedium4, 167);
        this.f20564c = k7.g.resolveThemeDuration(context, i10, 167);
        int i11 = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        this.f20565d = k7.g.resolveThemeInterpolator(context, i11, p6.a.f17607d);
        LinearInterpolator linearInterpolator = p6.a.f17604a;
        this.f20566e = k7.g.resolveThemeInterpolator(context, i11, linearInterpolator);
        this.f20567f = k7.g.resolveThemeInterpolator(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i10) {
        if (this.f20570i == null && this.f20572k == null) {
            Context context = this.f20568g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f20570i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f20570i;
            TextInputLayout textInputLayout = this.f20569h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f20572k = new FrameLayout(context);
            this.f20570i.addView(this.f20572k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i10 == 0 || i10 == 1) {
            this.f20572k.setVisibility(0);
            this.f20572k.addView(textView);
        } else {
            this.f20570i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f20570i.setVisibility(0);
        this.f20571j++;
    }

    public final void b() {
        LinearLayout linearLayout = this.f20570i;
        TextInputLayout textInputLayout = this.f20569h;
        if ((linearLayout == null || textInputLayout.getEditText() == null) ? false : true) {
            EditText editText = textInputLayout.getEditText();
            Context context = this.f20568g;
            boolean zIsFontScaleAtLeast1_3 = n7.c.isFontScaleAtLeast1_3(context);
            LinearLayout linearLayout2 = this.f20570i;
            int i10 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            int paddingStart = j0.getPaddingStart(editText);
            if (zIsFontScaleAtLeast1_3) {
                paddingStart = context.getResources().getDimensionPixelSize(i10);
            }
            int i11 = R.dimen.material_helper_text_font_1_3_padding_top;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
            if (zIsFontScaleAtLeast1_3) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(i11);
            }
            int paddingEnd = j0.getPaddingEnd(editText);
            if (zIsFontScaleAtLeast1_3) {
                paddingEnd = context.getResources().getDimensionPixelSize(i10);
            }
            j0.setPaddingRelative(linearLayout2, paddingStart, dimensionPixelSize, paddingEnd, 0);
        }
    }

    public final void c() {
        Animator animator = this.f20573l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            boolean z11 = i12 == i10;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z11 ? 1.0f : 0.0f);
            int i13 = this.f20564c;
            objectAnimatorOfFloat.setDuration(z11 ? this.f20563b : i13);
            objectAnimatorOfFloat.setInterpolator(z11 ? this.f20566e : this.f20567f);
            if (i10 == i12 && i11 != 0) {
                objectAnimatorOfFloat.setStartDelay(i13);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f20574m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f20562a);
            objectAnimatorOfFloat2.setInterpolator(this.f20565d);
            objectAnimatorOfFloat2.setStartDelay(i13);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i10) {
        if (i10 == 1) {
            return this.f20579r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f20586y;
    }

    public final void f() {
        this.f20577p = null;
        c();
        if (this.f20575n == 1) {
            if (!this.f20585x || TextUtils.isEmpty(this.f20584w)) {
                this.f20576o = 0;
            } else {
                this.f20576o = 2;
            }
        }
        i(this.f20575n, this.f20576o, h(this.f20579r, ""));
    }

    public final void g(TextView textView, int i10) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f20570i;
        if (linearLayout == null) {
            return;
        }
        boolean z10 = true;
        if (i10 != 0 && i10 != 1) {
            z10 = false;
        }
        if (!z10 || (frameLayout = this.f20572k) == null) {
            linearLayout.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i11 = this.f20571j - 1;
        this.f20571j = i11;
        LinearLayout linearLayout2 = this.f20570i;
        if (i11 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f20569h;
        return j0.isLaidOut(textInputLayout) && textInputLayout.isEnabled() && !(this.f20576o == this.f20575n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void i(int i10, int i11, boolean z10) {
        TextView textViewE;
        TextView textViewE2;
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f20573l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f20585x, this.f20586y, 2, i10, i11);
            d(arrayList, this.f20578q, this.f20579r, 1, i10, i11);
            p6.b.playTogether(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, e(i10), i10, e(i11)));
            animatorSet.start();
        } else if (i10 != i11) {
            if (i11 != 0 && (textViewE2 = e(i11)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i10 != 0 && (textViewE = e(i10)) != null) {
                textViewE.setVisibility(4);
                if (i10 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.f20575n = i11;
        }
        TextInputLayout textInputLayout = this.f20569h;
        textInputLayout.r();
        textInputLayout.u(z10, false);
        textInputLayout.x();
    }
}
