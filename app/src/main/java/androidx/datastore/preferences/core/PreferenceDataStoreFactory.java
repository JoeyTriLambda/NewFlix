package androidx.datastore.preferences.core;

import i1.c;
import i1.d;
import i1.e;
import j1.b;
import java.io.File;
import java.util.List;
import kg.g0;
import l1.a;
import zf.i;

/* compiled from: PreferenceDataStoreFactory.kt */
/* loaded from: classes.dex */
public final class PreferenceDataStoreFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final PreferenceDataStoreFactory f2311a = new PreferenceDataStoreFactory();

    public final d<a> create(b<a> bVar, List<? extends c<a>> list, g0 g0Var, final yf.a<? extends File> aVar) {
        i.checkNotNullParameter(list, "migrations");
        i.checkNotNullParameter(g0Var, "scope");
        i.checkNotNullParameter(aVar, "produceFile");
        return new PreferenceDataStore(e.f13104a.create(l1.d.f15720a, bVar, list, g0Var, new yf.a<File>() { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // yf.a
            public final File invoke() {
                File fileInvoke = aVar.invoke();
                String extension = wf.c.getExtension(fileInvoke);
                l1.d dVar = l1.d.f15720a;
                if (i.areEqual(extension, dVar.getFileExtension())) {
                    return fileInvoke;
                }
                throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: " + dVar.getFileExtension()).toString());
            }
        }));
    }
}
