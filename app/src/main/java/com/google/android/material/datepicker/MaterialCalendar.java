package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import x0.j0;

/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends x<S> {

    /* renamed from: v0, reason: collision with root package name */
    public static final /* synthetic */ int f9002v0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    public int f9003i0;

    /* renamed from: j0, reason: collision with root package name */
    public com.google.android.material.datepicker.d<S> f9004j0;

    /* renamed from: k0, reason: collision with root package name */
    public com.google.android.material.datepicker.a f9005k0;

    /* renamed from: l0, reason: collision with root package name */
    public f f9006l0;

    /* renamed from: m0, reason: collision with root package name */
    public t f9007m0;

    /* renamed from: n0, reason: collision with root package name */
    public CalendarSelector f9008n0;

    /* renamed from: o0, reason: collision with root package name */
    public com.google.android.material.datepicker.c f9009o0;

    /* renamed from: p0, reason: collision with root package name */
    public RecyclerView f9010p0;

    /* renamed from: q0, reason: collision with root package name */
    public RecyclerView f9011q0;

    /* renamed from: r0, reason: collision with root package name */
    public View f9012r0;

    /* renamed from: s0, reason: collision with root package name */
    public View f9013s0;

    /* renamed from: t0, reason: collision with root package name */
    public View f9014t0;

    /* renamed from: u0, reason: collision with root package name */
    public View f9015u0;

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public class a extends x0.a {
        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.setCollectionInfo(null);
        }
    }

    public class b extends y {
        public final /* synthetic */ int E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, int i10, int i11) {
            super(context, i10);
            this.E = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.w wVar, int[] iArr) {
            int i10 = this.E;
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            if (i10 == 0) {
                iArr[0] = materialCalendar.f9011q0.getWidth();
                iArr[1] = materialCalendar.f9011q0.getWidth();
            } else {
                iArr[0] = materialCalendar.f9011q0.getHeight();
                iArr[1] = materialCalendar.f9011q0.getHeight();
            }
        }
    }

    public class c implements d {
        public c() {
        }

        public void onDayClick(long j10) {
            MaterialCalendar materialCalendar = MaterialCalendar.this;
            if (materialCalendar.f9005k0.getDateValidator().isValid(j10)) {
                materialCalendar.f9004j0.select(j10);
                Iterator<w<S>> it = materialCalendar.f9112h0.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(materialCalendar.f9004j0.getSelection());
                }
                materialCalendar.f9011q0.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = materialCalendar.f9010p0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    public interface d {
    }

    public static <T> MaterialCalendar<T> newInstance(com.google.android.material.datepicker.d<T> dVar, int i10, com.google.android.material.datepicker.a aVar, f fVar) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", fVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.f9025o);
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    @Override // com.google.android.material.datepicker.x
    public boolean addOnSelectionChangedListener(w<S> wVar) {
        return super.addOnSelectionChangedListener(wVar);
    }

    public com.google.android.material.datepicker.d<S> getDateSelector() {
        return this.f9004j0;
    }

    public final void o(t tVar) {
        t tVar2 = ((v) this.f9011q0.getAdapter()).f9103d.f9022b;
        Calendar calendar = tVar2.f9088b;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i10 = tVar.f9090n;
        int i11 = tVar2.f9090n;
        int i12 = tVar.f9089m;
        int i13 = tVar2.f9089m;
        int i14 = (i12 - i13) + ((i10 - i11) * 12);
        t tVar3 = this.f9007m0;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i15 = i14 - ((tVar3.f9089m - i13) + ((tVar3.f9090n - i11) * 12));
        boolean z10 = Math.abs(i15) > 3;
        boolean z11 = i15 > 0;
        this.f9007m0 = tVar;
        if (z10 && z11) {
            this.f9011q0.scrollToPosition(i14 - 3);
            this.f9011q0.post(new i(this, i14));
        } else if (!z10) {
            this.f9011q0.post(new i(this, i14));
        } else {
            this.f9011q0.scrollToPosition(i14 + 3);
            this.f9011q0.post(new i(this, i14));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9003i0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f9004j0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f9005k0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f9006l0 = (f) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f9007m0 = (t) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException, Resources.NotFoundException {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f9003i0);
        this.f9009o0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        t tVar = this.f9005k0.f9022b;
        if (p.q(contextThemeWrapper)) {
            i10 = R.layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R.layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i12 = u.f9095r;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i12 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i12) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        j0.setAccessibilityDelegate(gridView, new a());
        int i13 = this.f9005k0.f9026p;
        gridView.setAdapter((ListAdapter) (i13 > 0 ? new g(i13) : new g()));
        gridView.setNumColumns(tVar.f9091o);
        gridView.setEnabled(false);
        this.f9011q0 = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.f9011q0.setLayoutManager(new b(getContext(), i11, i11));
        this.f9011q0.setTag("MONTHS_VIEW_GROUP_TAG");
        v vVar = new v(contextThemeWrapper, this.f9004j0, this.f9005k0, this.f9006l0, new c());
        this.f9011q0.setAdapter(vVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        int i14 = R.id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(i14);
        this.f9010p0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f9010p0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f9010p0.setAdapter(new c0(this));
            this.f9010p0.addItemDecoration(new k(this));
        }
        int i15 = R.id.month_navigation_fragment_toggle;
        if (viewInflate.findViewById(i15) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(i15);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            j0.setAccessibilityDelegate(materialButton, new l(this));
            View viewFindViewById = viewInflate.findViewById(R.id.month_navigation_previous);
            this.f9012r0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(R.id.month_navigation_next);
            this.f9013s0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f9014t0 = viewInflate.findViewById(i14);
            this.f9015u0 = viewInflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            p(CalendarSelector.DAY);
            materialButton.setText(this.f9007m0.c());
            this.f9011q0.addOnScrollListener(new m(this, vVar, materialButton));
            materialButton.setOnClickListener(new n(this));
            this.f9013s0.setOnClickListener(new o(this, vVar));
            this.f9012r0.setOnClickListener(new h(this, vVar));
        }
        if (!p.q(contextThemeWrapper)) {
            new androidx.recyclerview.widget.p().attachToRecyclerView(this.f9011q0);
        }
        RecyclerView recyclerView2 = this.f9011q0;
        t tVar2 = this.f9007m0;
        t tVar3 = vVar.f9103d.f9022b;
        if (!(tVar3.f9088b instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        recyclerView2.scrollToPosition((tVar2.f9089m - tVar3.f9089m) + ((tVar2.f9090n - tVar3.f9090n) * 12));
        j0.setAccessibilityDelegate(this.f9011q0, new j());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9003i0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f9004j0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9005k0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f9006l0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f9007m0);
    }

    public final void p(CalendarSelector calendarSelector) {
        this.f9008n0 = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f9010p0.getLayoutManager().scrollToPosition(this.f9007m0.f9090n - ((c0) this.f9010p0.getAdapter()).f9053d.f9005k0.f9022b.f9090n);
            this.f9014t0.setVisibility(0);
            this.f9015u0.setVisibility(8);
            this.f9012r0.setVisibility(8);
            this.f9013s0.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f9014t0.setVisibility(8);
            this.f9015u0.setVisibility(0);
            this.f9012r0.setVisibility(0);
            this.f9013s0.setVisibility(0);
            o(this.f9007m0);
        }
    }
}
