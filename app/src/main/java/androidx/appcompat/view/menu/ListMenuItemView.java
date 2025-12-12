package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.c1;
import x0.j0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements j.a, AbsListView.SelectionBoundsAdjuster {
    public LayoutInflater A;
    public boolean B;

    /* renamed from: b, reason: collision with root package name */
    public g f920b;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f921m;

    /* renamed from: n, reason: collision with root package name */
    public RadioButton f922n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f923o;

    /* renamed from: p, reason: collision with root package name */
    public CheckBox f924p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f925q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f926r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView f927s;

    /* renamed from: t, reason: collision with root package name */
    public LinearLayout f928t;

    /* renamed from: u, reason: collision with root package name */
    public final Drawable f929u;

    /* renamed from: v, reason: collision with root package name */
    public final int f930v;

    /* renamed from: w, reason: collision with root package name */
    public final Context f931w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f932x;

    /* renamed from: y, reason: collision with root package name */
    public final Drawable f933y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f934z;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.A == null) {
            this.A = LayoutInflater.from(getContext());
        }
        return this.A;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f926r;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f927s;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f927s.getLayoutParams();
        rect.top = this.f927s.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.f920b;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void initialize(g gVar, int i10) {
        this.f920b = gVar;
        boolean z10 = false;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(prefersCondensedTitle() ? gVar.getTitleCondensed() : gVar.getTitle());
        setCheckable(gVar.isCheckable());
        e eVar = gVar.f1025n;
        if (eVar.isShortcutsVisible()) {
            if ((eVar.isQwertyMode() ? gVar.f1021j : gVar.f1019h) != 0) {
                z10 = true;
            }
        }
        setShortcut(z10, eVar.isQwertyMode() ? gVar.f1021j : gVar.f1019h);
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        j0.setBackground(this, this.f929u);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f923o = textView;
        int i10 = this.f930v;
        if (i10 != -1) {
            textView.setTextAppearance(this.f931w, i10);
        }
        this.f925q = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f926r = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f933y);
        }
        this.f927s = (ImageView) findViewById(R.id.group_divider);
        this.f928t = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f921m != null && this.f932x) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f921m.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f922n == null && this.f924p == null) {
            return;
        }
        if (this.f920b.isExclusiveCheckable()) {
            if (this.f922n == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f922n = radioButton;
                LinearLayout linearLayout = this.f928t;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f922n;
            view = this.f924p;
        } else {
            if (this.f924p == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f924p = checkBox;
                LinearLayout linearLayout2 = this.f928t;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f924p;
            view = this.f922n;
        }
        if (z10) {
            compoundButton.setChecked(this.f920b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f924p;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f922n;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f920b.isExclusiveCheckable()) {
            if (this.f922n == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f922n = radioButton;
                LinearLayout linearLayout = this.f928t;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f922n;
        } else {
            if (this.f924p == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f924p = checkBox;
                LinearLayout linearLayout2 = this.f928t;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f924p;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.B = z10;
        this.f932x = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f927s;
        if (imageView != null) {
            imageView.setVisibility((this.f934z || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f920b.shouldShowIcon() || this.B;
        if (z10 || this.f932x) {
            ImageView imageView = this.f921m;
            if (imageView == null && drawable == null && !this.f932x) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f921m = imageView2;
                LinearLayout linearLayout = this.f928t;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f932x) {
                this.f921m.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f921m;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f921m.getVisibility() != 0) {
                this.f921m.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setShortcut(boolean r9, char r10) {
        /*
            r8 = this;
            r10 = 1
            r0 = 8
            if (r9 == 0) goto L23
            androidx.appcompat.view.menu.g r9 = r8.f920b
            androidx.appcompat.view.menu.e r1 = r9.f1025n
            boolean r2 = r1.isShortcutsVisible()
            r3 = 0
            if (r2 == 0) goto L1f
            boolean r1 = r1.isQwertyMode()
            if (r1 == 0) goto L19
            char r9 = r9.f1021j
            goto L1b
        L19:
            char r9 = r9.f1019h
        L1b:
            if (r9 == 0) goto L1f
            r9 = 1
            goto L20
        L1f:
            r9 = 0
        L20:
            if (r9 == 0) goto L23
            goto L25
        L23:
            r3 = 8
        L25:
            if (r3 != 0) goto Ldd
            android.widget.TextView r9 = r8.f925q
            androidx.appcompat.view.menu.g r1 = r8.f920b
            androidx.appcompat.view.menu.e r2 = r1.f1025n
            boolean r2 = r2.isQwertyMode()
            if (r2 == 0) goto L36
            char r2 = r1.f1021j
            goto L38
        L36:
            char r2 = r1.f1019h
        L38:
            if (r2 != 0) goto L3e
            java.lang.String r10 = ""
            goto Lda
        L3e:
            androidx.appcompat.view.menu.e r4 = r1.f1025n
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r5 = r5.getResources()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            android.content.Context r7 = r4.getContext()
            android.view.ViewConfiguration r7 = android.view.ViewConfiguration.get(r7)
            boolean r7 = r7.hasPermanentMenuKey()
            if (r7 == 0) goto L64
            int r7 = androidx.appcompat.R.string.abc_prepend_shortcut_label
            java.lang.String r7 = r5.getString(r7)
            r6.append(r7)
        L64:
            boolean r4 = r4.isQwertyMode()
            if (r4 == 0) goto L6d
            int r1 = r1.f1022k
            goto L6f
        L6d:
            int r1 = r1.f1020i
        L6f:
            int r4 = androidx.appcompat.R.string.abc_menu_meta_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 65536(0x10000, float:9.1835E-41)
            androidx.appcompat.view.menu.g.a(r1, r7, r4, r6)
            int r4 = androidx.appcompat.R.string.abc_menu_ctrl_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 4096(0x1000, float:5.74E-42)
            androidx.appcompat.view.menu.g.a(r1, r7, r4, r6)
            int r4 = androidx.appcompat.R.string.abc_menu_alt_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 2
            androidx.appcompat.view.menu.g.a(r1, r7, r4, r6)
            int r4 = androidx.appcompat.R.string.abc_menu_shift_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            androidx.appcompat.view.menu.g.a(r1, r10, r4, r6)
            int r10 = androidx.appcompat.R.string.abc_menu_sym_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r4 = 4
            androidx.appcompat.view.menu.g.a(r1, r4, r10, r6)
            int r10 = androidx.appcompat.R.string.abc_menu_function_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            androidx.appcompat.view.menu.g.a(r1, r0, r10, r6)
            if (r2 == r0) goto Lcd
            r10 = 10
            if (r2 == r10) goto Lc3
            r10 = 32
            if (r2 == r10) goto Lb9
            r6.append(r2)
            goto Ld6
        Lb9:
            int r10 = androidx.appcompat.R.string.abc_menu_space_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
            goto Ld6
        Lc3:
            int r10 = androidx.appcompat.R.string.abc_menu_enter_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
            goto Ld6
        Lcd:
            int r10 = androidx.appcompat.R.string.abc_menu_delete_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
        Ld6:
            java.lang.String r10 = r6.toString()
        Lda:
            r9.setText(r10)
        Ldd:
            android.widget.TextView r9 = r8.f925q
            int r9 = r9.getVisibility()
            if (r9 == r3) goto Lea
            android.widget.TextView r9 = r8.f925q
            r9.setVisibility(r3)
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.setShortcut(boolean, char):void");
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f923o.getVisibility() != 8) {
                this.f923o.setVisibility(8);
            }
        } else {
            this.f923o.setText(charSequence);
            if (this.f923o.getVisibility() != 0) {
                this.f923o.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MenuView, i10, 0);
        this.f929u = c1VarObtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.f930v = c1VarObtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f932x = c1VarObtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.f931w = context;
        this.f933y = c1VarObtainStyledAttributes.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f934z = typedArrayObtainStyledAttributes.hasValue(0);
        c1VarObtainStyledAttributes.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }
}
