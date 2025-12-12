package k7;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.google.android.material.R;
import cz.msebera.android.httpclient.HttpStatus;

/* compiled from: MaterialBackAnimationHelper.java */
/* loaded from: classes.dex */
public abstract class a<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f15012a;

    /* renamed from: b, reason: collision with root package name */
    public final V f15013b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15014c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15015d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15016e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.activity.b f15017f;

    public a(V v10) {
        this.f15013b = v10;
        Context context = v10.getContext();
        this.f15012a = g.resolveThemeInterpolator(context, R.attr.motionEasingStandardDecelerateInterpolator, z0.a.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.f15014c = g.resolveThemeDuration(context, R.attr.motionDurationMedium2, HttpStatus.SC_MULTIPLE_CHOICES);
        this.f15015d = g.resolveThemeDuration(context, R.attr.motionDurationShort3, 150);
        this.f15016e = g.resolveThemeDuration(context, R.attr.motionDurationShort2, 100);
    }

    public float interpolateProgress(float f10) {
        return this.f15012a.getInterpolation(f10);
    }

    public androidx.activity.b onCancelBackProgress() {
        if (this.f15017f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f15017f;
        this.f15017f = null;
        return bVar;
    }

    public androidx.activity.b onHandleBackInvoked() {
        androidx.activity.b bVar = this.f15017f;
        this.f15017f = null;
        return bVar;
    }

    public void onStartBackProgress(androidx.activity.b bVar) {
        this.f15017f = bVar;
    }

    public androidx.activity.b onUpdateBackProgress(androidx.activity.b bVar) {
        if (this.f15017f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = this.f15017f;
        this.f15017f = bVar;
        return bVar2;
    }
}
