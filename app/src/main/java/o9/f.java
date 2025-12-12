package o9;

import android.content.Context;
import o9.g;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements l8.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17056a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f17057b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17058c;

    public /* synthetic */ f(String str, int i10, Object obj) {
        this.f17056a = i10;
        this.f17057b = str;
        this.f17058c = obj;
    }

    @Override // l8.g
    public final Object create(l8.d dVar) {
        int i10 = this.f17056a;
        String str = this.f17057b;
        Object obj = this.f17058c;
        switch (i10) {
            case 0:
                return new a(str, ((pd.a) ((g.a) obj)).c((Context) dVar.get(Context.class)));
            default:
                l8.b bVar = (l8.b) obj;
                try {
                    t9.b.pushTrace(str);
                    return bVar.getFactory().create(dVar);
                } finally {
                    t9.b.popTrace();
                }
        }
    }
}
