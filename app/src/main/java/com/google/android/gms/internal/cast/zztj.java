package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zztj {
    private static final zztj zzb = new zztj(true);
    final zzvv zza = new zzvl(16);
    private boolean zzc;
    private boolean zzd;

    private zztj() {
    }

    public static zztj zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.cast.zzti r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.cast.zzwo r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.cast.zzty.zzd
            r5.getClass()
            com.google.android.gms.internal.cast.zzwo r1 = com.google.android.gms.internal.cast.zzwo.zza
            com.google.android.gms.internal.cast.zzwp r1 = com.google.android.gms.internal.cast.zzwp.INT
            com.google.android.gms.internal.cast.zzwp r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzux
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzuc
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zztr
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzsu
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.internal.cast.zzwo r4 = r4.zzb()
            com.google.android.gms.internal.cast.zzwp r4 = r4.zza()
            r2 = 1
            r1[r2] = r4
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r5 = 2
            r1[r5] = r4
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zztj.zzd(com.google.android.gms.internal.cast.zzti, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zztj zztjVar = new zztj();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry entryZzg = this.zza.zzg(i10);
            zztjVar.zzc((zzti) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zztjVar.zzc((zzti) entry.getKey(), entry.getValue());
        }
        zztjVar.zzd = this.zzd;
        return zztjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zztj) {
            return this.zza.equals(((zztj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry entryZzg = this.zza.zzg(i10);
            if (entryZzg.getValue() instanceof zztp) {
                ((zztp) entryZzg.getValue()).zzF();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzti zztiVar, Object obj) {
        if (!zztiVar.zzc()) {
            zzd(zztiVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zzd(zztiVar, arrayList.get(i10));
            }
            obj = arrayList;
        }
        if (obj instanceof zzuc) {
            this.zzd = true;
        }
        this.zza.put(zztiVar, obj);
    }

    private zztj(boolean z10) {
        zzb();
        zzb();
    }
}
