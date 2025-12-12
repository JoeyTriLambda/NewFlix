package n1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* compiled from: EmojiTransformationMethod.java */
/* loaded from: classes.dex */
public final class h implements TransformationMethod {

    /* renamed from: b, reason: collision with root package name */
    public final TransformationMethod f16472b;

    public h(TransformationMethod transformationMethod) {
        this.f16472b = transformationMethod;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.f16472b;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f16472b;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.f.get().getLoadState() != 1) ? charSequence : androidx.emoji2.text.f.get().process(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f16472b;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
