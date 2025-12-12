package kotlin.text;

import ac.c;
import kotlin.jvm.internal.Lambda;
import yf.l;
import zf.i;

/* compiled from: Indent.kt */
/* loaded from: classes2.dex */
final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements l<String, String> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15272b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$getIndentFunction$2(String str) {
        super(1);
        this.f15272b = str;
    }

    @Override // yf.l
    public final String invoke(String str) {
        i.checkNotNullParameter(str, "line");
        return c.o(new StringBuilder(), this.f15272b, str);
    }
}
