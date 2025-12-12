package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    public final a A;
    public ValueAnimator B;
    public final b C;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f3142b;

    /* renamed from: m, reason: collision with root package name */
    public final View f3143m;

    /* renamed from: n, reason: collision with root package name */
    public final View f3144n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f3145o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f3146p;

    /* renamed from: q, reason: collision with root package name */
    public c f3147q;

    /* renamed from: r, reason: collision with root package name */
    public final float f3148r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3149s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3150t;

    /* renamed from: u, reason: collision with root package name */
    public final float f3151u;

    /* renamed from: v, reason: collision with root package name */
    public final float f3152v;

    /* renamed from: w, reason: collision with root package name */
    public ValueAnimator f3153w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3154x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3155y;

    /* renamed from: z, reason: collision with root package name */
    public final ArgbEvaluator f3156z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchOrbView.this.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SearchOrbView.this.setSearchOrbZ(valueAnimator.getAnimatedFraction());
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f3159a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3160b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3161c;

        public c(int i10, int i11, int i12) {
            this.f3159a = i10;
            this.f3160b = i11 == i10 ? getBrightColor(i10) : i11;
            this.f3161c = i12;
        }

        public static int getBrightColor(int i10) {
            return Color.argb((int) ((Color.alpha(i10) * 0.85f) + 38.25f), (int) ((Color.red(i10) * 0.85f) + 38.25f), (int) ((Color.green(i10) * 0.85f) + 38.25f), (int) ((Color.blue(i10) * 0.85f) + 38.25f));
        }
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchOrbViewStyle);
    }

    public final void a(boolean z10) {
        float f10 = z10 ? this.f3148r : 1.0f;
        ViewPropertyAnimator viewPropertyAnimatorScaleY = this.f3143m.animate().scaleX(f10).scaleY(f10);
        long j10 = this.f3150t;
        viewPropertyAnimatorScaleY.setDuration(j10).start();
        if (this.B == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.B = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.C);
        }
        if (z10) {
            this.B.start();
        } else {
            this.B.reverse();
        }
        this.B.setDuration(j10);
        enableOrbColorAnimation(z10);
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f3153w;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f3153w = null;
        }
        if (this.f3154x && this.f3155y) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f3156z, Integer.valueOf(this.f3147q.f3159a), Integer.valueOf(this.f3147q.f3160b), Integer.valueOf(this.f3147q.f3159a));
            this.f3153w = valueAnimatorOfObject;
            valueAnimatorOfObject.setRepeatCount(-1);
            this.f3153w.setDuration(this.f3149s * 2);
            this.f3153w.addUpdateListener(this.A);
            this.f3153w.start();
        }
    }

    public void enableOrbColorAnimation(boolean z10) {
        this.f3154x = z10;
        b();
    }

    public float getFocusedZoom() {
        return this.f3148r;
    }

    public int getLayoutResourceId() {
        return R.layout.lb_search_orb;
    }

    public int getOrbColor() {
        return this.f3147q.f3159a;
    }

    public c getOrbColors() {
        return this.f3147q;
    }

    public Drawable getOrbIcon() {
        return this.f3146p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3155y = true;
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f3142b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f3155y = false;
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        a(z10);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.f3142b = onClickListener;
    }

    public void setOrbColor(int i10) {
        setOrbColors(new c(i10, i10, 0));
    }

    public void setOrbColors(c cVar) {
        this.f3147q = cVar;
        this.f3145o.setColorFilter(cVar.f3161c);
        if (this.f3153w == null) {
            setOrbViewColor(this.f3147q.f3159a);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.f3146p = drawable;
        this.f3145o.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i10) {
        View view = this.f3144n;
        if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(i10);
        }
    }

    public void setSearchOrbZ(float f10) {
        float f11 = this.f3152v;
        float f12 = this.f3151u;
        x0.j0.setZ(this.f3144n, ((f11 - f12) * f10) + f12);
    }

    public SearchOrbView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3156z = new ArgbEvaluator();
        this.A = new a();
        this.C = new b();
        Resources resources = context.getResources();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.f3143m = viewInflate;
        this.f3144n = viewInflate.findViewById(R.id.search_orb);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        this.f3145o = imageView;
        this.f3148r = context.getResources().getFraction(R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.f3149s = context.getResources().getInteger(R.integer.lb_search_orb_pulse_duration_ms);
        this.f3150t = context.getResources().getInteger(R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_focused_z);
        this.f3152v = dimensionPixelSize;
        this.f3151u = context.getResources().getDimensionPixelSize(R.dimen.lb_search_orb_unfocused_z);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSearchOrbView, i10, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(R.drawable.lb_ic_in_app_search) : drawable);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(R.color.lb_default_search_color));
        setOrbColors(new c(color, typedArrayObtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbBrightColor, color), typedArrayObtainStyledAttributes.getColor(R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        x0.j0.setZ(imageView, dimensionPixelSize);
    }
}
