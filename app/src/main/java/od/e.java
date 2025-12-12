package od;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdultVideosFetcherRelated.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f17082b;

    public e(f fVar, String str) {
        this.f17082b = fVar;
        this.f17081a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) throws JSONException {
        Matcher matcher;
        f fVar;
        try {
            matcher = Pattern.compile("video_related=\\[.*?\\];").matcher(((dh.b) ch.a.connect(this.f17081a)).get().toString());
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
        while (true) {
            boolean zFind = matcher.find();
            fVar = this.f17082b;
            if (!zFind) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray(matcher.group(0).replace("video_related=", "").replace("}];", "}]"));
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String string = jSONObject.getString("tf");
                        String string2 = jSONObject.getString("i");
                        String string3 = jSONObject.getString("d");
                        String str = "https://xvideos.com" + jSONObject.getString("u");
                        id.c cVar = new id.c();
                        cVar.f13365a = string;
                        cVar.f13367c = string2;
                        cVar.f13368d = string3;
                        cVar.f13366b = str;
                        fVar.f17083a.add(cVar);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            e10.printStackTrace();
            return null;
        }
        if (fVar.f17083a.size() <= 0) {
            return null;
        }
        fVar.f17084b.OnVideoListSuccess(fVar.f17083a);
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((e) str);
    }
}
