package q;

import android.content.Context;
import android.content.Intent;
import zf.f;
import zf.i;

/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class c extends q.a<Intent, androidx.activity.result.a> {

    /* compiled from: ActivityResultContracts.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
    }

    @Override // q.a
    public Intent createIntent(Context context, Intent intent) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(intent, "input");
        return intent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // q.a
    public androidx.activity.result.a parseResult(int i10, Intent intent) {
        return new androidx.activity.result.a(i10, intent);
    }
}
