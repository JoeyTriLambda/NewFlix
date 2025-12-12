package dg;

import kotlin.random.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public abstract class a extends Random {
    public abstract java.util.Random getImpl();

    @Override // kotlin.random.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10) {
        return getImpl().nextInt(i10);
    }
}
