package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NonOverlappingLinearLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3075b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3076m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<ArrayList<View>> f3077n;

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        int iIndexOfChild;
        if (!this.f3076m) {
            super.focusableViewAvailable(view);
            return;
        }
        for (View view2 = view; view2 != this && view2 != null; view2 = (View) view2.getParent()) {
            if (view2.getParent() == this) {
                iIndexOfChild = indexOfChild(view2);
                break;
            }
        }
        iIndexOfChild = -1;
        if (iIndexOfChild != -1) {
            this.f3077n.get(iIndexOfChild).add(view);
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ArrayList<ArrayList<View>> arrayList = this.f3077n;
        ?? r12 = 0;
        int i14 = 0;
        try {
            boolean z11 = this.f3075b && getOrientation() == 0 && getLayoutDirection() == 1;
            this.f3076m = z11;
            if (z11) {
                while (arrayList.size() > getChildCount()) {
                    arrayList.remove(arrayList.size() - 1);
                }
                while (arrayList.size() < getChildCount()) {
                    arrayList.add(new ArrayList<>());
                }
            }
            super.onLayout(z10, i10, i11, i12, i13);
            if (this.f3076m) {
                for (int i15 = 0; i15 < arrayList.size(); i15++) {
                    for (int i16 = 0; i16 < arrayList.get(i15).size(); i16++) {
                        super.focusableViewAvailable(arrayList.get(i15).get(i16));
                    }
                }
            }
        } finally {
            if (this.f3076m) {
                this.f3076m = false;
                while (r12 < arrayList.size()) {
                    arrayList.get(r12).clear();
                    r12++;
                }
            }
        }
    }

    public void setFocusableViewAvailableFixEnabled(boolean z10) {
        this.f3075b = z10;
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3075b = false;
        this.f3077n = new ArrayList<>();
    }
}
