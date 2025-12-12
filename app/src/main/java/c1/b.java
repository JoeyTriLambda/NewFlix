package c1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import w0.h;

/* compiled from: EditorInfoCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f5005a = new String[0];

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i10);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i11);
    }

    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        int i10 = Build.VERSION.SDK_INT;
        String[] strArr = f5005a;
        if (i10 >= 25) {
            String[] strArr2 = editorInfo.contentMimeTypes;
            return strArr2 != null ? strArr2 : strArr;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return strArr;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray != null ? stringArray : strArr;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int i10) {
        h.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            editorInfo.setInitialSurroundingSubText(charSequence, i10);
            return;
        }
        int i11 = editorInfo.initialSelStart;
        int i12 = editorInfo.initialSelEnd;
        int i13 = i11 > i12 ? i12 - i10 : i11 - i10;
        int i14 = i11 > i12 ? i11 - i10 : i12 - i10;
        int length = charSequence.length();
        if (i10 < 0 || i13 < 0 || i14 > length) {
            a(editorInfo, null, 0, 0);
            return;
        }
        int i15 = editorInfo.inputType & 4095;
        if (i15 == 129 || i15 == 225 || i15 == 18) {
            a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            a(editorInfo, charSequence, i13, i14);
            return;
        }
        int i16 = i14 - i13;
        int i17 = i16 > 1024 ? 0 : i16;
        int i18 = 2048 - i17;
        int iMin = Math.min(charSequence.length() - i14, i18 - Math.min(i13, (int) (i18 * 0.8d)));
        int iMin2 = Math.min(i13, i18 - iMin);
        int i19 = i13 - iMin2;
        if (Character.isLowSurrogate(charSequence.charAt(i19))) {
            i19++;
            iMin2--;
        }
        if (Character.isHighSurrogate(charSequence.charAt((i14 + iMin) - 1))) {
            iMin--;
        }
        CharSequence charSequenceConcat = i17 != i16 ? TextUtils.concat(charSequence.subSequence(i19, i19 + iMin2), charSequence.subSequence(i14, iMin + i14)) : charSequence.subSequence(i19, iMin2 + i17 + iMin + i19);
        int i20 = iMin2 + 0;
        a(editorInfo, charSequenceConcat, i20, i17 + i20);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            editorInfo.setInitialSurroundingSubText(charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }
}
