package e7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: DrawableUtils.java */
    /* renamed from: e7.a$a, reason: collision with other inner class name */
    public static class C0136a {
        public static void a(Outline outline, Path path) {
            outline.setConvexPath(path);
        }
    }

    /* compiled from: DrawableUtils.java */
    public static class b {
        public static void a(Outline outline, Path path) {
            outline.setPath(path);
        }
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable drawable, Drawable drawable2) {
        return compositeTwoLayeredDrawable(drawable, drawable2, -1, -1);
    }

    public static Drawable createTintableMutatedDrawableIfNeeded(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        boolean z10 = Build.VERSION.SDK_INT < 23;
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (!z10) {
                return drawable;
            }
            drawable.mutate();
            return drawable;
        }
        Drawable drawableMutate = p0.a.wrap(drawable).mutate();
        if (mode == null) {
            return drawableMutate;
        }
        p0.a.setTintMode(drawableMutate, mode);
        return drawableMutate;
    }

    public static int[] getCheckedState(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int i11 = iArr[i10];
            if (i11 == 16842912) {
                return iArr;
            }
            if (i11 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i10] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static ColorStateList getColorStateListOrNull(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !(drawable instanceof ColorStateListDrawable)) {
            return null;
        }
        return ((ColorStateListDrawable) drawable).getColorStateList();
    }

    public static AttributeSet parseDrawableXml(Context context, int i10, CharSequence charSequence) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i10);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException | XmlPullParserException e10) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i10));
            notFoundException.initCause(e10);
            throw notFoundException;
        }
    }

    public static void setOutlineToPath(Outline outline, Path path) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            b.a(outline, path);
            return;
        }
        if (i10 >= 29) {
            try {
                C0136a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            C0136a.a(outline, path);
        }
    }

    public static void setTint(Drawable drawable, int i10) {
        boolean z10 = i10 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z10) {
                drawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z10) {
            p0.a.setTint(drawable, i10);
        } else {
            p0.a.setTintList(drawable, null);
        }
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable drawable, Drawable drawable2, int i10, int i11) {
        Drawable bVar = drawable2;
        int intrinsicWidth = i10;
        int intrinsicHeight = i11;
        if (drawable == null) {
            return bVar;
        }
        if (bVar == null) {
            return drawable;
        }
        boolean z10 = (intrinsicWidth == -1 || intrinsicHeight == -1) ? false : true;
        if (intrinsicWidth == -1 && (intrinsicWidth = drawable2.getIntrinsicWidth()) == -1) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (intrinsicHeight == -1 && (intrinsicHeight = drawable2.getIntrinsicHeight()) == -1) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if (intrinsicWidth > drawable.getIntrinsicWidth() || intrinsicHeight > drawable.getIntrinsicHeight()) {
            float f10 = intrinsicWidth / intrinsicHeight;
            if (f10 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                intrinsicHeight = (int) (intrinsicWidth2 / f10);
                intrinsicWidth = intrinsicWidth2;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                intrinsicWidth = (int) (f10 * intrinsicHeight);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, bVar});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z10) {
            bVar = new e7.b(bVar, intrinsicWidth, intrinsicHeight);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, bVar});
        int iMax = Math.max((drawable.getIntrinsicWidth() - intrinsicWidth) / 2, 0);
        int iMax2 = Math.max((drawable.getIntrinsicHeight() - intrinsicHeight) / 2, 0);
        layerDrawable2.setLayerInset(1, iMax, iMax2, iMax, iMax2);
        return layerDrawable2;
    }
}
