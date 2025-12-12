package c4;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import l7.c;

/* compiled from: FontUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static void a(MenuItem menuItem, Typeface typeface) {
        SpannableString spannableString = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new b("", typeface), 0, spannableString.length(), 18);
        menuItem.setTitle(spannableString);
    }

    public void applyFontToMenu(Menu menu, Typeface typeface) {
        for (int i10 = 0; i10 < menu.size(); i10++) {
            MenuItem item = menu.getItem(i10);
            SubMenu subMenu = item.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int i11 = 0; i11 < subMenu.size(); i11++) {
                    a(subMenu.getItem(i11), typeface);
                }
            }
            a(item, typeface);
        }
    }

    public void applyFontToNavigationView(c cVar, Typeface typeface) {
        applyFontToMenu(cVar.getMenu(), typeface);
    }

    public void applyFontToToolbar(Toolbar toolbar, Typeface typeface) {
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTypeface(typeface);
                return;
            }
        }
    }

    public void applyFontToView(View view, Typeface typeface) {
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(typeface);
        }
    }
}
