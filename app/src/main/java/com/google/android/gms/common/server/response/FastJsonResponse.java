package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @VisibleForTesting
    @SafeParcelable.Class
    @ShowFirstParty
    @KeepForSdk
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();

        /* renamed from: b, reason: collision with root package name */
        @SafeParcelable.VersionField
        public final int f7455b;

        /* renamed from: m, reason: collision with root package name */
        @SafeParcelable.Field
        public final int f7456m;

        /* renamed from: n, reason: collision with root package name */
        @SafeParcelable.Field
        public final boolean f7457n;

        /* renamed from: o, reason: collision with root package name */
        @SafeParcelable.Field
        public final int f7458o;

        /* renamed from: p, reason: collision with root package name */
        @SafeParcelable.Field
        public final boolean f7459p;

        /* renamed from: q, reason: collision with root package name */
        @SafeParcelable.Field
        public final String f7460q;

        /* renamed from: r, reason: collision with root package name */
        @SafeParcelable.Field
        public final int f7461r;

        /* renamed from: s, reason: collision with root package name */
        public final Class<? extends FastJsonResponse> f7462s;

        /* renamed from: t, reason: collision with root package name */
        @SafeParcelable.Field
        public final String f7463t;

        /* renamed from: u, reason: collision with root package name */
        public zan f7464u;

        /* renamed from: v, reason: collision with root package name */
        @SafeParcelable.Field
        public final FieldConverter<I, O> f7465v;

        @SafeParcelable.Constructor
        public Field(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param boolean z10, @SafeParcelable.Param int i12, @SafeParcelable.Param boolean z11, @SafeParcelable.Param String str, @SafeParcelable.Param int i13, @SafeParcelable.Param String str2, @SafeParcelable.Param com.google.android.gms.common.server.converter.zaa zaaVar) {
            this.f7455b = i10;
            this.f7456m = i11;
            this.f7457n = z10;
            this.f7458o = i12;
            this.f7459p = z11;
            this.f7460q = str;
            this.f7461r = i13;
            if (str2 == null) {
                this.f7462s = null;
                this.f7463t = null;
            } else {
                this.f7462s = SafeParcelResponse.class;
                this.f7463t = str2;
            }
            if (zaaVar == null) {
                this.f7465v = null;
            } else {
                this.f7465v = (FieldConverter<I, O>) zaaVar.zab();
            }
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.f7461r;
        }

        public final String toString() {
            Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f7455b)).add("typeIn", Integer.valueOf(this.f7456m)).add("typeInArray", Boolean.valueOf(this.f7457n)).add("typeOut", Integer.valueOf(this.f7458o)).add("typeOutArray", Boolean.valueOf(this.f7459p)).add("outputFieldName", this.f7460q).add("safeParcelFieldId", Integer.valueOf(this.f7461r));
            String str = this.f7463t;
            if (str == null) {
                str = null;
            }
            Objects.ToStringHelper toStringHelperAdd2 = toStringHelperAdd.add("concreteTypeName", str);
            Class<? extends FastJsonResponse> cls = this.f7462s;
            if (cls != null) {
                toStringHelperAdd2.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.f7465v;
            if (fieldConverter != null) {
                toStringHelperAdd2.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return toStringHelperAdd2.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.f7455b);
            SafeParcelWriter.writeInt(parcel, 2, this.f7456m);
            SafeParcelWriter.writeBoolean(parcel, 3, this.f7457n);
            SafeParcelWriter.writeInt(parcel, 4, this.f7458o);
            SafeParcelWriter.writeBoolean(parcel, 5, this.f7459p);
            SafeParcelWriter.writeString(parcel, 6, this.f7460q, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            String str = this.f7463t;
            if (str == null) {
                str = null;
            }
            SafeParcelWriter.writeString(parcel, 8, str, false);
            FieldConverter<I, O> fieldConverter = this.f7465v;
            SafeParcelWriter.writeParcelable(parcel, 9, fieldConverter != null ? com.google.android.gms.common.server.converter.zaa.zaa(fieldConverter) : null, i10, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }

        public final I zaf(O o6) {
            FieldConverter<I, O> fieldConverter = this.f7465v;
            Preconditions.checkNotNull(fieldConverter);
            return fieldConverter.zad(o6);
        }

        public final Map<String, Field<?, ?>> zah() {
            String str = this.f7463t;
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(this.f7464u);
            return (Map) Preconditions.checkNotNull(this.f7464u.zab(str));
        }

        public final void zai(zan zanVar) {
            this.f7464u = zanVar;
        }

        public final boolean zaj() {
            return this.f7465v != null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @ShowFirstParty
    public interface FieldConverter<I, O> {
        I zad(O o6);
    }

    public static final void a(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.f7456m;
        if (i10 == 11) {
            Class<? extends FastJsonResponse> cls = field.f7462s;
            Preconditions.checkNotNull(cls);
            sb2.append(cls.cast(obj).toString());
        } else {
            if (i10 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(JsonUtils.escapeString((String) obj));
            sb2.append("\"");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <O, I> I zaD(Field<I, O> field, Object obj) {
        return field.f7465v != null ? field.zaf(obj) : obj;
    }

    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @KeepForSdk
    public Object getFieldValue(Field field) {
        String str = field.f7460q;
        if (field.f7462s == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.f7460q);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strSubstring).length() + 4);
            sb2.append("get");
            sb2.append(upperCase);
            sb2.append(strSubstring);
            return getClass().getMethod(sb2.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    @KeepForSdk
    public abstract Object getValueObject(String str);

    @KeepForSdk
    public boolean isFieldSet(Field field) {
        if (field.f7458o != 11) {
            return isPrimitiveFieldSet(field.f7460q);
        }
        if (field.f7459p) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @KeepForSdk
    public abstract boolean isPrimitiveFieldSet(String str);

    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object objZaD = zaD(field, getFieldValue(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (objZaD != null) {
                    switch (field.f7458o) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(Base64Utils.encode((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(Base64Utils.encodeUrlSafe((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb2, (HashMap) objZaD);
                            break;
                        default:
                            if (field.f7457n) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        a(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            } else {
                                a(sb2, field, objZaD);
                                break;
                            }
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }
}
