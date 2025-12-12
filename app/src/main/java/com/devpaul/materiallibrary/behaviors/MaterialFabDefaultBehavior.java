package com.devpaul.materiallibrary.behaviors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.devpaul.materiallibrary.views.MaterialFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: classes.dex */
public class MaterialFabDefaultBehavior extends CoordinatorLayout.c<MaterialFloatingActionButton> {
    public MaterialFabDefaultBehavior(Context context, AttributeSet attributeSet) {
    }

    public MaterialFabDefaultBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, MaterialFloatingActionButton materialFloatingActionButton, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, MaterialFloatingActionButton materialFloatingActionButton, View view) {
        materialFloatingActionButton.setTranslationY(Math.min(0.0f, view.getTranslationY() - view.getHeight()));
        return true;
    }
}
