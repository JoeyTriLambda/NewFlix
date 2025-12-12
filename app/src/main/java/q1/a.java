package q1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.leanback.R;

/* compiled from: ColorOverlayDimmer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f17775a;

    /* renamed from: b, reason: collision with root package name */
    public final float f17776b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f17777c;

    public a(int i10, float f10, float f11) {
        f10 = f10 > 1.0f ? 1.0f : f10;
        f10 = f10 < 0.0f ? 0.0f : f10;
        f11 = f11 > 1.0f ? 1.0f : f11;
        float f12 = f11 >= 0.0f ? f11 : 0.0f;
        Paint paint = new Paint();
        this.f17777c = paint;
        paint.setColor(Color.rgb(Color.red(i10), Color.green(i10), Color.blue(i10)));
        this.f17775a = f10;
        this.f17776b = f12;
        setActiveLevel(1.0f);
    }

    public static a createDefault(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        typedArrayObtainStyledAttributes.recycle();
        return new a(color, fraction, fraction2);
    }

    public Paint getPaint() {
        return this.f17777c;
    }

    public void setActiveLevel(float f10) {
        float f11 = this.f17775a;
        float f12 = this.f17776b;
        this.f17777c.setAlpha((int) ((((f11 - f12) * f10) + f12) * 255.0f));
    }
}
