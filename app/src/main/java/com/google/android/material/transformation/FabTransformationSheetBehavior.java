package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import p6.h;
import p6.j;
import x0.j0;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: t, reason: collision with root package name */
    public HashMap f9532t;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.b onCreateMotionSpec(Context context, boolean z10) {
        int i10 = z10 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.b bVar = new FabTransformationBehavior.b();
        bVar.f9526a = h.createFromResource(context, i10);
        bVar.f9527b = new j(17, 0.0f, 0.0f);
        return bVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View view, View view2, boolean z10, boolean z11) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.f9532t = new HashMap(childCount);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                boolean z12 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z12) {
                    if (z10) {
                        this.f9532t.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        j0.setImportantForAccessibility(childAt, 4);
                    } else {
                        HashMap map = this.f9532t;
                        if (map != null && map.containsKey(childAt)) {
                            j0.setImportantForAccessibility(childAt, ((Integer) this.f9532t.get(childAt)).intValue());
                        }
                    }
                }
            }
            if (!z10) {
                this.f9532t = null;
            }
        }
        return super.onExpandedStateChange(view, view2, z10, z11);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
