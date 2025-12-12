package flix.com.vision.bvp.subtitle;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import fc.g;
import flix.com.vision.exomedia.ui.widget.VideoView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class CaptionsView extends AppCompatTextView implements Runnable {

    /* renamed from: y, reason: collision with root package name */
    public static String f12168y;

    /* renamed from: s, reason: collision with root package name */
    public long f12169s;

    /* renamed from: t, reason: collision with root package name */
    public VideoView f12170t;

    /* renamed from: u, reason: collision with root package name */
    public TreeMap<Long, c> f12171u;

    /* renamed from: v, reason: collision with root package name */
    public CMime f12172v;

    /* renamed from: w, reason: collision with root package name */
    public Uri f12173w;

    /* renamed from: x, reason: collision with root package name */
    public String f12174x;

    public enum CMime {
        SUBRIP,
        WEBVTT
    }

    public enum TrackParseState {
        NEW_TRACK,
        PARSED_CUE,
        PARSED_TIME
    }

    public class a implements gc.a {
        public a(URL url) {
        }

        public void onDownload(File file) {
            CaptionsView captionsView = CaptionsView.this;
            try {
                String path = file.getPath();
                String str = CaptionsView.f12168y;
                captionsView.f12171u = captionsView.m(path);
            } catch (Exception unused) {
                String str2 = CaptionsView.f12168y;
                captionsView.getClass();
            }
        }

        public void onFail(Exception exc) {
            String str = CaptionsView.f12168y;
            CaptionsView.this.getClass();
        }
    }

    public interface b {
    }

    public CaptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12169s = 0L;
        this.f12173w = null;
        this.f12174x = null;
    }

    public static long p(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(":");
        String[] strArrSplit2 = strArrSplit[2].split(",");
        long j10 = Long.parseLong(strArrSplit[0].trim());
        long j11 = Long.parseLong(strArrSplit[1].trim());
        long j12 = Long.parseLong(strArrSplit2[0].trim()) * 1000;
        return j12 + (j11 * 60 * 1000) + (j10 * 60 * 60 * 1000) + Long.parseLong(strArrSplit2[1].trim());
    }

    public static TreeMap<Long, c> parse(InputStream inputStream, CMime cMime) throws IOException {
        return cMime == CMime.SUBRIP ? parseSrt(inputStream) : cMime == CMime.WEBVTT ? parseVtt(inputStream) : parseSrt(inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0070 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.TreeMap<java.lang.Long, flix.com.vision.bvp.subtitle.CaptionsView.c> parseSrt(java.io.InputStream r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.bvp.subtitle.CaptionsView.parseSrt(java.io.InputStream):java.util.TreeMap");
    }

    public static TreeMap<Long, c> parseVtt(InputStream inputStream) throws IOException, NumberFormatException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        TreeMap<Long, c> treeMap = new TreeMap<>();
        lineNumberReader.readLine();
        lineNumberReader.readLine();
        while (true) {
            String line = lineNumberReader.readLine();
            if (line == null) {
                return treeMap;
            }
            String strC = "";
            while (true) {
                String line2 = lineNumberReader.readLine();
                if (line2 == null || line2.trim().equals("")) {
                    break;
                }
                strC = ac.c.C(strC, line2, "<br/>");
            }
            String strSubstring = strC.substring(0, strC.length() - 5);
            String[] strArrSplit = line.split(" --> ");
            if (strArrSplit.length == 2) {
                long jQ = q(strArrSplit[0]);
                treeMap.put(Long.valueOf(jQ), new c(jQ, q(strArrSplit[1]), strSubstring));
            }
        }
    }

    public static long q(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(":");
        if (!(strArrSplit.length == 3)) {
            String[] strArrSplit2 = strArrSplit[1].split("\\.");
            return (Long.parseLong(strArrSplit2[0].trim()) * 1000) + (Long.parseLong(strArrSplit[0].trim()) * 60 * 1000) + Long.parseLong(strArrSplit2[1].trim());
        }
        String[] strArrSplit3 = strArrSplit[2].split("\\.");
        long j10 = Long.parseLong(strArrSplit[0].trim());
        long j11 = Long.parseLong(strArrSplit[1].trim());
        return (Long.parseLong(strArrSplit3[0].trim()) * 1000) + (j11 * 60 * 1000) + (j10 * 60 * 60 * 1000) + Long.parseLong(strArrSplit3[1].trim());
    }

    public void changeEncoding(String str) {
        Uri uri = this.f12173w;
        if (uri == null && this.f12174x == null) {
            return;
        }
        f12168y = str;
        if (uri == null) {
            String str2 = this.f12174x;
            if (str2 != null) {
                this.f12171u = m(str2);
                return;
            }
            return;
        }
        if (!g.isRemotePath(uri)) {
            this.f12171u = m(this.f12173w.toString());
            return;
        }
        try {
            n(new URL(this.f12173w.toString()));
        } catch (NullPointerException | MalformedURLException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.TreeMap<java.lang.Long, flix.com.vision.bvp.subtitle.CaptionsView.c> m(java.lang.String r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            flix.com.vision.bvp.subtitle.CaptionsView$CMime r4 = r3.f12172v     // Catch: java.lang.Exception -> L1a java.lang.Throwable -> L2e
            java.util.TreeMap r4 = parse(r1, r4)     // Catch: java.lang.Exception -> L1a java.lang.Throwable -> L2e
            r1.close()     // Catch: java.io.IOException -> L15
            goto L19
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            return r4
        L1a:
            r4 = move-exception
            goto L20
        L1c:
            r4 = move-exception
            goto L30
        L1e:
            r4 = move-exception
            r1 = r0
        L20:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L2d
            r1.close()     // Catch: java.io.IOException -> L29
            goto L2d
        L29:
            r4 = move-exception
            r4.printStackTrace()
        L2d:
            return r0
        L2e:
            r4 = move-exception
            r0 = r1
        L30:
            if (r0 == 0) goto L3a
            r0.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r0 = move-exception
            r0.printStackTrace()
        L3a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.bvp.subtitle.CaptionsView.m(java.lang.String):java.util.TreeMap");
    }

    public final void n(URL url) {
        new gc.b(getContext(), new a(url)).execute(url.toString(), "subtitle.srt");
    }

    public final String o(long j10) {
        long j11 = j10 + this.f12169s;
        String str = "";
        for (Map.Entry<Long, c> entry : this.f12171u.entrySet()) {
            if (j11 < entry.getKey().longValue()) {
                break;
            }
            if (j11 < entry.getValue().f12184b) {
                str = entry.getValue().f12185c;
            }
        }
        return str;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 300L);
        setShadowLayer(6.0f, 6.0f, 6.0f, -16777216);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() throws NumberFormatException {
        VideoView videoView = this.f12170t;
        if (videoView != null && this.f12171u != null) {
            long currentPosition = videoView.getCurrentPosition() / 1000;
            String strO = o(this.f12170t.getCurrentPosition());
            try {
                if (strO.startsWith("{\\an")) {
                    strO = strO.replace("{\\an" + Integer.parseInt(strO.split("\\}")[0].replace("{\\an", "").replace("}", "")) + "}", "");
                }
            } catch (Exception unused) {
                strO = o(this.f12170t.getCurrentPosition());
            }
            setText(Html.fromHtml("" + strO));
        }
        postDelayed(this, 50L);
    }

    public void setCaptionsSource(Uri uri, CMime cMime, String str) {
        this.f12173w = null;
        this.f12174x = null;
        this.f12172v = cMime;
        if (uri == null) {
            this.f12171u = new TreeMap<>();
            return;
        }
        this.f12173w = uri;
        if (!g.isRemotePath(uri)) {
            this.f12171u = m(uri.toString());
            return;
        }
        try {
            n(new URL(uri.toString()));
        } catch (NullPointerException | MalformedURLException e10) {
            e10.printStackTrace();
        }
    }

    public void setPlayer(VideoView videoView) {
        this.f12170t = videoView;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f12183a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12184b;

        /* renamed from: c, reason: collision with root package name */
        public String f12185c;

        public c(long j10, long j11, String str) {
            this.f12183a = j10;
            this.f12184b = j11;
            this.f12185c = str;
        }

        public void setText(String str) {
            this.f12185c = str;
        }

        public c(long j10, long j11) {
            this.f12183a = j10;
            this.f12184b = j11;
        }
    }

    public void setCaptionsSource(String str, CMime cMime, String str2) {
        this.f12173w = null;
        this.f12174x = null;
        this.f12172v = cMime;
        if (str == null) {
            this.f12171u = new TreeMap<>();
        } else {
            this.f12174x = str;
            this.f12171u = m(str);
        }
    }

    public void setCaptionsViewLoadListener(b bVar) {
    }

    public void setEncoding(String str) {
    }
}
