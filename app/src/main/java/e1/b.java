package e1;

import android.database.Cursor;
import android.widget.Filter;
import androidx.appcompat.widget.w0;

/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
public final class b extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public final a f11124a;

    /* compiled from: CursorFilter.java */
    public interface a {
    }

    public b(a aVar) {
        this.f11124a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return ((w0) this.f11124a).convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorRunQueryOnBackgroundThread = ((w0) this.f11124a).runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorRunQueryOnBackgroundThread != null) {
            filterResults.count = cursorRunQueryOnBackgroundThread.getCount();
            filterResults.values = cursorRunQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f11124a;
        Cursor cursor = ((e1.a) aVar).getCursor();
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((w0) aVar).changeCursor((Cursor) obj);
    }
}
