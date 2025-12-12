package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.leanback.R;

/* loaded from: classes.dex */
class GuidanceStylingRelativeLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public final float f3051b;

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static float getKeyLinePercent(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(R.styleable.LeanbackGuidedStepTheme);
        float f10 = typedArrayObtainStyledAttributes.getFloat(R.styleable.LeanbackGuidedStepTheme_guidedStepKeyline, 40.0f);
        typedArrayObtainStyledAttributes.recycle();
        return f10;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View viewFindViewById = getRootView().findViewById(R.id.guidance_title);
        View viewFindViewById2 = getRootView().findViewById(R.id.guidance_breadcrumb);
        View viewFindViewById3 = getRootView().findViewById(R.id.guidance_description);
        ImageView imageView = (ImageView) getRootView().findViewById(R.id.guidance_icon);
        int measuredHeight = (int) ((getMeasuredHeight() * this.f3051b) / 100.0f);
        if (viewFindViewById != null && viewFindViewById.getParent() == this) {
            int baseline = (((measuredHeight - viewFindViewById.getBaseline()) - viewFindViewById2.getMeasuredHeight()) - viewFindViewById.getPaddingTop()) - viewFindViewById2.getTop();
            if (viewFindViewById2.getParent() == this) {
                viewFindViewById2.offsetTopAndBottom(baseline);
            }
            viewFindViewById.offsetTopAndBottom(baseline);
            if (viewFindViewById3 != null && viewFindViewById3.getParent() == this) {
                viewFindViewById3.offsetTopAndBottom(baseline);
            }
        }
        if (imageView == null || imageView.getParent() != this || imageView.getDrawable() == null) {
            return;
        }
        imageView.offsetTopAndBottom(measuredHeight - (imageView.getMeasuredHeight() / 2));
    }

    public GuidanceStylingRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3051b = getKeyLinePercent(context);
    }
}
