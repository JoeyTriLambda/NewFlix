package g8;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* compiled from: FirebaseOptions.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f12798a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12799b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12800c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12801d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12802e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12803f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12804g;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f12799b = str;
        this.f12798a = str2;
        this.f12800c = str3;
        this.f12801d = str4;
        this.f12802e = str5;
        this.f12803f = str6;
        this.f12804g = str7;
    }

    public static i fromResource(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new i(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Objects.equal(this.f12799b, iVar.f12799b) && Objects.equal(this.f12798a, iVar.f12798a) && Objects.equal(this.f12800c, iVar.f12800c) && Objects.equal(this.f12801d, iVar.f12801d) && Objects.equal(this.f12802e, iVar.f12802e) && Objects.equal(this.f12803f, iVar.f12803f) && Objects.equal(this.f12804g, iVar.f12804g);
    }

    public String getApiKey() {
        return this.f12798a;
    }

    public String getApplicationId() {
        return this.f12799b;
    }

    public String getGcmSenderId() {
        return this.f12802e;
    }

    public String getProjectId() {
        return this.f12804g;
    }

    public int hashCode() {
        return Objects.hashCode(this.f12799b, this.f12798a, this.f12800c, this.f12801d, this.f12802e, this.f12803f, this.f12804g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f12799b).add("apiKey", this.f12798a).add("databaseUrl", this.f12800c).add("gcmSenderId", this.f12802e).add("storageBucket", this.f12803f).add("projectId", this.f12804g).toString();
    }
}
