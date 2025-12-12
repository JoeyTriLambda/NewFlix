package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class GmsSignatureVerifier {
    static {
        zzz zzzVar = new zzz();
        zzzVar.f7558a = "com.google.android.gms";
        zzzVar.f7559b = 204200000L;
        zzi zziVar = zzn.f7535d;
        zzag zzagVarZzn = zzag.zzn(zziVar.b(), zzn.f7533b.b());
        Preconditions.checkNotNull(zzagVarZzn);
        zzzVar.f7560c = zzag.zzk(zzagVarZzn);
        zzh zzhVar = zzn.f7534c;
        zzag zzagVarZzn2 = zzag.zzn(zzhVar.b(), zzn.f7532a.b());
        Preconditions.checkNotNull(zzagVarZzn2);
        zzzVar.f7561d = zzag.zzk(zzagVarZzn2);
        zzzVar.a();
        zzz zzzVar2 = new zzz();
        zzzVar2.f7558a = "com.android.vending";
        zzzVar2.f7559b = 82240000L;
        zzag zzagVarZzm = zzag.zzm(zziVar.b());
        Preconditions.checkNotNull(zzagVarZzm);
        zzzVar2.f7560c = zzag.zzk(zzagVarZzm);
        zzag zzagVarZzm2 = zzag.zzm(zzhVar.b());
        Preconditions.checkNotNull(zzagVarZzm2);
        zzzVar2.f7561d = zzag.zzk(zzagVarZzm2);
        zzzVar2.a();
        new HashMap();
    }
}
