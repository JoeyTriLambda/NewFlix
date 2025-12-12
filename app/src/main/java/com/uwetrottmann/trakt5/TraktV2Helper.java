package com.uwetrottmann.trakt5;

import com.google.gson.JsonParseException;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.u;
import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.ProgressLastActivity;
import com.uwetrottmann.trakt5.enums.Rating;
import com.uwetrottmann.trakt5.enums.Resolution;
import com.uwetrottmann.trakt5.enums.Status;
import java.lang.reflect.Type;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

/* loaded from: classes2.dex */
public class TraktV2Helper {
    public static j getGsonBuilder() {
        j jVar = new j();
        final int i10 = 0;
        jVar.registerTypeAdapter(OffsetDateTime.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i10) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        final int i11 = 3;
        jVar.registerTypeAdapter(OffsetDateTime.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i11) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        final int i12 = 5;
        jVar.registerTypeAdapter(LocalDate.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i12) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        final int i13 = 6;
        jVar.registerTypeAdapter(Rating.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i13) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        final int i14 = 4;
        jVar.registerTypeAdapter(Rating.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i14) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        final int i15 = 7;
        jVar.registerTypeAdapter(Status.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i15) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        final int i16 = 8;
        jVar.registerTypeAdapter(ProgressLastActivity.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i16) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        jVar.registerTypeAdapter(MediaType.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i12) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        final int i17 = 9;
        jVar.registerTypeAdapter(MediaType.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i17) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        jVar.registerTypeAdapter(Resolution.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i13) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        final int i18 = 1;
        jVar.registerTypeAdapter(Resolution.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i18) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        jVar.registerTypeAdapter(Hdr.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i10) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        final int i19 = 2;
        jVar.registerTypeAdapter(Hdr.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i19) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        jVar.registerTypeAdapter(Audio.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i18) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        jVar.registerTypeAdapter(Audio.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i11) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        jVar.registerTypeAdapter(AudioChannels.class, new u() { // from class: com.uwetrottmann.trakt5.b
            @Override // com.google.gson.u
            public final o serialize(Object obj, Type type, t tVar) {
                switch (i19) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$11((Hdr) obj, type, tVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$13((Audio) obj, type, tVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$15((AudioChannels) obj, type, tVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$1((OffsetDateTime) obj, type, tVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$4((Rating) obj, type, tVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$7((MediaType) obj, type, tVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$9((Resolution) obj, type, tVar);
                }
            }
        });
        jVar.registerTypeAdapter(AudioChannels.class, new n() { // from class: com.uwetrottmann.trakt5.a
            @Override // com.google.gson.n
            public final Object deserialize(o oVar, Type type, m mVar) {
                switch (i14) {
                    case 0:
                        return TraktV2Helper.lambda$getGsonBuilder$0(oVar, type, mVar);
                    case 1:
                        return TraktV2Helper.lambda$getGsonBuilder$10(oVar, type, mVar);
                    case 2:
                        return TraktV2Helper.lambda$getGsonBuilder$12(oVar, type, mVar);
                    case 3:
                        return TraktV2Helper.lambda$getGsonBuilder$14(oVar, type, mVar);
                    case 4:
                        return TraktV2Helper.lambda$getGsonBuilder$16(oVar, type, mVar);
                    case 5:
                        return TraktV2Helper.lambda$getGsonBuilder$2(oVar, type, mVar);
                    case 6:
                        return TraktV2Helper.lambda$getGsonBuilder$3(oVar, type, mVar);
                    case 7:
                        return TraktV2Helper.lambda$getGsonBuilder$5(oVar, type, mVar);
                    case 8:
                        return TraktV2Helper.lambda$getGsonBuilder$6(oVar, type, mVar);
                    default:
                        return TraktV2Helper.lambda$getGsonBuilder$8(oVar, type, mVar);
                }
            }
        });
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ OffsetDateTime lambda$getGsonBuilder$0(o oVar, Type type, m mVar) throws JsonParseException {
        return OffsetDateTime.parse(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$1(OffsetDateTime offsetDateTime, Type type, t tVar) {
        return new s(offsetDateTime.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Resolution lambda$getGsonBuilder$10(o oVar, Type type, m mVar) throws JsonParseException {
        return Resolution.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$11(Hdr hdr, Type type, t tVar) {
        return new s(hdr.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Hdr lambda$getGsonBuilder$12(o oVar, Type type, m mVar) throws JsonParseException {
        return Hdr.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$13(Audio audio, Type type, t tVar) {
        return new s(audio.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Audio lambda$getGsonBuilder$14(o oVar, Type type, m mVar) throws JsonParseException {
        return Audio.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$15(AudioChannels audioChannels, Type type, t tVar) {
        return new s(audioChannels.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioChannels lambda$getGsonBuilder$16(o oVar, Type type, m mVar) throws JsonParseException {
        return AudioChannels.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LocalDate lambda$getGsonBuilder$2(o oVar, Type type, m mVar) throws JsonParseException {
        return LocalDate.parse(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Rating lambda$getGsonBuilder$3(o oVar, Type type, m mVar) throws JsonParseException {
        return Rating.fromValue(oVar.getAsInt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$4(Rating rating, Type type, t tVar) {
        return new s(Integer.valueOf(rating.value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Status lambda$getGsonBuilder$5(o oVar, Type type, m mVar) throws JsonParseException {
        return Status.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ProgressLastActivity lambda$getGsonBuilder$6(o oVar, Type type, m mVar) throws JsonParseException {
        return ProgressLastActivity.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$7(MediaType mediaType, Type type, t tVar) {
        return new s(mediaType.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MediaType lambda$getGsonBuilder$8(o oVar, Type type, m mVar) throws JsonParseException {
        return MediaType.fromValue(oVar.getAsString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o lambda$getGsonBuilder$9(Resolution resolution, Type type, t tVar) {
        return new s(resolution.toString());
    }
}
