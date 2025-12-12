package com.unity3d.services.store.core;

import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.core.webview.WebViewEventCategory;

/* loaded from: classes2.dex */
public class StoreWebViewError extends j {
    public StoreWebViewError(Enum<?> r12, String str, Object... objArr) {
        super(r12, str, objArr);
    }

    @Override // com.unity3d.scar.adapter.common.j
    public String getDomain() {
        return WebViewEventCategory.STORE.name();
    }
}
