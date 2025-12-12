package ah;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Arrays;

/* compiled from: Segment.kt */
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f723a;

    /* renamed from: b, reason: collision with root package name */
    public int f724b;

    /* renamed from: c, reason: collision with root package name */
    public int f725c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f726d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f727e;

    /* renamed from: f, reason: collision with root package name */
    public u f728f;

    /* renamed from: g, reason: collision with root package name */
    public u f729g;

    /* compiled from: Segment.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public u() {
        this.f723a = new byte[8192];
        this.f727e = true;
        this.f726d = false;
    }

    public final void compact() {
        u uVar = this.f729g;
        int i10 = 0;
        if (!(uVar != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        zf.i.checkNotNull(uVar);
        if (uVar.f727e) {
            int i11 = this.f725c - this.f724b;
            u uVar2 = this.f729g;
            zf.i.checkNotNull(uVar2);
            int i12 = 8192 - uVar2.f725c;
            u uVar3 = this.f729g;
            zf.i.checkNotNull(uVar3);
            if (!uVar3.f726d) {
                u uVar4 = this.f729g;
                zf.i.checkNotNull(uVar4);
                i10 = uVar4.f724b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            u uVar5 = this.f729g;
            zf.i.checkNotNull(uVar5);
            writeTo(uVar5, i11);
            pop();
            v.recycle(this);
        }
    }

    public final u pop() {
        u uVar = this.f728f;
        if (uVar == this) {
            uVar = null;
        }
        u uVar2 = this.f729g;
        zf.i.checkNotNull(uVar2);
        uVar2.f728f = this.f728f;
        u uVar3 = this.f728f;
        zf.i.checkNotNull(uVar3);
        uVar3.f729g = this.f729g;
        this.f728f = null;
        this.f729g = null;
        return uVar;
    }

    public final u push(u uVar) {
        zf.i.checkNotNullParameter(uVar, "segment");
        uVar.f729g = this;
        uVar.f728f = this.f728f;
        u uVar2 = this.f728f;
        zf.i.checkNotNull(uVar2);
        uVar2.f729g = uVar;
        this.f728f = uVar;
        return uVar;
    }

    public final u sharedCopy() {
        this.f726d = true;
        return new u(this.f723a, this.f724b, this.f725c, true, false);
    }

    public final u split(int i10) {
        u uVarTake;
        if (!(i10 > 0 && i10 <= this.f725c - this.f724b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i10 >= 1024) {
            uVarTake = sharedCopy();
        } else {
            uVarTake = v.take();
            byte[] bArr = this.f723a;
            byte[] bArr2 = uVarTake.f723a;
            int i11 = this.f724b;
            mf.h.copyInto$default(bArr, bArr2, 0, i11, i11 + i10, 2, (Object) null);
        }
        uVarTake.f725c = uVarTake.f724b + i10;
        this.f724b += i10;
        u uVar = this.f729g;
        zf.i.checkNotNull(uVar);
        uVar.push(uVarTake);
        return uVarTake;
    }

    public final u unsharedCopy() {
        byte[] bArr = this.f723a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        zf.i.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new u(bArrCopyOf, this.f724b, this.f725c, false, true);
    }

    public final void writeTo(u uVar, int i10) {
        zf.i.checkNotNullParameter(uVar, "sink");
        if (!uVar.f727e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i11 = uVar.f725c;
        if (i11 + i10 > 8192) {
            if (uVar.f726d) {
                throw new IllegalArgumentException();
            }
            int i12 = uVar.f724b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = uVar.f723a;
            mf.h.copyInto$default(bArr, bArr, 0, i12, i11, 2, (Object) null);
            uVar.f725c -= uVar.f724b;
            uVar.f724b = 0;
        }
        int i13 = uVar.f725c;
        int i14 = this.f724b;
        mf.h.copyInto(this.f723a, uVar.f723a, i13, i14, i14 + i10);
        uVar.f725c += i10;
        this.f724b += i10;
    }

    public u(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        zf.i.checkNotNullParameter(bArr, JsonStorageKeyNames.DATA_KEY);
        this.f723a = bArr;
        this.f724b = i10;
        this.f725c = i11;
        this.f726d = z10;
        this.f727e = z11;
    }
}
