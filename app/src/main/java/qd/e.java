package qd;

import android.os.Handler;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import cz.msebera.android.httpclient.HttpStatus;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayDeque;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18095b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BaseProcessor f18096m;

    public /* synthetic */ e(BaseProcessor baseProcessor, int i10) {
        this.f18095b = i10;
        this.f18096m = baseProcessor;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f18095b;
        BaseProcessor baseProcessor = this.f18096m;
        switch (i10) {
            case 0:
                baseProcessor.getClass();
                com.google.gson.l asJsonArray = ((com.google.gson.o) obj).getAsJsonObject().get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("magnets").getAsJsonArray();
                int i11 = 0;
                while (true) {
                    int size = asJsonArray.size();
                    ArrayDeque<Integer> arrayDeque = baseProcessor.f12434e;
                    if (i11 >= size) {
                        if (arrayDeque.size() > 0) {
                            new Handler().postDelayed(new vb.d(baseProcessor, 5), 10000L);
                            break;
                        }
                    } else {
                        com.google.gson.q asJsonObject = asJsonArray.get(i11).getAsJsonObject();
                        if (asJsonObject.get("ready").getAsBoolean()) {
                            arrayDeque.add(Integer.valueOf(asJsonObject.get("id").getAsInt()));
                        }
                        i11++;
                    }
                }
                break;
            default:
                baseProcessor.getClass();
                com.google.gson.q asJsonObject2 = ((com.google.gson.o) obj).getAsJsonObject();
                String asString = asJsonObject2.get("status").getAsString();
                if (asString != null && asString.equals("success")) {
                    com.google.gson.q asJsonObject3 = asJsonObject2.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject();
                    String asString2 = asJsonObject3.get("link").getAsString();
                    long asLong = asJsonObject3.get("filesize").getAsLong();
                    if (asLong >= 100000000) {
                        String str = (asLong == 0 || asLong == -1) ? "" : fd.e.readableFileSize(asLong);
                        hd.o oVar = new hd.o();
                        oVar.f13047w = true;
                        oVar.C = ac.c.k("[ALLDEBRID] [FAST] [", str, "]");
                        oVar.D = asString2;
                        oVar.B = true;
                        LinksActivity.setRDQtyLabel(oVar);
                        if (oVar.f13043s == 0) {
                            oVar.f13043s = HttpStatus.SC_MULTIPLE_CHOICES;
                        }
                        baseProcessor.addLink(oVar);
                        break;
                    }
                }
                break;
        }
    }
}
