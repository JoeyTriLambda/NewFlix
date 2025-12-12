package n3;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.l;
import java.lang.reflect.Field;

/* compiled from: MDTintHelper.java */
/* loaded from: classes.dex */
public final class c {
    public static void setTint(RadioButton radioButton, int i10) {
        radioButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{o3.a.resolveColor(radioButton.getContext(), com.afollestad.materialdialogs.R.attr.colorControlNormal), i10}));
    }

    public static void setTint(EditText editText, int i10) {
        Context context = editText.getContext();
        int i11 = com.afollestad.materialdialogs.R.attr.colorControlNormal;
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{o3.a.resolveColor(context, i11), o3.a.resolveColor(context, i11), i10});
        if (editText instanceof l) {
            ((l) editText).setSupportBackgroundTintList(colorStateList);
        } else {
            editText.setBackgroundTintList(colorStateList);
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i12 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {editText.getContext().getResources().getDrawable(i12), editText.getContext().getResources().getDrawable(i12)};
            drawableArr[0].setColorFilter(i10, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i10, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
