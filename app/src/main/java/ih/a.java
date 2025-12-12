package ih;

import android.content.Context;
import org.koin.android.error.MissingAndroidContextException;
import org.koin.core.scope.Scope;
import zf.i;
import zf.k;

/* compiled from: ModuleExt.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final Context androidContext(Scope scope) throws MissingAndroidContextException {
        i.checkNotNullParameter(scope, "<this>");
        try {
            return (Context) scope.get(k.getOrCreateKotlinClass(Context.class), null, null);
        } catch (Exception unused) {
            throw new MissingAndroidContextException("Can't resolve Context instance. Please use androidContext() function in your KoinApplication configuration.");
        }
    }
}
