package a;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import sh.b;
import yf.a;

/* loaded from: classes.dex */
public final class u extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f22b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Context context) {
        super(0);
        this.f22b = context;
    }

    @Override // yf.a
    public final Object invoke() {
        return b.parametersOf(this.f22b);
    }
}
