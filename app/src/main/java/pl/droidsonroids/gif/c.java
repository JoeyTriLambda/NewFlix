package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: GifViewUtils.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f17768a = Arrays.asList("raw", "drawable", "mipmap");

    public static boolean a(ImageView imageView, boolean z10, int i10) throws Resources.NotFoundException {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f17768a.contains(resources.getResourceTypeName(i10))) {
                    return false;
                }
                pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(resources, i10);
                if (z10) {
                    imageView.setImageDrawable(aVar);
                    return true;
                }
                imageView.setBackground(aVar);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* compiled from: GifViewUtils.java */
    public static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        public final int f17769c;

        /* renamed from: d, reason: collision with root package name */
        public final int f17770d;

        public a(ImageView imageView, AttributeSet attributeSet) {
            super(imageView, attributeSet);
            this.f17769c = a(imageView, attributeSet, true);
            this.f17770d = a(imageView, attributeSet, false);
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z10) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z10 ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (c.f17768a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !c.a(imageView, z10, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        public a() {
            this.f17769c = 0;
            this.f17770d = 0;
        }
    }

    /* compiled from: GifViewUtils.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f17771a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17772b;

        public b(View view, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, 0, 0);
            this.f17771a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
            this.f17772b = typedArrayObtainStyledAttributes.getInt(R.styleable.GifView_loopCount, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public b() {
            this.f17771a = false;
            this.f17772b = -1;
        }
    }
}
