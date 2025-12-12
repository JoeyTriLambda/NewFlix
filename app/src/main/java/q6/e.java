package q6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
public class e<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: b, reason: collision with root package name */
    public f f17916b;

    /* renamed from: m, reason: collision with root package name */
    public int f17917m;

    public e() {
        this.f17917m = 0;
    }

    public int getTopAndBottomOffset() {
        f fVar = this.f17916b;
        if (fVar != null) {
            return fVar.getTopAndBottomOffset();
        }
        return 0;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.onLayoutChild(v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        layoutChild(coordinatorLayout, v10, i10);
        if (this.f17916b == null) {
            this.f17916b = new f(v10);
        }
        f fVar = this.f17916b;
        View view = fVar.f17918a;
        fVar.f17919b = view.getTop();
        fVar.f17920c = view.getLeft();
        this.f17916b.a();
        int i11 = this.f17917m;
        if (i11 == 0) {
            return true;
        }
        this.f17916b.setTopAndBottomOffset(i11);
        this.f17917m = 0;
        return true;
    }

    public boolean setTopAndBottomOffset(int i10) {
        f fVar = this.f17916b;
        if (fVar != null) {
            return fVar.setTopAndBottomOffset(i10);
        }
        this.f17917m = i10;
        return false;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17917m = 0;
    }
}
