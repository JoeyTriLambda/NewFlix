package ac;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import flix.com.vision.models.Drama;
import java.util.ArrayList;

/* compiled from: DramaAdapter.java */
/* loaded from: classes2.dex */
public final class m extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final gd.e f506d;

    /* renamed from: e, reason: collision with root package name */
    public final Activity f507e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<Drama> f508f;

    /* compiled from: DramaAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public Drama f509u;

        /* renamed from: v, reason: collision with root package name */
        public final FrameLayout f510v;

        /* renamed from: w, reason: collision with root package name */
        public final View f511w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f512x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f513y;

        /* renamed from: z, reason: collision with root package name */
        public final ImageView f514z;

        public a(m mVar, View view) {
            super(view);
            this.f511w = view;
            this.f514z = (ImageView) view.findViewById(R.id.image);
            this.f512x = (TextView) view.findViewById(R.id.title);
            this.f513y = (TextView) view.findViewById(R.id.year_textview);
            this.f510v = (FrameLayout) view.findViewById(R.id.image_back);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f512x.getText()) + "'";
        }
    }

    public m(ArrayList<Drama> arrayList, Activity activity, gd.e eVar) {
        this.f508f = arrayList;
        this.f507e = activity;
        this.f506d = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f508f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.drama_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        ArrayList<Drama> arrayList = this.f508f;
        Drama drama = arrayList.get(i10);
        aVar.f509u = drama;
        String str = drama.f12389n;
        aVar.f513y.setText(drama.f12387b);
        aVar.f512x.setText(str);
        try {
            Picasso.get().load(arrayList.get(i10).f12392q).fit().centerCrop().into(aVar.f514z);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        b bVar = new b(this, aVar, 5);
        View view = aVar.f511w;
        view.setOnFocusChangeListener(bVar);
        view.setOnClickListener(new ub.v(11, this, aVar));
        view.setOnLongClickListener(new g(1, this, aVar));
        if (i10 == 0) {
            view.requestFocus();
        }
    }
}
