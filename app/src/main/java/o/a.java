package o;

/* loaded from: classes2.dex */
public final class a extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super("sessionId=" + str);
        zf.i.checkNotNullParameter(str, "id");
    }
}
