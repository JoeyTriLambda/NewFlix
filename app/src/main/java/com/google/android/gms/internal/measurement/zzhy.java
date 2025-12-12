package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzhy<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zzhy<MessageType, BuilderType>> implements zzlf {
    @Override // 
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzb(zziu zziuVar, zzjg zzjgVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i10, int i11) throws zzkb {
        try {
            zziu zziuVarZza = zziu.zza(bArr, 0, i11, false);
            zzb(zziuVarZza, zzjg.zza);
            zziuVarZza.zzc(0);
            return this;
        } catch (zzkb e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException(zza("byte array"), e11);
        }
    }

    @Override // 
    /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i10, int i11, zzjg zzjgVar) throws zzkb {
        try {
            zziu zziuVarZza = zziu.zza(bArr, 0, i11, false);
            zzb(zziuVarZza, zzjgVar);
            zziuVarZza.zzc(0);
            return this;
        } catch (zzkb e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException(zza("byte array"), e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final /* synthetic */ zzlf zza(byte[] bArr) throws zzkb {
        return zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final /* synthetic */ zzlf zza(byte[] bArr, zzjg zzjgVar) throws zzkb {
        return zza(bArr, 0, bArr.length, zzjgVar);
    }

    private final String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }
}
