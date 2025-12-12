package q2;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* compiled from: ObjectAnimatorUtils.java */
/* loaded from: classes.dex */
public final class c {
    public static <T, V> ObjectAnimator a(T t10, Property<T, V> property, Path path) {
        return ObjectAnimator.ofObject(t10, property, (TypeConverter) null, path);
    }
}
