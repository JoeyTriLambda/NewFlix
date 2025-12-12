package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public final class f extends View {

    /* renamed from: b, reason: collision with root package name */
    public int f2077b;

    /* renamed from: m, reason: collision with root package name */
    public View f2078m;

    /* renamed from: n, reason: collision with root package name */
    public int f2079n;

    public View getContent() {
        return this.f2078m;
    }

    public int getEmptyVisibility() {
        return this.f2079n;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (iHeight / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View viewFindViewById;
        if (this.f2077b == i10) {
            return;
        }
        View view = this.f2078m;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f2078m.getLayoutParams()).f1905f0 = false;
            this.f2078m = null;
        }
        this.f2077b = i10;
        if (i10 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i10)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i10) {
        this.f2079n = i10;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.f2078m == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f2078m.getLayoutParams();
        aVar2.f1927q0.setVisibility(0);
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = aVar.f1927q0.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour != dimensionBehaviour) {
            aVar.f1927q0.setWidth(aVar2.f1927q0.getWidth());
        }
        if (aVar.f1927q0.getVerticalDimensionBehaviour() != dimensionBehaviour) {
            aVar.f1927q0.setHeight(aVar2.f1927q0.getHeight());
        }
        aVar2.f1927q0.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.f2077b == -1 && !isInEditMode()) {
            setVisibility(this.f2079n);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f2077b);
        this.f2078m = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.a) viewFindViewById.getLayoutParams()).f1905f0 = true;
            this.f2078m.setVisibility(0);
            setVisibility(0);
        }
    }
}
