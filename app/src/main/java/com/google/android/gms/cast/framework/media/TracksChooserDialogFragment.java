package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.fragment.app.n;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class TracksChooserDialogFragment extends n {
    public long[] A0;
    public AlertDialog B0;
    public RemoteMediaClient C0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f6539x0;

    /* renamed from: y0, reason: collision with root package name */
    public ArrayList f6540y0;

    /* renamed from: z0, reason: collision with root package name */
    public ArrayList f6541z0;

    @Deprecated
    public TracksChooserDialogFragment() {
    }

    public static TracksChooserDialogFragment newInstance() {
        return new TracksChooserDialogFragment();
    }

    public static int p(ArrayList arrayList, long[] jArr, int i10) {
        if (jArr != null && arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                for (long j10 : jArr) {
                    if (j10 == ((MediaTrack) arrayList.get(i11)).getId()) {
                        return i11;
                    }
                }
            }
        }
        return i10;
    }

    public static ArrayList q(int i10, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaTrack mediaTrack = (MediaTrack) it.next();
            if (mediaTrack.getType() == i10) {
                arrayList.add(mediaTrack);
            }
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) throws IllegalArgumentException {
        super.onCreate(bundle);
        this.f6539x0 = true;
        this.f6541z0 = new ArrayList();
        this.f6540y0 = new ArrayList();
        this.A0 = new long[0];
        CastSession currentCastSession = CastContext.getSharedInstance(getContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession != null && currentCastSession.isConnected()) {
            RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
            this.C0 = remoteMediaClient;
            if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.C0.getMediaInfo() != null) {
                RemoteMediaClient remoteMediaClient2 = this.C0;
                MediaStatus mediaStatus = remoteMediaClient2.getMediaStatus();
                if (mediaStatus != null) {
                    this.A0 = mediaStatus.getActiveTrackIds();
                }
                MediaInfo mediaInfo = remoteMediaClient2.getMediaInfo();
                if (mediaInfo == null) {
                    this.f6539x0 = false;
                    return;
                }
                List<MediaTrack> mediaTracks = mediaInfo.getMediaTracks();
                if (mediaTracks == null) {
                    this.f6539x0 = false;
                    return;
                }
                this.f6541z0 = q(2, mediaTracks);
                ArrayList arrayListQ = q(1, mediaTracks);
                this.f6540y0 = arrayListQ;
                if (arrayListQ.isEmpty()) {
                    return;
                }
                ArrayList arrayList = this.f6540y0;
                MediaTrack.Builder builder = new MediaTrack.Builder(-1L, 1);
                builder.setName(getActivity().getString(R.string.cast_tracks_chooser_dialog_none));
                builder.setSubtype(2);
                builder.setContentId("");
                arrayList.add(0, builder.build());
                return;
            }
        }
        this.f6539x0 = false;
    }

    @Override // androidx.fragment.app.n
    public Dialog onCreateDialog(Bundle bundle) {
        int iP = p(this.f6540y0, this.A0, 0);
        int iP2 = p(this.f6541z0, this.A0, -1);
        zzbu zzbuVar = new zzbu(getActivity(), this.f6540y0, iP);
        zzbu zzbuVar2 = new zzbu(getActivity(), this.f6541z0, iP2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.cast_tracks_chooser_dialog_layout, (ViewGroup) null);
        int i10 = R.id.text_list_view;
        ListView listView = (ListView) viewInflate.findViewById(i10);
        int i11 = R.id.audio_list_view;
        ListView listView2 = (ListView) viewInflate.findViewById(i11);
        TabHost tabHost = (TabHost) viewInflate.findViewById(R.id.tab_host);
        tabHost.setup();
        if (zzbuVar.getCount() == 0) {
            listView.setVisibility(4);
        } else {
            listView.setAdapter((ListAdapter) zzbuVar);
            TabHost.TabSpec tabSpecNewTabSpec = tabHost.newTabSpec("textTab");
            tabSpecNewTabSpec.setContent(i10);
            tabSpecNewTabSpec.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_subtitles));
            tabHost.addTab(tabSpecNewTabSpec);
        }
        if (zzbuVar2.getCount() <= 1) {
            listView2.setVisibility(4);
        } else {
            listView2.setAdapter((ListAdapter) zzbuVar2);
            TabHost.TabSpec tabSpecNewTabSpec2 = tabHost.newTabSpec("audioTab");
            tabSpecNewTabSpec2.setContent(i11);
            tabSpecNewTabSpec2.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_audio));
            tabHost.addTab(tabSpecNewTabSpec2);
        }
        builder.setView(viewInflate).setPositiveButton(getActivity().getString(R.string.cast_tracks_chooser_dialog_ok), new zzbr(this, zzbuVar, zzbuVar2)).setNegativeButton(R.string.cast_tracks_chooser_dialog_cancel, new zzbq(this));
        AlertDialog alertDialog = this.B0;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.B0 = null;
        }
        AlertDialog alertDialogCreate = builder.create();
        this.B0 = alertDialogCreate;
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
