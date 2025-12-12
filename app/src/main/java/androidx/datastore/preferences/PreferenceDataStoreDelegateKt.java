package androidx.datastore.preferences;

import android.content.Context;
import com.unity3d.ads.metadata.MediationMetaData;
import i1.c;
import i1.d;
import j1.b;
import java.util.List;
import kg.g0;
import kg.g2;
import kg.h0;
import kg.s0;
import mf.k;
import yf.l;
import zf.i;

/* compiled from: PreferenceDataStoreDelegate.kt */
/* loaded from: classes.dex */
public final class PreferenceDataStoreDelegateKt {
    public static final cg.a<Context, d<l1.a>> preferencesDataStore(String str, b<l1.a> bVar, l<? super Context, ? extends List<? extends c<l1.a>>> lVar, g0 g0Var) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(lVar, "produceMigrations");
        i.checkNotNullParameter(g0Var, "scope");
        return new PreferenceDataStoreSingletonDelegate(str, bVar, lVar, g0Var);
    }

    public static /* synthetic */ cg.a preferencesDataStore$default(String str, b bVar, l lVar, g0 g0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar = new l<Context, List<? extends c<l1.a>>>() { // from class: androidx.datastore.preferences.PreferenceDataStoreDelegateKt.preferencesDataStore.1
                @Override // yf.l
                public final List<c<l1.a>> invoke(Context context) {
                    i.checkNotNullParameter(context, "it");
                    return k.emptyList();
                }
            };
        }
        if ((i10 & 8) != 0) {
            g0Var = h0.CoroutineScope(s0.getIO().plus(g2.SupervisorJob$default(null, 1, null)));
        }
        return preferencesDataStore(str, bVar, lVar, g0Var);
    }
}
