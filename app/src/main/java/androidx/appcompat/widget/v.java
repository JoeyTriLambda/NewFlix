package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* compiled from: AppCompatRatingBar.java */
/* loaded from: classes.dex */
public final class v extends RatingBar {

    /* renamed from: b, reason: collision with root package name */
    public final t f1534b;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap bitmap = this.f1534b.f1520b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public v(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        t tVar = new t(this);
        this.f1534b = tVar;
        tVar.a(attributeSet, i10);
    }
}
