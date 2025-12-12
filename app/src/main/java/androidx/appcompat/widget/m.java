package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.R;

/* compiled from: AppCompatEmojiEditTextHelper.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f1445a;

    /* renamed from: b, reason: collision with root package name */
    public final n1.a f1446b;

    public m(EditText editText) {
        this.f1445a = editText;
        this.f1446b = new n1.a(editText, false);
    }

    public final KeyListener a(KeyListener keyListener) {
        return (keyListener instanceof NumberKeyListener) ^ true ? this.f1446b.getKeyListener(keyListener) : keyListener;
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f1445a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            this.f1446b.setEnabled(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
