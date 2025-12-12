package ac;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import flix.com.vision.models.Anime;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: AnimeAdapter.java */
/* loaded from: classes2.dex */
public final class h extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final Context f456d;

    /* renamed from: e, reason: collision with root package name */
    public final gd.d f457e;

    /* renamed from: f, reason: collision with root package name */
    public final c4.a f458f;

    /* renamed from: g, reason: collision with root package name */
    public final Activity f459g;

    /* renamed from: h, reason: collision with root package name */
    public final Typeface f460h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<Anime> f461i;

    /* compiled from: AnimeAdapter.java */
    public class a extends RecyclerView.z {
        public final TextView A;
        public final TextView B;
        public final TextView C;
        public final ImageView D;

        /* renamed from: u, reason: collision with root package name */
        public Anime f462u;

        /* renamed from: v, reason: collision with root package name */
        public final FrameLayout f463v;

        /* renamed from: w, reason: collision with root package name */
        public final View f464w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f465x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f466y;

        /* renamed from: z, reason: collision with root package name */
        public final TextView f467z;

        public a(h hVar, View view) {
            super(view);
            this.f464w = view;
            this.D = (ImageView) view.findViewById(R.id.image);
            this.f465x = (TextView) view.findViewById(R.id.title);
            this.C = (TextView) view.findViewById(R.id.year_textview);
            this.f466y = (TextView) view.findViewById(R.id.tag1);
            this.f467z = (TextView) view.findViewById(R.id.tag2);
            this.A = (TextView) view.findViewById(R.id.tag3);
            this.B = (TextView) view.findViewById(R.id.tag4);
            this.f463v = (FrameLayout) view.findViewById(R.id.image_back);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f465x.getText()) + "'";
        }
    }

    public h(Context context, ArrayList<Anime> arrayList, Activity activity, int i10, gd.d dVar) {
        this.f456d = context;
        this.f461i = arrayList;
        this.f459g = activity;
        this.f457e = dVar;
        AssetManager assets = context.getAssets();
        String str = Constant.f12450b;
        this.f460h = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f458f = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f461i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.anime_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        TextView textView = aVar.f465x;
        c4.a aVar2 = this.f458f;
        Typeface typeface = this.f460h;
        aVar2.applyFontToView(textView, typeface);
        TextView textView2 = aVar.C;
        aVar2.applyFontToView(textView2, typeface);
        TextView textView3 = aVar.f467z;
        aVar2.applyFontToView(textView3, typeface);
        TextView textView4 = aVar.A;
        aVar2.applyFontToView(textView4, typeface);
        TextView textView5 = aVar.B;
        aVar2.applyFontToView(textView5, typeface);
        TextView textView6 = aVar.f466y;
        int i11 = 8;
        textView6.setVisibility(8);
        textView3.setVisibility(8);
        textView4.setVisibility(8);
        textView5.setVisibility(8);
        ArrayList<Anime> arrayList = this.f461i;
        Anime anime = arrayList.get(i10);
        aVar.f462u = anime;
        String strTrim = anime.f12380n;
        int i12 = 0;
        if (strTrim.toLowerCase().contains("(dub)")) {
            textView3.setVisibility(0);
            textView3.setText("DUB");
            strTrim = strTrim.toLowerCase().replace("(dub)", "").trim();
        } else {
            textView3.setVisibility(8);
        }
        if (strTrim.toLowerCase().contains("(sub)")) {
            textView4.setVisibility(0);
            textView4.setText("SUB");
            strTrim = strTrim.toLowerCase().replace("(sub)", "").trim();
        }
        if (strTrim.toLowerCase().endsWith(")")) {
            String strSubstring = strTrim.substring(strTrim.length() - 6);
            strTrim = strTrim.replace(strSubstring, "").trim();
            textView2.setText(strSubstring.replace("(", "").replace(")", ""));
        }
        aVar.f465x.setText(strTrim.toUpperCase());
        if (aVar.f462u.f12380n.contains("Movie")) {
            textView6.setVisibility(0);
            textView6.setText("MOVIE");
        }
        if (aVar.f462u.f12380n.contains("Special")) {
            textView5.setVisibility(0);
            textView5.setText("SPECIAL");
        }
        try {
            Picasso.get().load(arrayList.get(i10).f12383q).fit().centerCrop().into(aVar.D);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        b bVar = new b(this, aVar, 2);
        View view = aVar.f464w;
        view.setOnFocusChangeListener(bVar);
        view.setOnClickListener(new ub.v(i11, this, aVar));
        view.setOnLongClickListener(new g(i12, this, aVar));
        if (i10 == 0) {
            view.requestFocus();
        }
    }
}
