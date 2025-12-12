package c5;

/* compiled from: PlaybackParameters.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    public static final m f5142d = new m(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f5143a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5145c;

    public m(float f10, float f11) {
        this.f5143a = f10;
        this.f5144b = f11;
        this.f5145c = Math.round(f10 * 1000.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f5143a == mVar.f5143a && this.f5144b == mVar.f5144b;
    }

    public long getSpeedAdjustedDurationUs(long j10) {
        return j10 * this.f5145c;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.f5144b) + ((Float.floatToRawIntBits(this.f5143a) + 527) * 31);
    }
}
