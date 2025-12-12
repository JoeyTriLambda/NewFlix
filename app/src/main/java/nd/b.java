package nd;

import ac.g;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.f0;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.models.Movie;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CardMoviePresenter.java */
/* loaded from: classes2.dex */
public final class b extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public ProgressBar f16803a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Movie> f16804b;

    /* renamed from: c, reason: collision with root package name */
    public final Activity f16805c;

    /* renamed from: d, reason: collision with root package name */
    public final TVListFragmentMain f16806d;

    public b(ArrayList<Movie> arrayList, Activity activity, TVListFragmentMain tVListFragmentMain) {
        this.f16804b = arrayList;
        this.f16805c = activity;
        this.f16806d = tVListFragmentMain;
    }

    @Override // androidx.leanback.widget.f0
    public void onBindViewHolder(f0.a aVar, Object obj) {
        String str;
        Movie movie = (Movie) obj;
        ImageView imageView = (ImageView) aVar.f3216a.findViewById(R.id.poster_image);
        View view = aVar.f3216a;
        TextView textView = (TextView) view.findViewById(R.id.episode_title_card);
        this.f16803a = (ProgressBar) view.findViewById(R.id.progress_card);
        try {
            if (movie.isSeries()) {
                int i10 = App.getInstance().f11574v.getInt(movie.getMovieId() + "watched_season_index", -1);
                if (i10 > -1) {
                    int i11 = i10 + 1;
                    int i12 = App.getInstance().f11574v.getInt(movie.getMovieId() + "season" + i11 + "episode" + i11, 0) + 1;
                    String string = App.getInstance().f11574v.getString(movie.getMovieId() + "s" + i11 + "e" + i11 + "title", "");
                    if (string.length() > 1) {
                        textView.setText("S" + i11 + "E" + i12 + ": " + string);
                    } else {
                        textView.setText("S" + i11 + "E" + i12);
                    }
                    textView.setVisibility(0);
                }
            } else {
                textView.setVisibility(8);
                int i13 = App.getInstance().f11574v.getInt(movie.getMovieId() + "", -1);
                if (i13 > 0) {
                    Iterator<Movie> it = this.f16804b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().getMovieId() == movie.getMovieId() && movie.getDuration() > 0) {
                            this.f16803a.setVisibility(0);
                            this.f16803a.setProgress((int) ((i13 * 100) / (movie.getDuration() * 60000)));
                            int duration = movie.getDuration() - (i13 / 60000);
                            if (duration > 60) {
                                str = (duration / 60) + "h " + (duration % 60) + "m";
                            } else {
                                str = duration + "m";
                            }
                            textView.setText(str + " remaining");
                            textView.setVisibility(0);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        String str2 = "https://www.themoviedb.org/t/p/w780" + movie.f12400r;
        String str3 = movie.f12400r;
        if (str3 == null || str3.length() <= 10) {
            Picasso.get().load(R.drawable.ic_movie).fit().centerCrop().into(imageView);
        } else {
            try {
                Picasso.get().load(str2).fit().centerCrop().error(R.drawable.ic_movie).into(imageView);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        view.setOnLongClickListener(new g(3, this, movie));
    }

    @Override // androidx.leanback.widget.f0
    public f0.a onCreateViewHolder(ViewGroup viewGroup) {
        View viewC = ac.c.c(viewGroup, R.layout.movie_item_view_card, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewC.getLayoutParams();
        layoutParams.width = be.b.getWidthInPercent(viewGroup.getContext(), 28);
        layoutParams.height = be.b.getHeightInPercent(viewGroup.getContext(), 24);
        return new f0.a(viewC);
    }

    @Override // androidx.leanback.widget.f0
    public void onUnbindViewHolder(f0.a aVar) {
    }
}
