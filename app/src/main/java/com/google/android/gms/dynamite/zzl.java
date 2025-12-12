package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzl implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int iZzb;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iZza = iVersions.zza(context, str);
        selectionResult.f7581a = iZza;
        int i10 = 1;
        int i11 = 0;
        if (iZza != 0) {
            iZzb = iVersions.zzb(context, str, false);
            selectionResult.f7582b = iZzb;
        } else {
            iZzb = iVersions.zzb(context, str, true);
            selectionResult.f7582b = iZzb;
        }
        int i12 = selectionResult.f7581a;
        if (i12 == 0) {
            if (iZzb == 0) {
                i10 = 0;
            }
            selectionResult.f7583c = i10;
            return selectionResult;
        }
        i11 = i12;
        if (iZzb < i11) {
            i10 = -1;
        }
        selectionResult.f7583c = i10;
        return selectionResult;
    }
}
