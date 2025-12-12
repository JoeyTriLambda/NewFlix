package ac;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: TVImportAdapter.java */
/* loaded from: classes2.dex */
public final class z extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final Activity f608d;

    /* renamed from: e, reason: collision with root package name */
    public final c4.a f609e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f610f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.h> f611g;

    /* compiled from: TVImportAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.h f612u;

        /* renamed from: v, reason: collision with root package name */
        public final ImageButton f613v;

        /* renamed from: w, reason: collision with root package name */
        public final View f614w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f615x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f616y;

        /* renamed from: z, reason: collision with root package name */
        public final ImageView f617z;

        public a(z zVar, View view) {
            super(view);
            this.f614w = view;
            this.f615x = (TextView) view.findViewById(R.id.item_histoty_name);
            this.f616y = (TextView) view.findViewById(R.id.item_histoty_url);
            this.f613v = (ImageButton) view.findViewById(R.id.option_button);
            this.f617z = (ImageView) view.findViewById(R.id.url_icon);
        }
    }

    public z(Context context, ArrayList<hd.h> arrayList, Activity activity) {
        this.f611g = arrayList;
        this.f608d = activity;
        AssetManager assets = context.getAssets();
        String str = Constant.f12450b;
        this.f610f = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f609e = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f611g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.tv_history_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        hd.h hVar = this.f611g.get(i10);
        aVar.f612u = hVar;
        String str = hVar.f13009m;
        TextView textView = aVar.f615x;
        textView.setText(str);
        String str2 = aVar.f612u.f13008b;
        TextView textView2 = aVar.f616y;
        textView2.setText(str2);
        textView2.requestFocus();
        c4.a aVar2 = this.f609e;
        Typeface typeface = this.f610f;
        aVar2.applyFontToView(textView, typeface);
        aVar2.applyFontToView(textView2, typeface);
        boolean zEquals = aVar.f612u.f13010n.equals("3");
        ImageView imageView = aVar.f617z;
        if (zEquals) {
            imageView.setImageResource(R.drawable.ic_action_file_type);
        } else if (aVar.f612u.f13010n.equals("1")) {
            imageView.setImageResource(R.drawable.tv_pack);
        } else {
            imageView.setImageResource(R.drawable.ic_action_tv_link);
        }
        aVar.f613v.setOnClickListener(new ub.v(17, this, aVar));
        aVar.f614w.setOnClickListener(new androidx.mediarouter.app.b(aVar, 12));
    }
}
