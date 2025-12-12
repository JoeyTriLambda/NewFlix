package androidx.leanback.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import androidx.leanback.R;
import androidx.leanback.widget.picker.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import s1.b;
import s1.c;

/* loaded from: classes.dex */
public class DatePicker extends b {
    public static final int[] N = {5, 2, 1};
    public String A;
    public c B;
    public c C;
    public c D;
    public int E;
    public int F;
    public int G;
    public final SimpleDateFormat H;
    public a.C0029a I;
    public Calendar J;
    public Calendar K;
    public Calendar L;
    public Calendar M;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean f(Calendar calendar, String str) {
        try {
            calendar.setTime(this.H.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w("DatePicker", "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    public long getDate() {
        return this.L.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.A;
    }

    public long getMaxDate() {
        return this.K.getTimeInMillis();
    }

    public long getMinDate() {
        return this.J.getTimeInMillis();
    }

    @Override // s1.b
    public final void onColumnValueChanged(int i10, int i11) {
        this.M.setTimeInMillis(this.L.getTimeInMillis());
        int currentValue = getColumnAt(i10).getCurrentValue();
        if (i10 == this.F) {
            this.M.add(5, i11 - currentValue);
        } else if (i10 == this.E) {
            this.M.add(2, i11 - currentValue);
        } else {
            if (i10 != this.G) {
                throw new IllegalArgumentException();
            }
            this.M.add(1, i11 - currentValue);
        }
        this.L.set(this.M.get(1), this.M.get(2), this.M.get(5));
        if (this.L.before(this.J)) {
            this.L.setTimeInMillis(this.J.getTimeInMillis());
        } else if (this.L.after(this.K)) {
            this.L.setTimeInMillis(this.K.getTimeInMillis());
        }
        post(new s1.a(this));
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(DateFormat.getDateFormatOrder(getContext()));
        }
        if (TextUtils.equals(this.A, str)) {
            return;
        }
        this.A = str;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.I.f3321a, str);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            bestDateTimePattern = "MM/dd/yyyy";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        int i10 = 0;
        boolean z10 = false;
        char c10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= bestDateTimePattern.length()) {
                break;
            }
            char cCharAt = bestDateTimePattern.charAt(i10);
            if (cCharAt != ' ') {
                if (cCharAt != '\'') {
                    if (z10) {
                        sb2.append(cCharAt);
                    } else {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= 6) {
                                z11 = false;
                                break;
                            } else if (cCharAt == cArr[i11]) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (!z11) {
                            sb2.append(cCharAt);
                        } else if (cCharAt != c10) {
                            arrayList.add(sb2.toString());
                            sb2.setLength(0);
                        }
                    }
                    c10 = cCharAt;
                } else if (z10) {
                    z10 = false;
                } else {
                    sb2.setLength(0);
                    z10 = true;
                }
            }
            i10++;
        }
        arrayList.add(sb2.toString());
        if (arrayList.size() != str.length() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " must equal the size of datePickerFormat: " + str.length() + " + 1");
        }
        setSeparators(arrayList);
        this.C = null;
        this.B = null;
        this.D = null;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        String upperCase = str.toUpperCase();
        ArrayList arrayList2 = new ArrayList(3);
        for (int i12 = 0; i12 < upperCase.length(); i12++) {
            char cCharAt2 = upperCase.charAt(i12);
            if (cCharAt2 == 'D') {
                if (this.C != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                c cVar = new c();
                this.C = cVar;
                arrayList2.add(cVar);
                this.C.setLabelFormat("%02d");
                this.F = i12;
            } else if (cCharAt2 != 'M') {
                if (cCharAt2 != 'Y') {
                    throw new IllegalArgumentException("datePicker format error");
                }
                if (this.D != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                c cVar2 = new c();
                this.D = cVar2;
                arrayList2.add(cVar2);
                this.G = i12;
                this.D.setLabelFormat("%d");
            } else {
                if (this.B != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                c cVar3 = new c();
                this.B = cVar3;
                arrayList2.add(cVar3);
                this.B.setStaticLabels(this.I.f3322b);
                this.E = i12;
            }
        }
        setColumns(arrayList2);
        post(new s1.a(this));
    }

    public void setMaxDate(long j10) {
        this.M.setTimeInMillis(j10);
        if (this.M.get(1) != this.K.get(1) || this.M.get(6) == this.K.get(6)) {
            this.K.setTimeInMillis(j10);
            if (this.L.after(this.K)) {
                this.L.setTimeInMillis(this.K.getTimeInMillis());
            }
            post(new s1.a(this));
        }
    }

    public void setMinDate(long j10) {
        this.M.setTimeInMillis(j10);
        if (this.M.get(1) != this.J.get(1) || this.M.get(6) == this.J.get(6)) {
            this.J.setTimeInMillis(j10);
            if (this.L.before(this.J)) {
                this.L.setTimeInMillis(this.J.getTimeInMillis());
            }
            post(new s1.a(this));
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.H = new SimpleDateFormat("MM/dd/yyyy");
        a.C0029a dateConstantInstance = a.getDateConstantInstance(Locale.getDefault(), getContext().getResources());
        this.I = dateConstantInstance;
        this.M = a.getCalendarForLocale(this.M, dateConstantInstance.f3321a);
        this.J = a.getCalendarForLocale(this.J, this.I.f3321a);
        this.K = a.getCalendarForLocale(this.K, this.I.f3321a);
        this.L = a.getCalendarForLocale(this.L, this.I.f3321a);
        c cVar = this.B;
        if (cVar != null) {
            cVar.setStaticLabels(this.I.f3322b);
            setColumnAt(this.E, this.B);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbDatePicker);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
        this.M.clear();
        if (TextUtils.isEmpty(string) || !f(this.M, string)) {
            this.M.set(1900, 0, 1);
        }
        this.J.setTimeInMillis(this.M.getTimeInMillis());
        this.M.clear();
        if (TextUtils.isEmpty(string2) || !f(this.M, string2)) {
            this.M.set(2100, 0, 1);
        }
        this.K.setTimeInMillis(this.M.getTimeInMillis());
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
        setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(DateFormat.getDateFormatOrder(context)) : string3);
    }
}
