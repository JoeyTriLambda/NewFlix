package s1;

/* compiled from: PickerColumn.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f19005a;

    /* renamed from: b, reason: collision with root package name */
    public int f19006b;

    /* renamed from: c, reason: collision with root package name */
    public int f19007c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence[] f19008d;

    /* renamed from: e, reason: collision with root package name */
    public String f19009e;

    public int getCount() {
        return (this.f19007c - this.f19006b) + 1;
    }

    public int getCurrentValue() {
        return this.f19005a;
    }

    public CharSequence getLabelFor(int i10) {
        CharSequence[] charSequenceArr = this.f19008d;
        return charSequenceArr == null ? String.format(this.f19009e, Integer.valueOf(i10)) : charSequenceArr[i10];
    }

    public int getMaxValue() {
        return this.f19007c;
    }

    public int getMinValue() {
        return this.f19006b;
    }

    public void setCurrentValue(int i10) {
        this.f19005a = i10;
    }

    public void setLabelFormat(String str) {
        this.f19009e = str;
    }

    public void setMaxValue(int i10) {
        this.f19007c = i10;
    }

    public void setMinValue(int i10) {
        this.f19006b = i10;
    }

    public void setStaticLabels(CharSequence[] charSequenceArr) {
        this.f19008d = charSequenceArr;
    }
}
