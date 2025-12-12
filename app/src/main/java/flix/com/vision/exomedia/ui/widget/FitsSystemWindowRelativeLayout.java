package flix.com.vision.exomedia.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class FitsSystemWindowRelativeLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public Rect f12239b;

    public FitsSystemWindowRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setFitsSystemWindows(true);
        if (this.f12239b == null) {
            this.f12239b = new Rect(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        Rect rect = new Rect();
        Rect rect2 = this.f12239b;
        int i10 = rect2.right + rect.right;
        int i11 = rect2.bottom + rect.bottom;
        setPadding(rect2.left, rect2.top + rect.top, i10, i11);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        Rect rect2 = this.f12239b;
        int i10 = rect2.right + rect.right;
        int i11 = rect2.bottom + rect.bottom;
        setPadding(rect2.left, rect2.top + rect.top, i10, i11);
        return false;
    }

    @Override // android.view.View
    @TargetApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        fitSystemWindows(new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()));
        return windowInsets;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().smallestScreenWidthDp <= 600) {
            a();
        }
    }
}
