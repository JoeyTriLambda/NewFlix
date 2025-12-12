package ac;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.WatchedAcvivity;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: WatchedMovieAdapter.java */
/* loaded from: classes2.dex */
public final class d0 extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    public final gd.j f415d;

    /* renamed from: f, reason: collision with root package name */
    public final int f417f;

    /* renamed from: g, reason: collision with root package name */
    public final WatchedAcvivity f418g;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<Movie> f420i;

    /* renamed from: j, reason: collision with root package name */
    public final Typeface f421j;

    /* renamed from: k, reason: collision with root package name */
    public final c4.a f422k;

    /* renamed from: l, reason: collision with root package name */
    public final MainActivity f423l;

    /* renamed from: e, reason: collision with root package name */
    public final int f416e = 900;

    /* renamed from: h, reason: collision with root package name */
    public boolean f419h = true;

    /* compiled from: WatchedMovieAdapter.java */
    public class b extends RecyclerView.z {
        public final ImageView A;
        public final ImageView B;

        /* renamed from: u, reason: collision with root package name */
        public Movie f426u;

        /* renamed from: v, reason: collision with root package name */
        public final RelativeLayout f427v;

        /* renamed from: w, reason: collision with root package name */
        public final View f428w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f429x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f430y;

        /* renamed from: z, reason: collision with root package name */
        public final RelativeLayout f431z;

        public b(d0 d0Var, View view) {
            super(view);
            this.f428w = view;
            this.A = (ImageView) view.findViewById(R.id.image);
            this.B = (ImageView) view.findViewById(R.id.place_holder_poster);
            this.f429x = (TextView) view.findViewById(R.id.title);
            this.f430y = (TextView) view.findViewById(R.id.year_textview);
            this.f431z = (RelativeLayout) view.findViewById(R.id.type_layout);
            this.f427v = (RelativeLayout) view.findViewById(R.id.image_back);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f429x.getText()) + "'";
        }
    }

    public d0(Context context, ArrayList arrayList, WatchedAcvivity watchedAcvivity, int i10, gd.j jVar, MainActivity mainActivity) {
        this.f417f = 0;
        this.f420i = new ArrayList<>();
        this.f420i = arrayList;
        this.f418g = watchedAcvivity;
        this.f417f = i10;
        this.f415d = jVar;
        AssetManager assets = watchedAcvivity.getAssets();
        String str = Constant.f12450b;
        this.f421j = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f422k = new c4.a();
        this.f423l = mainActivity;
        new Random(19L).nextInt(10);
        ArrayList<String> arrayList2 = App.B;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f420i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(this, c.c(viewGroup, R.layout.movie_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b bVar, int i10) {
        TextView textView = bVar.f429x;
        c4.a aVar = this.f422k;
        Typeface typeface = this.f421j;
        aVar.applyFontToView(textView, typeface);
        TextView textView2 = bVar.f430y;
        aVar.applyFontToView(textView2, typeface);
        ArrayList<Movie> arrayList = this.f420i;
        Movie movie = arrayList.get(i10);
        bVar.f426u = movie;
        boolean zIsSeries = movie.isSeries();
        RelativeLayout relativeLayout = bVar.f431z;
        if (zIsSeries) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        Movie movie2 = bVar.f426u;
        if (movie2.I == "null") {
            movie2.I = "";
        }
        bVar.f429x.setText(movie2.getTitle());
        textView2.setText(bVar.f426u.I);
        if (this.f417f == this.f416e && bVar.f426u.getServer().equals("is_series")) {
            textView2.setText("Season " + bVar.f426u.H);
        }
        boolean z10 = bVar.f426u.f12407y;
        int i11 = 4;
        ImageView imageView = bVar.A;
        if (z10) {
            imageView.setVisibility(4);
            try {
                Picasso.get().load(R.drawable.trakt_logo_3).fit().centerCrop().into(bVar.B);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (arrayList.get(i10).getImage_url() == null || arrayList.get(i10).getImage_url().isEmpty()) {
            imageView.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            try {
                Picasso.get().load(arrayList.get(i10).getImage_url()).fit().centerCrop().into(imageView, new a(bVar));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        ac.b bVar2 = new ac.b(this, bVar, 13);
        View view = bVar.f428w;
        view.setOnFocusChangeListener(bVar2);
        view.setOnLongClickListener(new e(this, bVar, i10, i11));
        view.setOnClickListener(new ub.v(20, this, bVar));
        if (i10 == 0) {
            view.requestFocus();
        }
    }

    /* compiled from: WatchedMovieAdapter.java */
    public class a implements sa.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f424a;

        public a(b bVar) {
            this.f424a = bVar;
        }

        @Override // sa.b
        public void onSuccess() {
            b bVar = this.f424a;
            d0 d0Var = d0.this;
            if (d0Var.f419h) {
                d0Var.f419h = false;
                try {
                    bVar.A.invalidate();
                    b2.b bVarGenerate = b2.b.from(((BitmapDrawable) bVar.A.getDrawable()).getBitmap()).generate();
                    bVar.f426u.f12403u = bVarGenerate.getDarkVibrantColor(0);
                    MainActivity mainActivity = d0Var.f423l;
                    if (mainActivity != null) {
                        mainActivity.extractDominantColor(bVar.f426u.f12403u);
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // sa.b
        public void onError(Exception exc) {
        }
    }
}
