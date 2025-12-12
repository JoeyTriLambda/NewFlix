package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.l f4236a;

    /* renamed from: b, reason: collision with root package name */
    public int f4237b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f4238c = new Rect();

    /* compiled from: OrientationHelper.java */
    public class a extends o {
        public a(RecyclerView.l lVar) {
            super(lVar);
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedEnd(View view) {
            return this.f4236a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedMeasurement(View view) {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            return this.f4236a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            return this.f4236a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedStart(View view) {
            return this.f4236a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getEnd() {
            return this.f4236a.getWidth();
        }

        @Override // androidx.recyclerview.widget.o
        public int getEndAfterPadding() {
            RecyclerView.l lVar = this.f4236a;
            return lVar.getWidth() - lVar.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.o
        public int getEndPadding() {
            return this.f4236a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.o
        public int getMode() {
            return this.f4236a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.o
        public int getModeInOther() {
            return this.f4236a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.o
        public int getStartAfterPadding() {
            return this.f4236a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.o
        public int getTotalSpace() {
            RecyclerView.l lVar = this.f4236a;
            return (lVar.getWidth() - lVar.getPaddingLeft()) - lVar.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.o
        public int getTransformedEndWithDecoration(View view) {
            RecyclerView.l lVar = this.f4236a;
            Rect rect = this.f4238c;
            lVar.getTransformedBoundingBox(view, true, rect);
            return rect.right;
        }

        @Override // androidx.recyclerview.widget.o
        public int getTransformedStartWithDecoration(View view) {
            RecyclerView.l lVar = this.f4236a;
            Rect rect = this.f4238c;
            lVar.getTransformedBoundingBox(view, true, rect);
            return rect.left;
        }

        @Override // androidx.recyclerview.widget.o
        public void offsetChildren(int i10) {
            this.f4236a.offsetChildrenHorizontal(i10);
        }
    }

    /* compiled from: OrientationHelper.java */
    public class b extends o {
        public b(RecyclerView.l lVar) {
            super(lVar);
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedEnd(View view) {
            return this.f4236a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedMeasurement(View view) {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            return this.f4236a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            return this.f4236a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getDecoratedStart(View view) {
            return this.f4236a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.o
        public int getEnd() {
            return this.f4236a.getHeight();
        }

        @Override // androidx.recyclerview.widget.o
        public int getEndAfterPadding() {
            RecyclerView.l lVar = this.f4236a;
            return lVar.getHeight() - lVar.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.o
        public int getEndPadding() {
            return this.f4236a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.o
        public int getMode() {
            return this.f4236a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.o
        public int getModeInOther() {
            return this.f4236a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.o
        public int getStartAfterPadding() {
            return this.f4236a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.o
        public int getTotalSpace() {
            RecyclerView.l lVar = this.f4236a;
            return (lVar.getHeight() - lVar.getPaddingTop()) - lVar.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.o
        public int getTransformedEndWithDecoration(View view) {
            RecyclerView.l lVar = this.f4236a;
            Rect rect = this.f4238c;
            lVar.getTransformedBoundingBox(view, true, rect);
            return rect.bottom;
        }

        @Override // androidx.recyclerview.widget.o
        public int getTransformedStartWithDecoration(View view) {
            RecyclerView.l lVar = this.f4236a;
            Rect rect = this.f4238c;
            lVar.getTransformedBoundingBox(view, true, rect);
            return rect.top;
        }

        @Override // androidx.recyclerview.widget.o
        public void offsetChildren(int i10) {
            this.f4236a.offsetChildrenVertical(i10);
        }
    }

    public o(RecyclerView.l lVar) {
        this.f4236a = lVar;
    }

    public static o createHorizontalHelper(RecyclerView.l lVar) {
        return new a(lVar);
    }

    public static o createOrientationHelper(RecyclerView.l lVar, int i10) {
        if (i10 == 0) {
            return createHorizontalHelper(lVar);
        }
        if (i10 == 1) {
            return createVerticalHelper(lVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static o createVerticalHelper(RecyclerView.l lVar) {
        return new b(lVar);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.f4237b) {
            return 0;
        }
        return getTotalSpace() - this.f4237b;
    }

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChildren(int i10);

    public void onLayoutComplete() {
        this.f4237b = getTotalSpace();
    }
}
