package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.c1;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f9342b;

    /* renamed from: m, reason: collision with root package name */
    public final Drawable f9343m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9344n;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, R.styleable.TabItem);
        this.f9342b = c1VarObtainStyledAttributes.getText(R.styleable.TabItem_android_text);
        this.f9343m = c1VarObtainStyledAttributes.getDrawable(R.styleable.TabItem_android_icon);
        this.f9344n = c1VarObtainStyledAttributes.getResourceId(R.styleable.TabItem_android_layout, 0);
        c1VarObtainStyledAttributes.recycle();
    }
}
