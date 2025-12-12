package a0;

import android.content.Context;
import android.content.res.ColorStateList;

/* compiled from: CardViewImpl.java */
/* loaded from: classes.dex */
public interface c {
    ColorStateList getBackgroundColor(b bVar);

    float getElevation(b bVar);

    float getMaxElevation(b bVar);

    float getRadius(b bVar);

    void initStatic();

    void initialize(b bVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12);

    void onCompatPaddingChanged(b bVar);

    void onPreventCornerOverlapChanged(b bVar);

    void setBackgroundColor(b bVar, ColorStateList colorStateList);

    void setElevation(b bVar, float f10);

    void setMaxElevation(b bVar, float f10);

    void setRadius(b bVar, float f10);
}
