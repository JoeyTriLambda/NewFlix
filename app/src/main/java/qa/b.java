package qa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.powerspinner.PowerSpinnerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultSpinnerAdapter.kt */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.Adapter<a> implements f<CharSequence> {

    /* renamed from: d, reason: collision with root package name */
    public int f18040d;

    /* renamed from: e, reason: collision with root package name */
    public final PowerSpinnerView f18041e;

    /* renamed from: f, reason: collision with root package name */
    public d<CharSequence> f18042f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f18043g;

    /* compiled from: DefaultSpinnerAdapter.kt */
    public static final class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final ra.a f18044u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ra.a aVar) {
            super(aVar.getRoot());
            zf.i.checkNotNullParameter(aVar, "binding");
            this.f18044u = aVar;
        }

        public final void bind(CharSequence charSequence, PowerSpinnerView powerSpinnerView) {
            zf.i.checkNotNullParameter(charSequence, "item");
            zf.i.checkNotNullParameter(powerSpinnerView, "spinnerView");
            ra.a aVar = this.f18044u;
            AppCompatTextView appCompatTextView = aVar.f18897b;
            appCompatTextView.setText(charSequence);
            appCompatTextView.setTypeface(powerSpinnerView.getTypeface());
            appCompatTextView.setGravity(powerSpinnerView.getGravity());
            appCompatTextView.setTextSize(0, powerSpinnerView.getTextSize());
            appCompatTextView.setTextColor(powerSpinnerView.getCurrentTextColor());
            aVar.getRoot().setPadding(powerSpinnerView.getPaddingLeft(), powerSpinnerView.getPaddingTop(), powerSpinnerView.getPaddingRight(), powerSpinnerView.getPaddingBottom());
        }
    }

    /* compiled from: DefaultSpinnerAdapter.kt */
    /* renamed from: qa.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0230b implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f18045b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f18046m;

        public ViewOnClickListenerC0230b(a aVar, b bVar) {
            this.f18045b = aVar;
            this.f18046m = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer numValueOf = Integer.valueOf(this.f18045b.getBindingAdapterPosition());
            if (!(numValueOf.intValue() != -1)) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                this.f18046m.notifyItemSelected(numValueOf.intValue());
            }
        }
    }

    public b(PowerSpinnerView powerSpinnerView) {
        zf.i.checkNotNullParameter(powerSpinnerView, "powerSpinnerView");
        this.f18040d = powerSpinnerView.getSelectedIndex();
        this.f18041e = powerSpinnerView;
        this.f18043g = new ArrayList();
    }

    public int getIndex() {
        return this.f18040d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f18043g.size();
    }

    public d<CharSequence> getOnSpinnerItemSelectedListener() {
        return this.f18042f;
    }

    public PowerSpinnerView getSpinnerView() {
        return this.f18041e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qa.f
    public void notifyItemSelected(int i10) {
        if (i10 == -1) {
            return;
        }
        int index = getIndex();
        setIndex(i10);
        PowerSpinnerView spinnerView = getSpinnerView();
        ArrayList arrayList = this.f18043g;
        spinnerView.notifyItemSelected(i10, (CharSequence) arrayList.get(i10));
        d<CharSequence> onSpinnerItemSelectedListener = getOnSpinnerItemSelectedListener();
        if (onSpinnerItemSelectedListener != 0) {
            Integer numValueOf = Integer.valueOf(index);
            CharSequence charSequence = null;
            if (!(numValueOf.intValue() != -1)) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                numValueOf.intValue();
                charSequence = (CharSequence) arrayList.get(index);
            }
            onSpinnerItemSelectedListener.onItemSelected(index, charSequence, i10, arrayList.get(i10));
        }
    }

    public void setIndex(int i10) {
        this.f18040d = i10;
    }

    @Override // qa.f
    public void setItems(List<? extends CharSequence> list) {
        zf.i.checkNotNullParameter(list, "itemList");
        ArrayList arrayList = this.f18043g;
        arrayList.clear();
        arrayList.addAll(list);
        setIndex(-1);
        notifyDataSetChanged();
    }

    @Override // qa.f
    public void setOnSpinnerItemSelectedListener(d<CharSequence> dVar) {
        this.f18042f = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        zf.i.checkNotNullParameter(aVar, "holder");
        aVar.bind((CharSequence) this.f18043g.get(i10), getSpinnerView());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        zf.i.checkNotNullParameter(viewGroup, "parent");
        ra.a aVarInflate = ra.a.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        zf.i.checkNotNullExpressionValue(aVarInflate, "ItemDefaultPowerSpinnerL…nt,\n        false\n      )");
        a aVar = new a(aVarInflate);
        aVarInflate.getRoot().setOnClickListener(new ViewOnClickListenerC0230b(aVar, this));
        return aVar;
    }
}
