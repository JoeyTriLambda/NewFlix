package s8;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import t8.f0;

/* compiled from: UserMetadata.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final g f19165a;

    /* renamed from: b, reason: collision with root package name */
    public final r8.l f19166b;

    /* renamed from: c, reason: collision with root package name */
    public String f19167c;

    /* renamed from: d, reason: collision with root package name */
    public final a f19168d = new a(false);

    /* renamed from: e, reason: collision with root package name */
    public final a f19169e = new a(true);

    /* renamed from: f, reason: collision with root package name */
    public final l f19170f = new l(128);

    /* renamed from: g, reason: collision with root package name */
    public final AtomicMarkableReference<String> f19171g = new AtomicMarkableReference<>(null, false);

    /* compiled from: UserMetadata.java */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference<d> f19172a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference<Callable<Void>> f19173b = new AtomicReference<>(null);

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19174c;

        public a(boolean z10) {
            this.f19174c = z10;
            this.f19172a = new AtomicMarkableReference<>(new d(64, z10 ? 8192 : 1024), false);
        }

        public Map<String, String> getKeys() {
            return this.f19172a.getReference().getKeys();
        }

        public boolean setKey(String str, String str2) {
            synchronized (this) {
                boolean key = this.f19172a.getReference().setKey(str, str2);
                boolean z10 = false;
                if (!key) {
                    return false;
                }
                AtomicMarkableReference<d> atomicMarkableReference = this.f19172a;
                int i10 = 1;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                g3.e eVar = new g3.e(this, i10);
                AtomicReference<Callable<Void>> atomicReference = this.f19173b;
                while (true) {
                    if (atomicReference.compareAndSet(null, eVar)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReference.get() != null) {
                        break;
                    }
                }
                if (z10) {
                    m.this.f19166b.submit(eVar);
                }
                return true;
            }
        }
    }

    public m(String str, w8.b bVar, r8.l lVar) {
        this.f19167c = str;
        this.f19165a = new g(bVar);
        this.f19166b = lVar;
    }

    public static m loadFromExistingSession(String str, w8.b bVar, r8.l lVar) {
        g gVar = new g(bVar);
        m mVar = new m(str, bVar, lVar);
        mVar.f19168d.f19172a.getReference().setKeys(gVar.c(str, false));
        mVar.f19169e.f19172a.getReference().setKeys(gVar.c(str, true));
        mVar.f19171g.set(gVar.readUserId(str), false);
        mVar.f19170f.updateRolloutAssignmentList(gVar.readRolloutsState(str));
        return mVar;
    }

    public static String readUserId(String str, w8.b bVar) {
        return new g(bVar).readUserId(str);
    }

    public Map<String, String> getCustomKeys() {
        return this.f19168d.getKeys();
    }

    public Map<String, String> getInternalKeys() {
        return this.f19169e.getKeys();
    }

    public List<f0.e.d.AbstractC0277e> getRolloutsState() {
        return this.f19170f.getReportRolloutsState();
    }

    public String getUserId() {
        return this.f19171g.getReference();
    }

    public boolean setInternalKey(String str, String str2) {
        return this.f19169e.setKey(str, str2);
    }

    public void setNewSession(String str) {
        synchronized (this.f19167c) {
            this.f19167c = str;
            Map<String, String> keys = this.f19168d.getKeys();
            List<k> rolloutAssignmentList = this.f19170f.getRolloutAssignmentList();
            if (getUserId() != null) {
                this.f19165a.writeUserData(str, getUserId());
            }
            if (!keys.isEmpty()) {
                this.f19165a.writeKeyData(str, keys);
            }
            if (!rolloutAssignmentList.isEmpty()) {
                this.f19165a.writeRolloutState(str, rolloutAssignmentList);
            }
        }
    }
}
