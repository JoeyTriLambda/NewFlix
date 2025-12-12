package h7;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public final class b implements TypeEvaluator<Float> {

    /* renamed from: a, reason: collision with root package name */
    public final FloatEvaluator f12953a = new FloatEvaluator();

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f10, Float f11, Float f12) {
        float fFloatValue = this.f12953a.evaluate(f10, (Number) f11, (Number) f12).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
