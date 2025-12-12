package ub;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.activities.DramaSearchResultActivity;
import flix.com.vision.models.Drama;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: DramaSearchResultActivity.java */
/* loaded from: classes2.dex */
public final class a0 extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Drama> f20144a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final String f20145b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f20146c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DramaSearchResultActivity f20147d;

    public a0(DramaSearchResultActivity dramaSearchResultActivity, boolean z10, String str) {
        this.f20147d = dramaSearchResultActivity;
        this.f20146c = z10;
        if (!z10) {
            str = dramaSearchResultActivity.Z + "/search.html?keyword=" + str.replace(StringUtils.SPACE, "+");
        }
        this.f20145b = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            String str = this.f20145b;
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
                    drama.f12391p = this.f20147d.Z + next.getElementsByTag("A").first().attr("href");
                    try {
                        if (drama.f12389n.toLowerCase().endsWith(")")) {
                            String strSubstring = drama.f12389n.substring(r2.length() - 6);
                            drama.f12389n = drama.f12389n.replace(strSubstring, "").trim();
                            drama.f12387b = strSubstring.replace("(", "").replace(")", "");
                        }
                    } catch (Exception unused) {
                    }
                    this.f20144a.add(drama);
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
        super.onPostExecute((a0) str);
        ArrayList<Drama> arrayList = this.f20144a;
        DramaSearchResultActivity dramaSearchResultActivity = this.f20147d;
        dramaSearchResultActivity.T.clear();
        dramaSearchResultActivity.T.addAll(arrayList);
        arrayList.clear();
        dramaSearchResultActivity.S.setVisibility(8);
        if (dramaSearchResultActivity.T.size() < 1) {
            dramaSearchResultActivity.W.setText("No anime found");
            dramaSearchResultActivity.W.setVisibility(0);
        } else if (this.f20146c) {
            Collections.shuffle(dramaSearchResultActivity.T);
        } else {
            dramaSearchResultActivity.W.setVisibility(8);
        }
        dramaSearchResultActivity.U.getAdapter().notifyDataSetChanged();
        dramaSearchResultActivity.U.invalidate();
        dramaSearchResultActivity.S.setVisibility(8);
    }
}
