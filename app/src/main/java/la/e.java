package la;

/* compiled from: IntEvaluator.java */
/* loaded from: classes.dex */
public final class e implements j<Integer> {
    @Override // la.j
    public Integer evaluate(float f10, Integer num, Integer num2) {
        return Integer.valueOf((int) ((f10 * (num2.intValue() - r3)) + num.intValue()));
    }
}
