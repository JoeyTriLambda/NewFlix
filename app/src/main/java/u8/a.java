package u8;

import android.content.res.Resources;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.q;
import com.unity3d.services.ads.token.INativeTokenGeneratorListener;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import flix.com.vision.App;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.activities.CastMoviesActivity;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.FilterActivity;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import g8.g;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import n4.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.f;
import t8.f0;
import u8.b;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements b.a, d, g, INativeTokenGeneratorListener, IInvocationCallbackInvoker, f, Response.Listener, Response.ErrorListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20137b;

    public /* synthetic */ a(int i10) {
        this.f20137b = i10;
    }

    @Override // se.f
    public final void accept(Object obj) {
        switch (this.f20137b) {
            case 11:
                ArrayList<String> arrayList = App.B;
                q asJsonObject = ((o) obj).getAsJsonObject();
                String asString = asJsonObject.get("status").getAsString();
                if (asString != null && asString.equals("success")) {
                    l asJsonArray = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("magnets").getAsJsonArray();
                    for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                        App.deleteMagnetsAllDebrid(asJsonArray.get(i10).getAsJsonObject().get("id").getAsLong() + "");
                    }
                    break;
                }
                break;
            case 12:
                ArrayList<String> arrayList2 = App.B;
                break;
            case 13:
                ArrayList<String> arrayList3 = App.B;
                break;
            case 14:
                ArrayList<String> arrayList4 = App.B;
                break;
            case 15:
            case 16:
            case 18:
            case 19:
            case 22:
            case 23:
            case 24:
            case 27:
            default:
                int i11 = LinksActivity.C0;
                break;
            case 17:
                ArrayList<String> arrayList5 = App.B;
                break;
            case 20:
                ArrayList<String> arrayList6 = App.B;
                ((o) obj).getAsJsonObject();
                break;
            case 21:
                ArrayList<String> arrayList7 = App.B;
                break;
            case 25:
                int i12 = CastMoviesActivity.f11604f0;
                break;
            case 26:
                int i13 = CastMoviesActivity.f11604f0;
                Log.d("", "");
                break;
            case 28:
                int i14 = FilterActivity.f11656o0;
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
        }
    }

    @Override // n4.d
    public final Object apply(Object obj) {
        return x8.a.f21640b.reportToJson((f0) obj).getBytes(Charset.forName("UTF-8"));
    }

    @Override // com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker
    public final void invokeCallback(Invocation invocation) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        SharedInstances.webViewAppInvocationCallbackInvoker$lambda$0(invocation);
    }

    @Override // com.android.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) throws Resources.NotFoundException {
        switch (this.f20137b) {
            case 16:
                App.c();
                break;
            case 19:
                App.c();
                break;
            case 23:
                ArrayList<String> arrayList = App.B;
                break;
            case 24:
                int i10 = AnimesListActivity.f11597f0;
                break;
            default:
                int i11 = DramaHomeActivity.f11619x0;
                break;
        }
    }

    @Override // com.unity3d.services.ads.token.INativeTokenGeneratorListener
    public final void onReady(String str) {
        InMemoryTokenStorage._get_nativeGeneratedToken_$lambda$2(str);
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) throws JSONException, Resources.NotFoundException {
        switch (this.f20137b) {
            case 15:
                String str = (String) obj;
                ArrayList<String> arrayList = App.B;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.get("status").toString().equals("success")) {
                        JSONObject jSONObject2 = (JSONObject) ((JSONObject) jSONObject.get(JsonStorageKeyNames.DATA_KEY)).get("hosts");
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            JSONArray jSONArray = (JSONArray) ((JSONObject) jSONObject2.get(itKeys.next().toString())).get("domains");
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                String string = jSONArray.get(i10).toString();
                                if (!App.N.contains(string)) {
                                    App.N.add(string);
                                }
                            }
                        }
                        break;
                    }
                } catch (Exception unused) {
                    App.c();
                    return;
                }
                break;
            case 18:
                String str2 = (String) obj;
                ArrayList<String> arrayList2 = App.B;
                try {
                    Iterator<String> itKeys2 = new JSONObject(str2).keys();
                    while (itKeys2.hasNext()) {
                        String string2 = itKeys2.next().toString();
                        if (!App.L.contains(string2)) {
                            App.L.add(string2);
                        }
                    }
                    break;
                } catch (Exception unused2) {
                    App.c();
                }
            default:
                String str3 = (String) obj;
                ArrayList<String> arrayList3 = App.B;
                try {
                    JSONArray jSONArray2 = new JSONObject(str3).getJSONArray("cache");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        String string3 = jSONArray2.getString(i11);
                        if (!App.M.contains(string3)) {
                            App.M.add(string3);
                        }
                    }
                    break;
                } catch (Exception unused3) {
                    return;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014f  */
    @Override // u8.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parse(android.util.JsonReader r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.a.parse(android.util.JsonReader):java.lang.Object");
    }
}
