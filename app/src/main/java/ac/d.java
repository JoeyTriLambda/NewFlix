package ac;

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
import flix.com.vision.activities.adult.AdultCategoriesActivity;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: AdultCategoryAdapter.java */
/* loaded from: classes2.dex */
public final class d extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f406d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f407e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<id.a> f408f;

    /* renamed from: g, reason: collision with root package name */
    public final AdultCategoriesActivity f409g;

    /* compiled from: AdultCategoryAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public id.a f410u;

        /* renamed from: v, reason: collision with root package name */
        public final LinearLayout f411v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f412w;

        /* renamed from: x, reason: collision with root package name */
        public final View f413x;

        /* renamed from: y, reason: collision with root package name */
        public final ImageView f414y;

        public a(d dVar, View view) {
            super(view);
            this.f413x = view;
            this.f412w = (TextView) view.findViewById(R.id.adult_category_title);
            this.f414y = (ImageView) view.findViewById(R.id.adult_cat_poster);
            this.f411v = (LinearLayout) view.findViewById(R.id.item_background);
        }
    }

    public d(AdultCategoriesActivity adultCategoriesActivity, ArrayList<id.a> arrayList) {
        this.f408f = arrayList;
        this.f409g = adultCategoriesActivity;
        AssetManager assets = adultCategoriesActivity.getAssets();
        String str = Constant.f12450b;
        this.f407e = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.f406d = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f408f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.adult_category_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, @SuppressLint({"RecyclerView"}) int i10) {
        this.f406d.applyFontToView(aVar.f412w, this.f407e);
        id.a aVar2 = this.f408f.get(i10);
        aVar.f410u = aVar2;
        aVar.f412w.setText(aVar2.f13360a);
        int i11 = 0;
        ac.a aVar3 = new ac.a(this, i10, i11);
        View view = aVar.f413x;
        view.setOnClickListener(aVar3);
        if (aVar.f410u.f13361b != null) {
            try {
                Picasso.get().load(aVar.f410u.f13361b).fit().centerCrop().into(aVar.f414y);
            } catch (Exception e10) {
                try {
                    e10.printStackTrace();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        view.setOnFocusChangeListener(new b(this, aVar, i11));
        view.setTag(Integer.valueOf(i10));
    }
}
