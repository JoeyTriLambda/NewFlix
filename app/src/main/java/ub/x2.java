package ub;

import android.util.Log;
import android.widget.Toast;
import com.android.volley.Response;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpStatus;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class x2 implements se.f, Response.Listener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20320b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UserTorrentsActivity f20321m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f20322n;

    public /* synthetic */ x2(UserTorrentsActivity userTorrentsActivity, String str, int i10) {
        this.f20320b = i10;
        this.f20321m = userTorrentsActivity;
        this.f20322n = str;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20320b;
        UserTorrentsActivity userTorrentsActivity = this.f20321m;
        switch (i10) {
            case 0:
                int i11 = UserTorrentsActivity.X;
                userTorrentsActivity.getClass();
                com.google.gson.q asJsonObject = ((com.google.gson.o) obj).getAsJsonObject();
                String asString = asJsonObject.get("status").getAsString();
                if (asString != null && asString.equals("success")) {
                    com.google.gson.l asJsonArray = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("magnets").getAsJsonObject().get("links").getAsJsonArray();
                    for (int i12 = 0; i12 < asJsonArray.size(); i12++) {
                        com.google.gson.q asJsonObject2 = asJsonArray.get(i12).getAsJsonObject();
                        if (asJsonObject2.get("size").getAsLong() > 1705604) {
                            userTorrentsActivity.unlockLinkAllRebrid(asJsonObject2.get("link").getAsString());
                        }
                    }
                    if (userTorrentsActivity.W.size() == 0) {
                        kc.d dVar = userTorrentsActivity.V;
                        if (dVar != null) {
                            try {
                                dVar.dismiss();
                            } catch (Exception unused) {
                            }
                        }
                        Toast.makeText(userTorrentsActivity, "Not available to stream", 0).show();
                        break;
                    }
                }
                break;
            default:
                Throwable th2 = (Throwable) obj;
                int i13 = UserTorrentsActivity.X;
                kc.d dVar2 = userTorrentsActivity.V;
                if (dVar2 != null) {
                    try {
                        dVar2.dismiss();
                    } catch (Exception unused2) {
                    }
                }
                Log.d(MainActivity.class.toString(), this.f20322n, th2);
                break;
        }
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) {
        String str = this.f20322n;
        int i10 = UserTorrentsActivity.X;
        UserTorrentsActivity userTorrentsActivity = this.f20321m;
        userTorrentsActivity.getClass();
        String strValueOf = String.valueOf((String) obj);
        ArrayList<hd.o> arrayList = new ArrayList<>();
        try {
            com.google.gson.q asJsonObject = com.google.gson.r.parseString(strValueOf).getAsJsonObject();
            if (asJsonObject.get("status").getAsString().equals("success")) {
                com.google.gson.l asJsonArray = asJsonObject.get("content").getAsJsonArray();
                for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
                    com.google.gson.q asJsonObject2 = asJsonArray.get(i11).getAsJsonObject();
                    String asString = asJsonObject2.get("stream_link").getAsString();
                    if (asString != null && asString.length() > 10) {
                        int asInt = asJsonObject2.get("size").getAsInt();
                        String str2 = (asInt == 0 || asInt == -1) ? "" : fd.e.readableFileSize(asInt);
                        hd.o oVar = new hd.o();
                        oVar.f13047w = true;
                        oVar.C = "[PREMIUMIZE.ME] [FAST] [" + str2 + "]";
                        oVar.D = asString;
                        oVar.A = true;
                        LinksActivity.setRDQtyLabel(oVar);
                        if (oVar.f13043s == 0) {
                            oVar.f13043s = HttpStatus.SC_MULTIPLE_CHOICES;
                        }
                        arrayList.add(oVar);
                    }
                }
                if (arrayList.size() > 0) {
                    userTorrentsActivity.T.put(str, arrayList);
                    userTorrentsActivity.d(arrayList);
                }
            }
        } catch (Exception e10) {
            try {
                Log.d(MovieDetailActivity.class.toString(), "", e10);
            } catch (Exception e11) {
                Log.d(MovieDetailActivity.class.toString(), "", e11);
            }
        }
    }
}
