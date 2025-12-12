package a2;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: MediaRouteDescriptor.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f138a;

    public g(Bundle bundle) {
        this.f138a = bundle;
    }

    public static g fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new g(bundle);
        }
        return null;
    }

    public boolean canDisconnectAndKeepPlaying() {
        return this.f138a.getBoolean("canDisconnect", false);
    }

    public Set<String> getAllowedPackages() {
        Bundle bundle = this.f138a;
        return !bundle.containsKey("allowedPackages") ? new HashSet() : new HashSet(bundle.getStringArrayList("allowedPackages"));
    }

    public int getConnectionState() {
        return this.f138a.getInt("connectionState", 0);
    }

    public List<IntentFilter> getControlFilters() {
        Bundle bundle = this.f138a;
        return !bundle.containsKey("controlFilters") ? new ArrayList() : new ArrayList(bundle.getParcelableArrayList("controlFilters"));
    }

    public String getDescription() {
        return this.f138a.getString("status");
    }

    public int getDeviceType() {
        return this.f138a.getInt("deviceType");
    }

    public Bundle getExtras() {
        return this.f138a.getBundle("extras");
    }

    public List<String> getGroupMemberIds() {
        Bundle bundle = this.f138a;
        return !bundle.containsKey("groupMemberIds") ? new ArrayList() : new ArrayList(bundle.getStringArrayList("groupMemberIds"));
    }

    public Uri getIconUri() {
        String string = this.f138a.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public String getId() {
        return this.f138a.getString("id");
    }

    public int getMaxClientVersion() {
        return this.f138a.getInt("maxClientVersion", Integer.MAX_VALUE);
    }

    public int getMinClientVersion() {
        return this.f138a.getInt("minClientVersion", 1);
    }

    public String getName() {
        return this.f138a.getString(MediationMetaData.KEY_NAME);
    }

    public int getPlaybackStream() {
        return this.f138a.getInt("playbackStream", -1);
    }

    public int getPlaybackType() {
        return this.f138a.getInt("playbackType", 1);
    }

    public int getPresentationDisplayId() {
        return this.f138a.getInt("presentationDisplayId", -1);
    }

    public IntentSender getSettingsActivity() {
        return (IntentSender) this.f138a.getParcelable("settingsIntent");
    }

    public int getVolume() {
        return this.f138a.getInt("volume");
    }

    public int getVolumeHandling() {
        return this.f138a.getInt("volumeHandling", 0);
    }

    public int getVolumeMax() {
        return this.f138a.getInt("volumeMax");
    }

    public boolean isEnabled() {
        return this.f138a.getBoolean("enabled", true);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(getId()) || TextUtils.isEmpty(getName()) || getControlFilters().contains(null)) ? false : true;
    }

    public boolean isVisibilityPublic() {
        return this.f138a.getBoolean("isVisibilityPublic", true);
    }

    public String toString() {
        return "MediaRouteDescriptor{ id=" + getId() + ", groupMemberIds=" + getGroupMemberIds() + ", name=" + getName() + ", description=" + getDescription() + ", iconUri=" + getIconUri() + ", isEnabled=" + isEnabled() + ", connectionState=" + getConnectionState() + ", controlFilters=" + Arrays.toString(getControlFilters().toArray()) + ", playbackType=" + getPlaybackType() + ", playbackStream=" + getPlaybackStream() + ", deviceType=" + getDeviceType() + ", volume=" + getVolume() + ", volumeMax=" + getVolumeMax() + ", volumeHandling=" + getVolumeHandling() + ", presentationDisplayId=" + getPresentationDisplayId() + ", extras=" + getExtras() + ", isValid=" + isValid() + ", minClientVersion=" + getMinClientVersion() + ", maxClientVersion=" + getMaxClientVersion() + ", isVisibilityPublic=" + isVisibilityPublic() + ", allowedPackages=" + Arrays.toString(getAllowedPackages().toArray()) + " }";
    }

    /* compiled from: MediaRouteDescriptor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f139a;

        /* renamed from: b, reason: collision with root package name */
        public final List<String> f140b;

        /* renamed from: c, reason: collision with root package name */
        public final List<IntentFilter> f141c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f142d;

        public a(String str, String str2) {
            this.f140b = new ArrayList();
            this.f141c = new ArrayList();
            this.f142d = new HashSet();
            this.f139a = new Bundle();
            setId(str);
            setName(str2);
        }

        public a addControlFilter(IntentFilter intentFilter) {
            if (intentFilter == null) {
                throw new IllegalArgumentException("filter must not be null");
            }
            List<IntentFilter> list = this.f141c;
            if (!list.contains(intentFilter)) {
                list.add(intentFilter);
            }
            return this;
        }

        public a addControlFilters(Collection<IntentFilter> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("filters must not be null");
            }
            if (!collection.isEmpty()) {
                for (IntentFilter intentFilter : collection) {
                    if (intentFilter != null) {
                        addControlFilter(intentFilter);
                    }
                }
            }
            return this;
        }

        public a addGroupMemberId(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("groupMemberId must not be empty");
            }
            List<String> list = this.f140b;
            if (!list.contains(str)) {
                list.add(str);
            }
            return this;
        }

        public a addGroupMemberIds(Collection<String> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("groupMemberIds must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator<String> it = collection.iterator();
                while (it.hasNext()) {
                    addGroupMemberId(it.next());
                }
            }
            return this;
        }

        public g build() {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f141c);
            Bundle bundle = this.f139a;
            bundle.putParcelableArrayList("controlFilters", arrayList);
            bundle.putStringArrayList("groupMemberIds", new ArrayList<>(this.f140b));
            bundle.putStringArrayList("allowedPackages", new ArrayList<>(this.f142d));
            return new g(bundle);
        }

        public a clearControlFilters() {
            this.f141c.clear();
            return this;
        }

        public a clearGroupMemberIds() {
            this.f140b.clear();
            return this;
        }

        public a setCanDisconnect(boolean z10) {
            this.f139a.putBoolean("canDisconnect", z10);
            return this;
        }

        public a setConnectionState(int i10) {
            this.f139a.putInt("connectionState", i10);
            return this;
        }

        public a setDeduplicationIds(Set<String> set) {
            this.f139a.putStringArrayList("deduplicationIds", new ArrayList<>(set));
            return this;
        }

        public a setDescription(String str) {
            this.f139a.putString("status", str);
            return this;
        }

        public a setDeviceType(int i10) {
            this.f139a.putInt("deviceType", i10);
            return this;
        }

        public a setEnabled(boolean z10) {
            this.f139a.putBoolean("enabled", z10);
            return this;
        }

        public a setExtras(Bundle bundle) {
            Bundle bundle2 = this.f139a;
            if (bundle == null) {
                bundle2.putBundle("extras", null);
            } else {
                bundle2.putBundle("extras", new Bundle(bundle));
            }
            return this;
        }

        public a setIconUri(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("iconUri must not be null");
            }
            this.f139a.putString("iconUri", uri.toString());
            return this;
        }

        public a setId(String str) {
            if (str == null) {
                throw new NullPointerException("id must not be null");
            }
            this.f139a.putString("id", str);
            return this;
        }

        public a setName(String str) {
            if (str == null) {
                throw new NullPointerException("name must not be null");
            }
            this.f139a.putString(MediationMetaData.KEY_NAME, str);
            return this;
        }

        public a setPlaybackStream(int i10) {
            this.f139a.putInt("playbackStream", i10);
            return this;
        }

        public a setPlaybackType(int i10) {
            this.f139a.putInt("playbackType", i10);
            return this;
        }

        public a setPresentationDisplayId(int i10) {
            this.f139a.putInt("presentationDisplayId", i10);
            return this;
        }

        public a setVolume(int i10) {
            this.f139a.putInt("volume", i10);
            return this;
        }

        public a setVolumeHandling(int i10) {
            this.f139a.putInt("volumeHandling", i10);
            return this;
        }

        public a setVolumeMax(int i10) {
            this.f139a.putInt("volumeMax", i10);
            return this;
        }

        public a(g gVar) {
            this.f140b = new ArrayList();
            this.f141c = new ArrayList();
            this.f142d = new HashSet();
            if (gVar != null) {
                this.f139a = new Bundle(gVar.f138a);
                this.f140b = gVar.getGroupMemberIds();
                this.f141c = gVar.getControlFilters();
                this.f142d = gVar.getAllowedPackages();
                return;
            }
            throw new IllegalArgumentException("descriptor must not be null");
        }
    }
}
