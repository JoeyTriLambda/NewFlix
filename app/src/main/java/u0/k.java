package u0;

import java.util.ArrayList;
import u0.l;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public final class k implements w0.a<l.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19949a;

    public k(String str) {
        this.f19949a = str;
    }

    @Override // w0.a
    public void accept(l.a aVar) {
        synchronized (l.f19952c) {
            b0.k<String, ArrayList<w0.a<l.a>>> kVar = l.f19953d;
            ArrayList<w0.a<l.a>> arrayList = kVar.get(this.f19949a);
            if (arrayList == null) {
                return;
            }
            kVar.remove(this.f19949a);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                arrayList.get(i10).accept(aVar);
            }
        }
    }
}
