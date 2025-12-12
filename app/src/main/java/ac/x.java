package ac;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.activities.MainActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class x implements View.OnLongClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f598b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f599m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f600n;

    public /* synthetic */ x(RecyclerView.Adapter adapter, int i10, int i11) {
        this.f598b = i11;
        this.f600n = adapter;
        this.f599m = i10;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i10 = this.f598b;
        int i11 = this.f599m;
        RecyclerView.Adapter adapter = this.f600n;
        switch (i10) {
            case 0:
                y yVar = (y) adapter;
                yVar.f602e.onLongPress(i11, yVar.f603f);
                return true;
            default:
                MainActivity mainActivity = ((e0) adapter).f437e;
                if (mainActivity == null) {
                    return false;
                }
                mainActivity.longClickMovie(i11);
                return false;
        }
    }
}
