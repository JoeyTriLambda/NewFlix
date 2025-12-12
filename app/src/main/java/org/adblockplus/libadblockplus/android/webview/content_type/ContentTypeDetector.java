package org.adblockplus.libadblockplus.android.webview.content_type;

import android.webkit.WebResourceRequest;
import org.adblockplus.libadblockplus.FilterEngine;

/* loaded from: classes2.dex */
public interface ContentTypeDetector {
    FilterEngine.ContentType detect(WebResourceRequest webResourceRequest);
}
