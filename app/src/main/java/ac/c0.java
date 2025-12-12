package ac;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;

/* compiled from: VideoSourceAdapter.java */
/* loaded from: classes2.dex */
public final class c0 extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final c4.a f397d;

    /* renamed from: e, reason: collision with root package name */
    public final Typeface f398e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f399f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f400g;

    /* renamed from: h, reason: collision with root package name */
    public final Activity f401h;

    /* compiled from: VideoSourceAdapter.java */
    public class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public hd.o f402u;

        /* renamed from: v, reason: collision with root package name */
        public final View f403v;

        /* renamed from: w, reason: collision with root package name */
        public final TextView f404w;

        /* renamed from: x, reason: collision with root package name */
        public final TextView f405x;

        public a(c0 c0Var, View view) {
            super(view);
            this.f403v = view;
            this.f404w = (TextView) view.findViewById(R.id.link_main_label);
            this.f405x = (TextView) view.findViewById(R.id.link_detail_view);
        }
    }

    public c0(Activity activity, ArrayList<hd.o> arrayList) {
        this.f400g = arrayList;
        this.f401h = activity;
        AssetManager assets = activity.getAssets();
        String str = Constant.f12450b;
        this.f398e = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f399f = Typeface.createFromAsset(activity.getAssets(), "fonts/product_sans_bold.ttf");
        this.f397d = new c4.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f400g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return super.getItemId(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(this, c.c(viewGroup, R.layout.video_source_item_view_new, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        hd.o oVar = this.f400g.get(i10);
        aVar.f402u = oVar;
        oVar.C = oVar.C.replace(" - ", " · ").replace("- ", " · ").replace(" -", "·");
        hd.o oVar2 = aVar.f402u;
        boolean z10 = oVar2.f13046v;
        c4.a aVar2 = this.f397d;
        TextView textView = aVar.f404w;
        TextView textView2 = aVar.f405x;
        if (z10 || oVar2.f13047w) {
            Typeface typeface = this.f399f;
            aVar2.applyFontToView(textView, typeface);
            aVar2.applyFontToView(textView2, typeface);
        } else {
            Typeface typeface2 = this.f398e;
            aVar2.applyFontToView(textView, typeface2);
            aVar2.applyFontToView(textView2, typeface2);
        }
        if (aVar.f402u.f13041q) {
            textView2.setAlpha(0.4f);
            textView.setAlpha(0.4f);
        } else {
            textView2.setAlpha(1.0f);
            textView.setAlpha(1.0f);
        }
        hd.o oVar3 = aVar.f402u;
        if (oVar3 == null) {
            return;
        }
        if (oVar3.f13050z) {
            textView2.setTextColor(-416706);
            textView2.setText("Direct · Real-Debrid");
        } else if (oVar3.A) {
            textView2.setTextColor(-416706);
            textView2.setText("Direct · Premiumize");
        } else {
            boolean z11 = oVar3.B;
            if (z11 || z11) {
                textView2.setTextColor(-416706);
                textView2.setText("Direct · AllDebrid");
            } else if (oVar3.f13047w) {
                textView2.setTextColor(this.f401h.getResources().getColor(R.color.accent));
                textView2.setText("Direct Stream");
            } else {
                textView2.setTextColor(-1);
                textView2.setText("Embed");
                if (aVar.f402u.hasSubtitles()) {
                    textView2.setText("Embed · Subtitles");
                } else if (aVar.f402u.hasMultiSubtitles()) {
                    textView2.setText("Embed · Subtitles · Multilanguage");
                }
            }
        }
        if (aVar.f402u.f13036b != null) {
            textView2.setText(((Object) textView2.getText()) + " - " + aVar.f402u.f13036b);
        }
        b bVar = new b(this, aVar, 12);
        View view = aVar.f403v;
        view.setOnFocusChangeListener(bVar);
        textView.setText(aVar.f402u.C);
        view.setOnClickListener(new ub.v(19, this, aVar));
        view.setOnLongClickListener(new g(2, this, aVar));
    }
}
