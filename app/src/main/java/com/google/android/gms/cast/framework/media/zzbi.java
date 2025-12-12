package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbi implements com.google.android.gms.cast.internal.zzas {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbk f6743a;

    public zzbi(zzbk zzbkVar) {
        this.f6743a = zzbkVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041 A[LOOP:0: B:21:0x003b->B:23:0x0041, LOOP_END] */
    @Override // com.google.android.gms.cast.internal.zzas
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r15, long r16, int r18, java.lang.Object r19, long r20, long r22) {
        /*
            r14 = this;
            r1 = r14
            com.google.android.gms.cast.framework.media.zzbk r2 = r1.f6743a
            com.google.android.gms.cast.framework.media.zzbl r0 = new com.google.android.gms.cast.framework.media.zzbl     // Catch: java.lang.IllegalStateException -> L26
            com.google.android.gms.common.api.Status r3 = new com.google.android.gms.common.api.Status     // Catch: java.lang.IllegalStateException -> L26
            r13 = r18
            r3.<init>(r13)     // Catch: java.lang.IllegalStateException -> L24
            r4 = r19
            boolean r5 = r4 instanceof com.google.android.gms.cast.internal.zzap
            r6 = 1
            if (r6 == r5) goto L14
            r4 = 0
        L14:
            if (r4 == 0) goto L19
            r5 = r4
            com.google.android.gms.cast.internal.zzap r5 = (com.google.android.gms.cast.internal.zzap) r5     // Catch: java.lang.IllegalStateException -> L24
        L19:
            if (r4 == 0) goto L1d
            com.google.android.gms.cast.internal.zzap r4 = (com.google.android.gms.cast.internal.zzap) r4     // Catch: java.lang.IllegalStateException -> L24
        L1d:
            r0.<init>(r3)     // Catch: java.lang.IllegalStateException -> L24
            r2.setResult(r0)     // Catch: java.lang.IllegalStateException -> L24
            goto L33
        L24:
            r0 = move-exception
            goto L29
        L26:
            r0 = move-exception
            r13 = r18
        L29:
            com.google.android.gms.cast.internal.Logger r3 = com.google.android.gms.cast.framework.media.RemoteMediaClient.f6527l
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "Result already set when calling onRequestCompleted"
            r3.e(r0, r5, r4)
        L33:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r2.f6747c
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f6536i
            java.util.Iterator r0 = r0.iterator()
        L3b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L55
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback r4 = (com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback) r4
            r5 = r15
            r6 = r16
            r8 = r18
            r9 = r20
            r11 = r22
            r4.zza(r5, r6, r8, r9, r11)
            goto L3b
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.zzbi.zza(java.lang.String, long, int, java.lang.Object, long, long):void");
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zzb(String str, long j10, long j11, long j12) {
        zzbk zzbkVar = this.f6743a;
        try {
            zzbkVar.setResult(new zzbj(new Status(2103)));
        } catch (IllegalStateException e10) {
            RemoteMediaClient.f6527l.e(e10, "Result already set when calling onRequestReplaced", new Object[0]);
        }
        Iterator it = zzbkVar.f6747c.f6536i.iterator();
        while (it.hasNext()) {
            ((RemoteMediaClient.Callback) it.next()).zza(str, j10, 2103, j11, j12);
        }
    }
}
