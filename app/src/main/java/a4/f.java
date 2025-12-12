package a4;

/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f322a;

    public void add(float f10) {
        int i10 = this.f322a + 1;
        this.f322a = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f322a = i10 / 2;
        }
    }
}
