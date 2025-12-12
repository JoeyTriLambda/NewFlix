package q6;

import android.view.View;
import x0.j0;

/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final View f17918a;

    /* renamed from: b, reason: collision with root package name */
    public int f17919b;

    /* renamed from: c, reason: collision with root package name */
    public int f17920c;

    /* renamed from: d, reason: collision with root package name */
    public int f17921d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17922e = true;

    public f(View view) {
        this.f17918a = view;
    }

    public final void a() {
        int i10 = this.f17921d;
        View view = this.f17918a;
        j0.offsetTopAndBottom(view, i10 - (view.getTop() - this.f17919b));
        j0.offsetLeftAndRight(view, 0 - (view.getLeft() - this.f17920c));
    }

    public int getLayoutTop() {
        return this.f17919b;
    }

    public int getTopAndBottomOffset() {
        return this.f17921d;
    }

    public boolean setTopAndBottomOffset(int i10) {
        if (!this.f17922e || this.f17921d == i10) {
            return false;
        }
        this.f17921d = i10;
        a();
        return true;
    }
}
