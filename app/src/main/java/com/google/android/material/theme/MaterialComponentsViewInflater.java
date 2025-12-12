package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.u;
import com.google.android.material.button.MaterialButton;
import r.v;
import v7.p;
import y6.a;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends v {
    @Override // r.v
    public d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    @Override // r.v
    public f createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // r.v
    public g createCheckBox(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // r.v
    public u createRadioButton(Context context, AttributeSet attributeSet) {
        return new m7.a(context, attributeSet);
    }

    @Override // r.v
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new w7.a(context, attributeSet);
    }
}
