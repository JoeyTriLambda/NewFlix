package com.google.android.gms.measurement.internal;

import ac.c;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqk;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import m0.a;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zznm extends zzmy {
    public zznm(zznd zzndVar) {
        super(zzndVar);
    }

    public static boolean A(int i10, List list) {
        if (i10 < (list.size() << 6)) {
            return ((1 << (i10 % 64)) & ((Long) list.get(i10 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static Bundle C(List<zzft.zzg> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzg zzgVar : list) {
            String strZzg = zzgVar.zzg();
            if (zzgVar.zzj()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zza()));
            } else if (zzgVar.zzk()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zzb()));
            } else if (zzgVar.zzn()) {
                bundle.putString(strZzg, zzgVar.zzh());
            } else if (zzgVar.zzl()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zzd()));
            }
        }
        return bundle;
    }

    /* JADX WARN: Type inference failed for: r6v9, types: [android.os.Bundle[], java.io.Serializable] */
    public static Serializable D(zzft.zze zzeVar, String str) {
        zzft.zzg zzgVarF = f(zzeVar, str);
        if (zzgVarF == null) {
            return null;
        }
        if (zzgVarF.zzn()) {
            return zzgVarF.zzh();
        }
        if (zzgVarF.zzl()) {
            return Long.valueOf(zzgVarF.zzd());
        }
        if (zzgVarF.zzj()) {
            return Double.valueOf(zzgVarF.zza());
        }
        if (zzgVarF.zzc() <= 0) {
            return null;
        }
        List<zzft.zzg> listZzi = zzgVarF.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzft.zzg zzgVar : listZzi) {
            if (zzgVar != null) {
                Bundle bundle = new Bundle();
                for (zzft.zzg zzgVar2 : zzgVar.zzi()) {
                    if (zzgVar2.zzn()) {
                        bundle.putString(zzgVar2.zzg(), zzgVar2.zzh());
                    } else if (zzgVar2.zzl()) {
                        bundle.putLong(zzgVar2.zzg(), zzgVar2.zzd());
                    } else if (zzgVar2.zzj()) {
                        bundle.putDouble(zzgVar2.zzg(), zzgVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static boolean E(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static Bundle G(List<zzft.zzn> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzn zznVar : list) {
            String strZzg = zznVar.zzg();
            if (zznVar.zzi()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zza()));
            } else if (zznVar.zzj()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zzb()));
            } else if (zznVar.zzm()) {
                bundle.putString(strZzg, zznVar.zzh());
            } else if (zznVar.zzk()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zzc()));
            }
        }
        return bundle;
    }

    public static int a(zzft.zzj.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < zzaVar.zzd(); i10++) {
            if (str.equals(zzaVar.zzk(i10).zzg())) {
                return i10;
            }
        }
        return -1;
    }

    public static Bundle c(Map map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(c((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static zzft.zzg f(zzft.zze zzeVar, String str) {
        for (zzft.zzg zzgVar : zzeVar.zzh()) {
            if (zzgVar.zzg().equals(str)) {
                return zzgVar;
            }
        }
        return null;
    }

    public static com.google.android.gms.internal.measurement.zzlf g(zzjt.zza zzaVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzkb {
        com.google.android.gms.internal.measurement.zzjg zzjgVarZza = com.google.android.gms.internal.measurement.zzjg.zza();
        return zzjgVarZza != null ? zzaVar.zza(bArr, zzjgVarZza) : zzaVar.zza(bArr);
    }

    public static zzbf h(com.google.android.gms.internal.measurement.zzad zzadVar) {
        Object obj;
        Bundle bundleC = c(zzadVar.zzc(), true);
        String string = (!bundleC.containsKey("_o") || (obj = bundleC.get("_o")) == null) ? "app" : obj.toString();
        String strZzb = zzit.zzb(zzadVar.zzb());
        if (strZzb == null) {
            strZzb = zzadVar.zzb();
        }
        return new zzbf(strZzb, new zzba(bundleC), string, zzadVar.zza());
    }

    public static String m(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    public static ArrayList n(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 < bitSet.length()) {
                    if (bitSet.get(i12)) {
                        j10 |= 1 << i11;
                    }
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static HashMap o(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(o((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj2 = arrayList2.get(i10);
                            i10++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(o((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(o((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static void q(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static void r(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                q(builder, str3, string, set);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void s(zzft.zze.zza zzaVar, String str, Long l10) {
        List<zzft.zzg> listZzf = zzaVar.zzf();
        int i10 = 0;
        while (true) {
            if (i10 >= listZzf.size()) {
                i10 = -1;
                break;
            } else if (str.equals(listZzf.get(i10).zzg())) {
                break;
            } else {
                i10++;
            }
        }
        zzft.zzg.zza zzaVarZza = zzft.zzg.zze().zza(str);
        if (l10 instanceof Long) {
            zzaVarZza.zza(l10.longValue());
        } else if (l10 instanceof String) {
            zzaVarZza.zzb((String) l10);
        } else if (l10 instanceof Double) {
            zzaVarZza.zza(((Double) l10).doubleValue());
        }
        if (i10 >= 0) {
            zzaVar.zza(i10, zzaVarZza);
        } else {
            zzaVar.zza(zzaVarZza);
        }
    }

    public static void u(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    public static void w(StringBuilder sb2, int i10, String str, zzfh.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        u(sb2, i10);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzdVar.zzh()) {
            x(sb2, i10, "comparison_type", zzdVar.zza().name());
        }
        if (zzdVar.zzj()) {
            x(sb2, i10, "match_as_float", Boolean.valueOf(zzdVar.zzg()));
        }
        if (zzdVar.zzi()) {
            x(sb2, i10, "comparison_value", zzdVar.zzd());
        }
        if (zzdVar.zzl()) {
            x(sb2, i10, "min_comparison_value", zzdVar.zzf());
        }
        if (zzdVar.zzk()) {
            x(sb2, i10, "max_comparison_value", zzdVar.zze());
        }
        u(sb2, i10);
        sb2.append("}\n");
    }

    public static void x(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        u(sb2, i10 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    public static void z(StringBuilder sb2, String str, zzft.zzl zzlVar) {
        if (zzlVar == null) {
            return;
        }
        u(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzlVar.zzb() != 0) {
            u(sb2, 4);
            sb2.append("results: ");
            int i10 = 0;
            for (Long l10 : zzlVar.zzi()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i10 = i11;
            }
            sb2.append('\n');
        }
        if (zzlVar.zzd() != 0) {
            u(sb2, 4);
            sb2.append("status: ");
            int i12 = 0;
            for (Long l11 : zzlVar.zzk()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i12 = i13;
            }
            sb2.append('\n');
        }
        if (zzlVar.zza() != 0) {
            u(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i14 = 0;
            for (zzft.zzd zzdVar : zzlVar.zzh()) {
                int i15 = i14 + 1;
                if (i14 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zzdVar.zzf() ? Integer.valueOf(zzdVar.zza()) : null);
                sb2.append(":");
                sb2.append(zzdVar.zze() ? Long.valueOf(zzdVar.zzb()) : null);
                i14 = i15;
            }
            sb2.append("}\n");
        }
        if (zzlVar.zzc() != 0) {
            u(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i16 = 0;
            for (zzft.zzm zzmVar : zzlVar.zzj()) {
                int i17 = i16 + 1;
                if (i16 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zzmVar.zzf() ? Integer.valueOf(zzmVar.zzb()) : null);
                sb2.append(": [");
                Iterator<Long> it = zzmVar.zze().iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i19 = i18 + 1;
                    if (i18 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i18 = i19;
                }
                sb2.append("]");
                i16 = i17;
            }
            sb2.append("}\n");
        }
        u(sb2, 3);
        sb2.append("}\n");
    }

    public final boolean B(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(zzb().currentTimeMillis() - j10) > j11;
    }

    public final byte[] F(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            zzj().zzg().zza("Failed to gzip content", e10);
            throw e10;
        }
    }

    public final boolean H(String str) throws IllegalStateException, OperationCanceledException, IOException, AuthenticatorException {
        Account[] result;
        boolean zBooleanValue;
        if (zzoi.zza() && zze().zza(zzbh.U0)) {
            return false;
        }
        Preconditions.checkNotNull(str);
        zzf zzfVarZze = zzh().zze(str);
        if (zzfVarZze == null) {
            return false;
        }
        zzaz zzazVarZzf = zzf();
        zzazVarZzf.zzt();
        long jCurrentTimeMillis = zzazVarZzf.zzb().currentTimeMillis();
        if (jCurrentTimeMillis - zzazVarZzf.f7703g > DateUtils.MILLIS_PER_DAY) {
            zzazVarZzf.f7702f = null;
        }
        Boolean bool = zzazVarZzf.f7702f;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (a.checkSelfPermission(zzazVarZzf.zza(), "android.permission.GET_ACCOUNTS") != 0) {
                zzazVarZzf.zzj().zzw().zza("Permission error checking for dasher/unicorn accounts");
                zzazVarZzf.f7703g = jCurrentTimeMillis;
                zzazVarZzf.f7702f = Boolean.FALSE;
            } else {
                if (zzazVarZzf.f7701e == null) {
                    zzazVarZzf.f7701e = AccountManager.get(zzazVarZzf.zza());
                }
                try {
                    result = zzazVarZzf.f7701e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
                } catch (AuthenticatorException | OperationCanceledException | IOException e10) {
                    zzazVarZzf.zzj().zzm().zza("Exception checking account types", e10);
                }
                if (result == null || result.length <= 0) {
                    Account[] result2 = zzazVarZzf.f7701e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
                    if (result2 != null && result2.length > 0) {
                        zzazVarZzf.f7702f = Boolean.TRUE;
                        zzazVarZzf.f7703g = jCurrentTimeMillis;
                    }
                    zzazVarZzf.f7703g = jCurrentTimeMillis;
                    zzazVarZzf.f7702f = Boolean.FALSE;
                } else {
                    zzazVarZzf.f7702f = Boolean.TRUE;
                    zzazVarZzf.f7703g = jCurrentTimeMillis;
                }
                zBooleanValue = true;
            }
            zBooleanValue = false;
        }
        if (zBooleanValue && zzfVarZze.zzao()) {
            zzgy zzgyVarZzm = zzm();
            zzgyVarZzm.zzt();
            zzfn.zzd zzdVarZzc = zzgyVarZzm.zzc(str);
            if (zzdVarZzc == null ? false : zzdVarZzc.zzo()) {
                return true;
            }
        }
        return false;
    }

    public final byte[] I(byte[] bArr) throws IllegalStateException, IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i10 = gZIPInputStream.read(bArr2);
                if (i10 <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i10);
            }
        } catch (IOException e10) {
            zzj().zzg().zza("Failed to ungzip content", e10);
            throw e10;
        }
    }

    public final ArrayList J() throws IllegalStateException, NumberFormatException {
        Map<String, String> mapZza = zzbh.zza(this.f8525b.zza());
        if (mapZza == null || mapZza.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = zzbh.Q.zza(null).intValue();
        for (Map.Entry<String, String> entry : mapZza.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i10 = Integer.parseInt(entry.getValue());
                    if (i10 != 0) {
                        arrayList.add(Integer.valueOf(i10));
                        if (arrayList.size() >= iIntValue) {
                            zzj().zzu().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e10) {
                    zzj().zzu().zza("Experiment ID NumberFormatException", e10);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final long b(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzq().zzt();
        MessageDigest messageDigestS = zznt.S();
        if (messageDigestS != null) {
            return zznt.d(messageDigestS.digest(bArr));
        }
        zzj().zzg().zza("Failed to get MD5");
        return 0L;
    }

    public final <T extends Parcelable> T d(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzj().zzg().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final zzft.zze e(zzay zzayVar) throws IllegalStateException {
        zzft.zze.zza zzaVarZza = zzft.zze.zze().zza(zzayVar.f7697e);
        zzba zzbaVar = zzayVar.f7698f;
        Iterator<String> it = zzbaVar.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzft.zzg.zza zzaVarZza2 = zzft.zzg.zze().zza(next);
            Object obj = zzbaVar.f7707b.get(next);
            Preconditions.checkNotNull(obj);
            t(zzaVarZza2, obj);
            zzaVarZza.zza(zzaVarZza2);
        }
        return (zzft.zze) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZza.zzah());
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @TargetApi(30)
    public final zzmv i(String str, zzft.zzj.zza zzaVar, zzft.zze.zza zzaVar2, String str2) {
        int iIndexOf;
        if (!zzpy.zza() || !zze().zze(str, zzbh.E0)) {
            return null;
        }
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Set setZza = zznp.zza(zze().zzd(str, zzbh.f7736e0).split(","));
        Uri.Builder builderA = zzo().a(str);
        q(builderA, "gmp_app_id", zzaVar.zzx(), setZza);
        q(builderA, "gmp_version", "87000", setZza);
        String strZzu = zzaVar.zzu();
        zzae zzaeVarZze = zze();
        zzfo<Boolean> zzfoVar = zzbh.H0;
        String str3 = "";
        if (zzaeVarZze.zze(str, zzfoVar) && zzm().n(str)) {
            strZzu = "";
        }
        q(builderA, "app_instance_id", strZzu, setZza);
        q(builderA, "rdid", zzaVar.zzz(), setZza);
        q(builderA, "bundle_id", zzaVar.zzt(), setZza);
        String strZze = zzaVar2.zze();
        String strZza = zzit.zza(strZze);
        if (!TextUtils.isEmpty(strZza)) {
            strZze = strZza;
        }
        q(builderA, "app_event_name", strZze, setZza);
        q(builderA, "app_version", String.valueOf(zzaVar.zzb()), setZza);
        String strZzy = zzaVar.zzy();
        if (!zze().zze(str, zzfoVar) || !zzm().o(str)) {
            str3 = strZzy;
        } else if (zze().zze(str, zzbh.f7772w0)) {
            if (!TextUtils.isEmpty(strZzy) && (iIndexOf = strZzy.indexOf(".")) != -1) {
                strZzy = strZzy.substring(0, iIndexOf);
            }
            str3 = strZzy;
        }
        q(builderA, "os_version", str3, setZza);
        q(builderA, "timestamp", String.valueOf(zzaVar2.zzc()), setZza);
        if (zzaVar.zzad()) {
            q(builderA, "lat", "1", setZza);
        }
        q(builderA, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), setZza);
        q(builderA, "trigger_uri_source", "1", setZza);
        q(builderA, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setZza);
        q(builderA, "request_uuid", str2, setZza);
        r(builderA, zze().zzd(str, zzbh.f7734d0).split("\\|"), C(zzaVar2.zzf()), setZza);
        r(builderA, zze().zzd(str, zzbh.f7732c0).split("\\|"), G(zzaVar.zzab()), setZza);
        if (zze().zza(zzbh.M0)) {
            q(builderA, "dma", zzaVar.zzac() ? "1" : "0", setZza);
            if (!zzaVar.zzw().isEmpty()) {
                q(builderA, "dma_cps", zzaVar.zzw(), setZza);
            }
        }
        return new zzmv(1, builderA.build().toString(), jCurrentTimeMillis);
    }

    @TargetApi(30)
    public final zzmv j(String str, zzft.zzj zzjVar, zzft.zze.zza zzaVar, String str2) {
        int iIndexOf;
        if (!zzpy.zza() || !zze().zze(str, zzbh.E0)) {
            return null;
        }
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Set setZza = zznp.zza(zze().zzd(str, zzbh.f7736e0).split(","));
        Uri.Builder builderA = zzo().a(str);
        q(builderA, "gmp_app_id", zzjVar.zzah(), setZza);
        q(builderA, "gmp_version", "87000", setZza);
        String strZzy = zzjVar.zzy();
        zzae zzaeVarZze = zze();
        zzfo<Boolean> zzfoVar = zzbh.H0;
        String str3 = "";
        if (zzaeVarZze.zze(str, zzfoVar) && zzm().n(str)) {
            strZzy = "";
        }
        q(builderA, "app_instance_id", strZzy, setZza);
        q(builderA, "rdid", zzjVar.zzal(), setZza);
        q(builderA, "bundle_id", zzjVar.zzx(), setZza);
        String strZze = zzaVar.zze();
        String strZza = zzit.zza(strZze);
        if (!TextUtils.isEmpty(strZza)) {
            strZze = strZza;
        }
        q(builderA, "app_event_name", strZze, setZza);
        q(builderA, "app_version", String.valueOf(zzjVar.zzb()), setZza);
        String strH_ = zzjVar.h_();
        if (!zze().zze(str, zzfoVar) || !zzm().o(str)) {
            str3 = strH_;
        } else if (zze().zze(str, zzbh.f7772w0)) {
            if (!TextUtils.isEmpty(strH_) && (iIndexOf = strH_.indexOf(".")) != -1) {
                strH_ = strH_.substring(0, iIndexOf);
            }
            str3 = strH_;
        }
        q(builderA, "os_version", str3, setZza);
        q(builderA, "timestamp", String.valueOf(zzaVar.zzc()), setZza);
        if (zzjVar.zzat()) {
            q(builderA, "lat", "1", setZza);
        }
        q(builderA, "privacy_sandbox_version", String.valueOf(zzjVar.zza()), setZza);
        q(builderA, "trigger_uri_source", "1", setZza);
        q(builderA, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setZza);
        q(builderA, "request_uuid", str2, setZza);
        r(builderA, zze().zzd(str, zzbh.f7734d0).split("\\|"), C(zzaVar.zzf()), setZza);
        r(builderA, zze().zzd(str, zzbh.f7732c0).split("\\|"), G(zzjVar.zzaq()), setZza);
        if (zze().zza(zzbh.M0)) {
            q(builderA, "dma", zzjVar.zzas() ? "1" : "0", setZza);
            if (!zzjVar.zzad().isEmpty()) {
                q(builderA, "dma_cps", zzjVar.zzad(), setZza);
            }
        }
        return new zzmv(1, builderA.build().toString(), jCurrentTimeMillis);
    }

    public final String k(zzfh.zze zzeVar) {
        StringBuilder sbR = c.r("\nproperty_filter {\n");
        if (zzeVar.zzi()) {
            x(sbR, 0, "filter_id", Integer.valueOf(zzeVar.zza()));
        }
        x(sbR, 0, "property_name", zzi().zzc(zzeVar.zze()));
        String strM = m(zzeVar.zzf(), zzeVar.zzg(), zzeVar.zzh());
        if (!strM.isEmpty()) {
            x(sbR, 0, "filter_type", strM);
        }
        v(sbR, 1, zzeVar.zzb());
        sbR.append("}\n");
        return sbR.toString();
    }

    public final String l(zzft.zzi zziVar) {
        zzft.zzb zzbVarZzt;
        if (zziVar == null) {
            return "";
        }
        StringBuilder sbR = c.r("\nbatch {\n");
        for (zzft.zzj zzjVar : zziVar.zzd()) {
            if (zzjVar != null) {
                u(sbR, 1);
                sbR.append("bundle {\n");
                if (zzjVar.zzbk()) {
                    x(sbR, 1, "protocol_version", Integer.valueOf(zzjVar.zze()));
                }
                if (zzqk.zza() && zze().zze(zzjVar.zzx(), zzbh.f7764s0) && zzjVar.zzbn()) {
                    x(sbR, 1, "session_stitching_token", zzjVar.zzam());
                }
                x(sbR, 1, "platform", zzjVar.zzak());
                if (zzjVar.zzbf()) {
                    x(sbR, 1, "gmp_version", Long.valueOf(zzjVar.zzm()));
                }
                if (zzjVar.zzbs()) {
                    x(sbR, 1, "uploading_gmp_version", Long.valueOf(zzjVar.zzs()));
                }
                if (zzjVar.zzbd()) {
                    x(sbR, 1, "dynamite_version", Long.valueOf(zzjVar.zzk()));
                }
                if (zzjVar.zzay()) {
                    x(sbR, 1, "config_version", Long.valueOf(zzjVar.zzi()));
                }
                x(sbR, 1, "gmp_app_id", zzjVar.zzah());
                x(sbR, 1, "admob_app_id", zzjVar.zzw());
                x(sbR, 1, "app_id", zzjVar.zzx());
                x(sbR, 1, "app_version", zzjVar.zzaa());
                if (zzjVar.zzav()) {
                    x(sbR, 1, "app_version_major", Integer.valueOf(zzjVar.zzb()));
                }
                x(sbR, 1, "firebase_instance_id", zzjVar.zzag());
                if (zzjVar.zzbc()) {
                    x(sbR, 1, "dev_cert_hash", Long.valueOf(zzjVar.zzj()));
                }
                x(sbR, 1, "app_store", zzjVar.zzz());
                if (zzjVar.zzbr()) {
                    x(sbR, 1, "upload_timestamp_millis", Long.valueOf(zzjVar.zzr()));
                }
                if (zzjVar.zzbo()) {
                    x(sbR, 1, "start_timestamp_millis", Long.valueOf(zzjVar.zzp()));
                }
                if (zzjVar.zzbe()) {
                    x(sbR, 1, "end_timestamp_millis", Long.valueOf(zzjVar.zzl()));
                }
                if (zzjVar.zzbj()) {
                    x(sbR, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzjVar.zzo()));
                }
                if (zzjVar.zzbi()) {
                    x(sbR, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzjVar.zzn()));
                }
                x(sbR, 1, "app_instance_id", zzjVar.zzy());
                x(sbR, 1, "resettable_device_id", zzjVar.zzal());
                x(sbR, 1, "ds_id", zzjVar.zzaf());
                if (zzjVar.zzbh()) {
                    x(sbR, 1, "limited_ad_tracking", Boolean.valueOf(zzjVar.zzat()));
                }
                x(sbR, 1, "os_version", zzjVar.h_());
                x(sbR, 1, "device_model", zzjVar.zzae());
                x(sbR, 1, "user_default_language", zzjVar.zzan());
                if (zzjVar.zzbq()) {
                    x(sbR, 1, "time_zone_offset_minutes", Integer.valueOf(zzjVar.zzg()));
                }
                if (zzjVar.zzax()) {
                    x(sbR, 1, "bundle_sequential_index", Integer.valueOf(zzjVar.zzc()));
                }
                if (zzjVar.zzbm()) {
                    x(sbR, 1, "service_upload", Boolean.valueOf(zzjVar.zzau()));
                }
                x(sbR, 1, "health_monitor", zzjVar.zzai());
                if (zzjVar.zzbl()) {
                    x(sbR, 1, "retry_counter", Integer.valueOf(zzjVar.zzf()));
                }
                if (zzjVar.zzba()) {
                    x(sbR, 1, "consent_signals", zzjVar.zzac());
                }
                if (zzjVar.zzbg()) {
                    x(sbR, 1, "is_dma_region", Boolean.valueOf(zzjVar.zzas()));
                }
                if (zzjVar.zzbb()) {
                    x(sbR, 1, "core_platform_services", zzjVar.zzad());
                }
                if (zzjVar.zzaz()) {
                    x(sbR, 1, "consent_diagnostics", zzjVar.zzab());
                }
                if (zzjVar.zzbp()) {
                    x(sbR, 1, "target_os_version", Long.valueOf(zzjVar.zzq()));
                }
                if (zzpy.zza() && zze().zze(zzjVar.zzx(), zzbh.E0)) {
                    x(sbR, 1, "ad_services_version", Integer.valueOf(zzjVar.zza()));
                    if (zzjVar.zzaw() && (zzbVarZzt = zzjVar.zzt()) != null) {
                        u(sbR, 2);
                        sbR.append("attribution_eligibility_status {\n");
                        x(sbR, 2, "eligible", Boolean.valueOf(zzbVarZzt.zzf()));
                        x(sbR, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzbVarZzt.zzh()));
                        x(sbR, 2, "pre_r", Boolean.valueOf(zzbVarZzt.zzi()));
                        x(sbR, 2, "r_extensions_too_old", Boolean.valueOf(zzbVarZzt.zzj()));
                        x(sbR, 2, "adservices_extension_too_old", Boolean.valueOf(zzbVarZzt.zze()));
                        x(sbR, 2, "ad_storage_not_allowed", Boolean.valueOf(zzbVarZzt.zzd()));
                        x(sbR, 2, "measurement_manager_disabled", Boolean.valueOf(zzbVarZzt.zzg()));
                        u(sbR, 2);
                        sbR.append("}\n");
                    }
                }
                List<zzft.zzn> listZzaq = zzjVar.zzaq();
                if (listZzaq != null) {
                    for (zzft.zzn zznVar : listZzaq) {
                        if (zznVar != null) {
                            u(sbR, 2);
                            sbR.append("user_property {\n");
                            x(sbR, 2, "set_timestamp_millis", zznVar.zzl() ? Long.valueOf(zznVar.zzd()) : null);
                            x(sbR, 2, MediationMetaData.KEY_NAME, zzi().zzc(zznVar.zzg()));
                            x(sbR, 2, "string_value", zznVar.zzh());
                            x(sbR, 2, "int_value", zznVar.zzk() ? Long.valueOf(zznVar.zzc()) : null);
                            x(sbR, 2, "double_value", zznVar.zzi() ? Double.valueOf(zznVar.zza()) : null);
                            u(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                List<zzft.zzc> listZzao = zzjVar.zzao();
                zzjVar.zzx();
                if (listZzao != null) {
                    for (zzft.zzc zzcVar : listZzao) {
                        if (zzcVar != null) {
                            u(sbR, 2);
                            sbR.append("audience_membership {\n");
                            if (zzcVar.zzg()) {
                                x(sbR, 2, "audience_id", Integer.valueOf(zzcVar.zza()));
                            }
                            if (zzcVar.zzh()) {
                                x(sbR, 2, "new_audience", Boolean.valueOf(zzcVar.zzf()));
                            }
                            z(sbR, "current_data", zzcVar.zzd());
                            if (zzcVar.zzi()) {
                                z(sbR, "previous_data", zzcVar.zze());
                            }
                            u(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                List<zzft.zze> listZzap = zzjVar.zzap();
                if (listZzap != null) {
                    for (zzft.zze zzeVar : listZzap) {
                        if (zzeVar != null) {
                            u(sbR, 2);
                            sbR.append("event {\n");
                            x(sbR, 2, MediationMetaData.KEY_NAME, zzi().zza(zzeVar.zzg()));
                            if (zzeVar.zzk()) {
                                x(sbR, 2, "timestamp_millis", Long.valueOf(zzeVar.zzd()));
                            }
                            if (zzeVar.zzj()) {
                                x(sbR, 2, "previous_timestamp_millis", Long.valueOf(zzeVar.zzc()));
                            }
                            if (zzeVar.zzi()) {
                                x(sbR, 2, "count", Integer.valueOf(zzeVar.zza()));
                            }
                            if (zzeVar.zzb() != 0) {
                                y(sbR, 2, zzeVar.zzh());
                            }
                            u(sbR, 2);
                            sbR.append("}\n");
                        }
                    }
                }
                u(sbR, 1);
                sbR.append("}\n");
            }
        }
        sbR.append("}\n");
        return sbR.toString();
    }

    public final List<Long> p(List<Long> list, List<Integer> list2) throws IllegalStateException {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().zzu().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    zzj().zzu().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    public final void t(zzft.zzg.zza zzaVar, Object obj) throws IllegalStateException {
        Preconditions.checkNotNull(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            zzj().zzg().zza("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                zzft.zzg.zza zzaVarZze = zzft.zzg.zze();
                for (String str : bundle.keySet()) {
                    zzft.zzg.zza zzaVarZza = zzft.zzg.zze().zza(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzaVarZza.zza(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzaVarZza.zzb((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzaVarZza.zza(((Double) obj2).doubleValue());
                    }
                    zzaVarZze.zza(zzaVarZza);
                }
                if (zzaVarZze.zza() > 0) {
                    arrayList.add((zzft.zzg) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZze.zzah()));
                }
            }
        }
        zzaVar.zza(arrayList);
    }

    public final void v(StringBuilder sb2, int i10, zzfh.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        u(sb2, i10);
        sb2.append("filter {\n");
        if (zzcVar.zzg()) {
            x(sb2, i10, "complement", Boolean.valueOf(zzcVar.zzf()));
        }
        if (zzcVar.zzi()) {
            x(sb2, i10, "param_name", zzi().zzb(zzcVar.zze()));
        }
        if (zzcVar.zzj()) {
            int i11 = i10 + 1;
            zzfh.zzf zzfVarZzd = zzcVar.zzd();
            if (zzfVarZzd != null) {
                u(sb2, i11);
                sb2.append("string_filter");
                sb2.append(" {\n");
                if (zzfVarZzd.zzj()) {
                    x(sb2, i11, "match_type", zzfVarZzd.zzb().name());
                }
                if (zzfVarZzd.zzi()) {
                    x(sb2, i11, "expression", zzfVarZzd.zze());
                }
                if (zzfVarZzd.zzh()) {
                    x(sb2, i11, "case_sensitive", Boolean.valueOf(zzfVarZzd.zzg()));
                }
                if (zzfVarZzd.zza() > 0) {
                    u(sb2, i11 + 1);
                    sb2.append("expression_list {\n");
                    for (String str : zzfVarZzd.zzf()) {
                        u(sb2, i11 + 2);
                        sb2.append(str);
                        sb2.append(StringUtils.LF);
                    }
                    sb2.append("}\n");
                }
                u(sb2, i11);
                sb2.append("}\n");
            }
        }
        if (zzcVar.zzh()) {
            w(sb2, i10 + 1, "number_filter", zzcVar.zzc());
        }
        u(sb2, i10);
        sb2.append("}\n");
    }

    public final void y(StringBuilder sb2, int i10, List<zzft.zzg> list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        for (zzft.zzg zzgVar : list) {
            if (zzgVar != null) {
                u(sb2, i11);
                sb2.append("param {\n");
                x(sb2, i11, MediationMetaData.KEY_NAME, zzgVar.zzm() ? zzi().zzb(zzgVar.zzg()) : null);
                x(sb2, i11, "string_value", zzgVar.zzn() ? zzgVar.zzh() : null);
                x(sb2, i11, "int_value", zzgVar.zzl() ? Long.valueOf(zzgVar.zzd()) : null);
                x(sb2, i11, "double_value", zzgVar.zzj() ? Double.valueOf(zzgVar.zza()) : null);
                if (zzgVar.zzc() > 0) {
                    y(sb2, i11, zzgVar.zzi());
                }
                u(sb2, i11);
                sb2.append("}\n");
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final boolean zzc() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznb zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public static Bundle zza(List<zzft.zzg> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzg zzgVar : list) {
            String strZzg = zzgVar.zzg();
            if (zzgVar.zzj()) {
                bundle.putDouble(strZzg, zzgVar.zza());
            } else if (zzgVar.zzk()) {
                bundle.putFloat(strZzg, zzgVar.zzb());
            } else if (zzgVar.zzn()) {
                bundle.putString(strZzg, zzgVar.zzh());
            } else if (zzgVar.zzl()) {
                bundle.putLong(strZzg, zzgVar.zzd());
            }
        }
        return bundle;
    }
}
