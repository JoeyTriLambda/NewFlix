package a;

import android.content.Context;
import com.traffmonetizer.sdk.TraffmonetizerSdkImpl;
import kotlin.jvm.internal.Lambda;
import sh.b;
import yf.a;

/* loaded from: classes.dex */
public final class t extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f20b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TraffmonetizerSdkImpl f21m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, TraffmonetizerSdkImpl traffmonetizerSdkImpl) {
        super(0);
        this.f20b = context;
        this.f21m = traffmonetizerSdkImpl;
    }

    @Override // yf.a
    public final Object invoke() {
        return b.parametersOf(this.f20b, this.f21m.f10647b);
    }
}
