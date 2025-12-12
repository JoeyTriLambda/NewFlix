package com.devpaul.materiallibrary.views;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.devpaul.materialfabmenu.R;
import f4.a;
import f4.f;
import f4.g;

/* loaded from: classes.dex */
public class MaterialFloatingActionButton extends View {
    public float A;
    public ObjectAnimator B;
    public int C;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f5574b;

    /* renamed from: m, reason: collision with root package name */
    public Paint f5575m;

    /* renamed from: n, reason: collision with root package name */
    public float f5576n;

    /* renamed from: o, reason: collision with root package name */
    public float f5577o;

    /* renamed from: p, reason: collision with root package name */
    public float f5578p;

    /* renamed from: q, reason: collision with root package name */
    public float f5579q;

    /* renamed from: r, reason: collision with root package name */
    public int f5580r;

    /* renamed from: s, reason: collision with root package name */
    public int f5581s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5582t;

    /* renamed from: u, reason: collision with root package name */
    public f f5583u;

    /* renamed from: v, reason: collision with root package name */
    public g f5584v;

    /* renamed from: w, reason: collision with root package name */
    public Bitmap f5585w;

    /* renamed from: x, reason: collision with root package name */
    public Rect f5586x;

    /* renamed from: y, reason: collision with root package name */
    public RectF f5587y;

    /* renamed from: z, reason: collision with root package name */
    public float f5588z;

    public MaterialFloatingActionButton(Context context, AttributeSet attributeSet) {
        int color;
        super(context, attributeSet);
        this.f5574b = new Paint(1);
        this.f5582t = false;
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            try {
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorAccent});
                color = typedArrayObtainStyledAttributes.getColor(0, -1);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Resources.NotFoundException e10) {
                e10.printStackTrace();
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
                color = -1;
            }
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialFloatingActionButton, 0, 0);
            int color2 = typedArrayObtainStyledAttributes2.getColor(R.styleable.MaterialFloatingActionButton_mat_fab_colorNormal, color == -1 ? getResources().getColor(android.R.color.holo_blue_dark) : color);
            this.f5580r = color2;
            this.f5581s = typedArrayObtainStyledAttributes2.getColor(R.styleable.MaterialFloatingActionButton_mat_fab_colorPressed, a.getDarkerColor(color2));
            this.C = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.MaterialFloatingActionButton_mat_fab_icon, 0);
            this.f5582t = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.MaterialFloatingActionButton_mat_fab_use_selector, false);
            int i10 = typedArrayObtainStyledAttributes2.getInt(R.styleable.MaterialFloatingActionButton_mat_fab_size, 0);
            typedArrayObtainStyledAttributes2.recycle();
            this.f5588z = a(R.dimen.mat_fab_icon_size);
            if (this.C != 0) {
                this.f5585w = BitmapFactory.decodeResource(getResources(), this.C);
                new BitmapDrawable(getResources(), this.f5585w).setAntiAlias(true);
                this.f5586x = new Rect(0, 0, this.f5585w.getWidth(), this.f5585w.getHeight());
                float f10 = this.f5588z;
                this.f5587y = new RectF(0.0f, 0.0f, f10, f10);
            } else {
                this.f5585w = getDefaulBitmap();
                this.f5586x = new Rect(0, 0, this.f5585w.getWidth(), this.f5585w.getHeight());
                float f11 = this.f5588z;
                this.f5587y = new RectF(0.0f, 0.0f, f11, f11);
            }
            float fA = a(R.dimen.mat_fab_shadow_offset) * 1.5f;
            float f12 = fA / 1.5f;
            float fA2 = a(R.dimen.mat_fab_shadow_max_radius);
            float fA3 = a(R.dimen.mat_fab_shadow_min_radius) / 2.0f;
            float fA4 = a(i10 == 0 ? R.dimen.mat_fab_normal_size : R.dimen.mat_fab_mini_size);
            this.f5579q = fA4;
            float f13 = (3.0f * fA) + (4.0f * fA2) + fA4;
            this.f5576n = f13;
            float f14 = f13 / 2.0f;
            this.f5577o = f14;
            this.f5578p = f14;
            this.A = 0.0f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotation", -45.0f);
            this.B = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(200L);
            this.B.setInterpolator(new OvershootInterpolator());
            float f15 = this.f5579q / 2.0f;
            float f16 = this.f5588z / 2.0f;
            RectF rectF = this.f5587y;
            float f17 = this.f5577o;
            float f18 = this.f5578p;
            rectF.set(f17 - f16, f18 - f16, f17 + f16, f18 + f16);
            Paint.Style style = Paint.Style.FILL;
            Paint paint = this.f5574b;
            paint.setStyle(style);
            paint.setColor(this.f5580r);
            Paint paint2 = new Paint();
            this.f5575m = paint2;
            paint2.setAntiAlias(true);
            this.f5575m.setFilterBitmap(true);
            this.f5575m.setDither(true);
            f fVar = new f(this, paint);
            this.f5583u = fVar;
            fVar.setRippleColor(a.getDarkerColor(this.f5580r));
            this.f5583u.setClipRadius(((int) this.f5579q) / 2);
            this.f5583u.setAnimationDuration(200L);
            this.f5583u.setMaxRippleRadius((int) ((this.f5579q * 0.75f) / 2.0f));
            f fVar2 = this.f5583u;
            float f19 = this.f5577o;
            float f20 = this.f5578p;
            fVar2.setBoundingRect(new RectF(f19 - f15, f20 - f15, f19 + f15, f20 + f15));
            g gVar = new g(this, paint);
            this.f5584v = gVar;
            gVar.setNormalColor(this.f5580r);
            this.f5584v.setPressedColor(this.f5581s);
            this.f5584v.setAnimationDuration(200L);
            this.f5584v.setShadowLimits(f12, fA, fA3, fA2);
            invalidate();
        } catch (Throwable th2) {
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
            throw th2;
        }
    }

    private Bitmap getDefaulBitmap() {
        float f10 = this.f5588z;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) f10, (int) f10, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float fA = a(R.dimen.mat_fab_single_dp);
        float f11 = 4.0f * fA;
        Rect rect = new Rect((int) ((canvas.getWidth() / 2) - fA), ((int) fA) * 4, (int) ((canvas.getWidth() / 2) + fA), (int) (canvas.getHeight() - f11));
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(255);
        canvas.drawRect(rect, paint);
        rect.set((int) f11, (int) ((canvas.getHeight() / 2) - fA), (int) (canvas.getWidth() - f11), (int) ((canvas.getHeight() / 2) + fA));
        canvas.drawRect(rect, paint);
        return bitmapCreateBitmap;
    }

    public final float a(int i10) {
        return getResources().getDimension(i10);
    }

    @Override // android.view.View
    public float getRotation() {
        return this.A;
    }

    public float getSize() {
        return this.f5576n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z10 = this.f5582t;
        Paint paint = this.f5574b;
        if (!z10) {
            this.f5583u.onDrawShadow(paint);
        }
        canvas.drawCircle(this.f5577o, this.f5578p, this.f5579q / 2.0f, paint);
        canvas.save();
        canvas.rotate(this.A, this.f5577o, this.f5578p);
        Bitmap bitmap = this.f5585w;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f5586x, this.f5587y, this.f5575m);
        }
        canvas.restore();
        if (this.f5582t) {
            this.f5584v.onDraw(paint);
        } else {
            this.f5583u.onDrawRipple(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        float f10 = this.f5576n;
        setMeasuredDimension((int) f10, (int) f10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f5582t ? this.f5584v.onTouchEvent(motionEvent) : this.f5583u.onTouchEvent(motionEvent);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setButtonColor(int i10) {
        this.f5580r = i10;
        this.f5574b.setColor(i10);
        invalidate();
    }

    public void setButtonPressedColor(int i10) {
        this.f5581s = i10;
        this.f5584v.setPressedColor(i10);
    }

    public void setIcon(int i10) {
        if (this.C != i10) {
            this.C = i10;
        }
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        this.A = f10;
        invalidate();
    }

    public void setUseSelector(boolean z10) {
        this.f5582t = z10;
    }
}
