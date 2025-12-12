package xd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import be.f;
import com.google.gson.l;
import com.google.gson.q;
import com.unity3d.ads.metadata.MediationMetaData;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import hd.m;
import hd.n;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: OpenSubtitleProcessor.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Movie f21736a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21737b = "https://www.opensubtitles.org";

    /* renamed from: c, reason: collision with root package name */
    public final String f21738c = "https://dl.opensubtitles.org";

    /* renamed from: d, reason: collision with root package name */
    public final String f21739d;

    /* compiled from: OpenSubtitleProcessor.java */
    /* renamed from: xd.a$a, reason: collision with other inner class name */
    public class AsyncTaskC0315a extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<m> f21740a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f21741b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f21742c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f21743d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f21744e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f21745f;

        public AsyncTaskC0315a(String str, String str2, String str3, int i10, int i11) {
            this.f21741b = str;
            this.f21742c = str2;
            this.f21743d = str3;
            this.f21744e = i10;
            this.f21745f = i11;
        }

        @Override // android.os.AsyncTask
        @SuppressLint({"StaticFieldLeak"})
        public String doInBackground(Void... voidArr) {
            int asInt;
            String strSubstring;
            String str = this.f21741b;
            a aVar = a.this;
            try {
                String str2 = aVar.f21737b;
                String str3 = aVar.f21739d;
                aVar.f21736a.getImdbID();
                l asJsonArray = JsonUtils.parse(App.getAjax("https://www.opensubtitles.org/libs/suggest.php?format=json3&MovieName=" + str + "&SubLanguageID=null").body().string()).getAsJsonArray();
                asInt = 0;
                for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                    q asJsonObject = asJsonArray.get(i10).getAsJsonObject();
                    if (asJsonObject.get(MediationMetaData.KEY_NAME).getAsString().equals(str) && asJsonObject.get("year").getAsString().equals(this.f21742c)) {
                        asInt = asJsonObject.get("id").getAsInt();
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (asInt == 0) {
                EventBus.getDefault().post(new n());
                return null;
            }
            String str4 = "https://www.opensubtitles.org/en/ssearch/sublanguageid-" + aVar.f21739d + "/idmovie-" + asInt;
            App.getInstance().f11564b = str4;
            Iterator<Element> it = ch.a.parse(App.get(str4, aVar.f21737b).body().string()).getElementsByTag("TR").iterator();
            String str5 = null;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.attr("itemprop") != null && !next.attr("itemprop").isEmpty()) {
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (next2.attr("itemprop") != null && next2.attr("itemprop").equals("url")) {
                            String strRemoveSpecialChars = f.removeSpecialChars(next2.attr("title").split("\"")[r14.split("\"").length - 1].trim());
                            if (!strRemoveSpecialChars.equalsIgnoreCase(f.removeSpecialChars(this.f21743d))) {
                                if (strRemoveSpecialChars.equalsIgnoreCase("episode" + this.f21744e + this.f21745f)) {
                                }
                            }
                            str5 = aVar.f21737b + next2.attr("href");
                            break;
                        }
                    }
                }
                if (str5 != null) {
                    break;
                }
            }
            if (str5 == null) {
                EventBus.getDefault().post(new n());
                return null;
            }
            Document document = ch.a.parse(App.get(str5, aVar.f21737b).body().string());
            Element elementById = document.getElementById("search_results");
            if (elementById == null) {
                this.f21740a = aVar.a(document);
                n nVar = new n();
                if (!this.f21740a.isEmpty()) {
                    nVar.f13035a = this.f21740a;
                }
                EventBus.getDefault().post(nVar);
                return null;
            }
            Iterator<Element> it3 = elementById.getElementsByTag("TR").iterator();
            while (it3.hasNext()) {
                Element next3 = it3.next();
                if (next3.text().contains("srt") || next3.text().contains("vtt")) {
                    Iterator<Element> it4 = next3.getElementsByTag("A").iterator();
                    String strAttr = null;
                    while (it4.hasNext() && (strAttr = it4.next().attr("href")) != null && !strAttr.contains("/sub/")) {
                    }
                    if (strAttr != null) {
                        Iterator<Element> it5 = next3.getElementsByTag("SPAN").iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                strSubstring = null;
                                break;
                            }
                            Element next4 = it5.next();
                            if (next4.attr("title") != null && !next4.attr("title").isEmpty()) {
                                strSubstring = next4.attr("title");
                                break;
                            }
                        }
                        String strAttr2 = aVar.f21739d;
                        Iterator<Element> it6 = next3.getElementsByTag("TD").iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            Element next5 = it6.next();
                            if (!next5.getElementsByTag("DIV").isEmpty() && !next5.getElementsByTag("A").isEmpty()) {
                                strAttr2 = next5.getElementsByTag("A").first().attr("title");
                                break;
                            }
                        }
                        if (strSubstring == null || strSubstring.length() < 10) {
                            strSubstring = next3.text().substring(0, 30);
                        }
                        if (strAttr2 == null) {
                            strAttr2 = aVar.f21739d;
                        }
                        m mVar = new m();
                        mVar.f13034m = strAttr2 + "." + strSubstring;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(aVar.f21738c);
                        sb2.append(strAttr.replace("subtitleserve", "download"));
                        mVar.f13033b = sb2.toString();
                        if (!this.f21740a.contains(mVar)) {
                            this.f21740a.add(mVar);
                        }
                    }
                }
            }
            if (this.f21740a.isEmpty()) {
                this.f21740a = aVar.a(document);
            }
            n nVar2 = new n();
            if (!this.f21740a.isEmpty()) {
                nVar2.f13035a = this.f21740a;
            }
            EventBus.getDefault().post(nVar2);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((AsyncTaskC0315a) str);
        }
    }

    /* compiled from: OpenSubtitleProcessor.java */
    public class b extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<m> f21747a = new ArrayList<>();

        public b() {
        }

        @Override // android.os.AsyncTask
        @SuppressLint({"StaticFieldLeak"})
        public String doInBackground(Void... voidArr) {
            Document document;
            Element elementById;
            String strSubstring;
            a aVar = a.this;
            try {
                document = ch.a.parse(App.get(aVar.f21737b + "/en/search/sublanguageid-" + aVar.f21739d + "/imdbid-" + aVar.f21736a.getImdbID(), aVar.f21737b).body().string());
                elementById = document.getElementById("search_results");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (elementById == null) {
                this.f21747a = aVar.a(document);
                n nVar = new n();
                if (!this.f21747a.isEmpty()) {
                    nVar.f13035a = this.f21747a;
                }
                EventBus.getDefault().post(nVar);
                return null;
            }
            Iterator<Element> it = elementById.getElementsByTag("TR").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next.text().contains("srt") || next.text().contains("vtt")) {
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    String strAttr = null;
                    while (it2.hasNext() && (strAttr = it2.next().attr("href")) != null && !strAttr.contains("/sub/")) {
                    }
                    if (strAttr != null) {
                        Iterator<Element> it3 = next.getElementsByTag("SPAN").iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                strSubstring = null;
                                break;
                            }
                            Element next2 = it3.next();
                            if (next2.attr("title") != null && !next2.attr("title").isEmpty()) {
                                strSubstring = next2.attr("title");
                                break;
                            }
                        }
                        String strAttr2 = aVar.f21739d;
                        Iterator<Element> it4 = next.getElementsByTag("TD").iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            Element next3 = it4.next();
                            if (!next3.getElementsByTag("DIV").isEmpty() && !next3.getElementsByTag("A").isEmpty()) {
                                strAttr2 = next3.getElementsByTag("A").first().attr("title");
                                break;
                            }
                        }
                        if (strSubstring == null || strSubstring.length() < 10) {
                            strSubstring = next.text().substring(0, 30);
                        }
                        if (strAttr2 == null) {
                            strAttr2 = aVar.f21739d;
                        }
                        m mVar = new m();
                        mVar.f13034m = strAttr2 + "." + strSubstring;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(aVar.f21738c);
                        sb2.append(strAttr.replace("subtitleserve", "download"));
                        mVar.f13033b = sb2.toString();
                        if (!this.f21747a.contains(mVar)) {
                            this.f21747a.add(mVar);
                        }
                    }
                }
            }
            if (this.f21747a.isEmpty()) {
                this.f21747a = aVar.a(document);
            }
            n nVar2 = new n();
            if (!this.f21747a.isEmpty()) {
                nVar2.f13035a = this.f21747a;
            }
            EventBus.getDefault().post(nVar2);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
        }
    }

    public a(Context context, Movie movie, String str) {
        this.f21739d = str.replace(StringUtils.SPACE, "").trim();
        this.f21736a = movie;
    }

    public final ArrayList<m> a(Document document) {
        ArrayList<m> arrayList = new ArrayList<>();
        Element elementById = document.getElementById("bt-dwl-bt");
        if (elementById != null) {
            String str = this.f21738c + elementById.attr("href").replace("subtitleserve", "download");
            m mVar = new m();
            mVar.f13033b = str;
            mVar.f13034m = this.f21739d + "." + this.f21736a.getTitle().replace(StringUtils.SPACE, ".") + ".Sub";
            arrayList.add(mVar);
        }
        return arrayList;
    }

    @SuppressLint({"StaticFieldLeak"})
    public void process(int i10, int i11, String str, String str2, String str3) {
        App.getInstance().f11564b = null;
        new AsyncTaskC0315a(str, str3, str2, i10, i11).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @SuppressLint({"StaticFieldLeak"})
    public void process() {
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
