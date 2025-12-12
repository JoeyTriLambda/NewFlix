package ac;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: KeyboardLetterAdapter.java */
/* loaded from: classes2.dex */
public final class r extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f546d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f547e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<String> f548f;

    /* renamed from: g, reason: collision with root package name */
    public final gd.i f549g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f550h;

    /* compiled from: KeyboardLetterAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public String f551u;

        /* renamed from: v, reason: collision with root package name */
        public final View f552v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f553w;

        public a(r rVar, View view) {
            super(view);
            this.f552v = view;
            this.f553w = (TextView) view.findViewById(R.id.letter_textview);
        }
    }

    public r(Context context, gd.i iVar, ArrayList<String> arrayList) {
        this.f548f = arrayList;
        this.f549g = iVar;
        AssetManager assets = context.getAssets();
        String str = Constant.f12450b;
        this.f547e = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f546d = new c4.a();
        this.f550h = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f548f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.keyboard_letter_item_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        String str = this.f548f.get(i10);
        aVar.f551u = str;
        String upperCase = str.toUpperCase();
        TextView textView = aVar.f553w;
        textView.setText(upperCase);
        this.f546d.applyFontToView(textView, this.f547e);
        ub.v vVar = new ub.v(13, this, aVar);
        View view = aVar.f552v;
        view.setOnClickListener(vVar);
        view.setOnFocusChangeListener(new b(this, aVar, 7));
    }
}
