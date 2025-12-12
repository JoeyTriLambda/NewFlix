package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zza extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzh f6420b;

    public zza(zzh zzhVar) {
        this.f6420b = zzhVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        zzh zzhVar = this.f6420b;
        if (zzhVar.f6440v == null) {
            return true;
        }
        if (zzhVar.f6432n.contains(Math.round(x10), Math.round(y10)) && zzhVar.f6433o.zzg(x10, y10)) {
            return true;
        }
        zzhVar.f6440v.zza();
        return true;
    }
}
