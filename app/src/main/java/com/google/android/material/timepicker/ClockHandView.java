package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.R;
import i7.t;
import java.util.ArrayList;
import java.util.Iterator;
import x0.j0;

/* loaded from: classes.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int A = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f9484b;

    /* renamed from: m, reason: collision with root package name */
    public final TimeInterpolator f9485m;

    /* renamed from: n, reason: collision with root package name */
    public final ValueAnimator f9486n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9487o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f9488p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9489q;

    /* renamed from: r, reason: collision with root package name */
    public final float f9490r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f9491s;

    /* renamed from: t, reason: collision with root package name */
    public final RectF f9492t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9493u;

    /* renamed from: v, reason: collision with root package name */
    public float f9494v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9495w;

    /* renamed from: x, reason: collision with root package name */
    public double f9496x;

    /* renamed from: y, reason: collision with root package name */
    public int f9497y;

    /* renamed from: z, reason: collision with root package name */
    public int f9498z;

    public class a extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void onRotate(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public final int a(int i10) {
        return i10 == 2 ? Math.round(this.f9497y * 0.66f) : this.f9497y;
    }

    public void addOnRotateListener(b bVar) {
        this.f9488p.add(bVar);
    }

    public final void b(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f9494v = f11;
        this.f9496x = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.f9498z);
        float fCos = (((float) Math.cos(this.f9496x)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.f9496x))) + height;
        RectF rectF = this.f9492t;
        float f12 = this.f9489q;
        rectF.set(fCos - f12, fSin - f12, fCos + f12, fSin + f12);
        Iterator it = this.f9488p.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onRotate(f11, z10);
        }
        invalidate();
    }

    public RectF getCurrentSelectorBox() {
        return this.f9492t;
    }

    public float getHandRotation() {
        return this.f9494v;
    }

    public int getSelectorRadius() {
        return this.f9489q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float fA = a(this.f9498z);
        float fCos = (((float) Math.cos(this.f9496x)) * fA) + f10;
        float f11 = height;
        float fSin = (fA * ((float) Math.sin(this.f9496x))) + f11;
        Paint paint = this.f9491s;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f9489q, paint);
        double dSin = Math.sin(this.f9496x);
        paint.setStrokeWidth(this.f9493u);
        canvas.drawLine(f10, f11, width + ((int) (Math.cos(this.f9496x) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f10, f11, this.f9490r, paint);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f9486n.isRunning()) {
            return;
        }
        setHandRotation(getHandRotation());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        boolean z12 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                z10 = this.f9495w;
                if (this.f9487o) {
                    this.f9498z = j7.a.dist((float) (getWidth() / 2), (float) (getHeight() / 2), x10, y10) <= ((float) a(2)) + t.dpToPx(getContext(), 12) ? 2 : 1;
                }
            } else {
                z10 = false;
            }
            z11 = false;
        } else {
            this.f9495w = false;
            z10 = false;
            z11 = true;
        }
        boolean z13 = this.f9495w;
        int degrees = ((int) Math.toDegrees(Math.atan2(y10 - (getHeight() / 2), x10 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            degrees += 360;
        }
        float f10 = degrees;
        boolean z14 = getHandRotation() != f10;
        if (z11 && z14) {
            z12 = true;
        } else if (z14 || z10) {
            setHandRotation(f10, false);
            z12 = true;
        }
        this.f9495w = z13 | z12;
        return true;
    }

    public void setCircleRadius(int i10) {
        this.f9497y = i10;
        invalidate();
    }

    public void setHandRotation(float f10) {
        setHandRotation(f10, false);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9486n = new ValueAnimator();
        this.f9488p = new ArrayList();
        Paint paint = new Paint();
        this.f9491s = paint;
        this.f9492t = new RectF();
        this.f9498z = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f9484b = k7.g.resolveThemeDuration(context, R.attr.motionDurationLong2, 200);
        this.f9485m = k7.g.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, p6.a.f17605b);
        this.f9497y = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f9489q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        this.f9493u = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f9490r = r7.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        j0.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setHandRotation(float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f9486n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            b(f10, false);
            return;
        }
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f10) > 180.0f) {
            if (handRotation > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (handRotation < 180.0f && f10 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(handRotation), Float.valueOf(f10));
        valueAnimator.setFloatValues(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        valueAnimator.setDuration(this.f9484b);
        valueAnimator.setInterpolator(this.f9485m);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i10 = ClockHandView.A;
                ClockHandView clockHandView = this.f9500b;
                clockHandView.getClass();
                clockHandView.b(((Float) valueAnimator2.getAnimatedValue()).floatValue(), true);
            }
        });
        valueAnimator.addListener(new a());
        valueAnimator.start();
    }
}
