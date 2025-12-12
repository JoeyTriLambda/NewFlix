package org.adblockplus.libadblockplus.android.webview.content_type;

import android.webkit.WebResourceRequest;
import org.adblockplus.libadblockplus.FilterEngine;

/* loaded from: classes2.dex */
public class OrderedContentTypeDetector implements ContentTypeDetector {
    private final ContentTypeDetector[] detectors;

    public OrderedContentTypeDetector(ContentTypeDetector... contentTypeDetectorArr) {
        this.detectors = contentTypeDetectorArr;
    }

    @Override // org.adblockplus.libadblockplus.android.webview.content_type.ContentTypeDetector
    public FilterEngine.ContentType detect(WebResourceRequest webResourceRequest) {
        for (ContentTypeDetector contentTypeDetector : this.detectors) {
            FilterEngine.ContentType contentTypeDetect = contentTypeDetector.detect(webResourceRequest);
            if (contentTypeDetect != null) {
                return contentTypeDetect;
            }
        }
        return null;
    }
}
