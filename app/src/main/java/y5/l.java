package y5;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import g5.l;
import g5.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.r;

/* compiled from: WebvttExtractor.java */
/* loaded from: classes.dex */
public final class l implements g5.e {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f21997g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f21998h = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f21999a;

    /* renamed from: b, reason: collision with root package name */
    public final r f22000b;

    /* renamed from: d, reason: collision with root package name */
    public g5.g f22002d;

    /* renamed from: f, reason: collision with root package name */
    public int f22004f;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f22001c = new l6.l();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f22003e = new byte[1024];

    public l(String str, r rVar) {
        this.f21999a = str;
        this.f22000b = rVar;
    }

    public final m a(long j10) {
        m mVarTrack = this.f22002d.track(0, 3);
        mVarTrack.format(c5.i.createTextSampleFormat((String) null, "text/vtt", (String) null, -1, 0, this.f21999a, (com.google.android.exoplayer2.drm.c) null, j10));
        this.f22002d.endTracks();
        return mVarTrack;
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f22002d = gVar;
        gVar.seekMap(new l.a(-9223372036854775807L));
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException, NumberFormatException {
        g5.b bVar = (g5.b) fVar;
        int length = (int) bVar.getLength();
        int i10 = this.f22004f;
        byte[] bArr = this.f22003e;
        if (i10 == bArr.length) {
            this.f22003e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f22003e;
        int i11 = this.f22004f;
        int i12 = bVar.read(bArr2, i11, bArr2.length - i11);
        if (i12 != -1) {
            int i13 = this.f22004f + i12;
            this.f22004f = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        l6.l lVar = new l6.l(this.f22003e);
        try {
            i6.h.validateWebvttHeaderLine(lVar);
            long jPtsToUs = 0;
            long timestampUs = 0;
            while (true) {
                String line = lVar.readLine();
                if (TextUtils.isEmpty(line)) {
                    Matcher matcherFindNextCueHeader = i6.h.findNextCueHeader(lVar);
                    if (matcherFindNextCueHeader == null) {
                        a(0L);
                    } else {
                        long timestampUs2 = i6.h.parseTimestampUs(matcherFindNextCueHeader.group(1));
                        long jAdjustTsTimestamp = this.f22000b.adjustTsTimestamp(r.usToPts((jPtsToUs + timestampUs2) - timestampUs));
                        m mVarA = a(jAdjustTsTimestamp - timestampUs2);
                        byte[] bArr3 = this.f22003e;
                        int i14 = this.f22004f;
                        l6.l lVar2 = this.f22001c;
                        lVar2.reset(bArr3, i14);
                        mVarA.sampleData(lVar2, this.f22004f);
                        mVarA.sampleMetadata(jAdjustTsTimestamp, 1, this.f22004f, 0, null);
                    }
                    return -1;
                }
                if (line.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = f21997g.matcher(line);
                    if (!matcher.find()) {
                        throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(line));
                    }
                    Matcher matcher2 = f21998h.matcher(line);
                    if (!matcher2.find()) {
                        throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(line));
                    }
                    timestampUs = i6.h.parseTimestampUs(matcher.group(1));
                    jPtsToUs = r.ptsToUs(Long.parseLong(matcher2.group(1)));
                }
            }
        } catch (SubtitleDecoderException e10) {
            throw new ParserException(e10);
        }
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        throw new IllegalStateException();
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        throw new IllegalStateException();
    }

    @Override // g5.e
    public void release() {
    }
}
