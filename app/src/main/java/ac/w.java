package ac;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: SeasonAdapter.java */
/* loaded from: classes2.dex */
public final class w extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final SeriesDetailActivity f586d;

    /* renamed from: e, reason: collision with root package name */
    public final gd.k f587e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<hd.j> f588f;

    /* renamed from: g, reason: collision with root package name */
    public int f589g;

    /* renamed from: h, reason: collision with root package name */
    public final c4.a f590h;

    /* renamed from: i, reason: collision with root package name */
    public final Typeface f591i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f592j;

    /* compiled from: SeasonAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.j f593u;

        /* renamed from: v, reason: collision with root package name */
        public final TextView f594v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f595w;

        /* renamed from: x, reason: collision with root package name */
        public final RelativeLayout f596x;

        /* renamed from: y, reason: collision with root package name */
        public final View f597y;

        public a(w wVar, View view) {
            super(view);
            this.f597y = view;
            this.f594v = (TextView) view.findViewById(R.id.season_label_view);
            this.f595w = (TextView) view.findViewById(R.id.episode_count_label);
            this.f596x = (RelativeLayout) view.findViewById(R.id.season_background);
        }
    }

    public w(SeriesDetailActivity seriesDetailActivity, gd.k kVar, ArrayList<hd.j> arrayList, int i10) {
        this.f588f = arrayList;
        this.f589g = i10;
        this.f587e = kVar;
        this.f586d = seriesDetailActivity;
        AssetManager assets = seriesDetailActivity.getAssets();
        String str = Constant.f12450b;
        this.f591i = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f590h = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f588f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f592j = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.season_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        hd.j jVar = this.f588f.get(i10);
        aVar.f593u = jVar;
        TextView textView = aVar.f595w;
        TextView textView2 = aVar.f594v;
        try {
            textView2.setText(jVar.f13012b);
            textView.setText(aVar.f593u.f13014n + " Episodes");
        } catch (Exception e10) {
            e10.getMessage();
        }
        ac.a aVar2 = new ac.a(this, i10, 5);
        View view = aVar.f597y;
        view.setOnClickListener(aVar2);
        c4.a aVar3 = this.f590h;
        Typeface typeface = this.f591i;
        aVar3.applyFontToView(textView2, typeface);
        aVar3.applyFontToView(textView, typeface);
        view.setOnFocusChangeListener(new b(this, aVar, 9));
        int i11 = this.f589g;
        int i12 = aVar.f593u.f13013m;
        RelativeLayout relativeLayout = aVar.f596x;
        if (i11 == i12) {
            relativeLayout.setBackground(this.f586d.getResources().getDrawable(R.drawable.season_item_border_selected));
        } else {
            relativeLayout.setBackground(null);
        }
        view.setTag(Integer.valueOf(i10));
    }
}
