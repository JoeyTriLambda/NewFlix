package sd;

import android.os.AsyncTask;
import flix.com.vision.models.Movie;

/* compiled from: EmoviesSeries.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19249a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Movie f19250b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f19251c;

    public a(b bVar, String str, Movie movie) {
        this.f19251c = bVar;
        this.f19249a = str;
        this.f19250b = movie;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x013c, code lost:
    
        r3 = java.lang.System.currentTimeMillis() / 1000;
        r0 = flix.com.vision.utils.JsonUtils.parse(flix.com.vision.App.getAjax(r5.f12433d + "/ajax/v4_get_sources?s=oserver&id=" + r2.attr("value").split("=")[1].replace("&s", "") + "&_=" + r3).body().string()).getAsJsonObject().get("value").getAsString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0190, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0198, code lost:
    
        if (r0.length() >= 10) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x019c, code lost:
    
        r0 = flix.com.vision.App.get(r0, r5.f12433d + "/").body().string();
        r5.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x01bf, code lost:
    
        r0 = new kotlin.text.Regex("sources:\\s*\\[(.*)]").find(r0, 0).getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01cf, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0233, code lost:
    
        return null;
     */
    @Override // android.os.AsyncTask
    @android.annotation.SuppressLint({"StaticFieldLeak"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r10) {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.a.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
    }
}
