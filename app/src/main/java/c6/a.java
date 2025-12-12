package c6;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import b6.h;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import l6.l;

/* compiled from: Cea608Decoder.java */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f5167r = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f5168s = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f5169t = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f5170u = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f5171v = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f5172w = {193, HttpStatus.SC_CREATED, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, HttpStatus.SC_ACCEPTED, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 235, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, 171, 187};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f5173x = {195, 227, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_NO_CONTENT, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: g, reason: collision with root package name */
    public final int f5175g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5176h;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f5179k;

    /* renamed from: l, reason: collision with root package name */
    public List<b6.a> f5180l;

    /* renamed from: m, reason: collision with root package name */
    public int f5181m;

    /* renamed from: n, reason: collision with root package name */
    public int f5182n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5183o;

    /* renamed from: p, reason: collision with root package name */
    public byte f5184p;

    /* renamed from: q, reason: collision with root package name */
    public byte f5185q;

    /* renamed from: f, reason: collision with root package name */
    public final l f5174f = new l();

    /* renamed from: i, reason: collision with root package name */
    public final LinkedList<C0061a> f5177i = new LinkedList<>();

    /* renamed from: j, reason: collision with root package name */
    public C0061a f5178j = new C0061a(0, 4);

    /* compiled from: Cea608Decoder.java */
    /* renamed from: c6.a$a, reason: collision with other inner class name */
    public static class C0061a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f5186a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f5187b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final LinkedList f5188c = new LinkedList();

        /* renamed from: d, reason: collision with root package name */
        public final SpannableStringBuilder f5189d = new SpannableStringBuilder();

        /* renamed from: e, reason: collision with root package name */
        public int f5190e;

        /* renamed from: f, reason: collision with root package name */
        public int f5191f;

        /* renamed from: g, reason: collision with root package name */
        public int f5192g;

        /* renamed from: h, reason: collision with root package name */
        public int f5193h;

        /* renamed from: i, reason: collision with root package name */
        public int f5194i;

        /* renamed from: j, reason: collision with root package name */
        public int f5195j;

        /* compiled from: Cea608Decoder.java */
        /* renamed from: c6.a$a$a, reason: collision with other inner class name */
        public static class C0062a {

            /* renamed from: a, reason: collision with root package name */
            public final CharacterStyle f5196a;

            /* renamed from: b, reason: collision with root package name */
            public final int f5197b;

            /* renamed from: c, reason: collision with root package name */
            public final int f5198c;

            public C0062a(CharacterStyle characterStyle, int i10, int i11) {
                this.f5196a = characterStyle;
                this.f5197b = i10;
                this.f5198c = i11;
            }
        }

        public C0061a(int i10, int i11) {
            reset(i10, i11);
        }

        public void append(char c10) {
            this.f5189d.append(c10);
        }

        public void backspace() {
            SpannableStringBuilder spannableStringBuilder = this.f5189d;
            int length = spannableStringBuilder.length();
            if (length > 0) {
                spannableStringBuilder.delete(length - 1, length);
            }
        }

        public b6.a build() {
            float f10;
            int i10;
            int i11;
            int i12;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i13 = 0;
            while (true) {
                LinkedList linkedList = this.f5188c;
                if (i13 >= linkedList.size()) {
                    break;
                }
                spannableStringBuilder.append((CharSequence) linkedList.get(i13));
                spannableStringBuilder.append('\n');
                i13++;
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i14 = this.f5191f + this.f5192g;
            int length = i14 - ((32 - i14) - spannableStringBuilder.length());
            if (this.f5193h == 2 && Math.abs(length) < 3) {
                f10 = 0.5f;
                i10 = 1;
            } else if (this.f5193h != 2 || length <= 0) {
                f10 = ((i14 / 32.0f) * 0.8f) + 0.1f;
                i10 = 0;
            } else {
                f10 = (((32 - r3) / 32.0f) * 0.8f) + 0.1f;
                i10 = 2;
            }
            if (this.f5193h == 1 || (i11 = this.f5190e) > 7) {
                i11 = (this.f5190e - 15) - 2;
                i12 = 2;
            } else {
                i12 = 0;
            }
            return new b6.a(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i11, 1, i12, f10, i10, Float.MIN_VALUE);
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = this.f5189d;
            int length = spannableStringBuilder.length();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                ArrayList arrayList = this.f5186a;
                if (i11 >= arrayList.size()) {
                    break;
                }
                spannableStringBuilder.setSpan(arrayList.get(i11), 0, length, 33);
                i11++;
            }
            while (true) {
                ArrayList arrayList2 = this.f5187b;
                if (i10 >= arrayList2.size()) {
                    break;
                }
                C0062a c0062a = (C0062a) arrayList2.get(i10);
                int size = arrayList2.size();
                int i12 = c0062a.f5198c;
                spannableStringBuilder.setSpan(c0062a.f5196a, c0062a.f5197b, i10 < size - i12 ? ((C0062a) arrayList2.get(i12 + i10)).f5197b : length, 33);
                i10++;
            }
            if (this.f5195j != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f5195j, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public int getRow() {
            return this.f5190e;
        }

        public boolean isEmpty() {
            return this.f5186a.isEmpty() && this.f5187b.isEmpty() && this.f5188c.isEmpty() && this.f5189d.length() == 0;
        }

        public void reset(int i10, int i11) {
            this.f5186a.clear();
            this.f5187b.clear();
            this.f5188c.clear();
            this.f5189d.clear();
            this.f5190e = 15;
            this.f5191f = 0;
            this.f5192g = 0;
            this.f5193h = i10;
            this.f5194i = i11;
            this.f5195j = -1;
        }

        public void rollUp() {
            LinkedList linkedList = this.f5188c;
            linkedList.add(buildSpannableString());
            this.f5189d.clear();
            this.f5186a.clear();
            this.f5187b.clear();
            this.f5195j = -1;
            int iMin = Math.min(this.f5194i, this.f5190e);
            while (linkedList.size() >= iMin) {
                linkedList.remove(0);
            }
        }

        public void setIndent(int i10) {
            this.f5191f = i10;
        }

        public void setMidrowStyle(CharacterStyle characterStyle, int i10) {
            this.f5187b.add(new C0062a(characterStyle, this.f5189d.length(), i10));
        }

        public void setPreambleStyle(CharacterStyle characterStyle) {
            this.f5186a.add(characterStyle);
        }

        public void setRow(int i10) {
            this.f5190e = i10;
        }

        public void setTab(int i10) {
            this.f5192g = i10;
        }

        public void setUnderline(boolean z10) {
            SpannableStringBuilder spannableStringBuilder = this.f5189d;
            if (z10) {
                this.f5195j = spannableStringBuilder.length();
            } else if (this.f5195j != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f5195j, spannableStringBuilder.length(), 33);
                this.f5195j = -1;
            }
        }

        public String toString() {
            return this.f5189d.toString();
        }
    }

    public a(String str, int i10) {
        this.f5175g = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i10 == 3 || i10 == 4) {
            this.f5176h = 2;
        } else {
            this.f5176h = 1;
        }
        c(0);
        b();
    }

    public final List<b6.a> a() {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            LinkedList<C0061a> linkedList = this.f5177i;
            if (i10 >= linkedList.size()) {
                return arrayList;
            }
            b6.a aVarBuild = linkedList.get(i10).build();
            if (aVarBuild != null) {
                arrayList.add(aVarBuild);
            }
            i10++;
        }
    }

    public final void b() {
        this.f5178j.reset(this.f5181m, this.f5182n);
        LinkedList<C0061a> linkedList = this.f5177i;
        linkedList.clear();
        linkedList.add(this.f5178j);
    }

    public final void c(int i10) {
        int i11 = this.f5181m;
        if (i11 == i10) {
            return;
        }
        this.f5181m = i10;
        b();
        if (i11 == 3 || i10 == 1 || i10 == 0) {
            this.f5179k = null;
        }
    }

    @Override // c6.d
    public b6.d createSubtitle() {
        ArrayList arrayList = this.f5179k;
        this.f5180l = arrayList;
        return new f(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0109  */
    @Override // c6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(b6.g r17) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.a.decode(b6.g):void");
    }

    @Override // c6.d, e5.c
    public /* bridge */ /* synthetic */ b6.g dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // c6.d, e5.c
    public /* bridge */ /* synthetic */ h dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // c6.d, e5.c
    public void flush() {
        super.flush();
        this.f5179k = null;
        this.f5180l = null;
        c(0);
        b();
        this.f5182n = 4;
        this.f5183o = false;
        this.f5184p = (byte) 0;
        this.f5185q = (byte) 0;
    }

    @Override // c6.d
    public boolean isNewSubtitleDataAvailable() {
        return this.f5179k != this.f5180l;
    }

    @Override // c6.d
    public /* bridge */ /* synthetic */ void queueInputBuffer(b6.g gVar) throws SubtitleDecoderException {
        super.queueInputBuffer(gVar);
    }

    @Override // c6.d, b6.e
    public /* bridge */ /* synthetic */ void setPositionUs(long j10) {
        super.setPositionUs(j10);
    }

    @Override // c6.d, e5.c
    public void release() {
    }
}
