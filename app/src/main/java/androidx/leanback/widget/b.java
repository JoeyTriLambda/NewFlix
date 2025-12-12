package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.widget.c1;
import androidx.leanback.widget.v;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: BaseGridView.java */
/* loaded from: classes.dex */
public abstract class b extends RecyclerView {
    public final j Q0;
    public boolean R0;
    public boolean S0;
    public RecyclerView.i T0;
    public RecyclerView.s U0;
    public e V0;
    public int W0;

    /* compiled from: BaseGridView.java */
    public class a implements RecyclerView.s {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onViewRecycled(RecyclerView.z zVar) {
            b bVar = b.this;
            j jVar = bVar.Q0;
            jVar.getClass();
            int adapterPosition = zVar.getAdapterPosition();
            if (adapterPosition != -1) {
                jVar.f3245c0.saveOffscreenView(zVar.f4041a, adapterPosition);
            }
            RecyclerView.s sVar = bVar.U0;
            if (sVar != null) {
                sVar.onViewRecycled(zVar);
            }
        }
    }

    /* compiled from: BaseGridView.java */
    /* renamed from: androidx.leanback.widget.b$b, reason: collision with other inner class name */
    public interface InterfaceC0028b {
    }

    /* compiled from: BaseGridView.java */
    public interface c {
    }

    /* compiled from: BaseGridView.java */
    public interface d {
    }

    /* compiled from: BaseGridView.java */
    public interface e {
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.R0 = true;
        this.S0 = true;
        this.W0 = 4;
        j jVar = new j(this);
        this.Q0 = jVar;
        setLayoutManager(jVar);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((androidx.recyclerview.widget.u) getItemAnimator()).setSupportsChangeAnimations(false);
        super.setRecyclerListener(new a());
    }

    public final void X(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseGridView);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutFront, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutEnd, false);
        j jVar = this.Q0;
        jVar.setFocusOutAllowed(z10, z11);
        jVar.setFocusOutSideAllowed(typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideStart, true), typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideEnd, true));
        jVar.setVerticalSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_verticalSpacing, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_verticalMargin, 0)));
        jVar.setHorizontalSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_horizontalSpacing, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_horizontalMargin, 0)));
        int i10 = R.styleable.lbBaseGridView_android_gravity;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            setGravity(typedArrayObtainStyledAttributes.getInt(i10, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final boolean Y() {
        return isChildrenDrawingOrderEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        e eVar = this.V0;
        return eVar != null && ((v.b) eVar).onUnhandledKey(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public View focusSearch(int i10) {
        if (isFocused()) {
            j jVar = this.Q0;
            View viewFindViewByPosition = jVar.findViewByPosition(jVar.getSelection());
            if (viewFindViewByPosition != null) {
                return focusSearch(viewFindViewByPosition, i10);
            }
        }
        return super.focusSearch(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        int iIndexOfChild;
        j jVar = this.Q0;
        View viewFindViewByPosition = jVar.findViewByPosition(jVar.C);
        if (viewFindViewByPosition == null || i11 < (iIndexOfChild = indexOfChild(viewFindViewByPosition))) {
            return i11;
        }
        if (i11 < i10 - 1) {
            iIndexOfChild = ((iIndexOfChild + i10) - 1) - i11;
        }
        return iIndexOfChild;
    }

    public int getExtraLayoutSpace() {
        return this.Q0.f3243a0;
    }

    public int getFocusScrollStrategy() {
        return this.Q0.getFocusScrollStrategy();
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.Q0.getHorizontalSpacing();
    }

    public int getHorizontalSpacing() {
        return this.Q0.getHorizontalSpacing();
    }

    public int getInitialPrefetchItemCount() {
        return this.W0;
    }

    public int getItemAlignmentOffset() {
        return this.Q0.getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.Q0.getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.Q0.getItemAlignmentViewId();
    }

    public e getOnUnhandledKeyListener() {
        return this.V0;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.Q0.f3245c0.getLimitNumber();
    }

    public final int getSaveChildrenPolicy() {
        return this.Q0.f3245c0.getSavePolicy();
    }

    public int getSelectedPosition() {
        return this.Q0.getSelection();
    }

    public int getSelectedSubPosition() {
        return this.Q0.getSubSelection();
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.Q0.getVerticalSpacing();
    }

    public int getVerticalSpacing() {
        return this.Q0.getVerticalSpacing();
    }

    public int getWindowAlignment() {
        return this.Q0.getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.Q0.getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.Q0.getWindowAlignmentOffsetPercent();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.S0;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        j jVar = this.Q0;
        if (!z10) {
            jVar.getClass();
            return;
        }
        int i11 = jVar.C;
        while (true) {
            View viewFindViewByPosition = jVar.findViewByPosition(i11);
            if (viewFindViewByPosition == null) {
                return;
            }
            if (viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.hasFocusable()) {
                viewFindViewByPosition.requestFocus();
                return;
            }
            i11++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        j jVar = this.Q0;
        int i14 = jVar.W;
        if (i14 != 1 && i14 != 2) {
            View viewFindViewByPosition = jVar.findViewByPosition(jVar.C);
            if (viewFindViewByPosition != null) {
                return viewFindViewByPosition.requestFocus(i10, rect);
            }
            return false;
        }
        int childCount = jVar.getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        c1 c1Var = jVar.X;
        int paddingMin = c1Var.mainAxis().getPaddingMin();
        int clientSize = c1Var.mainAxis().getClientSize() + paddingMin;
        while (i11 != i12) {
            View childAt = jVar.getChildAt(i11);
            if (childAt.getVisibility() == 0 && jVar.A(childAt) >= paddingMin && jVar.z(childAt) <= clientSize && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        this.Q0.onRtlPropertiesChanged(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i10) {
        j jVar = this.Q0;
        if ((jVar.f3259z & 64) != 0) {
            jVar.setSelectionWithSub(i10, 0, 0);
        } else {
            super.scrollToPosition(i10);
        }
    }

    public void setAnimateChildLayout(boolean z10) {
        if (this.R0 != z10) {
            this.R0 = z10;
            if (z10) {
                super.setItemAnimator(this.T0);
            } else {
                this.T0 = getItemAnimator();
                super.setItemAnimator(null);
            }
        }
    }

    public void setChildrenVisibility(int i10) {
        j jVar = this.Q0;
        jVar.I = i10;
        if (i10 != -1) {
            int childCount = jVar.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                jVar.getChildAt(i11).setVisibility(jVar.I);
            }
        }
    }

    public void setExtraLayoutSpace(int i10) {
        j jVar = this.Q0;
        int i11 = jVar.f3243a0;
        if (i11 == i10) {
            return;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
        jVar.f3243a0 = i10;
        jVar.requestLayout();
    }

    public void setFocusDrawingOrderEnabled(boolean z10) {
        super.setChildrenDrawingOrderEnabled(z10);
    }

    public void setFocusScrollStrategy(int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("Invalid scrollStrategy");
        }
        this.Q0.setFocusScrollStrategy(i10);
        requestLayout();
    }

    public final void setFocusSearchDisabled(boolean z10) {
        setDescendantFocusability(z10 ? 393216 : 262144);
        j jVar = this.Q0;
        jVar.f3259z = (z10 ? 32768 : 0) | (jVar.f3259z & (-32769));
    }

    public void setGravity(int i10) {
        this.Q0.setGravity(i10);
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z10) {
        this.S0 = z10;
    }

    @Deprecated
    public void setHorizontalMargin(int i10) {
        setHorizontalSpacing(i10);
    }

    public void setHorizontalSpacing(int i10) {
        this.Q0.setHorizontalSpacing(i10);
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.W0 = i10;
    }

    public void setItemAlignmentOffset(int i10) {
        this.Q0.setItemAlignmentOffset(i10);
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f10) {
        this.Q0.setItemAlignmentOffsetPercent(f10);
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z10) {
        this.Q0.setItemAlignmentOffsetWithPadding(z10);
        requestLayout();
    }

    public void setItemAlignmentViewId(int i10) {
        this.Q0.setItemAlignmentViewId(i10);
    }

    @Deprecated
    public void setItemMargin(int i10) {
        setItemSpacing(i10);
    }

    public void setItemSpacing(int i10) {
        this.Q0.setItemSpacing(i10);
        requestLayout();
    }

    public void setLayoutEnabled(boolean z10) {
        this.Q0.setLayoutEnabled(z10);
    }

    public void setOnChildLaidOutListener(z zVar) {
        this.Q0.getClass();
    }

    public void setOnChildSelectedListener(a0 a0Var) {
        this.Q0.setOnChildSelectedListener(a0Var);
    }

    public void setOnChildViewHolderSelectedListener(b0 b0Var) {
        this.Q0.setOnChildViewHolderSelectedListener(b0Var);
    }

    public void setOnUnhandledKeyListener(e eVar) {
        this.V0 = eVar;
    }

    public void setPruneChild(boolean z10) {
        this.Q0.setPruneChild(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecyclerListener(RecyclerView.s sVar) {
        this.U0 = sVar;
    }

    public final void setSaveChildrenLimitNumber(int i10) {
        this.Q0.f3245c0.setLimitNumber(i10);
    }

    public final void setSaveChildrenPolicy(int i10) {
        this.Q0.f3245c0.setSavePolicy(i10);
    }

    public void setScrollEnabled(boolean z10) {
        this.Q0.setScrollEnabled(z10);
    }

    public void setSelectedPosition(int i10) {
        this.Q0.setSelection(i10, 0);
    }

    public void setSelectedPositionSmooth(int i10) {
        this.Q0.setSelectionSmooth(i10);
    }

    @Deprecated
    public void setVerticalMargin(int i10) {
        setVerticalSpacing(i10);
    }

    public void setVerticalSpacing(int i10) {
        this.Q0.setVerticalSpacing(i10);
        requestLayout();
    }

    public void setWindowAlignment(int i10) {
        this.Q0.setWindowAlignment(i10);
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i10) {
        this.Q0.setWindowAlignmentOffset(i10);
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f10) {
        this.Q0.setWindowAlignmentOffsetPercent(f10);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z10) {
        c1.a aVarMainAxis = this.Q0.X.mainAxis();
        aVarMainAxis.f3206e = z10 ? aVarMainAxis.f3206e | 2 : aVarMainAxis.f3206e & (-3);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z10) {
        c1.a aVarMainAxis = this.Q0.X.mainAxis();
        aVarMainAxis.f3206e = z10 ? aVarMainAxis.f3206e | 1 : aVarMainAxis.f3206e & (-2);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i10) {
        j jVar = this.Q0;
        if ((jVar.f3259z & 64) != 0) {
            jVar.setSelectionWithSub(i10, 0, 0);
        } else {
            super.smoothScrollToPosition(i10);
        }
    }

    public void setOnKeyInterceptListener(InterfaceC0028b interfaceC0028b) {
    }

    public void setOnMotionInterceptListener(c cVar) {
    }

    public void setOnTouchInterceptListener(d dVar) {
    }
}
