package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f1253a;

    /* compiled from: ActionBarBackgroundDrawable.java */
    public static class a {
        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1253a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1253a;
        if (actionBarContainer.f1076s) {
            Drawable drawable = actionBarContainer.f1075r;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1073p;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f1074q;
        if (drawable3 == null || !actionBarContainer.f1077t) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f1253a;
        if (actionBarContainer.f1076s) {
            if (actionBarContainer.f1075r != null) {
                a.getOutline(actionBarContainer.f1073p, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f1073p;
            if (drawable != null) {
                a.getOutline(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
