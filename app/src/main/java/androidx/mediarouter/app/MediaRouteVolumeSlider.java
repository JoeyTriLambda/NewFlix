package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.R;
import androidx.appcompat.widget.x;

/* loaded from: classes.dex */
class MediaRouteVolumeSlider extends x {

    /* renamed from: m, reason: collision with root package name */
    public final float f3574m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3575n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f3576o;

    /* renamed from: p, reason: collision with root package name */
    public int f3577p;

    /* renamed from: q, reason: collision with root package name */
    public int f3578q;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    @Override // androidx.appcompat.widget.x, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i10 = isEnabled() ? 255 : (int) (this.f3574m * 255.0f);
        this.f3576o.setColorFilter(this.f3577p, PorterDuff.Mode.SRC_IN);
        this.f3576o.setAlpha(i10);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
            layerDrawable.findDrawableByLayerId(android.R.id.background).setColorFilter(this.f3578q, PorterDuff.Mode.SRC_IN);
            progressDrawable = drawableFindDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f3577p, PorterDuff.Mode.SRC_IN);
        progressDrawable.setAlpha(i10);
    }

    public void setColor(int i10) {
        setColor(i10, i10);
    }

    public void setHideThumb(boolean z10) {
        if (this.f3575n == z10) {
            return;
        }
        this.f3575n = z10;
        super.setThumb(z10 ? null : this.f3576o);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.f3576o = drawable;
        if (this.f3575n) {
            drawable = null;
        }
        super.setThumb(drawable);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3574m = r.d(context);
    }

    public void setColor(int i10, int i11) {
        if (this.f3577p != i10) {
            if (Color.alpha(i10) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i10));
            }
            this.f3577p = i10;
        }
        if (this.f3578q != i11) {
            if (Color.alpha(i11) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i11));
            }
            this.f3578q = i11;
        }
    }
}
