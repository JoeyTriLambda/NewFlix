package com.google.android.gms.internal.cast;

import ac.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n4.b;
import n4.d;
import n4.e;
import q4.q;
import q4.s;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@ShowFirstParty
/* loaded from: classes.dex */
public final class zzg {
    e zzb;
    private final Context zzd;
    private final com.google.android.gms.cast.internal.zzn zze;
    private final SessionManager zzf;
    private final zzbn zzg;
    private final zzaf zzh;
    private Long zzj;
    private final ExecutorService zzk;
    private static final Logger zzc = new Logger("ClientCastAnalytics");

    @ShowFirstParty
    public static final boolean zza = true;
    private int zzl = 1;
    private final String zzi = UUID.randomUUID().toString();

    private zzg(Context context, com.google.android.gms.cast.internal.zzn zznVar, SessionManager sessionManager, zzbn zzbnVar, zzaf zzafVar) {
        this.zzd = context;
        this.zze = zznVar;
        this.zzf = sessionManager;
        this.zzg = zzbnVar;
        this.zzh = zzafVar;
        zzec.zza();
        this.zzk = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
    }

    public static zzg zza(Context context, com.google.android.gms.cast.internal.zzn zznVar, SessionManager sessionManager, zzbn zzbnVar, zzaf zzafVar) {
        return new zzg(context, zznVar, sessionManager, zzbnVar, zzafVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzb(java.lang.String r12, int r13, android.content.SharedPreferences r14, android.os.Bundle r15) throws java.lang.NullPointerException {
        /*
            r11 = this;
            com.google.android.gms.cast.framework.SessionManager r0 = r11.zzf
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.internal.cast.zzbn r0 = r11.zzg
            com.google.android.gms.cast.framework.SessionManager r1 = r11.zzf
            r2 = 3
            java.lang.Class<com.google.android.gms.cast.framework.CastSession> r3 = com.google.android.gms.cast.framework.CastSession.class
            r4 = 2
            if (r13 == r2) goto L12
            if (r13 != r4) goto L2b
            r13 = 2
        L12:
            com.google.android.gms.internal.cast.zzaf r2 = r11.zzh
            com.google.android.gms.internal.cast.zzv r5 = new com.google.android.gms.internal.cast.zzv
            r5.<init>(r11, r2, r12)
            com.google.android.gms.internal.cast.zzt r2 = new com.google.android.gms.internal.cast.zzt
            r2.<init>(r5)
            r1.addSessionManagerListener(r2, r3)
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.cast.zzu r2 = new com.google.android.gms.internal.cast.zzu
            r2.<init>(r5)
            r0.zzm(r2)
        L2b:
            r2 = 1
            if (r13 == r2) goto L30
            if (r13 != r4) goto L4e
        L30:
            com.google.android.gms.internal.cast.zzaf r8 = r11.zzh
            com.google.android.gms.internal.cast.zzk r13 = new com.google.android.gms.internal.cast.zzk
            r5 = r13
            r6 = r14
            r7 = r11
            r9 = r15
            r10 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            com.google.android.gms.internal.cast.zzi r12 = new com.google.android.gms.internal.cast.zzi
            r12.<init>(r13)
            r1.addSessionManagerListener(r12, r3)
            if (r0 == 0) goto L4e
            com.google.android.gms.internal.cast.zzj r12 = new com.google.android.gms.internal.cast.zzj
            r12.<init>(r13)
            r0.zzm(r12)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzg.zzb(java.lang.String, int, android.content.SharedPreferences, android.os.Bundle):void");
    }

    public final void zzc(Bundle bundle) {
        final int i10 = bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
        boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
        if (i10 == 0) {
            if (!z10) {
                return;
            }
            i10 = 0;
            z10 = true;
        }
        final String packageName = this.zzd.getPackageName();
        String str = String.format(Locale.ROOT, "%s.%s", packageName, "client_cast_analytics_data");
        this.zzl = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
        s.initialize(this.zzd);
        this.zzb = s.getInstance().newFactory(o4.a.f16997e).getTransport("CAST_SENDER_SDK", zzno.class, b.of("proto"), new d() { // from class: com.google.android.gms.internal.cast.zze
            @Override // n4.d
            public final Object apply(Object obj) {
                zzno zznoVar = (zzno) obj;
                try {
                    int iZzu = zznoVar.zzu();
                    byte[] bArr = new byte[iZzu];
                    zztc zztcVarZzz = zztc.zzz(bArr, 0, iZzu);
                    zznoVar.zzJ(zztcVarZzz);
                    zztcVarZzz.zzA();
                    return bArr;
                } catch (IOException e10) {
                    throw new RuntimeException(c.k("Serializing ", zznoVar.getClass().getName(), " to a byte array threw an IOException (should never happen)."), e10);
                }
            }
        });
        if (bundle.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
            this.zzj = Long.valueOf(bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
        }
        final SharedPreferences sharedPreferences = this.zzd.getApplicationContext().getSharedPreferences(str, 0);
        if (i10 != 0) {
            final com.google.android.gms.cast.internal.zzn zznVar = this.zze;
            final String[] strArr = {"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"};
            zznVar.doRead(TaskApiCall.builder().run(new RemoteCall(zznVar, strArr) { // from class: com.google.android.gms.cast.internal.zze

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String[] f6855a;

                {
                    this.f6855a = strArr;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) throws RemoteException {
                    ((zzaj) ((zzo) obj).getService()).zzh(new zzl((TaskCompletionSource) obj2), this.f6855a);
                }
            }).setFeatures(com.google.android.gms.cast.zzax.f6936c).setAutoResolveMissingFeatures(false).setMethodKey(8426).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.cast.zzd
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) throws NullPointerException {
                    this.zza.zzb(packageName, i10, sharedPreferences, (Bundle) obj);
                }
            });
        }
        if (z10) {
            Preconditions.checkNotNull(sharedPreferences);
            zzo.zza(sharedPreferences, this, packageName).zze();
            zzo.zzd(zzml.CAST_CONTEXT);
        }
    }

    public final /* synthetic */ void zzd(zzno zznoVar, int i10) {
        zznn zznnVarZzd = zzno.zzd(zznoVar);
        zznnVarZzd.zzk(this.zzi);
        zznnVarZzd.zzf(this.zzi);
        Long l10 = this.zzj;
        if (l10 != null) {
            zznnVarZzd.zzi((int) l10.longValue());
        }
        zzno zznoVar2 = (zzno) zznnVarZzd.zzq();
        int i11 = this.zzl;
        int i12 = i11 - 1;
        n4.c cVarOfTelemetry = null;
        if (i11 == 0) {
            throw null;
        }
        if (i12 == 0) {
            cVarOfTelemetry = n4.c.ofTelemetry(i10 - 1, zznoVar2);
        } else if (i12 == 1) {
            cVarOfTelemetry = n4.c.ofData(i10 - 1, zznoVar2);
        }
        zzc.d("analytics event: %s", cVarOfTelemetry);
        Preconditions.checkNotNull(cVarOfTelemetry);
        e eVar = this.zzb;
        if (eVar != null) {
            ((q) eVar).send(cVarOfTelemetry);
        }
    }

    public final void zze(final zzno zznoVar, final int i10) {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.cast.zzf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zznoVar, i10);
            }
        });
    }
}
