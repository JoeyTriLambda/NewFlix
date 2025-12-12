package v7;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import x0.j0;
import y0.c;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f20544e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20545f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f20546g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f20547h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.mediarouter.app.b f20548i;

    /* renamed from: j, reason: collision with root package name */
    public final b f20549j;

    /* renamed from: k, reason: collision with root package name */
    public final c1.c f20550k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20551l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20552m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20553n;

    /* renamed from: o, reason: collision with root package name */
    public long f20554o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f20555p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f20556q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f20557r;

    public k(com.google.android.material.textfield.a aVar) {
        super(aVar);
        this.f20548i = new androidx.mediarouter.app.b(this, 4);
        this.f20549j = new b(this, 1);
        this.f20550k = new c1.c(this, 10);
        this.f20554o = Long.MAX_VALUE;
        Context context = aVar.getContext();
        int i10 = R.attr.motionDurationShort3;
        this.f20545f = k7.g.resolveThemeDuration(context, i10, 67);
        this.f20544e = k7.g.resolveThemeDuration(aVar.getContext(), i10, 50);
        this.f20546g = k7.g.resolveThemeInterpolator(aVar.getContext(), R.attr.motionEasingLinearInterpolator, p6.a.f17604a);
    }

    @Override // v7.l
    public void afterEditTextChanged(Editable editable) {
        if (this.f20555p.isTouchExplorationEnabled()) {
            if ((this.f20547h.getInputType() != 0) && !this.f20561d.hasFocus()) {
                this.f20547h.dismissDropDown();
            }
        }
        this.f20547h.post(new androidx.activity.d(this, 17));
    }

    @Override // v7.l
    public final int b() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // v7.l
    public final int c() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // v7.l
    public final View.OnFocusChangeListener d() {
        return this.f20549j;
    }

    @Override // v7.l
    public final View.OnClickListener e() {
        return this.f20548i;
    }

    @Override // v7.l
    public final boolean g(int i10) {
        return i10 != 0;
    }

    @Override // v7.l
    public c.a getTouchExplorationStateChangeListener() {
        return this.f20550k;
    }

    @Override // v7.l
    public final boolean h() {
        return this.f20551l;
    }

    @Override // v7.l
    public final boolean j() {
        return this.f20553n;
    }

    @Override // v7.l
    public final void m() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f20546g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f20545f);
        valueAnimatorOfFloat.addUpdateListener(new l7.a(this, 1));
        this.f20557r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f20544e);
        valueAnimatorOfFloat2.addUpdateListener(new l7.a(this, 1));
        this.f20556q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new j(this));
        this.f20555p = (AccessibilityManager) this.f20560c.getSystemService("accessibility");
    }

    @Override // v7.l
    @SuppressLint({"ClickableViewAccessibility"})
    public final void n() {
        AutoCompleteTextView autoCompleteTextView = this.f20547h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f20547h.setOnDismissListener(null);
        }
    }

    public final void o(boolean z10) {
        if (this.f20553n != z10) {
            this.f20553n = z10;
            this.f20557r.cancel();
            this.f20556q.start();
        }
    }

    @Override // v7.l
    public void onEditTextAttached(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f20547h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: v7.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                k kVar = this.f20541b;
                kVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - kVar.f20554o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        kVar.f20552m = false;
                    }
                    kVar.p();
                    kVar.f20552m = true;
                    kVar.f20554o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f20547h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: v7.i
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                k kVar = this.f20542a;
                kVar.f20552m = true;
                kVar.f20554o = System.currentTimeMillis();
                kVar.o(false);
            }
        });
        this.f20547h.setThreshold(0);
        TextInputLayout textInputLayout = this.f20558a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!(editText.getInputType() != 0) && this.f20555p.isTouchExplorationEnabled()) {
            j0.setImportantForAccessibility(this.f20561d, 2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // v7.l
    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        if (!(this.f20547h.getInputType() != 0)) {
            dVar.setClassName(Spinner.class.getName());
        }
        if (dVar.isShowingHintText()) {
            dVar.setHintText(null);
        }
    }

    @Override // v7.l
    @SuppressLint({"WrongConstant"})
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (this.f20555p.isEnabled()) {
            boolean z10 = false;
            if (this.f20547h.getInputType() != 0) {
                return;
            }
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f20553n && !this.f20547h.isPopupShowing()) {
                z10 = true;
            }
            if (accessibilityEvent.getEventType() == 1 || z10) {
                p();
                this.f20552m = true;
                this.f20554o = System.currentTimeMillis();
            }
        }
    }

    public final void p() {
        if (this.f20547h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f20554o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f20552m = false;
        }
        if (this.f20552m) {
            this.f20552m = false;
            return;
        }
        o(!this.f20553n);
        if (!this.f20553n) {
            this.f20547h.dismissDropDown();
        } else {
            this.f20547h.requestFocus();
            this.f20547h.showDropDown();
        }
    }
}
