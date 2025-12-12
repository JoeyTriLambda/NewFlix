package kotlin.random;

import java.io.Serializable;
import tf.b;
import zf.f;

/* compiled from: Random.kt */
/* loaded from: classes2.dex */
public abstract class Random {

    /* renamed from: b, reason: collision with root package name */
    public static final Default f15263b = new Default(null);

    /* renamed from: m, reason: collision with root package name */
    public static final Random f15264m = b.f19915a.defaultPlatformRandom();

    /* compiled from: Random.kt */
    public static final class Default extends Random implements Serializable {
        public /* synthetic */ Default(f fVar) {
            this();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.f15264m.nextInt();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10) {
            return Random.f15264m.nextInt(i10);
        }
    }

    public abstract int nextInt();

    public abstract int nextInt(int i10);
}
