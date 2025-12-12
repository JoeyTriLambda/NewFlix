package l0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class z implements Iterable<Intent> {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Intent> f15717b = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public final Context f15718m;

    /* compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public z(Context context) {
        this.f15718m = context;
    }

    public static z create(Context context) {
        return new z(context);
    }

    public z addNextIntent(Intent intent) {
        this.f15717b.add(intent);
        return this;
    }

    public z addNextIntentWithParentStack(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f15718m.getPackageManager());
        }
        if (component != null) {
            addParentStack(component);
        }
        addNextIntent(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z addParentStack(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = m.getParentActivityIntent(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f15718m.getPackageManager());
            }
            addParentStack(component);
            addNextIntent(supportParentActivityIntent);
        }
        return this;
    }

    public PendingIntent getPendingIntent(int i10, int i11) {
        return getPendingIntent(i10, i11, null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f15717b.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public PendingIntent getPendingIntent(int i10, int i11, Bundle bundle) {
        ArrayList<Intent> arrayList = this.f15717b;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return PendingIntent.getActivities(this.f15718m, i10, intentArr, i11, bundle);
    }

    public void startActivities(Bundle bundle) {
        ArrayList<Intent> arrayList = this.f15717b;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        Context context = this.f15718m;
        if (m0.a.startActivities(context, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public z addParentStack(ComponentName componentName) {
        Context context = this.f15718m;
        ArrayList<Intent> arrayList = this.f15717b;
        int size = arrayList.size();
        try {
            for (Intent parentActivityIntent = m.getParentActivityIntent(context, componentName); parentActivityIntent != null; parentActivityIntent = m.getParentActivityIntent(context, parentActivityIntent.getComponent())) {
                arrayList.add(size, parentActivityIntent);
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }
}
