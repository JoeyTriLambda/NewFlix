package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import c5.i;
import java.util.List;
import java.util.UUID;
import l6.t;
import l6.u;

/* compiled from: SsManifest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5993a;

    /* renamed from: b, reason: collision with root package name */
    public final C0073a f5994b;

    /* renamed from: c, reason: collision with root package name */
    public final b[] f5995c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5996d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5997e;

    /* compiled from: SsManifest.java */
    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    public static class C0073a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f5998a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f5999b;

        public C0073a(UUID uuid, byte[] bArr) {
            this.f5998a = uuid;
            this.f5999b = bArr;
        }
    }

    /* compiled from: SsManifest.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6000a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6001b;

        /* renamed from: c, reason: collision with root package name */
        public final i[] f6002c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6003d;

        /* renamed from: e, reason: collision with root package name */
        public final String f6004e;

        /* renamed from: f, reason: collision with root package name */
        public final String f6005f;

        /* renamed from: g, reason: collision with root package name */
        public final List<Long> f6006g;

        /* renamed from: h, reason: collision with root package name */
        public final long[] f6007h;

        /* renamed from: i, reason: collision with root package name */
        public final long f6008i;

        public b(String str, String str2, int i10, String str3, long j10, String str4, int i11, int i12, int i13, int i14, String str5, i[] iVarArr, List<Long> list, long j11) {
            this.f6004e = str;
            this.f6005f = str2;
            this.f6000a = i10;
            this.f6001b = j10;
            this.f6002c = iVarArr;
            this.f6003d = list.size();
            this.f6006g = list;
            this.f6008i = u.scaleLargeTimestamp(j11, 1000000L, j10);
            this.f6007h = u.scaleLargeTimestamps(list, 1000000L, j10);
        }

        public Uri buildRequestUri(int i10, int i11) {
            i[] iVarArr = this.f6002c;
            l6.a.checkState(iVarArr != null);
            List<Long> list = this.f6006g;
            l6.a.checkState(list != null);
            l6.a.checkState(i11 < list.size());
            String string = Integer.toString(iVarArr[i10].f5116m);
            String string2 = list.get(i11).toString();
            return t.resolveToUri(this.f6004e, this.f6005f.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        }

        public long getChunkDurationUs(int i10) {
            if (i10 == this.f6003d - 1) {
                return this.f6008i;
            }
            long[] jArr = this.f6007h;
            return jArr[i10 + 1] - jArr[i10];
        }

        public int getChunkIndex(long j10) {
            return u.binarySearchFloor(this.f6007h, j10, true, true);
        }

        public long getStartTimeUs(int i10) {
            return this.f6007h[i10];
        }
    }

    public a(int i10, int i11, long j10, long j11, long j12, int i12, boolean z10, C0073a c0073a, b[] bVarArr) {
        this.f5993a = z10;
        this.f5994b = c0073a;
        this.f5995c = bVarArr;
        this.f5997e = j12 == 0 ? -9223372036854775807L : u.scaleLargeTimestamp(j12, 1000000L, j10);
        this.f5996d = j11 != 0 ? u.scaleLargeTimestamp(j11, 1000000L, j10) : -9223372036854775807L;
    }
}
