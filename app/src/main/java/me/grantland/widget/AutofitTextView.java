package me.grantland.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import me.grantland.widget.a;

/* loaded from: classes2.dex */
public class AutofitTextView extends TextView implements a.c {

    /* renamed from: b, reason: collision with root package name */
    public a f16279b;

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16279b = a.create(this, attributeSet, 0).addOnTextSizeChangeListener(this);
    }

    public a getAutofitHelper() {
        return this.f16279b;
    }

    public float getMaxTextSize() {
        return this.f16279b.getMaxTextSize();
    }

    public float getMinTextSize() {
        return this.f16279b.getMinTextSize();
    }

    public float getPrecision() {
        return this.f16279b.getPrecision();
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        super.setLines(i10);
        a aVar = this.f16279b;
        if (aVar != null) {
            aVar.setMaxLines(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        super.setMaxLines(i10);
        a aVar = this.f16279b;
        if (aVar != null) {
            aVar.setMaxLines(i10);
        }
    }

    public void setMaxTextSize(float f10) {
        this.f16279b.setMaxTextSize(f10);
    }

    public void setMinTextSize(int i10) {
        this.f16279b.setMinTextSize(2, i10);
    }

    public void setPrecision(float f10) {
        this.f16279b.setPrecision(f10);
    }

    public void setSizeToFit(boolean z10) {
        this.f16279b.setEnabled(z10);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        a aVar = this.f16279b;
        if (aVar != null) {
            aVar.setTextSize(i10, f10);
        }
    }

    @Override // me.grantland.widget.a.c
    public void onTextSizeChange(float f10, float f11) {
    }
}
