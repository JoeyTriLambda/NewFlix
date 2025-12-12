package sa;

import android.content.Context;
import android.os.StatFs;
import com.squareup.picasso.o;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkHttp3Downloader.java */
/* loaded from: classes2.dex */
public final class g implements d {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f19195a;

    public g(Context context) {
        StringBuilder sb2 = o.f10621a;
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        this(file);
    }

    public Response load(Request request) throws IOException {
        return this.f19195a.newCall(request).execute();
    }

    public g(File file) {
        long blockCountLong;
        StringBuilder sb2 = o.f10621a;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCountLong = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            blockCountLong = 5242880;
        }
        this(file, Math.max(Math.min(blockCountLong, 52428800L), 5242880L));
    }

    public g(File file, long j10) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j10)).build());
    }

    public g(OkHttpClient okHttpClient) {
        this.f19195a = okHttpClient;
        okHttpClient.cache();
    }
}
