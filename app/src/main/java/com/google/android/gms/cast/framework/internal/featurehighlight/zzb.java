package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzb extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f6421b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzg f6422m;

    public zzb(View view, zzg zzgVar) {
        this.f6421b = view;
        this.f6422m = zzgVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        View view = this.f6421b;
        if (view.getParent() != null) {
            view.performClick();
        }
        this.f6422m.zzb();
        return true;
    }
}
