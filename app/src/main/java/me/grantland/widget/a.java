package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: AutofitHelper.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f16280a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f16281b;

    /* renamed from: c, reason: collision with root package name */
    public float f16282c;

    /* renamed from: d, reason: collision with root package name */
    public int f16283d;

    /* renamed from: e, reason: collision with root package name */
    public float f16284e;

    /* renamed from: f, reason: collision with root package name */
    public float f16285f;

    /* renamed from: g, reason: collision with root package name */
    public float f16286g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16287h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16288i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<c> f16289j;

    /* renamed from: k, reason: collision with root package name */
    public final b f16290k = new b();

    /* renamed from: l, reason: collision with root package name */
    public final ViewOnLayoutChangeListenerC0201a f16291l = new ViewOnLayoutChangeListenerC0201a();

    /* compiled from: AutofitHelper.java */
    /* renamed from: me.grantland.widget.a$a, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0201a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0201a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            a.this.a();
        }
    }

    /* compiled from: AutofitHelper.java */
    public interface c {
        void onTextSizeChange(float f10, float f11);
    }

    public a(TextView textView) {
        float f10 = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.f16280a = textView;
        this.f16281b = new TextPaint();
        float textSize = textView.getTextSize();
        if (this.f16282c != textSize) {
            this.f16282c = textSize;
        }
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        this.f16283d = (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) ? textView.getMaxLines() : 1;
        this.f16284e = f10 * 8.0f;
        this.f16285f = this.f16282c;
        this.f16286g = 0.5f;
    }

    public static float b(CharSequence charSequence, TextPaint textPaint, float f10, int i10, float f11, float f12, float f13, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int lineCount;
        float fMeasureText;
        float f14 = (f11 + f12) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f14, displayMetrics));
        if (i10 != 1) {
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            lineCount = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            lineCount = 1;
        }
        if (lineCount > i10) {
            return f12 - f11 < f13 ? f11 : b(charSequence, textPaint, f10, i10, f11, f14, f13, displayMetrics);
        }
        if (lineCount < i10) {
            return b(charSequence, textPaint, f10, i10, f14, f12, f13, displayMetrics);
        }
        if (i10 == 1) {
            fMeasureText = textPaint.measureText(charSequence, 0, charSequence.length());
        } else {
            float lineWidth = 0.0f;
            for (int i11 = 0; i11 < lineCount; i11++) {
                if (staticLayout.getLineWidth(i11) > lineWidth) {
                    lineWidth = staticLayout.getLineWidth(i11);
                }
            }
            fMeasureText = lineWidth;
        }
        return f12 - f11 < f13 ? f11 : fMeasureText > f10 ? b(charSequence, textPaint, f10, i10, f11, f14, f13, displayMetrics) : fMeasureText < f10 ? b(charSequence, textPaint, f10, i10, f14, f12, f13, displayMetrics) : f14;
    }

    public static a create(TextView textView, AttributeSet attributeSet, int i10) {
        a aVar = new a(textView);
        boolean z10 = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int minTextSize = (int) aVar.getMinTextSize();
            float precision = aVar.getPrecision();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutofitTextView, i10, 0);
            z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AutofitTextView_minTextSize, minTextSize);
            float f10 = typedArrayObtainStyledAttributes.getFloat(R.styleable.AutofitTextView_precision, precision);
            typedArrayObtainStyledAttributes.recycle();
            aVar.setMinTextSize(0, dimensionPixelSize).setPrecision(f10);
        }
        aVar.setEnabled(z10);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.grantland.widget.a.a():void");
    }

    public a addOnTextSizeChangeListener(c cVar) {
        if (this.f16289j == null) {
            this.f16289j = new ArrayList<>();
        }
        this.f16289j.add(cVar);
        return this;
    }

    public float getMaxTextSize() {
        return this.f16285f;
    }

    public float getMinTextSize() {
        return this.f16284e;
    }

    public float getPrecision() {
        return this.f16286g;
    }

    public a setEnabled(boolean z10) {
        if (this.f16287h != z10) {
            this.f16287h = z10;
            ViewOnLayoutChangeListenerC0201a viewOnLayoutChangeListenerC0201a = this.f16291l;
            b bVar = this.f16290k;
            TextView textView = this.f16280a;
            if (z10) {
                textView.addTextChangedListener(bVar);
                textView.addOnLayoutChangeListener(viewOnLayoutChangeListenerC0201a);
                a();
            } else {
                textView.removeTextChangedListener(bVar);
                textView.removeOnLayoutChangeListener(viewOnLayoutChangeListenerC0201a);
                textView.setTextSize(0, this.f16282c);
            }
        }
        return this;
    }

    public a setMaxLines(int i10) {
        if (this.f16283d != i10) {
            this.f16283d = i10;
            a();
        }
        return this;
    }

    public a setMaxTextSize(float f10) {
        return setMaxTextSize(2, f10);
    }

    public a setMinTextSize(int i10, float f10) {
        Context context = this.f16280a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float fApplyDimension = TypedValue.applyDimension(i10, f10, system.getDisplayMetrics());
        if (fApplyDimension != this.f16284e) {
            this.f16284e = fApplyDimension;
            a();
        }
        return this;
    }

    public a setPrecision(float f10) {
        if (this.f16286g != f10) {
            this.f16286g = f10;
            a();
        }
        return this;
    }

    public void setTextSize(int i10, float f10) {
        if (this.f16288i) {
            return;
        }
        Context context = this.f16280a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float fApplyDimension = TypedValue.applyDimension(i10, f10, system.getDisplayMetrics());
        if (this.f16282c != fApplyDimension) {
            this.f16282c = fApplyDimension;
        }
    }

    public a setMaxTextSize(int i10, float f10) {
        Context context = this.f16280a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float fApplyDimension = TypedValue.applyDimension(i10, f10, system.getDisplayMetrics());
        if (fApplyDimension != this.f16285f) {
            this.f16285f = fApplyDimension;
            a();
        }
        return this;
    }

    /* compiled from: AutofitHelper.java */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            a.this.a();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
