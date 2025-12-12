package y3;

import android.content.Context;
import com.airbnb.lottie.network.FileExtension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21858a;

    public a(Context context) {
        this.f21858a = context.getApplicationContext();
    }

    public static String a(String str, FileExtension fileExtension, boolean z10) {
        StringBuilder sb2 = new StringBuilder("lottie_cache_");
        sb2.append(str.replaceAll("\\W+", ""));
        sb2.append(z10 ? fileExtension.tempExtension() : fileExtension.f5528b);
        return sb2.toString();
    }

    public final File b() {
        File file = new File(this.f21858a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File c(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(b(), a(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i10);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
