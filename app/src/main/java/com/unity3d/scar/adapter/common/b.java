package com.unity3d.scar.adapter.common;

/* compiled from: GMAAdsError.java */
/* loaded from: classes2.dex */
public final class b extends j {
    public b(GMAEvent gMAEvent, Object... objArr) {
        super(gMAEvent, null, objArr);
    }

    public static b AdNotLoadedError(bb.c cVar) {
        String str = String.format("Cannot show ad that is not loaded for placement %s", cVar.getPlacementId());
        return new b(GMAEvent.AD_NOT_LOADED_ERROR, str, cVar.getPlacementId(), cVar.getQueryId(), str);
    }

    public static b AdapterCreationError(String str) {
        return new b(GMAEvent.SCAR_UNSUPPORTED, str, new Object[0]);
    }

    public static b InternalLoadError(bb.c cVar, String str) {
        return new b(GMAEvent.INTERNAL_LOAD_ERROR, str, cVar.getPlacementId(), cVar.getQueryId(), str);
    }

    public static b InternalShowError(bb.c cVar, String str) {
        return new b(GMAEvent.INTERNAL_SHOW_ERROR, str, cVar.getPlacementId(), cVar.getQueryId(), str);
    }

    public static b InternalSignalsError(String str) {
        return new b(GMAEvent.INTERNAL_SIGNALS_ERROR, str, str);
    }

    public static b NoAdsError(String str, String str2, String str3) {
        return new b(GMAEvent.NO_AD_ERROR, str3, str, str2, str3);
    }

    public static b QueryNotFoundError(bb.c cVar) {
        String str = String.format("Missing queryInfoMetadata for ad %s", cVar.getPlacementId());
        return new b(GMAEvent.QUERY_NOT_FOUND_ERROR, str, cVar.getPlacementId(), cVar.getQueryId(), str);
    }

    @Override // com.unity3d.scar.adapter.common.j
    public String getDomain() {
        return "GMA";
    }

    public b(GMAEvent gMAEvent, String str, Object... objArr) {
        super(gMAEvent, str, objArr);
    }
}
