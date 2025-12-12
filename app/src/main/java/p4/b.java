package p4;

import p4.a;

/* compiled from: AutoValue_AndroidClientInfo.java */
/* loaded from: classes.dex */
public final class b extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f17544a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17545b;

    /* renamed from: c, reason: collision with root package name */
    public final String f17546c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17547d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17548e;

    /* renamed from: f, reason: collision with root package name */
    public final String f17549f;

    /* renamed from: g, reason: collision with root package name */
    public final String f17550g;

    /* renamed from: h, reason: collision with root package name */
    public final String f17551h;

    /* renamed from: i, reason: collision with root package name */
    public final String f17552i;

    /* renamed from: j, reason: collision with root package name */
    public final String f17553j;

    /* renamed from: k, reason: collision with root package name */
    public final String f17554k;

    /* renamed from: l, reason: collision with root package name */
    public final String f17555l;

    /* compiled from: AutoValue_AndroidClientInfo.java */
    public static final class a extends a.AbstractC0222a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f17556a;

        /* renamed from: b, reason: collision with root package name */
        public String f17557b;

        /* renamed from: c, reason: collision with root package name */
        public String f17558c;

        /* renamed from: d, reason: collision with root package name */
        public String f17559d;

        /* renamed from: e, reason: collision with root package name */
        public String f17560e;

        /* renamed from: f, reason: collision with root package name */
        public String f17561f;

        /* renamed from: g, reason: collision with root package name */
        public String f17562g;

        /* renamed from: h, reason: collision with root package name */
        public String f17563h;

        /* renamed from: i, reason: collision with root package name */
        public String f17564i;

        /* renamed from: j, reason: collision with root package name */
        public String f17565j;

        /* renamed from: k, reason: collision with root package name */
        public String f17566k;

        /* renamed from: l, reason: collision with root package name */
        public String f17567l;

        @Override // p4.a.AbstractC0222a
        public p4.a build() {
            return new b(this.f17556a, this.f17557b, this.f17558c, this.f17559d, this.f17560e, this.f17561f, this.f17562g, this.f17563h, this.f17564i, this.f17565j, this.f17566k, this.f17567l);
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setApplicationBuild(String str) {
            this.f17567l = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setCountry(String str) {
            this.f17565j = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setDevice(String str) {
            this.f17559d = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setFingerprint(String str) {
            this.f17563h = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setHardware(String str) {
            this.f17558c = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setLocale(String str) {
            this.f17564i = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setManufacturer(String str) {
            this.f17562g = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setMccMnc(String str) {
            this.f17566k = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setModel(String str) {
            this.f17557b = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setOsBuild(String str) {
            this.f17561f = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setProduct(String str) {
            this.f17560e = str;
            return this;
        }

        @Override // p4.a.AbstractC0222a
        public a.AbstractC0222a setSdkVersion(Integer num) {
            this.f17556a = num;
            return this;
        }
    }

    public b(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f17544a = num;
        this.f17545b = str;
        this.f17546c = str2;
        this.f17547d = str3;
        this.f17548e = str4;
        this.f17549f = str5;
        this.f17550g = str6;
        this.f17551h = str7;
        this.f17552i = str8;
        this.f17553j = str9;
        this.f17554k = str10;
        this.f17555l = str11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p4.a)) {
            return false;
        }
        p4.a aVar = (p4.a) obj;
        Integer num = this.f17544a;
        if (num != null ? num.equals(aVar.getSdkVersion()) : aVar.getSdkVersion() == null) {
            String str = this.f17545b;
            if (str != null ? str.equals(aVar.getModel()) : aVar.getModel() == null) {
                String str2 = this.f17546c;
                if (str2 != null ? str2.equals(aVar.getHardware()) : aVar.getHardware() == null) {
                    String str3 = this.f17547d;
                    if (str3 != null ? str3.equals(aVar.getDevice()) : aVar.getDevice() == null) {
                        String str4 = this.f17548e;
                        if (str4 != null ? str4.equals(aVar.getProduct()) : aVar.getProduct() == null) {
                            String str5 = this.f17549f;
                            if (str5 != null ? str5.equals(aVar.getOsBuild()) : aVar.getOsBuild() == null) {
                                String str6 = this.f17550g;
                                if (str6 != null ? str6.equals(aVar.getManufacturer()) : aVar.getManufacturer() == null) {
                                    String str7 = this.f17551h;
                                    if (str7 != null ? str7.equals(aVar.getFingerprint()) : aVar.getFingerprint() == null) {
                                        String str8 = this.f17552i;
                                        if (str8 != null ? str8.equals(aVar.getLocale()) : aVar.getLocale() == null) {
                                            String str9 = this.f17553j;
                                            if (str9 != null ? str9.equals(aVar.getCountry()) : aVar.getCountry() == null) {
                                                String str10 = this.f17554k;
                                                if (str10 != null ? str10.equals(aVar.getMccMnc()) : aVar.getMccMnc() == null) {
                                                    String str11 = this.f17555l;
                                                    if (str11 == null) {
                                                        if (aVar.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(aVar.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // p4.a
    public String getApplicationBuild() {
        return this.f17555l;
    }

    @Override // p4.a
    public String getCountry() {
        return this.f17553j;
    }

    @Override // p4.a
    public String getDevice() {
        return this.f17547d;
    }

    @Override // p4.a
    public String getFingerprint() {
        return this.f17551h;
    }

    @Override // p4.a
    public String getHardware() {
        return this.f17546c;
    }

    @Override // p4.a
    public String getLocale() {
        return this.f17552i;
    }

    @Override // p4.a
    public String getManufacturer() {
        return this.f17550g;
    }

    @Override // p4.a
    public String getMccMnc() {
        return this.f17554k;
    }

    @Override // p4.a
    public String getModel() {
        return this.f17545b;
    }

    @Override // p4.a
    public String getOsBuild() {
        return this.f17549f;
    }

    @Override // p4.a
    public String getProduct() {
        return this.f17548e;
    }

    @Override // p4.a
    public Integer getSdkVersion() {
        return this.f17544a;
    }

    public int hashCode() {
        Integer num = this.f17544a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f17545b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f17546c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f17547d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f17548e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f17549f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f17550g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f17551h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f17552i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f17553j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f17554k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f17555l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb2.append(this.f17544a);
        sb2.append(", model=");
        sb2.append(this.f17545b);
        sb2.append(", hardware=");
        sb2.append(this.f17546c);
        sb2.append(", device=");
        sb2.append(this.f17547d);
        sb2.append(", product=");
        sb2.append(this.f17548e);
        sb2.append(", osBuild=");
        sb2.append(this.f17549f);
        sb2.append(", manufacturer=");
        sb2.append(this.f17550g);
        sb2.append(", fingerprint=");
        sb2.append(this.f17551h);
        sb2.append(", locale=");
        sb2.append(this.f17552i);
        sb2.append(", country=");
        sb2.append(this.f17553j);
        sb2.append(", mccMnc=");
        sb2.append(this.f17554k);
        sb2.append(", applicationBuild=");
        return ac.c.o(sb2, this.f17555l, "}");
    }
}
