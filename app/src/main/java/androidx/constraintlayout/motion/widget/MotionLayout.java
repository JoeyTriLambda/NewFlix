package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import x0.t;

/* loaded from: classes.dex */
public final class MotionLayout extends ConstraintLayout implements t {

    /* renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f1849c0 = 0;
    public float D;
    public int E;
    public int F;
    public int G;
    public float H;
    public float I;
    public float J;
    public long K;
    public float L;
    public c M;
    public i0.b N;
    public boolean O;
    public ArrayList<i0.c> P;
    public ArrayList<i0.c> Q;
    public ArrayList<i0.c> R;
    public CopyOnWriteArrayList<c> S;
    public int T;
    public float U;
    public boolean V;
    public b W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f1850a0;

    /* renamed from: b0, reason: collision with root package name */
    public TransitionState f1851b0;

    public enum TransitionState {
        /* JADX INFO: Fake field, exist only in values array */
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.W.a();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float f1857a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f1858b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        public int f1859c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f1860d = -1;

        public b() {
        }

        public final void a() {
            int i10 = this.f1859c;
            MotionLayout motionLayout = MotionLayout.this;
            if (i10 != -1 || this.f1860d != -1) {
                if (i10 == -1) {
                    motionLayout.transitionToState(this.f1860d);
                } else {
                    int i11 = this.f1860d;
                    if (i11 == -1) {
                        motionLayout.setState(i10, -1, -1);
                    } else {
                        motionLayout.setTransition(i10, i11);
                    }
                }
                motionLayout.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f1858b)) {
                if (Float.isNaN(this.f1857a)) {
                    return;
                }
                motionLayout.setProgress(this.f1857a);
            } else {
                motionLayout.setProgress(this.f1857a, this.f1858b);
                this.f1857a = Float.NaN;
                this.f1858b = Float.NaN;
                this.f1859c = -1;
                this.f1860d = -1;
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f1857a);
            bundle.putFloat("motion.velocity", this.f1858b);
            bundle.putInt("motion.StartState", this.f1859c);
            bundle.putInt("motion.EndState", this.f1860d);
            return bundle;
        }

        public void recordState() {
            MotionLayout motionLayout = MotionLayout.this;
            this.f1860d = motionLayout.G;
            this.f1859c = motionLayout.E;
            this.f1858b = motionLayout.getVelocity();
            this.f1857a = motionLayout.getProgress();
        }

        public void setEndState(int i10) {
            this.f1860d = i10;
        }

        public void setProgress(float f10) {
            this.f1857a = f10;
        }

        public void setStartState(int i10) {
            this.f1859c = i10;
        }

        public void setTransitionState(Bundle bundle) {
            this.f1857a = bundle.getFloat("motion.progress");
            this.f1858b = bundle.getFloat("motion.velocity");
            this.f1859c = bundle.getInt("motion.StartState");
            this.f1860d = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f10) {
            this.f1858b = f10;
        }
    }

    public interface c {
        void onTransitionChange(MotionLayout motionLayout, int i10, int i11, float f10);

        void onTransitionStarted(MotionLayout motionLayout, int i10, int i11);
    }

    public final void c() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if ((this.M == null && ((copyOnWriteArrayList = this.S) == null || copyOnWriteArrayList.isEmpty())) || this.U == this.I) {
            return;
        }
        if (this.T != -1) {
            c cVar = this.M;
            if (cVar != null) {
                cVar.onTransitionStarted(this, this.E, this.G);
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.S;
            if (copyOnWriteArrayList2 != null) {
                Iterator<c> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.E, this.G);
                }
            }
        }
        this.T = -1;
        float f10 = this.I;
        this.U = f10;
        c cVar2 = this.M;
        if (cVar2 != null) {
            cVar2.onTransitionChange(this, this.E, this.G, f10);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList3 = this.S;
        if (copyOnWriteArrayList3 != null) {
            Iterator<c> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.E, this.G, this.I);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        boolean z10;
        int i10;
        ArrayList<i0.c> arrayList = this.R;
        if (arrayList != null) {
            Iterator<i0.c> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPreDraw(canvas);
            }
        }
        if (this.K == -1) {
            this.K = getNanoTime();
        }
        float f10 = this.J;
        if (f10 > 0.0f && f10 < 1.0f) {
            this.F = -1;
        }
        boolean z11 = false;
        if (this.O) {
            float fSignum = Math.signum(this.L - f10);
            long nanoTime = getNanoTime();
            float f11 = (((nanoTime - this.K) * fSignum) * 1.0E-9f) / this.H;
            float f12 = this.J + f11;
            if ((fSignum > 0.0f && f12 >= this.L) || (fSignum <= 0.0f && f12 <= this.L)) {
                f12 = this.L;
            }
            this.J = f12;
            this.I = f12;
            this.K = nanoTime;
            this.D = f11;
            if (Math.abs(f11) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if ((fSignum > 0.0f && f12 >= this.L) || (fSignum <= 0.0f && f12 <= this.L)) {
                f12 = this.L;
            }
            TransitionState transitionState = TransitionState.FINISHED;
            if (f12 >= 1.0f || f12 <= 0.0f) {
                setState(transitionState);
            }
            int childCount = getChildCount();
            this.O = false;
            getNanoTime();
            if (childCount > 0) {
                getChildAt(0);
                throw null;
            }
            boolean z12 = (fSignum > 0.0f && f12 >= this.L) || (fSignum <= 0.0f && f12 <= this.L);
            if (!this.O && z12) {
                setState(transitionState);
            }
            boolean z13 = (!z12) | this.O;
            this.O = z13;
            if (f12 <= 0.0f && (i10 = this.E) != -1 && this.F != i10) {
                this.F = i10;
                throw null;
            }
            if (f12 >= 1.0d) {
                int i11 = this.F;
                int i12 = this.G;
                if (i11 != i12) {
                    this.F = i12;
                    throw null;
                }
            }
            if (z13) {
                invalidate();
            } else if ((fSignum > 0.0f && f12 == 1.0f) || (fSignum < 0.0f && f12 == 0.0f)) {
                setState(transitionState);
            }
        }
        float f13 = this.J;
        if (f13 < 1.0f) {
            if (f13 <= 0.0f) {
                int i13 = this.F;
                int i14 = this.E;
                z10 = i13 != i14;
                this.F = i14;
            }
            if (z11 && !this.V) {
                requestLayout();
            }
            this.I = this.J;
            super.dispatchDraw(canvas);
        }
        int i15 = this.F;
        int i16 = this.G;
        z10 = i15 != i16;
        this.F = i16;
        z11 = z10;
        if (z11) {
            requestLayout();
        }
        this.I = this.J;
        super.dispatchDraw(canvas);
    }

    public void fireTransitionCompleted() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if (!(this.M == null && ((copyOnWriteArrayList = this.S) == null || copyOnWriteArrayList.isEmpty())) && this.T == -1) {
            this.T = this.F;
            throw null;
        }
        if (this.M != null) {
            throw null;
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.S;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty()) {
            throw null;
        }
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.F;
    }

    public ArrayList<a.C0017a> getDefinedTransitions() {
        return null;
    }

    public i0.b getDesignTool() {
        if (this.N == null) {
            this.N = new i0.b(this);
        }
        return this.N;
    }

    public int getEndState() {
        return this.G;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.J;
    }

    public androidx.constraintlayout.motion.widget.a getScene() {
        return null;
    }

    public int getStartState() {
        return this.E;
    }

    public float getTargetPosition() {
        return this.L;
    }

    public Bundle getTransitionState() {
        if (this.W == null) {
            this.W = new b();
        }
        this.W.recordState();
        return this.W.getTransitionState();
    }

    public long getTransitionTimeMs() {
        return (long) (this.H * 1000.0f);
    }

    public float getVelocity() {
        return this.D;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        b bVar = this.W;
        if (bVar != null) {
            if (this.f1850a0) {
                post(new a());
            } else {
                bVar.a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.V = true;
        try {
            super.onLayout(z10, i10, i11, i12, i13);
        } finally {
            this.V = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // x0.s
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // x0.s
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        getNanoTime();
    }

    @Override // x0.s
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof i0.c) {
            i0.c cVar = (i0.c) view;
            if (this.S == null) {
                this.S = new CopyOnWriteArrayList<>();
            }
            this.S.add(cVar);
            if (cVar.isUsedOnShow()) {
                if (this.P == null) {
                    this.P = new ArrayList<>();
                }
                this.P.add(cVar);
            }
            if (cVar.isUseOnHide()) {
                if (this.Q == null) {
                    this.Q = new ArrayList<>();
                }
                this.Q.add(cVar);
            }
            if (cVar.isDecorator()) {
                if (this.R == null) {
                    this.R = new ArrayList<>();
                }
                this.R.add(cVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<i0.c> arrayList = this.P;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<i0.c> arrayList2 = this.Q;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i10) {
        this.f1889v = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        int i10 = this.F;
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f1850a0 = z10;
    }

    public void setInterpolatedProgress(float f10) {
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<i0.c> arrayList = this.Q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.Q.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<i0.c> arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.P.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10, float f11) {
        if (isAttachedToWindow()) {
            setProgress(f10);
            setState(TransitionState.MOVING);
            this.D = f11;
        } else {
            if (this.W == null) {
                this.W = new b();
            }
            this.W.setProgress(f10);
            this.W.setVelocity(f11);
        }
    }

    public void setScene(androidx.constraintlayout.motion.widget.a aVar) {
        isRtl();
        throw null;
    }

    public void setStartState(int i10) {
        if (isAttachedToWindow()) {
            this.F = i10;
            return;
        }
        if (this.W == null) {
            this.W = new b();
        }
        this.W.setStartState(i10);
        this.W.setEndState(i10);
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.F == -1) {
            return;
        }
        TransitionState transitionState3 = this.f1851b0;
        this.f1851b0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            c();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                fireTransitionCompleted();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            c();
        }
        if (transitionState == transitionState2) {
            fireTransitionCompleted();
        }
    }

    public void setTransition(int i10) {
    }

    public void setTransitionDuration(int i10) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(c cVar) {
        this.M = cVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.W == null) {
            this.W = new b();
        }
        this.W.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.W.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return i0.a.getName(context, this.E) + "->" + i0.a.getName(context, this.G) + " (pos:" + this.J + " Dpos/Dt:" + this.D;
    }

    public void transitionToState(int i10) {
        if (isAttachedToWindow()) {
            transitionToState(i10, -1, -1);
            return;
        }
        if (this.W == null) {
            this.W = new b();
        }
        this.W.setEndState(i10);
    }

    @Override // x0.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i10 == 0 && i11 == 0) {
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
    }

    public void setTransition(int i10, int i11) {
        if (isAttachedToWindow()) {
            return;
        }
        if (this.W == null) {
            this.W = new b();
        }
        this.W.setStartState(i10);
        this.W.setEndState(i11);
    }

    public void transitionToState(int i10, int i11, int i12) {
        transitionToState(i10, i11, i12, -1);
    }

    public void setTransition(a.C0017a c0017a) {
        throw null;
    }

    public void transitionToState(int i10, int i11, int i12, int i13) {
        int i14 = this.F;
        if (i14 == i10) {
            return;
        }
        if (this.E == i10) {
            if (i13 > 0) {
                this.H = i13 / 1000.0f;
                return;
            }
            return;
        }
        if (this.G == i10) {
            if (i13 > 0) {
                this.H = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.G = i10;
        if (i14 != -1) {
            setTransition(i14, i10);
            this.J = 0.0f;
            transitionToEnd();
            if (i13 > 0) {
                this.H = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.L = 1.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = getNanoTime();
        getNanoTime();
        if (i13 == -1) {
            throw null;
        }
        this.E = -1;
        throw null;
    }

    public void setProgress(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.W == null) {
                this.W = new b();
            }
            this.W.setProgress(f10);
            return;
        }
        TransitionState transitionState = TransitionState.FINISHED;
        TransitionState transitionState2 = TransitionState.MOVING;
        if (f10 <= 0.0f) {
            if (this.J == 1.0f && this.F == this.G) {
                setState(transitionState2);
            }
            this.F = this.E;
            if (this.J == 0.0f) {
                setState(transitionState);
                return;
            }
            return;
        }
        if (f10 >= 1.0f) {
            if (this.J == 0.0f && this.F == this.E) {
                setState(transitionState2);
            }
            this.F = this.G;
            if (this.J == 1.0f) {
                setState(transitionState);
                return;
            }
            return;
        }
        this.F = -1;
        setState(transitionState2);
    }

    public void setState(int i10, int i11, int i12) {
        setState(TransitionState.SETUP);
        this.F = i10;
        this.E = -1;
        this.G = -1;
        androidx.constraintlayout.widget.c cVar = this.f1889v;
        if (cVar != null) {
            cVar.updateConstraints(i10, i11, i12);
        }
    }

    public void transitionToEnd() {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
    }

    public void setInteractionEnabled(boolean z10) {
    }

    @Override // x0.s
    public void onStopNestedScroll(View view, int i10) {
    }

    @Override // x0.s
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
    }
}
