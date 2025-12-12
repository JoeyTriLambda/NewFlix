package bh;

import okio.SegmentedByteString;
import zf.i;

/* compiled from: -SegmentedByteString.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final int binarySearch(int[] iArr, int i10, int i11, int i12) {
        i.checkNotNullParameter(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i10) {
        i.checkNotNullParameter(segmentedByteString, "<this>");
        int iBinarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i10 + 1, 0, segmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }
}
