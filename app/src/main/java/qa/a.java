package qa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: ContextExtension.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final Drawable contextDrawable(Context context, int i10) {
        zf.i.checkNotNullParameter(context, "$this$contextDrawable");
        return m0.a.getDrawable(context, i10);
    }

    public static final int dp2Px(Context context, int i10) {
        zf.i.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        zf.i.checkNotNullExpressionValue(resources, "resources");
        return (int) (i10 * resources.getDisplayMetrics().density);
    }

    public static final int dp2Px(View view, int i10) {
        zf.i.checkNotNullParameter(view, "$this$dp2Px");
        Context context = view.getContext();
        zf.i.checkNotNullExpressionValue(context, "context");
        return dp2Px(context, i10);
    }

    public static final int dp2Px(Context context, float f10) {
        zf.i.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        zf.i.checkNotNullExpressionValue(resources, "resources");
        return (int) (f10 * resources.getDisplayMetrics().density);
    }

    public static final int dp2Px(View view, float f10) {
        zf.i.checkNotNullParameter(view, "$this$dp2Px");
        Context context = view.getContext();
        zf.i.checkNotNullExpressionValue(context, "context");
        return dp2Px(context, f10);
    }
}
