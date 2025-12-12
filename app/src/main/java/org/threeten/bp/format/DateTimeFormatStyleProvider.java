package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.chrono.Chronology;

/* loaded from: classes2.dex */
abstract class DateTimeFormatStyleProvider {
    public static DateTimeFormatStyleProvider getInstance() {
        return new SimpleDateTimeFormatStyleProvider();
    }

    public Locale[] getAvailableLocales() {
        throw new UnsupportedOperationException();
    }

    public abstract DateTimeFormatter getFormatter(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale);
}
