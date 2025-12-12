package x0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class n {

    /* compiled from: MenuItemCompat.java */
    public static class a {
        public static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        public static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        public static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        public static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        public static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        public static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        public static MenuItem g(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static MenuItem k(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        public static MenuItem l(MenuItem menuItem, char c10, char c11, int i10, int i11) {
            return menuItem.setShortcut(c10, c11, i10, i11);
        }

        public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    public static b getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof q0.b) {
            return ((q0.b) menuItem).getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static MenuItem setActionProvider(MenuItem menuItem, b bVar) {
        if (menuItem instanceof q0.b) {
            return ((q0.b) menuItem).setSupportActionProvider(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setAlphabeticShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.g(menuItem, c10, i10);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.h(menuItem, charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.i(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.j(menuItem, mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setNumericShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.k(menuItem, c10, i10);
        }
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof q0.b) {
            ((q0.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.m(menuItem, charSequence);
        }
    }
}
