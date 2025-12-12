package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.loopj.android.http.AsyncHttpClient;
import x0.j0;

/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public final class j extends RecyclerView.k implements RecyclerView.o {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final a B;
    public final b C;

    /* renamed from: a, reason: collision with root package name */
    public final int f4172a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4173b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f4174c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f4175d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4176e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4177f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f4178g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f4179h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4180i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4181j;

    /* renamed from: k, reason: collision with root package name */
    public int f4182k;

    /* renamed from: l, reason: collision with root package name */
    public int f4183l;

    /* renamed from: m, reason: collision with root package name */
    public float f4184m;

    /* renamed from: n, reason: collision with root package name */
    public int f4185n;

    /* renamed from: o, reason: collision with root package name */
    public int f4186o;

    /* renamed from: p, reason: collision with root package name */
    public float f4187p;

    /* renamed from: s, reason: collision with root package name */
    public RecyclerView f4190s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f4197z;

    /* renamed from: q, reason: collision with root package name */
    public int f4188q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f4189r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4191t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4192u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f4193v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f4194w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f4195x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f4196y = new int[2];

    /* compiled from: FastScroller.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            int i10 = jVar.A;
            ValueAnimator valueAnimator = jVar.f4197z;
            if (i10 == 1) {
                valueAnimator.cancel();
            } else if (i10 != 2) {
                return;
            }
            jVar.A = 3;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            valueAnimator.setDuration(500);
            valueAnimator.start();
        }
    }

    /* compiled from: FastScroller.java */
    public class b extends RecyclerView.p {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            j jVar = j.this;
            int iComputeVerticalScrollRange = jVar.f4190s.computeVerticalScrollRange();
            int i12 = jVar.f4189r;
            int i13 = iComputeVerticalScrollRange - i12;
            int i14 = jVar.f4172a;
            jVar.f4191t = i13 > 0 && i12 >= i14;
            int iComputeHorizontalScrollRange = jVar.f4190s.computeHorizontalScrollRange();
            int i15 = jVar.f4188q;
            boolean z10 = iComputeHorizontalScrollRange - i15 > 0 && i15 >= i14;
            jVar.f4192u = z10;
            boolean z11 = jVar.f4191t;
            if (!z11 && !z10) {
                if (jVar.f4193v != 0) {
                    jVar.c(0);
                    return;
                }
                return;
            }
            if (z11) {
                float f10 = i12;
                jVar.f4183l = (int) ((((f10 / 2.0f) + iComputeVerticalScrollOffset) * f10) / iComputeVerticalScrollRange);
                jVar.f4182k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
            }
            if (jVar.f4192u) {
                float f11 = iComputeHorizontalScrollOffset;
                float f12 = i15;
                jVar.f4186o = (int) ((((f12 / 2.0f) + f11) * f12) / iComputeHorizontalScrollRange);
                jVar.f4185n = Math.min(i15, (i15 * i15) / iComputeHorizontalScrollRange);
            }
            int i16 = jVar.f4193v;
            if (i16 == 0 || i16 == 1) {
                jVar.c(1);
            }
        }
    }

    /* compiled from: FastScroller.java */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public boolean f4200b = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4200b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4200b) {
                this.f4200b = false;
                return;
            }
            j jVar = j.this;
            if (((Float) jVar.f4197z.getAnimatedValue()).floatValue() == 0.0f) {
                jVar.A = 0;
                jVar.c(0);
            } else {
                jVar.A = 2;
                jVar.f4190s.invalidate();
            }
        }
    }

    /* compiled from: FastScroller.java */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j jVar = j.this;
            jVar.f4174c.setAlpha(iFloatValue);
            jVar.f4175d.setAlpha(iFloatValue);
            jVar.f4190s.invalidate();
        }
    }

    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4197z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f4174c = stateListDrawable;
        this.f4175d = drawable;
        this.f4178g = stateListDrawable2;
        this.f4179h = drawable2;
        this.f4176e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f4177f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f4180i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f4181j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f4172a = i11;
        this.f4173b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        attachToRecyclerView(recyclerView);
    }

    public final boolean a(float f10, float f11) {
        if (f11 >= this.f4189r - this.f4180i) {
            int i10 = this.f4186o;
            int i11 = this.f4185n;
            if (f10 >= i10 - (i11 / 2) && f10 <= (i11 / 2) + i10) {
                return true;
            }
        }
        return false;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4190s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        b bVar = this.C;
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f4190s.removeOnItemTouchListener(this);
            this.f4190s.removeOnScrollListener(bVar);
            this.f4190s.removeCallbacks(this.B);
        }
        this.f4190s = recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
            this.f4190s.addOnItemTouchListener(this);
            this.f4190s.addOnScrollListener(bVar);
        }
    }

    public final boolean b(float f10, float f11) {
        boolean z10 = j0.getLayoutDirection(this.f4190s) == 1;
        int i10 = this.f4176e;
        if (z10) {
            if (f10 > i10) {
                return false;
            }
        } else if (f10 < this.f4188q - i10) {
            return false;
        }
        int i11 = this.f4183l;
        int i12 = this.f4182k / 2;
        return f11 >= ((float) (i11 - i12)) && f11 <= ((float) (i12 + i11));
    }

    public final void c(int i10) {
        a aVar = this.B;
        StateListDrawable stateListDrawable = this.f4174c;
        if (i10 == 2 && this.f4193v != 2) {
            stateListDrawable.setState(D);
            this.f4190s.removeCallbacks(aVar);
        }
        if (i10 == 0) {
            this.f4190s.invalidate();
        } else {
            show();
        }
        if (this.f4193v == 2 && i10 != 2) {
            stateListDrawable.setState(E);
            this.f4190s.removeCallbacks(aVar);
            this.f4190s.postDelayed(aVar, 1200);
        } else if (i10 == 1) {
            this.f4190s.removeCallbacks(aVar);
            this.f4190s.postDelayed(aVar, AsyncHttpClient.DEFAULT_RETRY_SLEEP_TIME_MILLIS);
        }
        this.f4193v = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar) {
        if (this.f4188q != this.f4190s.getWidth() || this.f4189r != this.f4190s.getHeight()) {
            this.f4188q = this.f4190s.getWidth();
            this.f4189r = this.f4190s.getHeight();
            c(0);
            return;
        }
        if (this.A != 0) {
            if (this.f4191t) {
                int i10 = this.f4188q;
                int i11 = this.f4176e;
                int i12 = i10 - i11;
                int i13 = this.f4183l;
                int i14 = this.f4182k;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable = this.f4174c;
                stateListDrawable.setBounds(0, 0, i11, i14);
                int i16 = this.f4189r;
                int i17 = this.f4177f;
                Drawable drawable = this.f4175d;
                drawable.setBounds(0, 0, i17, i16);
                if (j0.getLayoutDirection(this.f4190s) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i11, i15);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i11, -i15);
                } else {
                    canvas.translate(i12, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i15);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i12, -i15);
                }
            }
            if (this.f4192u) {
                int i18 = this.f4189r;
                int i19 = this.f4180i;
                int i20 = i18 - i19;
                int i21 = this.f4186o;
                int i22 = this.f4185n;
                int i23 = i21 - (i22 / 2);
                StateListDrawable stateListDrawable2 = this.f4178g;
                stateListDrawable2.setBounds(0, 0, i22, i19);
                int i24 = this.f4188q;
                int i25 = this.f4181j;
                Drawable drawable2 = this.f4179h;
                drawable2.setBounds(0, 0, i24, i25);
                canvas.translate(0.0f, i20);
                drawable2.draw(canvas);
                canvas.translate(i23, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i23, -i20);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f4193v;
        if (i10 == 1) {
            boolean zB = b(motionEvent.getX(), motionEvent.getY());
            boolean zA = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zB && !zA) {
                return false;
            }
            if (zA) {
                this.f4194w = 1;
                this.f4187p = (int) motionEvent.getX();
            } else if (zB) {
                this.f4194w = 2;
                this.f4184m = (int) motionEvent.getY();
            }
            c(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onTouchEvent(androidx.recyclerview.widget.RecyclerView r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.j.onTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void");
    }

    public void show() {
        int i10 = this.A;
        ValueAnimator valueAnimator = this.f4197z;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }
}
