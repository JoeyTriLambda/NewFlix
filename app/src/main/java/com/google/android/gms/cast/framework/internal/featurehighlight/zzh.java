package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzep;
import x0.g;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzh extends ViewGroup {

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f6429y = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f6430b;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f6431m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f6432n;

    /* renamed from: o, reason: collision with root package name */
    public final OuterHighlightDrawable f6433o;

    /* renamed from: p, reason: collision with root package name */
    public final InnerZoneDrawable f6434p;

    /* renamed from: q, reason: collision with root package name */
    public View f6435q;

    /* renamed from: r, reason: collision with root package name */
    public Animator f6436r;

    /* renamed from: s, reason: collision with root package name */
    public final zzi f6437s;

    /* renamed from: t, reason: collision with root package name */
    public final g f6438t;

    /* renamed from: u, reason: collision with root package name */
    public g f6439u;

    /* renamed from: v, reason: collision with root package name */
    public zzg f6440v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6441w;

    /* renamed from: x, reason: collision with root package name */
    public HelpTextView f6442x;

    public zzh(Context context) {
        super(context);
        this.f6430b = new int[2];
        this.f6431m = new Rect();
        this.f6432n = new Rect();
        setId(R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.f6434p = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.f6433o = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.f6437s = new zzi(this);
        g gVar = new g(context, new zza(this));
        this.f6438t = gVar;
        gVar.setIsLongpressEnabled(false);
        setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.save();
        OuterHighlightDrawable outerHighlightDrawable = this.f6433o;
        outerHighlightDrawable.draw(canvas);
        this.f6434p.draw(canvas);
        View view = this.f6435q;
        if (view == null) {
            throw new IllegalStateException("Neither target view nor drawable was set");
        }
        if (view.getParent() != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f6435q.getWidth(), this.f6435q.getHeight(), Bitmap.Config.ARGB_8888);
            this.f6435q.draw(new Canvas(bitmapCreateBitmap));
            int iZzc = outerHighlightDrawable.zzc();
            int iRed = Color.red(iZzc);
            int iGreen = Color.green(iZzc);
            int iBlue = Color.blue(iZzc);
            for (int i10 = 0; i10 < bitmapCreateBitmap.getHeight(); i10++) {
                for (int i11 = 0; i11 < bitmapCreateBitmap.getWidth(); i11++) {
                    int pixel = bitmapCreateBitmap.getPixel(i11, i10);
                    if (Color.alpha(pixel) != 0) {
                        bitmapCreateBitmap.setPixel(i11, i10, Color.argb(Color.alpha(pixel), iRed, iGreen, iBlue));
                    }
                }
            }
            Rect rect = this.f6431m;
            canvas.drawBitmap(bitmapCreateBitmap, rect.left, rect.top, (Paint) null);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f6435q;
        if (view == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        ViewParent parent = view.getParent();
        int[] iArr = this.f6430b;
        if (parent != null) {
            View view2 = this.f6435q;
            getLocationInWindow(iArr);
            int i14 = iArr[0];
            int i15 = iArr[1];
            view2.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i14;
            iArr[1] = iArr[1] - i15;
        }
        int i16 = iArr[0];
        int i17 = iArr[1];
        int width = this.f6435q.getWidth() + i16;
        int height = this.f6435q.getHeight() + iArr[1];
        Rect rect = this.f6431m;
        rect.set(i16, i17, width, height);
        Rect rect2 = this.f6432n;
        rect2.set(i10, i11, i12, i13);
        this.f6433o.setBounds(rect2);
        this.f6434p.setBounds(rect2);
        zzi zziVar = this.f6437s;
        zzh zzhVar = zziVar.f6448f;
        View viewAsView = zzhVar.f6442x.asView();
        if (rect.isEmpty() || rect2.isEmpty()) {
            viewAsView.layout(0, 0, 0, 0);
        } else {
            int iCenterY = rect.centerY();
            int iCenterX = rect.centerX();
            int iCenterY2 = rect2.centerY();
            int iHeight = rect.height();
            int i18 = zziVar.f6444b;
            int iMax = Math.max(i18 + i18, iHeight) / 2;
            int i19 = iCenterY + iMax;
            int i20 = zziVar.f6445c;
            if (iCenterY < iCenterY2) {
                int i21 = i19 + i20;
                zziVar.b(viewAsView, rect2.width(), rect2.bottom - i21);
                int iA = zziVar.a(viewAsView, rect2.left, rect2.right, viewAsView.getMeasuredWidth(), iCenterX);
                viewAsView.layout(iA, i21, viewAsView.getMeasuredWidth() + iA, viewAsView.getMeasuredHeight() + i21);
            } else {
                int i22 = (iCenterY - iMax) - i20;
                zziVar.b(viewAsView, rect2.width(), i22 - rect2.top);
                int iA2 = zziVar.a(viewAsView, rect2.left, rect2.right, viewAsView.getMeasuredWidth(), iCenterX);
                viewAsView.layout(iA2, i22 - viewAsView.getMeasuredHeight(), viewAsView.getMeasuredWidth() + iA2, i22);
            }
        }
        int left = viewAsView.getLeft();
        int top = viewAsView.getTop();
        int right = viewAsView.getRight();
        int bottom = viewAsView.getBottom();
        Rect rect3 = zziVar.f6443a;
        rect3.set(left, top, right, bottom);
        zzhVar.f6433o.zzf(rect, rect3);
        zzhVar.f6434p.zzb(rect);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i10), i10), View.resolveSize(View.MeasureSpec.getSize(i11), i11));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6441w = this.f6431m.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.f6441w) {
            g gVar = this.f6439u;
            if (gVar != null) {
                gVar.onTouchEvent(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.f6435q.getParent() != null) {
                this.f6435q.onTouchEvent(motionEvent);
            }
        } else {
            this.f6438t.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6433o || drawable == this.f6434p || drawable == null;
    }

    public final void zzg(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f6442x.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzep.zza());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f6433o, PropertyValuesHolder.ofFloat("scale", 1.125f), PropertyValuesHolder.ofInt("alpha", 0));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zzep.zza());
        Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(200L);
        Animator animatorZza = this.f6434p.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, animatorZza);
        animatorSet.addListener(new zze(this, runnable));
        Animator animator = this.f6436r;
        if (animator != null) {
            animator.cancel();
        }
        this.f6436r = animatorSet;
        animatorSet.start();
    }

    public final void zzh(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f6442x.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzep.zza());
        Rect rect = this.f6431m;
        float fExactCenterX = rect.exactCenterX();
        OuterHighlightDrawable outerHighlightDrawable = this.f6433o;
        float fZza = fExactCenterX - outerHighlightDrawable.zza();
        float fExactCenterY = rect.exactCenterY() - outerHighlightDrawable.zzb();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofFloat("translationX", 0.0f, fZza), PropertyValuesHolder.ofFloat("translationY", 0.0f, fExactCenterY), PropertyValuesHolder.ofInt("alpha", 0));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zzep.zza());
        Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(200L);
        Animator animatorZza = this.f6434p.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, animatorZza);
        animatorSet.addListener(new zzf(this, runnable));
        Animator animator = this.f6436r;
        if (animator != null) {
            animator.cancel();
        }
        this.f6436r = animatorSet;
        animatorSet.start();
    }

    public final void zzi(View view, View view2, boolean z10, zzg zzgVar) {
        this.f6435q = view;
        this.f6440v = zzgVar;
        g gVar = new g(getContext(), new zzb(view, zzgVar));
        this.f6439u = gVar;
        gVar.setIsLongpressEnabled(false);
        setVisibility(4);
    }

    public final void zzj(int i10) {
        this.f6433o.zze(i10);
    }

    public final void zzk() {
        if (this.f6435q == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f6442x.asView(), "alpha", 0.0f, 1.0f).setDuration(350L);
        duration.setInterpolator(zzep.zzc());
        Rect rect = this.f6431m;
        float fExactCenterX = rect.exactCenterX();
        OuterHighlightDrawable outerHighlightDrawable = this.f6433o;
        Animator animatorZzd = outerHighlightDrawable.zzd(fExactCenterX - outerHighlightDrawable.zza(), rect.exactCenterY() - outerHighlightDrawable.zzb());
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f6434p, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofInt("alpha", 0, 255));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zzep.zzc());
        Animator duration2 = objectAnimatorOfPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, animatorZzd, duration2);
        animatorSet.addListener(new zzd(this));
        Animator animator = this.f6436r;
        if (animator != null) {
            animator.cancel();
        }
        this.f6436r = animatorSet;
        animatorSet.start();
    }

    public final void zzl(Runnable runnable) {
        addOnLayoutChangeListener(new zzc(this));
    }

    public final void zzn(HelpTextView helpTextView) {
        helpTextView.getClass();
        this.f6442x = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
