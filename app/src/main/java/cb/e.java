package cb;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SignalsCollectorBase.java */
/* loaded from: classes2.dex */
public abstract class e implements c {

    /* compiled from: SignalsCollectorBase.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final b f5256b;

        /* renamed from: m, reason: collision with root package name */
        public final f f5257m;

        public a(e eVar, b bVar, f fVar) {
            this.f5256b = bVar;
            this.f5257m = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = this.f5257m;
            Map<String, String> signalsMap = fVar.getSignalsMap();
            int size = signalsMap.size();
            b bVar = this.f5256b;
            if (size > 0) {
                bVar.onSignalsCollected(new JSONObject(signalsMap).toString());
            } else if (fVar.getErrorMessage() == null) {
                bVar.onSignalsCollected("");
            } else {
                bVar.onSignalsCollectionFailed(fVar.getErrorMessage());
            }
        }
    }

    public void getSCARBiddingSignals(Context context, b bVar) {
        com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a();
        f fVar = new f();
        aVar.enter();
        getSCARSignal(context, true, aVar, fVar);
        aVar.enter();
        getSCARSignal(context, false, aVar, fVar);
        aVar.notify(new a(this, bVar, fVar));
    }

    public void getSCARSignals(Context context, String[] strArr, String[] strArr2, b bVar) {
        com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a();
        f fVar = new f();
        for (String str : strArr) {
            aVar.enter();
            getSCARSignal(context, str, true, aVar, fVar);
        }
        for (String str2 : strArr2) {
            aVar.enter();
            getSCARSignal(context, str2, false, aVar, fVar);
        }
        aVar.notify(new a(this, bVar, fVar));
    }

    public void onOperationNotSupported(String str, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        fVar.setErrorMessage(String.format("Operation Not supported: %s.", str));
        aVar.leave();
    }
}
