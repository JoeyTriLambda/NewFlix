package ac;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import java.util.ArrayList;

/* compiled from: AdultVideoAdapter.java */
/* loaded from: classes2.dex */
public final class f extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<id.c> f444d;

    /* renamed from: e, reason: collision with root package name */
    public final Activity f445e;

    /* renamed from: f, reason: collision with root package name */
    public final gd.b f446f;

    /* compiled from: AdultVideoAdapter.java */
    public class a extends RecyclerView.z {
        public final View A;
        public final ImageView B;

        /* renamed from: u, reason: collision with root package name */
        public id.c f447u;

        /* renamed from: v, reason: collision with root package name */
        public final LinearLayout f448v;

        /* renamed from: w, reason: collision with root package name */
        public final RelativeLayout f449w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f450x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f451y;

        /* renamed from: z, reason: collision with root package name */
        public final TextView f452z;

        public a(f fVar, View view) {
            super(view);
            this.A = view;
            this.f449w = (RelativeLayout) view.findViewById(R.id.resolution_holder);
            this.f450x = (TextView) view.findViewById(R.id.adult_category_title);
            this.f451y = (TextView) view.findViewById(R.id.adult_video_resolution);
            this.f452z = (TextView) view.findViewById(R.id.adult_video_duration);
            this.B = (ImageView) view.findViewById(R.id.adult_cat_poster);
            this.f448v = (LinearLayout) view.findViewById(R.id.item_background);
        }
    }

    public f(Activity activity, gd.b bVar, ArrayList<id.c> arrayList) {
        this.f446f = bVar;
        this.f444d = arrayList;
        this.f445e = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f444d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, @SuppressLint({"RecyclerView"}) int i10) {
        id.c cVar = this.f444d.get(i10);
        aVar.f447u = cVar;
        aVar.f450x.setText(cVar.f13365a);
        aVar.f452z.setText(aVar.f447u.f13368d);
        String str = aVar.f447u.f13369e;
        int i11 = 0;
        RelativeLayout relativeLayout = aVar.f449w;
        if (str == null || str.isEmpty()) {
            relativeLayout.setVisibility(4);
        } else {
            relativeLayout.setVisibility(0);
        }
        aVar.f451y.setText(aVar.f447u.f13369e);
        int i12 = 1;
        ac.a aVar2 = new ac.a(this, i10, i12);
        View view = aVar.A;
        view.setOnClickListener(aVar2);
        if (aVar.f447u.f13367c != null) {
            try {
                Picasso.get().load(aVar.f447u.f13367c).fit().centerCrop().into(aVar.B);
            } catch (Exception e10) {
                try {
                    e10.printStackTrace();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        view.setOnFocusChangeListener(new b(this, aVar, i12));
        view.setOnLongClickListener(new e(this, i10, aVar, i11));
        view.setTag(Integer.valueOf(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, !(App.getInstance().f11574v.getBoolean("pref_adult_show_big_pictures", false) && !(this.f445e instanceof AdultVideoPlayerActivity)) ? c.c(viewGroup, R.layout.adult_video_item_view, viewGroup, false) : c.c(viewGroup, R.layout.adult_video_item_view_big, viewGroup, false));
    }
}
