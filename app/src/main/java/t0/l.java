package t0;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: LocaleListPlatformWrapper.java */
/* loaded from: classes.dex */
public final class l implements j {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f19368a;

    public l(Object obj) {
        this.f19368a = (LocaleList) obj;
    }

    public boolean equals(Object obj) {
        return this.f19368a.equals(((j) obj).getLocaleList());
    }

    @Override // t0.j
    public Locale get(int i10) {
        return this.f19368a.get(i10);
    }

    @Override // t0.j
    public Object getLocaleList() {
        return this.f19368a;
    }

    public int hashCode() {
        return this.f19368a.hashCode();
    }

    @Override // t0.j
    public boolean isEmpty() {
        return this.f19368a.isEmpty();
    }

    @Override // t0.j
    public int size() {
        return this.f19368a.size();
    }

    @Override // t0.j
    public String toLanguageTags() {
        return this.f19368a.toLanguageTags();
    }

    public String toString() {
        return this.f19368a.toString();
    }
}
