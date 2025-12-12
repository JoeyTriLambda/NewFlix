package a2;

import a2.a;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: MediaRouteProvider.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f145a;

    /* renamed from: b, reason: collision with root package name */
    public final d f146b;

    /* renamed from: c, reason: collision with root package name */
    public final c f147c;

    /* renamed from: d, reason: collision with root package name */
    public a f148d;

    /* renamed from: e, reason: collision with root package name */
    public h f149e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f150f;

    /* renamed from: g, reason: collision with root package name */
    public k f151g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f152h;

    /* compiled from: MediaRouteProvider.java */
    public static abstract class a {
        public abstract void onDescriptorChanged(i iVar, k kVar);
    }

    /* compiled from: MediaRouteProvider.java */
    public static abstract class b extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Object f153a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public Executor f154b;

        /* renamed from: c, reason: collision with root package name */
        public c f155c;

        /* renamed from: d, reason: collision with root package name */
        public g f156d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList f157e;

        /* compiled from: MediaRouteProvider.java */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f158b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ g f159m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Collection f160n;

            public a(c cVar, g gVar, Collection collection) {
                this.f158b = cVar;
                this.f159m = gVar;
                this.f160n = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((a.b) this.f158b).onRoutesChanged(b.this, this.f159m, this.f160n);
            }
        }

        /* compiled from: MediaRouteProvider.java */
        /* renamed from: a2.i$b$b, reason: collision with other inner class name */
        public static final class C0003b {

            /* renamed from: a, reason: collision with root package name */
            public final g f162a;

            /* renamed from: b, reason: collision with root package name */
            public final int f163b;

            /* renamed from: c, reason: collision with root package name */
            public final boolean f164c;

            /* renamed from: d, reason: collision with root package name */
            public final boolean f165d;

            /* renamed from: e, reason: collision with root package name */
            public final boolean f166e;

            /* compiled from: MediaRouteProvider.java */
            /* renamed from: a2.i$b$b$a */
            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public final g f167a;

                /* renamed from: b, reason: collision with root package name */
                public int f168b = 1;

                /* renamed from: c, reason: collision with root package name */
                public boolean f169c = false;

                /* renamed from: d, reason: collision with root package name */
                public boolean f170d = false;

                /* renamed from: e, reason: collision with root package name */
                public boolean f171e = false;

                public a(g gVar) {
                    if (gVar == null) {
                        throw new NullPointerException("descriptor must not be null");
                    }
                    this.f167a = gVar;
                }

                public C0003b build() {
                    return new C0003b(this.f167a, this.f168b, this.f169c, this.f170d, this.f171e);
                }

                public a setIsGroupable(boolean z10) {
                    this.f170d = z10;
                    return this;
                }

                public a setIsTransferable(boolean z10) {
                    this.f171e = z10;
                    return this;
                }

                public a setIsUnselectable(boolean z10) {
                    this.f169c = z10;
                    return this;
                }

                public a setSelectionState(int i10) {
                    this.f168b = i10;
                    return this;
                }
            }

            public C0003b(g gVar, int i10, boolean z10, boolean z11, boolean z12) {
                this.f162a = gVar;
                this.f163b = i10;
                this.f164c = z10;
                this.f165d = z11;
                this.f166e = z12;
            }

            public g getRouteDescriptor() {
                return this.f162a;
            }

            public int getSelectionState() {
                return this.f163b;
            }

            public boolean isGroupable() {
                return this.f165d;
            }

            public boolean isTransferable() {
                return this.f166e;
            }

            public boolean isUnselectable() {
                return this.f164c;
            }
        }

        /* compiled from: MediaRouteProvider.java */
        public interface c {
        }

        public String getGroupableSelectionTitle() {
            return null;
        }

        public String getTransferableSectionTitle() {
            return null;
        }

        public final void notifyDynamicRoutesChanged(g gVar, Collection<C0003b> collection) {
            if (gVar == null) {
                throw new NullPointerException("groupRoute must not be null");
            }
            if (collection == null) {
                throw new NullPointerException("dynamicRoutes must not be null");
            }
            synchronized (this.f153a) {
                Executor executor = this.f154b;
                if (executor != null) {
                    executor.execute(new a(this.f155c, gVar, collection));
                } else {
                    this.f156d = gVar;
                    this.f157e = new ArrayList(collection);
                }
            }
        }

        public abstract void onAddMemberRoute(String str);

        public abstract void onRemoveMemberRoute(String str);

        public abstract void onUpdateMemberRoutes(List<String> list);
    }

    /* compiled from: MediaRouteProvider.java */
    public final class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            i iVar = i.this;
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                iVar.f150f = false;
                iVar.onDiscoveryRequestChanged(iVar.f149e);
                return;
            }
            iVar.f152h = false;
            a aVar = iVar.f148d;
            if (aVar != null) {
                aVar.onDescriptorChanged(iVar, iVar.f151g);
            }
        }
    }

    /* compiled from: MediaRouteProvider.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f173a;

        public d(ComponentName componentName) {
            if (componentName == null) {
                throw new IllegalArgumentException("componentName must not be null");
            }
            this.f173a = componentName;
        }

        public ComponentName getComponentName() {
            return this.f173a;
        }

        public String getPackageName() {
            return this.f173a.getPackageName();
        }

        public String toString() {
            return "ProviderMetadata{ componentName=" + this.f173a.flattenToShortString() + " }";
        }
    }

    /* compiled from: MediaRouteProvider.java */
    public static abstract class e {
        @Deprecated
        public void onUnselect() {
        }

        public void onUnselect(int i10) {
            onUnselect();
        }

        public void onRelease() {
        }

        public void onSelect() {
        }

        public void onSetVolume(int i10) {
        }

        public void onUpdateVolume(int i10) {
        }
    }

    public i(Context context) {
        this(context, null);
    }

    public final Context getContext() {
        return this.f145a;
    }

    public final k getDescriptor() {
        return this.f151g;
    }

    public final h getDiscoveryRequest() {
        return this.f149e;
    }

    public final d getMetadata() {
        return this.f146b;
    }

    public b onCreateDynamicGroupRouteController(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public e onCreateRouteController(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public final void setCallback(a aVar) {
        n.a();
        this.f148d = aVar;
    }

    public final void setDescriptor(k kVar) {
        n.a();
        if (this.f151g != kVar) {
            this.f151g = kVar;
            if (this.f152h) {
                return;
            }
            this.f152h = true;
            this.f147c.sendEmptyMessage(1);
        }
    }

    public final void setDiscoveryRequest(h hVar) {
        n.a();
        if (w0.c.equals(this.f149e, hVar)) {
            return;
        }
        this.f149e = hVar;
        if (this.f150f) {
            return;
        }
        this.f150f = true;
        this.f147c.sendEmptyMessage(2);
    }

    public i(Context context, d dVar) {
        this.f147c = new c();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.f145a = context;
        if (dVar == null) {
            this.f146b = new d(new ComponentName(context, getClass()));
        } else {
            this.f146b = dVar;
        }
    }

    public e onCreateRouteController(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return onCreateRouteController(str);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public void onDiscoveryRequestChanged(h hVar) {
    }
}
