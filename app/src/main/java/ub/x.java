package ub;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.activities.DramaSearchActivityMobile;
import flix.com.vision.models.Drama;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: DramaSearchActivityMobile.java */
/* loaded from: classes2.dex */
public final class x extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Drama> f20313a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final String f20314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DramaSearchActivityMobile f20315c;

    public x(DramaSearchActivityMobile dramaSearchActivityMobile, String str) {
        this.f20315c = dramaSearchActivityMobile;
        this.f20314b = dramaSearchActivityMobile.Q + "/search.html?keyword=" + str.replace(StringUtils.SPACE, "+");
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            String str = this.f20314b;
            Iterator<Element> it = ch.a.parse(App.get(str, str).body().string()).select("div.list-drama div.item").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                try {
                    Drama drama = new Drama();
                    Element elementFirst = next.getElementsByTag("IMG").first();
                    if (elementFirst != null) {
                        String strAttr = elementFirst.attr("alt");
                        String str2 = "https://" + elementFirst.attr("src");
                        drama.f12389n = strAttr;
                        drama.f12392q = str2;
                    }
                    drama.f12391p = this.f20315c.Q + next.getElementsByTag("A").first().attr("href");
                    try {
                        if (drama.f12389n.toLowerCase().endsWith(")")) {
                            String strSubstring = drama.f12389n.substring(r2.length() - 6);
                            drama.f12389n = drama.f12389n.replace(strSubstring, "").trim();
                            drama.f12387b = strSubstring.replace("(", "").replace(")", "");
                        }
                    } catch (Exception unused) {
                    }
                    this.f20313a.add(drama);
                } catch (Exception unused2) {
                }
            }
            return null;
        } catch (Exception unused3) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((x) str);
        DramaSearchActivityMobile dramaSearchActivityMobile = this.f20315c;
        kc.d dVar = dramaSearchActivityMobile.T;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        ArrayList<Drama> arrayList = this.f20313a;
        if (arrayList.isEmpty()) {
            be.d.makeToast(dramaSearchActivityMobile.getBaseContext(), "No result found!", false);
            return;
        }
        dramaSearchActivityMobile.N.clear();
        dramaSearchActivityMobile.N.addAll(arrayList);
        arrayList.clear();
        dramaSearchActivityMobile.P.notifyDataSetChanged();
    }
}
