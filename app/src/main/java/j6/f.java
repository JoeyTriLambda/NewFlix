package j6;

import u5.n;

/* compiled from: TrackSelection.java */
/* loaded from: classes.dex */
public interface f {

    /* compiled from: TrackSelection.java */
    public interface a {
    }

    boolean blacklist(int i10, long j10);

    c5.i getFormat(int i10);

    int getIndexInTrackGroup(int i10);

    c5.i getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    n getTrackGroup();

    int indexOf(int i10);

    int indexOf(c5.i iVar);

    int length();

    void updateSelectedTrack(long j10);
}
