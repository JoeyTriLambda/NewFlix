package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class MaterialDialog extends m3.a implements View.OnClickListener, AdapterView.OnItemClickListener {
    public MDButton A;
    public ListType B;

    /* renamed from: n, reason: collision with root package name */
    public final c f5289n;

    /* renamed from: o, reason: collision with root package name */
    public ListView f5290o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f5291p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f5292q;

    /* renamed from: r, reason: collision with root package name */
    public View f5293r;

    /* renamed from: s, reason: collision with root package name */
    public ProgressBar f5294s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f5295t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f5296u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f5297v;

    /* renamed from: w, reason: collision with root package name */
    public EditText f5298w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f5299x;

    /* renamed from: y, reason: collision with root package name */
    public MDButton f5300y;

    /* renamed from: z, reason: collision with root package name */
    public MDButton f5301z;

    public static class DialogException extends WindowManager.BadTokenException {
        public DialogException(String str) {
            super(str);
        }
    }

    public enum ListType {
        REGULAR,
        SINGLE,
        MULTI;

        public static int getLayoutForType(ListType listType) {
            int iOrdinal = listType.ordinal();
            if (iOrdinal == 0) {
                return R.layout.md_listitem;
            }
            if (iOrdinal == 1) {
                return R.layout.md_listitem_singlechoice;
            }
            if (iOrdinal == 2) {
                return R.layout.md_listitem_multichoice;
            }
            throw new IllegalArgumentException("Not a valid list type");
        }
    }

    public static class NotImplementedException extends Error {
        public NotImplementedException(String str) {
            super(str);
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: com.afollestad.materialdialogs.MaterialDialog$a$a, reason: collision with other inner class name */
        public class RunnableC0064a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5307b;

            public RunnableC0064a(int i10) {
                this.f5307b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                MaterialDialog.this.f5290o.requestFocus();
                MaterialDialog.this.f5290o.setSelection(this.f5307b);
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MaterialDialog materialDialog = MaterialDialog.this;
            materialDialog.f5290o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ListType listType = materialDialog.B;
            ListType listType2 = ListType.SINGLE;
            if (listType == listType2 || listType == ListType.MULTI) {
                if (listType != listType2) {
                    materialDialog.getClass();
                    return;
                }
                int i10 = materialDialog.f5289n.A;
                if (i10 >= 0 && materialDialog.f5290o.getLastVisiblePosition() < i10) {
                    int lastVisiblePosition = i10 - ((materialDialog.f5290o.getLastVisiblePosition() - materialDialog.f5290o.getFirstVisiblePosition()) / 2);
                    if (lastVisiblePosition < 0) {
                        lastVisiblePosition = 0;
                    }
                    materialDialog.f5290o.post(new RunnableC0064a(lastVisiblePosition));
                }
            }
        }
    }

    public static class c {
        public int A;
        public boolean B;
        public Typeface C;
        public Typeface D;
        public final int E;
        public com.afollestad.materialdialogs.a F;
        public boolean G;
        public int H;
        public final int I;
        public final int J;
        public final int K;
        public final int L;
        public final NumberFormat M;

        /* renamed from: a, reason: collision with root package name */
        public final Context f5310a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f5311b;

        /* renamed from: c, reason: collision with root package name */
        public GravityEnum f5312c;

        /* renamed from: d, reason: collision with root package name */
        public GravityEnum f5313d;

        /* renamed from: e, reason: collision with root package name */
        public GravityEnum f5314e;

        /* renamed from: f, reason: collision with root package name */
        public GravityEnum f5315f;

        /* renamed from: g, reason: collision with root package name */
        public GravityEnum f5316g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5317h;

        /* renamed from: i, reason: collision with root package name */
        public int f5318i;

        /* renamed from: j, reason: collision with root package name */
        public int f5319j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f5320k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f5321l;

        /* renamed from: m, reason: collision with root package name */
        public CharSequence f5322m;

        /* renamed from: n, reason: collision with root package name */
        public View f5323n;

        /* renamed from: o, reason: collision with root package name */
        public int f5324o;

        /* renamed from: p, reason: collision with root package name */
        public ColorStateList f5325p;

        /* renamed from: q, reason: collision with root package name */
        public ColorStateList f5326q;

        /* renamed from: r, reason: collision with root package name */
        public ColorStateList f5327r;

        /* renamed from: s, reason: collision with root package name */
        public ColorStateList f5328s;

        /* renamed from: t, reason: collision with root package name */
        public d f5329t;

        /* renamed from: u, reason: collision with root package name */
        public e f5330u;

        /* renamed from: v, reason: collision with root package name */
        public e f5331v;

        /* renamed from: w, reason: collision with root package name */
        public Theme f5332w;

        /* renamed from: x, reason: collision with root package name */
        public final boolean f5333x;

        /* renamed from: y, reason: collision with root package name */
        public final boolean f5334y;

        /* renamed from: z, reason: collision with root package name */
        public final float f5335z;

        public c(Context context) {
            GravityEnum gravityEnum = GravityEnum.START;
            this.f5312c = gravityEnum;
            this.f5313d = gravityEnum;
            this.f5314e = GravityEnum.END;
            this.f5315f = gravityEnum;
            this.f5316g = gravityEnum;
            this.f5317h = 0;
            this.f5318i = -1;
            this.f5319j = -1;
            Theme theme = Theme.LIGHT;
            this.f5332w = theme;
            this.f5333x = true;
            this.f5334y = true;
            this.f5335z = 1.2f;
            this.A = -1;
            this.B = true;
            this.E = -1;
            this.I = -2;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.f5310a = context;
            int iResolveColor = o3.a.resolveColor(context, R.attr.colorAccent, o3.a.getColor(context, R.color.md_material_blue_600));
            this.f5324o = iResolveColor;
            int iResolveColor2 = o3.a.resolveColor(context, android.R.attr.colorAccent, iResolveColor);
            this.f5324o = iResolveColor2;
            this.f5325p = o3.a.getActionTextStateList(context, iResolveColor2);
            this.f5326q = o3.a.getActionTextStateList(context, this.f5324o);
            this.f5327r = o3.a.getActionTextStateList(context, this.f5324o);
            this.f5328s = o3.a.getActionTextStateList(context, o3.a.resolveColor(context, R.attr.md_link_color, this.f5324o));
            this.f5317h = o3.a.resolveColor(context, R.attr.md_btn_ripple_color, o3.a.resolveColor(context, R.attr.colorControlHighlight, o3.a.resolveColor(context, android.R.attr.colorControlHighlight)));
            this.M = NumberFormat.getPercentInstance();
            this.f5332w = o3.a.isColorDark(o3.a.resolveColor(context, android.R.attr.textColorPrimary)) ? theme : Theme.DARK;
            if (n3.d.get(false) != null) {
                n3.d dVar = n3.d.get();
                dVar.getClass();
                this.f5312c = dVar.f16478a;
                this.f5313d = dVar.f16479b;
                this.f5314e = dVar.f16480c;
                this.f5315f = dVar.f16481d;
                this.f5316g = dVar.f16482e;
            }
            this.f5312c = o3.a.resolveGravityEnum(context, R.attr.md_title_gravity, this.f5312c);
            this.f5313d = o3.a.resolveGravityEnum(context, R.attr.md_content_gravity, this.f5313d);
            this.f5314e = o3.a.resolveGravityEnum(context, R.attr.md_btnstacked_gravity, this.f5314e);
            this.f5315f = o3.a.resolveGravityEnum(context, R.attr.md_items_gravity, this.f5315f);
            this.f5316g = o3.a.resolveGravityEnum(context, R.attr.md_buttons_gravity, this.f5316g);
            typeface(o3.a.resolveString(context, R.attr.md_medium_font), o3.a.resolveString(context, R.attr.md_regular_font));
            if (this.D == null) {
                try {
                    this.D = Typeface.create("sans-serif-medium", 0);
                } catch (Exception unused) {
                }
            }
            if (this.C == null) {
                try {
                    this.C = Typeface.create("sans-serif", 0);
                } catch (Exception unused2) {
                }
            }
        }

        public c autoDismiss(boolean z10) {
            this.B = z10;
            return this;
        }

        public MaterialDialog build() {
            return new MaterialDialog(this);
        }

        public c callback(d dVar) {
            this.f5329t = dVar;
            return this;
        }

        public c content(int i10) {
            content(this.f5310a.getText(i10));
            return this;
        }

        public c customView(View view, boolean z10) {
            if (this.f5320k != null) {
                throw new IllegalStateException("You cannot use customView() when you have content set.");
            }
            if (this.I > -2) {
                throw new IllegalStateException("You cannot use customView() with a progress dialog");
            }
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f5323n = view;
            this.G = z10;
            return this;
        }

        public final Context getContext() {
            return this.f5310a;
        }

        public c negativeText(int i10) {
            return i10 == 0 ? this : negativeText(this.f5310a.getText(i10));
        }

        public c onNegative(e eVar) {
            this.f5331v = eVar;
            return this;
        }

        public c onPositive(e eVar) {
            this.f5330u = eVar;
            return this;
        }

        public c positiveText(int i10) {
            if (i10 == 0) {
                return this;
            }
            positiveText(this.f5310a.getText(i10));
            return this;
        }

        public MaterialDialog show() {
            MaterialDialog materialDialogBuild = build();
            materialDialogBuild.show();
            return materialDialogBuild;
        }

        public c theme(Theme theme) {
            this.f5332w = theme;
            return this;
        }

        public c title(int i10) {
            title(this.f5310a.getText(i10));
            return this;
        }

        public c typeface(String str, String str2) {
            Context context = this.f5310a;
            if (str != null) {
                Typeface typeface = o3.c.get(context, str);
                this.D = typeface;
                if (typeface == null) {
                    throw new IllegalArgumentException("No font asset found for ".concat(str));
                }
            }
            if (str2 != null) {
                Typeface typeface2 = o3.c.get(context, str2);
                this.C = typeface2;
                if (typeface2 == null) {
                    throw new IllegalArgumentException("No font asset found for ".concat(str2));
                }
            }
            return this;
        }

        public c content(CharSequence charSequence) {
            if (this.f5323n != null) {
                throw new IllegalStateException("You cannot set content() when you're using a custom view.");
            }
            this.f5320k = charSequence;
            return this;
        }

        public c negativeText(CharSequence charSequence) {
            this.f5322m = charSequence;
            return this;
        }

        public c positiveText(CharSequence charSequence) {
            this.f5321l = charSequence;
            return this;
        }

        public c title(CharSequence charSequence) {
            this.f5311b = charSequence;
            return this;
        }
    }

    public interface e {
        void onClick(MaterialDialog materialDialog, DialogAction dialogAction);
    }

    @SuppressLint({"InflateParams"})
    public MaterialDialog(c cVar) {
        super(cVar.f5310a, com.afollestad.materialdialogs.b.getTheme(cVar));
        new Handler();
        this.f5289n = cVar;
        this.f16099b = (MDRootLayout) LayoutInflater.from(cVar.f5310a).inflate(com.afollestad.materialdialogs.b.getInflateLayout(cVar), (ViewGroup) null);
        com.afollestad.materialdialogs.b.init(this);
    }

    public final Drawable a(DialogAction dialogAction, boolean z10) {
        c cVar = this.f5289n;
        if (z10) {
            cVar.getClass();
            int i10 = R.attr.md_btn_stacked_selector;
            Drawable drawableResolveDrawable = o3.a.resolveDrawable(cVar.f5310a, i10);
            return drawableResolveDrawable != null ? drawableResolveDrawable : o3.a.resolveDrawable(getContext(), i10);
        }
        int iOrdinal = dialogAction.ordinal();
        if (iOrdinal == 1) {
            cVar.getClass();
            int i11 = R.attr.md_btn_neutral_selector;
            Drawable drawableResolveDrawable2 = o3.a.resolveDrawable(cVar.f5310a, i11);
            if (drawableResolveDrawable2 != null) {
                return drawableResolveDrawable2;
            }
            Drawable drawableResolveDrawable3 = o3.a.resolveDrawable(getContext(), i11);
            o3.b.applyColor(drawableResolveDrawable3, cVar.f5317h);
            return drawableResolveDrawable3;
        }
        if (iOrdinal != 2) {
            cVar.getClass();
            int i12 = R.attr.md_btn_positive_selector;
            Drawable drawableResolveDrawable4 = o3.a.resolveDrawable(cVar.f5310a, i12);
            if (drawableResolveDrawable4 != null) {
                return drawableResolveDrawable4;
            }
            Drawable drawableResolveDrawable5 = o3.a.resolveDrawable(getContext(), i12);
            o3.b.applyColor(drawableResolveDrawable5, cVar.f5317h);
            return drawableResolveDrawable5;
        }
        cVar.getClass();
        int i13 = R.attr.md_btn_negative_selector;
        Drawable drawableResolveDrawable6 = o3.a.resolveDrawable(cVar.f5310a, i13);
        if (drawableResolveDrawable6 != null) {
            return drawableResolveDrawable6;
        }
        Drawable drawableResolveDrawable7 = o3.a.resolveDrawable(getContext(), i13);
        o3.b.applyColor(drawableResolveDrawable7, cVar.f5317h);
        return drawableResolveDrawable7;
    }

    public final void checkIfListInitScroll() {
        ListView listView = this.f5290o;
        if (listView == null) {
            return;
        }
        listView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f5298w != null) {
            o3.a.hideKeyboard(this, this.f5289n);
        }
        super.dismiss();
    }

    @Override // m3.a, android.app.Dialog
    public /* bridge */ /* synthetic */ View findViewById(int i10) {
        return super.findViewById(i10);
    }

    public final MDButton getActionButton(DialogAction dialogAction) {
        int iOrdinal = dialogAction.ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? this.f5300y : this.A : this.f5301z;
    }

    public final EditText getInputEditText() {
        return this.f5298w;
    }

    public final Drawable getListSelector() {
        c cVar = this.f5289n;
        cVar.getClass();
        Context context = cVar.f5310a;
        int i10 = R.attr.md_list_selector;
        Drawable drawableResolveDrawable = o3.a.resolveDrawable(context, i10);
        return drawableResolveDrawable != null ? drawableResolveDrawable : o3.a.resolveDrawable(getContext(), i10);
    }

    public void invalidateInputMinMaxIndicator(int i10, boolean z10) {
        int i11;
        int i12;
        TextView textView = this.f5299x;
        if (textView != null) {
            c cVar = this.f5289n;
            int i13 = 0;
            if (cVar.L > 0) {
                textView.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(i10), Integer.valueOf(cVar.L)));
                this.f5299x.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            boolean z11 = (z10 && i10 == 0) || ((i11 = cVar.L) > 0 && i10 > i11) || i10 < cVar.K;
            if (z11) {
                cVar.getClass();
                i12 = 0;
            } else {
                i12 = cVar.f5319j;
            }
            if (z11) {
                cVar.getClass();
            } else {
                i13 = cVar.f5324o;
            }
            if (cVar.L > 0) {
                this.f5299x.setTextColor(i12);
            }
            n3.c.setTint(this.f5298w, i13);
            getActionButton(DialogAction.POSITIVE).setEnabled(!z11);
        }
    }

    public final void invalidateList() {
        if (this.f5290o == null) {
            return;
        }
        c cVar = this.f5289n;
        cVar.getClass();
        com.afollestad.materialdialogs.a aVar = cVar.F;
        if (aVar == null) {
            return;
        }
        this.f5290o.setAdapter((ListAdapter) aVar);
        if (this.B == null) {
            return;
        }
        this.f5290o.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogAction dialogAction = (DialogAction) view.getTag();
        int iOrdinal = dialogAction.ordinal();
        c cVar = this.f5289n;
        if (iOrdinal == 0) {
            d dVar = cVar.f5329t;
            if (dVar != null) {
                dVar.onAny(this);
                cVar.f5329t.onPositive(this);
            }
            e eVar = cVar.f5330u;
            if (eVar != null) {
                eVar.onClick(this, dialogAction);
            }
            cVar.getClass();
            cVar.getClass();
            if (cVar.B) {
                dismiss();
            }
        } else if (iOrdinal == 1) {
            d dVar2 = cVar.f5329t;
            if (dVar2 != null) {
                dVar2.onAny(this);
                cVar.f5329t.onNeutral(this);
            }
            if (cVar.B) {
                dismiss();
            }
        } else if (iOrdinal == 2) {
            d dVar3 = cVar.f5329t;
            if (dVar3 != null) {
                dVar3.onAny(this);
                cVar.f5329t.onNegative(this);
            }
            e eVar2 = cVar.f5331v;
            if (eVar2 != null) {
                eVar2.onClick(this, dialogAction);
            }
            if (cVar.B) {
                dismiss();
            }
        }
        cVar.getClass();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        boolean z10;
        c cVar = this.f5289n;
        cVar.getClass();
        ListType listType = this.B;
        if (listType == null || listType == ListType.REGULAR) {
            if (cVar.B) {
                dismiss();
                return;
            }
            return;
        }
        if (listType == ListType.MULTI) {
            throw null;
        }
        if (listType == ListType.SINGLE) {
            com.afollestad.materialdialogs.a aVar = cVar.F;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.control);
            if (cVar.B && cVar.f5321l == null) {
                dismiss();
                cVar.A = i10;
                cVar.getClass();
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                cVar.A = i10;
                radioButton.setChecked(true);
                aVar.notifyDataSetChanged();
            }
        }
    }

    @Override // m3.a, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        if (this.f5298w != null) {
            o3.a.showKeyboard(this, this.f5289n);
            if (this.f5298w.getText().length() > 0) {
                EditText editText = this.f5298w;
                editText.setSelection(editText.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    @Override // m3.a, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(int i10) throws IllegalAccessError {
        super.setContentView(i10);
    }

    public void setInternalInputCallback() {
        EditText editText = this.f5298w;
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new b());
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        this.f5292q.setText(charSequence);
    }

    public final void setTypeface(TextView textView, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        textView.setTypeface(typeface);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
            throw new DialogException("Bad window token, you cannot show a dialog before an Activity is created or after it's hidden.");
        }
    }

    @Override // m3.a, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View view) throws IllegalAccessError {
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i10) {
        setTitle(this.f5289n.f5310a.getString(i10));
    }

    @Override // m3.a, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        super.setContentView(view, layoutParams);
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            int length = charSequence.toString().length();
            MaterialDialog materialDialog = MaterialDialog.this;
            materialDialog.f5289n.getClass();
            boolean z10 = length == 0;
            materialDialog.getActionButton(DialogAction.POSITIVE).setEnabled(!z10);
            materialDialog.invalidateInputMinMaxIndicator(length, z10);
            materialDialog.f5289n.getClass();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @Deprecated
    public static abstract class d {
        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        public final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        @Deprecated
        public abstract void onNegative(MaterialDialog materialDialog);

        @Deprecated
        public abstract void onPositive(MaterialDialog materialDialog);

        public final String toString() {
            return super.toString();
        }

        @Deprecated
        public void onAny(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onNeutral(MaterialDialog materialDialog) {
        }
    }
}
