package g6;

import android.text.Layout;

/* compiled from: TtmlStyle.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public String f12758a;

    /* renamed from: b, reason: collision with root package name */
    public int f12759b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12760c;

    /* renamed from: d, reason: collision with root package name */
    public int f12761d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12762e;

    /* renamed from: f, reason: collision with root package name */
    public int f12763f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f12764g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f12765h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f12766i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f12767j = -1;

    /* renamed from: k, reason: collision with root package name */
    public float f12768k;

    /* renamed from: l, reason: collision with root package name */
    public String f12769l;

    /* renamed from: m, reason: collision with root package name */
    public Layout.Alignment f12770m;

    public e chain(e eVar) {
        if (eVar != null) {
            if (!this.f12760c && eVar.f12760c) {
                setFontColor(eVar.f12759b);
            }
            if (this.f12765h == -1) {
                this.f12765h = eVar.f12765h;
            }
            if (this.f12766i == -1) {
                this.f12766i = eVar.f12766i;
            }
            if (this.f12758a == null) {
                this.f12758a = eVar.f12758a;
            }
            if (this.f12763f == -1) {
                this.f12763f = eVar.f12763f;
            }
            if (this.f12764g == -1) {
                this.f12764g = eVar.f12764g;
            }
            if (this.f12770m == null) {
                this.f12770m = eVar.f12770m;
            }
            if (this.f12767j == -1) {
                this.f12767j = eVar.f12767j;
                this.f12768k = eVar.f12768k;
            }
            if (!this.f12762e && eVar.f12762e) {
                setBackgroundColor(eVar.f12761d);
            }
        }
        return this;
    }

    public int getBackgroundColor() {
        if (this.f12762e) {
            return this.f12761d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int getFontColor() {
        if (this.f12760c) {
            return this.f12759b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String getFontFamily() {
        return this.f12758a;
    }

    public float getFontSize() {
        return this.f12768k;
    }

    public int getFontSizeUnit() {
        return this.f12767j;
    }

    public String getId() {
        return this.f12769l;
    }

    public int getStyle() {
        int i10 = this.f12765h;
        if (i10 == -1 && this.f12766i == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f12766i == 1 ? 2 : 0);
    }

    public Layout.Alignment getTextAlign() {
        return this.f12770m;
    }

    public boolean hasBackgroundColor() {
        return this.f12762e;
    }

    public boolean hasFontColor() {
        return this.f12760c;
    }

    public boolean isLinethrough() {
        return this.f12763f == 1;
    }

    public boolean isUnderline() {
        return this.f12764g == 1;
    }

    public e setBackgroundColor(int i10) {
        this.f12761d = i10;
        this.f12762e = true;
        return this;
    }

    public e setBold(boolean z10) {
        l6.a.checkState(true);
        this.f12765h = z10 ? 1 : 0;
        return this;
    }

    public e setFontColor(int i10) {
        l6.a.checkState(true);
        this.f12759b = i10;
        this.f12760c = true;
        return this;
    }

    public e setFontFamily(String str) {
        l6.a.checkState(true);
        this.f12758a = str;
        return this;
    }

    public e setFontSize(float f10) {
        this.f12768k = f10;
        return this;
    }

    public e setFontSizeUnit(int i10) {
        this.f12767j = i10;
        return this;
    }

    public e setId(String str) {
        this.f12769l = str;
        return this;
    }

    public e setItalic(boolean z10) {
        l6.a.checkState(true);
        this.f12766i = z10 ? 1 : 0;
        return this;
    }

    public e setLinethrough(boolean z10) {
        l6.a.checkState(true);
        this.f12763f = z10 ? 1 : 0;
        return this;
    }

    public e setTextAlign(Layout.Alignment alignment) {
        this.f12770m = alignment;
        return this;
    }

    public e setUnderline(boolean z10) {
        l6.a.checkState(true);
        this.f12764g = z10 ? 1 : 0;
        return this;
    }
}
