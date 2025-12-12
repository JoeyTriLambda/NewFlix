package ac;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import java.util.ArrayList;

/* compiled from: NetworkAdapter.java */
/* loaded from: classes2.dex */
public final class u extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final Activity f576d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<ld.a> f577e;

    /* compiled from: NetworkAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public ld.a f578u;

        /* renamed from: v, reason: collision with root package name */
        public final View f579v;

        /* renamed from: w, reason: collision with root package name */
        public final ImageView f580w;

        public a(u uVar, View view) {
            super(view);
            this.f579v = view;
            this.f580w = (ImageView) view.findViewById(R.id.network_image);
        }
    }

    public u(Context context, ArrayList<ld.a> arrayList, Activity activity) {
        this.f577e = arrayList;
        this.f576d = activity;
        new fd.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f577e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.network_item_view_main, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        ld.a aVar2 = this.f577e.get(i10);
        aVar.f578u = aVar2;
        if (aVar2.f16049c > 1) {
            try {
                try {
                    Picasso.get().load(aVar.f578u.f16049c).fit().into(aVar.f580w);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        ub.b bVar = new ub.b(5);
        View view = aVar.f579v;
        view.setOnFocusChangeListener(bVar);
        view.setOnClickListener(new ub.v(15, this, aVar));
    }
}
