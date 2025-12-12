package com.tuyenmonkey.mkloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import va.a;
import xa.d;

/* loaded from: classes2.dex */
public class MKLoader extends View implements a {

    /* renamed from: b, reason: collision with root package name */
    public d f10652b;

    public MKLoader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MKLoader);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.MKLoader_mk_type);
        d dVarGenerateLoaderView = ya.a.generateLoaderView(string == null ? "ClassicSpinner" : string);
        this.f10652b = dVarGenerateLoaderView;
        dVarGenerateLoaderView.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.MKLoader_mk_color, Color.parseColor("#ffffff")));
        this.f10652b.setInvalidateListener(this);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f10652b.draw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f10652b.setSize(getWidth(), getHeight());
        this.f10652b.initializeObjects();
        this.f10652b.setUpAnimation();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize(this.f10652b.getDesiredWidth(), i10), View.resolveSize(this.f10652b.getDesiredHeight(), i11));
    }

    @Override // va.a
    public void reDraw() {
        invalidate();
    }
}
