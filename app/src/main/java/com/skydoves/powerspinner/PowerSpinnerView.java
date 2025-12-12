package com.skydoves.powerspinner;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.RecyclerView;
import com.loopj.android.http.AsyncHttpClient;
import java.util.List;
import qa.f;
import qa.g;
import qa.h;
import yf.p;
import yf.r;
import zf.i;

/* compiled from: PowerSpinnerView.kt */
/* loaded from: classes2.dex */
public final class PowerSpinnerView extends AppCompatTextView implements k {
    public long A;
    public boolean B;
    public long C;
    public int D;
    public boolean E;
    public SpinnerGravity F;
    public int G;
    public int H;
    public boolean I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public qa.e R;
    public qa.c S;
    public SpinnerAnimation T;
    public String U;
    public l V;

    /* renamed from: s, reason: collision with root package name */
    public final ra.b f10438s;

    /* renamed from: t, reason: collision with root package name */
    public final PopupWindow f10439t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10440u;

    /* renamed from: v, reason: collision with root package name */
    public int f10441v;

    /* renamed from: w, reason: collision with root package name */
    public f<?> f10442w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10443x;

    /* renamed from: y, reason: collision with root package name */
    public long f10444y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f10445z;

    /* compiled from: PowerSpinnerView.kt */
    public static final class a implements qa.c {
        public a() {
        }

        @Override // qa.c
        public final void onDismiss() {
            PowerSpinnerView.this.dismiss();
        }
    }

    /* compiled from: PowerSpinnerView.kt */
    public static final class b implements qa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yf.a f10447a;

        public b(yf.a aVar) {
            this.f10447a = aVar;
        }

        @Override // qa.c
        public final void onDismiss() {
            this.f10447a.invoke();
        }
    }

    /* compiled from: PowerSpinnerView.kt */
    public static final class c<T> implements qa.d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f10448a;

        public c(r rVar) {
            this.f10448a = rVar;
        }

        @Override // qa.d
        public final void onItemSelected(int i10, T t10, int i11, T t11) {
            this.f10448a.invoke(Integer.valueOf(i10), t10, Integer.valueOf(i11), t11);
        }
    }

    /* compiled from: PowerSpinnerView.kt */
    public static final class d implements qa.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f10449a;

        public d(p pVar) {
            this.f10449a = pVar;
        }

        @Override // qa.e
        public final void onSpinnerOutsideTouch(View view, MotionEvent motionEvent) {
            i.checkNotNullParameter(view, "view");
            i.checkNotNullParameter(motionEvent, "event");
            this.f10449a.invoke(view, motionEvent);
        }
    }

    /* compiled from: PowerSpinnerView.kt */
    public static final class e implements Runnable {

        /* compiled from: PowerSpinnerView.kt */
        public static final class a implements PopupWindow.OnDismissListener {
            public a() {
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                qa.c onSpinnerDismissListener = PowerSpinnerView.this.getOnSpinnerDismissListener();
                if (onSpinnerDismissListener != null) {
                    onSpinnerDismissListener.onDismiss();
                }
            }
        }

        /* compiled from: PowerSpinnerView.kt */
        public static final class b implements View.OnTouchListener {
            public b() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                i.checkNotNullParameter(view, "view");
                i.checkNotNullParameter(motionEvent, "event");
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                qa.e spinnerOutsideTouchListener = PowerSpinnerView.this.getSpinnerOutsideTouchListener();
                if (spinnerOutsideTouchListener == null) {
                    return true;
                }
                spinnerOutsideTouchListener.onSpinnerOutsideTouch(view, motionEvent);
                return true;
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PowerSpinnerView powerSpinnerView = PowerSpinnerView.this;
            PopupWindow popupWindow = powerSpinnerView.f10439t;
            popupWindow.setWidth(powerSpinnerView.getWidth());
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new a());
            popupWindow.setTouchInterceptor(new b());
            popupWindow.setElevation(powerSpinnerView.getSpinnerPopupElevation());
            FrameLayout frameLayout = powerSpinnerView.f10438s.f18898a;
            if (powerSpinnerView.getSpinnerPopupBackgroundColor() == 65555) {
                frameLayout.setBackground(powerSpinnerView.getBackground());
            } else {
                frameLayout.setBackgroundColor(powerSpinnerView.getSpinnerPopupBackgroundColor());
            }
            i.checkNotNullExpressionValue(frameLayout, "this");
            frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), frameLayout.getPaddingBottom());
            if (powerSpinnerView.getShowDivider()) {
                androidx.recyclerview.widget.i iVar = new androidx.recyclerview.widget.i(frameLayout.getContext(), 1);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setSize(frameLayout.getWidth(), powerSpinnerView.getDividerSize());
                gradientDrawable.setColor(powerSpinnerView.getDividerColor());
                iVar.setDrawable(gradientDrawable);
                powerSpinnerView.getSpinnerRecyclerView().addItemDecoration(iVar);
            }
            if (powerSpinnerView.getSpinnerPopupWidth() != Integer.MIN_VALUE) {
                powerSpinnerView.f10439t.setWidth(powerSpinnerView.getSpinnerPopupWidth());
            }
            if (powerSpinnerView.getSpinnerPopupHeight() != Integer.MIN_VALUE) {
                powerSpinnerView.f10439t.setHeight(powerSpinnerView.getSpinnerPopupHeight());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerSpinnerView(Context context) {
        super(context);
        i.checkNotNullParameter(context, "context");
        ra.b bVarInflate = ra.b.inflate(LayoutInflater.from(getContext()), null, false);
        i.checkNotNullExpressionValue(bVarInflate, "LayoutBodyPowerSpinnerLi…om(context), null, false)");
        this.f10438s = bVarInflate;
        this.f10441v = -1;
        this.f10442w = new qa.b(this);
        this.f10443x = true;
        this.f10444y = 250L;
        Context context2 = getContext();
        i.checkNotNullExpressionValue(context2, "context");
        Drawable drawableContextDrawable = qa.a.contextDrawable(context2, R.drawable.arrow_power_spinner_library);
        this.f10445z = drawableContextDrawable != null ? drawableContextDrawable.mutate() : null;
        this.A = 150L;
        this.D = Integer.MIN_VALUE;
        this.E = true;
        this.F = SpinnerGravity.END;
        this.H = -1;
        this.J = qa.a.dp2Px((View) this, 0.5f);
        this.K = -1;
        this.L = 65555;
        this.M = qa.a.dp2Px((View) this, 4);
        this.N = Integer.MIN_VALUE;
        this.O = Integer.MIN_VALUE;
        this.P = Integer.MIN_VALUE;
        this.Q = true;
        this.T = SpinnerAnimation.NORMAL;
        if (this.f10442w instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            Object obj = this.f10442w;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            }
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) obj);
        }
        this.f10439t = new PopupWindow(bVarInflate.f18898a, -1, -2);
        setOnClickListener(new h(this));
        if (getGravity() == 0) {
            setGravity(16);
        }
        Object context3 = getContext();
        if (this.V == null && (context3 instanceof l)) {
            setLifecycleOwner((l) context3);
        }
    }

    public static final void access$animateArrow(PowerSpinnerView powerSpinnerView, boolean z10) {
        if (powerSpinnerView.f10443x) {
            int i10 = AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
            int i11 = z10 ? 0 : AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
            if (!z10) {
                i10 = 0;
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(powerSpinnerView.f10445z, "level", i11, i10);
            objectAnimatorOfInt.setDuration(powerSpinnerView.f10444y);
            objectAnimatorOfInt.start();
        }
    }

    public static final void access$applyWindowAnimation(PowerSpinnerView powerSpinnerView) {
        int i10 = powerSpinnerView.N;
        PopupWindow popupWindow = powerSpinnerView.f10439t;
        if (i10 != Integer.MIN_VALUE) {
            popupWindow.setAnimationStyle(i10);
            return;
        }
        int iOrdinal = powerSpinnerView.T.ordinal();
        if (iOrdinal == 0) {
            popupWindow.setAnimationStyle(R.style.DropDown_PowerSpinner);
        } else if (iOrdinal == 1) {
            popupWindow.setAnimationStyle(R.style.Fade_PowerSpinner);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            popupWindow.setAnimationStyle(R.style.Elastic_PowerSpinner);
        }
    }

    private final void setTypeArray(TypedArray typedArray) throws Resources.NotFoundException {
        int resourceId;
        int i10 = R.styleable.PowerSpinnerView_spinner_arrow_drawable;
        if (typedArray.hasValue(i10)) {
            this.D = typedArray.getResourceId(i10, this.D);
        }
        int i11 = R.styleable.PowerSpinnerView_spinner_arrow_show;
        if (typedArray.hasValue(i11)) {
            this.E = typedArray.getBoolean(i11, this.E);
        }
        int i12 = R.styleable.PowerSpinnerView_spinner_arrow_gravity;
        if (typedArray.hasValue(i12)) {
            int integer = typedArray.getInteger(i12, this.F.getValue());
            SpinnerGravity spinnerGravity = SpinnerGravity.START;
            if (integer != spinnerGravity.getValue()) {
                spinnerGravity = SpinnerGravity.TOP;
                if (integer != spinnerGravity.getValue()) {
                    spinnerGravity = SpinnerGravity.END;
                    if (integer != spinnerGravity.getValue()) {
                        spinnerGravity = SpinnerGravity.BOTTOM;
                        if (integer != spinnerGravity.getValue()) {
                            throw new IllegalArgumentException("unknown argument: spinner_arrow_gravity");
                        }
                    }
                }
            }
            this.F = spinnerGravity;
        }
        int i13 = R.styleable.PowerSpinnerView_spinner_arrow_padding;
        if (typedArray.hasValue(i13)) {
            this.G = typedArray.getDimensionPixelSize(i13, this.G);
        }
        int i14 = R.styleable.PowerSpinnerView_spinner_arrow_tint;
        if (typedArray.hasValue(i14)) {
            this.H = typedArray.getColor(i14, this.H);
        }
        int i15 = R.styleable.PowerSpinnerView_spinner_arrow_animate;
        if (typedArray.hasValue(i15)) {
            this.f10443x = typedArray.getBoolean(i15, this.f10443x);
        }
        if (typedArray.hasValue(R.styleable.PowerSpinnerView_spinner_arrow_animate_duration)) {
            this.f10444y = typedArray.getInteger(r0, (int) this.f10444y);
        }
        int i16 = R.styleable.PowerSpinnerView_spinner_divider_show;
        if (typedArray.hasValue(i16)) {
            this.I = typedArray.getBoolean(i16, this.I);
        }
        int i17 = R.styleable.PowerSpinnerView_spinner_divider_size;
        if (typedArray.hasValue(i17)) {
            this.J = typedArray.getDimensionPixelSize(i17, this.J);
        }
        int i18 = R.styleable.PowerSpinnerView_spinner_divider_color;
        if (typedArray.hasValue(i18)) {
            this.K = typedArray.getColor(i18, this.K);
        }
        int i19 = R.styleable.PowerSpinnerView_spinner_popup_background;
        if (typedArray.hasValue(i19)) {
            this.L = typedArray.getColor(i19, this.L);
        }
        int i20 = R.styleable.PowerSpinnerView_spinner_popup_animation;
        if (typedArray.hasValue(i20)) {
            int integer2 = typedArray.getInteger(i20, this.T.getValue());
            SpinnerAnimation spinnerAnimation = SpinnerAnimation.DROPDOWN;
            if (integer2 != spinnerAnimation.getValue()) {
                spinnerAnimation = SpinnerAnimation.FADE;
                if (integer2 != spinnerAnimation.getValue()) {
                    spinnerAnimation = SpinnerAnimation.BOUNCE;
                    if (integer2 != spinnerAnimation.getValue()) {
                        spinnerAnimation = SpinnerAnimation.NORMAL;
                        if (integer2 != spinnerAnimation.getValue()) {
                            throw new IllegalArgumentException("unknown argument: spinner_popup_animation");
                        }
                    }
                }
            }
            this.T = spinnerAnimation;
        }
        int i21 = R.styleable.PowerSpinnerView_spinner_popup_animation_style;
        if (typedArray.hasValue(i21)) {
            this.N = typedArray.getResourceId(i21, this.N);
        }
        int i22 = R.styleable.PowerSpinnerView_spinner_popup_width;
        if (typedArray.hasValue(i22)) {
            this.O = typedArray.getDimensionPixelSize(i22, this.O);
        }
        int i23 = R.styleable.PowerSpinnerView_spinner_popup_height;
        if (typedArray.hasValue(i23)) {
            this.P = typedArray.getDimensionPixelSize(i23, this.P);
        }
        int i24 = R.styleable.PowerSpinnerView_spinner_popup_elevation;
        if (typedArray.hasValue(i24)) {
            this.M = typedArray.getDimensionPixelSize(i24, this.M);
        }
        int i25 = R.styleable.PowerSpinnerView_spinner_item_array;
        if (typedArray.hasValue(i25) && (resourceId = typedArray.getResourceId(i25, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
            setItems(resourceId);
        }
        int i26 = R.styleable.PowerSpinnerView_spinner_dismiss_notified_select;
        if (typedArray.hasValue(i26)) {
            this.Q = typedArray.getBoolean(i26, this.Q);
        }
        if (typedArray.hasValue(R.styleable.PowerSpinnerView_spinner_debounce_duration)) {
            this.A = typedArray.getInteger(r0, (int) this.A);
        }
        int i27 = R.styleable.PowerSpinnerView_spinner_preference_name;
        if (typedArray.hasValue(i27)) {
            setPreferenceName(typedArray.getString(i27));
        }
        int i28 = R.styleable.PowerSpinnerView_spinner_popup_focusable;
        if (typedArray.hasValue(i28)) {
            setIsFocusable(typedArray.getBoolean(i28, false));
        }
    }

    public static /* synthetic */ void showOrDismiss$default(PowerSpinnerView powerSpinnerView, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        powerSpinnerView.showOrDismiss(i10, i11);
    }

    public final void dismiss() {
        yf.a<lf.h> aVar = new yf.a<lf.h>() { // from class: com.skydoves.powerspinner.PowerSpinnerView.dismiss.1
            {
                super(0);
            }

            @Override // yf.a
            public /* bridge */ /* synthetic */ lf.h invoke() {
                invoke2();
                return lf.h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PowerSpinnerView powerSpinnerView = PowerSpinnerView.this;
                if (powerSpinnerView.isShowing()) {
                    PowerSpinnerView.access$animateArrow(powerSpinnerView, false);
                    powerSpinnerView.f10439t.dismiss();
                    powerSpinnerView.f10440u = false;
                }
            }
        };
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.C > this.A) {
            this.C = jCurrentTimeMillis;
            aVar.invoke();
        }
    }

    public final boolean getArrowAnimate() {
        return this.f10443x;
    }

    public final long getArrowAnimationDuration() {
        return this.f10444y;
    }

    public final Drawable getArrowDrawable() {
        return this.f10445z;
    }

    public final SpinnerGravity getArrowGravity() {
        return this.F;
    }

    public final int getArrowPadding() {
        return this.G;
    }

    public final int getArrowResource() {
        return this.D;
    }

    public final qa.i getArrowSize() {
        return null;
    }

    public final int getArrowTint() {
        return this.H;
    }

    public final long getDebounceDuration() {
        return this.A;
    }

    public final boolean getDisableChangeTextWhenNotified() {
        return this.B;
    }

    public final boolean getDismissWhenNotifiedItemSelected() {
        return this.Q;
    }

    public final int getDividerColor() {
        return this.K;
    }

    public final int getDividerSize() {
        return this.J;
    }

    public final l getLifecycleOwner() {
        return this.V;
    }

    public final qa.c getOnSpinnerDismissListener() {
        return this.S;
    }

    public final String getPreferenceName() {
        return this.U;
    }

    public final int getSelectedIndex() {
        return this.f10441v;
    }

    public final boolean getShowArrow() {
        return this.E;
    }

    public final boolean getShowDivider() {
        return this.I;
    }

    public final <T> f<T> getSpinnerAdapter() {
        f<T> fVar = (f<T>) this.f10442w;
        if (fVar != null) {
            return fVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
    }

    public final FrameLayout getSpinnerBodyView() {
        FrameLayout frameLayout = this.f10438s.f18898a;
        i.checkNotNullExpressionValue(frameLayout, "binding.body");
        return frameLayout;
    }

    public final qa.e getSpinnerOutsideTouchListener() {
        return this.R;
    }

    public final SpinnerAnimation getSpinnerPopupAnimation() {
        return this.T;
    }

    public final int getSpinnerPopupAnimationStyle() {
        return this.N;
    }

    public final int getSpinnerPopupBackgroundColor() {
        return this.L;
    }

    public final int getSpinnerPopupElevation() {
        return this.M;
    }

    public final int getSpinnerPopupHeight() {
        return this.P;
    }

    public final int getSpinnerPopupWidth() {
        return this.O;
    }

    public final RecyclerView getSpinnerRecyclerView() {
        RecyclerView recyclerView = this.f10438s.f18899b;
        i.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        return recyclerView;
    }

    public final boolean isShowing() {
        return this.f10440u;
    }

    public final void m() {
        if (getArrowResource() != Integer.MIN_VALUE) {
            Context context = getContext();
            i.checkNotNullExpressionValue(context, "context");
            Drawable drawableContextDrawable = qa.a.contextDrawable(context, getArrowResource());
            this.f10445z = drawableContextDrawable != null ? drawableContextDrawable.mutate() : null;
        }
        setCompoundDrawablePadding(getArrowPadding());
        getArrowSize();
        Drawable drawable = this.f10445z;
        if (!getShowArrow()) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (drawable != null) {
            Drawable drawableMutate = p0.a.wrap(drawable).mutate();
            i.checkNotNullExpressionValue(drawableMutate, "DrawableCompat.wrap(it).mutate()");
            p0.a.setTint(drawableMutate, getArrowTint());
            drawableMutate.invalidateSelf();
        }
        int iOrdinal = getArrowGravity().ordinal();
        if (iOrdinal == 0) {
            setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        if (iOrdinal == 1) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (iOrdinal == 2) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }

    public final void n() {
        if (this.f10442w.getItemCount() > 0) {
            String str = this.U;
            if (str == null || str.length() == 0) {
                return;
            }
            g.a aVar = g.f18049c;
            Context context = getContext();
            i.checkNotNullExpressionValue(context, "context");
            if (aVar.getInstance(context).getSelectedIndex(str) != -1) {
                f<?> fVar = this.f10442w;
                Context context2 = getContext();
                i.checkNotNullExpressionValue(context2, "context");
                fVar.notifyItemSelected(aVar.getInstance(context2).getSelectedIndex(str));
            }
        }
    }

    public final void notifyItemSelected(int i10, CharSequence charSequence) {
        i.checkNotNullParameter(charSequence, "changedText");
        this.f10441v = i10;
        if (!this.B) {
            setText(charSequence);
        }
        if (this.Q) {
            dismiss();
        }
        String str = this.U;
        if (str == null || str.length() == 0) {
            return;
        }
        g.a aVar = g.f18049c;
        Context context = getContext();
        i.checkNotNullExpressionValue(context, "context");
        aVar.getInstance(context).persistSelectedIndex(str, this.f10441v);
    }

    public final void o() {
        post(new e());
    }

    @t(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        dismiss();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        o();
        m();
        n();
    }

    public final void setArrowAnimate(boolean z10) {
        this.f10443x = z10;
    }

    public final void setArrowAnimationDuration(long j10) {
        this.f10444y = j10;
    }

    public final void setArrowDrawable(Drawable drawable) {
        this.f10445z = drawable;
    }

    public final void setArrowGravity(SpinnerGravity spinnerGravity) {
        i.checkNotNullParameter(spinnerGravity, "value");
        this.F = spinnerGravity;
        m();
    }

    public final void setArrowPadding(int i10) {
        this.G = i10;
        m();
    }

    public final void setArrowResource(int i10) {
        this.D = i10;
        m();
    }

    public final void setArrowSize(qa.i iVar) {
        m();
    }

    public final void setArrowTint(int i10) {
        this.H = i10;
        m();
    }

    public final void setDisableChangeTextWhenNotified(boolean z10) {
        this.B = z10;
    }

    public final void setDismissWhenNotifiedItemSelected(boolean z10) {
        this.Q = z10;
    }

    public final void setDividerColor(int i10) {
        this.K = i10;
        o();
    }

    public final void setDividerSize(int i10) {
        this.J = i10;
        o();
    }

    public final void setIsFocusable(boolean z10) {
        this.f10439t.setFocusable(z10);
        this.S = new a();
    }

    public final <T> void setItems(List<? extends T> list) {
        i.checkNotNullParameter(list, "itemList");
        f<?> fVar = this.f10442w;
        if (fVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        }
        fVar.setItems(list);
    }

    public final void setLifecycleOwner(l lVar) {
        Lifecycle lifecycle;
        this.V = lVar;
        if (lVar == null || (lifecycle = lVar.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this);
    }

    public final void setOnSpinnerDismissListener(qa.c cVar) {
        this.S = cVar;
    }

    public final <T> void setOnSpinnerItemSelectedListener(qa.d<T> dVar) {
        i.checkNotNullParameter(dVar, "onSpinnerItemSelectedListener");
        f<?> fVar = this.f10442w;
        if (fVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        }
        fVar.setOnSpinnerItemSelectedListener(dVar);
    }

    public final /* synthetic */ void setOnSpinnerOutsideTouchListener(p<? super View, ? super MotionEvent, lf.h> pVar) {
        i.checkNotNullParameter(pVar, "block");
        this.R = new d(pVar);
    }

    public final void setPreferenceName(String str) {
        this.U = str;
        n();
    }

    public final void setShowArrow(boolean z10) {
        this.E = z10;
        m();
    }

    public final void setShowDivider(boolean z10) {
        this.I = z10;
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void setSpinnerAdapter(f<T> fVar) {
        i.checkNotNullParameter(fVar, "powerSpinnerInterface");
        this.f10442w = fVar;
        if (fVar instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            Object obj = this.f10442w;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            }
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) obj);
        }
    }

    public final void setSpinnerOutsideTouchListener(qa.e eVar) {
        this.R = eVar;
    }

    public final void setSpinnerPopupAnimation(SpinnerAnimation spinnerAnimation) {
        i.checkNotNullParameter(spinnerAnimation, "<set-?>");
        this.T = spinnerAnimation;
    }

    public final void setSpinnerPopupAnimationStyle(int i10) {
        this.N = i10;
    }

    public final void setSpinnerPopupBackgroundColor(int i10) {
        this.L = i10;
        o();
    }

    public final void setSpinnerPopupElevation(int i10) {
        this.M = i10;
        o();
    }

    public final void setSpinnerPopupHeight(int i10) {
        this.P = i10;
    }

    public final void setSpinnerPopupWidth(int i10) {
        this.O = i10;
    }

    public final void show(final int i10, final int i11) {
        yf.a<lf.h> aVar = new yf.a<lf.h>() { // from class: com.skydoves.powerspinner.PowerSpinnerView.show.1

            /* compiled from: PowerSpinnerView.kt */
            /* renamed from: com.skydoves.powerspinner.PowerSpinnerView$show$1$a */
            public static final class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C03461 c03461 = C03461.this;
                    PowerSpinnerView.this.f10439t.update(PowerSpinnerView.this.getSpinnerPopupWidth() != Integer.MIN_VALUE ? PowerSpinnerView.this.getSpinnerPopupWidth() : PowerSpinnerView.this.getWidth(), PowerSpinnerView.this.getSpinnerPopupHeight() != Integer.MIN_VALUE ? PowerSpinnerView.this.getSpinnerPopupHeight() : PowerSpinnerView.this.getSpinnerRecyclerView().getHeight());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // yf.a
            public /* bridge */ /* synthetic */ lf.h invoke() {
                invoke2();
                return lf.h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PowerSpinnerView powerSpinnerView = PowerSpinnerView.this;
                if (powerSpinnerView.isShowing()) {
                    return;
                }
                powerSpinnerView.f10440u = true;
                PowerSpinnerView.access$animateArrow(powerSpinnerView, true);
                PowerSpinnerView.access$applyWindowAnimation(powerSpinnerView);
                powerSpinnerView.f10439t.showAsDropDown(powerSpinnerView, i10, i11);
                powerSpinnerView.post(new a());
            }
        };
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.C > this.A) {
            this.C = jCurrentTimeMillis;
            aVar.invoke();
        }
    }

    public final void showOrDismiss(int i10, int i11) {
        RecyclerView.Adapter adapter = getSpinnerRecyclerView().getAdapter();
        if (adapter != null) {
            i.checkNotNullExpressionValue(adapter, "getSpinnerRecyclerView().adapter ?: return");
            if (this.f10440u || adapter.getItemCount() <= 0) {
                dismiss();
            } else {
                show(i10, i11);
            }
        }
    }

    public final void setItems(int i10) throws Resources.NotFoundException {
        if (this.f10442w instanceof qa.b) {
            Context context = getContext();
            i.checkNotNullExpressionValue(context, "context");
            String[] stringArray = context.getResources().getStringArray(i10);
            i.checkNotNullExpressionValue(stringArray, "context.resources.getStringArray(resource)");
            setItems(mf.i.toList(stringArray));
        }
    }

    public final /* synthetic */ void setOnSpinnerDismissListener(yf.a<lf.h> aVar) {
        i.checkNotNullParameter(aVar, "block");
        this.S = new b(aVar);
    }

    public final /* synthetic */ <T> void setOnSpinnerItemSelectedListener(r<? super Integer, ? super T, ? super Integer, ? super T, lf.h> rVar) {
        i.checkNotNullParameter(rVar, "block");
        f<?> fVar = this.f10442w;
        if (fVar != null) {
            fVar.setOnSpinnerItemSelectedListener(new c(rVar));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
    }
}
