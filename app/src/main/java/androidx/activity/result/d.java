package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.random.Random;

/* compiled from: ActivityResultRegistry.java */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f828a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f829b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f830c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f831d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final transient HashMap f832e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f833f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f834g = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* compiled from: ActivityResultRegistry.java */
    public class a<I> extends androidx.activity.result.c<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f835a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q.a f836b;

        public a(String str, q.a aVar) {
            this.f835a = str;
            this.f836b = aVar;
        }

        @Override // androidx.activity.result.c
        public void launch(I i10, l0.c cVar) throws Exception {
            d dVar = d.this;
            HashMap map = dVar.f829b;
            String str = this.f835a;
            Integer num = (Integer) map.get(str);
            q.a aVar = this.f836b;
            if (num != null) {
                dVar.f831d.add(str);
                try {
                    dVar.onLaunch(num.intValue(), aVar, i10, cVar);
                    return;
                } catch (Exception e10) {
                    dVar.f831d.remove(str);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void unregister() {
            Integer num;
            d dVar = d.this;
            ArrayList<String> arrayList = dVar.f831d;
            String str = this.f835a;
            if (!arrayList.contains(str) && (num = (Integer) dVar.f829b.remove(str)) != null) {
                dVar.f828a.remove(num);
            }
            dVar.f832e.remove(str);
            HashMap map = dVar.f833f;
            if (map.containsKey(str)) {
                StringBuilder sbV = ac.c.v("Dropping pending result for request ", str, ": ");
                sbV.append(map.get(str));
                Log.w("ActivityResultRegistry", sbV.toString());
                map.remove(str);
            }
            Bundle bundle = dVar.f834g;
            if (bundle.containsKey(str)) {
                StringBuilder sbV2 = ac.c.v("Dropping pending result for request ", str, ": ");
                sbV2.append(bundle.getParcelable(str));
                Log.w("ActivityResultRegistry", sbV2.toString());
                bundle.remove(str);
            }
            if (((c) dVar.f830c.get(str)) != null) {
                throw null;
            }
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    public static class b<O> {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.b<O> f838a;

        /* renamed from: b, reason: collision with root package name */
        public final q.a<?, O> f839b;

        public b(androidx.activity.result.b<O> bVar, q.a<?, O> aVar) {
            this.f838a = bVar;
            this.f839b = aVar;
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    public static class c {
    }

    public final boolean dispatchResult(int i10, int i11, Intent intent) {
        androidx.activity.result.b<O> bVar;
        String str = (String) this.f828a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        b bVar2 = (b) this.f832e.get(str);
        if (bVar2 == null || (bVar = bVar2.f838a) == 0 || !this.f831d.contains(str)) {
            this.f833f.remove(str);
            this.f834g.putParcelable(str, new androidx.activity.result.a(i11, intent));
            return true;
        }
        bVar.onActivityResult(bVar2.f839b.parseResult(i11, intent));
        this.f831d.remove(str);
        return true;
    }

    public abstract <I, O> void onLaunch(int i10, q.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, l0.c cVar);

    public final void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f831d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        Bundle bundle3 = this.f834g;
        bundle3.putAll(bundle2);
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            HashMap map = this.f829b;
            boolean zContainsKey = map.containsKey(str);
            HashMap map2 = this.f828a;
            if (zContainsKey) {
                Integer num = (Integer) map.remove(str);
                if (!bundle3.containsKey(str)) {
                    map2.remove(num);
                }
            }
            int iIntValue = integerArrayList.get(i10).intValue();
            String str2 = stringArrayList.get(i10);
            map2.put(Integer.valueOf(iIntValue), str2);
            map.put(str2, Integer.valueOf(iIntValue));
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        HashMap map = this.f829b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f831d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f834g.clone());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.c<I> register(String str, q.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        int i10;
        HashMap map;
        HashMap map2 = this.f829b;
        if (((Integer) map2.get(str)) == null) {
            int iNextInt = Random.f15263b.nextInt(2147418112);
            while (true) {
                i10 = iNextInt + 65536;
                map = this.f828a;
                if (!map.containsKey(Integer.valueOf(i10))) {
                    break;
                }
                iNextInt = Random.f15263b.nextInt(2147418112);
            }
            map.put(Integer.valueOf(i10), str);
            map2.put(str, Integer.valueOf(i10));
        }
        this.f832e.put(str, new b(bVar, aVar));
        HashMap map3 = this.f833f;
        if (map3.containsKey(str)) {
            Object obj = map3.get(str);
            map3.remove(str);
            bVar.onActivityResult(obj);
        }
        Bundle bundle = this.f834g;
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) bundle.getParcelable(str);
        if (aVar2 != null) {
            bundle.remove(str);
            bVar.onActivityResult(aVar.parseResult(aVar2.getResultCode(), aVar2.getData()));
        }
        return new a(str, aVar);
    }

    public final <O> boolean dispatchResult(int i10, @SuppressLint({"UnknownNullness"}) O o6) {
        androidx.activity.result.b<O> bVar;
        String str = (String) this.f828a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        b bVar2 = (b) this.f832e.get(str);
        if (bVar2 != null && (bVar = bVar2.f838a) != null) {
            if (!this.f831d.remove(str)) {
                return true;
            }
            bVar.onActivityResult(o6);
            return true;
        }
        this.f834g.remove(str);
        this.f833f.put(str, o6);
        return true;
    }
}
