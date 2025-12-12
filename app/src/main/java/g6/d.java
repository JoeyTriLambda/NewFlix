package g6;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

/* compiled from: TtmlRenderUtil.java */
/* loaded from: classes.dex */
public final class d {
    public static void applyStylesToSpan(SpannableStringBuilder spannableStringBuilder, int i10, int i11, e eVar) {
        if (eVar.getStyle() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(eVar.getStyle()), i10, i11, 33);
        }
        if (eVar.isLinethrough()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i11, 33);
        }
        if (eVar.isUnderline()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }
        if (eVar.hasFontColor()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(eVar.getFontColor()), i10, i11, 33);
        }
        if (eVar.hasBackgroundColor()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(eVar.getBackgroundColor()), i10, i11, 33);
        }
        if (eVar.getFontFamily() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(eVar.getFontFamily()), i10, i11, 33);
        }
        if (eVar.getTextAlign() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(eVar.getTextAlign()), i10, i11, 33);
        }
        int fontSizeUnit = eVar.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) eVar.getFontSize(), true), i10, i11, 33);
        } else if (fontSizeUnit == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.getFontSize()), i10, i11, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.getFontSize() / 100.0f), i10, i11, 33);
        }
    }

    public static e resolveStyle(e eVar, String[] strArr, Map<String, e> map) {
        if (eVar == null && strArr == null) {
            return null;
        }
        int i10 = 0;
        if (eVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (eVar == null && strArr.length > 1) {
            e eVar2 = new e();
            int length = strArr.length;
            while (i10 < length) {
                eVar2.chain(map.get(strArr[i10]));
                i10++;
            }
            return eVar2;
        }
        if (eVar != null && strArr != null && strArr.length == 1) {
            return eVar.chain(map.get(strArr[0]));
        }
        if (eVar != null && strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i10 < length2) {
                eVar.chain(map.get(strArr[i10]));
                i10++;
            }
        }
        return eVar;
    }
}
