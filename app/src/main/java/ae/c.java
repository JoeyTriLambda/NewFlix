package ae;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.q;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.App;
import flix.com.vision.models.Json;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonUtilsTV.java */
/* loaded from: classes2.dex */
public final class c {

    /* compiled from: JsonUtilsTV.java */
    public class a implements Response.Listener<String> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f639b;

        public a(boolean z10) {
            this.f639b = z10;
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(String str) throws JSONException {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("SWIFTSTREAMZ");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        hd.d dVar = new hd.d();
                        ArrayList<hd.k> arrayList2 = dVar.f12989v;
                        dVar.f12984q = jSONObject.getString("c_title");
                        dVar.f12980m = jSONObject.getString("c_name") + "";
                        dVar.f12982o = jSONObject.getString("id");
                        dVar.f12988u = 999;
                        dVar.f12985r = jSONObject.getString("c_thumbnail");
                        ArrayList arrayList3 = new ArrayList();
                        if (!jSONObject.getString("stream_list").equals("null")) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("stream_list");
                            if (jSONArray2.length() > 0) {
                                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i11);
                                    hd.k kVar = new hd.k();
                                    kVar.f13026t = Integer.parseInt(jSONObject2.getString("stream_id"));
                                    kVar.f13023q = Integer.parseInt(jSONObject2.getString("token"));
                                    kVar.f13024r = jSONObject2.getString("token");
                                    kVar.f13021o = jSONObject2.getString("agent");
                                    kVar.f13027u = jSONObject2.getString("stream_url");
                                    kVar.f13029w = jSONObject2.getString(MediationMetaData.KEY_NAME);
                                    kVar.f13020n = jSONObject2.getString("referer");
                                    arrayList3.add(kVar);
                                }
                                arrayList2.addAll(arrayList3);
                                if (arrayList2.get(0) != null && !arrayList2.get(0).f13029w.contains("HD") && arrayList2.size() > 1) {
                                    Collections.reverse(arrayList2);
                                }
                            }
                        }
                        boolean z10 = this.f639b;
                        if (!z10 || (z10 && !dVar.f12984q.toLowerCase().contains("sky") && !dVar.f12984q.toLowerCase().contains("milan") && !dVar.f12984q.toLowerCase().contains("fox"))) {
                            arrayList.add(dVar);
                        }
                    } catch (Exception unused) {
                    }
                }
                lc.a aVar = new lc.a();
                aVar.f16046a.addAll(arrayList);
                EventBus.getDefault().post(aVar);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* compiled from: JsonUtilsTV.java */
    /* renamed from: ae.c$c, reason: collision with other inner class name */
    public class C0009c extends d4.m {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f640n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0009c(String str, String str2, a aVar, b bVar) {
            super(1, str, aVar, bVar);
            this.f640n = str2;
        }

        @Override // com.android.volley.Request
        public Map<String, String> getParams() throws AuthFailureError {
            q qVar = (q) new com.google.gson.j().create().toJsonTree(new Json());
            qVar.addProperty("method_name", "get_channels");
            qVar.addProperty("cat_id", this.f640n);
            return ac.c.w(JsonStorageKeyNames.DATA_KEY, Json.toBase64(qVar.toString()));
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class d implements Response.Listener<String> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hd.k f641b;

        public d(hd.k kVar) {
            this.f641b = kVar;
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(String str) throws JSONException {
            hd.k kVar = this.f641b;
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONObject("SWIFTSTREAMZ").getJSONArray("token_list");
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        if (kVar.f13024r.equals(jSONObject.getString("t_id"))) {
                            c.GetStreamLink3(kVar, jSONObject.getString("token_link"));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class f extends d4.m {
        public f(String str, d dVar, e eVar) {
            super(1, str, dVar, eVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getParams() throws NoSuchAlgorithmException, AuthFailureError {
            String strValueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String strM33722a = c.m33722a(strValueOf);
            try {
                be.a.m33719a(new be.a().mo31918a(strValueOf + '&' + strM33722a));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            q qVar = (q) new com.google.gson.j().create().toJsonTree(new Json());
            qVar.addProperty("method_name", "token_data");
            return ac.c.w(JsonStorageKeyNames.DATA_KEY, Json.toBase64(qVar.toString()));
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class g implements Response.Listener<String> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hd.k f642b;

        public g(hd.k kVar) {
            this.f642b = kVar;
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(String str) {
            String strValueOf = String.valueOf(str);
            hd.k kVar = this.f642b;
            String str2 = kVar.f13027u;
            StringBuilder sb2 = new StringBuilder(strValueOf);
            int length = strValueOf.length();
            boolean z10 = true;
            int i10 = 0;
            while (z10) {
                length--;
                if (length >= 0) {
                    if (i10 == 10 || i10 == 22 || i10 == 34 || i10 == 46 || i10 == 58) {
                        sb2.deleteCharAt(length);
                    }
                    i10++;
                } else {
                    z10 = false;
                }
            }
            kVar.f13027u = ac.c.B(str2, sb2.toString());
            EventBus.getDefault().post(kVar);
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class i extends d4.m {
        public i(String str, g gVar, h hVar) {
            super(1, str, gVar, hVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getParams() throws AuthFailureError {
            q qVar = (q) new com.google.gson.j().create().toJsonTree(new Json());
            qVar.addProperty("method_name", "token_data");
            return ac.c.w(JsonStorageKeyNames.DATA_KEY, Json.toBase64(qVar.toString()));
        }
    }

    public static void GetCategoriesChannels(String str, String str2, boolean z10) {
        App.getInstance().getRequestQueue().add(new C0009c(str, str2, new a(z10), new b()));
    }

    public static void GetStreamLink(hd.k kVar, String str) {
        App.getInstance().getRequestQueue().add(new f(str, new d(kVar), new e()));
    }

    public static void GetStreamLink3(hd.k kVar, String str) {
        App.getInstance().getRequestQueue().add(new i(str, new g(kVar), new h()));
    }

    public static String loadJSONFromAsset(Context context) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open("adult.json");
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String m33722a(String str) throws NoSuchAlgorithmException {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest((str + "e31Vga4MXIYss1I0jhtdKlkxxwv5N0CYSnCpQcRijIdSJYg").getBytes(StandardCharsets.UTF_8));
            StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
            for (byte b10 : bArrDigest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append('0');
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Huh, MD5 should be supported?", e10);
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class b implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class e implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* compiled from: JsonUtilsTV.java */
    public class h implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
