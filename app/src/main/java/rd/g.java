package rd;

import android.os.AsyncTask;

/* compiled from: ZoeChip.java */
/* loaded from: classes2.dex */
public final class g extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f18937a;

    public g(h hVar) {
        this.f18937a = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0088, code lost:
    
        r2 = r8.getEvalScriptFromHTML(ch.a.parse(flix.com.vision.App.get(ch.a.parse(flix.com.vision.App.get(r3.getElementsByTag("A").first().attr("data-server"), r1).body().string()).getElementsByTag("IFRAME").first().attr("src"), r1).body().string()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00cc, code lost:
    
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ce, code lost:
    
        r2 = new kotlin.text.Regex("file:\\s*\"(.*?m3u8.*?)\"").find(new be.e(r2).unpack(), 0).getGroupValues().get(1);
        r5 = new hd.o();
        r5.D = r2;
        r5.f13047w = true;
        r5.F = false;
        r5.f13039o = true;
        r5.C = "1080p - [FILEMOON] - [DIRECT] - English";
        r5.f13040p = r1;
        r8.f12431b.OnSuccess(r5);
     */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r8) {
        /*
            r7 = this;
            rd.h r8 = r7.f18937a
            r0 = 0
            java.lang.String r1 = r8.b()     // Catch: java.lang.Exception -> L107
            if (r1 != 0) goto La
            return r0
        La:
            java.lang.String r2 = r8.f12433d     // Catch: java.lang.Exception -> L107
            okhttp3.Response r2 = flix.com.vision.App.get(r1, r2)     // Catch: java.lang.Exception -> L107
            okhttp3.ResponseBody r2 = r2.body()     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r2.string()     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Document r2 = ch.a.parse(r2)     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "show_player_ajax"
            org.jsoup.nodes.Element r2 = r2.getElementById(r3)     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "movie-id"
            java.lang.String r2 = r2.attr(r3)     // Catch: java.lang.Exception -> L107
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L107
            r3.<init>()     // Catch: java.lang.Exception -> L107
            java.lang.String r4 = r8.f12433d     // Catch: java.lang.Exception -> L107
            r3.append(r4)     // Catch: java.lang.Exception -> L107
            java.lang.String r4 = "/wp-admin/admin-ajax.php"
            r3.append(r4)     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L107
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Exception -> L107
            r4.<init>()     // Catch: java.lang.Exception -> L107
            java.lang.String r5 = "action"
            java.lang.String r6 = "lazy_player"
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L107
            java.lang.String r5 = "movieID"
            r4.put(r5, r2)     // Catch: java.lang.Exception -> L107
            okhttp3.Response r2 = flix.com.vision.App.post(r3, r4, r3)     // Catch: java.lang.Exception -> L107
            boolean r3 = r2.isSuccessful()     // Catch: java.lang.Exception -> L107
            if (r3 == 0) goto L10b
            okhttp3.ResponseBody r2 = r2.body()     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r2.string()     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Document r2 = ch.a.parse(r2)     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "LI"
            org.jsoup.select.Elements r2 = r2.getElementsByTag(r3)     // Catch: java.lang.Exception -> L107
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L107
        L6c:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L107
            if (r3 == 0) goto L10b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3     // Catch: java.lang.Exception -> L107
            java.lang.String r4 = r3.text()     // Catch: java.lang.Exception -> L107
            java.lang.String r4 = r4.toLowerCase()     // Catch: java.lang.Exception -> L107
            java.lang.String r5 = "filemoon"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Exception -> L107
            if (r4 == 0) goto L6c
            java.lang.String r2 = "A"
            org.jsoup.select.Elements r2 = r3.getElementsByTag(r2)     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Element r2 = r2.first()     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "data-server"
            java.lang.String r2 = r2.attr(r3)     // Catch: java.lang.Exception -> L107
            okhttp3.Response r2 = flix.com.vision.App.get(r2, r1)     // Catch: java.lang.Exception -> L107
            okhttp3.ResponseBody r2 = r2.body()     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r2.string()     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Document r2 = ch.a.parse(r2)     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "IFRAME"
            org.jsoup.select.Elements r2 = r2.getElementsByTag(r3)     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Element r2 = r2.first()     // Catch: java.lang.Exception -> L107
            java.lang.String r3 = "src"
            java.lang.String r2 = r2.attr(r3)     // Catch: java.lang.Exception -> L107
            okhttp3.Response r2 = flix.com.vision.App.get(r2, r1)     // Catch: java.lang.Exception -> L107
            okhttp3.ResponseBody r2 = r2.body()     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r2.string()     // Catch: java.lang.Exception -> L107
            org.jsoup.nodes.Document r2 = ch.a.parse(r2)     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r8.getEvalScriptFromHTML(r2)     // Catch: java.lang.Exception -> L107
            if (r2 == 0) goto L10b
            be.e r3 = new be.e     // Catch: java.lang.Exception -> L107
            r3.<init>(r2)     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = r3.unpack()     // Catch: java.lang.Exception -> L107
            kotlin.text.Regex r3 = new kotlin.text.Regex     // Catch: java.lang.Exception -> L107
            java.lang.String r4 = "file:\\s*\"(.*?m3u8.*?)\""
            r3.<init>(r4)     // Catch: java.lang.Exception -> L107
            r4 = 0
            ig.f r2 = r3.find(r2, r4)     // Catch: java.lang.Exception -> L107
            java.util.List r2 = r2.getGroupValues()     // Catch: java.lang.Exception -> L107
            r3 = 1
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L107
            hd.o r5 = new hd.o     // Catch: java.lang.Exception -> L107
            r5.<init>()     // Catch: java.lang.Exception -> L107
            r5.D = r2     // Catch: java.lang.Exception -> L107
            r5.f13047w = r3     // Catch: java.lang.Exception -> L107
            r5.F = r4     // Catch: java.lang.Exception -> L107
            r5.f13039o = r3     // Catch: java.lang.Exception -> L107
            java.lang.String r2 = "1080p - [FILEMOON] - [DIRECT] - English"
            r5.C = r2     // Catch: java.lang.Exception -> L107
            r5.f13040p = r1     // Catch: java.lang.Exception -> L107
            gd.f r8 = r8.f12431b     // Catch: java.lang.Exception -> L107
            r8.OnSuccess(r5)     // Catch: java.lang.Exception -> L107
            goto L10b
        L107:
            r8 = move-exception
            r8.printStackTrace()
        L10b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rd.g.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((g) str);
    }
}
