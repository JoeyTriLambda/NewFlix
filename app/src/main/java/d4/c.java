package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f10814e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10815a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10816b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    public int f10817c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f10818d;

    /* compiled from: ByteArrayPool.java */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i10) {
        this.f10818d = i10;
    }

    public final synchronized void a() {
        while (this.f10817c > this.f10818d) {
            byte[] bArr = (byte[]) this.f10815a.remove(0);
            this.f10816b.remove(bArr);
            this.f10817c -= bArr.length;
        }
    }

    public synchronized byte[] getBuf(int i10) {
        for (int i11 = 0; i11 < this.f10816b.size(); i11++) {
            byte[] bArr = (byte[]) this.f10816b.get(i11);
            if (bArr.length >= i10) {
                this.f10817c -= bArr.length;
                this.f10816b.remove(i11);
                this.f10815a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f10818d) {
                this.f10815a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f10816b, bArr, f10814e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f10816b.add(iBinarySearch, bArr);
                this.f10817c += bArr.length;
                a();
            }
        }
    }
}
