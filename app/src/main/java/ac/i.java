package ac;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;
import me.grantland.widget.AutofitTextView;

/* compiled from: AnimeEpisodeAdapter.java */
/* loaded from: classes2.dex */
public final class i extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f468d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f469e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<hd.f> f470f;

    /* renamed from: g, reason: collision with root package name */
    public final AnimeDetailActivity f471g;

    /* compiled from: AnimeEpisodeAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.f f472u;

        /* renamed from: v, reason: collision with root package name */
        public final AutofitTextView f473v;

        /* renamed from: w, reason: collision with root package name */
        public final View f474w;

        public a(i iVar, View view) {
            super(view);
            this.f474w = view;
            this.f473v = (AutofitTextView) view.findViewById(R.id.rowTextView);
            view.findViewById(R.id.color_view);
        }
    }

    public i(AnimeDetailActivity animeDetailActivity, ArrayList<hd.f> arrayList, String str) {
        this.f470f = arrayList;
        this.f471g = animeDetailActivity;
        AssetManager assets = animeDetailActivity.getAssets();
        String str2 = Constant.f12450b;
        this.f469e = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f468d = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f470f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.episode_anime_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        aVar.f472u = this.f470f.get(i10);
        Typeface typeface = this.f469e;
        c4.a aVar2 = this.f468d;
        AutofitTextView autofitTextView = aVar.f473v;
        aVar2.applyFontToView(autofitTextView, typeface);
        autofitTextView.setText("E" + aVar.f472u.toString());
        ub.u uVar = new ub.u(this, i10, aVar, 5);
        View view = aVar.f474w;
        view.setOnClickListener(uVar);
        view.setOnFocusChangeListener(new ub.b(3));
    }
}
