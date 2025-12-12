package androidx.leanback.widget;

/* compiled from: SearchBar.java */
/* loaded from: classes.dex */
public final class n0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3310b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SearchBar f3311m;

    public n0(SearchBar searchBar, int i10) {
        this.f3311m = searchBar;
        this.f3310b = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        SearchBar searchBar = this.f3311m;
        searchBar.E.play(searchBar.F.get(this.f3310b), 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
