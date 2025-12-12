package t3;

import a4.d;
import a4.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p3.g;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f19395d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f19396a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19397b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, g> f19398c;

    public b(Drawable.Callback callback, String str, p3.b bVar, Map<String, g> map) {
        this.f19397b = str;
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f19397b = str + JsonPointer.SEPARATOR;
        }
        if (callback instanceof View) {
            this.f19396a = ((View) callback).getContext();
            this.f19398c = map;
            setDelegate(bVar);
        } else {
            d.warning("LottieDrawable must be inside of a view for images to work.");
            this.f19398c = new HashMap();
            this.f19396a = null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        synchronized (f19395d) {
            this.f19398c.get(str).setBitmap(bitmap);
        }
    }

    public Bitmap bitmapForId(String str) {
        String str2 = this.f19397b;
        g gVar = this.f19398c.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        String fileName = gVar.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                synchronized (f19395d) {
                    this.f19398c.get(str).setBitmap(bitmapDecodeByteArray);
                }
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e10) {
                d.warning("data URL did not have correct base64 format.", e10);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapResizeBitmapIfNeeded = h.resizeBitmapIfNeeded(BitmapFactory.decodeStream(this.f19396a.getAssets().open(str2 + fileName), null, options), gVar.getWidth(), gVar.getHeight());
            a(str, bitmapResizeBitmapIfNeeded);
            return bitmapResizeBitmapIfNeeded;
        } catch (IOException e11) {
            d.warning("Unable to open asset.", e11);
            return null;
        }
    }

    public boolean hasSameContext(Context context) {
        Context context2 = this.f19396a;
        return (context == null && context2 == null) || context2.equals(context);
    }

    public void setDelegate(p3.b bVar) {
    }
}
