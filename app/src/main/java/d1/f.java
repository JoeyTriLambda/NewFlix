package d1;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper.java */
/* loaded from: classes.dex */
public final class f extends a {
    public final ListView C;

    public f(ListView listView) {
        super(listView);
        this.C = listView;
    }

    @Override // d1.a
    public boolean canTargetScrollHorizontally(int i10) {
        return false;
    }

    @Override // d1.a
    public boolean canTargetScrollVertically(int i10) {
        ListView listView = this.C;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i11 = firstVisiblePosition + childCount;
        if (i10 > 0) {
            if (i11 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i10 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // d1.a
    public void scrollTargetBy(int i10, int i11) {
        this.C.scrollListBy(i11);
    }
}
