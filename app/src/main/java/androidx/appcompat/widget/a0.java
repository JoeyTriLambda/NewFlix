package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1247a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f1248b;

    /* compiled from: AppCompatTextClassifierHelper.java */
    public static final class a {
        public static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public a0(TextView textView) {
        this.f1247a = (TextView) w0.h.checkNotNull(textView);
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier = this.f1248b;
        return textClassifier == null ? a.a(this.f1247a) : textClassifier;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.f1248b = textClassifier;
    }
}
