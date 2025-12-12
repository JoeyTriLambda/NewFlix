package qd;

import android.os.AsyncTask;

/* compiled from: WatchSeriesProcessor.java */
/* loaded from: classes2.dex */
public final class a0 extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18073b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f18074c;

    public a0(b0 b0Var, String str, String str2) {
        this.f18074c = b0Var;
        this.f18072a = str;
        this.f18073b = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        r4 = r5.attr("href");
        r5 = r4.contains(cz.msebera.android.httpclient.HttpHost.DEFAULT_SCHEME_NAME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        r6 = r8.f18074c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        r4 = r6.f12433d + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008b, code lost:
    
        r4 = ((dh.b) ch.a.connect(r4)).get().getElementsByClass("child_episode");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
    
        if (r4 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if (r4.size() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        r0 = r4.first().getElementsByTag("A").first().attr("href");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
    
        if (r0.contains(cz.msebera.android.httpclient.HttpHost.DEFAULT_SCHEME_NAME) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        r0 = r6.f12433d + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        r9 = ((dh.b) ch.a.connect(r0)).get().getElementsByClass("anime_muti_link");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
    
        if (r9 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
    
        if (r9.isEmpty() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e6, code lost:
    
        r9 = r9.first().getElementsByTag("LI");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f4, code lost:
    
        if (r9.isEmpty() != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f6, code lost:
    
        r9 = r9.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fe, code lost:
    
        if (r9.hasNext() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0100, code lost:
    
        r0 = r9.next().attr("data-video");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
    
        if (r0 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
    
        if (r0.startsWith("//") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
    
        r0 = "http:" + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0127, code lost:
    
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012f, code lost:
    
        if (r0.contains(".php?id=") == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0131, code lost:
    
        new bd.e(r6.f12432c, r2, r6.f12431b).process(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013e, code lost:
    
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0146, code lost:
    
        if (r0.length() <= 20) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0148, code lost:
    
        r1 = new hd.o();
        r1.D = r0;
        r1.C = r6.checkLinkLabel(r0);
        r1.F = true;
        r6.f18077g.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0164, code lost:
    
        if (r6.f18077g.isEmpty() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0166, code lost:
    
        r9 = r6.f18077g.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0170, code lost:
    
        if (r9.hasNext() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0172, code lost:
    
        r6.addLink(r9.next());
     */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r9) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: qd.a0.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a0) str);
    }
}
