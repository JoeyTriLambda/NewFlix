package ig;

/* compiled from: Appendable.kt */
/* loaded from: classes2.dex */
public class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(Appendable appendable, T t10, yf.l<? super T, ? extends CharSequence> lVar) {
        zf.i.checkNotNullParameter(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t10));
            return;
        }
        if (t10 == 0 ? true : t10 instanceof CharSequence) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }
}
