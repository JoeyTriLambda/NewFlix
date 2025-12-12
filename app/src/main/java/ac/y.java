package ac;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import cz.msebera.android.httpclient.HttpHost;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.tv.TVCategory;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: TVCategoryAdapater.java */
/* loaded from: classes2.dex */
public final class y extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final int f601d = 100;

    /* renamed from: e, reason: collision with root package name */
    public final gd.l f602e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<TVCategory> f603f;

    /* compiled from: TVCategoryAdapater.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public TVCategory f604u;

        /* renamed from: v, reason: collision with root package name */
        public final View f605v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f606w;

        /* renamed from: x, reason: collision with root package name */
        public final ImageView f607x;

        public a(y yVar, View view) {
            super(view);
            this.f605v = view;
            this.f606w = (TextView) view.findViewById(R.id.channel_text_view);
            this.f607x = (ImageView) view.findViewById(R.id.image_v);
        }
    }

    public y(ArrayList<TVCategory> arrayList, gd.l lVar, Context context) {
        this.f603f = arrayList;
        new fd.a();
        new fd.f(context);
        ArrayList<String> arrayList2 = App.B;
        this.f602e = lVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f603f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewC = c.c(viewGroup, R.layout.category_layout_item_view, viewGroup, false);
        if (this.f601d == 200) {
            viewC = c.c(viewGroup, R.layout.channel_item_view_list, viewGroup, false);
        }
        return new a(this, viewC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        int i11 = 0;
        aVar.f605v.setSelected(i10 == 0);
        TVCategory tVCategory = this.f603f.get(i10);
        aVar.f604u = tVCategory;
        try {
            aVar.f606w.setText(tVCategory.getCategoryName().toUpperCase(Locale.ROOT));
        } catch (Exception unused) {
        }
        String categoryImageurl = aVar.f604u.getCategoryImageurl();
        int i12 = 10;
        ImageView imageView = aVar.f607x;
        if (categoryImageurl == null || aVar.f604u.getCategoryImageurl().length() <= 10 || !aVar.f604u.getCategoryImageurl().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            try {
                try {
                    Picasso.get().load(R.drawable.tv_pack).fit().centerCrop().into(imageView);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            try {
                try {
                    Picasso.get().load(aVar.f604u.getCategoryImageurl()).fit().centerCrop().into(imageView);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            } catch (OutOfMemoryError e13) {
                e13.printStackTrace();
            }
        }
        ub.v vVar = new ub.v(16, this, aVar);
        View view = aVar.f605v;
        view.setOnClickListener(vVar);
        view.setOnLongClickListener(new x(this, i10, i11));
        view.setOnFocusChangeListener(new b(this, aVar, i12));
    }
}
