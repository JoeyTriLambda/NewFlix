package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbu extends ArrayAdapter implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final Context f6762b;

    /* renamed from: m, reason: collision with root package name */
    public int f6763m;

    public zzbu(Context context, List list, int i10) {
        super(context, R.layout.cast_tracks_chooser_dialog_row_layout, list == null ? new ArrayList() : list);
        this.f6762b = context;
        this.f6763m = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = r7.f6762b
            if (r9 != 0) goto L32
            java.lang.String r9 = "layout_inflater"
            java.lang.Object r9 = r1.getSystemService(r9)
            android.view.LayoutInflater r9 = (android.view.LayoutInflater) r9
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            android.view.LayoutInflater r9 = (android.view.LayoutInflater) r9
            int r2 = com.google.android.gms.cast.framework.R.layout.cast_tracks_chooser_dialog_row_layout
            android.view.View r9 = r9.inflate(r2, r10, r0)
            com.google.android.gms.cast.framework.media.zzbt r10 = new com.google.android.gms.cast.framework.media.zzbt
            int r2 = com.google.android.gms.cast.framework.R.id.text
            android.view.View r2 = r9.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.google.android.gms.cast.framework.R.id.radio
            android.view.View r3 = r9.findViewById(r3)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            r10.<init>(r2, r3)
            r9.setTag(r10)
            goto L3e
        L32:
            java.lang.Object r10 = r9.getTag()
            com.google.android.gms.cast.framework.media.zzbt r10 = (com.google.android.gms.cast.framework.media.zzbt) r10
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            com.google.android.gms.cast.framework.media.zzbt r10 = (com.google.android.gms.cast.framework.media.zzbt) r10
        L3e:
            android.widget.RadioButton r2 = r10.f6761b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r2.setTag(r3)
            int r2 = r7.f6763m
            r3 = 1
            if (r2 != r8) goto L4e
            r2 = 1
            goto L4f
        L4e:
            r2 = 0
        L4f:
            android.widget.RadioButton r4 = r10.f6761b
            r4.setChecked(r2)
            r9.setOnClickListener(r7)
            java.lang.Object r2 = r7.getItem(r8)
            com.google.android.gms.cast.MediaTrack r2 = (com.google.android.gms.cast.MediaTrack) r2
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            com.google.android.gms.cast.MediaTrack r2 = (com.google.android.gms.cast.MediaTrack) r2
            java.lang.String r4 = r2.getName()
            java.util.Locale r5 = r2.getLanguageLocale()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L9b
            int r2 = r2.getSubtype()
            r4 = 2
            if (r2 != r4) goto L7f
            int r8 = com.google.android.gms.cast.framework.R.string.cast_tracks_chooser_dialog_closed_captions
            java.lang.String r4 = r1.getString(r8)
            goto L9b
        L7f:
            if (r5 == 0) goto L8c
            java.lang.String r4 = r5.getDisplayLanguage()
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto L8c
            goto L9b
        L8c:
            int r2 = com.google.android.gms.cast.framework.R.string.cast_tracks_chooser_dialog_default_track_name
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r8 = r8 + r3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r4[r0] = r8
            java.lang.String r4 = r1.getString(r2, r4)
        L9b:
            android.widget.TextView r8 = r10.f6760a
            r8.setText(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.zzbu.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6763m = ((Integer) Preconditions.checkNotNull(((zzbt) Preconditions.checkNotNull((zzbt) view.getTag())).f6761b.getTag())).intValue();
        notifyDataSetChanged();
    }

    public final MediaTrack zza() {
        int i10 = this.f6763m;
        if (i10 < 0 || i10 >= getCount()) {
            return null;
        }
        return (MediaTrack) getItem(this.f6763m);
    }
}
