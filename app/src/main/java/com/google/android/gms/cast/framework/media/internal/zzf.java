package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzag;
import com.loopj.android.http.AsyncHttpClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzf extends AsyncTask {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f6550c = new Logger("FetchBitmapTask");

    /* renamed from: a, reason: collision with root package name */
    public final zzi f6551a;

    /* renamed from: b, reason: collision with root package name */
    public final zzb f6552b;

    public zzf(Context context, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14, zzb zzbVar) {
        this.f6552b = zzbVar;
        this.f6551a = zzag.zze(context.getApplicationContext(), this, new zze(this), i10, i11, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        zzi zziVar;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (zziVar = this.f6551a) == null) {
            return null;
        }
        try {
            return zziVar.zze(uri);
        } catch (RemoteException e10) {
            f6550c.d(e10, "Unable to call %s on %s.", "doFetch", "zzi");
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        zzb zzbVar = this.f6552b;
        if (zzbVar != null) {
            zzbVar.zzb(bitmap);
        }
    }
}
