package com.google.android.exoplayer2.source.hls.playlist;

import c5.i;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsMasterPlaylist.java */
/* loaded from: classes.dex */
public final class a extends z5.a {

    /* renamed from: c, reason: collision with root package name */
    public final List<C0072a> f5906c;

    /* renamed from: d, reason: collision with root package name */
    public final List<C0072a> f5907d;

    /* renamed from: e, reason: collision with root package name */
    public final List<C0072a> f5908e;

    /* renamed from: f, reason: collision with root package name */
    public final i f5909f;

    /* renamed from: g, reason: collision with root package name */
    public final List<i> f5910g;

    /* compiled from: HlsMasterPlaylist.java */
    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a, reason: collision with other inner class name */
    public static final class C0072a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5911a;

        /* renamed from: b, reason: collision with root package name */
        public final i f5912b;

        public C0072a(String str, i iVar) {
            this.f5911a = str;
            this.f5912b = iVar;
        }

        public static C0072a createMediaPlaylistHlsUrl(String str) {
            return new C0072a(str, i.createContainerFormat("0", "application/x-mpegURL", null, null, -1, 0, null));
        }
    }

    public a(String str, List<String> list, List<C0072a> list2, List<C0072a> list3, List<C0072a> list4, i iVar, List<i> list5) {
        super(str, list);
        this.f5906c = Collections.unmodifiableList(list2);
        this.f5907d = Collections.unmodifiableList(list3);
        this.f5908e = Collections.unmodifiableList(list4);
        this.f5909f = iVar;
        this.f5910g = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a createSingleVariantMasterPlaylist(String str) {
        List listSingletonList = Collections.singletonList(C0072a.createMediaPlaylistHlsUrl(str));
        List listEmptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), listSingletonList, listEmptyList, listEmptyList, null, null);
    }
}
