package ac;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import java.util.ArrayList;

/* compiled from: ColorAdapter.java */
/* loaded from: classes2.dex */
public final class l extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final String f497d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<hd.e> f498e;

    /* renamed from: f, reason: collision with root package name */
    public final Activity f499f;

    /* renamed from: g, reason: collision with root package name */
    public androidx.appcompat.app.d f500g;

    /* compiled from: ColorAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.e f501u;

        /* renamed from: v, reason: collision with root package name */
        public final ImageView f502v;

        /* renamed from: w, reason: collision with root package name */
        public final RelativeLayout f503w;

        /* renamed from: x, reason: collision with root package name */
        public final View f504x;

        /* renamed from: y, reason: collision with root package name */
        public final View f505y;

        public a(l lVar, View view) {
            super(view);
            this.f504x = view;
            this.f505y = view.findViewById(R.id.color_view);
            this.f502v = (ImageView) view.findViewById(R.id.check_icon);
            this.f503w = (RelativeLayout) view.findViewById(R.id.image_back);
        }
    }

    public l(Activity activity, ArrayList<hd.e> arrayList, String str) {
        this.f497d = "mouse_toggle_color";
        this.f498e = arrayList;
        this.f499f = activity;
        this.f497d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f498e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.color_item_view, viewGroup, false));
    }

    public void setAlertDialog(androidx.appcompat.app.d dVar) {
        this.f500g = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        hd.e eVar = this.f498e.get(i10);
        aVar.f501u = eVar;
        aVar.f505y.setBackgroundResource(eVar.f12990a);
        boolean z10 = aVar.f501u.f12991b;
        ImageView imageView = aVar.f502v;
        if (z10) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ub.v vVar = new ub.v(10, this, aVar);
        View view = aVar.f504x;
        view.setOnClickListener(vVar);
        view.setOnFocusChangeListener(new b(this, aVar, 4));
    }
}
