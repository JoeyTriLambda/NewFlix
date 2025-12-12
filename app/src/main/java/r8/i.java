package r8;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18708a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f18708a) {
            case 0:
                return str.startsWith("aqs.");
            case 1:
                return str.startsWith(".ae");
            case 2:
                Charset charset = w8.a.f21028e;
                return str.startsWith("event") && !str.endsWith("_");
            default:
                Charset charset2 = w8.a.f21028e;
                return str.startsWith("event");
        }
    }
}
