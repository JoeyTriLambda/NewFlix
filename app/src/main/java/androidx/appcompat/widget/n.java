package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;

/* compiled from: AppCompatEmojiTextHelper.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1462a;

    /* renamed from: b, reason: collision with root package name */
    public final n1.f f1463b;

    public n(TextView textView) {
        this.f1462a = textView;
        this.f1463b = new n1.f(textView, false);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1463b.getFilters(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f1462a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public final void c(boolean z10) {
        this.f1463b.setAllCaps(z10);
    }

    public final void d(boolean z10) {
        this.f1463b.setEnabled(z10);
    }

    public boolean isEnabled() {
        return this.f1463b.isEnabled();
    }

    public TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
        return this.f1463b.wrapTransformationMethod(transformationMethod);
    }
}
