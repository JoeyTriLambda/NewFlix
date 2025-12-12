package k6;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import l6.u;

/* compiled from: DefaultDataSource.java */
/* loaded from: classes.dex */
public final class i implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14982a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super d> f14983b;

    /* renamed from: c, reason: collision with root package name */
    public final d f14984c;

    /* renamed from: d, reason: collision with root package name */
    public FileDataSource f14985d;

    /* renamed from: e, reason: collision with root package name */
    public AssetDataSource f14986e;

    /* renamed from: f, reason: collision with root package name */
    public ContentDataSource f14987f;

    /* renamed from: g, reason: collision with root package name */
    public d f14988g;

    /* renamed from: h, reason: collision with root package name */
    public d f14989h;

    public i(Context context, n<? super d> nVar, d dVar) {
        this.f14982a = context.getApplicationContext();
        this.f14983b = nVar;
        this.f14984c = (d) l6.a.checkNotNull(dVar);
    }

    @Override // k6.d
    public void close() throws IOException {
        d dVar = this.f14989h;
        if (dVar != null) {
            try {
                dVar.close();
            } finally {
                this.f14989h = null;
            }
        }
    }

    @Override // k6.d
    public Uri getUri() {
        d dVar = this.f14989h;
        if (dVar == null) {
            return null;
        }
        return dVar.getUri();
    }

    @Override // k6.d
    public long open(f fVar) throws IOException {
        l6.a.checkState(this.f14989h == null);
        String scheme = fVar.f14959a.getScheme();
        Uri uri = fVar.f14959a;
        boolean zIsLocalFileUri = u.isLocalFileUri(uri);
        Context context = this.f14982a;
        n<? super d> nVar = this.f14983b;
        if (zIsLocalFileUri) {
            if (uri.getPath().startsWith("/android_asset/")) {
                if (this.f14986e == null) {
                    this.f14986e = new AssetDataSource(context, nVar);
                }
                this.f14989h = this.f14986e;
            } else {
                if (this.f14985d == null) {
                    this.f14985d = new FileDataSource(nVar);
                }
                this.f14989h = this.f14985d;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f14986e == null) {
                this.f14986e = new AssetDataSource(context, nVar);
            }
            this.f14989h = this.f14986e;
        } else if ("content".equals(scheme)) {
            if (this.f14987f == null) {
                this.f14987f = new ContentDataSource(context, nVar);
            }
            this.f14989h = this.f14987f;
        } else {
            boolean zEquals = "rtmp".equals(scheme);
            d dVar = this.f14984c;
            if (zEquals) {
                if (this.f14988g == null) {
                    try {
                        this.f14988g = (d) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (ClassNotFoundException unused) {
                        Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (IllegalAccessException e10) {
                        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e10);
                    } catch (InstantiationException e11) {
                        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e11);
                    } catch (NoSuchMethodException e12) {
                        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e12);
                    } catch (InvocationTargetException e13) {
                        Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e13);
                    }
                    if (this.f14988g == null) {
                        this.f14988g = dVar;
                    }
                }
                this.f14989h = this.f14988g;
            } else {
                this.f14989h = dVar;
            }
        }
        return this.f14989h.open(fVar);
    }

    @Override // k6.d
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f14989h.read(bArr, i10, i11);
    }
}
