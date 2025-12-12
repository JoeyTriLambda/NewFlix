package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public int f1526a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1527b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1528c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f1529d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f1530e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1531f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1532g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1533h = false;

    public int getEnd() {
        return this.f1532g ? this.f1526a : this.f1527b;
    }

    public int getLeft() {
        return this.f1526a;
    }

    public int getRight() {
        return this.f1527b;
    }

    public int getStart() {
        return this.f1532g ? this.f1527b : this.f1526a;
    }

    public void setAbsolute(int i10, int i11) {
        this.f1533h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1530e = i10;
            this.f1526a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1531f = i11;
            this.f1527b = i11;
        }
    }

    public void setDirection(boolean z10) {
        if (z10 == this.f1532g) {
            return;
        }
        this.f1532g = z10;
        if (!this.f1533h) {
            this.f1526a = this.f1530e;
            this.f1527b = this.f1531f;
            return;
        }
        if (z10) {
            int i10 = this.f1529d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f1530e;
            }
            this.f1526a = i10;
            int i11 = this.f1528c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f1531f;
            }
            this.f1527b = i11;
            return;
        }
        int i12 = this.f1528c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f1530e;
        }
        this.f1526a = i12;
        int i13 = this.f1529d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f1531f;
        }
        this.f1527b = i13;
    }

    public void setRelative(int i10, int i11) {
        this.f1528c = i10;
        this.f1529d = i11;
        this.f1533h = true;
        if (this.f1532g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1526a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1527b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1526a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1527b = i11;
        }
    }
}
