package p6;

import android.animation.TypeEvaluator;

/* compiled from: ArgbEvaluatorCompat.java */
/* loaded from: classes.dex */
public final class c implements TypeEvaluator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f17609a = new c();

    public static c getInstance() {
        return f17609a;
    }

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f10, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f11 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = num2.intValue();
        float f12 = ((iIntValue2 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d);
        float fA = o1.a.a(f12, f11, f10, f11);
        float fA2 = o1.a.a(fPow4, fPow, f10, fPow);
        float fA3 = o1.a.a(fPow5, fPow2, f10, fPow2);
        float fA4 = o1.a.a(fPow6, fPow3, f10, fPow3);
        float fPow7 = ((float) Math.pow(fA2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fA3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fA4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fA * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
