package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes.dex */
public class GuidedActionEditText extends EditText {

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f3052b;

    /* renamed from: m, reason: collision with root package name */
    public final a f3053m;

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            setBackground(this.f3052b);
        } else {
            setBackground(this.f3053m);
        }
        if (z10) {
            return;
        }
        setFocusable(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((isFocused() ? EditText.class : TextView.class).getName());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        return super.onKeyPreIme(i10, keyEvent);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3052b = getBackground();
        a aVar = new a();
        this.f3053m = aVar;
        setBackground(aVar);
    }

    public static final class a extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            rect.set(0, 0, 0, 0);
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public void setImeKeyListener(o oVar) {
    }

    public void setOnAutofillListener(l lVar) {
    }
}
