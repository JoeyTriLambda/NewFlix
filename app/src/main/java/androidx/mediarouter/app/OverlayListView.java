package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class OverlayListView extends ListView {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3579b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final BitmapDrawable f3580a;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f3582c;

        /* renamed from: d, reason: collision with root package name */
        public Interpolator f3583d;

        /* renamed from: e, reason: collision with root package name */
        public long f3584e;

        /* renamed from: f, reason: collision with root package name */
        public final Rect f3585f;

        /* renamed from: g, reason: collision with root package name */
        public int f3586g;

        /* renamed from: j, reason: collision with root package name */
        public long f3589j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f3590k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f3591l;

        /* renamed from: m, reason: collision with root package name */
        public InterfaceC0034a f3592m;

        /* renamed from: b, reason: collision with root package name */
        public float f3581b = 1.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f3587h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f3588i = 1.0f;

        /* renamed from: androidx.mediarouter.app.OverlayListView$a$a, reason: collision with other inner class name */
        public interface InterfaceC0034a {
        }

        public a(BitmapDrawable bitmapDrawable, Rect rect) {
            this.f3580a = bitmapDrawable;
            this.f3585f = rect;
            Rect rect2 = new Rect(rect);
            this.f3582c = rect2;
            if (bitmapDrawable != null) {
                bitmapDrawable.setAlpha((int) (this.f3581b * 255.0f));
                bitmapDrawable.setBounds(rect2);
            }
        }

        public BitmapDrawable getBitmapDrawable() {
            return this.f3580a;
        }

        public boolean isAnimationStarted() {
            return this.f3590k;
        }

        public a setAlphaAnimation(float f10, float f11) {
            this.f3587h = f10;
            this.f3588i = f11;
            return this;
        }

        public a setAnimationEndListener(InterfaceC0034a interfaceC0034a) {
            this.f3592m = interfaceC0034a;
            return this;
        }

        public a setDuration(long j10) {
            this.f3584e = j10;
            return this;
        }

        public a setInterpolator(Interpolator interpolator) {
            this.f3583d = interpolator;
            return this;
        }

        public a setTranslateYAnimation(int i10) {
            this.f3586g = i10;
            return this;
        }

        public void startAnimation(long j10) {
            this.f3589j = j10;
            this.f3590k = true;
        }

        public void stopAnimation() {
            this.f3590k = true;
            this.f3591l = true;
            InterfaceC0034a interfaceC0034a = this.f3592m;
            if (interfaceC0034a != null) {
                ((e) interfaceC0034a).onAnimationEnd();
            }
        }

        public boolean update(long j10) {
            if (this.f3591l) {
                return false;
            }
            float fMax = this.f3590k ? Math.max(0.0f, Math.min(1.0f, (j10 - this.f3589j) / this.f3584e)) : 0.0f;
            Interpolator interpolator = this.f3583d;
            float interpolation = interpolator == null ? fMax : interpolator.getInterpolation(fMax);
            int i10 = (int) (this.f3586g * interpolation);
            Rect rect = this.f3585f;
            int i11 = rect.top + i10;
            Rect rect2 = this.f3582c;
            rect2.top = i11;
            rect2.bottom = rect.bottom + i10;
            float f10 = this.f3587h;
            float fA = o1.a.a(this.f3588i, f10, interpolation, f10);
            this.f3581b = fA;
            BitmapDrawable bitmapDrawable = this.f3580a;
            if (bitmapDrawable != null && rect2 != null) {
                bitmapDrawable.setAlpha((int) (fA * 255.0f));
                bitmapDrawable.setBounds(rect2);
            }
            if (this.f3590k && fMax >= 1.0f) {
                this.f3591l = true;
                InterfaceC0034a interfaceC0034a = this.f3592m;
                if (interfaceC0034a != null) {
                    ((e) interfaceC0034a).onAnimationEnd();
                }
            }
            return !this.f3591l;
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3579b = new ArrayList();
    }

    public void addOverlayObject(a aVar) {
        this.f3579b.add(aVar);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f3579b;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BitmapDrawable bitmapDrawable = aVar.getBitmapDrawable();
                if (bitmapDrawable != null) {
                    bitmapDrawable.draw(canvas);
                }
                if (!aVar.update(getDrawingTime())) {
                    it.remove();
                }
            }
        }
    }

    public void startAnimationAll() {
        Iterator it = this.f3579b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.isAnimationStarted()) {
                aVar.startAnimation(getDrawingTime());
            }
        }
    }

    public void stopAnimationAll() {
        Iterator it = this.f3579b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).stopAnimation();
        }
    }
}
