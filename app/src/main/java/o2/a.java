package o2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.swiperefreshlayout.R;
import x0.j0;

/* compiled from: CircleImageView.java */
/* loaded from: classes.dex */
public final class a extends ImageView {

    /* renamed from: b, reason: collision with root package name */
    public Animation.AnimationListener f16951b;

    /* renamed from: m, reason: collision with root package name */
    public int f16952m;

    public a(Context context) {
        super(context);
        float f10 = getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f16952m = typedArrayObtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        j0.setElevation(this, f10 * 4.0f);
        shapeDrawable.getPaint().setColor(this.f16952m);
        j0.setBackground(this, shapeDrawable);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f16951b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f16951b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f16951b = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
            this.f16952m = i10;
        }
    }
}
