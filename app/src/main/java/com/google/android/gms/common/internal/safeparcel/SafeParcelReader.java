package com.google.android.gms.common.internal.safeparcel;

import ac.c;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static void a(Parcel parcel, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        throw new ParseException(c.o(c.t("Expected size ", i11, " got ", i10, " (0x"), Integer.toHexString(i10), ")"), parcel);
    }

    public static void b(Parcel parcel, int i10, int i11) {
        int size = readSize(parcel, i10);
        if (size == i11) {
            return;
        }
        throw new ParseException(c.o(c.t("Expected size ", i11, " got ", size, " (0x"), Integer.toHexString(size), ")"), parcel);
    }

    public static BigDecimal createBigDecimal(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i11 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + size);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i11);
    }

    public static BigDecimal[] createBigDecimalArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + size);
        return bigDecimalArr;
    }

    public static BigInteger createBigInteger(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + size);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] createBigIntegerArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + size);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + size);
        return zArrCreateBooleanArray;
    }

    public static Bundle createBundle(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + size);
        return bundle;
    }

    public static byte[] createByteArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + size);
        return bArrCreateByteArray;
    }

    public static double[] createDoubleArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + size);
        return dArrCreateDoubleArray;
    }

    public static float[] createFloatArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + size);
        return fArrCreateFloatArray;
    }

    public static int[] createIntArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + size);
        return iArrCreateIntArray;
    }

    public static long[] createLongArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + size);
        return jArrCreateLongArray;
    }

    public static Parcel createParcel(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, size);
        parcel.setDataPosition(iDataPosition + size);
        return parcelObtain;
    }

    public static Parcel[] createParcelArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = parcel.readInt();
            if (i13 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i13);
                parcelArr[i12] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i13);
            } else {
                parcelArr[i12] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + size);
        return parcelArr;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + size);
        return tCreateFromParcel;
    }

    public static String createString(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + size);
        return string;
    }

    public static String[] createStringArray(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + size);
        return strArrCreateStringArray;
    }

    public static ArrayList<String> createStringList(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + size);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + size);
        return tArr;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + size);
        return arrayListCreateTypedArrayList;
    }

    public static void ensureAtEnd(Parcel parcel, int i10) {
        if (parcel.dataPosition() != i10) {
            throw new ParseException(c.f("Overread allowed size end=", i10), parcel);
        }
    }

    public static int getFieldId(int i10) {
        return (char) i10;
    }

    public static boolean readBoolean(Parcel parcel, int i10) {
        b(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean readBooleanObject(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        if (size == 0) {
            return null;
        }
        a(parcel, size, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double readDouble(Parcel parcel, int i10) {
        b(parcel, i10, 8);
        return parcel.readDouble();
    }

    public static Double readDoubleObject(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        if (size == 0) {
            return null;
        }
        a(parcel, size, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(Parcel parcel, int i10) {
        b(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        if (size == 0) {
            return null;
        }
        a(parcel, size, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder readIBinder(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + size);
        return strongBinder;
    }

    public static int readInt(Parcel parcel, int i10) {
        b(parcel, i10, 4);
        return parcel.readInt();
    }

    public static Integer readIntegerObject(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        if (size == 0) {
            return null;
        }
        a(parcel, size, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long readLong(Parcel parcel, int i10) {
        b(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long readLongObject(Parcel parcel, int i10) {
        int size = readSize(parcel, i10);
        if (size == 0) {
            return null;
        }
        a(parcel, size, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int readSize(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i10));
    }

    public static int validateObjectHeader(Parcel parcel) {
        int header = readHeader(parcel);
        int size = readSize(parcel, header);
        int fieldId = getFieldId(header);
        int iDataPosition = parcel.dataPosition();
        if (fieldId != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(header))), parcel);
        }
        int i10 = size + iDataPosition;
        if (i10 < iDataPosition || i10 > parcel.dataSize()) {
            throw new ParseException(c.g("Size read is invalid start=", iDataPosition, " end=", i10), parcel);
        }
        return i10;
    }
}
