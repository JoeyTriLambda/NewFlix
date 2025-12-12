package com.google.android.gms.internal.cast;

import ac.c;
import com.google.android.gms.internal.cast.zztm;
import com.google.android.gms.internal.cast.zztp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zztp<MessageType extends zztp<MessageType, BuilderType>, BuilderType extends zztm<MessageType, BuilderType>> extends zzsh<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzwa zzc = zzwa.zzc();

    public static zztx zzA() {
        return zzvg.zzd();
    }

    public static zztx zzB(zztx zztxVar) {
        int size = zztxVar.size();
        return zztxVar.zzg(size == 0 ? 10 : size + size);
    }

    public static Object zzD(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzE(zzux zzuxVar, String str, Object[] objArr) {
        return new zzvh(zzuxVar, str, objArr);
    }

    public static void zzH(Class cls, zztp zztpVar) {
        zztpVar.zzG();
        zzb.put(cls, zztpVar);
    }

    private final int zza(zzvi zzviVar) {
        return zzvf.zza().zzb(getClass()).zza(this);
    }

    public static zztp zzw(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zztp zztpVar = (zztp) map.get(cls);
        if (zztpVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zztpVar = (zztp) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zztpVar == null) {
            zztpVar = (zztp) ((zztp) zzwj.zze(cls)).zzb(6, null, null);
            if (zztpVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zztpVar);
        }
        return zztpVar;
    }

    public static zztu zzy() {
        return zztq.zze();
    }

    public static zztw zzz() {
        return zzum.zze();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzvf.zza().zzb(getClass()).zzg(this, (zztp) obj);
    }

    public final int hashCode() {
        if (zzK()) {
            return zzs();
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int iZzs = zzs();
        this.zza = iZzs;
        return iZzs;
    }

    public final String toString() {
        return zzuz.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.cast.zzux
    public final /* synthetic */ zzuw zzC() {
        return (zztm) zzb(5, null, null);
    }

    public final void zzF() {
        zzvf.zza().zzb(getClass()).zzd(this);
        zzG();
    }

    public final void zzG() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzI(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.cast.zzux
    public final void zzJ(zztc zztcVar) throws IOException {
        zzvf.zza().zzb(getClass()).zzf(this, zztd.zza(zztcVar));
    }

    public final boolean zzK() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzb(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.cast.zzsh
    public final int zzq(zzvi zzviVar) {
        if (zzK()) {
            int iZza = zzviVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(c.f("serialized size must be non-negative, was ", iZza));
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iZza2 = zzviVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(c.f("serialized size must be non-negative, was ", iZza2));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzs() {
        return zzvf.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.cast.zzuy
    public final /* synthetic */ zzux zzt() {
        return (zztp) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.cast.zzux
    public final int zzu() {
        int iZza;
        if (zzK()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException(c.f("serialized size must be non-negative, was ", iZza));
            }
        } else {
            iZza = this.zzd & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException(c.f("serialized size must be non-negative, was ", iZza));
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }

    public final zztm zzv() {
        return (zztm) zzb(5, null, null);
    }

    public final zztp zzx() {
        return (zztp) zzb(4, null, null);
    }
}
