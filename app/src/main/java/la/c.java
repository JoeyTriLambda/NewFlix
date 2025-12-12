package la;

/* compiled from: FloatEvaluator.java */
/* loaded from: classes.dex */
public final class c implements j<Number> {
    @Override // la.j
    public Float evaluate(float f10, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(((number2.floatValue() - fFloatValue) * f10) + fFloatValue);
    }
}
