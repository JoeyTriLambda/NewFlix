package tb;

import com.google.gson.l;
import com.google.gson.o;
import flix.com.vision.App;
import java.util.ArrayDeque;
import java.util.ArrayList;
import se.f;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19884b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ App f19885m;

    public /* synthetic */ c(App app, int i10) {
        this.f19884b = i10;
        this.f19885m = app;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f19884b;
        App app = this.f19885m;
        switch (i10) {
            case 0:
                ArrayList<String> arrayList = App.B;
                app.getClass();
                l asJsonArray = ((o) obj).getAsJsonArray();
                int i11 = 0;
                while (true) {
                    int size = asJsonArray.size();
                    ArrayDeque<String> arrayDeque = app.f11577y;
                    if (i11 >= size) {
                        if (arrayDeque.size() <= 0) {
                            o1.a.j(app.f11574v, "RD_CLEANED", true);
                            break;
                        } else {
                            app.deleteTorrentsRealDebrid(arrayDeque.pop());
                            break;
                        }
                    } else {
                        arrayDeque.add(asJsonArray.get(i11).getAsJsonObject().get("id").getAsString());
                        i11++;
                    }
                }
            case 1:
                ArrayDeque<String> arrayDeque2 = app.f11577y;
                if (arrayDeque2.size() > 0) {
                    app.deleteTorrentsRealDebrid(arrayDeque2.pop());
                    break;
                }
                break;
            default:
                ArrayDeque<String> arrayDeque3 = app.f11577y;
                try {
                    if (arrayDeque3.size() > 0) {
                        app.deleteTorrentsRealDebrid(arrayDeque3.pop());
                    } else {
                        app.f11574v.edit().putBoolean("RD_CLEANED", true).apply();
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
        }
    }
}
