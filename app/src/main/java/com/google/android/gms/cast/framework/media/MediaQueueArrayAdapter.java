package com.google.android.gms.cast.framework.media;

import android.widget.ArrayAdapter;
import com.google.android.gms.cast.MediaQueueItem;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class MediaQueueArrayAdapter extends ArrayAdapter<MediaQueueItem> {
    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        throw null;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public MediaQueueItem getItem(int i10) {
        throw null;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i10) {
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        throw null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        throw null;
    }
}
