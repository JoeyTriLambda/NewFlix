package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import w0.h;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f2133k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2134a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2135b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2136c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2137d;

    /* renamed from: e, reason: collision with root package name */
    public int f2138e;

    /* renamed from: f, reason: collision with root package name */
    public int f2139f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2140g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2141h;

    /* renamed from: i, reason: collision with root package name */
    public String f2142i;

    /* renamed from: j, reason: collision with root package name */
    public String f2143j;

    public static class a {
        public static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            }
        }

        public static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            }
        }

        public static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            }
        }

        public static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            }
        }

        public static Drawable e(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon f(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f2134a) {
                case -1:
                    return (Icon) iconCompat.f2135b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f2135b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.getResPackage(), iconCompat.f2138e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f2135b, iconCompat.f2138e, iconCompat.f2139f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f2135b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.f2135b, false));
                        break;
                    } else {
                        iconCreateWithBitmap = b.b((Bitmap) iconCompat.f2135b);
                        break;
                    }
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.getUri());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.getUri());
                        }
                        InputStream uriInputStream = iconCompat.getUriInputStream(context);
                        if (uriInputStream == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.getUri());
                        }
                        if (i10 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(uriInputStream), false));
                            break;
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(uriInputStream));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f2140g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f2141h;
            if (mode != IconCompat.f2133k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f2134a = -1;
        this.f2136c = null;
        this.f2137d = null;
        this.f2138e = 0;
        this.f2139f = 0;
        this.f2140g = null;
        this.f2141h = f2133k;
        this.f2142i = null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f10 = iMin;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat createFromIcon(Icon icon) {
        h.checkNotNull(icon);
        int iC = a.c(icon);
        if (iC == 2) {
            return createWithResource(null, a.b(icon), a.a(icon));
        }
        if (iC == 4) {
            return createWithContentUri(a.d(icon));
        }
        if (iC == 6) {
            return createWithAdaptiveBitmapContentUri(a.d(icon));
        }
        IconCompat iconCompat = new IconCompat(-1);
        iconCompat.f2135b = icon;
        return iconCompat;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String str) {
        w0.c.requireNonNull(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f2135b = str;
        return iconCompat;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        w0.c.requireNonNull(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2135b = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithContentUri(String str) {
        w0.c.requireNonNull(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f2135b = str;
        return iconCompat;
    }

    public static IconCompat createWithResource(Context context, int i10) {
        w0.c.requireNonNull(context);
        return createWithResource(context.getResources(), context.getPackageName(), i10);
    }

    public Bitmap getBitmap() {
        int i10 = this.f2134a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2135b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f2135b;
        }
        if (i10 == 5) {
            return a((Bitmap) this.f2135b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        int i10 = this.f2134a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f2135b);
        }
        if (i10 == 2) {
            return this.f2138e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        int i10 = this.f2134a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f2135b);
        }
        if (i10 == 2) {
            String str = this.f2143j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f2135b).split(":", -1)[0] : this.f2143j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int i10 = this.f2134a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : a.c(this.f2135b);
    }

    public Uri getUri() {
        int i10 = this.f2134a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f2135b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f2135b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream getUriInputStream(Context context) {
        Uri uri = getUri();
        String scheme = uri.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception e10) {
                Log.w("IconCompat", "Unable to load image from URI: " + uri, e10);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f2135b));
        } catch (FileNotFoundException e11) {
            Log.w("IconCompat", "Unable to load image from path: " + uri, e11);
            return null;
        }
    }

    public void onPostParceling() {
        this.f2141h = PorterDuff.Mode.valueOf(this.f2142i);
        switch (this.f2134a) {
            case -1:
                Parcelable parcelable = this.f2137d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f2135b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2137d;
                if (parcelable2 != null) {
                    this.f2135b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2136c;
                this.f2135b = bArr;
                this.f2134a = 3;
                this.f2138e = 0;
                this.f2139f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2136c, Charset.forName("UTF-16"));
                this.f2135b = str;
                if (this.f2134a == 2 && this.f2143j == null) {
                    this.f2143j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2135b = this.f2136c;
                return;
        }
    }

    public void onPreParceling(boolean z10) {
        this.f2142i = this.f2141h.name();
        switch (this.f2134a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f2137d = (Parcelable) this.f2135b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f2137d = (Parcelable) this.f2135b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f2135b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f2136c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f2136c = ((String) this.f2135b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2136c = (byte[]) this.f2135b;
                return;
            case 4:
            case 6:
                this.f2136c = this.f2135b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    public String toString() {
        String str;
        if (this.f2134a == -1) {
            return String.valueOf(this.f2135b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f2134a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb2.append(str);
        switch (this.f2134a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f2135b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f2135b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f2143j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(getResId())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f2138e);
                if (this.f2139f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f2139f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f2135b);
                break;
        }
        if (this.f2140g != null) {
            sb2.append(" tint=");
            sb2.append(this.f2140g);
        }
        if (this.f2141h != f2133k) {
            sb2.append(" mode=");
            sb2.append(this.f2141h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public Icon toIcon(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public static IconCompat createWithResource(Resources resources, String str, int i10) {
        w0.c.requireNonNull(str);
        if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2138e = i10;
            if (resources != null) {
                try {
                    iconCompat.f2135b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2135b = str;
            }
            iconCompat.f2143j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri uri) {
        w0.c.requireNonNull(uri);
        return createWithAdaptiveBitmapContentUri(uri.toString());
    }

    public static IconCompat createWithContentUri(Uri uri) {
        w0.c.requireNonNull(uri);
        return createWithContentUri(uri.toString());
    }

    public IconCompat(int i10) {
        this.f2136c = null;
        this.f2137d = null;
        this.f2138e = 0;
        this.f2139f = 0;
        this.f2140g = null;
        this.f2141h = f2133k;
        this.f2142i = null;
        this.f2134a = i10;
    }
}
