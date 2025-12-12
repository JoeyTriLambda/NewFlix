package mc;

import flix.com.vision.exomedia.ExoMedia$RendererType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import sc.a;
import tc.c;
import tc.e;

/* compiled from: ExoMedia.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f16262a;

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f16263b;

    static {
        HashMap map = new HashMap();
        f16262a = map;
        ArrayList arrayList = new ArrayList();
        f16263b = arrayList;
        ExoMedia$RendererType exoMedia$RendererType = ExoMedia$RendererType.AUDIO;
        map.put(exoMedia$RendererType, new LinkedList());
        ExoMedia$RendererType exoMedia$RendererType2 = ExoMedia$RendererType.VIDEO;
        map.put(exoMedia$RendererType2, new LinkedList());
        map.put(ExoMedia$RendererType.CLOSED_CAPTION, new LinkedList());
        map.put(ExoMedia$RendererType.METADATA, new LinkedList());
        List list = (List) map.get(exoMedia$RendererType);
        list.add("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer");
        list.add("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
        list.add("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
        ((List) map.get(exoMedia$RendererType2)).add("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer");
        arrayList.add(new a.C0250a(new c(), ".m3u8", ".*m3u8.*"));
        arrayList.add(new a.C0250a(new tc.a(), ".mpd", ".*mpd.*"));
        arrayList.add(new a.C0250a(new e(), ".ism", ".*ism.*"));
    }
}
