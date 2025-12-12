package flix.com.vision.filepickerlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes2.dex */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i10, int i11, int i12, int i13) {
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, i10, i11, i12, i13);
        if (i11 > 0 && floatingActionButton.getVisibility() == 0) {
            floatingActionButton.hide();
        } else {
            if (i11 >= 0 || floatingActionButton.getVisibility() == 0) {
                return;
            }
            floatingActionButton.show();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, View view2, int i10) {
        return i10 == 2 || super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, view2, i10);
    }
}
