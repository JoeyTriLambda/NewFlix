package t3;

import a4.d;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import u3.h;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public final AssetManager f19393d;

    /* renamed from: a, reason: collision with root package name */
    public final h<String> f19390a = new h<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19391b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19392c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final String f19394e = ".ttf";

    public a(Drawable.Callback callback, p3.a aVar) {
        if (callback instanceof View) {
            this.f19393d = ((View) callback).getContext().getAssets();
        } else {
            d.warning("LottieDrawable must be inside of a view for images to work.");
            this.f19393d = null;
        }
    }

    public Typeface getTypeface(String str, String str2) {
        h<String> hVar = this.f19390a;
        hVar.set(str, str2);
        HashMap map = this.f19391b;
        Typeface typeface = (Typeface) map.get(hVar);
        if (typeface != null) {
            return typeface;
        }
        HashMap map2 = this.f19392c;
        Typeface typefaceCreate = (Typeface) map2.get(str);
        if (typefaceCreate == null) {
            typefaceCreate = Typeface.createFromAsset(this.f19393d, "fonts/" + str + this.f19394e);
            map2.put(str, typefaceCreate);
        }
        boolean zContains = str2.contains("Italic");
        boolean zContains2 = str2.contains("Bold");
        int i10 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        if (typefaceCreate.getStyle() != i10) {
            typefaceCreate = Typeface.create(typefaceCreate, i10);
        }
        map.put(hVar, typefaceCreate);
        return typefaceCreate;
    }

    public void setDelegate(p3.a aVar) {
    }
}
