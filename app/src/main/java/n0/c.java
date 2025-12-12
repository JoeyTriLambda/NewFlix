package n0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

/* compiled from: ComplexColorCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f16407a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f16408b;

    /* renamed from: c, reason: collision with root package name */
    public int f16409c;

    public c(Shader shader, ColorStateList colorStateList, int i10) {
        this.f16407a = shader;
        this.f16408b = colorStateList;
        this.f16409c = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0166, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static n0.c a(android.content.res.Resources r27, int r28, android.content.res.Resources.Theme r29) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.c.a(android.content.res.Resources, int, android.content.res.Resources$Theme):n0.c");
    }

    public static c inflate(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, i10, theme);
        } catch (Exception e10) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e10);
            return null;
        }
    }

    public int getColor() {
        return this.f16409c;
    }

    public Shader getShader() {
        return this.f16407a;
    }

    public boolean isGradient() {
        return this.f16407a != null;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return this.f16407a == null && (colorStateList = this.f16408b) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.f16408b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f16409c) {
                this.f16409c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(int i10) {
        this.f16409c = i10;
    }

    public boolean willDraw() {
        return isGradient() || this.f16409c != 0;
    }
}
