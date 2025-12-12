package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import x0.j0;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: b, reason: collision with root package name */
    public int f9510b;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f9511b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f9512m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g7.a f9513n;

        public a(View view, int i10, g7.a aVar) {
            this.f9511b = view;
            this.f9512m = i10;
            this.f9513n = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view = this.f9511b;
            view.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.f9510b == this.f9512m) {
                g7.a aVar = this.f9513n;
                expandableBehavior.onExpandedStateChange((View) aVar, view, aVar.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f9510b = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g7.a findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = dependencies.get(i10);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (g7.a) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i10;
        g7.a aVar = (g7.a) view2;
        if (!(!aVar.isExpanded() ? this.f9510b != 1 : !((i10 = this.f9510b) == 0 || i10 == 2))) {
            return false;
        }
        this.f9510b = aVar.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) aVar, view, aVar.isExpanded(), true);
    }

    public abstract boolean onExpandedStateChange(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
        g7.a aVarFindExpandableWidget;
        int i11;
        if (!j0.isLaidOut(view) && (aVarFindExpandableWidget = findExpandableWidget(coordinatorLayout, view)) != null) {
            if (!aVarFindExpandableWidget.isExpanded() ? this.f9510b != 1 : !((i11 = this.f9510b) == 0 || i11 == 2)) {
                int i12 = aVarFindExpandableWidget.isExpanded() ? 1 : 2;
                this.f9510b = i12;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i12, aVarFindExpandableWidget));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9510b = 0;
    }
}
