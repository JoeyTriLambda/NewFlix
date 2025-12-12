package ie;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final ByteOrder f13418b = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13419a;

    public j() {
        this.f13419a = new HashMap();
    }

    public static j a() {
        return new j();
    }

    public int b() {
        Iterator it = this.f13419a.entrySet().iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) ((Map.Entry) it.next()).getValue()).length + 8;
        }
        return length;
    }

    public byte[] c() {
        int iB = b();
        if (iB == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[iB];
        int length = 0;
        for (Map.Entry entry : this.f13419a.entrySet()) {
            Integer num = (Integer) entry.getKey();
            byte[] bArr2 = (byte[]) entry.getValue();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            ByteOrder byteOrder = f13418b;
            byte[] bArrArray = byteBufferAllocate.order(byteOrder).putInt(num.intValue()).array();
            byte[] bArrArray2 = ByteBuffer.allocate(4).order(byteOrder).putInt(bArr2.length + 8).array();
            System.arraycopy(bArrArray, 0, bArr, length, bArrArray.length);
            int i10 = length + 4;
            System.arraycopy(bArrArray2, 0, bArr, i10, bArrArray2.length);
            int i11 = i10 + 4;
            System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
            length = i11 + bArr2.length;
        }
        return bArr;
    }

    public Integer d(int i10) {
        byte[] bArrC = c(i10);
        if (bArrC == null) {
            return null;
        }
        return Integer.valueOf(ByteBuffer.wrap(bArrC).order(f13418b).getInt());
    }

    public Long e(int i10) {
        byte[] bArrC = c(i10);
        if (bArrC == null) {
            return null;
        }
        return Long.valueOf(ByteBuffer.wrap(bArrC).order(f13418b).getLong());
    }

    public j f(int i10) {
        byte[] bArrC = c(i10);
        if (bArrC == null) {
            return null;
        }
        return new j(bArrC, 0, bArrC.length);
    }

    public String g(int i10) {
        byte[] bArrC = c(i10);
        if (bArrC == null) {
            return null;
        }
        return new String(bArrC, StandardCharsets.UTF_8);
    }

    public j(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public j a(int i10, byte b10) {
        return a(i10, new byte[]{b10});
    }

    public Byte b(int i10) {
        byte[] bArrC = c(i10);
        if (bArrC == null) {
            return null;
        }
        return Byte.valueOf(bArrC[0]);
    }

    public byte[] c(int i10) {
        return (byte[]) this.f13419a.get(Integer.valueOf(i10));
    }

    public j(byte[] bArr, int i10, int i11) {
        this.f13419a = new HashMap();
        if (bArr == null) {
            return;
        }
        int i12 = 0;
        while (i12 < i11) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10 + i12, 4);
            ByteOrder byteOrder = f13418b;
            int i13 = byteBufferWrap.order(byteOrder).getInt();
            int i14 = i12 + 4;
            int i15 = ByteBuffer.wrap(bArr, i10 + i14, 4).order(byteOrder).getInt();
            int i16 = i14 + 4;
            int i17 = i15 - 8;
            if (i17 > 100000) {
                je.a.b("TlvBox", "Error Trying to Allocate size: %d on type: %d", Integer.valueOf(i15), Integer.valueOf(i13));
            }
            byte[] bArr2 = new byte[i17];
            System.arraycopy(bArr, i10 + i16, bArr2, 0, i17);
            a(i13, bArr2);
            i12 = i16 + i17;
        }
    }

    public j a(int i10, int i11) {
        return a(i10, ByteBuffer.allocate(4).order(f13418b).putInt(i11).array());
    }

    public j a(int i10, long j10) {
        return a(i10, ByteBuffer.allocate(8).order(f13418b).putLong(j10).array());
    }

    public j a(int i10, j jVar) {
        return jVar == null ? this : a(i10, jVar.c());
    }

    public j a(int i10, String str) {
        return str == null ? this : a(i10, str.getBytes(StandardCharsets.UTF_8));
    }

    public j a(int i10, byte[] bArr) {
        if (bArr == null) {
            return this;
        }
        this.f13419a.put(Integer.valueOf(i10), bArr);
        return this;
    }

    public boolean a(int i10) {
        return this.f13419a.containsKey(Integer.valueOf(i10));
    }
}
