package a2;

import a2.i;
import a2.w;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.android.volley.Response;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpStatus;
import flix.com.vision.App;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.api.alldebrid.AllDebridApiKeyEntryActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremApiKeyEntryActivity;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.processors.english.BaseProcessor;
import h9.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kg.k0;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import z4.a;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements w.b, CallbackToFutureAdapter.b, a.InterfaceC0331a, a.InterfaceC0161a, Response.Listener, se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f289b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f290m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f291n;

    public /* synthetic */ x(int i10, Object obj, Object obj2) {
        this.f289b = i10;
        this.f290m = obj;
        this.f291n = obj2;
    }

    public final void a(i.e eVar) {
        y yVar = (y) this.f290m;
        ((a) yVar.f293b).releaseProviderController((w) this.f291n, eVar);
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f289b;
        Object obj2 = this.f291n;
        Object obj3 = this.f290m;
        switch (i10) {
            case 7:
                AllDebridApiKeyEntryActivity allDebridApiKeyEntryActivity = (AllDebridApiKeyEntryActivity) obj3;
                String str = (String) obj2;
                com.google.gson.o oVar = (com.google.gson.o) obj;
                int i11 = AllDebridApiKeyEntryActivity.Q;
                kc.d dVar = allDebridApiKeyEntryActivity.P;
                if (dVar != null) {
                    try {
                        dVar.dismiss();
                    } catch (Exception unused) {
                    }
                }
                com.google.gson.q asJsonObject = oVar.getAsJsonObject();
                if (!asJsonObject.get("status").getAsString().equals("success")) {
                    ic.a.Success(allDebridApiKeyEntryActivity, ac.c.j("API Key not valid: ", asJsonObject.get("message").getAsString()), null, 80, 1);
                    break;
                } else {
                    SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                    com.google.gson.q asJsonObject2 = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("user").getAsJsonObject();
                    String asString = asJsonObject2.get("username").getAsString();
                    boolean asBoolean = asJsonObject2.get("isPremium").getAsBoolean();
                    int asInt = asJsonObject2.get("premiumUntil").getAsInt();
                    if (asInt > 0) {
                        editorEdit.putString("ALL_DEBRID_PREMIUM_UNTIL", AllDebridApiKeyEntryActivity.getDate(asInt));
                    }
                    editorEdit.putBoolean("ALL_DEBRID_LOGGED_IN", true);
                    editorEdit.putString("ALL_DEBRID_USERNAME", asString);
                    editorEdit.putBoolean("ALL_DEBRID_IS_PREMIUM", asBoolean);
                    String str2 = Constants.f12319a;
                    editorEdit.putString("all_debrid_apikey", str);
                    editorEdit.apply();
                    editorEdit.commit();
                    AllDebridCommon.f12043n = true;
                    AllDebridCommon.f12044o = str;
                    ic.a.Success(allDebridApiKeyEntryActivity, "Successfully logged in", null, 80, 1);
                    allDebridApiKeyEntryActivity.finish();
                    break;
                }
            default:
                PremApiKeyEntryActivity premApiKeyEntryActivity = (PremApiKeyEntryActivity) obj3;
                String str3 = (String) obj2;
                com.google.gson.o oVar2 = (com.google.gson.o) obj;
                int i12 = PremApiKeyEntryActivity.Q;
                kc.d dVar2 = premApiKeyEntryActivity.P;
                if (dVar2 != null) {
                    try {
                        dVar2.dismiss();
                    } catch (Exception unused2) {
                    }
                }
                com.google.gson.q asJsonObject3 = oVar2.getAsJsonObject();
                if (!asJsonObject3.get("status").getAsString().equals("success")) {
                    ic.a.Success(premApiKeyEntryActivity, ac.c.j("API Key not valid: ", asJsonObject3.get("message").getAsString()), null, 80, 1);
                    break;
                } else {
                    int asInt2 = asJsonObject3.get("premium_until").getAsInt();
                    if (asInt2 > 0) {
                        App.getInstance().f11574v.edit().putString("PREM_PREMIUM_UNTIL", PremApiKeyEntryActivity.getDate(asInt2)).apply();
                    }
                    App.getInstance().f11574v.edit().putBoolean("PREM_LOGGED_IN", true).apply();
                    SharedPreferences.Editor editorEdit2 = App.getInstance().f11574v.edit();
                    String str4 = Constants.f12319a;
                    editorEdit2.putString("prem_apikey", str3).apply();
                    PremiumizeCommon.f12045b = true;
                    PremiumizeCommon.f12046m = str3;
                    ic.a.Success(premApiKeyEntryActivity, "Successfully logged in", null, 80, 1);
                    premApiKeyEntryActivity.finish();
                    break;
                }
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        k0 k0Var = (k0) this.f290m;
        Object obj = this.f291n;
        CoroutineAdapterKt.a(k0Var, obj, aVar);
        return obj;
    }

    @Override // z4.a.InterfaceC0331a
    public final Object execute() {
        int i10 = this.f289b;
        Object obj = this.f291n;
        Object obj2 = this.f290m;
        switch (i10) {
            case 2:
                ((x4.h) obj2).f21533c.recordSuccess((Iterable) obj);
                break;
            default:
                x4.h hVar = (x4.h) obj2;
                hVar.getClass();
                Iterator it = ((Map) obj).entrySet().iterator();
                while (it.hasNext()) {
                    hVar.f21539i.recordLogEventDropped(((Integer) r2.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
                }
                break;
        }
        return null;
    }

    @Override // h9.a.InterfaceC0161a
    public final void handle(h9.b bVar) {
        a.InterfaceC0161a interfaceC0161a = (a.InterfaceC0161a) this.f290m;
        a.InterfaceC0161a interfaceC0161a2 = (a.InterfaceC0161a) this.f291n;
        interfaceC0161a.handle(bVar);
        interfaceC0161a2.handle(bVar);
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) {
        String[] strArr;
        int i10;
        int i11 = this.f289b;
        Object obj2 = this.f291n;
        Object obj3 = this.f290m;
        switch (i11) {
            case 5:
                AnimesListActivity animesListActivity = (AnimesListActivity) obj3;
                List<String> list = (List) obj2;
                String str = (String) obj;
                int i12 = AnimesListActivity.f11597f0;
                animesListActivity.getClass();
                try {
                    JSONArray jSONArray = (JSONArray) new JSONArray(str.substring(19, str.length() - 1)).get(1);
                    for (int i13 = 0; i13 < jSONArray.length(); i13++) {
                        list.add(((JSONArray) jSONArray.get(i13)).get(0).toString());
                    }
                    animesListActivity.K.clearSuggestions();
                    animesListActivity.K.addSuggestions(list);
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 6:
                DramaHomeActivity dramaHomeActivity = (DramaHomeActivity) obj3;
                List<String> list2 = (List) obj2;
                String str2 = (String) obj;
                int i14 = DramaHomeActivity.f11619x0;
                dramaHomeActivity.getClass();
                try {
                    JSONArray jSONArray2 = (JSONArray) new JSONArray(str2.substring(19, str2.length() - 1)).get(1);
                    for (int i15 = 0; i15 < jSONArray2.length(); i15++) {
                        list2.add(((JSONArray) jSONArray2.get(i15)).get(0).toString());
                    }
                    dramaHomeActivity.L.clearSuggestions();
                    dramaHomeActivity.L.addSuggestions(list2);
                    break;
                } catch (Exception unused2) {
                    return;
                }
            case 7:
            case 8:
            default:
                wd.s sVar = (wd.s) obj3;
                sVar.getClass();
                new wd.t(sVar, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            case 9:
                od.a aVar = (od.a) obj3;
                int i16 = od.a.f17071c;
                aVar.getClass();
                String[] strArrSplit = ((String) obj2).split("\\?");
                String[] strArrSplit2 = ((String) obj).split("#EXT-X-STREAM-INF:");
                int length = strArrSplit2.length;
                int i17 = 0;
                while (true) {
                    od.b bVar = aVar.f17073b;
                    if (i17 < length) {
                        String[] strArrSplit3 = strArrSplit2[i17].split("NAME=");
                        int length2 = strArrSplit3.length;
                        int i18 = 0;
                        while (i18 < length2) {
                            String str3 = strArrSplit3[i18];
                            String[] strArr2 = strArrSplit2;
                            od.a aVar2 = aVar;
                            int i19 = length;
                            if (str3.contains("1080p")) {
                                strArr = strArrSplit3;
                                i10 = length2;
                                bVar.addLink(strArrSplit[0].replace("hls.m3u8", str3.replace("\"1080p\"", "")).replaceAll(StringUtils.LF, "").replaceAll(StringUtils.SPACE, ""), "1080p");
                            } else {
                                strArr = strArrSplit3;
                                i10 = length2;
                                if (str3.contains("720p")) {
                                    bVar.addLink(strArrSplit[0].replace("hls.m3u8", str3.replace("\"720p\"", "")).replaceAll(StringUtils.LF, "").replaceAll(StringUtils.SPACE, ""), "720p");
                                } else if (str3.contains("480p")) {
                                    bVar.addLink(strArrSplit[0].replace("hls.m3u8", str3.replace("\"480p\"", "")).replaceAll(StringUtils.LF, "").replaceAll(StringUtils.SPACE, ""), "480p");
                                } else if (str3.contains("360p")) {
                                    bVar.addLink(strArrSplit[0].replace("hls.m3u8", str3.replace("\"360p\"", "")).replaceAll(StringUtils.LF, "").replaceAll(StringUtils.SPACE, ""), "360p");
                                } else if (str3.contains("250p")) {
                                    bVar.addLink(strArrSplit[0].replace("hls.m3u8", str3.replace("\"250p\"", "")).replaceAll(StringUtils.LF, "").replaceAll(StringUtils.SPACE, ""), "250p");
                                }
                            }
                            i18++;
                            strArrSplit2 = strArr2;
                            aVar = aVar2;
                            length = i19;
                            strArrSplit3 = strArr;
                            length2 = i10;
                        }
                        i17++;
                    } else if (bVar.f17074a.size() > 0) {
                        ArrayList<id.b> arrayList = bVar.f17074a;
                        Collections.sort(arrayList);
                        id.b bVar2 = bVar.f17076c;
                        if (bVar2 != null) {
                            arrayList.add(0, bVar2);
                        }
                        bVar.f17075b.OnStreamResolvedSuccess(arrayList);
                        break;
                    }
                }
                break;
            case 10:
                pd.b bVar3 = (pd.b) obj3;
                String str4 = (String) obj2;
                int i20 = pd.b.f17671c;
                bVar3.getClass();
                String[] strArrSplit4 = ((String) obj).split("#EXT-X-STREAM-INF:");
                int length3 = strArrSplit4.length;
                int i21 = 0;
                while (true) {
                    pd.c cVar = bVar3.f17673b;
                    if (i21 < length3) {
                        String[] strArrSplit5 = strArrSplit4[i21].split("RESOLUTION=");
                        int length4 = strArrSplit5.length;
                        int i22 = 0;
                        while (i22 < length4) {
                            String str5 = strArrSplit5[i22];
                            pd.b bVar4 = bVar3;
                            String[] strArr3 = strArrSplit4;
                            if (str5.contains("1080")) {
                                cVar.addLink(!cVar.f17674a ? str4.replace("/index.m3u8", "/1080/index.m3u8") : str4.replace(".m3u8", ".1080.m3u8"), "1080p");
                            } else if (str5.contains("720")) {
                                cVar.addLink(!cVar.f17674a ? str4.replace("/index.m3u8", "/720/index.m3u8") : str4.replace(".m3u8", ".720.m3u8"), "720p");
                            } else if (str5.contains("480")) {
                                cVar.addLink(!cVar.f17674a ? str4.replace("/index.m3u8", "/480/index.m3u8") : str4.replace(".m3u8", ".480.m3u8"), "480p");
                            }
                            if (cVar.f17677d != null) {
                                if (str5.contains("360")) {
                                    cVar.addLink(str4.replace("/index.m3u8", "/360/index.m3u8"), "360p");
                                } else if (str5.contains("250")) {
                                    cVar.addLink(str4.replace("/index.m3u8", "/250/index.m3u8"), "250p");
                                }
                            }
                            i22++;
                            strArrSplit4 = strArr3;
                            bVar3 = bVar4;
                        }
                        i21++;
                    } else if (cVar.f17675b.size() > 0) {
                        ArrayList<hd.o> arrayList2 = cVar.f17675b;
                        Collections.sort(arrayList2);
                        if (cVar.f17677d != null) {
                            hd.o oVar = cVar.f17678e;
                            if (oVar != null) {
                                arrayList2.add(0, oVar);
                            }
                            Collections.sort(arrayList2);
                            cVar.f17677d.OnM3USuccess(arrayList2);
                            break;
                        } else {
                            cVar.f17676c.OnSuccess(arrayList2);
                            break;
                        }
                    }
                }
                break;
            case 11:
                BaseProcessor baseProcessor = (BaseProcessor) obj3;
                String str6 = (String) obj2;
                baseProcessor.getClass();
                try {
                    com.google.gson.q asJsonObject = com.google.gson.r.parseString(String.valueOf((String) obj)).getAsJsonObject();
                    if (asJsonObject.get("status").getAsString().equals("success")) {
                        com.google.gson.l asJsonArray = asJsonObject.get("content").getAsJsonArray();
                        for (int i23 = 0; i23 < asJsonArray.size(); i23++) {
                            com.google.gson.q asJsonObject2 = asJsonArray.get(i23).getAsJsonObject();
                            try {
                                String asString = asJsonObject2.get("stream_link").getAsString();
                                if (asString != null && asString.length() > 10) {
                                    int asInt = asJsonObject2.get("size").getAsInt();
                                    String str7 = (asInt == 0 || asInt == -1) ? "" : fd.e.readableFileSize(asInt);
                                    hd.o oVar2 = new hd.o();
                                    oVar2.f13047w = true;
                                    oVar2.C = "[PREMIUMIZE.ME] [FAST] [" + str7 + "]";
                                    oVar2.D = asString;
                                    oVar2.f13036b = baseProcessor.getOriginalName(str6);
                                    oVar2.A = true;
                                    LinksActivity.setRDQtyLabel(oVar2);
                                    if (oVar2.f13043s == 0) {
                                        oVar2.f13043s = HttpStatus.SC_MULTIPLE_CHOICES;
                                    }
                                    baseProcessor.addLink(oVar2);
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        break;
                    } else {
                        break;
                    }
                } catch (Exception e10) {
                    try {
                        Log.d(MovieDetailActivity.class.toString(), "", e10);
                        return;
                    } catch (Exception e11) {
                        Log.d(MovieDetailActivity.class.toString(), "", e11);
                        return;
                    }
                }
                break;
            case 12:
                td.c cVar2 = (td.c) obj3;
                jd.b bVar5 = (jd.b) obj2;
                cVar2.getClass();
                String strValueOf = String.valueOf((String) obj);
                try {
                    hd.o oVar3 = new hd.o();
                    oVar3.D = strValueOf;
                    oVar3.f13047w = true;
                    oVar3.f13043s = 1080;
                    if (bVar5.f14693b.contains("English")) {
                        oVar3.f13037m = true;
                    } else {
                        oVar3.f13038n = true;
                    }
                    oVar3.C = "1080p - [FVSTREAM] - [DIRECT] - " + bVar5.f14693b;
                    cVar2.f12431b.OnSuccess(oVar3);
                    if (bVar5.f14693b.contains("English")) {
                        new pd.c(cVar2.f19890f, cVar2.f12431b).process(oVar3);
                        break;
                    }
                } catch (Exception e12) {
                    try {
                        Log.d(MovieDetailActivity.class.toString(), "", e12);
                        return;
                    } catch (Exception e13) {
                        Log.d(MovieDetailActivity.class.toString(), "", e13);
                        return;
                    }
                }
                break;
            case 13:
                td.f fVar = (td.f) obj3;
                jd.b bVar6 = (jd.b) obj2;
                fVar.getClass();
                String strValueOf2 = String.valueOf((String) obj);
                try {
                    hd.o oVar4 = new hd.o();
                    oVar4.D = strValueOf2;
                    oVar4.f13047w = true;
                    oVar4.f13043s = 1080;
                    if (bVar6.f14693b.contains("English")) {
                        oVar4.f13037m = true;
                    } else {
                        oVar4.f13038n = true;
                    }
                    oVar4.C = "1080p - [FVSTREAM] - [DIRECT] - " + bVar6.f14693b;
                    oVar4.f13045u = bVar6.f14693b;
                    fVar.f12431b.OnSuccess(oVar4);
                    if (bVar6.f14693b.contains("English")) {
                        new pd.c(fVar.f19902f, fVar.f12431b).process(oVar4);
                        break;
                    }
                } catch (Exception e14) {
                    try {
                        Log.d(MovieDetailActivity.class.toString(), "", e14);
                        return;
                    } catch (Exception e15) {
                        Log.d(MovieDetailActivity.class.toString(), "", e15);
                        return;
                    }
                }
                break;
            case 14:
                wd.c cVar3 = (wd.c) obj3;
                cVar3.getClass();
                new wd.d(cVar3, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            case 15:
                wd.f fVar2 = (wd.f) obj3;
                fVar2.getClass();
                new wd.g(fVar2, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            case 16:
                wd.i iVar = (wd.i) obj3;
                iVar.getClass();
                new wd.j(iVar, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            case 17:
                wd.m mVar = (wd.m) obj3;
                mVar.getClass();
                new wd.n(mVar, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            case 18:
                wd.p pVar = (wd.p) obj3;
                pVar.getClass();
                new wd.q(pVar, String.valueOf((String) obj), (String) obj2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
        }
    }
}
