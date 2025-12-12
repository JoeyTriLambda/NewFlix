package s1;

import androidx.leanback.widget.picker.DatePicker;

/* compiled from: DatePicker.java */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f18981b = false;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DatePicker f18982m;

    public a(DatePicker datePicker) {
        this.f18982m = datePicker;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        boolean z11;
        DatePicker datePicker = this.f18982m;
        int[] iArr = {datePicker.F, datePicker.E, datePicker.G};
        boolean z12 = true;
        boolean z13 = true;
        for (int i10 = 2; i10 >= 0; i10--) {
            int i11 = iArr[i10];
            if (i11 >= 0) {
                int i12 = DatePicker.N[i10];
                c columnAt = datePicker.getColumnAt(i11);
                if (z12) {
                    int i13 = datePicker.J.get(i12);
                    if (i13 != columnAt.getMinValue()) {
                        columnAt.setMinValue(i13);
                        z10 = true;
                    }
                    z10 = false;
                } else {
                    int actualMinimum = datePicker.L.getActualMinimum(i12);
                    if (actualMinimum != columnAt.getMinValue()) {
                        columnAt.setMinValue(actualMinimum);
                        z10 = true;
                    }
                    z10 = false;
                }
                boolean z14 = z10 | false;
                if (z13) {
                    int i14 = datePicker.K.get(i12);
                    if (i14 != columnAt.getMaxValue()) {
                        columnAt.setMaxValue(i14);
                        z11 = true;
                    }
                    z11 = false;
                } else {
                    int actualMaximum = datePicker.L.getActualMaximum(i12);
                    if (actualMaximum != columnAt.getMaxValue()) {
                        columnAt.setMaxValue(actualMaximum);
                        z11 = true;
                    }
                    z11 = false;
                }
                boolean z15 = z14 | z11;
                z12 &= datePicker.L.get(i12) == datePicker.J.get(i12);
                z13 &= datePicker.L.get(i12) == datePicker.K.get(i12);
                if (z15) {
                    datePicker.setColumnAt(iArr[i10], columnAt);
                }
                datePicker.setColumnValue(iArr[i10], datePicker.L.get(i12), this.f18981b);
            }
        }
    }
}
