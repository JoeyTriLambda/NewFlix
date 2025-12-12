package v7;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;

/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes.dex */
public final class e extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f20531e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20532f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f20533g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f20534h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f20535i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.mediarouter.app.b f20536j;

    /* renamed from: k, reason: collision with root package name */
    public final b f20537k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f20538l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f20539m;

    public e(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.f20536j = new androidx.mediarouter.app.b(this, 3);
        this.f20537k = new b(this, 0);
        Context context = aVar.getContext();
        int i10 = R.attr.motionDurationShort3;
        this.f20531e = k7.g.resolveThemeDuration(context, i10, 100);
        this.f20532f = k7.g.resolveThemeDuration(aVar.getContext(), i10, 150);
        this.f20533g = k7.g.resolveThemeInterpolator(aVar.getContext(), R.attr.motionEasingLinearInterpolator, p6.a.f17604a);
        this.f20534h = k7.g.resolveThemeInterpolator(aVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, p6.a.f17607d);
    }

    @Override // v7.l
    public final void afterEditTextChanged(Editable editable) {
        if (this.f20559b.A != null) {
            return;
        }
        o(p());
    }

    @Override // v7.l
    public final int b() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // v7.l
    public final int c() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // v7.l
    public final View.OnFocusChangeListener d() {
        return this.f20537k;
    }

    @Override // v7.l
    public final View.OnClickListener e() {
        return this.f20536j;
    }

    @Override // v7.l
    public final View.OnFocusChangeListener f() {
        return this.f20537k;
    }

    @Override // v7.l
    public final void k(boolean z10) {
        if (this.f20559b.A == null) {
            return;
        }
        o(z10);
    }

    @Override // v7.l
    public final void m() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f20534h);
        valueAnimatorOfFloat.setDuration(this.f20532f);
        final int i10 = 0;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v7.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ e f20526m;

            {
                this.f20526m = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i11 = i10;
                e eVar = this.f20526m;
                switch (i11) {
                    case 0:
                        eVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar.f20561d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                    default:
                        eVar.getClass();
                        eVar.f20561d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f20533g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i11 = this.f20531e;
        valueAnimatorOfFloat2.setDuration(i11);
        final int i12 = 1;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v7.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ e f20526m;

            {
                this.f20526m = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i112 = i12;
                e eVar = this.f20526m;
                switch (i112) {
                    case 0:
                        eVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar.f20561d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                    default:
                        eVar.getClass();
                        eVar.f20561d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20538l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f20538l.addListener(new c(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i11);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v7.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ e f20526m;

            {
                this.f20526m = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i112 = i12;
                e eVar = this.f20526m;
                switch (i112) {
                    case 0:
                        eVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar.f20561d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                    default:
                        eVar.getClass();
                        eVar.f20561d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                }
            }
        });
        this.f20539m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new d(this));
    }

    @Override // v7.l
    public final void n() {
        EditText editText = this.f20535i;
        if (editText != null) {
            editText.post(new androidx.activity.d(this, 16));
        }
    }

    public final void o(boolean z10) {
        boolean z11 = this.f20559b.d() == z10;
        if (z10 && !this.f20538l.isRunning()) {
            this.f20539m.cancel();
            this.f20538l.start();
            if (z11) {
                this.f20538l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f20538l.cancel();
        this.f20539m.start();
        if (z11) {
            this.f20539m.end();
        }
    }

    @Override // v7.l
    public void onEditTextAttached(EditText editText) {
        this.f20535i = editText;
        this.f20558a.setEndIconVisible(p());
    }

    public final boolean p() {
        EditText editText = this.f20535i;
        return editText != null && (editText.hasFocus() || this.f20561d.hasFocus()) && this.f20535i.getText().length() > 0;
    }
}
