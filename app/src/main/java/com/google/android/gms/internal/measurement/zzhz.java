package com.google.android.gms.internal.measurement;

import ac.c;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o1.a;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzhz<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zzhy<MessageType, BuilderType>> implements zzlg {
    protected int zza = 0;

    public int zza(zzly zzlyVar) {
        int iZzbt = zzbt();
        if (iZzbt != -1) {
            return iZzbt;
        }
        int iZza = zzlyVar.zza(this);
        zzc(iZza);
        return iZza;
    }

    public int zzbt() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzij zzbu() {
        try {
            zzio zzioVarZzc = zzij.zzc(zzbw());
            zza(zzioVarZzc.zzb());
            return zzioVarZzc.zza();
        } catch (IOException e10) {
            throw new RuntimeException(c.k("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e10);
        }
    }

    public final byte[] zzbv() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzja zzjaVarZzb = zzja.zzb(bArr);
            zza(zzjaVarZzb);
            zzjaVarZzb.zzb();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(c.k("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e10);
        }
    }

    public void zzc(int i10) {
        throw new UnsupportedOperationException();
    }

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjw.zza(iterable);
        if (iterable instanceof zzkm) {
            List<?> listZze = ((zzkm) iterable).zze();
            zzkm zzkmVar = (zzkm) list;
            int size = list.size();
            for (Object obj : listZze) {
                if (obj == null) {
                    String strD = a.d("Element at index ", zzkmVar.size() - size, " is null.");
                    int size2 = zzkmVar.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzkmVar.remove(size2);
                        } else {
                            throw new NullPointerException(strD);
                        }
                    }
                } else if (obj instanceof zzij) {
                    zzkmVar.zza((zzij) obj);
                } else {
                    zzkmVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzls) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size3 = list.size();
        for (T t10 : iterable) {
            if (t10 == null) {
                String strD2 = a.d("Element at index ", list.size() - size3, " is null.");
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 >= size3) {
                        list.remove(size4);
                    } else {
                        throw new NullPointerException(strD2);
                    }
                }
            } else {
                list.add(t10);
            }
        }
    }
}
