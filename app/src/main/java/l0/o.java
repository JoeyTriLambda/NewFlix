package l0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public final class o {

    /* compiled from: NotificationCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f15658a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f15659b;

        /* renamed from: c, reason: collision with root package name */
        public final y[] f15660c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f15661d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f15662e;

        /* renamed from: f, reason: collision with root package name */
        public final int f15663f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f15664g;

        /* renamed from: h, reason: collision with root package name */
        @Deprecated
        public final int f15665h;

        /* renamed from: i, reason: collision with root package name */
        public final CharSequence f15666i;

        /* renamed from: j, reason: collision with root package name */
        public final PendingIntent f15667j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f15668k;

        /* compiled from: NotificationCompat.java */
        /* renamed from: l0.o$a$a, reason: collision with other inner class name */
        public static final class C0185a {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f15669a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f15670b;

            /* renamed from: c, reason: collision with root package name */
            public final PendingIntent f15671c;

            /* renamed from: d, reason: collision with root package name */
            public final boolean f15672d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f15673e;

            /* renamed from: f, reason: collision with root package name */
            public final ArrayList<y> f15674f;

            /* renamed from: g, reason: collision with root package name */
            public final int f15675g;

            /* renamed from: h, reason: collision with root package name */
            public final boolean f15676h;

            /* renamed from: i, reason: collision with root package name */
            public final boolean f15677i;

            /* renamed from: j, reason: collision with root package name */
            public final boolean f15678j;

            public C0185a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle());
            }

            public a build() {
                if (this.f15677i && this.f15671c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<y> arrayList3 = this.f15674f;
                if (arrayList3 != null) {
                    Iterator<y> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        y next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                y[] yVarArr = arrayList.isEmpty() ? null : (y[]) arrayList.toArray(new y[arrayList.size()]);
                return new a(this.f15669a, this.f15670b, this.f15671c, this.f15673e, arrayList2.isEmpty() ? null : (y[]) arrayList2.toArray(new y[arrayList2.size()]), yVarArr, this.f15672d, this.f15675g, this.f15676h, this.f15677i, this.f15678j);
            }

            public C0185a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.createWithResource(null, "", i10) : null, charSequence, pendingIntent, new Bundle());
            }

            public C0185a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f15672d = true;
                this.f15676h = true;
                this.f15669a = iconCompat;
                this.f15670b = d.limitCharSequenceLength(charSequence);
                this.f15671c = pendingIntent;
                this.f15673e = bundle;
                this.f15674f = null;
                this.f15672d = true;
                this.f15675g = 0;
                this.f15676h = true;
                this.f15677i = false;
                this.f15678j = false;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.createWithResource(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent getActionIntent() {
            return this.f15667j;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f15661d;
        }

        public Bundle getExtras() {
            return this.f15658a;
        }

        public IconCompat getIconCompat() {
            int i10;
            if (this.f15659b == null && (i10 = this.f15665h) != 0) {
                this.f15659b = IconCompat.createWithResource(null, "", i10);
            }
            return this.f15659b;
        }

        public y[] getRemoteInputs() {
            return this.f15660c;
        }

        public int getSemanticAction() {
            return this.f15663f;
        }

        public boolean getShowsUserInterface() {
            return this.f15662e;
        }

        public CharSequence getTitle() {
            return this.f15666i;
        }

        public boolean isAuthenticationRequired() {
            return this.f15668k;
        }

        public boolean isContextual() {
            return this.f15664g;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, y[] yVarArr, y[] yVarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f15662e = true;
            this.f15659b = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.f15665h = iconCompat.getResId();
            }
            this.f15666i = d.limitCharSequenceLength(charSequence);
            this.f15667j = pendingIntent;
            this.f15658a = bundle == null ? new Bundle() : bundle;
            this.f15660c = yVarArr;
            this.f15661d = z10;
            this.f15663f = i10;
            this.f15662e = z11;
            this.f15664g = z12;
            this.f15668k = z13;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class b extends f {

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f15679b;

        @Override // l0.o.f
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
        }

        @Override // l0.o.f
        public void apply(n nVar) {
            new Notification.BigTextStyle(((p) nVar).getBuilder()).setBigContentTitle(null).bigText(this.f15679b);
        }

        public b bigText(CharSequence charSequence) {
            this.f15679b = d.limitCharSequenceLength(charSequence);
            return this;
        }

        @Override // l0.o.f
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }
    }

    /* compiled from: NotificationCompat.java */
    public static final class c {
        public static Notification.BubbleMetadata toPlatform(c cVar) {
            return null;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Context f15680a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<a> f15681b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<w> f15682c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<a> f15683d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f15684e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f15685f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f15686g;

        /* renamed from: h, reason: collision with root package name */
        public IconCompat f15687h;

        /* renamed from: i, reason: collision with root package name */
        public int f15688i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f15689j;

        /* renamed from: k, reason: collision with root package name */
        public f f15690k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f15691l;

        /* renamed from: m, reason: collision with root package name */
        public Bundle f15692m;

        /* renamed from: n, reason: collision with root package name */
        public int f15693n;

        /* renamed from: o, reason: collision with root package name */
        public String f15694o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f15695p;

        /* renamed from: q, reason: collision with root package name */
        public final Notification f15696q;

        /* renamed from: r, reason: collision with root package name */
        @Deprecated
        public final ArrayList<String> f15697r;

        public d(Context context, String str) {
            this.f15681b = new ArrayList<>();
            this.f15682c = new ArrayList<>();
            this.f15683d = new ArrayList<>();
            this.f15689j = true;
            this.f15691l = false;
            this.f15693n = 0;
            Notification notification = new Notification();
            this.f15696q = notification;
            this.f15680a = context;
            this.f15694o = str;
            notification.when = System.currentTimeMillis();
            notification.audioStreamType = -1;
            this.f15688i = 0;
            this.f15697r = new ArrayList<>();
            this.f15695p = true;
        }

        public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public d addAction(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f15681b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification build() {
            return new p(this).build();
        }

        public Bundle getExtras() {
            if (this.f15692m == null) {
                this.f15692m = new Bundle();
            }
            return this.f15692m;
        }

        public d setAutoCancel(boolean z10) {
            Notification notification = this.f15696q;
            if (z10) {
                notification.flags |= 16;
            } else {
                notification.flags &= -17;
            }
            return this;
        }

        public d setChannelId(String str) {
            this.f15694o = str;
            return this;
        }

        public d setContentIntent(PendingIntent pendingIntent) {
            this.f15686g = pendingIntent;
            return this;
        }

        public d setContentText(CharSequence charSequence) {
            this.f15685f = limitCharSequenceLength(charSequence);
            return this;
        }

        public d setContentTitle(CharSequence charSequence) {
            this.f15684e = limitCharSequenceLength(charSequence);
            return this;
        }

        public d setLargeIcon(Bitmap bitmap) {
            this.f15687h = bitmap == null ? null : IconCompat.createWithBitmap(o.reduceLargeIconSize(this.f15680a, bitmap));
            return this;
        }

        public d setLocalOnly(boolean z10) {
            this.f15691l = z10;
            return this;
        }

        public d setOngoing(boolean z10) {
            Notification notification = this.f15696q;
            if (z10) {
                notification.flags |= 2;
            } else {
                notification.flags &= -3;
            }
            return this;
        }

        public d setPriority(int i10) {
            this.f15688i = i10;
            return this;
        }

        public d setShowWhen(boolean z10) {
            this.f15689j = z10;
            return this;
        }

        public d setSmallIcon(int i10) {
            this.f15696q.icon = i10;
            return this;
        }

        public d setStyle(f fVar) {
            if (this.f15690k != fVar) {
                this.f15690k = fVar;
                if (fVar != null) {
                    fVar.setBuilder(this);
                }
            }
            return this;
        }

        public d setTicker(CharSequence charSequence) {
            this.f15696q.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public d setVisibility(int i10) {
            this.f15693n = i10;
            return this;
        }

        public d setWhen(long j10) {
            this.f15696q.when = j10;
            return this;
        }

        public d addAction(a aVar) {
            if (aVar != null) {
                this.f15681b.add(aVar);
            }
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, null);
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class e extends f {

        /* compiled from: NotificationCompat.java */
        public static class a {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        @Override // l0.o.f
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putInt("android.callType", 0);
            bundle.putBoolean("android.callIsVideo", false);
            bundle.putCharSequence("android.verificationText", null);
            bundle.putParcelable("android.answerIntent", null);
            bundle.putParcelable("android.declineIntent", null);
            bundle.putParcelable("android.hangUpIntent", null);
        }

        @Override // l0.o.f
        public void apply(n nVar) {
            if (Build.VERSION.SDK_INT >= 31) {
                if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(0));
                    return;
                }
                return;
            }
            Notification.Builder builder = ((p) nVar).getBuilder();
            builder.setContentTitle(null);
            Bundle bundle = this.f15698a.f15692m;
            CharSequence charSequence = (bundle == null || !bundle.containsKey("android.text")) ? null : this.f15698a.f15692m.getCharSequence("android.text");
            builder.setContentText(charSequence != null ? charSequence : null);
            a.b(builder, "call");
        }

        public ArrayList<a> getActionsListWithSystemActions() {
            int i10 = R.drawable.ic_call_decline;
            int i11 = R.string.call_notification_hang_up_action;
            Integer numValueOf = Integer.valueOf(m0.a.getColor(this.f15698a.f15680a, R.color.call_notification_decline_color));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f15698a.f15680a.getResources().getString(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(numValueOf.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarBuild = new a.C0185a(IconCompat.createWithResource(this.f15698a.f15680a, i10), spannableStringBuilder, (PendingIntent) null).build();
            aVarBuild.getExtras().putBoolean("key_action_priority", true);
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(aVarBuild);
            ArrayList<a> arrayList2 = this.f15698a.f15681b;
            if (arrayList2 != null) {
                Iterator<a> it = arrayList2.iterator();
                int i12 = 2;
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isContextual()) {
                        arrayList.add(next);
                    } else if (!next.getExtras().getBoolean("key_action_priority") && i12 > 1) {
                        arrayList.add(next);
                        i12--;
                    }
                }
            }
            return arrayList;
        }

        @Override // l0.o.f
        public String getClassName() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }
    }

    /* compiled from: NotificationCompat.java */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public d f15698a;

        public void addCompatExtras(Bundle bundle) {
            String className = getClassName();
            if (className != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", className);
            }
        }

        public abstract void apply(n nVar);

        public String getClassName() {
            return null;
        }

        public RemoteViews makeBigContentView(n nVar) {
            return null;
        }

        public RemoteViews makeContentView(n nVar) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(n nVar) {
            return null;
        }

        public void setBuilder(d dVar) {
            if (this.f15698a != dVar) {
                this.f15698a = dVar;
                if (dVar != null) {
                    dVar.setStyle(this);
                }
            }
        }
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static Bitmap reduceLargeIconSize(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * dMin), (int) Math.ceil(bitmap.getHeight() * dMin), true);
    }
}
