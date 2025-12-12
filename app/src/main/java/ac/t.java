package ac;

import android.app.Activity;
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
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: MovieAdapter.java */
/* loaded from: classes2.dex */
public final class t extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    public final gd.j f558d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f559e;

    /* renamed from: g, reason: collision with root package name */
    public final int f561g;

    /* renamed from: h, reason: collision with root package name */
    public final Activity f562h;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<Movie> f564j;

    /* renamed from: k, reason: collision with root package name */
    public final Typeface f565k;

    /* renamed from: l, reason: collision with root package name */
    public final c4.a f566l;

    /* renamed from: m, reason: collision with root package name */
    public final MainActivity f567m;

    /* renamed from: f, reason: collision with root package name */
    public final int f560f = 900;

    /* renamed from: i, reason: collision with root package name */
    public boolean f563i = true;

    /* compiled from: MovieAdapter.java */
    public class b extends RecyclerView.z {
        public final ImageView A;
        public final ImageView B;

        /* renamed from: u, reason: collision with root package name */
        public Movie f570u;

        /* renamed from: v, reason: collision with root package name */
        public final RelativeLayout f571v;

        /* renamed from: w, reason: collision with root package name */
        public final View f572w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f573x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f574y;

        /* renamed from: z, reason: collision with root package name */
        public final RelativeLayout f575z;

        public b(t tVar, View view) {
            super(view);
            this.f572w = view;
            this.A = (ImageView) view.findViewById(R.id.image);
            this.B = (ImageView) view.findViewById(R.id.place_holder_poster);
            this.f573x = (TextView) view.findViewById(R.id.title);
            this.f574y = (TextView) view.findViewById(R.id.year_textview);
            this.f575z = (RelativeLayout) view.findViewById(R.id.type_layout);
            this.f571v = (RelativeLayout) view.findViewById(R.id.image_back);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f573x.getText()) + "'";
        }
    }

    public t(Context context, ArrayList arrayList, Activity activity, int i10, gd.j jVar, MainActivity mainActivity) {
        this.f561g = 0;
        this.f564j = new ArrayList<>();
        this.f559e = context;
        this.f564j = arrayList;
        this.f562h = activity;
        this.f561g = i10;
        this.f558d = jVar;
        AssetManager assets = activity.getAssets();
        String str = Constant.f12450b;
        this.f565k = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f566l = new c4.a();
        this.f567m = mainActivity;
        new Random(19L).nextInt(10);
        ArrayList<String> arrayList2 = App.B;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f564j.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(this, c.c(viewGroup, R.layout.movie_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b bVar, int i10) {
        TextView textView = bVar.f573x;
        c4.a aVar = this.f566l;
        Typeface typeface = this.f565k;
        aVar.applyFontToView(textView, typeface);
        TextView textView2 = bVar.f574y;
        aVar.applyFontToView(textView2, typeface);
        ArrayList<Movie> arrayList = this.f564j;
        Movie movie = arrayList.get(i10);
        bVar.f570u = movie;
        boolean zIsSeries = movie.isSeries();
        int i11 = 8;
        RelativeLayout relativeLayout = bVar.f575z;
        if (zIsSeries) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        Movie movie2 = bVar.f570u;
        if (movie2.I == "null") {
            movie2.I = "";
        }
        bVar.f573x.setText(movie2.getTitle());
        textView2.setText(bVar.f570u.I);
        if (this.f561g == this.f560f && bVar.f570u.getServer().equals("is_series")) {
            textView2.setText("Season " + bVar.f570u.H);
        }
        boolean z10 = bVar.f570u.f12407y;
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
        ac.b bVar2 = new ac.b(this, bVar, i11);
        View view = bVar.f572w;
        view.setOnFocusChangeListener(bVar2);
        view.setOnLongClickListener(new e(this, bVar, i10, 3));
        view.setOnClickListener(new ub.v(14, this, bVar));
        if (i10 != 0 || (this.f562h instanceof SearchActivityTV)) {
            return;
        }
        view.requestFocus();
    }

    /* compiled from: MovieAdapter.java */
    public class a implements sa.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568a;

        public a(b bVar) {
            this.f568a = bVar;
        }

        @Override // sa.b
        public void onSuccess() {
            b bVar = this.f568a;
            t tVar = t.this;
            if (tVar.f563i) {
                tVar.f563i = false;
                try {
                    bVar.A.invalidate();
                    b2.b bVarGenerate = b2.b.from(((BitmapDrawable) bVar.A.getDrawable()).getBitmap()).generate();
                    bVar.f570u.f12403u = bVarGenerate.getDarkVibrantColor(0);
                    MainActivity mainActivity = tVar.f567m;
                    if (mainActivity != null) {
                        mainActivity.extractDominantColor(bVar.f570u.f12403u);
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
