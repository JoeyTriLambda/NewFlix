package flix.com.vision.exomedia.core.video.scale;

/* loaded from: classes2.dex */
public enum ScaleType {
    CENTER,
    CENTER_CROP,
    CENTER_INSIDE,
    FIT_CENTER,
    NONE;

    public static ScaleType fromOrdinal(int i10) {
        return (i10 < 0 || i10 > 4) ? NONE : values()[i10];
    }
}
