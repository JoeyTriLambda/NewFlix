package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.mediarouter.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MediaRouteDialogHelper.java */
/* loaded from: classes.dex */
public final class n {
    public static int getDialogHeight(Context context) {
        return !context.getResources().getBoolean(R.bool.is_tablet) ? -1 : -2;
    }

    public static int getDialogWidth(Context context) throws Resources.NotFoundException {
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z10 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(z10 ? R.dimen.mr_dialog_fixed_width_minor : R.dimen.mr_dialog_fixed_width_major, typedValue, true);
        int i10 = typedValue.type;
        if (i10 == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else {
            if (i10 != 6) {
                return -2;
            }
            int i11 = displayMetrics.widthPixels;
            fraction = typedValue.getFraction(i11, i11);
        }
        return (int) fraction;
    }

    public static int getDialogWidthForDynamicGroup(Context context) {
        if (context.getResources().getBoolean(R.bool.is_tablet)) {
            return getDialogWidth(context);
        }
        return -1;
    }

    public static <E> HashMap<E, BitmapDrawable> getItemBitmapMap(Context context, ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, BitmapDrawable> map = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i10 = 0; i10 < listView.getChildCount(); i10++) {
            E item = arrayAdapter.getItem(firstVisiblePosition + i10);
            View childAt = listView.getChildAt(i10);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getWidth(), childAt.getHeight(), Bitmap.Config.ARGB_8888);
            childAt.draw(new Canvas(bitmapCreateBitmap));
            map.put(item, new BitmapDrawable(context.getResources(), bitmapCreateBitmap));
        }
        return map;
    }

    public static <E> HashMap<E, Rect> getItemBoundMap(ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, Rect> map = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i10 = 0; i10 < listView.getChildCount(); i10++) {
            E item = arrayAdapter.getItem(firstVisiblePosition + i10);
            View childAt = listView.getChildAt(i10);
            map.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
        }
        return map;
    }

    public static <E> Set<E> getItemsAdded(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list2);
        hashSet.removeAll(list);
        return hashSet;
    }

    public static <E> Set<E> getItemsRemoved(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list);
        hashSet.removeAll(list2);
        return hashSet;
    }

    public static <E> boolean listUnorderedEquals(List<E> list, List<E> list2) {
        return new HashSet(list).equals(new HashSet(list2));
    }
}
