package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.a;
import com.squareup.picasso.f;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class Picasso {

    /* renamed from: m, reason: collision with root package name */
    public static final a f10484m = new a(Looper.getMainLooper());

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Picasso f10485n = null;

    /* renamed from: a, reason: collision with root package name */
    public final d f10486a;

    /* renamed from: b, reason: collision with root package name */
    public final List<m> f10487b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f10488c;

    /* renamed from: d, reason: collision with root package name */
    public final f f10489d;

    /* renamed from: e, reason: collision with root package name */
    public final sa.a f10490e;

    /* renamed from: f, reason: collision with root package name */
    public final sa.h f10491f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakHashMap f10492g;

    /* renamed from: h, reason: collision with root package name */
    public final WeakHashMap f10493h;

    /* renamed from: i, reason: collision with root package name */
    public final ReferenceQueue<Object> f10494i;

    /* renamed from: j, reason: collision with root package name */
    public final Bitmap.Config f10495j = null;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10496k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f10497l;

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);


        /* renamed from: b, reason: collision with root package name */
        public final int f10502b;

        LoadedFrom(int i10) {
            this.f10502b = i10;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        /* JADX INFO: Fake field, exist only in values array */
        HIGH
    }

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmap;
            int i10 = message.what;
            if (i10 == 3) {
                com.squareup.picasso.a aVar = (com.squareup.picasso.a) message.obj;
                if (aVar.f10516a.f10497l) {
                    o.d("Main", "canceled", aVar.f10517b.a(), "target got garbage collected");
                }
                aVar.f10516a.a(aVar.b());
                return;
            }
            if (i10 == 8) {
                List list = (List) message.obj;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    com.squareup.picasso.c cVar = (com.squareup.picasso.c) list.get(i11);
                    Picasso picasso = cVar.f10533m;
                    picasso.getClass();
                    com.squareup.picasso.a aVar2 = cVar.f10542v;
                    ArrayList arrayList = cVar.f10543w;
                    boolean z10 = (arrayList == null || arrayList.isEmpty()) ? false : true;
                    if (aVar2 != null || z10) {
                        Uri uri = cVar.f10538r.f10584c;
                        Exception exc = cVar.A;
                        Bitmap bitmap2 = cVar.f10544x;
                        LoadedFrom loadedFrom = cVar.f10546z;
                        if (aVar2 != null) {
                            picasso.b(bitmap2, loadedFrom, aVar2, exc);
                        }
                        if (z10) {
                            int size2 = arrayList.size();
                            for (int i12 = 0; i12 < size2; i12++) {
                                picasso.b(bitmap2, loadedFrom, (com.squareup.picasso.a) arrayList.get(i12), exc);
                            }
                        }
                    }
                }
                return;
            }
            if (i10 != 13) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size3 = list2.size();
            for (int i13 = 0; i13 < size3; i13++) {
                com.squareup.picasso.a aVar3 = (com.squareup.picasso.a) list2.get(i13);
                Picasso picasso2 = aVar3.f10516a;
                picasso2.getClass();
                if ((aVar3.f10520e & 1) == 0) {
                    bitmap = ((sa.e) picasso2.f10490e).get(aVar3.f10524i);
                    sa.h hVar = picasso2.f10491f;
                    if (bitmap != null) {
                        hVar.f19197b.sendEmptyMessage(0);
                    } else {
                        hVar.f19197b.sendEmptyMessage(1);
                    }
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    LoadedFrom loadedFrom2 = LoadedFrom.MEMORY;
                    picasso2.b(bitmap, loadedFrom2, aVar3, null);
                    if (picasso2.f10497l) {
                        o.d("Main", "completed", aVar3.f10517b.a(), "from " + loadedFrom2);
                    }
                } else {
                    picasso2.c(aVar3);
                    if (picasso2.f10497l) {
                        o.c("Main", "resumed", aVar3.f10517b.a());
                    }
                }
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f10506a;

        /* renamed from: b, reason: collision with root package name */
        public sa.g f10507b;

        /* renamed from: c, reason: collision with root package name */
        public j f10508c;

        /* renamed from: d, reason: collision with root package name */
        public sa.e f10509d;

        /* renamed from: e, reason: collision with root package name */
        public d.a f10510e;

        public b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f10506a = context.getApplicationContext();
        }

        public Picasso build() {
            Context context = this.f10506a;
            if (this.f10507b == null) {
                this.f10507b = new sa.g(context);
            }
            if (this.f10509d == null) {
                this.f10509d = new sa.e(context);
            }
            if (this.f10508c == null) {
                this.f10508c = new j();
            }
            if (this.f10510e == null) {
                this.f10510e = d.f10514a;
            }
            sa.h hVar = new sa.h(this.f10509d);
            return new Picasso(context, new f(context, this.f10508c, Picasso.f10484m, this.f10507b, this.f10509d, hVar), this.f10509d, this.f10510e, hVar);
        }
    }

    public static class c extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final ReferenceQueue<Object> f10511b;

        /* renamed from: m, reason: collision with root package name */
        public final Handler f10512m;

        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Exception f10513b;

            public a(Exception exc) {
                this.f10513b = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.f10513b);
            }
        }

        public c(ReferenceQueue referenceQueue, a aVar) {
            this.f10511b = referenceQueue;
            this.f10512m = aVar;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Handler handler = this.f10512m;
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0115a c0115a = (a.C0115a) this.f10511b.remove(1000L);
                    Message messageObtainMessage = handler.obtainMessage();
                    if (c0115a != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = c0115a.f10528a;
                        handler.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e10) {
                    handler.post(new a(e10));
                    return;
                }
            }
        }
    }

    public Picasso(Context context, f fVar, sa.a aVar, d dVar, sa.h hVar) {
        this.f10488c = context;
        this.f10489d = fVar;
        this.f10490e = aVar;
        this.f10486a = dVar;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new n(context));
        arrayList.add(new com.squareup.picasso.d(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new e(context));
        arrayList.add(new com.squareup.picasso.b(context));
        arrayList.add(new g(context));
        arrayList.add(new NetworkRequestHandler(fVar.f10557c, hVar));
        this.f10487b = Collections.unmodifiableList(arrayList);
        this.f10491f = hVar;
        this.f10492g = new WeakHashMap();
        this.f10493h = new WeakHashMap();
        this.f10496k = false;
        this.f10497l = false;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f10494i = referenceQueue;
        new c(referenceQueue, f10484m).start();
    }

    public static Picasso get() {
        if (f10485n == null) {
            synchronized (Picasso.class) {
                if (f10485n == null) {
                    Context context = PicassoProvider.f10515b;
                    if (context == null) {
                        throw new IllegalStateException("context == null");
                    }
                    f10485n = new b(context).build();
                }
            }
        }
        return f10485n;
    }

    public final void a(Object obj) {
        StringBuilder sb2 = o.f10621a;
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
        com.squareup.picasso.a aVar = (com.squareup.picasso.a) this.f10492g.remove(obj);
        if (aVar != null) {
            aVar.a();
            f.a aVar2 = this.f10489d.f10562h;
            aVar2.sendMessage(aVar2.obtainMessage(2, aVar));
        }
        if (obj instanceof ImageView) {
            sa.c cVar = (sa.c) this.f10493h.remove((ImageView) obj);
            if (cVar != null) {
                cVar.f19182b.getClass();
                cVar.f19184n = null;
                WeakReference<ImageView> weakReference = cVar.f19183m;
                ImageView imageView = weakReference.get();
                if (imageView == null) {
                    return;
                }
                weakReference.clear();
                imageView.removeOnAttachStateChangeListener(cVar);
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(cVar);
                }
            }
        }
    }

    public final void b(Bitmap bitmap, LoadedFrom loadedFrom, com.squareup.picasso.a aVar, Exception exc) {
        if (aVar.f10527l) {
            return;
        }
        if (!aVar.f10526k) {
            this.f10492g.remove(aVar.b());
        }
        if (bitmap == null) {
            aVar.error(exc);
            if (this.f10497l) {
                o.d("Main", "errored", aVar.f10517b.a(), exc.getMessage());
                return;
            }
            return;
        }
        if (loadedFrom == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        aVar.complete(bitmap, loadedFrom);
        if (this.f10497l) {
            o.d("Main", "completed", aVar.f10517b.a(), "from " + loadedFrom);
        }
    }

    public final void c(com.squareup.picasso.a aVar) {
        Object objB = aVar.b();
        if (objB != null) {
            WeakHashMap weakHashMap = this.f10492g;
            if (weakHashMap.get(objB) != aVar) {
                a(objB);
                weakHashMap.put(objB, aVar);
            }
        }
        f.a aVar2 = this.f10489d.f10562h;
        aVar2.sendMessage(aVar2.obtainMessage(1, aVar));
    }

    public void cancelRequest(ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("view cannot be null.");
        }
        a(imageView);
    }

    public l load(Uri uri) {
        return new l(this, uri, 0);
    }

    public l load(String str) {
        if (str == null) {
            return new l(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public l load(int i10) {
        if (i10 != 0) {
            return new l(this, null, i10);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public interface d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10514a = new a();

        public static class a implements d {
            public k transformRequest(k kVar) {
                return kVar;
            }
        }
    }
}
