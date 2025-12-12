package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.commons.lang3.StringUtils;
import x0.j0;

/* compiled from: MaterialDatePicker.java */
/* loaded from: classes.dex */
public final class p<S> extends androidx.fragment.app.n {
    public int B0;
    public d<S> C0;
    public x<S> D0;
    public com.google.android.material.datepicker.a E0;
    public f F0;
    public MaterialCalendar<S> G0;
    public int H0;
    public CharSequence I0;
    public boolean J0;
    public int K0;
    public int L0;
    public CharSequence M0;
    public int N0;
    public CharSequence O0;
    public int P0;
    public CharSequence Q0;
    public int R0;
    public CharSequence S0;
    public TextView T0;
    public TextView U0;
    public CheckableImageButton V0;
    public q7.g W0;
    public Button X0;
    public boolean Y0;
    public CharSequence Z0;

    /* renamed from: a1, reason: collision with root package name */
    public CharSequence f9074a1;

    /* renamed from: x0, reason: collision with root package name */
    public final LinkedHashSet<r<? super S>> f9075x0 = new LinkedHashSet<>();

    /* renamed from: y0, reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f9076y0 = new LinkedHashSet<>();

    /* renamed from: z0, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f9077z0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> A0 = new LinkedHashSet<>();

    /* compiled from: MaterialDatePicker.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVar = p.this;
            Iterator<r<? super S>> it = pVar.f9075x0.iterator();
            while (it.hasNext()) {
                it.next().onPositiveButtonClick((Object) pVar.getSelection());
            }
            pVar.dismiss();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVar = p.this;
            Iterator<View.OnClickListener> it = pVar.f9076y0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            pVar.dismiss();
        }
    }

    /* compiled from: MaterialDatePicker.java */
    public class c extends w<S> {
        public c() {
        }

        @Override // com.google.android.material.datepicker.w
        public void onSelectionChanged(S s10) {
            p pVar = p.this;
            String headerText = pVar.getHeaderText();
            pVar.U0.setContentDescription(pVar.getDateSelector().getSelectionContentDescription(pVar.requireContext()));
            pVar.U0.setText(headerText);
            pVar.X0.setEnabled(pVar.getDateSelector().isSelectionComplete());
        }
    }

    public static int p(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar calendarD = a0.d();
        calendarD.set(5, 1);
        Calendar calendarC = a0.c(calendarD);
        calendarC.get(2);
        calendarC.get(1);
        int maximum = calendarC.getMaximum(7);
        calendarC.getActualMaximum(5);
        calendarC.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean q(Context context) {
        return r(context, android.R.attr.windowFullscreen);
    }

    public static boolean r(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(n7.b.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i10});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    public final d<S> getDateSelector() {
        if (this.C0 == null) {
            this.C0 = (d) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.C0;
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f9077z0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.B0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.C0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.E0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.F0 = (f) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.H0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.I0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.K0 = bundle.getInt("INPUT_MODE_KEY");
        this.L0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.M0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.N0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.O0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.P0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.Q0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.R0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.S0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.I0;
        if (text == null) {
            text = requireContext().getResources().getText(this.H0);
        }
        this.Z0 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), StringUtils.LF);
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f9074a1 = text;
    }

    @Override // androidx.fragment.app.n
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int defaultThemeResId = this.B0;
        if (defaultThemeResId == 0) {
            defaultThemeResId = getDateSelector().getDefaultThemeResId(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, defaultThemeResId);
        Context context = dialog.getContext();
        this.J0 = q(context);
        int i10 = R.attr.materialCalendarStyle;
        int i11 = R.style.Widget_MaterialComponents_MaterialCalendar;
        this.W0 = new q7.g(context, null, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialCalendar, i10, i11);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.W0.initializeElevationOverlay(context);
        this.W0.setFillColor(ColorStateList.valueOf(color));
        this.W0.setElevation(j0.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.J0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        f fVar = this.F0;
        if (fVar != null) {
            fVar.initialize(context);
        }
        if (this.J0) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(p(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(p(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.U0 = textView;
        int i10 = 1;
        j0.setAccessibilityLiveRegion(textView, 1);
        this.V0 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.T0 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.V0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.V0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, s.a.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], s.a.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.V0.setChecked(this.K0 != 0);
        j0.setAccessibilityDelegate(this.V0, null);
        t(this.V0);
        this.V0.setOnClickListener(new androidx.mediarouter.app.b(this, i10));
        this.X0 = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.X0.setEnabled(true);
        } else {
            this.X0.setEnabled(false);
        }
        this.X0.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.M0;
        if (charSequence != null) {
            this.X0.setText(charSequence);
        } else {
            int i11 = this.L0;
            if (i11 != 0) {
                this.X0.setText(i11);
            }
        }
        CharSequence charSequence2 = this.O0;
        if (charSequence2 != null) {
            this.X0.setContentDescription(charSequence2);
        } else if (this.N0 != 0) {
            this.X0.setContentDescription(getContext().getResources().getText(this.N0));
        }
        this.X0.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.Q0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.P0;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        CharSequence charSequence4 = this.S0;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.R0 != 0) {
            button.setContentDescription(getContext().getResources().getText(this.R0));
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.A0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.B0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.C0);
        a.b bVar = new a.b(this.E0);
        MaterialCalendar<S> materialCalendar = this.G0;
        t tVar = materialCalendar == null ? null : materialCalendar.f9007m0;
        if (tVar != null) {
            bVar.setOpenAt(tVar.f9093q);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.build());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.F0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.H0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.I0);
        bundle.putInt("INPUT_MODE_KEY", this.K0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.L0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.M0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.N0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.O0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.P0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.Q0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.R0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.S0);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.J0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.W0);
            if (!this.Y0) {
                View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                i7.c.applyEdgeToEdge(window, true, i7.t.getBackgroundColor(viewFindViewById), null);
                j0.setOnApplyWindowInsetsListener(viewFindViewById, new q(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
                this.Y0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.W0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new d7.a(requireDialog(), rect));
        }
        s();
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onStop() {
        this.D0.f9112h0.clear();
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.fragment.app.Fragment, com.google.android.material.datepicker.s] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s() {
        /*
            r7 = this;
            android.content.Context r0 = r7.requireContext()
            int r1 = r7.B0
            if (r1 == 0) goto L9
            goto L11
        L9:
            com.google.android.material.datepicker.d r1 = r7.getDateSelector()
            int r1 = r1.getDefaultThemeResId(r0)
        L11:
            com.google.android.material.datepicker.d r0 = r7.getDateSelector()
            com.google.android.material.datepicker.a r2 = r7.E0
            com.google.android.material.datepicker.f r3 = r7.F0
            com.google.android.material.datepicker.MaterialCalendar r0 = com.google.android.material.datepicker.MaterialCalendar.newInstance(r0, r1, r2, r3)
            r7.G0 = r0
            int r2 = r7.K0
            r3 = 1
            if (r2 != r3) goto L47
            com.google.android.material.datepicker.d r0 = r7.getDateSelector()
            com.google.android.material.datepicker.a r2 = r7.E0
            com.google.android.material.datepicker.s r4 = new com.google.android.material.datepicker.s
            r4.<init>()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "THEME_RES_ID_KEY"
            r5.putInt(r6, r1)
            java.lang.String r1 = "DATE_SELECTOR_KEY"
            r5.putParcelable(r1, r0)
            java.lang.String r0 = "CALENDAR_CONSTRAINTS_KEY"
            r5.putParcelable(r0, r2)
            r4.setArguments(r5)
            r0 = r4
        L47:
            r7.D0 = r0
            android.widget.TextView r0 = r7.T0
            int r1 = r7.K0
            if (r1 != r3) goto L63
            android.content.res.Resources r1 = r7.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            r2 = 2
            if (r1 != r2) goto L5d
            goto L5e
        L5d:
            r3 = 0
        L5e:
            if (r3 == 0) goto L63
            java.lang.CharSequence r1 = r7.f9074a1
            goto L65
        L63:
            java.lang.CharSequence r1 = r7.Z0
        L65:
            r0.setText(r1)
            java.lang.String r0 = r7.getHeaderText()
            android.widget.TextView r1 = r7.U0
            com.google.android.material.datepicker.d r2 = r7.getDateSelector()
            android.content.Context r3 = r7.requireContext()
            java.lang.String r2 = r2.getSelectionContentDescription(r3)
            r1.setContentDescription(r2)
            android.widget.TextView r1 = r7.U0
            r1.setText(r0)
            androidx.fragment.app.y r0 = r7.getChildFragmentManager()
            androidx.fragment.app.g0 r0 = r0.beginTransaction()
            int r1 = com.google.android.material.R.id.mtrl_calendar_frame
            com.google.android.material.datepicker.x<S> r2 = r7.D0
            r0.replace(r1, r2)
            r0.commitNow()
            com.google.android.material.datepicker.x<S> r0 = r7.D0
            com.google.android.material.datepicker.p$c r1 = new com.google.android.material.datepicker.p$c
            r1.<init>()
            r0.addOnSelectionChangedListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.p.s():void");
    }

    public final void t(CheckableImageButton checkableImageButton) {
        this.V0.setContentDescription(this.K0 == 1 ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }
}
