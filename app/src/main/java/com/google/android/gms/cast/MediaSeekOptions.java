package com.google.android.gms.cast;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public class MediaSeekOptions {

    /* renamed from: a, reason: collision with root package name */
    public final long f6269a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6270b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6271c;

    /* renamed from: d, reason: collision with root package name */
    public final JSONObject f6272d;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f6273a;

        /* renamed from: b, reason: collision with root package name */
        public int f6274b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6275c;

        /* renamed from: d, reason: collision with root package name */
        public JSONObject f6276d;

        public MediaSeekOptions build() {
            return new MediaSeekOptions(this.f6273a, this.f6274b, this.f6275c, this.f6276d);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.f6276d = jSONObject;
            return this;
        }

        public Builder setIsSeekToInfinite(boolean z10) {
            this.f6275c = z10;
            return this;
        }

        public Builder setPosition(long j10) {
            this.f6273a = j10;
            return this;
        }

        public Builder setResumeState(int i10) {
            this.f6274b = i10;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResumeState {
    }

    public /* synthetic */ MediaSeekOptions(long j10, int i10, boolean z10, JSONObject jSONObject) {
        this.f6269a = j10;
        this.f6270b = i10;
        this.f6271c = z10;
        this.f6272d = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSeekOptions)) {
            return false;
        }
        MediaSeekOptions mediaSeekOptions = (MediaSeekOptions) obj;
        return this.f6269a == mediaSeekOptions.f6269a && this.f6270b == mediaSeekOptions.f6270b && this.f6271c == mediaSeekOptions.f6271c && Objects.equal(this.f6272d, mediaSeekOptions.f6272d);
    }

    public JSONObject getCustomData() {
        return this.f6272d;
    }

    public long getPosition() {
        return this.f6269a;
    }

    public int getResumeState() {
        return this.f6270b;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f6269a), Integer.valueOf(this.f6270b), Boolean.valueOf(this.f6271c), this.f6272d);
    }

    public boolean isSeekToInfinite() {
        return this.f6271c;
    }
}
