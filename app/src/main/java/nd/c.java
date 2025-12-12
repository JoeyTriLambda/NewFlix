package nd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.f0;
import com.squareup.picasso.Picasso;
import flix.com.vision.R;
import java.util.ArrayList;

/* compiled from: CardNetworkPresenter.java */
/* loaded from: classes2.dex */
public final class c extends f0 {
    public c(ArrayList<ld.a> arrayList) {
    }

    @Override // androidx.leanback.widget.f0
    public void onBindViewHolder(f0.a aVar, Object obj) {
        ld.a aVar2 = (ld.a) obj;
        try {
            Picasso.get().load(aVar2.f16049c).fit().centerInside().error(R.drawable.ic_movie).into((ImageView) aVar.f3216a.findViewById(R.id.poster_image));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.leanback.widget.f0
    public f0.a onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getContext();
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.network_item_view_card, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        layoutParams.width = be.b.getWidthInPercent(viewGroup.getContext(), 20);
        layoutParams.height = be.b.getHeightInPercent(viewGroup.getContext(), 12);
        return new f0.a(viewInflate);
    }

    @Override // androidx.leanback.widget.f0
    public void onUnbindViewHolder(f0.a aVar) {
    }
}
