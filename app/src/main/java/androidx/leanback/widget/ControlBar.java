package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ControlBar extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f3049b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3050m;

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3049b = -1;
        this.f3050m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (i10 != 33 && i10 != 130) {
            super.addFocusables(arrayList, i10, i11);
            return;
        }
        int i12 = this.f3049b;
        if (i12 >= 0 && i12 < getChildCount()) {
            arrayList.add(getChildAt(this.f3049b));
        } else if (getChildCount() > 0) {
            arrayList.add(getChildAt(this.f3050m ? getChildCount() / 2 : 0));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (getChildCount() > 0) {
            int i11 = this.f3049b;
            if (getChildAt((i11 < 0 || i11 >= getChildCount()) ? this.f3050m ? getChildCount() / 2 : 0 : this.f3049b).requestFocus(i10, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f3049b = indexOfChild(view);
    }
}
