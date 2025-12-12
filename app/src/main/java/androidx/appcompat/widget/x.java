package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class x extends SeekBar {

    /* renamed from: b, reason: collision with root package name */
    public final y f1544b;

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f1544b;
        Drawable drawable = yVar.f1553e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        SeekBar seekBar = yVar.f1552d;
        if (drawable.setState(seekBar.getDrawableState())) {
            seekBar.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1544b.f1553e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1544b.d(canvas);
    }

    public x(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i10);
        x0.checkAppCompatTheme(this, getContext());
        y yVar = new y(this);
        this.f1544b = yVar;
        yVar.a(attributeSet, i10);
    }
}
