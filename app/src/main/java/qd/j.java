package qd;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: GoMovies123Processor.java */
/* loaded from: classes2.dex */
public final class j extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18105a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f18106b;

    public j(k kVar, String str) {
        this.f18106b = kVar;
        this.f18105a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        k kVar = this.f18106b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18105a)).get().getElementsByClass("flw-item").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                Element elementFirst2 = next.getElementsByClass("film-name").first();
                if (elementFirst2 != null && (elementFirst = elementFirst2.getElementsByTag("A").first()) != null) {
                    String strRemoveSpecialChars = kVar.removeSpecialChars(elementFirst.attr("title"));
                    String strRemoveSpecialChars2 = kVar.removeSpecialChars(kVar.f18107f.getTitle());
                    Element elementFirst3 = next.getElementsByClass("fd-infor").first();
                    if (strRemoveSpecialChars != null && strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2.toLowerCase()) && elementFirst3 != null && elementFirst3.text().trim().contains(kVar.f18107f.I)) {
                        kVar.getStreamRequest(elementFirst.attr("href").split("-")[r0.length - 1]);
                        return null;
                    }
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
        super.onPostExecute((j) str);
    }
}
