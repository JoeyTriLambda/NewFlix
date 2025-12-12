package ac;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;
import me.grantland.widget.AutofitTextView;

/* compiled from: DramaEpisodeAdapter.java */
/* loaded from: classes2.dex */
public final class o extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f524d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f525e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<hd.f> f526f;

    /* renamed from: g, reason: collision with root package name */
    public final DramaDetailActivity f527g;

    /* compiled from: DramaEpisodeAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.f f528u;

        /* renamed from: v, reason: collision with root package name */
        public final AutofitTextView f529v;

        /* renamed from: w, reason: collision with root package name */
        public final View f530w;

        public a(o oVar, View view) {
            super(view);
            this.f530w = view;
            this.f529v = (AutofitTextView) view.findViewById(R.id.rowTextView);
            view.findViewById(R.id.color_view);
        }
    }

    public o(DramaDetailActivity dramaDetailActivity, ArrayList<hd.f> arrayList, String str) {
        this.f526f = arrayList;
        this.f527g = dramaDetailActivity;
        AssetManager assets = dramaDetailActivity.getAssets();
        String str2 = Constant.f12450b;
        this.f525e = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f524d = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f526f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.episode_anime_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        aVar.f528u = this.f526f.get(i10);
        Typeface typeface = this.f525e;
        c4.a aVar2 = this.f524d;
        AutofitTextView autofitTextView = aVar.f529v;
        aVar2.applyFontToView(autofitTextView, typeface);
        autofitTextView.setText("E" + aVar.f528u.f13001u);
        ub.u uVar = new ub.u(this, i10, aVar, 6);
        View view = aVar.f530w;
        view.setOnClickListener(uVar);
        view.setOnFocusChangeListener(new ub.b(4));
    }
}
