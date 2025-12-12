package rc;

import android.content.Context;
import android.os.Handler;
import b6.i;
import c5.o;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.mediacodec.a;
import f5.c;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m6.g;
import q5.e;

/* compiled from: RendererProvider.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18919a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f18920b;

    /* renamed from: c, reason: collision with root package name */
    public final i.a f18921c;

    /* renamed from: d, reason: collision with root package name */
    public final e.a f18922d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.a f18923e;

    /* renamed from: f, reason: collision with root package name */
    public final g f18924f;

    /* renamed from: g, reason: collision with root package name */
    public f5.a<c> f18925g;

    /* renamed from: h, reason: collision with root package name */
    public final int f18926h = 50;

    /* renamed from: i, reason: collision with root package name */
    public final int f18927i = 5000;

    public a(Context context, Handler handler, i.a aVar, e.a aVar2, com.google.android.exoplayer2.audio.a aVar3, g gVar) {
        this.f18919a = context;
        this.f18920b = handler;
        this.f18921c = aVar;
        this.f18922d = aVar2;
        this.f18923e = aVar3;
        this.f18924f = gVar;
    }

    public List<o> buildAudioRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.android.exoplayer2.audio.c(com.google.android.exoplayer2.mediacodec.a.f5880a, this.f18925g, true, this.f18920b, this.f18923e, d5.c.getCapabilities(this.f18919a), new AudioProcessor[0]));
        List list = (List) mc.a.f16262a.get(ExoMedia$RendererType.AUDIO);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((o) Class.forName((String) it.next()).getConstructor(Handler.class, com.google.android.exoplayer2.audio.a.class).newInstance(this.f18920b, this.f18923e));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public List<o> buildCaptionRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i(this.f18921c, this.f18920b.getLooper()));
        return arrayList;
    }

    public List<o> buildMetadataRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(this.f18922d, this.f18920b.getLooper(), q5.c.f17887a));
        return arrayList;
    }

    public List<o> buildVideoRenderers() {
        ArrayList arrayList = new ArrayList();
        Context context = this.f18919a;
        a.C0071a c0071a = com.google.android.exoplayer2.mediacodec.a.f5880a;
        int i10 = this.f18927i;
        arrayList.add(new m6.e(context, c0071a, i10, this.f18925g, false, this.f18920b, this.f18924f, this.f18926h));
        List list = (List) mc.a.f16262a.get(ExoMedia$RendererType.VIDEO);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((o) Class.forName((String) it.next()).getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, g.class, Integer.TYPE).newInstance(Boolean.TRUE, Integer.valueOf(i10), this.f18920b, this.f18924f, Integer.valueOf(this.f18926h)));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public List<o> generate() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(buildAudioRenderers());
        arrayList.addAll(buildVideoRenderers());
        arrayList.addAll(buildCaptionRenderers());
        arrayList.addAll(buildMetadataRenderers());
        return arrayList;
    }

    public void setDrmSessionManager(f5.a<c> aVar) {
        this.f18925g = aVar;
    }
}
