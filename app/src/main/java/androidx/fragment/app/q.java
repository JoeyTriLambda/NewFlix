package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
public final class q {
    public static int a(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* compiled from: FragmentAnim.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f2904a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f2905b;

        public a(Animation animation) {
            this.f2904a = animation;
            this.f2905b = null;
        }

        public a(Animator animator) {
            this.f2904a = null;
            this.f2905b = animator;
        }
    }

    /* compiled from: FragmentAnim.java */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f2906b;

        /* renamed from: m, reason: collision with root package name */
        public final View f2907m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f2908n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f2909o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f2910p;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2910p = true;
            this.f2906b = viewGroup;
            this.f2907m = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f2910p = true;
            if (this.f2908n) {
                return !this.f2909o;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f2908n = true;
                x0.y.add(this.f2906b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10 = this.f2908n;
            ViewGroup viewGroup = this.f2906b;
            if (z10 || !this.f2910p) {
                viewGroup.endViewTransition(this.f2907m);
                this.f2909o = true;
            } else {
                this.f2910p = false;
                viewGroup.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f2910p = true;
            if (this.f2908n) {
                return !this.f2909o;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f2908n = true;
                x0.y.add(this.f2906b, this);
            }
            return true;
        }
    }
}
