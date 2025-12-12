package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class PlaybackTransportRowView extends LinearLayout {

    public interface a {
    }

    public PlaybackTransportRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View childAt;
        if (view != null) {
            if (i10 == 33) {
                for (int iIndexOfChild = indexOfChild(getFocusedChild()) - 1; iIndexOfChild >= 0; iIndexOfChild--) {
                    View childAt2 = getChildAt(iIndexOfChild);
                    if (childAt2.hasFocusable()) {
                        return childAt2;
                    }
                }
            } else {
                if (i10 == 130) {
                    int iIndexOfChild2 = indexOfChild(getFocusedChild());
                    do {
                        iIndexOfChild2++;
                        if (iIndexOfChild2 < getChildCount()) {
                            childAt = getChildAt(iIndexOfChild2);
                        }
                    } while (!childAt.hasFocusable());
                    return childAt;
                }
                if ((i10 == 17 || i10 == 66) && (getFocusedChild() instanceof ViewGroup)) {
                    return FocusFinder.getInstance().findNextFocus((ViewGroup) getFocusedChild(), view, i10);
                }
            }
        }
        return super.focusSearch(view, i10);
    }

    public a getOnUnhandledKeyListener() {
        return null;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View viewFindFocus = findFocus();
        if (viewFindFocus != null && viewFindFocus.requestFocus(i10, rect)) {
            return true;
        }
        View viewFindViewById = findViewById(R.id.playback_progress);
        if (viewFindViewById != null && viewFindViewById.isFocusable() && viewFindViewById.requestFocus(i10, rect)) {
            return true;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    public void setOnUnhandledKeyListener(a aVar) {
    }
}
