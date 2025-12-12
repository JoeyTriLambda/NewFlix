package w;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R;

/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20777a;

    public a(Context context) {
        this.f20777a = context;
    }

    public static a get(Context context) {
        return new a(context);
    }

    public boolean enableHomeButtonByDefault() {
        return this.f20777a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.f20777a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.f20777a.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600) {
            return 5;
        }
        if (i10 > 960 && i11 > 720) {
            return 5;
        }
        if (i10 > 720 && i11 > 960) {
            return 5;
        }
        if (i10 >= 500) {
            return 4;
        }
        if (i10 > 640 && i11 > 480) {
            return 4;
        }
        if (i10 <= 480 || i11 <= 640) {
            return i10 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int getStackedTabMaxWidth() {
        return this.f20777a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        int[] iArr = R.styleable.ActionBar;
        int i10 = R.attr.actionBarStyle;
        Context context = this.f20777a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i10, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return this.f20777a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
