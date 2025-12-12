package i6;

import android.text.Layout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l6.u;

/* compiled from: WebvttCssStyle.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f13221a;

    /* renamed from: b, reason: collision with root package name */
    public String f13222b;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f13223c;

    /* renamed from: d, reason: collision with root package name */
    public String f13224d;

    /* renamed from: e, reason: collision with root package name */
    public String f13225e;

    /* renamed from: f, reason: collision with root package name */
    public int f13226f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13227g;

    /* renamed from: h, reason: collision with root package name */
    public int f13228h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13229i;

    /* renamed from: j, reason: collision with root package name */
    public int f13230j;

    /* renamed from: k, reason: collision with root package name */
    public int f13231k;

    /* renamed from: l, reason: collision with root package name */
    public int f13232l;

    /* renamed from: m, reason: collision with root package name */
    public int f13233m;

    /* renamed from: n, reason: collision with root package name */
    public int f13234n;

    public d() {
        reset();
    }

    public static int a(int i10, int i11, String str, String str2) {
        if (str.isEmpty() || i10 == -1) {
            return i10;
        }
        if (str.equals(str2)) {
            return i10 + i11;
        }
        return -1;
    }

    public int getBackgroundColor() {
        if (this.f13229i) {
            return this.f13228h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public int getFontColor() {
        if (this.f13227g) {
            return this.f13226f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String getFontFamily() {
        return this.f13225e;
    }

    public float getFontSize() {
        return 0.0f;
    }

    public int getFontSizeUnit() {
        return this.f13234n;
    }

    public int getSpecificityScore(String str, String str2, String[] strArr, String str3) {
        if (this.f13221a.isEmpty() && this.f13222b.isEmpty() && this.f13223c.isEmpty() && this.f13224d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int iA = a(a(a(0, 1073741824, this.f13221a, str), 2, this.f13222b, str2), 4, this.f13224d, str3);
        if (iA == -1 || !Arrays.asList(strArr).containsAll(this.f13223c)) {
            return 0;
        }
        return (this.f13223c.size() * 4) + iA;
    }

    public int getStyle() {
        int i10 = this.f13232l;
        if (i10 == -1 && this.f13233m == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f13233m == 1 ? 2 : 0);
    }

    public Layout.Alignment getTextAlign() {
        return null;
    }

    public boolean hasBackgroundColor() {
        return this.f13229i;
    }

    public boolean hasFontColor() {
        return this.f13227g;
    }

    public boolean isLinethrough() {
        return this.f13230j == 1;
    }

    public boolean isUnderline() {
        return this.f13231k == 1;
    }

    public void reset() {
        this.f13221a = "";
        this.f13222b = "";
        this.f13223c = Collections.emptyList();
        this.f13224d = "";
        this.f13225e = null;
        this.f13227g = false;
        this.f13229i = false;
        this.f13230j = -1;
        this.f13231k = -1;
        this.f13232l = -1;
        this.f13233m = -1;
        this.f13234n = -1;
    }

    public d setBackgroundColor(int i10) {
        this.f13228h = i10;
        this.f13229i = true;
        return this;
    }

    public d setBold(boolean z10) {
        this.f13232l = z10 ? 1 : 0;
        return this;
    }

    public d setFontColor(int i10) {
        this.f13226f = i10;
        this.f13227g = true;
        return this;
    }

    public d setFontFamily(String str) {
        this.f13225e = u.toLowerInvariant(str);
        return this;
    }

    public d setItalic(boolean z10) {
        this.f13233m = z10 ? 1 : 0;
        return this;
    }

    public void setTargetClasses(String[] strArr) {
        this.f13223c = Arrays.asList(strArr);
    }

    public void setTargetId(String str) {
        this.f13221a = str;
    }

    public void setTargetTagName(String str) {
        this.f13222b = str;
    }

    public void setTargetVoice(String str) {
        this.f13224d = str;
    }

    public d setUnderline(boolean z10) {
        this.f13231k = z10 ? 1 : 0;
        return this;
    }
}
