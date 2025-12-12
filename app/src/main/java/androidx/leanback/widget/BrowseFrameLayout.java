package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class BrowseFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public View.OnKeyListener f3046b;

    public interface a {
    }

    public interface b {
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zDispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.f3046b;
        return (onKeyListener == null || zDispatchKeyEvent) ? zDispatchKeyEvent : onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        return super.focusSearch(view, i10);
    }

    public a getOnChildFocusListener() {
        return null;
    }

    public b getOnFocusSearchListener() {
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
    }

    public void setOnDispatchKeyListener(View.OnKeyListener onKeyListener) {
        this.f3046b = onKeyListener;
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void setOnChildFocusListener(a aVar) {
    }

    public void setOnFocusSearchListener(b bVar) {
    }
}
