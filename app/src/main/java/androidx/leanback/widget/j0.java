package androidx.leanback.widget;

/* compiled from: Row.java */
/* loaded from: classes.dex */
public class j0 {

    /* renamed from: b, reason: collision with root package name */
    public m f3278b;

    /* renamed from: a, reason: collision with root package name */
    public int f3277a = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f3279c = -1;

    public j0(m mVar) {
        setHeaderItem(mVar);
    }

    public final m getHeaderItem() {
        return this.f3278b;
    }

    public final long getId() {
        if ((this.f3277a & 1) != 1) {
            return this.f3279c;
        }
        m headerItem = getHeaderItem();
        if (headerItem != null) {
            return headerItem.getId();
        }
        return -1L;
    }

    public final void setHeaderItem(m mVar) {
        this.f3278b = mVar;
    }

    public final void setId(long j10) {
        this.f3279c = j10;
        this.f3277a = (this.f3277a & (-2)) | 0;
    }

    public j0() {
    }
}
