package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* compiled from: PicassoDrawable.java */
/* loaded from: classes2.dex */
public final class i extends BitmapDrawable {

    /* renamed from: h, reason: collision with root package name */
    public static final Paint f10572h = new Paint();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10573a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10574b;

    /* renamed from: c, reason: collision with root package name */
    public final Picasso.LoadedFrom f10575c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f10576d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10577e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10578f;

    /* renamed from: g, reason: collision with root package name */
    public int f10579g;

    public i(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z10, boolean z11) {
        super(context.getResources(), bitmap);
        this.f10579g = 255;
        this.f10573a = z11;
        this.f10574b = context.getResources().getDisplayMetrics().density;
        this.f10575c = loadedFrom;
        if ((loadedFrom == Picasso.LoadedFrom.MEMORY || z10) ? false : true) {
            this.f10576d = drawable;
            this.f10578f = true;
            this.f10577e = SystemClock.uptimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z10, boolean z11) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new i(context, bitmap, drawable, loadedFrom, z10, z11));
    }

    public static void b(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f10578f) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f10577e) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.f10578f = false;
                this.f10576d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f10576d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f10579g * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f10579g);
            }
        } else {
            super.draw(canvas);
        }
        if (this.f10573a) {
            Paint paint = f10572h;
            paint.setColor(-1);
            float f10 = this.f10574b;
            Path path = new Path();
            float f11 = 0;
            path.moveTo(f11, f11);
            float f12 = ((int) (16.0f * f10)) + 0;
            path.lineTo(f12, f11);
            path.lineTo(f11, f12);
            canvas.drawPath(path, paint);
            paint.setColor(this.f10575c.f10502b);
            Path path2 = new Path();
            path2.moveTo(f11, f11);
            float f13 = ((int) (f10 * 15.0f)) + 0;
            path2.lineTo(f13, f11);
            path2.lineTo(f11, f13);
            canvas.drawPath(path2, paint);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10576d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f10579g = i10;
        Drawable drawable = this.f10576d;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        super.setAlpha(i10);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10576d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
