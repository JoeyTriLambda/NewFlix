package i7;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: ToolbarUtils.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13325a = new a();

    /* compiled from: ToolbarUtils.java */
    public class a implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    public static ArrayList a(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static ActionMenuView getActionMenuView(Toolbar toolbar) {
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public static ImageView getLogoImageView(Toolbar toolbar) {
        ImageView imageView;
        Drawable drawable;
        Drawable logo = toolbar.getLogo();
        if (logo == null) {
            return null;
        }
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if ((childAt instanceof ImageView) && (drawable = (imageView = (ImageView) childAt).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                return imageView;
            }
        }
        return null;
    }

    public static ImageButton getNavigationIconButton(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static TextView getSubtitleTextView(Toolbar toolbar) {
        ArrayList arrayListA = a(toolbar, toolbar.getSubtitle());
        if (arrayListA.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(arrayListA, f13325a);
    }

    public static TextView getTitleTextView(Toolbar toolbar) {
        ArrayList arrayListA = a(toolbar, toolbar.getTitle());
        if (arrayListA.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(arrayListA, f13325a);
    }
}
