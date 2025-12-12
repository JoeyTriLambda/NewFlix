package ed;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.AnimesListActivity;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: FilterDialogFragmentAnime.java */
/* loaded from: classes2.dex */
public final class a extends DialogFragment {

    /* renamed from: b, reason: collision with root package name */
    public Button f11207b;

    /* renamed from: m, reason: collision with root package name */
    public Button f11208m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f11209n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f11210o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f11211p;

    /* renamed from: q, reason: collision with root package name */
    public LinearLayout f11212q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f11213r;

    /* renamed from: s, reason: collision with root package name */
    public Spinner f11214s;

    /* renamed from: t, reason: collision with root package name */
    public Spinner f11215t;

    /* renamed from: u, reason: collision with root package name */
    public Spinner f11216u;

    /* renamed from: v, reason: collision with root package name */
    public Spinner f11217v;

    /* renamed from: w, reason: collision with root package name */
    public Spinner f11218w;

    /* renamed from: x, reason: collision with root package name */
    public CheckBox f11219x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f11220y;

    /* compiled from: FilterDialogFragmentAnime.java */
    /* renamed from: ed.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0137a implements View.OnClickListener {
        public ViewOnClickListenerC0137a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.getClass();
            aVar.dismiss();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11222b;

        public b(ArrayList arrayList) {
            this.f11222b = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            a.this.getClass();
            String str = (String) this.f11222b.get(i10);
            if (str.equals("All")) {
                str = "";
            }
            App.getInstance().f11574v.edit().putString("type_anime", str).apply();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            a.this.getClass();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class c implements AdapterView.OnItemSelectedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11224b;

        public c(ArrayList arrayList) {
            this.f11224b = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            a.this.getClass();
            String str = (String) this.f11224b.get(i10);
            if (str.equals("All")) {
                str = "";
            }
            App.getInstance().f11574v.edit().putString("lang_anime", str).apply();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            a.this.getClass();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class d implements AdapterView.OnItemSelectedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11226b;

        public d(ArrayList arrayList) {
            this.f11226b = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            a.this.getClass();
            String str = (String) this.f11226b.get(i10);
            if (str.equals("All")) {
                str = "";
            }
            App.getInstance().f11574v.edit().putString("year_anime", str).apply();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            a.this.getClass();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11228b;

        public e(ArrayList arrayList) {
            this.f11228b = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            a.this.getClass();
            String str = (String) this.f11228b.get(i10);
            if (str.equals("All")) {
                str = "";
            }
            App.getInstance().f11574v.edit().putString("genre_anime", str).apply();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            a.this.getClass();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11214s.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11215t.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11217v.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11218w.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11216u.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f11219x.performClick();
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class l implements CompoundButton.OnCheckedChangeListener {
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            o1.a.j(App.getInstance().f11574v, "pref_hide_adult_content_anime", z10);
        }
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            ((AnimesListActivity) aVar.getActivity()).applyFilter();
            aVar.getClass();
            aVar.dismiss();
        }
    }

    public static a newInstance(boolean z10, Activity activity) {
        return new a();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_setting_fragment_anime, viewGroup, false);
        getDialog().getWindow().requestFeature(1);
        setCancelable(true);
        this.f11213r = (LinearLayout) viewInflate.findViewById(R.id.lin_sort);
        this.f11215t = (Spinner) viewInflate.findViewById(R.id.spinner_sort);
        this.f11220y = (LinearLayout) viewInflate.findViewById(R.id.lin_hsfk);
        this.f11219x = (CheckBox) viewInflate.findViewById(R.id.check_nsfk);
        this.f11210o = (LinearLayout) viewInflate.findViewById(R.id.lin_lang);
        this.f11209n = (LinearLayout) viewInflate.findViewById(R.id.lin_genre);
        this.f11211p = (LinearLayout) viewInflate.findViewById(R.id.lin_year);
        this.f11212q = (LinearLayout) viewInflate.findViewById(R.id.lin_type);
        this.f11209n.setOnClickListener(new f());
        this.f11209n.requestFocus();
        this.f11213r.setOnClickListener(new g());
        this.f11210o.setOnClickListener(new h());
        this.f11212q.setOnClickListener(new i());
        this.f11211p.setOnClickListener(new j());
        this.f11208m = (Button) viewInflate.findViewById(R.id.cancel_but);
        this.f11207b = (Button) viewInflate.findViewById(R.id.save_but);
        this.f11214s = (Spinner) viewInflate.findViewById(R.id.spinner_genre);
        this.f11217v = (Spinner) viewInflate.findViewById(R.id.spinner_lang);
        this.f11216u = (Spinner) viewInflate.findViewById(R.id.spinner_year);
        this.f11218w = (Spinner) viewInflate.findViewById(R.id.spinner_type);
        ArrayList arrayList = new ArrayList(Arrays.asList("All", "Dubbed", "Subbed"));
        ArrayList arrayList2 = new ArrayList(Arrays.asList("All", "Movie", "TV Series", "OVA", "ONA", "Special"));
        ArrayList arrayList3 = new ArrayList(Arrays.asList("All", "Action", "Adventure", "Cars", "Comedy", "Dementia", "Demons", "Drama", "Ecchi", "Fantasy", "Game", "Harem", "Historical", "Horror", "Josei", "Kids", "Magic", "Martial", "Arts", "Mecha", "Military", "Music", "Mystery", "Parody", "Police", "Psychological", "Romance", "Samurai", "School", "Sci-Fi", "Seinen", "Shoujo", "Shoujo Ai", "Shounen", "Shounen Ai", "Slice of Life", "Space", "Sports", "Super", "Power", "Supernatural", "Thriller", "Vampire", "Yaoi", "Yuri"));
        ArrayList arrayList4 = new ArrayList(Arrays.asList("All", "2023", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"));
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(getActivity(), R.array.langs, R.layout.spinner_row1);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(getActivity(), R.array.types, R.layout.spinner_row1);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource3 = ArrayAdapter.createFromResource(getActivity(), R.array.years, R.layout.spinner_row1);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource4 = ArrayAdapter.createFromResource(getActivity(), R.array.genres_anim, R.layout.spinner_row1);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource5 = ArrayAdapter.createFromResource(getActivity(), R.array.server_sortby, R.layout.spinner_row1);
        this.f11219x.setChecked(App.getInstance().f11574v.getBoolean("pref_hide_adult_content_anime", false));
        this.f11220y.setOnClickListener(new k());
        this.f11219x.setOnCheckedChangeListener(new l());
        this.f11215t.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource5);
        this.f11216u.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource3);
        this.f11214s.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource4);
        this.f11217v.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        this.f11218w.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource2);
        this.f11215t.setSelection(App.getInstance().f11574v.getInt("sort_by_index_anime", 0));
        this.f11215t.setOnItemSelectedListener(new m());
        try {
            String string = App.getInstance().f11574v.getString("year_anime", "");
            if (string == "") {
                string = "All";
            }
            this.f11216u.setSelection(arrayList4.indexOf(string));
            String string2 = App.getInstance().f11574v.getString("genre_anime", "");
            if (string2 == "") {
                string2 = "All";
            }
            this.f11214s.setSelection(arrayList3.indexOf(string2));
            String string3 = App.getInstance().f11574v.getString("type_anime", "");
            if (string3 == "") {
                string3 = "All";
            }
            this.f11218w.setSelection(arrayList2.indexOf(string3));
            String string4 = App.getInstance().f11574v.getString("lang_anime", "");
            this.f11217v.setSelection(arrayList.indexOf(string4 == "" ? "All" : string4));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f11207b.setOnClickListener(new n());
        this.f11208m.setOnClickListener(new ViewOnClickListenerC0137a());
        this.f11218w.setOnItemSelectedListener(new b(arrayList2));
        this.f11217v.setOnItemSelectedListener(new c(arrayList));
        this.f11216u.setOnItemSelectedListener(new d(arrayList4));
        this.f11214s.setOnItemSelectedListener(new e(arrayList3));
        return viewInflate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* compiled from: FilterDialogFragmentAnime.java */
    public class m implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            App.getInstance().f11574v.edit().putString("pref_filter_sort_anime", i10 == 1 ? "last_added" : "popular").apply();
            App.getInstance().f11574v.edit().putInt("sort_by_index_anime", i10).apply();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
