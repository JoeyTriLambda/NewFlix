package org.adblockplus.libadblockplus;

import com.unity3d.services.core.request.metrics.MetricCommonTags;

/* loaded from: classes2.dex */
public class AppInfo {
    public final String application;
    public final String applicationVersion;
    public final String locale;
    public final String name;
    public final String version;

    public static class Builder {
        private String application;
        private String applicationVersion;
        private String locale;
        private String name;
        private String version;

        public AppInfo build() {
            return new AppInfo(this.version, this.name, this.application, this.applicationVersion, this.locale);
        }

        public Builder setApplication(String str) {
            this.application = str;
            return this;
        }

        public Builder setApplicationVersion(String str) {
            this.applicationVersion = str;
            return this;
        }

        public Builder setLocale(String str) {
            this.locale = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        private Builder() {
            this.version = "1.0";
            this.name = "libadblockplus-android";
            this.application = MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID;
            this.applicationVersion = "0";
            this.locale = "en_US";
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private AppInfo(String str, String str2, String str3, String str4, String str5) {
        this.version = str;
        this.name = str2;
        this.application = str3;
        this.applicationVersion = str4;
        this.locale = str5;
    }
}
