package ac;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.models.Drama;
import java.util.ArrayList;

/* compiled from: DramaContinueAdapter.java */
/* loaded from: classes2.dex */
public final class n extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final gd.e f515d;

    /* renamed from: e, reason: collision with root package name */
    public final DramaHomeActivity f516e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<Drama> f517f;

    /* compiled from: DramaContinueAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public Drama f518u;

        /* renamed from: v, reason: collision with root package name */
        public final FrameLayout f519v;

        /* renamed from: w, reason: collision with root package name */
        public final View f520w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f521x;

        /* renamed from: y, reason: collision with root package name */
        public final TextView f522y;

        /* renamed from: z, reason: collision with root package name */
        public final ImageView f523z;

        public a(n nVar, View view) {
            super(view);
            this.f520w = view;
            this.f523z = (ImageView) view.findViewById(R.id.image);
            this.f521x = (TextView) view.findViewById(R.id.title);
            this.f522y = (TextView) view.findViewById(R.id.year_textview);
            this.f519v = (FrameLayout) view.findViewById(R.id.image_back);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public String toString() {
            return super.toString() + " '" + ((Object) this.f521x.getText()) + "'";
        }
    }

    public n(ArrayList<Drama> arrayList, DramaHomeActivity dramaHomeActivity, gd.e eVar) {
        this.f517f = arrayList;
        this.f516e = dramaHomeActivity;
        this.f515d = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f517f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.drama_continue_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        ArrayList<Drama> arrayList = this.f517f;
        Drama drama = arrayList.get(i10);
        aVar.f518u = drama;
        String strTrim = drama.f12389n;
        int i11 = 6;
        if (strTrim.toLowerCase().endsWith(")")) {
            String strSubstring = strTrim.substring(strTrim.length() - 6);
            strTrim = strTrim.replace(strSubstring, "").trim();
            aVar.f522y.setText(strSubstring.replace("(", "").replace(")", ""));
        }
        aVar.f521x.setText(strTrim);
        try {
            Picasso.get().load(arrayList.get(i10).f12392q).fit().centerCrop().into(aVar.f523z);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        b bVar = new b(this, aVar, i11);
        View view = aVar.f520w;
        view.setOnFocusChangeListener(bVar);
        view.setOnClickListener(new ub.v(12, this, aVar));
        view.setOnLongClickListener(new e(this, aVar, i10, 2));
        if (i10 == 0) {
            view.requestFocus();
        }
    }
}
