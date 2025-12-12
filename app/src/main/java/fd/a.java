package fd;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import sa.j;

/* compiled from: CircleTransform.java */
/* loaded from: classes2.dex */
public final class a implements j {
    @Override // sa.j
    public String key() {
        return "circle";
    }

    @Override // sa.j
    public Bitmap transform(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f10 = iMin / 2.0f;
        canvas.drawCircle(f10, f10, f10, paint);
        bitmapCreateBitmap.recycle();
        return bitmapCreateBitmap2;
    }
}
