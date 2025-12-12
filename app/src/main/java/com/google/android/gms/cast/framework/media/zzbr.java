package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbr implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbu f6757b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzbu f6758m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ TracksChooserDialogFragment f6759n;

    public zzbr(TracksChooserDialogFragment tracksChooserDialogFragment, zzbu zzbuVar, zzbu zzbuVar2) {
        this.f6759n = tracksChooserDialogFragment;
        this.f6757b = zzbuVar;
        this.f6758m = zzbuVar2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        TracksChooserDialogFragment tracksChooserDialogFragment = this.f6759n;
        if (!tracksChooserDialogFragment.f6539x0) {
            AlertDialog alertDialog = tracksChooserDialogFragment.B0;
            if (alertDialog != null) {
                alertDialog.cancel();
                tracksChooserDialogFragment.B0 = null;
                return;
            }
            return;
        }
        RemoteMediaClient remoteMediaClient = (RemoteMediaClient) Preconditions.checkNotNull(tracksChooserDialogFragment.C0);
        if (!remoteMediaClient.hasMediaSession()) {
            AlertDialog alertDialog2 = tracksChooserDialogFragment.B0;
            if (alertDialog2 != null) {
                alertDialog2.cancel();
                tracksChooserDialogFragment.B0 = null;
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        MediaTrack mediaTrackZza = this.f6757b.zza();
        if (mediaTrackZza != null && mediaTrackZza.getId() != -1) {
            arrayList.add(Long.valueOf(mediaTrackZza.getId()));
        }
        MediaTrack mediaTrackZza2 = this.f6758m.zza();
        if (mediaTrackZza2 != null) {
            arrayList.add(Long.valueOf(mediaTrackZza2.getId()));
        }
        long[] jArr = tracksChooserDialogFragment.A0;
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            Iterator it = tracksChooserDialogFragment.f6541z0.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((MediaTrack) it.next()).getId()));
            }
            Iterator it2 = tracksChooserDialogFragment.f6540y0.iterator();
            while (it2.hasNext()) {
                hashSet.add(Long.valueOf(((MediaTrack) it2.next()).getId()));
            }
            for (long j10 : jArr) {
                Long lValueOf = Long.valueOf(j10);
                if (!hashSet.contains(lValueOf)) {
                    arrayList.add(lValueOf);
                }
            }
        }
        long[] jArr2 = new long[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jArr2[i11] = ((Long) arrayList.get(i11)).longValue();
        }
        Arrays.sort(jArr2);
        remoteMediaClient.setActiveMediaTracks(jArr2);
        AlertDialog alertDialog3 = tracksChooserDialogFragment.B0;
        if (alertDialog3 != null) {
            alertDialog3.cancel();
            tracksChooserDialogFragment.B0 = null;
        }
    }
}
