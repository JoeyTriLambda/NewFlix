package nd;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.f0;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import flix.com.vision.models.Movie;

/* compiled from: MoviePresenter.java */
/* loaded from: classes2.dex */
public final class d extends f0 {
    @Override // androidx.leanback.widget.f0
    public void onBindViewHolder(f0.a aVar, Object obj) {
        Movie movie = (Movie) obj;
        try {
            Picasso.get().load(movie.getImage_url()).fit().error(R.drawable.ic_movie).centerCrop().into((ImageView) aVar.f3216a.findViewById(R.id.poster_image));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.leanback.widget.f0
    public f0.a onCreateViewHolder(ViewGroup viewGroup) {
        View viewC = ac.c.c(viewGroup, R.layout.movie_item_view_tv, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewC.getLayoutParams();
        layoutParams.width = be.b.getWidthInPercent(viewGroup.getContext(), 12);
        layoutParams.height = be.b.getHeightInPercent(viewGroup.getContext(), 32);
        return new f0.a(viewC);
    }

    @Override // androidx.leanback.widget.f0
    public void onUnbindViewHolder(f0.a aVar) {
    }
}
