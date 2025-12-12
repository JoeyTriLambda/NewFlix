package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class MediaNowPlayingView extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f3066b;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f3067m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f3068n;

    /* renamed from: o, reason: collision with root package name */
    public final ObjectAnimator f3069o;

    /* renamed from: p, reason: collision with root package name */
    public final ObjectAnimator f3070p;

    /* renamed from: q, reason: collision with root package name */
    public final ObjectAnimator f3071q;

    public MediaNowPlayingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        LayoutInflater.from(context).inflate(R.layout.lb_playback_now_playing_bars, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.bar1);
        this.f3066b = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.bar2);
        this.f3067m = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.bar3);
        this.f3068n = imageView3;
        imageView.setPivotY(imageView.getDrawable().getIntrinsicHeight());
        imageView2.setPivotY(imageView2.getDrawable().getIntrinsicHeight());
        imageView3.setPivotY(imageView3.getDrawable().getIntrinsicHeight());
        setDropScale(imageView);
        setDropScale(imageView2);
        setDropScale(imageView3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "scaleY", 0.41666666f, 0.25f, 0.41666666f, 0.5833333f, 0.75f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.5f, 0.33333334f, 0.16666667f, 0.33333334f, 0.5f, 0.5833333f, 0.75f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.41666666f, 0.25f, 0.33333334f, 0.41666666f);
        this.f3069o = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(2320L);
        objectAnimatorOfFloat.setInterpolator(linearInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "scaleY", 1.0f, 0.9166667f, 0.8333333f, 0.9166667f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.41666666f, 0.25f, 0.41666666f, 0.6666667f, 0.8333333f, 1.0f, 0.8333333f, 0.75f, 0.6666667f, 1.0f);
        this.f3070p = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setDuration(2080L);
        objectAnimatorOfFloat2.setInterpolator(linearInterpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView3, "scaleY", 0.6666667f, 0.75f, 0.8333333f, 1.0f, 0.9166667f, 0.75f, 0.5833333f, 0.41666666f, 0.5833333f, 0.6666667f, 0.75f, 1.0f, 0.9166667f, 1.0f, 0.75f, 0.5833333f, 0.75f, 0.9166667f, 1.0f, 0.8333333f, 0.6666667f, 0.75f, 0.5833333f, 0.41666666f, 0.25f, 0.6666667f);
        this.f3071q = objectAnimatorOfFloat3;
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setDuration(2000L);
        objectAnimatorOfFloat3.setInterpolator(linearInterpolator);
    }

    public static void setDropScale(View view) {
        view.setScaleY(0.083333336f);
    }

    public final void a() {
        ObjectAnimator objectAnimator = this.f3069o;
        if (!objectAnimator.isStarted()) {
            objectAnimator.start();
        }
        ObjectAnimator objectAnimator2 = this.f3070p;
        if (!objectAnimator2.isStarted()) {
            objectAnimator2.start();
        }
        ObjectAnimator objectAnimator3 = this.f3071q;
        if (!objectAnimator3.isStarted()) {
            objectAnimator3.start();
        }
        this.f3066b.setVisibility(0);
        this.f3067m.setVisibility(0);
        this.f3068n.setVisibility(0);
    }

    public final void b() {
        ObjectAnimator objectAnimator = this.f3069o;
        boolean zIsStarted = objectAnimator.isStarted();
        ImageView imageView = this.f3066b;
        if (zIsStarted) {
            objectAnimator.cancel();
            setDropScale(imageView);
        }
        ObjectAnimator objectAnimator2 = this.f3070p;
        boolean zIsStarted2 = objectAnimator2.isStarted();
        ImageView imageView2 = this.f3067m;
        if (zIsStarted2) {
            objectAnimator2.cancel();
            setDropScale(imageView2);
        }
        ObjectAnimator objectAnimator3 = this.f3071q;
        boolean zIsStarted3 = objectAnimator3.isStarted();
        ImageView imageView3 = this.f3068n;
        if (zIsStarted3) {
            objectAnimator3.cancel();
            setDropScale(imageView3);
        }
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 8) {
            b();
        } else {
            a();
        }
    }
}
