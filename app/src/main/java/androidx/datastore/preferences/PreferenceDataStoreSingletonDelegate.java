package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import com.unity3d.ads.metadata.MediationMetaData;
import gg.g;
import i1.c;
import i1.d;
import j1.b;
import java.io.File;
import java.util.List;
import kg.g0;
import yf.l;
import zf.i;

/* compiled from: PreferenceDataStoreDelegate.kt */
/* loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements cg.a<Context, d<l1.a>> {

    /* renamed from: a, reason: collision with root package name */
    public final String f2287a;

    /* renamed from: b, reason: collision with root package name */
    public final b<l1.a> f2288b;

    /* renamed from: c, reason: collision with root package name */
    public final l<Context, List<c<l1.a>>> f2289c;

    /* renamed from: d, reason: collision with root package name */
    public final g0 f2290d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f2291e;

    /* renamed from: f, reason: collision with root package name */
    public volatile d<l1.a> f2292f;

    /* JADX WARN: Multi-variable type inference failed */
    public PreferenceDataStoreSingletonDelegate(String str, b<l1.a> bVar, l<? super Context, ? extends List<? extends c<l1.a>>> lVar, g0 g0Var) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(lVar, "produceMigrations");
        i.checkNotNullParameter(g0Var, "scope");
        this.f2287a = str;
        this.f2288b = bVar;
        this.f2289c = lVar;
        this.f2290d = g0Var;
        this.f2291e = new Object();
    }

    @Override // cg.a
    public /* bridge */ /* synthetic */ d<l1.a> getValue(Context context, g gVar) {
        return getValue2(context, (g<?>) gVar);
    }

    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public d<l1.a> getValue2(Context context, g<?> gVar) {
        d<l1.a> dVar;
        i.checkNotNullParameter(context, "thisRef");
        i.checkNotNullParameter(gVar, "property");
        d<l1.a> dVar2 = this.f2292f;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.f2291e) {
            if (this.f2292f == null) {
                final Context applicationContext = context.getApplicationContext();
                PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f2311a;
                b<l1.a> bVar = this.f2288b;
                l<Context, List<c<l1.a>>> lVar = this.f2289c;
                i.checkNotNullExpressionValue(applicationContext, "applicationContext");
                this.f2292f = preferenceDataStoreFactory.create(bVar, lVar.invoke(applicationContext), this.f2290d, new yf.a<File>() { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // yf.a
                    public final File invoke() {
                        Context context2 = applicationContext;
                        i.checkNotNullExpressionValue(context2, "applicationContext");
                        return k1.a.preferencesDataStoreFile(context2, this.f2287a);
                    }
                });
            }
            dVar = this.f2292f;
            i.checkNotNull(dVar);
        }
        return dVar;
    }
}
