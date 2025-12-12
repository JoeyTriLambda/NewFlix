package gc;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.bvp.subtitle.CaptionsView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: DownloadFile.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<String, String, String> {

    /* renamed from: a, reason: collision with root package name */
    public final a f12818a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12819b;

    /* renamed from: c, reason: collision with root package name */
    public File f12820c;

    public b(Context context, a aVar) {
        this.f12819b = context;
        this.f12818a = aVar;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(String... strArr) {
    }

    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) throws IOException {
        try {
            URL url = new URL(strArr[0]);
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.connect();
            uRLConnectionOpenConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream(), 8192);
            this.f12820c = new File(this.f12819b.getCacheDir(), strArr[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(this.f12820c);
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = bufferedInputStream.read(bArr);
                if (i10 == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    return null;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (Exception e10) {
            ((CaptionsView.a) this.f12818a).onFail(e10);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        a aVar = this.f12818a;
        if (aVar != null) {
            ((CaptionsView.a) aVar).onDownload(this.f12820c);
        }
    }
}
