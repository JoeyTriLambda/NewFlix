package com.google.android.material.textfield;

import ac.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.l;
import com.google.android.material.R;
import i7.f;
import i7.r;

/* loaded from: classes.dex */
public class TextInputEditText extends l {

    /* renamed from: r, reason: collision with root package name */
    public final Rect f9405r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9406s;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout != null && this.f9406s) || rect == null) {
            return;
        }
        Rect rect2 = this.f9405r;
        textInputLayout.getFocusedRect(rect2);
        rect.bottom = rect2.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout != null && this.f9406s)) {
            return super.getGlobalVisibleRect(rect, point);
        }
        boolean globalVisibleRect = textInputLayout.getGlobalVisibleRect(rect, point);
        if (globalVisibleRect && point != null) {
            point.offset(-getScrollX(), -getScrollY());
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.isProvidingHint()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.isProvidingHint() && super.getHint() == null && f.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.l, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z10 = !TextUtils.isEmpty(text);
        string = "";
        String string2 = TextUtils.isEmpty(hint) ^ true ? hint.toString() : "";
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) text);
            sb2.append(TextUtils.isEmpty(string2) ? "" : c.j(", ", string2));
            string = sb2.toString();
        } else if (!TextUtils.isEmpty(string2)) {
            string = string2;
        }
        accessibilityNodeInfo.setText(string);
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout != null && this.f9406s) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        int height = textInputLayout.getHeight() - getHeight();
        int i10 = rect.left;
        int i11 = rect.top;
        int i12 = rect.right;
        int i13 = rect.bottom + height;
        Rect rect2 = this.f9405r;
        rect2.set(i10, i11, i12, i13);
        return super.requestRectangleOnScreen(rect2);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f9406s = z10;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.wrap(context, attributeSet, i10, 0), attributeSet, i10);
        this.f9405r = new Rect();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context, attributeSet, R.styleable.TextInputEditText, i10, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
