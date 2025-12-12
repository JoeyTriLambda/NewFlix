package i6;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l6.u;
import org.apache.commons.lang3.StringUtils;

/* compiled from: WebvttSubtitle.java */
/* loaded from: classes.dex */
public final class i implements b6.d {

    /* renamed from: b, reason: collision with root package name */
    public final List<e> f13265b;

    /* renamed from: m, reason: collision with root package name */
    public final int f13266m;

    /* renamed from: n, reason: collision with root package name */
    public final long[] f13267n;

    /* renamed from: o, reason: collision with root package name */
    public final long[] f13268o;

    public i(List<e> list) {
        this.f13265b = list;
        int size = list.size();
        this.f13266m = size;
        this.f13267n = new long[size * 2];
        for (int i10 = 0; i10 < this.f13266m; i10++) {
            e eVar = list.get(i10);
            int i11 = i10 * 2;
            long[] jArr = this.f13267n;
            jArr[i11] = eVar.f13235o;
            jArr[i11 + 1] = eVar.f13236p;
        }
        long[] jArr2 = this.f13267n;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f13268o = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < this.f13266m; i10++) {
            int i11 = i10 * 2;
            long[] jArr = this.f13267n;
            if (jArr[i11] <= j10 && j10 < jArr[i11 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                e eVar2 = this.f13265b.get(i10);
                if (!eVar2.isNormalCue()) {
                    arrayList.add(eVar2);
                } else if (eVar == null) {
                    eVar = eVar2;
                } else {
                    CharSequence charSequence = eVar2.f4777b;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(eVar.f4777b).append((CharSequence) StringUtils.LF).append(charSequence);
                    } else {
                        spannableStringBuilder.append((CharSequence) StringUtils.LF).append(charSequence);
                    }
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        l6.a.checkArgument(i10 >= 0);
        long[] jArr = this.f13268o;
        l6.a.checkArgument(i10 < jArr.length);
        return jArr[i10];
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return this.f13268o.length;
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        long[] jArr = this.f13268o;
        int iBinarySearchCeil = u.binarySearchCeil(jArr, j10, false, false);
        if (iBinarySearchCeil < jArr.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }
}
