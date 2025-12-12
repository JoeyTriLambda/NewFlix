package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public boolean D;
    public boolean E;
    public e F;
    public int[] J;

    /* renamed from: q, reason: collision with root package name */
    public f[] f4061q;

    /* renamed from: r, reason: collision with root package name */
    public o f4062r;

    /* renamed from: s, reason: collision with root package name */
    public o f4063s;

    /* renamed from: t, reason: collision with root package name */
    public int f4064t;

    /* renamed from: u, reason: collision with root package name */
    public int f4065u;

    /* renamed from: v, reason: collision with root package name */
    public final l f4066v;

    /* renamed from: y, reason: collision with root package name */
    public BitSet f4069y;

    /* renamed from: p, reason: collision with root package name */
    public int f4060p = -1;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4067w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4068x = false;

    /* renamed from: z, reason: collision with root package name */
    public int f4070z = -1;
    public int A = Integer.MIN_VALUE;
    public final d B = new d();
    public final int C = 2;
    public final Rect G = new Rect();
    public final b H = new b();
    public final boolean I = true;
    public final a K = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.n();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f4072a;

        /* renamed from: b, reason: collision with root package name */
        public int f4073b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4074c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4075d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4076e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f4077f;

        public b() {
            a();
        }

        public final void a() {
            this.f4072a = -1;
            this.f4073b = Integer.MIN_VALUE;
            this.f4074c = false;
            this.f4075d = false;
            this.f4076e = false;
            int[] iArr = this.f4077f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.m {

        /* renamed from: e, reason: collision with root package name */
        public f f4079e;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean isFullSpan() {
            return false;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f4086b;

        /* renamed from: m, reason: collision with root package name */
        public int f4087m;

        /* renamed from: n, reason: collision with root package name */
        public int f4088n;

        /* renamed from: o, reason: collision with root package name */
        public int[] f4089o;

        /* renamed from: p, reason: collision with root package name */
        public int f4090p;

        /* renamed from: q, reason: collision with root package name */
        public int[] f4091q;

        /* renamed from: r, reason: collision with root package name */
        public List<d.a> f4092r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f4093s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f4094t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f4095u;

        public class a implements Parcelable.Creator<e> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f4086b);
            parcel.writeInt(this.f4087m);
            parcel.writeInt(this.f4088n);
            if (this.f4088n > 0) {
                parcel.writeIntArray(this.f4089o);
            }
            parcel.writeInt(this.f4090p);
            if (this.f4090p > 0) {
                parcel.writeIntArray(this.f4091q);
            }
            parcel.writeInt(this.f4093s ? 1 : 0);
            parcel.writeInt(this.f4094t ? 1 : 0);
            parcel.writeInt(this.f4095u ? 1 : 0);
            parcel.writeList(this.f4092r);
        }

        public e(Parcel parcel) {
            this.f4086b = parcel.readInt();
            this.f4087m = parcel.readInt();
            int i10 = parcel.readInt();
            this.f4088n = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f4089o = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f4090p = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f4091q = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f4093s = parcel.readInt() == 1;
            this.f4094t = parcel.readInt() == 1;
            this.f4095u = parcel.readInt() == 1;
            this.f4092r = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f4088n = eVar.f4088n;
            this.f4086b = eVar.f4086b;
            this.f4087m = eVar.f4087m;
            this.f4089o = eVar.f4089o;
            this.f4090p = eVar.f4090p;
            this.f4091q = eVar.f4091q;
            this.f4093s = eVar.f4093s;
            this.f4094t = eVar.f4094t;
            this.f4095u = eVar.f4095u;
            this.f4092r = eVar.f4092r;
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<View> f4096a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public int f4097b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f4098c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f4099d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f4100e;

        public f(int i10) {
            this.f4100e = i10;
        }

        public static c e(View view) {
            return (c) view.getLayoutParams();
        }

        public final void a() {
            View view = this.f4096a.get(r0.size() - 1);
            c cVarE = e(view);
            this.f4098c = StaggeredGridLayoutManager.this.f4062r.getDecoratedEnd(view);
            cVarE.getClass();
        }

        public final void b() {
            this.f4096a.clear();
            this.f4097b = Integer.MIN_VALUE;
            this.f4098c = Integer.MIN_VALUE;
            this.f4099d = 0;
        }

        public final int c(int i10, int i11, boolean z10, boolean z11) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int startAfterPadding = staggeredGridLayoutManager.f4062r.getStartAfterPadding();
            int endAfterPadding = staggeredGridLayoutManager.f4062r.getEndAfterPadding();
            int i12 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f4096a.get(i10);
                int decoratedStart = staggeredGridLayoutManager.f4062r.getDecoratedStart(view);
                int decoratedEnd = staggeredGridLayoutManager.f4062r.getDecoratedEnd(view);
                boolean z12 = false;
                boolean z13 = !z11 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
                if (!z11 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                    z12 = true;
                }
                if (z13 && z12) {
                    if (z10) {
                        return staggeredGridLayoutManager.getPosition(view);
                    }
                    if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                        return staggeredGridLayoutManager.getPosition(view);
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        public final int d(int i10) {
            int i11 = this.f4098c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f4096a.size() == 0) {
                return i10;
            }
            a();
            return this.f4098c;
        }

        public final int f(int i10) {
            int i11 = this.f4097b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            ArrayList<View> arrayList = this.f4096a;
            if (arrayList.size() == 0) {
                return i10;
            }
            View view = arrayList.get(0);
            c cVarE = e(view);
            this.f4097b = StaggeredGridLayoutManager.this.f4062r.getDecoratedStart(view);
            cVarE.getClass();
            return this.f4097b;
        }

        public int findFirstPartiallyVisibleItemPosition() {
            boolean z10 = StaggeredGridLayoutManager.this.f4067w;
            ArrayList<View> arrayList = this.f4096a;
            return z10 ? c(arrayList.size() - 1, -1, false, true) : c(0, arrayList.size(), false, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            boolean z10 = StaggeredGridLayoutManager.this.f4067w;
            ArrayList<View> arrayList = this.f4096a;
            return z10 ? c(0, arrayList.size(), false, true) : c(arrayList.size() - 1, -1, false, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.f4067w ? c(0, this.f4096a.size(), true, false) : c(r1.size() - 1, -1, true, false);
        }

        public int getDeletedSize() {
            return this.f4099d;
        }

        public View getFocusableViewAfter(int i10, int i11) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList<View> arrayList = this.f4096a;
            View view = null;
            if (i11 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = arrayList.get(size);
                    if ((staggeredGridLayoutManager.f4067w && staggeredGridLayoutManager.getPosition(view2) >= i10) || ((!staggeredGridLayoutManager.f4067w && staggeredGridLayoutManager.getPosition(view2) <= i10) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = arrayList.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = arrayList.get(i12);
                    if ((staggeredGridLayoutManager.f4067w && staggeredGridLayoutManager.getPosition(view3) <= i10) || ((!staggeredGridLayoutManager.f4067w && staggeredGridLayoutManager.getPosition(view3) >= i10) || !view3.hasFocusable())) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.l.d properties = RecyclerView.l.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f3978a);
        setSpanCount(properties.f3979b);
        setReverseLayout(properties.f3980c);
        this.f4066v = new l();
        this.f4062r = o.createOrientationHelper(this, this.f4064t);
        this.f4063s = o.createOrientationHelper(this, 1 - this.f4064t);
    }

    public static int O(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f4068x
            if (r0 == 0) goto L9
            int r0 = r7.x()
            goto Ld
        L9:
            int r0 = r7.w()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1a
            if (r8 >= r9) goto L16
            int r2 = r9 + 1
            goto L1c
        L16:
            int r2 = r8 + 1
            r3 = r9
            goto L1d
        L1a:
            int r2 = r8 + r9
        L1c:
            r3 = r8
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r7.B
            r4.c(r3)
            r5 = 1
            if (r10 == r5) goto L36
            r6 = 2
            if (r10 == r6) goto L32
            if (r10 == r1) goto L2b
            goto L39
        L2b:
            r4.e(r8, r5)
            r4.d(r9, r5)
            goto L39
        L32:
            r4.e(r8, r9)
            goto L39
        L36:
            r4.d(r8, r9)
        L39:
            if (r2 > r0) goto L3c
            return
        L3c:
            boolean r8 = r7.f4068x
            if (r8 == 0) goto L45
            int r8 = r7.w()
            goto L49
        L45:
            int r8 = r7.x()
        L49:
            if (r3 > r8) goto L4e
            r7.requestLayout()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View B() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B():android.view.View");
    }

    public final void C(int i10, int i11, View view, boolean z10) {
        Rect rect = this.G;
        calculateItemDecorationsForChild(view, rect);
        c cVar = (c) view.getLayoutParams();
        int iO = O(i10, ((ViewGroup.MarginLayoutParams) cVar).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int iO2 = O(i11, ((ViewGroup.MarginLayoutParams) cVar).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect.bottom);
        if (j(view, iO, iO2, cVar)) {
            view.measure(iO, iO2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x040b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(androidx.recyclerview.widget.RecyclerView.r r17, androidx.recyclerview.widget.RecyclerView.w r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.D(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, boolean):void");
    }

    public final boolean E(int i10) {
        if (this.f4064t == 0) {
            return (i10 == -1) != this.f4068x;
        }
        return ((i10 == -1) == this.f4068x) == isLayoutRTL();
    }

    public final void F(int i10, RecyclerView.w wVar) {
        int iW;
        int i11;
        if (i10 > 0) {
            iW = x();
            i11 = 1;
        } else {
            iW = w();
            i11 = -1;
        }
        l lVar = this.f4066v;
        lVar.f4218a = true;
        M(iW, wVar);
        L(i11);
        lVar.f4220c = iW + lVar.f4221d;
        lVar.f4219b = Math.abs(i10);
    }

    public final void G(RecyclerView.r rVar, l lVar) {
        if (!lVar.f4218a || lVar.f4226i) {
            return;
        }
        if (lVar.f4219b == 0) {
            if (lVar.f4222e == -1) {
                H(lVar.f4224g, rVar);
                return;
            } else {
                I(lVar.f4223f, rVar);
                return;
            }
        }
        int i10 = 1;
        if (lVar.f4222e == -1) {
            int i11 = lVar.f4223f;
            int iF = this.f4061q[0].f(i11);
            while (i10 < this.f4060p) {
                int iF2 = this.f4061q[i10].f(i11);
                if (iF2 > iF) {
                    iF = iF2;
                }
                i10++;
            }
            int i12 = i11 - iF;
            H(i12 < 0 ? lVar.f4224g : lVar.f4224g - Math.min(i12, lVar.f4219b), rVar);
            return;
        }
        int i13 = lVar.f4224g;
        int iD = this.f4061q[0].d(i13);
        while (i10 < this.f4060p) {
            int iD2 = this.f4061q[i10].d(i13);
            if (iD2 < iD) {
                iD = iD2;
            }
            i10++;
        }
        int i14 = iD - lVar.f4224g;
        I(i14 < 0 ? lVar.f4223f : Math.min(i14, lVar.f4219b) + lVar.f4223f, rVar);
    }

    public final void H(int i10, RecyclerView.r rVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f4062r.getDecoratedStart(childAt) < i10 || this.f4062r.getTransformedStartWithDecoration(childAt) < i10) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            cVar.getClass();
            if (cVar.f4079e.f4096a.size() == 1) {
                return;
            }
            f fVar = cVar.f4079e;
            ArrayList<View> arrayList = fVar.f4096a;
            int size = arrayList.size();
            View viewRemove = arrayList.remove(size - 1);
            c cVarE = f.e(viewRemove);
            cVarE.f4079e = null;
            if (cVarE.isItemRemoved() || cVarE.isItemChanged()) {
                fVar.f4099d -= StaggeredGridLayoutManager.this.f4062r.getDecoratedMeasurement(viewRemove);
            }
            if (size == 1) {
                fVar.f4097b = Integer.MIN_VALUE;
            }
            fVar.f4098c = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, rVar);
        }
    }

    public final void I(int i10, RecyclerView.r rVar) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f4062r.getDecoratedEnd(childAt) > i10 || this.f4062r.getTransformedEndWithDecoration(childAt) > i10) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            cVar.getClass();
            if (cVar.f4079e.f4096a.size() == 1) {
                return;
            }
            f fVar = cVar.f4079e;
            ArrayList<View> arrayList = fVar.f4096a;
            View viewRemove = arrayList.remove(0);
            c cVarE = f.e(viewRemove);
            cVarE.f4079e = null;
            if (arrayList.size() == 0) {
                fVar.f4098c = Integer.MIN_VALUE;
            }
            if (cVarE.isItemRemoved() || cVarE.isItemChanged()) {
                fVar.f4099d -= StaggeredGridLayoutManager.this.f4062r.getDecoratedMeasurement(viewRemove);
            }
            fVar.f4097b = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, rVar);
        }
    }

    public final void J() {
        if (this.f4064t == 1 || !isLayoutRTL()) {
            this.f4068x = this.f4067w;
        } else {
            this.f4068x = !this.f4067w;
        }
    }

    public final int K(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        F(i10, wVar);
        l lVar = this.f4066v;
        int iR = r(rVar, lVar, wVar);
        if (lVar.f4219b >= iR) {
            i10 = i10 < 0 ? -iR : iR;
        }
        this.f4062r.offsetChildren(-i10);
        this.D = this.f4068x;
        lVar.f4219b = 0;
        G(rVar, lVar);
        return i10;
    }

    public final void L(int i10) {
        l lVar = this.f4066v;
        lVar.f4222e = i10;
        lVar.f4221d = this.f4068x != (i10 == -1) ? -1 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void M(int r5, androidx.recyclerview.widget.RecyclerView.w r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.l r0 = r4.f4066v
            r1 = 0
            r0.f4219b = r1
            r0.f4220c = r5
            boolean r2 = r4.isSmoothScrolling()
            r3 = 1
            if (r2 == 0) goto L2e
            int r6 = r6.getTargetScrollPosition()
            r2 = -1
            if (r6 == r2) goto L2e
            boolean r2 = r4.f4068x
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r2 != r5) goto L25
            androidx.recyclerview.widget.o r5 = r4.f4062r
            int r5 = r5.getTotalSpace()
            goto L2f
        L25:
            androidx.recyclerview.widget.o r5 = r4.f4062r
            int r5 = r5.getTotalSpace()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r2 = r4.getClipToPadding()
            if (r2 == 0) goto L49
            androidx.recyclerview.widget.o r2 = r4.f4062r
            int r2 = r2.getStartAfterPadding()
            int r2 = r2 - r6
            r0.f4223f = r2
            androidx.recyclerview.widget.o r6 = r4.f4062r
            int r6 = r6.getEndAfterPadding()
            int r6 = r6 + r5
            r0.f4224g = r6
            goto L55
        L49:
            androidx.recyclerview.widget.o r2 = r4.f4062r
            int r2 = r2.getEnd()
            int r2 = r2 + r5
            r0.f4224g = r2
            int r5 = -r6
            r0.f4223f = r5
        L55:
            r0.f4225h = r1
            r0.f4218a = r3
            androidx.recyclerview.widget.o r5 = r4.f4062r
            int r5 = r5.getMode()
            if (r5 != 0) goto L6a
            androidx.recyclerview.widget.o r5 = r4.f4062r
            int r5 = r5.getEnd()
            if (r5 != 0) goto L6a
            r1 = 1
        L6a:
            r0.f4226i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.M(int, androidx.recyclerview.widget.RecyclerView$w):void");
    }

    public final void N(f fVar, int i10, int i11) {
        int deletedSize = fVar.getDeletedSize();
        int i12 = fVar.f4100e;
        if (i10 != -1) {
            int i13 = fVar.f4098c;
            if (i13 == Integer.MIN_VALUE) {
                fVar.a();
                i13 = fVar.f4098c;
            }
            if (i13 - deletedSize >= i11) {
                this.f4069y.set(i12, false);
                return;
            }
            return;
        }
        int i14 = fVar.f4097b;
        if (i14 == Integer.MIN_VALUE) {
            View view = fVar.f4096a.get(0);
            c cVarE = f.e(view);
            fVar.f4097b = StaggeredGridLayoutManager.this.f4062r.getDecoratedStart(view);
            cVarE.getClass();
            i14 = fVar.f4097b;
        }
        if (i14 + deletedSize <= i11) {
            this.f4069y.set(i12, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void assertNotInLayoutOrScroll(String str) {
        if (this.F == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollHorizontally() {
        return this.f4064t == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canScrollVertically() {
        return this.f4064t == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean checkLayoutParams(RecyclerView.m mVar) {
        return mVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        l lVar;
        int iD;
        int iF;
        if (this.f4064t != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        F(i10, wVar);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f4060p) {
            this.J = new int[this.f4060p];
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = this.f4060p;
            lVar = this.f4066v;
            if (i12 >= i14) {
                break;
            }
            if (lVar.f4221d == -1) {
                iD = lVar.f4223f;
                iF = this.f4061q[i12].f(iD);
            } else {
                iD = this.f4061q[i12].d(lVar.f4224g);
                iF = lVar.f4224g;
            }
            int i15 = iD - iF;
            if (i15 >= 0) {
                this.J[i13] = i15;
                i13++;
            }
            i12++;
        }
        Arrays.sort(this.J, 0, i13);
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = lVar.f4220c;
            if (!(i17 >= 0 && i17 < wVar.getItemCount())) {
                return;
            }
            ((k.b) cVar).addPosition(lVar.f4220c, this.J[i16]);
            lVar.f4220c += lVar.f4221d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollExtent(RecyclerView.w wVar) {
        return o(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollOffset(RecyclerView.w wVar) {
        return p(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeHorizontalScrollRange(RecyclerView.w wVar) {
        return q(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF computeScrollVectorForPosition(int i10) {
        int iM = m(i10);
        PointF pointF = new PointF();
        if (iM == 0) {
            return null;
        }
        if (this.f4064t == 0) {
            pointF.x = iM;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollExtent(RecyclerView.w wVar) {
        return o(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollOffset(RecyclerView.w wVar) {
        return p(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int computeVerticalScrollRange(RecyclerView.w wVar) {
        return q(wVar);
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4060p];
        } else if (iArr.length < this.f4060p) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4060p + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f4060p; i10++) {
            iArr[i10] = this.f4061q[i10].findLastVisibleItemPosition();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateDefaultLayoutParams() {
        return this.f4064t == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public int getSpanCount() {
        return this.f4060p;
    }

    public void invalidateSpanAssignments() {
        this.B.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean isAutoMeasureEnabled() {
        return this.C != 0;
    }

    public final boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final int m(int i10) {
        if (getChildCount() == 0) {
            return this.f4068x ? 1 : -1;
        }
        return (i10 < w()) != this.f4068x ? -1 : 1;
    }

    public final boolean n() {
        int iW;
        if (getChildCount() != 0 && this.C != 0 && isAttachedToWindow()) {
            if (this.f4068x) {
                iW = x();
                w();
            } else {
                iW = w();
                x();
            }
            if (iW == 0 && B() != null) {
                this.B.a();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    public final int o(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        o oVar = this.f4062r;
        boolean z10 = this.I;
        return t.a(wVar, oVar, t(!z10), s(!z10), this, this.I);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.f4060p; i11++) {
            f fVar = this.f4061q[i11];
            int i12 = fVar.f4097b;
            if (i12 != Integer.MIN_VALUE) {
                fVar.f4097b = i12 + i10;
            }
            int i13 = fVar.f4098c;
            if (i13 != Integer.MIN_VALUE) {
                fVar.f4098c = i13 + i10;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.f4060p; i11++) {
            f fVar = this.f4061q[i11];
            int i12 = fVar.f4097b;
            if (i12 != Integer.MIN_VALUE) {
                fVar.f4097b = i12 + i10;
            }
            int i13 = fVar.f4098c;
            if (i13 != Integer.MIN_VALUE) {
                fVar.f4098c = i13 + i10;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.B.a();
        for (int i10 = 0; i10 < this.f4060p; i10++) {
            this.f4061q[i10].b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.r rVar) {
        super.onDetachedFromWindow(recyclerView, rVar);
        removeCallbacks(this.K);
        for (int i10 = 0; i10 < this.f4060p; i10++) {
            this.f4061q[i10].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003e  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.r r11, androidx.recyclerview.widget.RecyclerView.w r12) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewT = t(false);
            View viewS = s(false);
            if (viewT == null || viewS == null) {
                return;
            }
            int position = getPosition(viewT);
            int position2 = getPosition(viewS);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        A(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsChanged(RecyclerView recyclerView) {
        this.B.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        A(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        A(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        A(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutChildren(RecyclerView.r rVar, RecyclerView.w wVar) {
        D(rVar, wVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onLayoutCompleted(RecyclerView.w wVar) {
        super.onLayoutCompleted(wVar);
        this.f4070z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            this.F = eVar;
            if (this.f4070z != -1) {
                eVar.f4089o = null;
                eVar.f4088n = 0;
                eVar.f4086b = -1;
                eVar.f4087m = -1;
                eVar.f4089o = null;
                eVar.f4088n = 0;
                eVar.f4090p = 0;
                eVar.f4091q = null;
                eVar.f4092r = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public Parcelable onSaveInstanceState() {
        int iF;
        int startAfterPadding;
        int[] iArr;
        e eVar = this.F;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.f4093s = this.f4067w;
        eVar2.f4094t = this.D;
        eVar2.f4095u = this.E;
        d dVar = this.B;
        if (dVar == null || (iArr = dVar.f4080a) == null) {
            eVar2.f4090p = 0;
        } else {
            eVar2.f4091q = iArr;
            eVar2.f4090p = iArr.length;
            eVar2.f4092r = dVar.f4081b;
        }
        if (getChildCount() > 0) {
            eVar2.f4086b = this.D ? x() : w();
            View viewS = this.f4068x ? s(true) : t(true);
            eVar2.f4087m = viewS != null ? getPosition(viewS) : -1;
            int i10 = this.f4060p;
            eVar2.f4088n = i10;
            eVar2.f4089o = new int[i10];
            for (int i11 = 0; i11 < this.f4060p; i11++) {
                if (this.D) {
                    iF = this.f4061q[i11].d(Integer.MIN_VALUE);
                    if (iF != Integer.MIN_VALUE) {
                        startAfterPadding = this.f4062r.getEndAfterPadding();
                        iF -= startAfterPadding;
                    }
                } else {
                    iF = this.f4061q[i11].f(Integer.MIN_VALUE);
                    if (iF != Integer.MIN_VALUE) {
                        startAfterPadding = this.f4062r.getStartAfterPadding();
                        iF -= startAfterPadding;
                    }
                }
                eVar2.f4089o[i11] = iF;
            }
        } else {
            eVar2.f4086b = -1;
            eVar2.f4087m = -1;
            eVar2.f4088n = 0;
        }
        return eVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            n();
        }
    }

    public final int p(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        o oVar = this.f4062r;
        boolean z10 = this.I;
        return t.b(wVar, oVar, t(!z10), s(!z10), this, this.I, this.f4068x);
    }

    public final int q(RecyclerView.w wVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        o oVar = this.f4062r;
        boolean z10 = this.I;
        return t.c(wVar, oVar, t(!z10), s(!z10), this, this.I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v51 */
    public final int r(RecyclerView.r rVar, l lVar, RecyclerView.w wVar) {
        f fVar;
        ?? r12;
        int decoratedMeasurement;
        int decoratedMeasurement2;
        int startAfterPadding;
        int decoratedMeasurement3;
        View view;
        int i10;
        int i11;
        RecyclerView.r rVar2 = rVar;
        int i12 = 1;
        this.f4069y.set(0, this.f4060p, true);
        l lVar2 = this.f4066v;
        int i13 = lVar2.f4226i ? lVar.f4222e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : lVar.f4222e == 1 ? lVar.f4224g + lVar.f4219b : lVar.f4223f - lVar.f4219b;
        int i14 = lVar.f4222e;
        for (int i15 = 0; i15 < this.f4060p; i15++) {
            if (!this.f4061q[i15].f4096a.isEmpty()) {
                N(this.f4061q[i15], i14, i13);
            }
        }
        int endAfterPadding = this.f4068x ? this.f4062r.getEndAfterPadding() : this.f4062r.getStartAfterPadding();
        boolean z10 = false;
        while (true) {
            int i16 = lVar.f4220c;
            int i17 = -1;
            if (!(i16 >= 0 && i16 < wVar.getItemCount()) || (!lVar2.f4226i && this.f4069y.isEmpty())) {
                break;
            }
            View viewForPosition = rVar2.getViewForPosition(lVar.f4220c);
            lVar.f4220c += lVar.f4221d;
            c cVar = (c) viewForPosition.getLayoutParams();
            int viewLayoutPosition = cVar.getViewLayoutPosition();
            d dVar = this.B;
            int[] iArr = dVar.f4080a;
            int i18 = (iArr == null || viewLayoutPosition >= iArr.length) ? -1 : iArr[viewLayoutPosition];
            if (i18 == -1) {
                if (E(lVar.f4222e)) {
                    i11 = this.f4060p - i12;
                    i10 = -1;
                } else {
                    i17 = this.f4060p;
                    i10 = 1;
                    i11 = 0;
                }
                f fVar2 = null;
                if (lVar.f4222e == i12) {
                    int startAfterPadding2 = this.f4062r.getStartAfterPadding();
                    int i19 = Integer.MAX_VALUE;
                    while (i11 != i17) {
                        f fVar3 = this.f4061q[i11];
                        int iD = fVar3.d(startAfterPadding2);
                        if (iD < i19) {
                            i19 = iD;
                            fVar2 = fVar3;
                        }
                        i11 += i10;
                    }
                } else {
                    int endAfterPadding2 = this.f4062r.getEndAfterPadding();
                    int i20 = Integer.MIN_VALUE;
                    while (i11 != i17) {
                        f fVar4 = this.f4061q[i11];
                        int iF = fVar4.f(endAfterPadding2);
                        if (iF > i20) {
                            fVar2 = fVar4;
                            i20 = iF;
                        }
                        i11 += i10;
                    }
                }
                fVar = fVar2;
                dVar.b(viewLayoutPosition);
                dVar.f4080a[viewLayoutPosition] = fVar.f4100e;
            } else {
                fVar = this.f4061q[i18];
            }
            f fVar5 = fVar;
            cVar.f4079e = fVar5;
            if (lVar.f4222e == 1) {
                addView(viewForPosition);
                r12 = 0;
            } else {
                r12 = 0;
                addView(viewForPosition, 0);
            }
            if (this.f4064t == 1) {
                C(RecyclerView.l.getChildMeasureSpec(this.f4065u, getWidthMode(), r12, ((ViewGroup.MarginLayoutParams) cVar).width, r12), RecyclerView.l.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) cVar).height, true), viewForPosition, r12);
            } else {
                C(RecyclerView.l.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.l.getChildMeasureSpec(this.f4065u, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), viewForPosition, false);
            }
            if (lVar.f4222e == 1) {
                int iD2 = fVar5.d(endAfterPadding);
                decoratedMeasurement2 = iD2;
                decoratedMeasurement = this.f4062r.getDecoratedMeasurement(viewForPosition) + iD2;
            } else {
                int iF2 = fVar5.f(endAfterPadding);
                decoratedMeasurement = iF2;
                decoratedMeasurement2 = iF2 - this.f4062r.getDecoratedMeasurement(viewForPosition);
            }
            if (lVar.f4222e == 1) {
                f fVar6 = cVar.f4079e;
                fVar6.getClass();
                c cVar2 = (c) viewForPosition.getLayoutParams();
                cVar2.f4079e = fVar6;
                ArrayList<View> arrayList = fVar6.f4096a;
                arrayList.add(viewForPosition);
                fVar6.f4098c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    fVar6.f4097b = Integer.MIN_VALUE;
                }
                if (cVar2.isItemRemoved() || cVar2.isItemChanged()) {
                    fVar6.f4099d = StaggeredGridLayoutManager.this.f4062r.getDecoratedMeasurement(viewForPosition) + fVar6.f4099d;
                }
            } else {
                f fVar7 = cVar.f4079e;
                fVar7.getClass();
                c cVar3 = (c) viewForPosition.getLayoutParams();
                cVar3.f4079e = fVar7;
                ArrayList<View> arrayList2 = fVar7.f4096a;
                arrayList2.add(0, viewForPosition);
                fVar7.f4097b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    fVar7.f4098c = Integer.MIN_VALUE;
                }
                if (cVar3.isItemRemoved() || cVar3.isItemChanged()) {
                    fVar7.f4099d = StaggeredGridLayoutManager.this.f4062r.getDecoratedMeasurement(viewForPosition) + fVar7.f4099d;
                }
            }
            if (isLayoutRTL() && this.f4064t == 1) {
                decoratedMeasurement3 = this.f4063s.getEndAfterPadding() - (((this.f4060p - 1) - fVar5.f4100e) * this.f4065u);
                startAfterPadding = decoratedMeasurement3 - this.f4063s.getDecoratedMeasurement(viewForPosition);
            } else {
                startAfterPadding = this.f4063s.getStartAfterPadding() + (fVar5.f4100e * this.f4065u);
                decoratedMeasurement3 = this.f4063s.getDecoratedMeasurement(viewForPosition) + startAfterPadding;
            }
            int i21 = decoratedMeasurement3;
            int i22 = startAfterPadding;
            if (this.f4064t == 1) {
                view = viewForPosition;
                layoutDecoratedWithMargins(viewForPosition, i22, decoratedMeasurement2, i21, decoratedMeasurement);
            } else {
                view = viewForPosition;
                layoutDecoratedWithMargins(view, decoratedMeasurement2, i22, decoratedMeasurement, i21);
            }
            N(fVar5, lVar2.f4222e, i13);
            G(rVar, lVar2);
            if (lVar2.f4225h && view.hasFocusable()) {
                this.f4069y.set(fVar5.f4100e, false);
            }
            rVar2 = rVar;
            z10 = true;
            i12 = 1;
        }
        RecyclerView.r rVar3 = rVar2;
        if (!z10) {
            G(rVar3, lVar2);
        }
        int startAfterPadding3 = lVar2.f4222e == -1 ? this.f4062r.getStartAfterPadding() - z(this.f4062r.getStartAfterPadding()) : y(this.f4062r.getEndAfterPadding()) - this.f4062r.getEndAfterPadding();
        if (startAfterPadding3 > 0) {
            return Math.min(lVar.f4219b, startAfterPadding3);
        }
        return 0;
    }

    public final View s(boolean z10) {
        int startAfterPadding = this.f4062r.getStartAfterPadding();
        int endAfterPadding = this.f4062r.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.f4062r.getDecoratedStart(childAt);
            int decoratedEnd = this.f4062r.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollHorizontallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        return K(i10, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void scrollToPosition(int i10) {
        e eVar = this.F;
        if (eVar != null && eVar.f4086b != i10) {
            eVar.f4089o = null;
            eVar.f4088n = 0;
            eVar.f4086b = -1;
            eVar.f4087m = -1;
        }
        this.f4070z = i10;
        this.A = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int scrollVerticallyBy(int i10, RecyclerView.r rVar, RecyclerView.w wVar) {
        return K(i10, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f4064t == 1) {
            iChooseSize2 = RecyclerView.l.chooseSize(i11, rect.height() + paddingBottom, getMinimumHeight());
            iChooseSize = RecyclerView.l.chooseSize(i10, (this.f4065u * this.f4060p) + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.l.chooseSize(i10, rect.width() + paddingRight, getMinimumWidth());
            iChooseSize2 = RecyclerView.l.chooseSize(i11, (this.f4065u * this.f4060p) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f4064t) {
            return;
        }
        this.f4064t = i10;
        o oVar = this.f4062r;
        this.f4062r = this.f4063s;
        this.f4063s = oVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        e eVar = this.F;
        if (eVar != null && eVar.f4093s != z10) {
            eVar.f4093s = z10;
        }
        this.f4067w = z10;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f4060p) {
            invalidateSpanAssignments();
            this.f4060p = i10;
            this.f4069y = new BitSet(this.f4060p);
            this.f4061q = new f[this.f4060p];
            for (int i11 = 0; i11 < this.f4060p; i11++) {
                this.f4061q[i11] = new f(i11);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.w wVar, int i10) {
        m mVar = new m(recyclerView.getContext());
        mVar.setTargetPosition(i10);
        startSmoothScroll(mVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean supportsPredictiveItemAnimations() {
        return this.F == null;
    }

    public final View t(boolean z10) {
        int startAfterPadding = this.f4062r.getStartAfterPadding();
        int endAfterPadding = this.f4062r.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int decoratedStart = this.f4062r.getDecoratedStart(childAt);
            if (this.f4062r.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void u(RecyclerView.r rVar, RecyclerView.w wVar, boolean z10) {
        int endAfterPadding;
        int iY = y(Integer.MIN_VALUE);
        if (iY != Integer.MIN_VALUE && (endAfterPadding = this.f4062r.getEndAfterPadding() - iY) > 0) {
            int i10 = endAfterPadding - (-K(-endAfterPadding, rVar, wVar));
            if (!z10 || i10 <= 0) {
                return;
            }
            this.f4062r.offsetChildren(i10);
        }
    }

    public final void v(RecyclerView.r rVar, RecyclerView.w wVar, boolean z10) {
        int startAfterPadding;
        int iZ = z(Integer.MAX_VALUE);
        if (iZ != Integer.MAX_VALUE && (startAfterPadding = iZ - this.f4062r.getStartAfterPadding()) > 0) {
            int iK = startAfterPadding - K(startAfterPadding, rVar, wVar);
            if (!z10 || iK <= 0) {
                return;
            }
            this.f4062r.offsetChildren(-iK);
        }
    }

    public final int w() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int x() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int y(int i10) {
        int iD = this.f4061q[0].d(i10);
        for (int i11 = 1; i11 < this.f4060p; i11++) {
            int iD2 = this.f4061q[i11].d(i10);
            if (iD2 > iD) {
                iD = iD2;
            }
        }
        return iD;
    }

    public final int z(int i10) {
        int iF = this.f4061q[0].f(i10);
        for (int i11 = 1; i11 < this.f4060p; i11++) {
            int iF2 = this.f4061q[i11].f(i10);
            if (iF2 < iF) {
                iF = iF2;
            }
        }
        return iF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int[] f4080a;

        /* renamed from: b, reason: collision with root package name */
        public List<a> f4081b;

        public final void a() {
            int[] iArr = this.f4080a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4081b = null;
        }

        public final void b(int i10) {
            int[] iArr = this.f4080a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f4080a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int length = iArr.length;
                while (length <= i10) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f4080a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4080a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x000e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int c(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.f4080a
                r1 = -1
                if (r0 != 0) goto L6
                return r1
            L6:
                int r0 = r0.length
                if (r5 < r0) goto La
                return r1
            La:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f4081b
                if (r0 != 0) goto L10
            Le:
                r0 = -1
                goto L46
            L10:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = r4.getFullSpanItem(r5)
                if (r0 == 0) goto L1b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r2 = r4.f4081b
                r2.remove(r0)
            L1b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f4081b
                int r0 = r0.size()
                r2 = 0
            L22:
                if (r2 >= r0) goto L34
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r4.f4081b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r3 = r3.f4082b
                if (r3 < r5) goto L31
                goto L35
            L31:
                int r2 = r2 + 1
                goto L22
            L34:
                r2 = -1
            L35:
                if (r2 == r1) goto Le
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r4.f4081b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r4.f4081b
                r3.remove(r2)
                int r0 = r0.f4082b
            L46:
                if (r0 != r1) goto L52
                int[] r0 = r4.f4080a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.f4080a
                int r5 = r5.length
                return r5
            L52:
                int r0 = r0 + 1
                int[] r2 = r4.f4080a
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r2 = r4.f4080a
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.c(int):int");
        }

        public final void d(int i10, int i11) {
            int[] iArr = this.f4080a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f4080a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f4080a, i10, i12, -1);
            List<a> list = this.f4081b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4081b.get(size);
                int i13 = aVar.f4082b;
                if (i13 >= i10) {
                    aVar.f4082b = i13 + i11;
                }
            }
        }

        public final void e(int i10, int i11) {
            int[] iArr = this.f4080a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f4080a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f4080a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            List<a> list = this.f4081b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4081b.get(size);
                int i13 = aVar.f4082b;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f4081b.remove(size);
                    } else {
                        aVar.f4082b = i13 - i11;
                    }
                }
            }
        }

        public a getFullSpanItem(int i10) {
            List<a> list = this.f4081b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f4081b.get(size);
                if (aVar.f4082b == i10) {
                    return aVar;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0038a();

            /* renamed from: b, reason: collision with root package name */
            public int f4082b;

            /* renamed from: m, reason: collision with root package name */
            public int f4083m;

            /* renamed from: n, reason: collision with root package name */
            public int[] f4084n;

            /* renamed from: o, reason: collision with root package name */
            public boolean f4085o;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            public class C0038a implements Parcelable.Creator<a> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i10) {
                    return new a[i10];
                }
            }

            public a(Parcel parcel) {
                this.f4082b = parcel.readInt();
                this.f4083m = parcel.readInt();
                this.f4085o = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f4084n = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4082b + ", mGapDir=" + this.f4083m + ", mHasUnwantedGapAfter=" + this.f4085o + ", mGapPerSpan=" + Arrays.toString(this.f4084n) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f4082b);
                parcel.writeInt(this.f4083m);
                parcel.writeInt(this.f4085o ? 1 : 0);
                int[] iArr = this.f4084n;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4084n);
                }
            }

            public a() {
            }
        }
    }
}
