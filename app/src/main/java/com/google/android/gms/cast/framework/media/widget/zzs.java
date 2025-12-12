package com.google.android.gms.cast.framework.media.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.google.android.gms.cast.internal.Logger;
import p0.a;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzs {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f6717a = new Logger("WidgetUtil");

    public static Drawable a(Context context, int i10, int i11, int i12, int i13) {
        int color;
        ColorStateList colorStateList;
        Drawable drawableWrap = a.wrap(context.getResources().getDrawable(i11).mutate());
        a.setTintMode(drawableWrap, PorterDuff.Mode.SRC_IN);
        if (i10 != 0) {
            colorStateList = m0.a.getColorStateList(context, i10);
        } else {
            if (i12 != 0) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i12});
                color = typedArrayObtainStyledAttributes.getColor(0, 0);
                typedArrayObtainStyledAttributes.recycle();
            } else {
                color = m0.a.getColor(context, i13);
            }
            colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{color, o0.a.setAlphaComponent(color, 128)});
        }
        a.setTintList(drawableWrap, colorStateList);
        return drawableWrap;
    }

    @TargetApi(17)
    public static Bitmap zza(Context context, Bitmap bitmap, float f10, float f11) {
        Logger logger = f6717a;
        logger.d("Begin blurring bitmap %s, original width = %d, original height = %d.", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        int iRound = Math.round(bitmap.getWidth() * 0.25f);
        int iRound2 = Math.round(bitmap.getHeight() * 0.25f);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iRound, iRound2, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, bitmapCreateScaledBitmap.getConfig());
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(7.5f);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCreateBitmap);
        renderScriptCreate.destroy();
        logger.d("End blurring bitmap %s, original width = %d, original height = %d.", bitmapCreateScaledBitmap, Integer.valueOf(iRound), Integer.valueOf(iRound2));
        return bitmapCreateBitmap;
    }

    public static Drawable zzb(Context context, int i10, int i11) {
        return a(context, i10, i11, 0, R.color.white);
    }

    public static Drawable zzc(Context context, int i10, int i11) {
        return a(context, i10, i11, R.attr.colorForeground, 0);
    }
}
