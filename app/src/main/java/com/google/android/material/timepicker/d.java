package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q7.j;
import x0.j0;

/* compiled from: RadialViewGroup.java */
/* loaded from: classes.dex */
public class d extends ConstraintLayout {
    public final c D;
    public int E;
    public q7.g F;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(j0.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            c cVar = this.D;
            handler.removeCallbacks(cVar);
            handler.post(cVar);
        }
    }

    public int getRadius() {
        return this.E;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            c cVar = this.D;
            handler.removeCallbacks(cVar);
            handler.post(cVar);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.F.setFillColor(ColorStateList.valueOf(i10));
    }

    public void setRadius(int i10) {
        this.E = i10;
        updateLayoutParams();
    }

    public void updateLayoutParams() {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.clone(this);
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i11 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!map.containsKey(i11)) {
                    map.put(i11, new ArrayList());
                }
                ((List) map.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.E * 0.66f) : this.E;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                dVar.constrainCircle(((View) it.next()).getId(), R.id.circle_center, iRound, size);
                size += 360.0f / list.size();
            }
        }
        dVar.applyTo(this);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.material.timepicker.c] */
    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        q7.g gVar = new q7.g();
        this.F = gVar;
        gVar.setCornerSize(new j(0.5f));
        this.F.setFillColor(ColorStateList.valueOf(-1));
        j0.setBackground(this, this.F);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i10, 0);
        this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.D = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f9502b.updateLayoutParams();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
