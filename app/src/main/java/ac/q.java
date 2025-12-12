package ac;

import ac.q;
import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: EpisodeAdapter.java */
/* loaded from: classes2.dex */
public final class q extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f534d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f535e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f536f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.f> f537g;

    /* renamed from: h, reason: collision with root package name */
    public final SeriesDetailActivity f538h;

    /* renamed from: i, reason: collision with root package name */
    public int f539i;

    /* compiled from: EpisodeAdapter.java */
    public class a extends RecyclerView.z {
        public final View A;
        public final ImageView B;

        /* renamed from: u, reason: collision with root package name */
        public hd.f f540u;

        /* renamed from: v, reason: collision with root package name */
        public final LinearLayout f541v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f542w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f543x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f544y;

        /* renamed from: z, reason: collision with root package name */
        public final TextView f545z;

        public a(q qVar, View view) {
            super(view);
            this.A = view;
            this.f542w = (TextView) view.findViewById(R.id.episode_number_text_view);
            this.f543x = (TextView) view.findViewById(R.id.episode_plot);
            this.f545z = (TextView) view.findViewById(R.id.episode_duration);
            this.f544y = (TextView) view.findViewById(R.id.episode_title_textview);
            this.B = (ImageView) view.findViewById(R.id.episode_poster);
            this.f541v = (LinearLayout) view.findViewById(R.id.episode_background_2);
        }
    }

    public q(SeriesDetailActivity seriesDetailActivity, ArrayList<hd.f> arrayList, int i10, int i11) {
        this.f537g = arrayList;
        this.f538h = seriesDetailActivity;
        this.f539i = i11;
        AssetManager assets = seriesDetailActivity.getAssets();
        String str = Constant.f12450b;
        this.f535e = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f536f = Typeface.createFromAsset(seriesDetailActivity.getAssets(), "fonts/product_sans_bold.ttf");
        this.f534d = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f537g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.episode_item_view, viewGroup, false));
    }

    public void setSeason(int i10) {
        this.f539i = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final a aVar, @SuppressLint({"RecyclerView"}) final int i10) {
        TextView textView = aVar.f544y;
        c4.a aVar2 = this.f534d;
        Typeface typeface = this.f536f;
        aVar2.applyFontToView(textView, typeface);
        TextView textView2 = aVar.f542w;
        aVar2.applyFontToView(textView2, typeface);
        TextView textView3 = aVar.f543x;
        Typeface typeface2 = this.f535e;
        aVar2.applyFontToView(textView3, typeface2);
        TextView textView4 = aVar.f545z;
        aVar2.applyFontToView(textView4, typeface2);
        hd.f fVar = this.f537g.get(i10);
        aVar.f540u = fVar;
        textView4.setText(fVar.f13004x);
        textView2.setText("S" + this.f539i + "E" + aVar.f540u.f13001u);
        ac.a aVar3 = new ac.a(this, i10, 3);
        View view = aVar.A;
        view.setOnClickListener(aVar3);
        if (aVar.f540u.f12995o != null) {
            try {
                Picasso.get().load(aVar.f540u.f12995o).fit().centerCrop().into(aVar.B);
            } catch (Exception e10) {
                try {
                    e10.printStackTrace();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ac.p
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                q qVar = this.f531b;
                q.a aVar4 = aVar;
                if (z10) {
                    SeriesDetailActivity seriesDetailActivity = qVar.f538h;
                    seriesDetailActivity.episodeHighlited(i10);
                    aVar4.f541v.setBackground(seriesDetailActivity.getResources().getDrawable(R.drawable.season_item_border_selected_episode));
                } else {
                    qVar.getClass();
                    aVar4.f541v.setBackground(null);
                    int i11 = aVar4.f540u.f13001u;
                }
            }
        });
        textView3.setText(aVar.f540u.f12992b);
        aVar.f544y.setText(aVar.f540u.f13000t);
        view.setTag(Integer.valueOf(i10));
    }
}
