package q;

import android.content.Context;
import android.content.Intent;
import zf.i;

/* compiled from: ActivityResultContract.kt */
/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* renamed from: q.a$a, reason: collision with other inner class name */
    public static final class C0227a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f17773a;

        public C0227a(T t10) {
            this.f17773a = t10;
        }

        public final T getValue() {
            return this.f17773a;
        }
    }

    public abstract Intent createIntent(Context context, I i10);

    public C0227a<O> getSynchronousResult(Context context, I i10) {
        i.checkNotNullParameter(context, "context");
        return null;
    }

    public abstract O parseResult(int i10, Intent intent);
}
