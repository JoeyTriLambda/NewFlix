package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* compiled from: TimePickerView.java */
/* loaded from: classes.dex */
public final class h implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f9509b;

    public h(GestureDetector gestureDetector) {
        this.f9509b = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f9509b.onTouchEvent(motionEvent);
        }
        return false;
    }
}
