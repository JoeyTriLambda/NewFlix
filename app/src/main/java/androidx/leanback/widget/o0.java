package androidx.leanback.widget;

import android.os.SystemClock;
import android.view.MotionEvent;

/* compiled from: SearchBar.java */
/* loaded from: classes.dex */
public final class o0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchBar f3312b;

    public o0(SearchBar searchBar) {
        this.f3312b = searchBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SearchBar searchBar = this.f3312b;
        searchBar.f3116b.requestFocusFromTouch();
        searchBar.f3116b.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, searchBar.f3116b.getWidth(), searchBar.f3116b.getHeight(), 0));
        searchBar.f3116b.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, searchBar.f3116b.getWidth(), searchBar.f3116b.getHeight(), 0));
    }
}
