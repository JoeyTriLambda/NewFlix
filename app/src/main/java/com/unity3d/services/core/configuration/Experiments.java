package com.unity3d.services.core.configuration;

import com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Experiments extends ExperimentsBase {
    private static final Set<String> NEXT_SESSION_FLAGS = new HashSet(Collections.singletonList("tsi_prw"));
    private final JSONObject _experimentData;

    public Experiments() {
        this(null);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getCurrentSessionExperiments() {
        if (this._experimentData == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = this._experimentData.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!NEXT_SESSION_FLAGS.contains(next)) {
                map.put(next, String.valueOf(this._experimentData.optBoolean(next)));
            }
        }
        return new JSONObject(map);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public Map<String, String> getExperimentTags() {
        HashMap map = new HashMap();
        Iterator<String> itKeys = this._experimentData.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, String.valueOf(this._experimentData.opt(next)));
        }
        return map;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getExperimentsAsJson() {
        return this._experimentData;
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public JSONObject getNextSessionExperiments() {
        if (this._experimentData == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = this._experimentData.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (NEXT_SESSION_FLAGS.contains(next)) {
                map.put(next, String.valueOf(this._experimentData.optBoolean(next)));
            }
        }
        return new JSONObject(map);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public String getScarBiddingManager() {
        return this._experimentData.optString("scar_bm", SCARBiddingManagerType.DISABLED.getName());
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isJetpackLifecycle() {
        return this._experimentData.optBoolean("gjl", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isNativeWebViewCacheEnabled() {
        return this._experimentData.optBoolean("nwc", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isOkHttpEnabled() {
        return this._experimentData.optBoolean("okhttp", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isScarInitEnabled() {
        return this._experimentData.optBoolean("scar_init", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebAssetAdCaching() {
        return this._experimentData.optBoolean("wac", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebGestureNotRequired() {
        return this._experimentData.optBoolean("wgr", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebMessageEnabled() {
        return this._experimentData.optBoolean("jwm", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean isWebViewAsyncDownloadEnabled() {
        return this._experimentData.optBoolean("wad", false);
    }

    @Override // com.unity3d.services.core.configuration.IExperiments
    public boolean shouldNativeTokenAwaitPrivacy() {
        return this._experimentData.optBoolean("tsi_prw", false);
    }

    public Experiments(JSONObject jSONObject) {
        if (jSONObject == null) {
            this._experimentData = new JSONObject();
        } else {
            this._experimentData = jSONObject;
        }
    }
}
