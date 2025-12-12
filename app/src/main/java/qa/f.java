package qa;

import java.util.List;

/* compiled from: PowerSpinnerInterface.kt */
/* loaded from: classes2.dex */
public interface f<T> {
    int getItemCount();

    void notifyItemSelected(int i10);

    void setItems(List<? extends T> list);

    void setOnSpinnerItemSelectedListener(d<T> dVar);
}
