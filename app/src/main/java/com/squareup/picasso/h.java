package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* compiled from: ImageViewAction.java */
/* loaded from: classes2.dex */
public final class h extends a<ImageView> {

    /* renamed from: m, reason: collision with root package name */
    public sa.b f10571m;

    public h(Picasso picasso, ImageView imageView, k kVar, int i10, String str, sa.b bVar) {
        super(picasso, imageView, kVar, i10, str);
        this.f10571m = bVar;
    }

    @Override // com.squareup.picasso.a
    public final void a() {
        this.f10527l = true;
        if (this.f10571m != null) {
            this.f10571m = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.picasso.a
    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f10518c.get();
        if (imageView == null) {
            return;
        }
        Picasso picasso = this.f10516a;
        i.a(imageView, picasso.f10488c, bitmap, loadedFrom, this.f10519d, picasso.f10496k);
        sa.b bVar = this.f10571m;
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.picasso.a
    public void error(Exception exc) {
        ImageView imageView = (ImageView) this.f10518c.get();
        if (imageView == null) {
            return;
        }
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        int i10 = this.f10522g;
        if (i10 != 0) {
            imageView.setImageResource(i10);
        } else {
            Drawable drawable2 = this.f10523h;
            if (drawable2 != null) {
                imageView.setImageDrawable(drawable2);
            }
        }
        sa.b bVar = this.f10571m;
        if (bVar != null) {
            bVar.onError(exc);
        }
    }
}
