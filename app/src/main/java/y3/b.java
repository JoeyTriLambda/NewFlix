package y3;

import android.content.Context;
import com.airbnb.lottie.network.FileExtension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
import org.apache.commons.lang3.StringUtils;
import p3.d;
import p3.e;
import p3.l;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f21859a;

    /* renamed from: b, reason: collision with root package name */
    public final a f21860b;

    public b(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f21859a = str;
        if (str2 == null) {
            this.f21860b = null;
        } else {
            this.f21860b = new a(applicationContext);
        }
    }

    public static String b(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb2.append(line);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e10) {
                throw e10;
            }
        }
        return sb2.toString();
    }

    public static l<d> fetchSync(Context context, String str, String str2) {
        return new b(context, str, str2).fetchSync();
    }

    public final l<d> a() throws IOException {
        StringBuilder sb2 = new StringBuilder("Fetching ");
        String str = this.f21859a;
        sb2.append(str);
        a4.d.debug(sb2.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                l<d> lVarC = c(httpURLConnection);
                StringBuilder sb3 = new StringBuilder("Completed fetch from network. Success: ");
                sb3.append(lVarC.getValue() != null);
                a4.d.debug(sb3.toString());
                return lVarC;
            }
            return new l<>((Throwable) new IllegalArgumentException("Unable to fetch " + str + ". Failed with " + httpURLConnection.getResponseCode() + StringUtils.LF + b(httpURLConnection)));
        } catch (Exception e10) {
            return new l<>((Throwable) e10);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public final l<d> c(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        l<d> lVarFromJsonInputStreamSync;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        boolean zContains = contentType.contains("application/zip");
        a aVar = this.f21860b;
        String str = this.f21859a;
        if (zContains) {
            a4.d.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            lVarFromJsonInputStreamSync = aVar == null ? e.fromZipStreamSync(new ZipInputStream(httpURLConnection.getInputStream()), null) : e.fromZipStreamSync(new ZipInputStream(new FileInputStream(aVar.c(str, httpURLConnection.getInputStream(), fileExtension))), str);
        } else {
            a4.d.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lVarFromJsonInputStreamSync = aVar == null ? e.fromJsonInputStreamSync(httpURLConnection.getInputStream(), null) : e.fromJsonInputStreamSync(new FileInputStream(new File(aVar.c(str, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), str);
        }
        if (aVar != null && lVarFromJsonInputStreamSync.getValue() != null) {
            File file = new File(aVar.b(), a.a(str, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            a4.d.debug("Copying temp file to real file (" + file2 + ")");
            if (!zRenameTo) {
                a4.d.warning("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
            }
        }
        return lVarFromJsonInputStreamSync;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p3.l<p3.d> fetchSync() {
        /*
            r9 = this;
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.ZIP
            java.lang.String r1 = r9.f21859a
            r2 = 0
            y3.a r3 = r9.f21860b
            if (r3 != 0) goto Lb
            goto L92
        Lb:
            java.io.File r4 = new java.io.File     // Catch: java.io.FileNotFoundException -> L68
            java.io.File r5 = r3.b()     // Catch: java.io.FileNotFoundException -> L68
            com.airbnb.lottie.network.FileExtension r6 = com.airbnb.lottie.network.FileExtension.JSON     // Catch: java.io.FileNotFoundException -> L68
            r7 = 0
            java.lang.String r8 = y3.a.a(r1, r6, r7)     // Catch: java.io.FileNotFoundException -> L68
            r4.<init>(r5, r8)     // Catch: java.io.FileNotFoundException -> L68
            boolean r5 = r4.exists()     // Catch: java.io.FileNotFoundException -> L68
            if (r5 == 0) goto L22
            goto L37
        L22:
            java.io.File r4 = new java.io.File     // Catch: java.io.FileNotFoundException -> L68
            java.io.File r3 = r3.b()     // Catch: java.io.FileNotFoundException -> L68
            java.lang.String r5 = y3.a.a(r1, r0, r7)     // Catch: java.io.FileNotFoundException -> L68
            r4.<init>(r3, r5)     // Catch: java.io.FileNotFoundException -> L68
            boolean r3 = r4.exists()     // Catch: java.io.FileNotFoundException -> L68
            if (r3 == 0) goto L36
            goto L37
        L36:
            r4 = r2
        L37:
            if (r4 != 0) goto L3a
            goto L69
        L3a:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L68
            r3.<init>(r4)     // Catch: java.io.FileNotFoundException -> L68
            java.lang.String r5 = r4.getAbsolutePath()
            java.lang.String r7 = ".zip"
            boolean r5 = r5.endsWith(r7)
            if (r5 == 0) goto L4c
            r6 = r0
        L4c:
            java.lang.String r5 = "Cache hit for "
            java.lang.String r7 = " at "
            java.lang.StringBuilder r5 = ac.c.v(r5, r1, r7)
            java.lang.String r4 = r4.getAbsolutePath()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            a4.d.debug(r4)
            w0.d r4 = new w0.d
            r4.<init>(r6, r3)
            goto L6a
        L68:
        L69:
            r4 = r2
        L6a:
            if (r4 != 0) goto L6d
            goto L92
        L6d:
            F r3 = r4.f20843a
            com.airbnb.lottie.network.FileExtension r3 = (com.airbnb.lottie.network.FileExtension) r3
            S r4 = r4.f20844b
            java.io.InputStream r4 = (java.io.InputStream) r4
            if (r3 != r0) goto L81
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            r0.<init>(r4)
            p3.l r0 = p3.e.fromZipStreamSync(r0, r1)
            goto L85
        L81:
            p3.l r0 = p3.e.fromJsonInputStreamSync(r4, r1)
        L85:
            java.lang.Object r3 = r0.getValue()
            if (r3 == 0) goto L92
            java.lang.Object r0 = r0.getValue()
            r2 = r0
            p3.d r2 = (p3.d) r2
        L92:
            if (r2 == 0) goto L9a
            p3.l r0 = new p3.l
            r0.<init>(r2)
            return r0
        L9a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Animation for "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r1 = " not found in cache. Fetching from network."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a4.d.debug(r0)
            p3.l r0 = r9.a()     // Catch: java.io.IOException -> Lb5
            goto Lbc
        Lb5:
            r0 = move-exception
            p3.l r1 = new p3.l
            r1.<init>(r0)
            r0 = r1
        Lbc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.b.fetchSync():p3.l");
    }
}
