package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.loopj.android.http.AsyncHttpClient;

/* compiled from: AppCompatProgressBarHelper.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f1518c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final ProgressBar f1519a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f1520b;

    /* compiled from: AppCompatProgressBarHelper.java */
    public static class a {
        public static void transferLayerProperties(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i10) {
            layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
            layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
            layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
            layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
            layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
            layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
            layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
            layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
            layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
        }
    }

    public t(ProgressBar progressBar) {
        this.f1519a = progressBar;
    }

    public void a(AttributeSet attributeSet, int i10) {
        ProgressBar progressBar = this.f1519a;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(progressBar.getContext(), attributeSet, f1518c, i10, 0);
        Drawable drawableIfKnown = c1VarObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            if (drawableIfKnown instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableIfKnown;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i11 = 0; i11 < numberOfFrames; i11++) {
                    Drawable drawableB = b(animationDrawable.getFrame(i11), true);
                    drawableB.setLevel(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
                    animationDrawable2.addFrame(drawableB, animationDrawable.getDuration(i11));
                }
                animationDrawable2.setLevel(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
                drawableIfKnown = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(drawableIfKnown);
        }
        Drawable drawableIfKnown2 = c1VarObtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            progressBar.setProgressDrawable(b(drawableIfKnown2, false));
        }
        c1VarObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable b(Drawable drawable, boolean z10) {
        if (drawable instanceof p0.d) {
            p0.d dVar = (p0.d) drawable;
            Drawable wrappedDrawable = dVar.getWrappedDrawable();
            if (wrappedDrawable != null) {
                dVar.setWrappedDrawable(b(wrappedDrawable, z10));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    int id2 = layerDrawable.getId(i10);
                    drawableArr[i10] = b(layerDrawable.getDrawable(i10), id2 == 16908301 || id2 == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i11 = 0; i11 < numberOfLayers; i11++) {
                    layerDrawable2.setId(i11, layerDrawable.getId(i11));
                    if (Build.VERSION.SDK_INT >= 23) {
                        a.transferLayerProperties(layerDrawable, layerDrawable2, i11);
                    }
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f1520b == null) {
                    this.f1520b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z10 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }
}
