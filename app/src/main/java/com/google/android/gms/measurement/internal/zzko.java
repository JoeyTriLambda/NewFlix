package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzko implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final URL f8342b;

    /* renamed from: m, reason: collision with root package name */
    public final zzkp f8343m;

    /* renamed from: n, reason: collision with root package name */
    public final String f8344n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzkm f8345o;

    public zzko(zzkm zzkmVar, String str, URL url, byte[] bArr, Map<String, String> map, zzkp zzkpVar) {
        this.f8345o = zzkmVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzkpVar);
        this.f8342b = url;
        this.f8343m = zzkpVar;
        this.f8344n = str;
    }

    public final void a(final int i10, final IOException iOException, final byte[] bArr, final Map map) throws IllegalStateException {
        this.f8345o.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkr
            @Override // java.lang.Runnable
            public final void run() {
                int i11 = i10;
                Exception exc = iOException;
                byte[] bArr2 = bArr;
                Map<String, List<String>> map2 = map;
                zzko zzkoVar = this.f8346b;
                zzkoVar.f8343m.zza(zzkoVar.f8344n, i11, exc, bArr2, map2);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Throwable th2;
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> headerFields;
        IOException e10;
        this.f8345o.zzr();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionZza = com.google.android.gms.internal.measurement.zzcq.zza().zza(this.f8342b, "client-measurement");
            if (!(uRLConnectionZza instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionZza;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
                try {
                    byte[] bArrA = zzkm.a(httpURLConnection);
                    httpURLConnection.disconnect();
                    a(responseCode, null, bArrA, headerFields);
                } catch (IOException e11) {
                    e10 = e11;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a(responseCode, e10, null, headerFields);
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a(responseCode, null, null, headerFields);
                    throw th2;
                }
            } catch (IOException e12) {
                e10 = e12;
                headerFields = null;
            } catch (Throwable th4) {
                th2 = th4;
                headerFields = null;
            }
        } catch (IOException e13) {
            e10 = e13;
            httpURLConnection = null;
            headerFields = null;
        } catch (Throwable th5) {
            th2 = th5;
            httpURLConnection = null;
            headerFields = null;
        }
    }
}
