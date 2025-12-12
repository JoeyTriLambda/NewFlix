package qd;

import android.os.AsyncTask;

/* compiled from: UpMovies.java */
/* loaded from: classes2.dex */
public final class w extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18138a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f18139b;

    public w(x xVar, String str) {
        this.f18139b = xVar;
        this.f18138a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        r4 = r5.attr("href");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
    
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
    
        if (r4.startsWith(cz.msebera.android.httpclient.HttpHost.DEFAULT_SCHEME_NAME) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        if (r4.startsWith("/") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        r4 = r2.f12433d + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
    
        r4 = r2.f12433d + "/" + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b7, code lost:
    
        r1 = ((dh.b) ch.a.connect(r4)).get().getElementsByTag("DIV").iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cf, code lost:
    
        if (r1.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d1, code lost:
    
        r4 = r1.next();
        r5 = r4.attr("class");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
    
        if (r5 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e5, code lost:
    
        if (r5.contains("player-iframe") == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e7, code lost:
    
        r1 = r4.getElementsByTag("SCRIPT").first();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f1, code lost:
    
        if (r1 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f3, code lost:
    
        r1 = r1.toString();
        r2.getClass();
        r1 = java.util.regex.Pattern.compile("Base64.decode\\('(.*?)'").matcher(r1.replace("\"", "'"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010d, code lost:
    
        if (r1.find() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010f, code lost:
    
        r1 = r1.group(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0114, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0115, code lost:
    
        if (r1 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0117, code lost:
    
        r4 = new java.lang.String(android.util.Base64.decode(r1, 0), java.nio.charset.StandardCharsets.UTF_8);
        r2.getClass();
        r10 = java.util.regex.Pattern.compile("src='(.*?)'").matcher(r4.replace("\"", "'"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0138, code lost:
    
        if (r10.find() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x013a, code lost:
    
        r10 = r10.group(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x013f, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0140, code lost:
    
        if (r10 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0146, code lost:
    
        if (r10.isEmpty() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0148, code lost:
    
        r0 = new hd.o();
        r0.D = r10;
        r0.F = true;
        r0.C = r2.checkLinkLabel(r10) + " - [FPS]";
        r2.addLink(r0);
     */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r10) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.w.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((w) str);
    }
}
