package sa;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.o;

/* compiled from: Stats.java */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final sa.a f19196a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19197b;

    /* renamed from: c, reason: collision with root package name */
    public long f19198c;

    /* renamed from: d, reason: collision with root package name */
    public long f19199d;

    /* renamed from: e, reason: collision with root package name */
    public long f19200e;

    /* renamed from: f, reason: collision with root package name */
    public long f19201f;

    /* renamed from: g, reason: collision with root package name */
    public long f19202g;

    /* renamed from: h, reason: collision with root package name */
    public long f19203h;

    /* renamed from: i, reason: collision with root package name */
    public long f19204i;

    /* renamed from: j, reason: collision with root package name */
    public long f19205j;

    /* renamed from: k, reason: collision with root package name */
    public int f19206k;

    /* renamed from: l, reason: collision with root package name */
    public int f19207l;

    /* renamed from: m, reason: collision with root package name */
    public int f19208m;

    /* compiled from: Stats.java */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final h f19209a;

        /* compiled from: Stats.java */
        /* renamed from: sa.h$a$a, reason: collision with other inner class name */
        public class RunnableC0249a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Message f19210b;

            public RunnableC0249a(Message message) {
                this.f19210b = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f19210b.what);
            }
        }

        public a(Looper looper, h hVar) {
            super(looper);
            this.f19209a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            h hVar = this.f19209a;
            if (i10 == 0) {
                hVar.f19198c++;
                return;
            }
            if (i10 == 1) {
                hVar.f19199d++;
                return;
            }
            if (i10 == 2) {
                long j10 = message.arg1;
                int i11 = hVar.f19207l + 1;
                hVar.f19207l = i11;
                long j11 = hVar.f19201f + j10;
                hVar.f19201f = j11;
                hVar.f19204i = j11 / i11;
                return;
            }
            if (i10 == 3) {
                long j12 = message.arg1;
                hVar.f19208m++;
                long j13 = hVar.f19202g + j12;
                hVar.f19202g = j13;
                hVar.f19205j = j13 / hVar.f19207l;
                return;
            }
            if (i10 != 4) {
                Picasso.f10484m.post(new RunnableC0249a(message));
                return;
            }
            Long l10 = (Long) message.obj;
            hVar.f19206k++;
            long jLongValue = l10.longValue() + hVar.f19200e;
            hVar.f19200e = jLongValue;
            hVar.f19203h = jLongValue / hVar.f19206k;
        }
    }

    public h(sa.a aVar) {
        this.f19196a = aVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        StringBuilder sb2 = o.f10621a;
        k kVar = new k(looper);
        kVar.sendMessageDelayed(kVar.obtainMessage(), 1000L);
        this.f19197b = new a(handlerThread.getLooper(), this);
    }

    public final i a() {
        sa.a aVar = this.f19196a;
        return new i(((e) aVar).maxSize(), ((e) aVar).size(), this.f19198c, this.f19199d, this.f19200e, this.f19201f, this.f19202g, this.f19203h, this.f19204i, this.f19205j, this.f19206k, this.f19207l, this.f19208m, System.currentTimeMillis());
    }
}
