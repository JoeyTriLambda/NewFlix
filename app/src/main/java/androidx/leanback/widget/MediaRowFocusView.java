package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.leanback.R;

/* loaded from: classes.dex */
class MediaRowFocusView extends View {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f3072b;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f3073m;

    /* renamed from: n, reason: collision with root package name */
    public int f3074n;

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3073m = new RectF();
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.lb_playback_media_row_highlight_color));
        this.f3072b = paint;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.f3074n = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        RectF rectF = this.f3073m;
        rectF.set(0.0f, -height2, getWidth(), getHeight() + height2);
        int i10 = this.f3074n;
        canvas.drawRoundRect(rectF, i10, i10, this.f3072b);
    }
}
