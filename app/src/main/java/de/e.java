package de;

import java.io.OutputStream;
import kg.e0;
import kg.h0;
import kg.s0;
import zf.i;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f11016a;

    public e(OutputStream outputStream) {
        i.checkNotNullParameter(outputStream, "outputStream");
        this.f11016a = outputStream;
        int i10 = e0.f15105h;
        h0.CoroutineScope(s0.getIO().limitedParallelism(1).plus(new d(e0.b.f15106b)));
    }
}
