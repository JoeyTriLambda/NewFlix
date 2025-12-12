package r;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.R;
import w.b;

/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    public interface b {
        void onMenuVisibilityChanged(boolean z10);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    public static abstract class c {
        public abstract void a();
    }

    public boolean closeOptionsMenu() {
        return false;
    }

    public abstract boolean collapseActionView();

    public abstract void dispatchMenuVisibilityChanged(boolean z10);

    public abstract int getDisplayOptions();

    public abstract Context getThemedContext();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public abstract boolean onKeyShortcut(int i10, KeyEvent keyEvent);

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void setDefaultDisplayHomeAsUpEnabled(boolean z10);

    public abstract void setDisplayHomeAsUpEnabled(boolean z10);

    public abstract void setHomeActionContentDescription(int i10);

    public abstract void setHomeAsUpIndicator(int i10);

    public abstract void setHomeAsUpIndicator(Drawable drawable);

    public abstract void setHomeButtonEnabled(boolean z10);

    public abstract void setShowHideAnimationEnabled(boolean z10);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(CharSequence charSequence);

    public abstract void setWindowTitle(CharSequence charSequence);

    public w.b startActionMode(b.a aVar) {
        return null;
    }

    /* compiled from: ActionBar.java */
    /* renamed from: r.a$a, reason: collision with other inner class name */
    public static class C0232a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f18154a;

        public C0232a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f18154a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f18154a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0232a(int i10, int i11) {
            super(i10, i11);
            this.f18154a = 8388627;
        }

        public C0232a(C0232a c0232a) {
            super((ViewGroup.MarginLayoutParams) c0232a);
            this.f18154a = 0;
            this.f18154a = c0232a.f18154a;
        }

        public C0232a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f18154a = 0;
        }
    }

    public void a() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }
}
