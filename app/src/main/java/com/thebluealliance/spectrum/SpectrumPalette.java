package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import ta.c;

/* loaded from: classes2.dex */
public class SpectrumPalette extends LinearLayout {
    public boolean A;
    public EventBus B;
    public final ArrayList C;

    /* renamed from: b, reason: collision with root package name */
    public int f10624b;

    /* renamed from: m, reason: collision with root package name */
    public int f10625m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f10626n;

    /* renamed from: o, reason: collision with root package name */
    public int f10627o;

    /* renamed from: p, reason: collision with root package name */
    public a f10628p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10629q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10630r;

    /* renamed from: s, reason: collision with root package name */
    public int f10631s;

    /* renamed from: t, reason: collision with root package name */
    public int f10632t;

    /* renamed from: u, reason: collision with root package name */
    public int f10633u;

    /* renamed from: v, reason: collision with root package name */
    public int f10634v;

    /* renamed from: w, reason: collision with root package name */
    public int f10635w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10636x;

    /* renamed from: y, reason: collision with root package name */
    public int f10637y;

    /* renamed from: z, reason: collision with root package name */
    public int f10638z;

    public interface a {
        void onColorSelected(int i10);
    }

    public SpectrumPalette(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10629q = false;
        this.f10630r = false;
        this.f10631s = -1;
        this.f10632t = 0;
        this.f10633u = 0;
        this.f10634v = 0;
        this.f10635w = 0;
        this.f10636x = false;
        this.f10637y = 2;
        this.f10638z = -1;
        this.A = false;
        this.C = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SpectrumPalette, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SpectrumPalette_spectrum_colors, 0);
        if (resourceId != 0) {
            this.f10626n = getContext().getResources().getIntArray(resourceId);
        }
        this.f10629q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SpectrumPalette_spectrum_autoPadding, false);
        this.f10632t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SpectrumPalette_spectrum_outlineWidth, 0);
        int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.SpectrumPalette_spectrum_columnCount, -1);
        this.f10631s = i10;
        if (i10 != -1) {
            this.f10630r = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f10634v = getPaddingTop();
        this.f10635w = getPaddingBottom();
        EventBus eventBus = new EventBus();
        this.B = eventBus;
        eventBus.register(this);
        this.f10624b = getResources().getDimensionPixelSize(R.dimen.color_item_small);
        this.f10625m = getResources().getDimensionPixelSize(R.dimen.color_item_margins_small);
        setOrientation(1);
    }

    private int getOriginalPaddingBottom() {
        return this.f10635w;
    }

    private int getOriginalPaddingTop() {
        return this.f10634v;
    }

    public void createPaletteView() {
        if (this.A && this.f10637y == this.f10638z) {
            return;
        }
        this.A = true;
        this.f10638z = this.f10637y;
        removeAllViews();
        if (this.f10626n == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f10626n;
            if (i10 >= iArr.length) {
                break;
            }
            int i12 = iArr[i10];
            ta.a aVar = new ta.a(getContext(), i12, i12 == this.f10627o, this.B);
            int i13 = this.f10624b;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
            int i14 = this.f10625m;
            layoutParams.setMargins(i14, i14, i14, i14);
            aVar.setLayoutParams(layoutParams);
            int i15 = this.f10632t;
            if (i15 != 0) {
                aVar.setOutlineWidth(i15);
            }
            this.C.add(aVar);
            linearLayout.addView(aVar);
            i11++;
            if (i11 == this.f10637y) {
                addView(linearLayout);
                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout.setGravity(1);
                i11 = 0;
            }
            i10++;
        }
        if (i11 > 0) {
            while (i11 < this.f10637y) {
                ImageView imageView = new ImageView(getContext());
                int i16 = this.f10624b;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i16, i16);
                int i17 = this.f10625m;
                layoutParams2.setMargins(i17, i17, i17, i17);
                imageView.setLayoutParams(layoutParams2);
                linearLayout.addView(imageView);
                i11++;
            }
            addView(linearLayout);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int i12 = 0;
        if (this.f10630r) {
            size = getPaddingLeft() + (((this.f10625m * 2) + this.f10624b) * this.f10631s) + getPaddingRight();
            this.f10637y = this.f10631s;
        } else if (mode == 1073741824) {
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                if ((i14 * 2 * this.f10625m) + (this.f10624b * i14) > size - (getPaddingRight() + getPaddingLeft())) {
                    break;
                } else {
                    i13 = i14;
                }
            }
            this.f10637y = i13;
        } else if (mode == Integer.MIN_VALUE) {
            int i15 = 0;
            while (true) {
                int i16 = i15 + 1;
                if ((i16 * 2 * this.f10625m) + (this.f10624b * i16) > size - (getPaddingRight() + getPaddingLeft())) {
                    break;
                } else {
                    i15 = i16;
                }
            }
            this.f10637y = i15;
        } else {
            int paddingRight = getPaddingRight() + getPaddingLeft() + (((this.f10625m * 2) + this.f10624b) * 4);
            this.f10637y = 4;
            size = paddingRight;
        }
        int paddingRight2 = (size - (getPaddingRight() + (getPaddingLeft() + (((this.f10625m * 2) + this.f10624b) * this.f10637y)))) / 2;
        this.f10633u = paddingRight2;
        boolean z10 = this.f10629q;
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                int i17 = this.f10637y;
                int[] iArr = this.f10626n;
                if (iArr != null) {
                    int length = iArr.length / i17;
                    if (iArr.length % i17 != 0) {
                        length++;
                    }
                    i12 = length * ((this.f10625m * 2) + this.f10624b);
                }
                int i18 = i12 + this.f10634v + this.f10635w;
                if (z10) {
                    i18 += paddingRight2 * 2;
                }
                size2 = Math.min(i18, size2);
            } else {
                int i19 = this.f10637y;
                int[] iArr2 = this.f10626n;
                if (iArr2 != null) {
                    int length2 = iArr2.length / i19;
                    if (iArr2.length % i19 != 0) {
                        length2++;
                    }
                    i12 = length2 * ((this.f10625m * 2) + this.f10624b);
                }
                size2 = this.f10635w + i12 + this.f10634v;
                if (z10) {
                    size2 += paddingRight2 * 2;
                }
            }
        }
        if (z10) {
            int paddingLeft = getPaddingLeft();
            int i20 = this.f10634v + this.f10633u;
            int paddingRight3 = getPaddingRight();
            int i21 = this.f10635w + this.f10633u;
            this.f10636x = true;
            setPadding(paddingLeft, i20, paddingRight3, i21);
        }
        createPaletteView();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Subscribe
    public void onSelectedColorChanged(c cVar) {
        int selectedColor = cVar.getSelectedColor();
        this.f10627o = selectedColor;
        a aVar = this.f10628p;
        if (aVar != null) {
            aVar.onColorSelected(selectedColor);
        }
    }

    public void setColors(int[] iArr) {
        this.f10626n = iArr;
        this.A = false;
        createPaletteView();
    }

    public void setFixedColumnCount(int i10) {
        if (i10 <= 0) {
            this.f10630r = false;
            this.f10631s = -1;
            requestLayout();
            invalidate();
            return;
        }
        Log.d("spectrum", "set column count to " + i10);
        this.f10630r = true;
        this.f10631s = i10;
        requestLayout();
        invalidate();
    }

    public void setOnColorSelectedListener(a aVar) {
        this.f10628p = aVar;
    }

    public void setOutlineWidth(int i10) {
        this.f10632t = i10;
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((ta.a) it.next()).setOutlineWidth(i10);
        }
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.f10636x) {
            return;
        }
        this.f10634v = i11;
        this.f10635w = i13;
    }

    public void setSelectedColor(int i10) {
        this.f10627o = i10;
        this.B.post(new c(i10));
    }
}
