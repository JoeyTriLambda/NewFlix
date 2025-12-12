package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zztm;
import com.google.android.gms.internal.cast.zztp;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public class zztm<MessageType extends zztp<MessageType, BuilderType>, BuilderType extends zztm<MessageType, BuilderType>> extends zzsg<MessageType, BuilderType> {
    protected zztp zza;
    private final zztp zzb;

    public zztm(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzK()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzx();
    }

    private static void zza(Object obj, Object obj2) {
        zzvf.zza().zzb(obj.getClass()).zze(obj, obj2);
    }

    @Override // com.google.android.gms.internal.cast.zzsg
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public final zztm clone() {
        zztm zztmVar = (zztm) this.zzb.zzb(5, null, null);
        zztmVar.zza = zzs();
        return zztmVar;
    }

    public final zztm zzp(zztp zztpVar) {
        if (!this.zzb.equals(zztpVar)) {
            if (!this.zza.zzK()) {
                zzv();
            }
            zza(this.zza, zztpVar);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final MessageType zzq() {
        /*
            r5 = this;
            com.google.android.gms.internal.cast.zztp r0 = r5.zzs()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzb(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L30
        L13:
            if (r3 == 0) goto L31
            com.google.android.gms.internal.cast.zzvf r3 = com.google.android.gms.internal.cast.zzvf.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.cast.zzvi r3 = r3.zzb(r4)
            boolean r3 = r3.zzh(r0)
            if (r1 == r3) goto L29
            r1 = r2
            goto L2a
        L29:
            r1 = r0
        L2a:
            r4 = 2
            r0.zzb(r4, r1, r2)
            if (r3 == 0) goto L31
        L30:
            return r0
        L31:
            com.google.android.gms.internal.cast.zzvy r1 = new com.google.android.gms.internal.cast.zzvy
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zztm.zzq():com.google.android.gms.internal.cast.zztp");
    }

    @Override // com.google.android.gms.internal.cast.zzuw
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public MessageType zzs() {
        if (!this.zza.zzK()) {
            return (MessageType) this.zza;
        }
        this.zza.zzF();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzuy
    public final /* bridge */ /* synthetic */ zzux zzt() {
        throw null;
    }

    public final void zzu() {
        if (this.zza.zzK()) {
            return;
        }
        zzv();
    }

    public void zzv() {
        zztp zztpVarZzx = this.zzb.zzx();
        zza(zztpVarZzx, this.zza);
        this.zza = zztpVarZzx;
    }
}
