package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.google.android.material.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import w0.h;
import x6.e;
import x6.f;
import x6.g;
import x6.i;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.l implements x6.b, RecyclerView.v.b {
    public int A;
    public int B;
    public int C;

    /* renamed from: p, reason: collision with root package name */
    public int f8915p;

    /* renamed from: q, reason: collision with root package name */
    public int f8916q;

    /* renamed from: r, reason: collision with root package name */
    public int f8917r;

    /* renamed from: s, reason: collision with root package name */
    public final c f8918s;

    /* renamed from: t, reason: collision with root package name */
    public g f8919t;

    /* renamed from: u, reason: collision with root package name */
    public com.google.android.material.carousel.c f8920u;

    /* renamed from: v, reason: collision with root package name */
    public com.google.android.material.carousel.b f8921v;

    /* renamed from: w, reason: collision with root package name */
    public int f8922w;

    /* renamed from: x, reason: collision with root package name */
    public HashMap f8923x;

    /* renamed from: y, reason: collision with root package name */
    public f f8924y;

    /* renamed from: z, reason: collision with root package name */
    public final x6.c f8925z;

    public class a extends m {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.m
        public int calculateDxToMakeVisible(View view, int i10) {
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            if (carouselLayoutManager.f8920u == null || !carouselLayoutManager.isHorizontal()) {
                return 0;
            }
            int position = carouselLayoutManager.getPosition(view);
            return (int) (carouselLayoutManager.f8915p - carouselLayoutManager.w(position, carouselLayoutManager.u(position)));
        }

        @Override // androidx.recyclerview.widget.m
        public int calculateDyToMakeVisible(View view, int i10) {
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            if (carouselLayoutManager.f8920u == null || carouselLayoutManager.isHorizontal()) {
                return 0;
            }
            int position = carouselLayoutManager.getPosition(view);
            return (int) (carouselLayoutManager.f8915p - carouselLayoutManager.w(position, carouselLayoutManager.u(position)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.v
        public PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final View f8927a;

        /* renamed from: b, reason: collision with root package name */
        public final float f8928b;

        /* renamed from: c, reason: collision with root package name */
        public final float f8929c;

        /* renamed from: d, reason: collision with root package name */
        public final d f8930d;

        public b(View view, float f10, float f11, d dVar) {
            this.f8927a = view;
            this.f8928b = f10;
            this.f8929c = f11;
            this.f8930d = dVar;
        }
    }

    public static class c extends RecyclerView.k {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f8931a;

        /* renamed from: b, reason: collision with root package name */
        public List<b.C0084b> f8932b;

        public c() {
            Paint paint = new Paint();
            this.f8931a = paint;
            this.f8932b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar) {
            super.onDrawOver(canvas, recyclerView, wVar);
            Paint paint = this.f8931a;
            paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (b.C0084b c0084b : this.f8932b) {
                paint.setColor(o0.a.blendARGB(-65281, -16776961, c0084b.f8950c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    canvas.drawLine(c0084b.f8949b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f8924y.f(), c0084b.f8949b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f8924y.a(), paint);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f8924y.c(), c0084b.f8949b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f8924y.d(), c0084b.f8949b, paint);
                }
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final b.C0084b f8933a;

        /* renamed from: b, reason: collision with root package name */
        public final b.C0084b f8934b;

        public d(b.C0084b c0084b, b.C0084b c0084b2) {
            h.checkArgument(c0084b.f8948a <= c0084b2.f8948a);
            this.f8933a = c0084b;
            this.f8934b = c0084b2;
        }
    }

    public CarouselLayoutManager() {
        this(new i());
    }

    public static float v(float f10, d dVar) {
        b.C0084b c0084b = dVar.f8933a;
        float f11 = c0084b.f8951d;
        b.C0084b c0084b2 = dVar.f8934b;
        return p6.a.lerp(f11, c0084b2.f8951d, c0084b.f8949b, c0084b2.f8949b, f10);
    }

    public static d y(float f10, List list, boolean z10) {
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = -3.4028235E38f;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < list.size(); i14++) {
            b.C0084b c0084b = (b.C0084b) list.get(i14);
            float f15 = z10 ? c0084b.f8949b : c0084b.f8948a;
            float fAbs = Math.abs(f15 - f10);
            if (f15 <= f10 && fAbs <= f11) {
                i10 = i14;
                f11 = fAbs;
            }
            if (f15 > f10 && fAbs <= f12) {
                i12 = i14;
                f12 = fAbs;
            }
            if (f15 <= f13) {
                i11 = i14;
                f13 = f15;
            }
            if (f15 > f14) {
                i13 = i14;
                f14 = f15;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new d((b.C0084b) list.get(i10), (b.C0084b) list.get(i12));
    }

    public final boolean A(float f10, d dVar) {
        float fV = v(f10, dVar) / 2.0f;
        float f11 = z() ? f10 + fV : f10 - fV;
        return !z() ? f11 <= ((float) t()) : f11 >= 0.0f;
    }

    public final boolean B(float f10, d dVar) {
        float fN = n(f10, v(f10, dVar) / 2.0f);
        return !z() ? fN >= 0.0f : fN <= ((float) t());
    }

    public final b C(RecyclerView.r rVar, float f10, int i10) {
        View viewForPosition = rVar.getViewForPosition(i10);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fN = n(f10, this.f8921v.f8935a / 2.0f);
        d dVarY = y(fN, this.f8921v.f8936b, false);
        return new b(viewForPosition, fN, q(viewForPosition, fN, dVarY), dVarY);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v27 com.google.android.material.carousel.c, still in use, count: 3, list:
          (r5v27 com.google.android.material.carousel.c) from 0x058c: MOVE (r29v0 com.google.android.material.carousel.c) = (r5v27 com.google.android.material.carousel.c)
          (r5v27 com.google.android.material.carousel.c) from 0x04f2: PHI (r5v52 com.google.android.material.carousel.c) = (r5v27 com.google.android.material.carousel.c), (r5v53 com.google.android.material.carousel.c) binds: [B:143:0x04ea, B:162:0x0576] A[DONT_GENERATE, DONT_INLINE]
          (r5v27 com.google.android.material.carousel.c) from 0x0585: PHI (r5v56 com.google.android.material.carousel.c) = (r5v52 com.google.android.material.carousel.c), (r5v27 com.google.android.material.carousel.c) binds: [B:258:0x0585, B:142:0x04c7] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final void D(androidx.recyclerview.widget.RecyclerView.r r32) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.D(androidx.recyclerview.widget.RecyclerView$r):void");
    }

    public final void E() {
        this.f8920u = null;
        requestLayout();
    }

    public final int F(int i10, RecyclerView.r rVar, RecyclerView.w wVar) throws Resources.NotFoundException {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        if (this.f8920u == null) {
            D(rVar);
        }
        int i11 = this.f8915p;
        int i12 = this.f8916q;
        int i13 = this.f8917r;
        int i14 = i11 + i10;
        if (i14 < i12) {
            i10 = i12 - i11;
        } else if (i14 > i13) {
            i10 = i13 - i11;
        }
        this.f8915p = i11 + i10;
        H(this.f8920u);
        float f10 = this.f8921v.f8935a / 2.0f;
        float fR = r(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f11 = z() ? this.f8921v.c().f8949b : this.f8921v.a().f8949b;
        float f12 = Float.MAX_VALUE;
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            float fN = n(fR, f10);
            d dVarY = y(fN, this.f8921v.f8936b, false);
            float fQ = q(childAt, fN, dVarY);
            super.getDecoratedBoundsWithMargins(childAt, rect);
            G(childAt, fN, dVarY);
            this.f8924y.offsetChild(childAt, rect, f10, fQ);
            float fAbs = Math.abs(f11 - fQ);
            if (childAt != null && fAbs < f12) {
                this.B = getPosition(childAt);
                f12 = fAbs;
            }
            fR = n(fR, this.f8921v.f8935a);
        }
        s(rVar, wVar);
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G(View view, float f10, d dVar) {
        if (view instanceof x6.h) {
            b.C0084b c0084b = dVar.f8933a;
            float f11 = c0084b.f8950c;
            b.C0084b c0084b2 = dVar.f8934b;
            float fLerp = p6.a.lerp(f11, c0084b2.f8950c, c0084b.f8948a, c0084b2.f8948a, f10);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF maskRect = this.f8924y.getMaskRect(height, width, p6.a.lerp(0.0f, height / 2.0f, 0.0f, 1.0f, fLerp), p6.a.lerp(0.0f, width / 2.0f, 0.0f, 1.0f, fLerp));
            float fQ = q(view, f10, dVar);
            RectF rectF = new RectF(fQ - (maskRect.width() / 2.0f), fQ - (maskRect.height() / 2.0f), (maskRect.width() / 2.0f) + fQ, (maskRect.height() / 2.0f) + fQ);
            RectF rectF2 = new RectF(this.f8924y.c(), this.f8924y.f(), this.f8924y.d(), this.f8924y.a());
            this.f8919t.getClass();
            this.f8924y.containMaskWithinBounds(maskRect, rectF, rectF2);
            this.f8924y.moveMaskOnEdgeOutsideBounds(maskRect, rectF, rectF2);
            ((x6.h) view).setMaskRectF(maskRect);
        }
    }

    public final void H(com.google.android.material.carousel.c cVar) {
        int i10 = this.f8917r;
        int i11 = this.f8916q;
        if (i10 <= i11) {
            this.f8921v = z() ? cVar.a() : cVar.b();
        } else {
            this.f8921v = cVar.getShiftedState(this.f8915p, i11, i10);
        }
        List<b.C0084b> list = this.f8921v.f8936b;
        c cVar2 = this.f8918s;
        cVar2.getClass();
        cVar2.f8932b = Collections.unmodifiableList(list);
    }

    public final void I() {
        int itemCount = getItemCount();
        int i10 = this.A;
        if (itemCount == i10 || this.f8920u == null) {
            return;
        }
        i iVar = (i) this.f8919t;
        if ((i10 < iVar.f21637c && getItemCount() >= iVar.f21637c) || (i10 >= iVar.f21637c && getItemCount() < iVar.f21637c)) {
            E();
        }
        this.A = itemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollExtent(RecyclerView.w wVar) {
        if (getChildCount() == 0 || this.f8920u == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f8920u.f8956a.f8935a / computeHorizontalScrollRange(wVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollOffset(RecyclerView.w wVar) {
        return this.f8915p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollRange(RecyclerView.w wVar) {
        return this.f8917r - this.f8916q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (this.f8920u == null) {
            return null;
        }
        int iW = w(i10, u(i10)) - this.f8915p;
        return isHorizontal() ? new PointF(iW, 0.0f) : new PointF(0.0f, iW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollExtent(RecyclerView.w wVar) {
        if (getChildCount() == 0 || this.f8920u == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f8920u.f8956a.f8935a / computeVerticalScrollRange(wVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollOffset(RecyclerView.w wVar) {
        return this.f8915p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollRange(RecyclerView.w wVar) {
        return this.f8917r - this.f8916q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateDefaultLayoutParams() {
        return new RecyclerView.m(-2, -2);
    }

    @Override // x6.b
    public int getCarouselAlignment() {
        return this.C;
    }

    @Override // x6.b
    public int getContainerHeight() {
        return getHeight();
    }

    @Override // x6.b
    public int getContainerWidth() {
        return getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (isHorizontal()) {
            fCenterY = rect.centerX();
        }
        float fV = v(fCenterY, y(fCenterY, this.f8921v.f8936b, true));
        float fWidth = isHorizontal() ? (rect.width() - fV) / 2.0f : 0.0f;
        float fHeight = isHorizontal() ? 0.0f : (rect.height() - fV) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.f8924y.f21632a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // x6.b
    public boolean isHorizontal() {
        return this.f8924y.f21632a == 0;
    }

    public final void m(View view, int i10, b bVar) {
        float f10 = this.f8921v.f8935a / 2.0f;
        addView(view, i10);
        float f11 = bVar.f8929c;
        this.f8924y.layoutDecoratedWithMargins(view, (int) (f11 - f10), (int) (f11 + f10));
        G(view, bVar.f8928b, bVar.f8930d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void measureChildWithMargins(View view, int i10, int i11) {
        if (!(view instanceof x6.h)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i12 = rect.left + rect.right + i10;
        int i13 = rect.top + rect.bottom + i11;
        com.google.android.material.carousel.c cVar = this.f8920u;
        view.measure(RecyclerView.l.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + i12, (int) ((cVar == null || this.f8924y.f21632a != 0) ? ((ViewGroup.MarginLayoutParams) mVar).width : cVar.f8956a.f8935a), canScrollHorizontally()), RecyclerView.l.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + i13, (int) ((cVar == null || this.f8924y.f21632a != 1) ? ((ViewGroup.MarginLayoutParams) mVar).height : cVar.f8956a.f8935a), canScrollVertically()));
    }

    public final float n(float f10, float f11) {
        return z() ? f10 - f11 : f10 + f11;
    }

    public final void o(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        float fR = r(i10);
        while (i10 < wVar.getItemCount()) {
            b bVarC = C(rVar, fR, i10);
            float f10 = bVarC.f8929c;
            d dVar = bVarC.f8930d;
            if (A(f10, dVar)) {
                return;
            }
            fR = n(fR, this.f8921v.f8935a);
            if (!B(f10, dVar)) {
                m(bVarC.f8927a, -1, bVarC);
            }
            i10++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onAttachedToWindow(RecyclerView recyclerView) throws Resources.NotFoundException {
        super.onAttachedToWindow(recyclerView);
        g gVar = this.f8919t;
        Context context = recyclerView.getContext();
        float dimension = gVar.f21633a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        gVar.f21633a = dimension;
        float dimension2 = gVar.f21634b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        gVar.f21634b = dimension2;
        E();
        recyclerView.addOnLayoutChangeListener(this.f8925z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.r rVar) {
        super.onDetachedFromWindow(recyclerView, rVar);
        recyclerView.removeOnLayoutChangeListener(this.f8925z);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r6, int r7, androidx.recyclerview.widget.RecyclerView.r r8, androidx.recyclerview.widget.RecyclerView.w r9) {
        /*
            r5 = this;
            int r9 = r5.getChildCount()
            r0 = 0
            if (r9 != 0) goto L8
            return r0
        L8:
            int r9 = r5.getOrientation()
            r1 = 1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = -1
            if (r7 == r1) goto L56
            r4 = 2
            if (r7 == r4) goto L54
            r4 = 17
            if (r7 == r4) goto L48
            r4 = 33
            if (r7 == r4) goto L45
            r4 = 66
            if (r7 == r4) goto L3c
            r4 = 130(0x82, float:1.82E-43)
            if (r7 == r4) goto L39
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown focus request:"
            r9.<init>(r4)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "CarouselLayoutManager"
            android.util.Log.d(r9, r7)
            goto L51
        L39:
            if (r9 != r1) goto L51
            goto L54
        L3c:
            if (r9 != 0) goto L51
            boolean r7 = r5.z()
            if (r7 == 0) goto L54
            goto L56
        L45:
            if (r9 != r1) goto L51
            goto L56
        L48:
            if (r9 != 0) goto L51
            boolean r7 = r5.z()
            if (r7 == 0) goto L56
            goto L54
        L51:
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L57
        L54:
            r7 = 1
            goto L57
        L56:
            r7 = -1
        L57:
            if (r7 != r2) goto L5a
            return r0
        L5a:
            r9 = 0
            if (r7 != r3) goto L94
            int r6 = r5.getPosition(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            android.view.View r6 = r5.getChildAt(r9)
            int r6 = r5.getPosition(r6)
            int r6 = r6 - r1
            if (r6 < 0) goto L83
            int r7 = r5.getItemCount()
            if (r6 < r7) goto L76
            goto L83
        L76:
            float r7 = r5.r(r6)
            com.google.android.material.carousel.CarouselLayoutManager$b r6 = r5.C(r8, r7, r6)
            android.view.View r7 = r6.f8927a
            r5.m(r7, r9, r6)
        L83:
            boolean r6 = r5.z()
            if (r6 == 0) goto L8f
            int r6 = r5.getChildCount()
            int r9 = r6 + (-1)
        L8f:
            android.view.View r6 = r5.getChildAt(r9)
            goto Ld5
        L94:
            int r6 = r5.getPosition(r6)
            int r7 = r5.getItemCount()
            int r7 = r7 - r1
            if (r6 != r7) goto La0
            return r0
        La0:
            int r6 = r5.getChildCount()
            int r6 = r6 - r1
            android.view.View r6 = r5.getChildAt(r6)
            int r6 = r5.getPosition(r6)
            int r6 = r6 + r1
            if (r6 < 0) goto Lc4
            int r7 = r5.getItemCount()
            if (r6 < r7) goto Lb7
            goto Lc4
        Lb7:
            float r7 = r5.r(r6)
            com.google.android.material.carousel.CarouselLayoutManager$b r6 = r5.C(r8, r7, r6)
            android.view.View r7 = r6.f8927a
            r5.m(r7, r3, r6)
        Lc4:
            boolean r6 = r5.z()
            if (r6 == 0) goto Lcb
            goto Ld1
        Lcb:
            int r6 = r5.getChildCount()
            int r9 = r6 + (-1)
        Ld1:
            android.view.View r6 = r5.getChildAt(r9)
        Ld5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        I();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        I();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutChildren(RecyclerView.r rVar, RecyclerView.w wVar) throws Resources.NotFoundException {
        if (wVar.getItemCount() <= 0 || t() <= 0.0f) {
            removeAndRecycleAllViews(rVar);
            this.f8922w = 0;
            return;
        }
        boolean z10 = z();
        boolean z11 = this.f8920u == null;
        if (z11) {
            D(rVar);
        }
        com.google.android.material.carousel.c cVar = this.f8920u;
        boolean z12 = z();
        com.google.android.material.carousel.b bVarA = z12 ? cVar.a() : cVar.b();
        float f10 = (z12 ? bVarA.c() : bVarA.a()).f8948a;
        float f11 = bVarA.f8935a / 2.0f;
        int iE = (int) (this.f8924y.e() - (z() ? f10 + f11 : f10 - f11));
        com.google.android.material.carousel.c cVar2 = this.f8920u;
        boolean z13 = z();
        com.google.android.material.carousel.b bVarB = z13 ? cVar2.b() : cVar2.a();
        b.C0084b c0084bA = z13 ? bVarB.a() : bVarB.c();
        int itemCount = (int) (((((wVar.getItemCount() - 1) * bVarB.f8935a) * (z13 ? -1.0f : 1.0f)) - (c0084bA.f8948a - this.f8924y.e())) + (this.f8924y.b() - c0084bA.f8948a) + (z13 ? -c0084bA.f8954g : c0084bA.f8955h));
        int iMin = z13 ? Math.min(0, itemCount) : Math.max(0, itemCount);
        this.f8916q = z10 ? iMin : iE;
        if (z10) {
            iMin = iE;
        }
        this.f8917r = iMin;
        if (z11) {
            this.f8915p = iE;
            com.google.android.material.carousel.c cVar3 = this.f8920u;
            int itemCount2 = getItemCount();
            int i10 = this.f8916q;
            int i11 = this.f8917r;
            boolean z14 = z();
            float f12 = cVar3.f8956a.f8935a;
            HashMap map = new HashMap();
            int i12 = 0;
            for (int i13 = 0; i13 < itemCount2; i13++) {
                int i14 = z14 ? (itemCount2 - i13) - 1 : i13;
                float f13 = i14 * f12 * (z14 ? -1 : 1);
                float f14 = i11 - cVar3.f8962g;
                List<com.google.android.material.carousel.b> list = cVar3.f8958c;
                if (f13 > f14 || i13 >= itemCount2 - list.size()) {
                    map.put(Integer.valueOf(i14), list.get(r0.a.clamp(i12, 0, list.size() - 1)));
                    i12++;
                }
            }
            int i15 = 0;
            for (int i16 = itemCount2 - 1; i16 >= 0; i16--) {
                int i17 = z14 ? (itemCount2 - i16) - 1 : i16;
                float f15 = i17 * f12 * (z14 ? -1 : 1);
                float f16 = i10 + cVar3.f8961f;
                List<com.google.android.material.carousel.b> list2 = cVar3.f8957b;
                if (f15 < f16 || i16 < list2.size()) {
                    map.put(Integer.valueOf(i17), list2.get(r0.a.clamp(i15, 0, list2.size() - 1)));
                    i15++;
                }
            }
            this.f8923x = map;
            int i18 = this.B;
            if (i18 != -1) {
                this.f8915p = w(i18, u(i18));
            }
        }
        int i19 = this.f8915p;
        int i20 = this.f8916q;
        int i21 = this.f8917r;
        int i22 = i19 + 0;
        this.f8915p = (i22 < i20 ? i20 - i19 : i22 > i21 ? i21 - i19 : 0) + i19;
        this.f8922w = r0.a.clamp(this.f8922w, 0, wVar.getItemCount());
        H(this.f8920u);
        detachAndScrapAttachedViews(rVar);
        s(rVar, wVar);
        this.A = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutCompleted(RecyclerView.w wVar) {
        super.onLayoutCompleted(wVar);
        if (getChildCount() == 0) {
            this.f8922w = 0;
        } else {
            this.f8922w = getPosition(getChildAt(0));
        }
    }

    public final void p(int i10, RecyclerView.r rVar) {
        float fR = r(i10);
        while (i10 >= 0) {
            b bVarC = C(rVar, fR, i10);
            float f10 = bVarC.f8929c;
            d dVar = bVarC.f8930d;
            if (B(f10, dVar)) {
                return;
            }
            float f11 = this.f8921v.f8935a;
            fR = z() ? fR + f11 : fR - f11;
            if (!A(f10, dVar)) {
                m(bVarC.f8927a, 0, bVarC);
            }
            i10--;
        }
    }

    public final float q(View view, float f10, d dVar) {
        b.C0084b c0084b = dVar.f8933a;
        float f11 = c0084b.f8949b;
        b.C0084b c0084b2 = dVar.f8934b;
        float fLerp = p6.a.lerp(f11, c0084b2.f8949b, c0084b.f8948a, c0084b2.f8948a, f10);
        if (c0084b2 != this.f8921v.b()) {
            if (dVar.f8933a != this.f8921v.d()) {
                return fLerp;
            }
        }
        float maskMargins = this.f8924y.getMaskMargins((RecyclerView.m) view.getLayoutParams()) / this.f8921v.f8935a;
        return fLerp + (((1.0f - c0084b2.f8950c) + maskMargins) * (f10 - c0084b2.f8948a));
    }

    public final float r(int i10) {
        return n(this.f8924y.e() - this.f8915p, this.f8921v.f8935a * i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        int iX;
        if (this.f8920u == null || (iX = x(getPosition(view), u(getPosition(view)))) == 0) {
            return false;
        }
        int i10 = this.f8915p;
        int i11 = this.f8916q;
        int i12 = this.f8917r;
        int i13 = i10 + iX;
        if (i13 < i11) {
            iX = i11 - i10;
        } else if (i13 > i12) {
            iX = i12 - i10;
        }
        int iX2 = x(getPosition(view), this.f8920u.getShiftedState(i10 + iX, i11, i12));
        if (isHorizontal()) {
            recyclerView.scrollBy(iX2, 0);
            return true;
        }
        recyclerView.scrollBy(0, iX2);
        return true;
    }

    public final void s(RecyclerView.r rVar, RecyclerView.w wVar) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Rect rect = new Rect();
            super.getDecoratedBoundsWithMargins(childAt, rect);
            float fCenterX = isHorizontal() ? rect.centerX() : rect.centerY();
            if (!B(fCenterX, y(fCenterX, this.f8921v.f8936b, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, rVar);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            Rect rect2 = new Rect();
            super.getDecoratedBoundsWithMargins(childAt2, rect2);
            float fCenterX2 = isHorizontal() ? rect2.centerX() : rect2.centerY();
            if (!A(fCenterX2, y(fCenterX2, this.f8921v.f8936b, true))) {
                break;
            } else {
                removeAndRecycleView(childAt2, rVar);
            }
        }
        if (getChildCount() == 0) {
            p(this.f8922w - 1, rVar);
            o(this.f8922w, rVar, wVar);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            p(position - 1, rVar);
            o(position2 + 1, rVar, wVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (canScrollHorizontally()) {
            return F(i10, rVar, wVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void scrollToPosition(int i10) {
        this.B = i10;
        if (this.f8920u == null) {
            return;
        }
        this.f8915p = w(i10, u(i10));
        this.f8922w = r0.a.clamp(i10, 0, Math.max(0, getItemCount() - 1));
        H(this.f8920u);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (canScrollVertically()) {
            return F(i10, rVar, wVar);
        }
        return 0;
    }

    public void setCarouselAlignment(int i10) {
        this.C = i10;
        E();
    }

    public void setCarouselStrategy(g gVar) {
        this.f8919t = gVar;
        E();
    }

    public void setOrientation(int i10) {
        f eVar;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(ac.c.f("invalid orientation:", i10));
        }
        assertNotInLayoutOrScroll(null);
        f fVar = this.f8924y;
        if (fVar == null || i10 != fVar.f21632a) {
            if (i10 == 0) {
                eVar = new e(this);
            } else {
                if (i10 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                eVar = new x6.d(this);
            }
            this.f8924y = eVar;
            E();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    public final int t() {
        return isHorizontal() ? getContainerWidth() : getContainerHeight();
    }

    public final com.google.android.material.carousel.b u(int i10) {
        com.google.android.material.carousel.b bVar;
        HashMap map = this.f8923x;
        return (map == null || (bVar = (com.google.android.material.carousel.b) map.get(Integer.valueOf(r0.a.clamp(i10, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f8920u.f8956a : bVar;
    }

    public final int w(int i10, com.google.android.material.carousel.b bVar) {
        if (!z()) {
            return (int) ((bVar.f8935a / 2.0f) + ((i10 * bVar.f8935a) - bVar.a().f8948a));
        }
        float fT = t() - bVar.c().f8948a;
        float f10 = bVar.f8935a;
        return (int) ((fT - (i10 * f10)) - (f10 / 2.0f));
    }

    public final int x(int i10, com.google.android.material.carousel.b bVar) {
        int i11 = Integer.MAX_VALUE;
        for (b.C0084b c0084b : bVar.f8936b.subList(bVar.f8937c, bVar.f8938d + 1)) {
            float f10 = bVar.f8935a;
            float f11 = (f10 / 2.0f) + (i10 * f10);
            int iT = (z() ? (int) ((t() - c0084b.f8948a) - f11) : (int) (f11 - c0084b.f8948a)) - this.f8915p;
            if (Math.abs(i11) > Math.abs(iT)) {
                i11 = iT;
            }
        }
        return i11;
    }

    public final boolean z() {
        return isHorizontal() && getLayoutDirection() == 1;
    }

    public CarouselLayoutManager(g gVar) {
        this(gVar, 0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [x6.c] */
    public CarouselLayoutManager(g gVar, int i10) {
        this.f8918s = new c();
        final int i11 = 0;
        this.f8922w = 0;
        this.f8925z = new View.OnLayoutChangeListener() { // from class: x6.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                int i20 = i11;
                CarouselLayoutManager carouselLayoutManager = this;
                switch (i20) {
                    case 0:
                        carouselLayoutManager.getClass();
                        if (i12 != i16 || i13 != i17 || i14 != i18 || i15 != i19) {
                            view.post(new androidx.activity.d(carouselLayoutManager, 11));
                            break;
                        }
                    default:
                        carouselLayoutManager.getClass();
                        if (i12 != i16 || i13 != i17 || i14 != i18 || i15 != i19) {
                            view.post(new androidx.activity.d(carouselLayoutManager, 11));
                            break;
                        }
                }
            }
        };
        this.B = -1;
        this.C = 0;
        setCarouselStrategy(gVar);
        setOrientation(i10);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [x6.c] */
    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f8918s = new c();
        this.f8922w = 0;
        final int i12 = 1;
        this.f8925z = new View.OnLayoutChangeListener() { // from class: x6.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i122, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                int i20 = i12;
                CarouselLayoutManager carouselLayoutManager = this;
                switch (i20) {
                    case 0:
                        carouselLayoutManager.getClass();
                        if (i122 != i16 || i13 != i17 || i14 != i18 || i15 != i19) {
                            view.post(new androidx.activity.d(carouselLayoutManager, 11));
                            break;
                        }
                    default:
                        carouselLayoutManager.getClass();
                        if (i122 != i16 || i13 != i17 || i14 != i18 || i15 != i19) {
                            view.post(new androidx.activity.d(carouselLayoutManager, 11));
                            break;
                        }
                }
            }
        };
        this.B = -1;
        this.C = 0;
        setCarouselStrategy(new i());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            setCarouselAlignment(typedArrayObtainStyledAttributes.getInt(R.styleable.Carousel_carousel_alignment, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
