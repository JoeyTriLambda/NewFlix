package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.leanback.R;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public class SearchEditText extends y0 {

    /* renamed from: s, reason: collision with root package name */
    public a f3141s;

    public interface a {
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.TextAppearance_Leanback_SearchTextEdit);
    }

    @Override // androidx.leanback.widget.y0, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyPreIme(i10, keyEvent);
        }
        a aVar = this.f3141s;
        if (aVar == null) {
            return false;
        }
        ((SearchBar.d) aVar).onKeyboardDismiss();
        return false;
    }

    @Override // androidx.leanback.widget.y0
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // androidx.leanback.widget.y0, android.widget.TextView
    public /* bridge */ /* synthetic */ void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // androidx.leanback.widget.y0
    public /* bridge */ /* synthetic */ void setFinalRecognizedText(CharSequence charSequence) {
        super.setFinalRecognizedText(charSequence);
    }

    public void setOnKeyboardDismissListener(a aVar) {
        this.f3141s = aVar;
    }

    @Override // androidx.leanback.widget.y0
    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, String str2) {
        super.updateRecognizedText(str, str2);
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
