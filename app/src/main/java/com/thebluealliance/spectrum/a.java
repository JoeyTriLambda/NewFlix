package com.thebluealliance.spectrum;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.n;
import com.thebluealliance.spectrum.SpectrumPalette;
import ub.f2;

/* compiled from: SpectrumDialog.java */
/* loaded from: classes2.dex */
public class a extends n implements SpectrumPalette.a {
    public int[] A0;
    public d E0;

    /* renamed from: x0, reason: collision with root package name */
    public CharSequence f10639x0;

    /* renamed from: y0, reason: collision with root package name */
    public CharSequence f10640y0;

    /* renamed from: z0, reason: collision with root package name */
    public CharSequence f10641z0;
    public int B0 = -1;
    public int C0 = -1;
    public boolean D0 = true;
    public int F0 = 0;
    public int G0 = -1;
    public int H0 = 0;

    /* compiled from: SpectrumDialog.java */
    /* renamed from: com.thebluealliance.spectrum.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0118a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0118a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a aVar = a.this;
            d dVar = aVar.E0;
            if (dVar != null) {
                ((f2) dVar).a(true, aVar.C0);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: SpectrumDialog.java */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a aVar = a.this;
            d dVar = aVar.E0;
            if (dVar != null) {
                ((f2) dVar).a(false, aVar.B0);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: SpectrumDialog.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Context f10644a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f10645b = new Bundle();

        /* renamed from: c, reason: collision with root package name */
        public d f10646c;

        public c(Context context) {
            this.f10644a = context;
        }

        public a build() {
            a aVar = new a();
            aVar.setArguments(this.f10645b);
            aVar.setOnColorSelectedListener(this.f10646c);
            return aVar;
        }

        public c setColors(int i10) throws Resources.NotFoundException {
            this.f10645b.putIntArray("colors", this.f10644a.getResources().getIntArray(i10));
            return this;
        }

        public c setDismissOnColorSelected(boolean z10) {
            this.f10645b.putBoolean("should_dismiss_on_color_selected", z10);
            return this;
        }

        public c setOnColorSelectedListener(d dVar) {
            this.f10646c = dVar;
            return this;
        }

        public c setOutlineWidth(int i10) {
            this.f10645b.putInt("border_width", i10);
            return this;
        }

        public c setSelectedColorRes(int i10) {
            int color = m0.a.getColor(this.f10644a, i10);
            Bundle bundle = this.f10645b;
            bundle.putInt("selected_color", color);
            bundle.putInt("origina_selected_color", color);
            return this;
        }

        public c setTitle(int i10) {
            this.f10645b.putCharSequence("title", this.f10644a.getText(i10));
            return this;
        }
    }

    /* compiled from: SpectrumDialog.java */
    public interface d {
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        d dVar = this.E0;
        if (dVar != null) {
            ((f2) dVar).a(false, this.B0);
        }
    }

    @Override // com.thebluealliance.spectrum.SpectrumPalette.a
    public void onColorSelected(int i10) {
        this.C0 = i10;
        if (this.D0) {
            d dVar = this.E0;
            if (dVar != null) {
                ((f2) dVar).a(true, i10);
            }
            dismiss();
        }
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("title")) {
            this.f10639x0 = getContext().getText(R.string.default_dialog_title);
        } else {
            this.f10639x0 = arguments.getCharSequence("title");
        }
        if (arguments == null || !arguments.containsKey("colors")) {
            this.A0 = new int[]{-16777216};
        } else {
            this.A0 = arguments.getIntArray("colors");
        }
        int[] iArr = this.A0;
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("SpectrumDialog must be created with an array of colors");
        }
        if (arguments == null || !arguments.containsKey("selected_color")) {
            this.C0 = this.A0[0];
        } else {
            this.C0 = arguments.getInt("selected_color");
        }
        if (arguments == null || !arguments.containsKey("origina_selected_color")) {
            this.B0 = this.C0;
        } else {
            this.B0 = arguments.getInt("origina_selected_color");
        }
        if (arguments == null || !arguments.containsKey("should_dismiss_on_color_selected")) {
            this.D0 = true;
        } else {
            this.D0 = arguments.getBoolean("should_dismiss_on_color_selected");
        }
        if (arguments == null || !arguments.containsKey("positive_button_text")) {
            this.f10640y0 = getContext().getText(android.R.string.ok);
        } else {
            this.f10640y0 = arguments.getCharSequence("positive_button_text");
        }
        if (arguments == null || !arguments.containsKey("negative_button_text")) {
            this.f10641z0 = getContext().getText(android.R.string.cancel);
        } else {
            this.f10641z0 = arguments.getCharSequence("negative_button_text");
        }
        if (arguments != null && arguments.containsKey("border_width")) {
            this.F0 = arguments.getInt("border_width");
        }
        if (arguments != null && arguments.containsKey("fixed_column_count")) {
            this.G0 = arguments.getInt("fixed_column_count");
        }
        if (arguments != null && arguments.containsKey("theme_res_id")) {
            this.H0 = arguments.getInt("theme_res_id");
        }
        if (bundle == null || !bundle.containsKey("selected_color")) {
            return;
        }
        this.C0 = bundle.getInt("selected_color");
    }

    @Override // androidx.fragment.app.n
    public Dialog onCreateDialog(Bundle bundle) {
        d.a aVar = this.H0 != 0 ? new d.a(getContext(), this.H0) : new d.a(getContext());
        aVar.setTitle(this.f10639x0);
        if (this.D0) {
            aVar.setPositiveButton(null, null);
        } else {
            aVar.setPositiveButton(this.f10640y0, new DialogInterfaceOnClickListenerC0118a());
        }
        aVar.setNegativeButton(this.f10641z0, new b());
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_color_picker, (ViewGroup) null);
        SpectrumPalette spectrumPalette = (SpectrumPalette) viewInflate.findViewById(R.id.palette);
        spectrumPalette.setColors(this.A0);
        spectrumPalette.setSelectedColor(this.C0);
        spectrumPalette.setOnColorSelectedListener(this);
        int i10 = this.F0;
        if (i10 != 0) {
            spectrumPalette.setOutlineWidth(i10);
        }
        int i11 = this.G0;
        if (i11 > 0) {
            spectrumPalette.setFixedColumnCount(i11);
        }
        aVar.setView(viewInflate);
        return aVar.create();
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.E0 = null;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selected_color", this.C0);
    }

    public void setOnColorSelectedListener(d dVar) {
        this.E0 = dVar;
    }
}
