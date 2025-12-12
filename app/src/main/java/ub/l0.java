package ub;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpStatus;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.utils.JsonUtils;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class l0 implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20223b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ LinksActivity f20224m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ hd.o f20225n;

    public /* synthetic */ l0(LinksActivity linksActivity, hd.o oVar, int i10) {
        this.f20223b = i10;
        this.f20224m = linksActivity;
        this.f20225n = oVar;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20223b;
        hd.o oVar = this.f20225n;
        LinksActivity linksActivity = this.f20224m;
        switch (i10) {
            case 0:
                int i11 = LinksActivity.C0;
                linksActivity.getClass();
                hd.o rDVideo = JsonUtils.parseRDVideo((com.google.gson.o) obj);
                if (rDVideo != null) {
                    linksActivity.f11691u0 = true;
                    LinksActivity.setRDQtyLabel(rDVideo);
                    rDVideo.f13036b = oVar.f13036b;
                    linksActivity.OnSuccess(rDVideo);
                    break;
                }
                break;
            default:
                linksActivity.f11691u0 = true;
                com.google.gson.q asJsonObject = ((com.google.gson.o) obj).getAsJsonObject();
                String asString = asJsonObject.get("status").getAsString();
                if (asString != null && asString.equals("success")) {
                    com.google.gson.q asJsonObject2 = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject();
                    String asString2 = asJsonObject2.get("link").getAsString();
                    String asString3 = asJsonObject2.get("host").getAsString();
                    long asLong = asJsonObject2.get("filesize").getAsLong();
                    if (asString3 == null || asString3.length() < 2) {
                        asString3 = "ALLDEBRID";
                    }
                    String str = (asLong == 0 || asLong == -1) ? "" : fd.e.readableFileSize(asLong);
                    hd.o oVar2 = new hd.o();
                    oVar2.f13047w = true;
                    oVar2.C = "[" + asString3.toUpperCase() + "] [ALLDEBRID] [" + str + "]";
                    oVar2.D = asString2;
                    oVar2.f13036b = oVar.f13036b;
                    oVar2.B = true;
                    LinksActivity.setRDQtyLabel(oVar2);
                    if (oVar2.f13043s == 0) {
                        oVar2.f13043s = HttpStatus.SC_MULTIPLE_CHOICES;
                    }
                    linksActivity.OnSuccess(oVar2);
                    break;
                }
                break;
        }
    }
}
