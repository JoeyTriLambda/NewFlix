package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.leanback.R;

/* loaded from: classes.dex */
public final class SeekBar extends View {

    /* renamed from: b, reason: collision with root package name */
    public final RectF f3162b;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f3163m;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f3164n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f3165o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f3166p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f3167q;

    /* renamed from: r, reason: collision with root package name */
    public final Paint f3168r;

    /* renamed from: s, reason: collision with root package name */
    public int f3169s;

    /* renamed from: t, reason: collision with root package name */
    public int f3170t;

    /* renamed from: u, reason: collision with root package name */
    public int f3171u;

    /* renamed from: v, reason: collision with root package name */
    public int f3172v;

    /* renamed from: w, reason: collision with root package name */
    public int f3173w;

    /* renamed from: x, reason: collision with root package name */
    public int f3174x;

    /* renamed from: y, reason: collision with root package name */
    public int f3175y;

    public static abstract class a {
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3162b = new RectF();
        this.f3163m = new RectF();
        this.f3164n = new RectF();
        Paint paint = new Paint(1);
        this.f3165o = paint;
        Paint paint2 = new Paint(1);
        this.f3166p = paint2;
        Paint paint3 = new Paint(1);
        this.f3167q = paint3;
        Paint paint4 = new Paint(1);
        this.f3168r = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(-65536);
        paint4.setColor(-1);
        this.f3174x = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_bar_height);
        this.f3175y = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.f3173w = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    public final void a() {
        int i10 = isFocused() ? this.f3175y : this.f3174x;
        int width = getWidth();
        int height = getHeight();
        int i11 = (height - i10) / 2;
        RectF rectF = this.f3164n;
        int i12 = this.f3174x;
        float f10 = i11;
        float f11 = height - i11;
        rectF.set(i12 / 2, f10, width - (i12 / 2), f11);
        int i13 = isFocused() ? this.f3173w : this.f3174x / 2;
        float f12 = width - (i13 * 2);
        float f13 = (this.f3169s / this.f3171u) * f12;
        RectF rectF2 = this.f3162b;
        int i14 = this.f3174x;
        rectF2.set(i14 / 2, f10, (i14 / 2) + f13, f11);
        this.f3163m.set(rectF2.right, f10, (this.f3174x / 2) + ((this.f3170t / this.f3171u) * f12), f11);
        this.f3172v = i13 + ((int) f13);
        invalidate();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.f3171u;
    }

    public int getProgress() {
        return this.f3169s;
    }

    public int getSecondProgress() {
        return this.f3170t;
    }

    public int getSecondaryProgressColor() {
        return this.f3165o.getColor();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = isFocused() ? this.f3173w : this.f3174x / 2;
        canvas.drawRoundRect(this.f3164n, f10, f10, this.f3167q);
        RectF rectF = this.f3163m;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f10, f10, this.f3165o);
        }
        canvas.drawRoundRect(this.f3162b, f10, f10, this.f3166p);
        canvas.drawCircle(this.f3172v, getHeight() / 2, f10, this.f3168r);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        a();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setActiveBarHeight(int i10) {
        this.f3175y = i10;
        a();
    }

    public void setActiveRadius(int i10) {
        this.f3173w = i10;
        a();
    }

    public void setBarHeight(int i10) {
        this.f3174x = i10;
        a();
    }

    public void setMax(int i10) {
        this.f3171u = i10;
        a();
    }

    public void setProgress(int i10) {
        int i11 = this.f3171u;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.f3169s = i10;
        a();
    }

    public void setProgressColor(int i10) {
        this.f3166p.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.f3171u;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.f3170t = i10;
        a();
    }

    public void setSecondaryProgressColor(int i10) {
        this.f3165o.setColor(i10);
    }

    public void setAccessibilitySeekListener(a aVar) {
    }
}
