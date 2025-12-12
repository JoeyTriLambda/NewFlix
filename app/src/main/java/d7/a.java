package d7;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener.java */
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public final Dialog f10949b;

    /* renamed from: m, reason: collision with root package name */
    public final int f10950m;

    /* renamed from: n, reason: collision with root package name */
    public final int f10951n;

    /* renamed from: o, reason: collision with root package name */
    public final int f10952o;

    public a(Dialog dialog, Rect rect) {
        this.f10949b = dialog;
        this.f10950m = rect.left;
        this.f10951n = rect.top;
        this.f10952o = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f10950m;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.f10951n, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i10 = this.f10952o;
            motionEventObtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f10949b.onTouchEvent(motionEventObtain);
    }
}
