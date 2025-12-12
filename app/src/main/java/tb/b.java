package tb;

import com.google.gson.l;
import com.google.gson.o;
import flix.com.vision.App;
import java.util.ArrayDeque;
import java.util.ArrayList;
import se.f;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19881b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ App f19882m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ArrayDeque f19883n;

    public /* synthetic */ b(App app, ArrayDeque arrayDeque, int i10) {
        this.f19881b = i10;
        this.f19882m = app;
        this.f19883n = arrayDeque;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f19881b;
        ArrayDeque<String> arrayDeque = this.f19883n;
        App app = this.f19882m;
        switch (i10) {
            case 0:
                ArrayList<String> arrayList = App.B;
                app.getClass();
                l asJsonArray = ((o) obj).getAsJsonArray();
                for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
                    arrayDeque.add(asJsonArray.get(i11).getAsJsonObject().get("id").getAsString());
                }
                if (arrayDeque.size() > 0) {
                    app.deleteTorrentsRealDebridNewNew(arrayDeque);
                    break;
                }
                break;
            default:
                ArrayList<String> arrayList2 = App.B;
                app.getClass();
                if (arrayDeque.size() > 0) {
                    app.deleteTorrentsRealDebridNewNew(arrayDeque);
                    break;
                }
                break;
        }
    }
}
