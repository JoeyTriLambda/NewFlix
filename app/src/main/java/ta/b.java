package ta;

import android.graphics.Color;

/* compiled from: ColorUtil.java */
/* loaded from: classes2.dex */
public final class b {
    public static int getRippleColor(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        fArr[2] = fArr[2] * 0.5f;
        return Color.HSVToColor(fArr);
    }

    public static boolean isColorDark(int i10) {
        return (((double) Color.blue(i10)) * 0.114d) + ((((double) Color.green(i10)) * 0.587d) + (((double) Color.red(i10)) * 0.299d)) < 160.0d;
    }
}
