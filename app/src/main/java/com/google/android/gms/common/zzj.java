package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
abstract class zzj extends com.google.android.gms.common.internal.zzz {

    /* renamed from: a, reason: collision with root package name */
    public final int f7527a;

    public zzj(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.f7527a = Arrays.hashCode(bArr);
    }

    public static byte[] zze(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract byte[] b();

    public final boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperZzd;
        if (obj != null && (obj instanceof com.google.android.gms.common.internal.zzaa)) {
            try {
                com.google.android.gms.common.internal.zzaa zzaaVar = (com.google.android.gms.common.internal.zzaa) obj;
                if (zzaaVar.zzc() == this.f7527a && (iObjectWrapperZzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(b(), (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7527a;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.f7527a;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(b());
    }
}
