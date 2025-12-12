package ra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.powerspinner.R;

/* compiled from: LayoutBodyPowerSpinnerLibraryBinding.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f18898a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f18899b;

    public b(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f18898a = frameLayout;
        this.f18899b = recyclerView;
    }

    public static b bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i10);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new b(frameLayout, recyclerView);
    }

    public static b inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_body_power_spinner_library, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
