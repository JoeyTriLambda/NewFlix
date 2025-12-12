package e1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import e1.b;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b, reason: collision with root package name */
    public boolean f11114b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11115m;

    /* renamed from: n, reason: collision with root package name */
    public Cursor f11116n;

    /* renamed from: o, reason: collision with root package name */
    public Context f11117o;

    /* renamed from: p, reason: collision with root package name */
    public int f11118p;

    /* renamed from: q, reason: collision with root package name */
    public C0134a f11119q;

    /* renamed from: r, reason: collision with root package name */
    public b f11120r;

    /* renamed from: s, reason: collision with root package name */
    public e1.b f11121s;

    /* compiled from: CursorAdapter.java */
    /* renamed from: e1.a$a, reason: collision with other inner class name */
    public class C0134a extends ContentObserver {
        public C0134a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.onContentChanged();
        }
    }

    /* compiled from: CursorAdapter.java */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f11114b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f11114b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        int i10 = z10 ? 1 : 2;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f11115m = true;
        } else {
            this.f11115m = false;
        }
        boolean z11 = cursor != null;
        this.f11116n = cursor;
        this.f11114b = z11;
        this.f11117o = context;
        this.f11118p = z11 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.f11119q = new C0134a();
            this.f11120r = new b();
        } else {
            this.f11119q = null;
            this.f11120r = null;
        }
        if (z11) {
            C0134a c0134a = this.f11119q;
            if (c0134a != null) {
                cursor.registerContentObserver(c0134a);
            }
            b bVar = this.f11120r;
            if (bVar != null) {
                cursor.registerDataSetObserver(bVar);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor cursorSwapCursor = swapCursor(cursor);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    public abstract CharSequence convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f11114b || (cursor = this.f11116n) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor getCursor() {
        return this.f11116n;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f11114b) {
            return null;
        }
        this.f11116n.moveToPosition(i10);
        if (view == null) {
            view = newDropDownView(this.f11117o, this.f11116n, viewGroup);
        }
        bindView(view, this.f11117o, this.f11116n);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f11121s == null) {
            this.f11121s = new e1.b(this);
        }
        return this.f11121s;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f11114b || (cursor = this.f11116n) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f11116n;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f11114b && (cursor = this.f11116n) != null && cursor.moveToPosition(i10)) {
            return this.f11116n.getLong(this.f11118p);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f11114b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f11116n.moveToPosition(i10)) {
            throw new IllegalStateException(ac.c.f("couldn't move cursor to position ", i10));
        }
        if (view == null) {
            view = newView(this.f11117o, this.f11116n, viewGroup);
        }
        bindView(view, this.f11117o, this.f11116n);
        return view;
    }

    public abstract View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public void onContentChanged() {
        Cursor cursor;
        if (!this.f11115m || (cursor = this.f11116n) == null || cursor.isClosed()) {
            return;
        }
        this.f11114b = this.f11116n.requery();
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f11116n;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0134a c0134a = this.f11119q;
            if (c0134a != null) {
                cursor2.unregisterContentObserver(c0134a);
            }
            b bVar = this.f11120r;
            if (bVar != null) {
                cursor2.unregisterDataSetObserver(bVar);
            }
        }
        this.f11116n = cursor;
        if (cursor != null) {
            C0134a c0134a2 = this.f11119q;
            if (c0134a2 != null) {
                cursor.registerContentObserver(c0134a2);
            }
            b bVar2 = this.f11120r;
            if (bVar2 != null) {
                cursor.registerDataSetObserver(bVar2);
            }
            this.f11118p = cursor.getColumnIndexOrThrow("_id");
            this.f11114b = true;
            notifyDataSetChanged();
        } else {
            this.f11118p = -1;
            this.f11114b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
