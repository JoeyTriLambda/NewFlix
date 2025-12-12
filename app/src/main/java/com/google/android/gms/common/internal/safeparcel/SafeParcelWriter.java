package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int a(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void b(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static void c(Parcel parcel, Parcelable parcelable, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static void finishObjectHeader(Parcel parcel, int i10) {
        b(parcel, i10);
    }

    public static void writeBoolean(Parcel parcel, int i10, boolean z10) {
        parcel.writeInt(i10 | 262144);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void writeBooleanObject(Parcel parcel, int i10, Boolean bool, boolean z10) {
        if (bool != null) {
            parcel.writeInt(i10 | 262144);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            parcel.writeInt(i10 | 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i10, Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeBundle(bundle);
            b(parcel, iA);
        }
    }

    public static void writeByteArray(Parcel parcel, int i10, byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeByteArray(bArr);
            b(parcel, iA);
        }
    }

    public static void writeDouble(Parcel parcel, int i10, double d10) {
        parcel.writeInt(i10 | 524288);
        parcel.writeDouble(d10);
    }

    public static void writeDoubleObject(Parcel parcel, int i10, Double d10, boolean z10) {
        if (d10 != null) {
            parcel.writeInt(i10 | 524288);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            parcel.writeInt(i10 | 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i10, float f10) {
        parcel.writeInt(i10 | 262144);
        parcel.writeFloat(f10);
    }

    public static void writeFloatObject(Parcel parcel, int i10, Float f10, boolean z10) {
        if (f10 != null) {
            parcel.writeInt(i10 | 262144);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            parcel.writeInt(i10 | 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i10, IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            b(parcel, iA);
        }
    }

    public static void writeInt(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | 262144);
        parcel.writeInt(i11);
    }

    public static void writeIntArray(Parcel parcel, int i10, int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeIntArray(iArr);
            b(parcel, iA);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i10, Integer num, boolean z10) {
        if (num != null) {
            parcel.writeInt(i10 | 262144);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            parcel.writeInt(i10 | 0);
        }
    }

    public static void writeLong(Parcel parcel, int i10, long j10) {
        parcel.writeInt(i10 | 524288);
        parcel.writeLong(j10);
    }

    public static void writeLongArray(Parcel parcel, int i10, long[] jArr, boolean z10) {
        if (jArr == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeLongArray(jArr);
            b(parcel, iA);
        }
    }

    public static void writeLongObject(Parcel parcel, int i10, Long l10, boolean z10) {
        if (l10 != null) {
            parcel.writeInt(i10 | 524288);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            parcel.writeInt(i10 | 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i10, Parcel parcel2, boolean z10) {
        if (parcel2 == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            b(parcel, iA);
        }
    }

    public static void writeParcelable(Parcel parcel, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            b(parcel, iA);
        }
    }

    public static void writeString(Parcel parcel, int i10, String str, boolean z10) {
        if (str == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeString(str);
            b(parcel, iA);
        }
    }

    public static void writeStringArray(Parcel parcel, int i10, String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeStringArray(strArr);
            b(parcel, iA);
        }
    }

    public static void writeStringList(Parcel parcel, int i10, List<String> list, boolean z10) {
        if (list == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
            }
        } else {
            int iA = a(parcel, i10);
            parcel.writeStringList(list);
            b(parcel, iA);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i10, T[] tArr, int i11, boolean z10) {
        if (tArr == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i10);
        parcel.writeInt(tArr.length);
        for (T t10 : tArr) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                c(parcel, t10, i11);
            }
        }
        b(parcel, iA);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i10, List<T> list, boolean z10) {
        if (list == null) {
            if (z10) {
                parcel.writeInt(i10 | 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                c(parcel, t10, 0);
            }
        }
        b(parcel, iA);
    }
}
