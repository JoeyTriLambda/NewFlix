package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: TimePickerView.java */
/* loaded from: classes.dex */
public final class g extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimePickerView f9508b;

    public g(TimePickerView timePickerView) {
        this.f9508b = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        int i10 = TimePickerView.E;
        this.f9508b.getClass();
        return false;
    }
}
