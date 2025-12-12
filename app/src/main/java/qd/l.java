package qd;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: GoMovies123ProcessorSeries.java */
/* loaded from: classes2.dex */
public final class l extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f18109b;

    public l(m mVar, String str) {
        this.f18109b = mVar;
        this.f18108a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        String episodeId;
        m mVar = this.f18109b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18108a)).get().getElementsByClass("flw-item").iterator();
            while (it.hasNext()) {
                Element elementFirst2 = it.next().getElementsByClass("film-name").first();
                if (elementFirst2 != null && (elementFirst = elementFirst2.getElementsByTag("A").first()) != null) {
                    String strRemoveSpecialChars = mVar.removeSpecialChars(elementFirst.attr("title"));
                    String strRemoveSpecialChars2 = mVar.removeSpecialChars(mVar.f18110f.getTitle());
                    if (strRemoveSpecialChars != null) {
                        if (!strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2)) {
                            if (strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2.toLowerCase() + mVar.f18110f.I)) {
                            }
                        }
                        String seasonId = mVar.getSeasonId(elementFirst.attr("href").split("-")[r0.length - 1]);
                        if (seasonId == null || (episodeId = mVar.getEpisodeId(seasonId)) == null) {
                            return null;
                        }
                        mVar.getEpisodeServers(episodeId);
                        return null;
                    }
                    continue;
                }
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((l) str);
    }
}
