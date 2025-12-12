package zd;

import ac.c;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SubDownload.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f22712a = "";

    /* compiled from: SubDownload.java */
    /* renamed from: zd.a$a, reason: collision with other inner class name */
    public class AsyncTaskC0336a extends AsyncTask<String, String, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22713a;

        public AsyncTaskC0336a(Context context, String str) {
            this.f22713a = str;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            try {
                a.a(this.f22713a);
                return "";
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }
    }

    /* compiled from: SubDownload.java */
    public class b extends AsyncTask<String, String, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22714a;

        public b(Context context, String str) {
            this.f22714a = str;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            try {
                a.b(this.f22714a);
                return "";
            } catch (Exception e10) {
                e10.printStackTrace();
                return "";
            }
        }
    }

    public static void a(String str) throws IOException {
        String strSubstring;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Failed to ownload subtitle. HTTP code: " + responseCode);
                httpURLConnection.disconnect();
                return;
            }
            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
            if (headerField != null) {
                int iIndexOf = headerField.indexOf("filename=");
                strSubstring = iIndexOf > 0 ? headerField.substring(iIndexOf + 10, headerField.length() - 1) : "";
            } else {
                strSubstring = str.substring(str.lastIndexOf("/") + 1, str.length());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String strO = c.o(new StringBuilder(), f22712a, strSubstring);
            new File(c.o(new StringBuilder(), f22712a, strSubstring));
            FileOutputStream fileOutputStream = new FileOutputStream(strO);
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    System.out.println("File downloaded");
                    httpURLConnection.disconnect();
                    hd.c cVar = new hd.c();
                    cVar.f12978a = strO;
                    EventBus.getDefault().post(cVar);
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void b(String str) throws IOException {
        String strSubstring;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200 && responseCode != 301) {
                httpURLConnection.disconnect();
                hd.c cVar = new hd.c();
                cVar.f12978a = null;
                EventBus.getDefault().post(cVar);
                return;
            }
            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
            httpURLConnection.getContentType();
            httpURLConnection.getContentLength();
            if (headerField != null) {
                int iIndexOf = headerField.indexOf("filename=");
                strSubstring = iIndexOf > 0 ? headerField.substring(iIndexOf + 10, headerField.length() - 1) : "";
            } else {
                strSubstring = str.substring(str.lastIndexOf("/") + 1, str.length());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String strO = c.o(new StringBuilder(), f22712a, strSubstring);
            if (strO.endsWith(".zi")) {
                strO = strO.concat("p");
            }
            String str2 = f22712a + strSubstring.replace(".zip", "");
            File file = new File(str2);
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isFile() && file2.getName().endsWith(".srt")) {
                        hd.c cVar2 = new hd.c();
                        StringBuilder sbU = c.u(str2, "/");
                        sbU.append(file2.getName());
                        cVar2.f12978a = sbU.toString();
                        EventBus.getDefault().post(cVar2);
                        return;
                    }
                }
            } else {
                file.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(strO);
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    fileOutputStream.close();
                    inputStream.close();
                    System.out.println("File downloaded");
                    httpURLConnection.disconnect();
                    unZipFileGZIP(strO, str2);
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        try {
            f22712a = context.getExternalCacheDir().getAbsolutePath() + "/subs/";
            File file = new File(f22712a);
            if (file.exists()) {
                return true;
            }
            file.mkdir();
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            Toast.makeText(context, e10.getMessage(), 0).show();
            return false;
        }
    }

    public static void downloadSubtitle(Context context, String str) {
        if (c(context)) {
            new b(context, str).execute("");
        }
    }

    public static void downloadSubtitleDirect(Context context, String str) {
        if (c(context)) {
            new AsyncTaskC0336a(context, str).execute("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void unZipFileGZIP(java.lang.String r6, java.lang.String r7) throws java.io.IOException {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.IOException -> L67
            r2.<init>(r6)     // Catch: java.io.IOException -> L67
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch: java.io.IOException -> L67
            r3.<init>(r2)     // Catch: java.io.IOException -> L67
            r2 = r1
        L10:
            java.util.zip.ZipEntry r4 = r3.getNextEntry()     // Catch: java.io.IOException -> L67
            if (r4 == 0) goto L2a
            java.lang.String r2 = r4.getName()     // Catch: java.io.IOException -> L67
            java.lang.String r4 = ".srt"
            boolean r4 = r2.contains(r4)     // Catch: java.io.IOException -> L67
            if (r4 != 0) goto L2a
            java.lang.String r4 = ".wtt"
            boolean r4 = r2.contains(r4)     // Catch: java.io.IOException -> L67
            if (r4 == 0) goto L10
        L2a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L67
            r4.<init>()     // Catch: java.io.IOException -> L67
            r4.append(r7)     // Catch: java.io.IOException -> L67
            java.lang.String r7 = "/"
            r4.append(r7)     // Catch: java.io.IOException -> L67
            r4.append(r2)     // Catch: java.io.IOException -> L67
            java.lang.String r7 = r4.toString()     // Catch: java.io.IOException -> L67
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L67
            r2.<init>(r7)     // Catch: java.io.IOException -> L67
        L43:
            int r4 = r3.read(r0)     // Catch: java.io.IOException -> L67
            if (r4 <= 0) goto L4e
            r5 = 0
            r2.write(r0, r5, r4)     // Catch: java.io.IOException -> L67
            goto L43
        L4e:
            r3.close()     // Catch: java.io.IOException -> L67
            r2.close()     // Catch: java.io.IOException -> L67
            java.io.PrintStream r0 = java.lang.System.out     // Catch: java.io.IOException -> L64
            java.lang.String r1 = "The file was decompressed successfully!"
            r0.println(r1)     // Catch: java.io.IOException -> L64
            java.io.File r0 = new java.io.File     // Catch: java.io.IOException -> L64
            r0.<init>(r6)     // Catch: java.io.IOException -> L64
            r0.delete()     // Catch: java.io.IOException -> L64
            goto L6c
        L64:
            r6 = move-exception
            r1 = r7
            goto L68
        L67:
            r6 = move-exception
        L68:
            r6.printStackTrace()
            r7 = r1
        L6c:
            if (r7 != 0) goto L6f
            return
        L6f:
            hd.c r6 = new hd.c
            r6.<init>()
            r6.f12978a = r7
            org.greenrobot.eventbus.EventBus r7 = org.greenrobot.eventbus.EventBus.getDefault()
            r7.post(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.a.unZipFileGZIP(java.lang.String, java.lang.String):void");
    }
}
