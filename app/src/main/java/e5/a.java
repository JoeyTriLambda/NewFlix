package e5;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public int f11132b;

    public final void addFlag(int i10) {
        this.f11132b = i10 | this.f11132b;
    }

    public void clear() {
        this.f11132b = 0;
    }

    public final void clearFlag(int i10) {
        this.f11132b = (~i10) & this.f11132b;
    }

    public final boolean getFlag(int i10) {
        return (this.f11132b & i10) == i10;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i10) {
        this.f11132b = i10;
    }
}
