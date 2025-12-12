package l0;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import l0.o;
import l0.y;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public final class p implements n {

    /* renamed from: a, reason: collision with root package name */
    public final Notification.Builder f15699a;

    /* renamed from: b, reason: collision with root package name */
    public final o.d f15700b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f15701c;

    /* compiled from: NotificationCompatBuilder.java */
    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class c {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* compiled from: NotificationCompatBuilder.java */
    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public p(o.d dVar) {
        ArrayList<String> arrayList;
        new ArrayList();
        this.f15701c = new Bundle();
        this.f15700b = dVar;
        Context context = dVar.f15680a;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f15699a = e.a(context, dVar.f15694o);
        } else {
            this.f15699a = new Notification.Builder(dVar.f15680a);
        }
        Notification notification = dVar.f15696q;
        this.f15699a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f15684e).setContentText(dVar.f15685f).setContentInfo(null).setContentIntent(dVar.f15686g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        if (i10 < 23) {
            Notification.Builder builder = this.f15699a;
            IconCompat iconCompat = dVar.f15687h;
            builder.setLargeIcon(iconCompat == null ? null : iconCompat.getBitmap());
        } else {
            Notification.Builder builder2 = this.f15699a;
            IconCompat iconCompat2 = dVar.f15687h;
            c.b(builder2, iconCompat2 == null ? null : iconCompat2.toIcon(context));
        }
        this.f15699a.setSubText(null).setUsesChronometer(false).setPriority(dVar.f15688i);
        o.f fVar = dVar.f15690k;
        if (fVar instanceof o.e) {
            Iterator<o.a> it = ((o.e) fVar).getActionsListWithSystemActions().iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } else {
            Iterator<o.a> it2 = dVar.f15681b.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
        Bundle bundle = dVar.f15692m;
        if (bundle != null) {
            this.f15701c.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f15699a.setShowWhen(dVar.f15689j);
        a.i(this.f15699a, dVar.f15691l);
        a.g(this.f15699a, null);
        a.j(this.f15699a, null);
        a.h(this.f15699a, false);
        b.b(this.f15699a, null);
        b.c(this.f15699a, 0);
        b.f(this.f15699a, dVar.f15693n);
        b.d(this.f15699a, null);
        b.e(this.f15699a, notification.sound, notification.audioAttributes);
        ArrayList<w> arrayList2 = dVar.f15682c;
        ArrayList<String> arrayList3 = dVar.f15697r;
        if (i11 < 28) {
            if (arrayList2 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(arrayList2.size());
                Iterator<w> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next().resolveToLegacyUri());
                }
            }
            if (arrayList != null) {
                if (arrayList3 != null) {
                    b0.d dVar2 = new b0.d(arrayList3.size() + arrayList.size());
                    dVar2.addAll(arrayList);
                    dVar2.addAll(arrayList3);
                    arrayList = new ArrayList<>(dVar2);
                }
                arrayList3 = arrayList;
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            Iterator<String> it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                b.a(this.f15699a, it4.next());
            }
        }
        ArrayList<o.a> arrayList4 = dVar.f15683d;
        if (arrayList4.size() > 0) {
            Bundle bundle2 = dVar.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < arrayList4.size(); i12++) {
                String string = Integer.toString(i12);
                o.a aVar = arrayList4.get(i12);
                Bundle bundle5 = new Bundle();
                IconCompat iconCompat3 = aVar.getIconCompat();
                bundle5.putInt("icon", iconCompat3 != null ? iconCompat3.getResId() : 0);
                bundle5.putCharSequence("title", aVar.getTitle());
                bundle5.putParcelable("actionIntent", aVar.getActionIntent());
                Bundle bundle6 = aVar.getExtras() != null ? new Bundle(aVar.getExtras()) : new Bundle();
                bundle6.putBoolean("android.support.allowGeneratedReplies", aVar.getAllowGeneratedReplies());
                bundle5.putBundle("extras", bundle6);
                bundle5.putParcelableArray("remoteInputs", s.a(aVar.getRemoteInputs()));
                bundle5.putBoolean("showsUserInterface", aVar.getShowsUserInterface());
                bundle5.putInt("semanticAction", aVar.getSemanticAction());
                bundle4.putBundle(string, bundle5);
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.f15701c.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 24) {
            this.f15699a.setExtras(dVar.f15692m);
            d.e(this.f15699a, null);
        }
        if (i13 >= 26) {
            e.b(this.f15699a, 0);
            e.e(this.f15699a, null);
            e.f(this.f15699a, null);
            e.g(this.f15699a, 0L);
            e.d(this.f15699a, 0);
            if (!TextUtils.isEmpty(dVar.f15694o)) {
                this.f15699a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i13 >= 28) {
            Iterator<w> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                f.a(this.f15699a, it5.next().toAndroidPerson());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            g.a(this.f15699a, dVar.f15695p);
            g.b(this.f15699a, o.c.toPlatform(null));
        }
    }

    public final void a(o.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        IconCompat iconCompat = aVar.getIconCompat();
        RemoteInput[] remoteInputArr = null;
        Notification.Action.Builder builderA = i10 >= 23 ? c.a(iconCompat != null ? iconCompat.toIcon() : null, aVar.getTitle(), aVar.getActionIntent()) : a.e(iconCompat != null ? iconCompat.getResId() : 0, aVar.getTitle(), aVar.getActionIntent());
        if (aVar.getRemoteInputs() != null) {
            y[] remoteInputs = aVar.getRemoteInputs();
            if (remoteInputs != null) {
                remoteInputArr = new RemoteInput[remoteInputs.length];
                for (int i11 = 0; i11 < remoteInputs.length; i11++) {
                    remoteInputArr[i11] = y.a.fromCompat(remoteInputs[i11]);
                }
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.getExtras() != null ? new Bundle(aVar.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.getAllowGeneratedReplies());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 24) {
            d.a(builderA, aVar.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.getSemanticAction());
        if (i12 >= 28) {
            f.b(builderA, aVar.getSemanticAction());
        }
        if (i12 >= 29) {
            g.c(builderA, aVar.isContextual());
        }
        if (i12 >= 31) {
            h.a(builderA, aVar.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.getShowsUserInterface());
        a.b(builderA, bundle);
        a.a(this.f15699a, a.d(builderA));
    }

    public Notification build() {
        Bundle extras;
        RemoteViews remoteViewsMakeHeadsUpContentView;
        RemoteViews remoteViewsMakeBigContentView;
        o.d dVar = this.f15700b;
        o.f fVar = dVar.f15690k;
        if (fVar != null) {
            fVar.apply(this);
        }
        RemoteViews remoteViewsMakeContentView = fVar != null ? fVar.makeContentView(this) : null;
        Notification notificationBuildInternal = buildInternal();
        if (remoteViewsMakeContentView != null) {
            notificationBuildInternal.contentView = remoteViewsMakeContentView;
        } else {
            dVar.getClass();
        }
        if (fVar != null && (remoteViewsMakeBigContentView = fVar.makeBigContentView(this)) != null) {
            notificationBuildInternal.bigContentView = remoteViewsMakeBigContentView;
        }
        if (fVar != null && (remoteViewsMakeHeadsUpContentView = dVar.f15690k.makeHeadsUpContentView(this)) != null) {
            notificationBuildInternal.headsUpContentView = remoteViewsMakeHeadsUpContentView;
        }
        if (fVar != null && (extras = o.getExtras(notificationBuildInternal)) != null) {
            fVar.addCompatExtras(extras);
        }
        return notificationBuildInternal;
    }

    public Notification buildInternal() {
        int i10 = Build.VERSION.SDK_INT;
        Notification.Builder builder = this.f15699a;
        if (i10 >= 26) {
            return builder.build();
        }
        if (i10 >= 24) {
            return builder.build();
        }
        builder.setExtras(this.f15701c);
        return builder.build();
    }

    public Notification.Builder getBuilder() {
        return this.f15699a;
    }
}
