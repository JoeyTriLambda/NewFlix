package de.hdodenhof.circleimageview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType F = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config G = Bitmap.Config.ARGB_8888;
    public ColorFilter A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f11019b;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f11020m;

    /* renamed from: n, reason: collision with root package name */
    public final Matrix f11021n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f11022o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f11023p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f11024q;

    /* renamed from: r, reason: collision with root package name */
    public int f11025r;

    /* renamed from: s, reason: collision with root package name */
    public int f11026s;

    /* renamed from: t, reason: collision with root package name */
    public int f11027t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f11028u;

    /* renamed from: v, reason: collision with root package name */
    public BitmapShader f11029v;

    /* renamed from: w, reason: collision with root package name */
    public int f11030w;

    /* renamed from: x, reason: collision with root package name */
    public int f11031x;

    /* renamed from: y, reason: collision with root package name */
    public float f11032y;

    /* renamed from: z, reason: collision with root package name */
    public float f11033z;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.f11020m.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        Bitmap bitmap = null;
        if (this.E) {
            this.f11028u = null;
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    try {
                        boolean z10 = drawable instanceof ColorDrawable;
                        Bitmap.Config config = G;
                        Bitmap bitmapCreateBitmap = z10 ? Bitmap.createBitmap(2, 2, config) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), config);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                        bitmap = bitmapCreateBitmap;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            this.f11028u = bitmap;
        }
        b();
    }

    public final void b() {
        float fWidth;
        float fHeight;
        int i10;
        if (!this.B) {
            this.C = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f11028u == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.f11028u;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f11029v = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = this.f11022o;
        paint.setAntiAlias(true);
        paint.setShader(this.f11029v);
        Paint.Style style = Paint.Style.STROKE;
        Paint paint2 = this.f11023p;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f11025r);
        paint2.setStrokeWidth(this.f11026s);
        Paint.Style style2 = Paint.Style.FILL;
        Paint paint3 = this.f11024q;
        paint3.setStyle(style2);
        paint3.setAntiAlias(true);
        paint3.setColor(this.f11027t);
        this.f11031x = this.f11028u.getHeight();
        this.f11030w = this.f11028u.getWidth();
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = ((r1 - iMin) / 2.0f) + getPaddingLeft();
        float paddingTop = ((r2 - iMin) / 2.0f) + getPaddingTop();
        float f10 = iMin;
        RectF rectF = new RectF(paddingLeft, paddingTop, paddingLeft + f10, f10 + paddingTop);
        RectF rectF2 = this.f11020m;
        rectF2.set(rectF);
        this.f11033z = Math.min((rectF2.height() - this.f11026s) / 2.0f, (rectF2.width() - this.f11026s) / 2.0f);
        RectF rectF3 = this.f11019b;
        rectF3.set(rectF2);
        if (!this.D && (i10 = this.f11026s) > 0) {
            float f11 = i10 - 1.0f;
            rectF3.inset(f11, f11);
        }
        this.f11032y = Math.min(rectF3.height() / 2.0f, rectF3.width() / 2.0f);
        paint.setColorFilter(this.A);
        Matrix matrix = this.f11021n;
        matrix.set(null);
        float fWidth2 = 0.0f;
        if (rectF3.height() * this.f11030w > rectF3.width() * this.f11031x) {
            fWidth = rectF3.height() / this.f11031x;
            fWidth2 = (rectF3.width() - (this.f11030w * fWidth)) * 0.5f;
            fHeight = 0.0f;
        } else {
            fWidth = rectF3.width() / this.f11030w;
            fHeight = (rectF3.height() - (this.f11031x * fWidth)) * 0.5f;
        }
        matrix.setScale(fWidth, fWidth);
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF3.left, ((int) (fHeight + 0.5f)) + rectF3.top);
        this.f11029v.setLocalMatrix(matrix);
        invalidate();
    }

    public int getBorderColor() {
        return this.f11025r;
    }

    public int getBorderWidth() {
        return this.f11026s;
    }

    public int getCircleBackgroundColor() {
        return this.f11027t;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.A;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return F;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.E) {
            super.onDraw(canvas);
            return;
        }
        if (this.f11028u == null) {
            return;
        }
        int i10 = this.f11027t;
        RectF rectF = this.f11019b;
        if (i10 != 0) {
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.f11032y, this.f11024q);
        }
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.f11032y, this.f11022o);
        if (this.f11026s > 0) {
            RectF rectF2 = this.f11020m;
            canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), this.f11033z, this.f11023p);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RectF rectF = this.f11020m;
        return (((Math.pow((double) (y10 - rectF.centerY()), 2.0d) + Math.pow((double) (x10 - rectF.centerX()), 2.0d)) > Math.pow((double) this.f11033z, 2.0d) ? 1 : ((Math.pow((double) (y10 - rectF.centerY()), 2.0d) + Math.pow((double) (x10 - rectF.centerX()), 2.0d)) == Math.pow((double) this.f11033z, 2.0d) ? 0 : -1)) <= 0) && super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z10) {
        if (z10) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i10) {
        if (i10 == this.f11025r) {
            return;
        }
        this.f11025r = i10;
        this.f11023p.setColor(i10);
        invalidate();
    }

    public void setBorderOverlay(boolean z10) {
        if (z10 == this.D) {
            return;
        }
        this.D = z10;
        b();
    }

    public void setBorderWidth(int i10) {
        if (i10 == this.f11026s) {
            return;
        }
        this.f11026s = i10;
        b();
    }

    public void setCircleBackgroundColor(int i10) {
        if (i10 == this.f11027t) {
            return;
        }
        this.f11027t = i10;
        this.f11024q.setColor(i10);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i10) {
        setCircleBackgroundColor(getContext().getResources().getColor(i10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.A) {
            return;
        }
        this.A = colorFilter;
        this.f11022o.setColorFilter(colorFilter);
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z10) {
        if (this.E == z10) {
            return;
        }
        this.E = z10;
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        b();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        b();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != F) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11019b = new RectF();
        this.f11020m = new RectF();
        this.f11021n = new Matrix();
        this.f11022o = new Paint();
        this.f11023p = new Paint();
        this.f11024q = new Paint();
        this.f11025r = -16777216;
        this.f11026s = 0;
        this.f11027t = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i10, 0);
        this.f11026s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.f11025r = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, -16777216);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.f11027t = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_circle_background_color, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setScaleType(F);
        this.B = true;
        setOutlineProvider(new a());
        if (this.C) {
            b();
            this.C = false;
        }
    }
}
