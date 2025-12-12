package androidx.leanback.widget;

/* compiled from: ListRow.java */
/* loaded from: classes.dex */
public final class u extends j0 {

    /* renamed from: d, reason: collision with root package name */
    public final y f3373d;

    public u(m mVar, y yVar) {
        super(mVar);
        this.f3373d = yVar;
        if (yVar == null) {
            throw new IllegalArgumentException("ObjectAdapter cannot be null");
        }
    }

    public final y getAdapter() {
        return this.f3373d;
    }

    public CharSequence getContentDescription() {
        m headerItem = getHeaderItem();
        if (headerItem == null) {
            return null;
        }
        CharSequence contentDescription = headerItem.getContentDescription();
        return contentDescription != null ? contentDescription : headerItem.getName();
    }
}
