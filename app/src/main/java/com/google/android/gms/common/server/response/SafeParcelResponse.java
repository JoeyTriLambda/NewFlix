package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7466b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final Parcel f7467m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7468n = 2;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final zan f7469o;

    /* renamed from: p, reason: collision with root package name */
    public final String f7470p;

    /* renamed from: q, reason: collision with root package name */
    public int f7471q;

    /* renamed from: r, reason: collision with root package name */
    public int f7472r;

    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param int i10, @SafeParcelable.Param Parcel parcel, @SafeParcelable.Param zan zanVar) {
        this.f7466b = i10;
        this.f7467m = (Parcel) Preconditions.checkNotNull(parcel);
        this.f7469o = zanVar;
        this.f7470p = zanVar == null ? null : zanVar.zaa();
        this.f7471q = 2;
    }

    public static void b(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).getSafeParcelableFieldId(), entry);
        }
        sb2.append('{');
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(header));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                boolean zZaj = field.zaj();
                int i10 = field.f7458o;
                if (zZaj) {
                    switch (i10) {
                        case 0:
                            d(sb2, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.readInt(parcel, header))));
                            break;
                        case 1:
                            d(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigInteger(parcel, header)));
                            break;
                        case 2:
                            d(sb2, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.readLong(parcel, header))));
                            break;
                        case 3:
                            d(sb2, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.readFloat(parcel, header))));
                            break;
                        case 4:
                            d(sb2, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.readDouble(parcel, header))));
                            break;
                        case 5:
                            d(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigDecimal(parcel, header)));
                            break;
                        case 6:
                            d(sb2, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.readBoolean(parcel, header))));
                            break;
                        case 7:
                            d(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createString(parcel, header)));
                            break;
                        case 8:
                        case 9:
                            d(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createByteArray(parcel, header)));
                            break;
                        case 10:
                            Bundle bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleCreateBundle.keySet()) {
                                map2.put(str2, (String) Preconditions.checkNotNull(bundleCreateBundle.getString(str2)));
                            }
                            d(sb2, field, FastJsonResponse.zaD(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb3 = new StringBuilder(36);
                            sb3.append("Unknown field out type = ");
                            sb3.append(i10);
                            throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (field.f7459p) {
                    sb2.append("[");
                    switch (i10) {
                        case 0:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createIntArray(parcel, header));
                            break;
                        case 1:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createBigIntegerArray(parcel, header));
                            break;
                        case 2:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createLongArray(parcel, header));
                            break;
                        case 3:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createFloatArray(parcel, header));
                            break;
                        case 4:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createDoubleArray(parcel, header));
                            break;
                        case 5:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createBigDecimalArray(parcel, header));
                            break;
                        case 6:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createBooleanArray(parcel, header));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(sb2, SafeParcelReader.createStringArray(parcel, header));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrCreateParcelArray = SafeParcelReader.createParcelArray(parcel, header);
                            int length = parcelArrCreateParcelArray.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(",");
                                }
                                parcelArrCreateParcelArray[i11].setDataPosition(0);
                                b(sb2, field.zah(), parcelArrCreateParcelArray[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (i10) {
                        case 0:
                            sb2.append(SafeParcelReader.readInt(parcel, header));
                            break;
                        case 1:
                            sb2.append(SafeParcelReader.createBigInteger(parcel, header));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.readLong(parcel, header));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.readFloat(parcel, header));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.readDouble(parcel, header));
                            break;
                        case 5:
                            sb2.append(SafeParcelReader.createBigDecimal(parcel, header));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.readBoolean(parcel, header));
                            break;
                        case 7:
                            String strCreateString = SafeParcelReader.createString(parcel, header);
                            sb2.append("\"");
                            sb2.append(JsonUtils.escapeString(strCreateString));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                            sb2.append("\"");
                            sb2.append(Base64Utils.encode(bArrCreateByteArray));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                            sb2.append("\"");
                            sb2.append(Base64Utils.encodeUrlSafe(bArrCreateByteArray2));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle bundleCreateBundle2 = SafeParcelReader.createBundle(parcel, header);
                            Set<String> setKeySet = bundleCreateBundle2.keySet();
                            sb2.append("{");
                            boolean z11 = true;
                            for (String str3 : setKeySet) {
                                if (!z11) {
                                    sb2.append(",");
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\":\"");
                                sb2.append(JsonUtils.escapeString(bundleCreateBundle2.getString(str3)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel parcelCreateParcel = SafeParcelReader.createParcel(parcel, header);
                            parcelCreateParcel.setDataPosition(0);
                            b(sb2, field.zah(), parcelCreateParcel);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == iValidateObjectHeader) {
            sb2.append('}');
            return;
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("Overread allowed size end=");
        sb4.append(iValidateObjectHeader);
        throw new SafeParcelReader.ParseException(sb4.toString(), parcel);
    }

    public static final void c(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(JsonUtils.escapeString(Preconditions.checkNotNull(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(Base64Utils.encode((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb2, (HashMap) Preconditions.checkNotNull(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb3 = new StringBuilder(26);
                sb3.append("Unknown type = ");
                sb3.append(i10);
                throw new IllegalArgumentException(sb3.toString());
        }
    }

    public static final void d(StringBuilder sb2, FastJsonResponse.Field<?, ?> field, Object obj) {
        boolean z10 = field.f7457n;
        int i10 = field.f7456m;
        if (!z10) {
            c(sb2, i10, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 != 0) {
                sb2.append(",");
            }
            c(sb2, i10, arrayList.get(i11));
        }
        sb2.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zanVar = this.f7469o;
        if (zanVar == null) {
            return null;
        }
        return zanVar.zab((String) Preconditions.checkNotNull(this.f7470p));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        zan zanVar = this.f7469o;
        Preconditions.checkNotNull(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelZaE = zaE();
        parcelZaE.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        b(sb2, (Map) Preconditions.checkNotNull(zanVar.zab((String) Preconditions.checkNotNull(this.f7470p))), parcelZaE);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7466b);
        SafeParcelWriter.writeParcel(parcel, 2, zaE(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7468n != 0 ? this.f7469o : null, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final Parcel zaE() {
        int i10 = this.f7471q;
        Parcel parcel = this.f7467m;
        if (i10 == 0) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            this.f7472r = iBeginObjectHeader;
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
            this.f7471q = 2;
        } else if (i10 == 1) {
            SafeParcelWriter.finishObjectHeader(parcel, this.f7472r);
            this.f7471q = 2;
        }
        return parcel;
    }
}
