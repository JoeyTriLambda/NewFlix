package fg;

import java.util.NoSuchElementException;
import mf.t;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class b extends t {

    /* renamed from: b, reason: collision with root package name */
    public final int f11548b;

    /* renamed from: m, reason: collision with root package name */
    public final int f11549m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11550n;

    /* renamed from: o, reason: collision with root package name */
    public int f11551o;

    public b(int i10, int i11, int i12) {
        this.f11548b = i12;
        this.f11549m = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f11550n = z10;
        this.f11551o = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11550n;
    }

    @Override // mf.t
    public int nextInt() {
        int i10 = this.f11551o;
        if (i10 != this.f11549m) {
            this.f11551o = this.f11548b + i10;
        } else {
            if (!this.f11550n) {
                throw new NoSuchElementException();
            }
            this.f11550n = false;
        }
        return i10;
    }
}
