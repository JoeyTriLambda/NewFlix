package r7;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.q;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayDeque;
import java.util.HashSet;
import y0.g;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements y0.g, se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18654b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f18655m;

    public /* synthetic */ f(Object obj, int i10) {
        this.f18655m = obj;
        this.f18654b = i10;
    }

    @Override // se.f
    public final void accept(Object obj) {
        BaseProcessor baseProcessor = (BaseProcessor) this.f18655m;
        baseProcessor.getClass();
        q asJsonObject = ((o) obj).getAsJsonObject();
        String asString = asJsonObject.get("status").getAsString();
        if (asString == null || !asString.equals("success")) {
            return;
        }
        if (AllDebridCommon.f12041b == null) {
            AllDebridCommon.f12041b = new HashSet();
        }
        AllDebridCommon.f12041b.add(this.f18654b + "");
        l asJsonArray = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("magnets").getAsJsonObject().get("links").getAsJsonArray();
        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
            q asJsonObject2 = asJsonArray.get(i10).getAsJsonObject();
            if (asJsonObject2.get("size").getAsLong() > 1705604) {
                baseProcessor.unlockLinkAllRebrid(asJsonObject2.get("link").getAsString());
            }
        }
        ArrayDeque<Integer> arrayDeque = baseProcessor.f12434e;
        if (arrayDeque.size() > 0) {
            baseProcessor.a(arrayDeque.pop().intValue());
        }
    }

    @Override // y0.g
    public final boolean perform(View view, g.a aVar) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f18655m;
        int i10 = SideSheetBehavior.I;
        sideSheetBehavior.setState(this.f18654b);
        return true;
    }
}
