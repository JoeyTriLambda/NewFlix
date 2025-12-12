package ba;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import java.util.ArrayList;
import x0.p;

/* compiled from: SwipeDismissRecyclerViewTouchListener.java */
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {
    public boolean A;

    /* renamed from: b, reason: collision with root package name */
    public final int f4802b;

    /* renamed from: m, reason: collision with root package name */
    public final int f4803m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4804n;

    /* renamed from: o, reason: collision with root package name */
    public final long f4805o;

    /* renamed from: p, reason: collision with root package name */
    public final RecyclerView f4806p;

    /* renamed from: q, reason: collision with root package name */
    public final b f4807q;

    /* renamed from: r, reason: collision with root package name */
    public int f4808r = 1;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f4809s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public int f4810t = 0;

    /* renamed from: u, reason: collision with root package name */
    public float f4811u;

    /* renamed from: v, reason: collision with root package name */
    public float f4812v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4813w;

    /* renamed from: x, reason: collision with root package name */
    public VelocityTracker f4814x;

    /* renamed from: y, reason: collision with root package name */
    public int f4815y;

    /* renamed from: z, reason: collision with root package name */
    public View f4816z;

    /* compiled from: SwipeDismissRecyclerViewTouchListener.java */
    public interface b {
    }

    /* compiled from: SwipeDismissRecyclerViewTouchListener.java */
    public class c implements Comparable<c> {

        /* renamed from: b, reason: collision with root package name */
        public final int f4818b;

        /* renamed from: m, reason: collision with root package name */
        public final View f4819m;

        public c(a aVar, int i10, View view) {
            this.f4818b = i10;
            this.f4819m = view;
        }

        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            return cVar.f4818b - this.f4818b;
        }
    }

    public a(RecyclerView recyclerView, b bVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
        this.f4802b = viewConfiguration.getScaledTouchSlop();
        this.f4803m = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f4804n = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4805o = recyclerView.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f4806p = recyclerView;
        this.f4807q = bVar;
    }

    public RecyclerView.p makeScrollListener() {
        return new C0055a();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"AndroidLintClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int i10;
        int i11 = this.f4808r;
        RecyclerView recyclerView = this.f4806p;
        if (i11 < 2) {
            this.f4808r = recyclerView.getWidth();
        }
        int actionMasked = p.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            if (this.A) {
                return false;
            }
            Rect rect = new Rect();
            int childCount = recyclerView.getChildCount();
            int[] iArr = new int[2];
            recyclerView.getLocationOnScreen(iArr);
            int rawX = ((int) motionEvent.getRawX()) - iArr[0];
            int rawY = ((int) motionEvent.getRawY()) - iArr[1];
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i12);
                childAt.getHitRect(rect);
                if (rect.contains(rawX, rawY)) {
                    this.f4816z = childAt;
                    break;
                }
                i12++;
            }
            if (this.f4816z != null) {
                this.f4811u = motionEvent.getRawX();
                this.f4812v = motionEvent.getRawY();
                int childAdapterPosition = recyclerView.getChildAdapterPosition(this.f4816z);
                this.f4815y = childAdapterPosition;
                if (((SuperRecyclerView.b) this.f4807q).canDismiss(childAdapterPosition)) {
                    VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                    this.f4814x = velocityTrackerObtain;
                    velocityTrackerObtain.addMovement(motionEvent);
                } else {
                    this.f4816z = null;
                }
            }
            return false;
        }
        long j10 = this.f4805o;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.f4814x;
                if (velocityTracker != null && !this.A) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f4811u;
                    float rawY2 = motionEvent.getRawY() - this.f4812v;
                    float fAbs = Math.abs(rawX2);
                    int i13 = this.f4802b;
                    if (fAbs > i13 && Math.abs(rawY2) < Math.abs(rawX2) / 2.0f) {
                        this.f4813w = true;
                        if (rawX2 <= 0.0f) {
                            i13 = -i13;
                        }
                        recyclerView.requestDisallowInterceptTouchEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction((p.getActionIndex(motionEvent) << 8) | 3);
                        recyclerView.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        if (this.f4813w) {
                            ma.a.setTranslationX(this.f4816z, rawX2 - i13);
                            ma.a.setAlpha(this.f4816z, Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX2) * 2.0f) / this.f4808r))));
                        }
                    }
                    if (this.f4813w) {
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.f4814x != null) {
                View view2 = this.f4816z;
                if (view2 != null && this.f4813w) {
                    ma.b.animate(view2).translationX(0.0f).alpha(1.0f).setDuration(j10).setListener(null);
                }
                this.f4814x.recycle();
                this.f4814x = null;
                this.f4811u = 0.0f;
                this.f4812v = 0.0f;
                this.f4816z = null;
                this.f4815y = -1;
                this.f4813w = false;
            }
        } else if (this.f4814x != null) {
            float rawX3 = motionEvent.getRawX() - this.f4811u;
            this.f4814x.addMovement(motionEvent);
            this.f4814x.computeCurrentVelocity(1000);
            float xVelocity = this.f4814x.getXVelocity();
            float fAbs2 = Math.abs(xVelocity);
            float fAbs3 = Math.abs(this.f4814x.getYVelocity());
            if (Math.abs(rawX3) <= this.f4808r / 2 || !this.f4813w) {
                if (this.f4803m > fAbs2 || fAbs2 > this.f4804n || fAbs3 >= fAbs2 || !this.f4813w) {
                    z10 = false;
                } else {
                    z10 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX3 > 0.0f ? 1 : (rawX3 == 0.0f ? 0 : -1)) < 0);
                    if (this.f4814x.getXVelocity() > 0.0f) {
                        z11 = true;
                    }
                }
                z11 = false;
            } else {
                z11 = rawX3 > 0.0f;
                z10 = true;
            }
            if (!z10 || (i10 = this.f4815y) == -1) {
                ma.b.animate(this.f4816z).translationX(0.0f).alpha(1.0f).setDuration(j10).setListener(null);
            } else {
                View view3 = this.f4816z;
                this.f4810t++;
                ma.b.animate(view3).translationX(z11 ? this.f4808r : -this.f4808r).alpha(0.0f).setDuration(j10).setListener(new ba.b(this, i10, view3));
            }
            this.f4814x.recycle();
            this.f4814x = null;
            this.f4811u = 0.0f;
            this.f4812v = 0.0f;
            this.f4816z = null;
            this.f4815y = -1;
            this.f4813w = false;
        }
        return false;
    }

    public void setEnabled(boolean z10) {
        this.A = !z10;
    }

    /* compiled from: SwipeDismissRecyclerViewTouchListener.java */
    /* renamed from: ba.a$a, reason: collision with other inner class name */
    public class C0055a extends RecyclerView.p {
        public C0055a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            a.this.setEnabled(i10 != 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        }
    }
}
