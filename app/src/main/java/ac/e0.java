package ac;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.models.Movie;
import java.util.ArrayList;

/* compiled from: WatchingAdapter.java */
/* loaded from: classes2.dex */
public final class e0 extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final gd.j f436d;

    /* renamed from: e, reason: collision with root package name */
    public final MainActivity f437e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<Movie> f438f;

    /* compiled from: WatchingAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public Movie f439u;

        /* renamed from: v, reason: collision with root package name */
        public final View f440v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f441w;

        /* renamed from: x, reason: collision with root package name */
        public final ImageView f442x;

        /* renamed from: y, reason: collision with root package name */
        public final ProgressBar f443y;

        public a(e0 e0Var, View view) {
            super(view);
            this.f440v = view;
            this.f441w = (TextView) view.findViewById(R.id.episode_title_card);
            this.f442x = (ImageView) view.findViewById(R.id.poster_image);
            this.f443y = (ProgressBar) view.findViewById(R.id.progress_watching_main);
        }
    }

    public e0(Context context, ArrayList<Movie> arrayList, MainActivity mainActivity, gd.j jVar) {
        this.f438f = arrayList;
        this.f437e = mainActivity;
        this.f436d = jVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f438f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.movie_item_view_watching, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        aVar.f439u = this.f438f.get(i10);
        ProgressBar progressBar = aVar.f443y;
        String str = aVar.f439u.getMovieId() + "";
        String str2 = aVar.f439u.f12400r;
        int i11 = 1;
        if (str2 != null && str2.length() > 1) {
            try {
                try {
                    Picasso.get().load("https://www.themoviedb.org/t/p/w300" + aVar.f439u.f12400r).fit().centerCrop().into(aVar.f442x);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        if (App.getInstance().f11574v.getInt(str, -1) > 0) {
            try {
                if (aVar.f439u.getDuration() > 0) {
                    progressBar.setVisibility(0);
                    progressBar.setProgress((int) ((r1 * 100) / (aVar.f439u.getDuration() * 60000)));
                }
            } catch (Exception unused) {
            }
        }
        x xVar = new x(this, i10, i11);
        View view = aVar.f440v;
        view.setOnLongClickListener(xVar);
        view.setOnClickListener(new ub.v(21, this, aVar));
        view.setOnFocusChangeListener(new ub.b(7));
        Movie movie = aVar.f439u;
        boolean zIsSeries = movie.isSeries();
        TextView textView = aVar.f441w;
        if (!zIsSeries) {
            textView.setText(movie.getTitle());
            return;
        }
        try {
            int i12 = App.getInstance().f11574v.getInt(movie.getMovieId() + "watched_season_index", -1);
            if (i12 > -1) {
                int i13 = i12 + 1;
                int i14 = App.getInstance().f11574v.getInt(movie.getMovieId() + "season" + i13 + "episode" + i13, 0) + 1;
                String title = movie.getTitle();
                if (title.length() > 1) {
                    textView.setText("S" + i13 + "E" + i14 + " · " + title);
                } else {
                    textView.setText("S" + i13 + "E" + i14);
                }
            }
        } catch (Exception unused2) {
        }
    }
}
