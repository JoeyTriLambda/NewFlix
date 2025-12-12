package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Guideline extends View {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1946b;

    public Guideline(Context context) {
        super(context);
        this.f1946b = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z10) {
        this.f1946b = z10;
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1946b && aVar.f1894a == i10) {
            return;
        }
        aVar.f1894a = i10;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1946b && aVar.f1896b == i10) {
            return;
        }
        aVar.f1896b = i10;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1946b && aVar.f1898c == f10) {
            return;
        }
        aVar.f1898c = f10;
        setLayoutParams(aVar);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1946b = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }
}
