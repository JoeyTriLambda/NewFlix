package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Internal.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2545a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2546b;

    /* compiled from: Internal.java */
    public interface a extends h<Boolean> {
    }

    /* compiled from: Internal.java */
    public interface b extends h<Double> {
    }

    /* compiled from: Internal.java */
    public interface c {
        int getNumber();
    }

    /* compiled from: Internal.java */
    public interface d {
        boolean isInRange(int i10);
    }

    /* compiled from: Internal.java */
    public interface e extends h<Float> {
    }

    /* compiled from: Internal.java */
    public interface f extends h<Integer> {
    }

    /* compiled from: Internal.java */
    public interface g extends h<Long> {
    }

    /* compiled from: Internal.java */
    public interface h<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        h<E> mutableCopyWithCapacity(int i10);
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2546b = bArr;
        ByteBuffer.wrap(bArr);
        androidx.datastore.preferences.protobuf.h.newInstance(bArr);
    }

    public static k0 a(Object obj, Object obj2) {
        return ((GeneratedMessageLite.a) ((a.AbstractC0023a) ((k0) obj).toBuilder()).m7mergeFrom((k0) obj2)).m5buildPartial();
    }

    public static int hashBoolean(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int i10 = length;
        for (int i11 = 0; i11 < 0 + length; i11++) {
            i10 = (i10 * 31) + bArr[i11];
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public static int hashLong(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, f2545a);
    }
}
