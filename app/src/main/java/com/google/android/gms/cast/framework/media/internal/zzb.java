package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.common.internal.Preconditions;
import com.loopj.android.http.AsyncHttpClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6543a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageHints f6544b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f6545c;

    /* renamed from: d, reason: collision with root package name */
    public zzf f6546d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6547e;

    /* renamed from: f, reason: collision with root package name */
    public zza f6548f;

    public zzb(Context context) {
        this(context, new ImageHints(-1, 0, 0));
    }

    public final void a() {
        zzf zzfVar = this.f6546d;
        if (zzfVar != null) {
            zzfVar.cancel(true);
            this.f6546d = null;
        }
        this.f6545c = null;
        this.f6547e = false;
    }

    public final void zza() {
        a();
        this.f6548f = null;
    }

    public final void zzb(Bitmap bitmap) {
        this.f6547e = true;
        zza zzaVar = this.f6548f;
        if (zzaVar != null) {
            zzaVar.zza(bitmap);
        }
        this.f6546d = null;
    }

    public final void zzc(zza zzaVar) {
        this.f6548f = zzaVar;
    }

    public final boolean zzd(Uri uri) {
        if (uri == null) {
            a();
            return true;
        }
        if (uri.equals(this.f6545c)) {
            return this.f6547e;
        }
        a();
        this.f6545c = uri;
        ImageHints imageHints = this.f6544b;
        if (imageHints.getWidthInPixels() == 0 || imageHints.getHeightInPixels() == 0) {
            this.f6546d = new zzf(this.f6543a, 0, 0, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, this);
        } else {
            this.f6546d = new zzf(this.f6543a, imageHints.getWidthInPixels(), imageHints.getHeightInPixels(), false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, this);
        }
        ((zzf) Preconditions.checkNotNull(this.f6546d)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Uri) Preconditions.checkNotNull(this.f6545c));
        return false;
    }

    public zzb(Context context, ImageHints imageHints) {
        this.f6543a = context;
        this.f6544b = imageHints;
        new zzc();
        a();
    }
}
