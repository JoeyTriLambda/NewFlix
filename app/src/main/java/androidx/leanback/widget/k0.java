package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.leanback.R;

/* compiled from: RowContainerView.java */
/* loaded from: classes.dex */
public final class k0 extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f3281b;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f3282m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3283n;

    public k0(Context context) {
        this(context, null, 0);
    }

    public void addHeaderView(View view) {
        ViewGroup viewGroup = this.f3281b;
        if (viewGroup.indexOfChild(view) < 0) {
            viewGroup.addView(view, 0);
        }
    }

    public void addRowView(View view) {
        addView(view);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3282m;
        if (drawable != null) {
            if (this.f3283n) {
                this.f3283n = false;
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f3282m.draw(canvas);
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3282m;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f3283n = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        this.f3282m = drawable;
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setForegroundColor(int i10) {
        Drawable drawable = this.f3282m;
        if (!(drawable instanceof ColorDrawable)) {
            setForeground(new ColorDrawable(i10));
        } else {
            ((ColorDrawable) drawable.mutate()).setColor(i10);
            invalidate();
        }
    }

    public void showHeader(boolean z10) {
        this.f3281b.setVisibility(z10 ? 0 : 8);
    }

    public k0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3283n = true;
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.lb_row_container, this);
        this.f3281b = (ViewGroup) findViewById(R.id.lb_row_container_header_dock);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }
}
